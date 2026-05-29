package com.nicholasklaene.monarchbridge.exceptions
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionExpiredException

/** Thrown when Monarch returns HTTP 401 - the saved session token has expired. */
class MonarchSessionExpiredException(
    message: String = "Monarch session token has expired. Re-run :app:bootstrapMonarch.",
) : RuntimeException(message)
