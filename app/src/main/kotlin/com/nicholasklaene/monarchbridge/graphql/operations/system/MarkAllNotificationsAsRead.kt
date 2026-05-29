package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkAllNotificationsAsReadResponseData
import com.nicholasklaene.monarchbridge.generated.model.MarkNotificationAsReadResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Bulk-flip `readAt` for the first N activity events. Returns the echoed page. */
object MarkAllNotificationsAsRead :
    MonarchOperation<MarkAllNotificationsAsRead.Input, MarkAllNotificationsAsReadResponseData> {
    override val operationName: String = "Common_MarkAllActivityAsRead"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val first: Int,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("first" to input.first)

    override fun parseOutput(data: JsonNode): MarkAllNotificationsAsReadResponseData =
        MarkAllNotificationsAsReadResponseData(
            edges =
                data
                    .path("markAllActivityAsRead")
                    .path("activityEvents")
                    .path("edges")
                    .map { edge ->
                        val node = edge.path("node")
                        MarkNotificationAsReadResponseData(
                            id = node.path("id").asText(""),
                            readAt = node.path("readAt").asTextOrNull(),
                        )
                    },
        )
}
