package com.nicholasklaene.monarchbridge.graphql

import com.fasterxml.jackson.databind.JsonNode

/**
 * A "PayloadError" — a non-fatal application error that Monarch returns inside
 * `data.<mutation>.errors[]` instead of as an HTTP error or a top-level GraphQL `errors`-array
 * failure. Examples: "category not found", "tag name already exists", validation failures.
 *
 * Most mutations use the PayloadErrorFields fragment shape:
 *   { fieldErrors: [{field, messages}], message: String, code: String }
 *
 * `Common_CreateTransactionTag` uses a simplified shape: just `{ message: String }`.
 *
 * Surfaced uniformly here; thrown as [PayloadErrorException] by [MonarchClient.execute] and
 * mapped to HTTP 422 by `config/GlobalExceptionHandler`.
 */
data class PayloadError(
    val message: String?,
    val code: String?,
    val fieldErrors: List<FieldError>,
) {
    data class FieldError(
        val field: String,
        val messages: List<String>,
    )

    companion object {
        fun fromNode(node: JsonNode): PayloadError {
            val fieldErrors = node.path("fieldErrors").mapNotNull(::parseFieldError)
            return PayloadError(
                message = node.path("message").takeIf { it.isTextual }?.asText(),
                code = node.path("code").takeIf { it.isTextual }?.asText(),
                fieldErrors = fieldErrors,
            )
        }

        private fun parseFieldError(node: JsonNode): FieldError? {
            if (!node.path("field").isTextual) return null
            return FieldError(
                field = node.path("field").asText(),
                messages = node.path("messages").map { it.asText() },
            )
        }
    }
}
