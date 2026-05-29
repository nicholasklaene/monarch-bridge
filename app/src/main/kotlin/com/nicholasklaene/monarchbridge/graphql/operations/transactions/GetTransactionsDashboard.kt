package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DashboardTransactionRow
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionsDashboardResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Dashboard transactions list. Includes totals (totalCount, totalSelectableCount),
 * rule count, and per-row merchant/category/account refs.
 */
object GetTransactionsDashboard :
    MonarchOperation<GetTransactionsDashboard.Input, GetTransactionsDashboardResponseData> {
    override val operationName: String = "Common_GetTransactionsListDashboard"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: LocalDate?,
        val endDate: LocalDate?,
        val limit: Int?,
        val offset: Int?,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "limit" to input.limit,
            "offset" to input.offset,
            "filters" to
                mutableMapOf<String, Any?>().apply {
                    input.startDate?.let { put("startDate", it.toString()) }
                    input.endDate?.let { put("endDate", it.toString()) }
                },
        )

    override fun parseOutput(data: JsonNode): GetTransactionsDashboardResponseData {
        val txs = data.path("allTransactions")
        return GetTransactionsDashboardResponseData(
            totalCount = txs.path("totalCount").asIntOrNull(),
            totalSelectableCount = txs.path("totalSelectableCount").asIntOrNull(),
            ruleCount = data.path("transactionRules").takeIf { it.isArray }?.size(),
            summaryCount =
                data
                    .path("aggregates")
                    .path("summary")
                    .path("count")
                    .asIntOrNull(),
            results =
                txs.path("results").map { r ->
                    DashboardTransactionRow(
                        id = r.path("id").asText(""),
                        date = r.path("date").asTextOrNull()?.let(LocalDate::parse),
                        amount = r.path("amount").asDoubleOrNull(),
                        notes = r.path("notes").asTextOrNull(),
                        plaidName = r.path("plaidName").asTextOrNull(),
                        merchantName = r.path("merchant").path("name").asTextOrNull(),
                        categoryName = r.path("category").path("name").asTextOrNull(),
                        accountDisplayName = r.path("account").path("displayName").asTextOrNull(),
                    )
                },
        )
    }
}
