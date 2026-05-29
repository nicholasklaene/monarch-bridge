package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ResumeSubscriptionResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Resume a paused subscription immediately. No request body. PayloadError handling
 * routes to HTTP 422; no-op if the subscription is already active (Monarch returns the
 * current state unchanged).
 */
object ResumeSubscription : MonarchOperation<Unit, ResumeSubscriptionResponseData> {
    override val operationName: String = "Common_ResumeSubscription"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): ResumeSubscriptionResponseData {
        val s = data.path("resumeSubscription").path("subscription")
        return ResumeSubscriptionResponseData(
            resumed = s.path("status").asTextOrNull()?.equals("active", ignoreCase = true),
            resumedAt = s.path("resumedAt").asTextOrNull(),
        )
    }
}
