package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.PreviewAccountBalanceResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull

/** Preview the display balance an account would show with edit-form toggles applied. */
object PreviewAccountBalance :
    MonarchOperation<PreviewAccountBalance.Input, PreviewAccountBalanceResponseData> {
    override val operationName: String = "Common_GetDisplayBalancePreview"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val accountId: String,
        val invertSyncedBalance: Boolean?,
        val useAvailableBalance: Boolean?,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "accountId" to input.accountId,
            "invertSyncedBalance" to input.invertSyncedBalance,
            "useAvailableBalance" to input.useAvailableBalance,
        )

    override fun parseOutput(data: JsonNode): PreviewAccountBalanceResponseData {
        val node = data.path("account")
        return PreviewAccountBalanceResponseData(
            id = node.path("id").asText(""),
            displayBalancePreview = node.path("displayBalancePreview").asDoubleOrNull(),
        )
    }
}
