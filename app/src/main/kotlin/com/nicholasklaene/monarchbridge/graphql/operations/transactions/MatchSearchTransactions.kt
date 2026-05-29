package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MatchSearchTransactionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.MatchSearchTransactionsResponseDataResultsInner
import com.nicholasklaene.monarchbridge.generated.model.MatchSearchTransactionsResponseDataResultsInnerAccount
import com.nicholasklaene.monarchbridge.generated.model.MatchSearchTransactionsResponseDataResultsInnerMerchant
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull

/** Slim fuzzy transaction search for the web "find a match" picker. */
object MatchSearchTransactions :
    MonarchOperation<MatchSearchTransactions.Input, MatchSearchTransactionsResponseData> {
    override val operationName: String = "Web_FindMatchTransactions"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val search: String?,
        val limit: Int,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("search" to input.search, "limit" to input.limit)

    override fun parseOutput(data: JsonNode): MatchSearchTransactionsResponseData =
        MatchSearchTransactionsResponseData(
            results =
                data
                    .path("allTransactions")
                    .path("results")
                    .map { t ->
                        MatchSearchTransactionsResponseDataResultsInner(
                            id = t.path("id").asText(""),
                            amount = t.path("amount").asDoubleOrNull(),
                            date = t.path("date").asTextOrNull(),
                            plaidName = t.path("plaidName").asTextOrNull(),
                            merchant =
                                t.pathOrNull("merchant")?.let { m ->
                                    MatchSearchTransactionsResponseDataResultsInnerMerchant(
                                        id = m.path("id").asTextOrNull(),
                                        name = m.path("name").asTextOrNull(),
                                    )
                                },
                            account =
                                t.pathOrNull("account")?.let { a ->
                                    MatchSearchTransactionsResponseDataResultsInnerAccount(
                                        id = a.path("id").asTextOrNull(),
                                        displayName = a.path("displayName").asTextOrNull(),
                                    )
                                },
                        )
                    },
        )
}
