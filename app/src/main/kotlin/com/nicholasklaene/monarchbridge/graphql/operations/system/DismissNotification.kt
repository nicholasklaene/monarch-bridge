package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DismissNotificationResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Permanently hide a single activity event (sets `dismissedAt=now`). */
object DismissNotification :
    MonarchOperation<DismissNotification.Input, DismissNotificationResponseData> {
    override val operationName: String = "Common_DismissActivity"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): DismissNotificationResponseData {
        val node = data.path("dismissActivity").path("node")
        return DismissNotificationResponseData(
            id = node.path("id").asText(""),
            dismissedAt = node.path("dismissedAt").asTextOrNull(),
        )
    }
}
