package com.nicholasklaene.monarchbridge.exceptions

/**
 * Thrown when Monarch returns a non-2xx HTTP status (excluding 401/429 which have dedicated types),
 * or when the GraphQL response body contains a non-empty `errors` array.
 */
class MonarchRequestFailedException(
    val status: Int,
    val body: String,
    override val message: String,
) : RuntimeException(message)
