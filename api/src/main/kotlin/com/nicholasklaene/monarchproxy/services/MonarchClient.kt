package com.nicholasklaene.monarchproxy.services

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchproxy.config.MonarchProperties
import com.nicholasklaene.monarchproxy.exceptions.MonarchRateLimitedException
import com.nicholasklaene.monarchproxy.exceptions.MonarchRequestFailedException
import com.nicholasklaene.monarchproxy.exceptions.MonarchSessionExpiredException
import com.nicholasklaene.monarchproxy.exceptions.MonarchSessionMissingException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import java.io.InputStream
import java.net.URI

private val log = LoggerFactory.getLogger(MonarchClient::class.java)

/**
 * Executes GraphQL POST requests against the Monarch Money API.
 *
 * Security:
 * - SSRF allowlist: only `api.monarch.com` is permitted as the base-URL host (pinned at startup).
 * - Body cap: responses are read up to MAX_BODY_BYTES (5 MiB) to avoid memory exhaustion.
 * - Auth header: `Authorization: Token <token>` — NOT Bearer. No X-CSRFToken on GraphQL POSTs
 *   (upstream only attaches CSRF for form-upload paths, not GraphQL).
 *
 * All exceptions:
 * - 401 → [MonarchSessionExpiredException]
 * - 429 → [MonarchRateLimitedException] (retryAfterSeconds from Retry-After header)
 * - other non-2xx → [MonarchRequestFailedException]
 * - GraphQL `errors` present → [MonarchRequestFailedException]
 * - No session loaded → [MonarchSessionMissingException]
 */
@Component
open class MonarchClient(
    private val properties: MonarchProperties,
    private val monarchSession: MonarchSessionService,
    private val objectMapper: ObjectMapper,
) {
    companion object {
        /** 5 MiB body cap — mirrors PDS HttpJsoupFetcher.kt:131 pattern. */
        private const val MAX_BODY_BYTES = 5 * 1024 * 1024L
        private const val ALLOWED_HOST = "api.monarch.com"
        private const val GRAPHQL_PATH = "/graphql"
        private const val HTTP_OK = 200
        private const val HTTP_MIN_SUCCESS = 200
        private const val HTTP_MAX_SUCCESS = 300
    }

    init {
        checkSsrfAllowlist()
    }

    /**
     * SSRF allowlist check — called in init. Throws [IllegalStateException] if the configured
     * base-URL host is not in [allowedHosts]. Open so tests can subclass and override.
     */
    protected open fun checkSsrfAllowlist() {
        val host = URI(properties.baseUrl).host
        check(allowedHosts.contains(host)) {
            "SSRF protection: monarch.base-url host must be '$ALLOWED_HOST', got '$host'"
        }
    }

    /** Hosts allowed by the SSRF allowlist. Override in tests to add WireMock host. */
    protected open val allowedHosts: Set<String> get() = setOf(ALLOWED_HOST)

    /**
     * POSTs a GraphQL operation to Monarch and returns the parsed `data` node.
     *
     * @param operation  GraphQL operation name (used in the request body and for logging).
     * @param query      Full query string (operation + all required fragments).
     * @param variables  Variables map (may be empty).
     * @return the `data` field of the GraphQL response as a [JsonNode].
     * @throws MonarchSessionMissingException if no session is currently loaded.
     * @throws MonarchSessionExpiredException on HTTP 401.
     * @throws MonarchRateLimitedException    on HTTP 429.
     * @throws MonarchRequestFailedException  on other non-2xx or GraphQL `errors` in response.
     */
    @Suppress("LongMethod", "CyclomaticComplexMethod", "ThrowsCount")
    fun executeGraphQL(
        operation: String,
        query: String,
        variables: Map<String, Any?>,
    ): JsonNode {
        val session =
            monarchSession.current()
                ?: throw MonarchSessionMissingException()

        val body =
            mapOf(
                "query" to query,
                "operationName" to operation,
                "variables" to variables,
            )
        val requestBody = objectMapper.writeValueAsBytes(body)

        log.debug("GraphQL {} → POST {}{}", operation, properties.baseUrl, GRAPHQL_PATH)

        val restClient = buildRestClient(session.token)

        var responseStatus = 0
        var responseBody = ""

        restClient
            .post()
            .uri(GRAPHQL_PATH)
            .contentType(MediaType.APPLICATION_JSON)
            .body(requestBody)
            .exchange { _, response ->
                responseStatus = response.statusCode.value()
                val capped = response.body.readNBytes(MAX_BODY_BYTES.toInt())
                responseBody = String(capped)

                when (responseStatus) {
                    HttpStatus.UNAUTHORIZED.value() -> throw MonarchSessionExpiredException()
                    HttpStatus.TOO_MANY_REQUESTS.value() -> {
                        val retryAfter = response.headers.getFirst("Retry-After")?.toLongOrNull()
                        throw MonarchRateLimitedException(retryAfter)
                    }
                    else -> {
                        if (responseStatus < HTTP_MIN_SUCCESS || responseStatus >= HTTP_MAX_SUCCESS) {
                            throw MonarchRequestFailedException(
                                responseStatus,
                                responseBody,
                                "Monarch returned HTTP $responseStatus for operation $operation",
                            )
                        }
                    }
                }
            }

        val tree = objectMapper.readTree(responseBody)
        val errors = tree.path("errors")
        if (errors.isArray && errors.size() > 0) {
            val msg = errors[0].path("message").asText("GraphQL error")
            throw MonarchRequestFailedException(HTTP_OK, responseBody, "GraphQL errors for $operation: $msg")
        }
        return tree.path("data")
    }

    private fun buildRestClient(token: String): RestClient =
        RestClient
            .builder()
            .baseUrl(properties.baseUrl)
            .defaultHeader("Authorization", "Token $token")
            .defaultHeader("Content-Type", "application/json")
            .build()

    /** Exposed for testing — reads up to [MAX_BODY_BYTES] from an InputStream. */
    internal fun InputStream.readNBytes(max: Int): ByteArray {
        val buffer = ByteArray(max)
        var totalRead = 0
        while (totalRead < max) {
            val read = read(buffer, totalRead, max - totalRead)
            if (read == -1) break
            totalRead += read
        }
        return buffer.copyOf(totalRead)
    }
}
