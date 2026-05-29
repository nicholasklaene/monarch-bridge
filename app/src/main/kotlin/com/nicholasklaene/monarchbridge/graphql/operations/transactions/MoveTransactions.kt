package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MoveTransactionsRequest
import com.nicholasklaene.monarchbridge.generated.model.MoveTransactionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.MoveTransactionsResponseDataErrorsInner
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Move N transactions from any source account(s) to one target account. */
object MoveTransactions :
    MonarchOperation<MoveTransactions.Input, MoveTransactionsResponseData> {
    override val operationName: String = "Web_MoveTransactions"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val transactionIds: List<String>,
        val toAccountId: String,
    ) {
        companion object {
            fun from(req: MoveTransactionsRequest): Input = Input(transactionIds = req.transactionIds, toAccountId = req.toAccountId)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "transactionIds" to input.transactionIds,
                    "toAccountId" to input.toAccountId,
                ),
        )

    override fun parseOutput(data: JsonNode): MoveTransactionsResponseData {
        val node = data.path("moveTransactions")
        val errs =
            node.path("errors").map {
                MoveTransactionsResponseDataErrorsInner(message = it.path("message").asTextOrNull())
            }
        return MoveTransactionsResponseData(
            numTransactionsMoved = node.path("numTransactionsMoved").asInt(0),
            errors = errs.ifEmpty { null },
        )
    }
}
