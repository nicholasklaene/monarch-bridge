package com.nicholasklaene.monarchbridge.graphql

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.junit5.WireMockExtension
import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.MonarchProperties
import com.nicholasklaene.monarchbridge.exceptions.MonarchRateLimitedException
import com.nicholasklaene.monarchbridge.exceptions.MonarchRequestFailedException
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionExpiredException
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.exceptions.PayloadErrorException
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetAccounts
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import java.time.Instant
import com.nicholasklaene.monarchbridge.auth.MonarchSession as MonarchSessionData

@Suppress("LargeClass")
class MonarchClientTest {
    companion object {
        @JvmField
        @RegisterExtension
        val wiremock: WireMockExtension = WireMockExtension.newInstance().build()

        private const val GRAPHQL_PATH = "/graphql"
        private const val FAKE_TOKEN = "fake-session-token-abc123"

        private fun makeMapper(): ObjectMapper = ObjectMapper().registerKotlinModule().also { it.findAndRegisterModules() }
    }

    private lateinit var client: MonarchClient
    private lateinit var sessionService: MonarchSessionService

    @BeforeEach
    fun setUp() {
        val baseUrl = wiremock.baseUrl()
        val props =
            MonarchProperties(
                baseUrl = baseUrl,
                sessionPath = "/tmp/test-monarch-session-${System.nanoTime()}.json",
            )
        sessionService = MonarchSessionService(props, makeMapper())
        sessionService.save(
            MonarchSessionData(token = FAKE_TOKEN, email = "test@example.com", lastVerifiedAt = Instant.now()),
        )
        client = WireMockMonarchClient(props, sessionService, makeMapper())
    }

    // -------------------------------------------------------------------------------------
    // Successful response
    // -------------------------------------------------------------------------------------

