package com.nicholasklaene.monarchbridge.auth

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.junit5.WireMockExtension
import com.nicholasklaene.monarchbridge.config.MonarchProperties
import com.nicholasklaene.monarchbridge.exceptions.MonarchMfaRequiredException
import com.nicholasklaene.monarchbridge.exceptions.MonarchRequestFailedException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

/**
 * WireMock tests for MonarchAuth login flows.
 *
 * Payload shapes match the live Monarch web auth endpoints under api.monarch.com/auth.
 * VERIFY-AT-BOOTSTRAP markers in the code call out assumptions about response shape,
 * MFA-required HTTP code, and success body keys — confirmed at first interactive bootstrap.
 */
class MonarchAuthTest {
    companion object {
        @JvmField
        @RegisterExtension
        val wiremock: WireMockExtension = WireMockExtension.newInstance().build()

        private const val LOGIN_PATH = "/auth/login/"
    }

    private lateinit var auth: MonarchAuth

    @BeforeEach
    fun setUp() {
        val props =
            MonarchProperties(
                baseUrl = wiremock.baseUrl(),
                sessionPath = "/tmp/auth-test-session.json",
            )
        val mapper = ObjectMapper().registerKotlinModule().also { it.findAndRegisterModules() }
        auth = MonarchAuth(props, mapper)
    }

    // -------------------------------------------------------------------------------------
    // Successful login
    // -------------------------------------------------------------------------------------

    @Test
    fun `successful login returns session with token from response`() {
        // VERIFY-AT-BOOTSTRAP: {token, tokenExpiration: null} is the successful login shape
        wiremock.stubFor(
            post(urlEqualTo(LOGIN_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"token":"real-session-token-xyz","tokenExpiration":null}"""),
                ),
        )

        val session = auth.login("test@example.com", "password123")

        assertThat(session.token).isEqualTo("real-session-token-xyz")
        assertThat(session.email).isEqualTo("test@example.com")
        assertThat(session.lastVerifiedAt).isNotNull()
    }

    // -------------------------------------------------------------------------------------
    // MFA required
    // -------------------------------------------------------------------------------------

    @Test
    fun `HTTP 403 from server throws MonarchMfaRequiredException`() {
        // VERIFY-AT-BOOTSTRAP: upstream _login_user line 3578 — HTTP 403 = MFA required
        wiremock.stubFor(
            post(urlEqualTo(LOGIN_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(403)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"detail":"Multi-Factor Authentication required."}"""),
                ),
        )

        assertThatThrownBy { auth.login("test@example.com", "password123") }
            .isInstanceOf(MonarchMfaRequiredException::class.java)
    }

    @Test
    fun `loginWithMfa succeeds when TOTP code provided`() {
        // VERIFY-AT-BOOTSTRAP: /auth/login/ accepts totp field alongside username/password
        wiremock.stubFor(
            post(urlEqualTo(LOGIN_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"token":"mfa-session-token-abc","tokenExpiration":null}"""),
                ),
        )

        val session = auth.loginWithMfa("test@example.com", "password123", "123456")

        assertThat(session.token).isEqualTo("mfa-session-token-abc")
    }

    // -------------------------------------------------------------------------------------
    // HTTP errors during login (not the same as session-expired on GraphQL)
    // -------------------------------------------------------------------------------------

    @Test
    fun `HTTP 400 from server throws MonarchRequestFailedException`() {
        wiremock.stubFor(
            post(urlEqualTo(LOGIN_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(400)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"detail":"Bad request"}"""),
                ),
        )

        var caughtEx400: Throwable? = null
        try {
            auth.login("bad@bad.com", "bad")
        } catch (ex: MonarchRequestFailedException) {
            caughtEx400 = ex
        }
        assertThat(caughtEx400).isInstanceOf(MonarchRequestFailedException::class.java)
        assertThat((caughtEx400 as MonarchRequestFailedException).status).isEqualTo(400)
    }

    @Test
    fun `HTTP 401 from login endpoint throws MonarchRequestFailedException (not session-expired)`() {
        // 401 from /auth/login/ means wrong credentials — NOT the same as session token expiry on GraphQL
        // VERIFY-AT-BOOTSTRAP: confirm Monarch actually returns 401 for wrong creds (not 400/403)
        wiremock.stubFor(
            post(urlEqualTo(LOGIN_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(401)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"detail":"Invalid credentials"}"""),
                ),
        )

        var caughtEx401: Throwable? = null
        try {
            auth.login("wrong@example.com", "wrong")
        } catch (ex: MonarchRequestFailedException) {
            caughtEx401 = ex
        }
        assertThat(caughtEx401).isInstanceOf(MonarchRequestFailedException::class.java)
        assertThat((caughtEx401 as MonarchRequestFailedException).status).isEqualTo(401)
    }

    @Test
    fun `response missing token field throws MonarchRequestFailedException`() {
        // VERIFY-AT-BOOTSTRAP: guard against Monarch changing response shape
        wiremock.stubFor(
            post(urlEqualTo(LOGIN_PATH))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"someOtherField":"value"}"""),
                ),
        )

        assertThatThrownBy { auth.login("test@example.com", "password") }
            .isInstanceOf(MonarchRequestFailedException::class.java)
            .hasMessageContaining("token")
    }
}
