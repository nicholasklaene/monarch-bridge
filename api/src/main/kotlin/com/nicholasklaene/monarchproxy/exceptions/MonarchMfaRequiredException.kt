package com.nicholasklaene.monarchproxy.exceptions

/** Thrown during login when Monarch requires a TOTP code (HTTP 403 from /auth/login/). */
class MonarchMfaRequiredException(
    message: String = "Monarch requires MFA. Provide a TOTP code or --mfa-secret.",
) : RuntimeException(message)
