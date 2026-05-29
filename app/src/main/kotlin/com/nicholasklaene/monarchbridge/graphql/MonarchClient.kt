package com.nicholasklaene.monarchbridge.graphql

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.MonarchProperties
import com.nicholasklaene.monarchbridge.exceptions.MonarchRateLimitedException
import com.nicholasklaene.monarchbridge.exceptions.MonarchRequestFailedException
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionExpiredException
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.exceptions.PayloadErrorException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.core.io.ByteArrayResource
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestClient
import java.net.URI

/**
 * One file to upload as part of a multipart form-data POST.
 *
 * Used by [MonarchClient.uploadMultipart] and [MonarchClient.uploadToExternal] to send
 * binary payloads (PDF / image attachments, CSV balance history) to Monarch and to
 * Monarch's signed Cloudinary endpoints.
 */
data class MultipartFilePart(
    val filename: String,
    val contentType: String,
    val bytes: ByteArray,
)

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
@Suppress("LargeClass")
open class MonarchClient(
    private val properties: MonarchProperties,
    private val monarchSession: MonarchSessionService,
    private val objectMapper: ObjectMapper,
) {
    companion object {
        private val log = KotlinLogging.logger {}

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
     * Hosts allowed as targets for external multipart uploads (e.g. Cloudinary, which
     * Monarch's `Common_GetTransactionAttachmentUploadInfo` mutation hands us a signed
     * URL for). Override in tests to add WireMock host. Verified at request time, not
     * at startup, since Monarch decides the URL.
     */
    protected open val allowedUploadHosts: Set<String> get() = setOf("api.cloudinary.com")

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

        log.debug { "GraphQL $operation -> POST ${properties.baseUrl}$GRAPHQL_PATH" }

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
                    HttpStatus.UNAUTHORIZED.value() -> {
                        throw MonarchSessionExpiredException()
                    }

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

    /**
     * Typed entry point — the canonical way to talk to Monarch.
     *
     * Looks up the operation's [MonarchOperation.query] + [MonarchOperation.variables], runs
     * the GraphQL request, inspects `data.<mutation>.errors[]` for application-level failures
     * (thrown as [PayloadErrorException] → HTTP 422), and parses the raw response into the
     * operation's typed [TOutput] via [MonarchOperation.parseOutput].
     *
     * Callers get a fully-typed result. They never need to touch [JsonNode] unless they want
     * to access a field that isn't in the operation's Output class — in which case extend
     * the Output rather than dropping to raw JSON.
     */
    fun <TInput, TOutput> execute(
        operation: MonarchOperation<TInput, TOutput>,
        input: TInput,
    ): TOutput {
        val data = executeGraphQL(operation.operationName, operation.query, operation.variables(input))
        checkPayloadErrors(data)
        return operation.parseOutput(data)
    }

    /**
     * Walk the one-level-deep children of `data` looking for any object child with a non-empty
     * `errors` array. Mutations return `data.<mutationName> = { ..., errors: [...] }`; reads
     * typically return arrays or simple objects without an `errors` field. Detection is
     * heuristic but safe: reads with object-typed `data.foo` that happen to have an `errors`
     * key would false-positive, but no current Monarch read query has that shape.
     */
    private fun checkPayloadErrors(data: JsonNode) {
        for ((mutationName, mutationData) in data.properties()) {
            if (!mutationData.isObject) continue
            val errorsNode = mutationData.path("errors")
            if (errorsNode.isArray && errorsNode.size() > 0) {
                val errors = errorsNode.map { PayloadError.fromNode(it) }
                throw PayloadErrorException(mutationName, errors)
            }
        }
    }

    private fun buildRestClient(token: String): RestClient =
        RestClient
            .builder()
            .baseUrl(properties.baseUrl)
            .defaultHeader("Authorization", "Token $token")
            .defaultHeader("Content-Type", "application/json")
            .build()

    /**
     * POSTs a multipart form-data body to Monarch at [path] (joined to the configured
     * base URL). Sends the session token in `Authorization`, same as GraphQL calls.
     *
     * Used for non-GraphQL upload paths like `/account-balance-history/upload/`.
     *
     * @param fields each entry is sent as a form part. Strings go as text parts. Use
     *   [MultipartFilePart] for binary parts (filename + content type + bytes).
     * @return the parsed JSON response body.
     */
    @Suppress("LongMethod", "CyclomaticComplexMethod", "ThrowsCount")
    fun uploadMultipart(
        path: String,
        fields: Map<String, Any>,
    ): JsonNode {
        val session = monarchSession.current() ?: throw MonarchSessionMissingException()
        val body = LinkedMultiValueMap<String, Any>()
        for ((key, value) in fields) body.add(key, toMultipartValue(value))

        log.debug { "Multipart $path -> POST ${properties.baseUrl}$path" }

        val client =
            RestClient
                .builder()
                .baseUrl(properties.baseUrl)
                .defaultHeader("Authorization", "Token ${session.token}")
                .build()

        var responseStatus = 0
        var responseBody = ""

        client
            .post()
            .uri(path)
            .contentType(MediaType.MULTIPART_FORM_DATA)
            .body(body)
            .exchange { _, response ->
                responseStatus = response.statusCode.value()
                val capped = response.body.readNBytes(MAX_BODY_BYTES.toInt())
                responseBody = String(capped)
                handleUploadStatus(responseStatus, responseBody, "POST $path")
            }

        return objectMapper.readTree(responseBody)
    }

    /**
     * POSTs a multipart form-data body to an arbitrary URL whose host must be in
     * [allowedUploadHosts] (e.g. Cloudinary). Does NOT send Monarch's session token,
     * since Monarch's signed upload URLs carry their own auth in the form fields.
     *
     * The proxy uses this for the Cloudinary leg of `upload_attachment`: Monarch's
     * GraphQL mutation hands back a signed Cloudinary URL + form fields; we forward the
     * file there with no Monarch credentials attached.
     */
    @Suppress("LongMethod", "CyclomaticComplexMethod", "ThrowsCount")
    fun uploadToExternal(
        uploadUrl: String,
        fields: Map<String, Any>,
    ): JsonNode {
        val host = URI(uploadUrl).host
        check(allowedUploadHosts.contains(host)) {
            "SSRF protection: external upload host '$host' not in allowlist (allowed: $allowedUploadHosts)"
        }
        val body = LinkedMultiValueMap<String, Any>()
        for ((key, value) in fields) body.add(key, toMultipartValue(value))

        log.debug { "External multipart upload -> POST $uploadUrl" }

        val client = RestClient.builder().build()

        var responseStatus = 0
        var responseBody = ""

        client
            .post()
            .uri(URI(uploadUrl))
            .contentType(MediaType.MULTIPART_FORM_DATA)
            .body(body)
            .exchange { _, response ->
                responseStatus = response.statusCode.value()
                val capped = response.body.readNBytes(MAX_BODY_BYTES.toInt())
                responseBody = String(capped)
                if (responseStatus < HTTP_MIN_SUCCESS || responseStatus >= HTTP_MAX_SUCCESS) {
                    throw MonarchRequestFailedException(
                        responseStatus,
                        responseBody,
                        "External upload to $host returned HTTP $responseStatus",
                    )
                }
            }

        return objectMapper.readTree(responseBody)
    }

    @Suppress("ThrowsCount")
    private fun handleUploadStatus(
        responseStatus: Int,
        responseBody: String,
        opLabel: String,
    ) {
        when (responseStatus) {
            HttpStatus.UNAUTHORIZED.value() -> {
                throw MonarchSessionExpiredException()
            }

            HttpStatus.TOO_MANY_REQUESTS.value() -> {
                throw MonarchRateLimitedException(null)
            }

            else -> {
                if (responseStatus < HTTP_MIN_SUCCESS || responseStatus >= HTTP_MAX_SUCCESS) {
                    throw MonarchRequestFailedException(
                        responseStatus,
                        responseBody,
                        "Monarch returned HTTP $responseStatus for $opLabel",
                    )
                }
            }
        }
    }

    /** Convert a tagged value into a Spring multipart part. */
    private fun toMultipartValue(value: Any): Any =
        when (value) {
            is MultipartFilePart -> {
                val resource =
                    object : ByteArrayResource(value.bytes) {
                        override fun getFilename(): String = value.filename
                    }
                val headers =
                    HttpHeaders().apply {
                        contentType = MediaType.parseMediaType(value.contentType)
                    }
                HttpEntity(resource, headers)
            }

            else -> {
                value
            }
        }
}
