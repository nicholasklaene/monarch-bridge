package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.AccountSnapshot
import com.nicholasklaene.monarchbridge.generated.model.GetAccountHistoryResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.JsonMappers
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.pathOrNull
import java.time.LocalDate

/**
 * Per-account detail: full account + most-recent 20 transactions + full balance snapshot
 * series. Output is the spec-generated [GetAccountHistoryResponseData].
 */
object GetAccountHistory : MonarchOperation<GetAccountHistory.Input, GetAccountHistoryResponseData> {
    override val operationName: String = "AccountDetails_getAccount"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("AccountFields", "TransactionOverviewFields"))
    }

    data class Input(
        val accountId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.accountId)

    override fun parseOutput(data: JsonNode): GetAccountHistoryResponseData =
        GetAccountHistoryResponseData(
            account = data.pathOrNull("account")?.let(JsonMappers::parseAccount),
            recentTransactions = data.path("transactions").path("results").map(JsonMappers::parseTransaction),
            snapshots =
                data.path("snapshots").map {
                    AccountSnapshot(
                        date = LocalDate.parse(it.path("date").asText("1970-01-01")),
                        balance = it.path("signedBalance").asDouble(0.0),
                    )
                },
        )
}
