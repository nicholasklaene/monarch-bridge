package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetAccountBalanceAtDateResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * "What was this account worth on YYYY-MM-DD." Monarch's `displayBalance(date:)` resolver
 * walks back through the snapshot series to return the displayed (sign-adjusted) balance
 * as of the requested date. Filtered to one account via `AccountFilters.ids`.
 */
object GetDisplayBalanceAtDate :
    MonarchOperation<GetDisplayBalanceAtDate.Input, GetAccountBalanceAtDateResponseData> {
    override val operationName: String = "Common_GetDisplayBalanceAtDate"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val accountId: String,
        val date: LocalDate,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "date" to input.date.toString(),
            "filters" to mapOf("ids" to listOf(input.accountId)),
        )

    override fun parseOutput(data: JsonNode): GetAccountBalanceAtDateResponseData {
        val account = data.path("accounts").firstOrNull()
        return GetAccountBalanceAtDateResponseData(
            id = account?.path("id")?.asText("") ?: "",
            displayBalance = account?.path("displayBalance")?.asDoubleOrNull(),
            includeInNetWorth = account?.path("includeInNetWorth")?.asBoolean(false) ?: false,
            accountType = account?.path("type")?.path("name")?.asTextOrNull(),
        )
    }
}
