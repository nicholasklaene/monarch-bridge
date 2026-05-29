package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Hard-delete a goal via the v2 mutation. Output reuses the dedup'd
 * `{success: boolean}` type from the generated model pool.
 */
object DeleteGoalV2 :
    MonarchOperation<DeleteGoalV2.Input, MarkTransactionStreamAsNotRecurringResponseData> {
    override val operationName: String = "Common_DeleteGoalV2"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("id" to input.id))

    override fun parseOutput(data: JsonNode): MarkTransactionStreamAsNotRecurringResponseData =
        MarkTransactionStreamAsNotRecurringResponseData(
            success = data.path("deleteGoalV2").path("success").asBoolean(false),
        )
}
