package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Insert a new transaction. `amount` is signed (negative for expenses).
 * Output is the spec-generated [CreateTransactionResponseData].
 */
object CreateTransaction : MonarchOperation<CreateTransaction.Input, CreateTransactionResponseData> {
    override val operationName: String = "Common_CreateTransactionMutation"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val date: String,
        val accountId: String,
        val amount: Double,
        val merchantName: String,
        val categoryId: String,
        val notes: String = "",
        val shouldUpdateBalance: Boolean = false,
    ) {
        companion object {
            fun from(req: CreateTransactionRequest): Input =
                Input(
                    date = req.date,
                    accountId = req.accountId,
                    amount = req.amount,
                    merchantName = req.merchantName,
                    categoryId = req.categoryId,
                    notes = req.notes ?: "",
                    shouldUpdateBalance = req.shouldUpdateBalance ?: false,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "date" to input.date,
                    "accountId" to input.accountId,
                    "amount" to input.amount,
                    "merchantName" to input.merchantName,
                    "categoryId" to input.categoryId,
                    "notes" to input.notes,
                    "shouldUpdateBalance" to input.shouldUpdateBalance,
                ),
        )

    override fun parseOutput(data: JsonNode): CreateTransactionResponseData =
        CreateTransactionResponseData(
            transactionId =
                data
                    .path("createTransaction")
                    .path("transaction")
                    .path("id")
                    .asText(""),
        )
}
