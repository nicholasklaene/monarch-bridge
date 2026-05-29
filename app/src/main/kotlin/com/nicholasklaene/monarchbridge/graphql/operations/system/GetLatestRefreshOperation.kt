package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetLatestRefreshOperationResponseData
import com.nicholasklaene.monarchbridge.generated.model.LatestRefreshOperation
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull

/**
 * Latest global force-refresh operation (id + state). Lightweight alternative to
 * `/v1/refresh/status` for the "is a refresh running" question — returns one record
 * rather than per-account flags. `operation` is null when the user has never
 * triggered a force refresh.
 */
object GetLatestRefreshOperation : MonarchOperation<Unit, GetLatestRefreshOperationResponseData> {
    override val operationName: String = "Common_LatestForceRefreshOperation"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetLatestRefreshOperationResponseData {
        val node = data.pathOrNull("latestForceRefreshOperation") ?: return GetLatestRefreshOperationResponseData(operation = null)
        return GetLatestRefreshOperationResponseData(
            operation =
                LatestRefreshOperation(
                    id = node.path("id").asText(""),
                    state = node.path("state").asTextOrNull(),
                ),
        )
    }
}
