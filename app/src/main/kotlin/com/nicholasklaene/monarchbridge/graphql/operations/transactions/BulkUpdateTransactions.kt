package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateTransactionsRequest
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateTransactionsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/**
 * Wraps Monarch's `bulkUpdateTransactions` mutation. The mutation accepts the same
 * `updates: TransactionUpdateParams!` shape as the single-row `Web_TransactionDrawerUpdateTransaction`
 * mutation, plus a selection set (`allSelected` + either `selectedTransactionIds` or
 * `filters` + `excludedTransactionIds`) and the safety-guard `expectedAffectedTransactionCount`.
 *
 * Output is the spec-generated [BulkUpdateTransactionsResponseData] with `success` +
 * `affectedCount` + optional `errors[]`.
 */
object BulkUpdateTransactions : MonarchOperation<BulkUpdateTransactions.Input, BulkUpdateTransactionsResponseData> {
    override val operationName: String = "Common_BulkUpdateTransactionsMutation"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val selectedTransactionIds: List<String>? = null,
        val excludedTransactionIds: List<String>? = null,
        val allSelected: Boolean = false,
        val expectedAffectedTransactionCount: Int,
        val updates: Map<String, Any?>,
        val filters: Map<String, Any?>? = null,
    ) {
        companion object {
            fun from(req: BulkUpdateTransactionsRequest): Input =
                Input(
                    selectedTransactionIds = req.selectedTransactionIds,
                    excludedTransactionIds = req.excludedTransactionIds,
                    allSelected = req.allSelected ?: false,
                    expectedAffectedTransactionCount = req.expectedAffectedTransactionCount,
                    updates = updatesMap(req),
                    filters = req.filters?.let { filtersMap(it) },
                )

            internal fun updatesMap(req: BulkUpdateTransactionsRequest): Map<String, Any?> {
                val u = req.updates
                return mapOfNotNull(
                    "categoryId" to u.categoryId,
                    "merchantName" to u.merchantName,
                    "date" to u.date,
                    "notes" to u.notes,
                    "hide" to u.hide,
                    "isRecurring" to u.isRecurring,
                    "reviewStatus" to u.reviewStatus,
                    "goalId" to u.goalId,
                    "needsReviewByUserId" to u.needsReviewByUserId,
                    "ownerUserId" to u.ownerUserId,
                    "businessEntityId" to u.businessEntityId,
                    "isLinkedToPaydownBudget" to u.isLinkedToPaydownBudget,
                    "tags" to u.tags,
                )
            }
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "selectedTransactionIds" to input.selectedTransactionIds,
            "excludedTransactionIds" to input.excludedTransactionIds,
            "allSelected" to input.allSelected,
            "expectedAffectedTransactionCount" to input.expectedAffectedTransactionCount,
            "updates" to input.updates,
            "filters" to input.filters,
        )

    override fun parseOutput(data: JsonNode): BulkUpdateTransactionsResponseData {
        val payload = data.path("bulkUpdateTransactions")
        return BulkUpdateTransactionsResponseData(
            success = payload.path("success").asBoolean(false),
            affectedCount = payload.path("affectedCount").asInt(0),
            errors = null,
        )
    }
}
