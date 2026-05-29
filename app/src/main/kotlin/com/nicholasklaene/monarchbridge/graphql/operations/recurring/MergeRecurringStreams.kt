package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MergeRecurringStreamsRequest
import com.nicholasklaene.monarchbridge.generated.model.MergeRecurringStreamsResponseData
import com.nicholasklaene.monarchbridge.generated.model.RecurringStreamRef
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/** Collapse two or more recurring streams into one. */
object MergeRecurringStreams :
    MonarchOperation<MergeRecurringStreams.Input, MergeRecurringStreamsResponseData> {
    override val operationName: String = "Web_MergeRecurringStreams"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val primaryStreamId: String,
        val mergedStreamIds: List<String>,
        val newName: String? = null,
    ) {
        companion object {
            fun from(req: MergeRecurringStreamsRequest): Input =
                Input(
                    primaryStreamId = req.primaryStreamId,
                    mergedStreamIds = req.mergedStreamIds,
                    newName = req.newName,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOfNotNull(
                    "primaryStreamId" to input.primaryStreamId,
                    "mergedStreamIds" to input.mergedStreamIds,
                    "newName" to input.newName,
                ),
        )

    override fun parseOutput(data: JsonNode): MergeRecurringStreamsResponseData {
        val stream = data.path("mergeRecurringStreams").path("stream")
        return MergeRecurringStreamsResponseData(
            stream =
                RecurringStreamRef(
                    id = stream.path("id").asText(""),
                    name = stream.path("name").asTextOrNull(),
                ),
        )
    }
}
