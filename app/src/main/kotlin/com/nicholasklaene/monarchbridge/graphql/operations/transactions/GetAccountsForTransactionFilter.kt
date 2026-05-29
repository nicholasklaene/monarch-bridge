package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.AccountForFilterRow
import com.nicholasklaene.monarchbridge.generated.model.GetAccountsForTransactionFilterResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Accounts that match a transaction filter. Used by bulk-edit / bulk-delete UI to
 * preview which accounts would be touched. Filter here is date-range only for simplicity.
 */
object GetAccountsForTransactionFilter :
    MonarchOperation<GetAccountsForTransactionFilter.Input, GetAccountsForTransactionFilterResponseData> {
    override val operationName: String = "Common_GetAccountsForTransactions"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: LocalDate?,
        val endDate: LocalDate?,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "selectedTransactionIds" to null,
            "excludedTransactionIds" to null,
            "isAllSelected" to true,
            "filters" to
                mutableMapOf<String, Any?>().apply {
                    input.startDate?.let { put("startDate", it.toString()) }
                    input.endDate?.let { put("endDate", it.toString()) }
                },
        )

    override fun parseOutput(data: JsonNode): GetAccountsForTransactionFilterResponseData =
        GetAccountsForTransactionFilterResponseData(
            accounts =
                data.path("getAccountsForTransactions").map { a ->
                    AccountForFilterRow(
                        id = a.path("id").asText(""),
                        displayName = a.path("displayName").asTextOrNull(),
                        dataProvider = a.path("dataProvider").asTextOrNull(),
                        icon = a.path("icon").asTextOrNull(),
                        logoUrl = a.path("logoUrl").asTextOrNull(),
                        typeName = a.path("type").path("name").asTextOrNull(),
                        typeDisplay = a.path("type").path("display").asTextOrNull(),
                        subtypeName = a.path("subtype").path("name").asTextOrNull(),
                        institutionId = a.path("institution").path("id").asTextOrNull(),
                        institutionLogo = a.path("institution").path("logo").asTextOrNull(),
                        institutionPrimaryColor = a.path("institution").path("primaryColor").asTextOrNull(),
                    )
                },
        )
}
