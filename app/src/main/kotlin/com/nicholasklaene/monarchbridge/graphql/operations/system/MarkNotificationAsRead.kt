package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkNotificationAsReadResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Flip `readAt=now` on a single activity event. Idempotent. */
object MarkNotificationAsRead :
    MonarchOperation<MarkNotificationAsRead.Input, MarkNotificationAsReadResponseData> {
    override val operationName: String = "Common_MarkActivityAsRead"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): MarkNotificationAsReadResponseData {
        val node = data.path("markActivityAsRead").path("node")
        return MarkNotificationAsReadResponseData(
            id = node.path("id").asText(""),
            readAt = node.path("readAt").asTextOrNull(),
        )
    }
}
