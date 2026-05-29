package com.nicholasklaene.monarchbridge.exceptions

import com.nicholasklaene.monarchbridge.graphql.PayloadError

/**
 * Thrown by `MonarchClient.execute` when a mutation response carries non-empty
 * `data.<mutation>.errors[]`. Mapped to HTTP 422 (unprocessable entity) by
 * `GlobalExceptionHandler`.
 *
 * The [PayloadError] data type lives in `graphql/` because it's a GraphQL-shape
 * concern (parsed from `data.<mutation>.errors[]`); the exception lives here so
 * the global handler dispatch boundary stays clean.
 */
class PayloadErrorException(
    val mutationName: String,
    val errors: List<PayloadError>,
) : RuntimeException("PayloadError on $mutationName: ${errors.firstOrNull()?.message ?: "<no message>"}")
