package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.BulkDeleteTransactionsRequest
import com.nicholasklaene.monarchbridge.generated.model.BulkDeleteTransactionsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Wraps Monarch's `bulkDeleteTransactions` mutation. Selection-set + safety-guard semantics
 * mirror [BulkUpdateTransactions]: either `selectedTransactionIds` (explicit) or
 * `allSelected=true` + `filters` (+ optional `excludedTransactionIds`).
 *
 * Note the GraphQL document wraps the variables inside a nested `input: { ... }` object
 * with `isAllSelected` (not `allSelected`) — Monarch is inconsistent on this between
 * the update and delete mutations. The top-level GraphQL variable is still `$allSelected`.
 */
object BulkDeleteTransactions : MonarchOperation<BulkDeleteTransactions.Input, BulkDeleteTransactionsResponseData> {
    override val operationName: String = "Common_BulkDeleteTransactionsMutation"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val selectedTransactionIds: List<String>? = null,
        val excludedTransactionIds: List<String>? = null,
        val allSelected: Boolean = false,
        val expectedAffectedTransactionCount: Int,
        val filters: Map<String, Any?>? = null,
    ) {
        companion object {
            fun from(req: BulkDeleteTransactionsRequest): Input =
                Input(
                    selectedTransactionIds = req.selectedTransactionIds,
                    excludedTransactionIds = req.excludedTransactionIds,
                    allSelected = req.allSelected ?: false,
                    expectedAffectedTransactionCount = req.expectedAffectedTransactionCount,
                    filters = req.filters?.let { filtersMap(it) },
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "selectedTransactionIds" to input.selectedTransactionIds,
            "excludedTransactionIds" to input.excludedTransactionIds,
            "allSelected" to input.allSelected,
            "expectedAffectedTransactionCount" to input.expectedAffectedTransactionCount,
            "filters" to input.filters,
        )

    override fun parseOutput(data: JsonNode): BulkDeleteTransactionsResponseData {
        val payload = data.path("bulkDeleteTransactions")
        return BulkDeleteTransactionsResponseData(
            success = payload.path("success").asBoolean(false),
            affectedCount = payload.path("affectedCount").asInt(0),
            errors = null,
        )
    }
}
