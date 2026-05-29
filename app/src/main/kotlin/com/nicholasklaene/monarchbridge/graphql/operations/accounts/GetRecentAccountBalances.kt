package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetNetworthRecentResponseData
import com.nicholasklaene.monarchbridge.generated.model.RecentAccountBalances
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Per-account recent balance fluctuations since [Input.startDate]. Output is the spec-generated [GetNetworthRecentResponseData]. */
object GetRecentAccountBalances : MonarchOperation<GetRecentAccountBalances.Input, GetNetworthRecentResponseData> {
    override val operationName: String = "GetAccountRecentBalances"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("startDate" to input.startDate)

    override fun parseOutput(data: JsonNode): GetNetworthRecentResponseData =
        GetNetworthRecentResponseData(
            accounts =
                data.path("accounts").map {
                    RecentAccountBalances(
                        id = it.path("id").asText(""),
                        displayName = it.path("displayName").asTextOrNull(),
                        recentBalances = it.path("recentBalances").mapNotNull { v -> v.asDoubleOrNull() },
                    )
                },
        )
}
