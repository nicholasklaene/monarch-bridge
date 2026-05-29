package com.nicholasklaene.monarchbridge.graphql.operations.holdings

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetHoldingTransactionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.HoldingTransactionRow
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull
import java.time.LocalDate

/** Lots / trades for one holding over a date window. */
object GetHoldingTransactions :
    MonarchOperation<GetHoldingTransactions.Input, GetHoldingTransactionsResponseData> {
    override val operationName: String = "Web_GetHoldingTransactions"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val holdingId: String,
        val startDate: LocalDate? = null,
        val endDate: LocalDate? = null,
        val limit: Int? = null,
        val offset: Int? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOfNotNull(
            "holdingId" to input.holdingId,
            "startDate" to input.startDate?.toString(),
            "endDate" to input.endDate?.toString(),
            "limit" to input.limit,
            "offset" to input.offset,
        )

    override fun parseOutput(data: JsonNode): GetHoldingTransactionsResponseData =
        GetHoldingTransactionsResponseData(
            transactions =
                data.path("holdingTransactions").map { t ->
                    HoldingTransactionRow(
                        id = t.path("id").asText(""),
                        date = t.path("date").asTextOrNull(),
                        type = t.path("type").asTextOrNull(),
                        quantity = t.path("quantity").asDoubleOrNull(),
                        price = t.path("price").asDoubleOrNull(),
                        amount = t.path("amount").asDoubleOrNull(),
                        fees = t.path("fees").asDoubleOrNull(),
                        notes = t.path("notes").asTextOrNull(),
                    )
                },
        )
}
