package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Drop all goal-reconciliation records for one transaction. Inverse of
 * [LinkTransactionToGoal]. Output reuses the dedup'd `{success: boolean}` type.
 */
object UnlinkTransactionGoalRecords :
    MonarchOperation<UnlinkTransactionGoalRecords.Input, MarkTransactionStreamAsNotRecurringResponseData> {
    override val operationName: String = "Common_DeleteGoalReconciliationRecordsForTransaction"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val transactionId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("transactionId" to input.transactionId)

    override fun parseOutput(data: JsonNode): MarkTransactionStreamAsNotRecurringResponseData =
        MarkTransactionStreamAsNotRecurringResponseData(
            success = data.path("deleteGoalReconciliationRecordsForTransaction").path("success").asBoolean(false),
        )
}
