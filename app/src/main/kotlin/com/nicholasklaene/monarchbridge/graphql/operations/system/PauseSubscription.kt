package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.PauseSubscriptionRequest
import com.nicholasklaene.monarchbridge.generated.model.PauseSubscriptionResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Pause the active subscription. Body is optional - omit to pause indefinitely; provide
 * `resumeAt` to auto-resume on a date. PayloadError handling routes to HTTP 422.
 */
object PauseSubscription : MonarchOperation<PauseSubscription.Input, PauseSubscriptionResponseData> {
    override val operationName: String = "Common_PauseSubscription"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val resumeAt: LocalDate? = null,
        val reason: String? = null,
    ) {
        companion object {
            fun from(req: PauseSubscriptionRequest?): Input = Input(resumeAt = req?.resumeAt, reason = req?.reason)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                buildMap<String, Any?> {
                    input.resumeAt?.let { put("resumeAt", it.toString()) }
                    input.reason?.let { put("reason", it) }
                },
        )

    override fun parseOutput(data: JsonNode): PauseSubscriptionResponseData {
        val s = data.path("pauseSubscription").path("subscription")
        return PauseSubscriptionResponseData(
            paused = s.path("status").asTextOrNull()?.equals("paused", ignoreCase = true),
            pausedAt = s.path("pausedAt").asTextOrNull(),
            resumeAt = s.path("resumeAt").asTextOrNull()?.let { LocalDate.parse(it) },
        )
    }
}
