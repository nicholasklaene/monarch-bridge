package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.SkipRecurringInstanceRequest
import com.nicholasklaene.monarchbridge.generated.model.SkipRecurringInstanceResponseData
import com.nicholasklaene.monarchbridge.generated.model.SkippedRecurringInstance
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/** Skip one expected occurrence of a recurring stream on the given date. */
object SkipRecurringInstance :
    MonarchOperation<SkipRecurringInstance.Input, SkipRecurringInstanceResponseData> {
    override val operationName: String = "Web_SkipRecurringInstance"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val streamId: String,
        val skipDate: LocalDate,
    ) {
        companion object {
            fun from(
                streamId: String,
                req: SkipRecurringInstanceRequest,
            ): Input = Input(streamId = streamId, skipDate = req.skipDate)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "streamId" to input.streamId,
                    "skipDate" to input.skipDate.toString(),
                ),
        )

    override fun parseOutput(data: JsonNode): SkipRecurringInstanceResponseData {
        val instance = data.path("skipRecurringInstance").path("instance")
        return SkipRecurringInstanceResponseData(
            instance =
                SkippedRecurringInstance(
                    streamId = instance.path("streamId").asText(""),
                    skippedDate = instance.path("skippedDate").asTextOrNull(),
                ),
        )
    }
}
