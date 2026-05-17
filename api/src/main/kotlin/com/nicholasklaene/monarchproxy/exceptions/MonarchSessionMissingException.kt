package com.nicholasklaene.monarchproxy.exceptions

/** Thrown when a GraphQL call is attempted but no session token is loaded. */
class MonarchSessionMissingException(
    message: String = "No Monarch session. Run ./gradlew :api:bootstrapMonarch first.",
) : RuntimeException(message)
