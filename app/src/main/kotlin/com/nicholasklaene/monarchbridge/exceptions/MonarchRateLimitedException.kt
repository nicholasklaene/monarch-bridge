package com.nicholasklaene.monarchbridge.exceptions

/**
 * Thrown when Monarch returns HTTP 429 (rate limited).
 * @param retryAfterSeconds value of the `Retry-After` header, or null if absent.
 */
class MonarchRateLimitedException(
    val retryAfterSeconds: Long?,
) : RuntimeException("Monarch rate limit hit. Retry after ${retryAfterSeconds ?: "unknown"} seconds.")
