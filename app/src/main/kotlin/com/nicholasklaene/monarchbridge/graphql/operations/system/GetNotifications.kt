package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetNotificationsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetNotificationsResponseDataEdgesInner
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Paginated activity-event stream backing the in-app notification bell. */
object GetNotifications : MonarchOperation<GetNotifications.Input, GetNotificationsResponseData> {
    override val operationName: String = "Common_GetNotificationCenter"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val first: Int,
        val afterCursor: String?,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("first" to input.first, "afterCursor" to input.afterCursor)

    override fun parseOutput(data: JsonNode): GetNotificationsResponseData {
        val events = data.path("activityEvents")
        val pageInfo = events.path("pageInfo")
        return GetNotificationsResponseData(
            hasNextPage = pageInfo.path("hasNextPage").asBooleanOrNull(),
            endCursor = pageInfo.path("endCursor").asTextOrNull(),
            edges =
                events.path("edges").map { edge ->
                    val node = edge.path("node")
                    GetNotificationsResponseDataEdgesInner(
                        id = node.path("id").asText(""),
                        createdAt = node.path("createdAt").asTextOrNull(),
                        readAt = node.path("readAt").asTextOrNull(),
                        title = node.path("title").asTextOrNull(),
                        body = node.path("body").asTextOrNull(),
                        action = node.path("action").asTextOrNull(),
                        actionLabel = node.path("actionLabel").asTextOrNull(),
                        eventPriority = node.path("eventPriority").asTextOrNull(),
                        isPinned = node.path("isPinned").asBooleanOrNull(),
                        logo = node.path("logo").asTextOrNull(),
                        dismissedAt = node.path("dismissedAt").asTextOrNull(),
                        eventType = node.path("eventType").asTextOrNull(),
                        secondaryUrl = node.path("secondaryUrl").asTextOrNull(),
                    )
                },
        )
    }
}
