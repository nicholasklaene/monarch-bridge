package com.nicholasklaene.monarchbridge.exceptions
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException

/** Thrown when a GraphQL call is attempted but no session token is loaded. */
class MonarchSessionMissingException(
    message: String = "No Monarch session. Run ./gradlew :app:bootstrapMonarch first.",
) : RuntimeException(message)
