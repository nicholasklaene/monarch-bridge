package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.JsonMappers
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/**
 * Patch one or more fields on a transaction. All input fields are optional — only non-null
 * fields are included in the GraphQL `input` variable. Output is the spec-generated
 * [UpdateTransactionResponseData].
 */
object UpdateTransaction : MonarchOperation<UpdateTransaction.Input, UpdateTransactionResponseData> {
    override val operationName: String = "Web_TransactionDrawerUpdateTransaction"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val id: String,
        val category: String? = null,
        val merchantName: String? = null,
        val amount: Double? = null,
        val date: String? = null,
        val hideFromReports: Boolean? = null,
        val needsReview: Boolean? = null,
        val reviewed: Boolean? = null,
        val goalId: String? = null,
        val notes: String? = null,
    ) {
        companion object {
            @Suppress("LongParameterList")
            fun from(
                id: String,
                req: UpdateTransactionRequest,
            ): Input =
                Input(
                    id = id,
                    category = req.category,
                    merchantName = req.merchantName,
                    amount = req.amount,
                    date = req.date,
                    hideFromReports = req.hideFromReports,
                    needsReview = req.needsReview,
                    reviewed = req.reviewed,
                    goalId = req.goalId,
                    notes = req.notes,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOfNotNull(
                    "id" to input.id,
                    "category" to input.category,
                    "name" to input.merchantName,
                    "amount" to input.amount,
                    "date" to input.date,
                    "hideFromReports" to input.hideFromReports,
                    "needsReview" to input.needsReview,
                    "reviewed" to input.reviewed,
                    "goalId" to input.goalId,
                    "notes" to input.notes,
                ),
        )

    override fun parseOutput(data: JsonNode): UpdateTransactionResponseData =
        UpdateTransactionResponseData(
            transaction = JsonMappers.parseTransaction(data.path("updateTransaction").path("transaction")),
        )
}