    @Test
    fun `200 with data field returns the data JsonNode`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"data":{"accounts":[{"id":"acc1"}]}}"""),
                ),
        )

        val result = client.executeGraphQL("GetAccounts", GetAccounts.query, emptyMap())

        assertThat(result.path("accounts").size()).isEqualTo(1)
        assertThat(result.path("accounts")[0].path("id").asText()).isEqualTo("acc1")
    }

    // -------------------------------------------------------------------------------------
    // GraphQL-level errors
    // -------------------------------------------------------------------------------------

    @Test
    fun `200 with GraphQL errors array throws MonarchRequestFailedException`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"errors":[{"message":"Not found"}]}"""),
                ),
        )

        assertThatThrownBy { client.executeGraphQL("GetAccounts", GetAccounts.query, emptyMap()) }
            .isInstanceOf(MonarchRequestFailedException::class.java)
            .hasMessageContaining("GraphQL errors")
    }

    // -------------------------------------------------------------------------------------
    // HTTP error codes
    // -------------------------------------------------------------------------------------

    @Test
    fun `401 throws MonarchSessionExpiredException`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(aResponse().withStatus(401).withBody("Unauthorized")),
        )

        assertThatThrownBy { client.executeGraphQL("GetAccounts", GetAccounts.query, emptyMap()) }
            .isInstanceOf(MonarchSessionExpiredException::class.java)
    }

    @Test
    fun `429 with Retry-After header throws MonarchRateLimitedException with retryAfterSeconds`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(429)
                        .withHeader("Retry-After", "60")
                        .withBody("Rate limited"),
                ),
        )

        var caughtEx: Throwable? = null
        try {
            client.executeGraphQL("GetAccounts", GetAccounts.query, emptyMap())
        } catch (ex: MonarchRateLimitedException) {
            caughtEx = ex
        }
        assertThat(caughtEx).isInstanceOf(MonarchRateLimitedException::class.java)
        assertThat((caughtEx as MonarchRateLimitedException).retryAfterSeconds).isEqualTo(60L)
    }

    @Test
    fun `500 throws MonarchRequestFailedException with status 500`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(aResponse().withStatus(500).withBody("Internal Server Error")),
        )

        var caughtEx: Throwable? = null
        try {
            client.executeGraphQL("GetAccounts", GetAccounts.query, emptyMap())
        } catch (ex: MonarchRequestFailedException) {
            caughtEx = ex
        }
        assertThat(caughtEx).isInstanceOf(MonarchRequestFailedException::class.java)
        assertThat((caughtEx as MonarchRequestFailedException).status).isEqualTo(500)
    }

    // -------------------------------------------------------------------------------------
    // Header verification
    // -------------------------------------------------------------------------------------

    @Test
    fun `Authorization Token header is attached and no X-CSRFToken header`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"data":{}}"""),
                ),
        )

        client.executeGraphQL("GetAccounts", GetAccounts.query, emptyMap())

        wiremock.verify(
            postRequestedFor(urlEqualTo(GRAPHQL_PATH))
                .withHeader("Authorization", equalTo("Token $FAKE_TOKEN"))
                .withoutHeader("X-CSRFToken"),
        )
    }

    @Test
    fun `executeGraphQL POSTs correct JSON body shape`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"data":{}}"""),
                ),
        )

        client.executeGraphQL("GetAccounts", GetAccounts.query, emptyMap())

        wiremock.verify(
            postRequestedFor(urlEqualTo(GRAPHQL_PATH))
                .withRequestBody(matchingJsonPath("$.operationName", equalTo("GetAccounts")))
                .withRequestBody(matchingJsonPath("$.query"))
                // $.variables is always present; emptyMap() serialises to {} which WireMock
                // considers a falsy path value, so use a JSONPath existence filter instead.
                .withRequestBody(matchingJsonPath("$[?(@.variables != null)]")),
        )
    }

    // -------------------------------------------------------------------------------------
    // Session-missing guard
    // -------------------------------------------------------------------------------------

    @Test
    fun `missing session throws MonarchSessionMissingException`() {
        val props =
            MonarchProperties(
                baseUrl = wiremock.baseUrl(),
                sessionPath = "/tmp/no-such-session-${System.nanoTime()}.json",
            )
        val emptySession = MonarchSessionService(props, makeMapper())
        // Don't save anything — holder stays null
        val clientNoSession = WireMockMonarchClient(props, emptySession, makeMapper())

        assertThatThrownBy { clientNoSession.executeGraphQL("GetAccounts", GetAccounts.query, emptyMap()) }
            .isInstanceOf(MonarchSessionMissingException::class.java)
    }

    // -------------------------------------------------------------------------------------
    // Typed execute() path (covers PayloadError detection + parseOutput round-trip)
    // -------------------------------------------------------------------------------------

    @Test
    fun `typed execute returns parsed Output on success`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"data":{"accounts":[{"id":"acc-1","displayName":"Test"}]}}"""),
                ),
        )

        val result = client.execute(GetAccounts, Unit)

        assertThat(result.accounts).hasSize(1)
        assertThat(result.accounts[0].id).isEqualTo("acc-1")
    }

    @Test
    fun `typed execute throws PayloadErrorException when mutation reports application errors`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(
                            """{"data":{"createTransaction":{"errors":[{"message":"Account not found","code":"not_found"}]}}}""",
                        ),
                ),
        )

        assertThatThrownBy { client.execute(GetAccounts, Unit) }
            .isInstanceOf(PayloadErrorException::class.java)
            .hasMessageContaining("createTransaction")
    }

    @Test
    fun `typed execute ignores errors arrays on non-object data children`() {
        // Lists at the top level of data shouldn't trigger PayloadError walking.
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"data":{"accounts":[]}}"""),
                ),
        )

        val result = client.execute(GetAccounts, Unit)
        assertThat(result.accounts).isEmpty()
    }

    @Test
    fun `429 without Retry-After header still throws rate-limited`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH)).willReturn(aResponse().withStatus(429)),
        )
        assertThatThrownBy { client.executeGraphQL("GetAccounts", GetAccounts.query, emptyMap()) }
            .isInstanceOf(MonarchRateLimitedException::class.java)
    }

    @Test
    fun `200 with empty errors array does not throw`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"data":{"accounts":[]},"errors":[]}"""),
                ),
        )
        val result = client.executeGraphQL("GetAccounts", GetAccounts.query, emptyMap())
        assertThat(result.path("accounts").isArray).isTrue()
    }

    @Test
    fun `typed execute ignores empty mutation errors array`() {
        wiremock.stubFor(
            post(urlEqualTo(GRAPHQL_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"data":{"createTransaction":{"errors":[]}}}"""),
                ),
        )
        // No throw — empty errors array means success at the application level.
        assertThat(client.execute(GetAccounts, Unit).accounts).isEmpty()
    }

    // -------------------------------------------------------------------------------------
    // SSRF allowlist
    // -------------------------------------------------------------------------------------

    @Test
    fun `SSRF allowlist rejects non-allowed host at construction time`() {
        val props =
            MonarchProperties(
                baseUrl = "https://evil.example.com",
                sessionPath = "/tmp/ssrf-test-${System.nanoTime()}.json",
            )
        val session = MonarchSessionService(props, makeMapper())
        assertThatThrownBy { MonarchClient(props, session, makeMapper()) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("SSRF")
    }

    // -------------------------------------------------------------------------------------
    // Test subclass — bypasses SSRF host pin so WireMock (127.0.0.1) is allowed
    // -------------------------------------------------------------------------------------

    private class WireMockMonarchClient(
        props: MonarchProperties,
        session: MonarchSessionService,
        mapper: ObjectMapper,
    ) : MonarchClient(props, session, mapper) {
        override val allowedHosts: Set<String> get() = setOf("api.monarch.com", "localhost", "127.0.0.1")
        override val allowedUploadHosts: Set<String> get() = setOf("api.cloudinary.com", "localhost", "127.0.0.1")
    }

    // -------------------------------------------------------------------------------------
    // uploadMultipart / uploadToExternal — fast pre-network branches
    //
    // The wire-level paths are exercised by AccountController + TransactionController slice
    // tests against a stub MonarchClient. Here we cover the pre-network guards in isolation:
    // SSRF allowlist + session-missing check, which both throw before any RestClient call.
    // -------------------------------------------------------------------------------------

    @Test
    fun `uploadMultipart throws MonarchSessionMissingException when no session loaded`() {
        val props =
            MonarchProperties(
                baseUrl = wiremock.baseUrl(),
                sessionPath = "/tmp/no-such-session-${System.nanoTime()}.json",
            )
        val emptySession = MonarchSessionService(props, makeMapper())
        val clientNoSession = WireMockMonarchClient(props, emptySession, makeMapper())
        assertThatThrownBy {
            clientNoSession.uploadMultipart(
                "/upload/",
                mapOf("file" to MultipartFilePart("f.txt", "text/plain", "hi".toByteArray())),
            )
        }.isInstanceOf(MonarchSessionMissingException::class.java)
    }

    @Test
    fun `uploadToExternal rejects URL whose host is not allowlisted`() {
        assertThatThrownBy {
            client.uploadToExternal(
                "https://evil.example.com/upload",
                mapOf("file" to MultipartFilePart("f.txt", "text/plain", "hi".toByteArray())),
            )
        }.isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("SSRF protection")
    }
}
