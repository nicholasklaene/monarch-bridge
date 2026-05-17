package com.nicholasklaene.monarchproxy.exceptions

/** Thrown when Monarch returns HTTP 401 — the saved session token has expired. */
class MonarchSessionExpiredException(
    message: String = "Monarch session token has expired. Re-run :api:bootstrapMonarch.",
) : RuntimeException(message)
