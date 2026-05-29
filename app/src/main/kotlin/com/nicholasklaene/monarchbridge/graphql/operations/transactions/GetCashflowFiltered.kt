package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CashflowSummary
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowFilteredResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull
import java.time.LocalDate

/**
 * Filterable cashflow page: summary + timeframe (year/month/quarter) + entity
 * (category/group/merchant) breakdowns in one shot. Repeat each id-list query param.
 */
object GetCashflowFiltered : MonarchOperation<GetCashflowFiltered.Input, GetCashflowFilteredResponseData> {
    override val operationName: String = "Web_GetFilteredCashFlowPage"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: LocalDate?,
        val endDate: LocalDate?,
        val accounts: List<String>?,
        val categories: List<String>?,
        val categoryGroups: List<String>?,
        val merchants: List<String>?,
        val tags: List<String>?,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "startDate" to input.startDate?.toString(),
            "endDate" to input.endDate?.toString(),
            "accounts" to input.accounts,
            "categories" to input.categories,
            "categoryGroups" to input.categoryGroups,
            "merchants" to input.merchants,
            "tags" to input.tags,
        )

    override fun parseOutput(data: JsonNode): GetCashflowFilteredResponseData =
        GetCashflowFilteredResponseData(
            summary =
                data.pathOrNull("summary")?.path("summary")?.let { s ->
                    CashflowSummary(
                        sumIncome = s.path("sumIncome").asDoubleOrNull(),
                        sumExpense = s.path("sumExpense").asDoubleOrNull(),
                        savings = s.path("savings").asDoubleOrNull(),
                        savingsRate = s.path("savingsRate").asDoubleOrNull(),
                    )
                },
            byYear = GetCashflowTimeframe.parseBuckets(data.path("byYear"), "year"),
            byMonth = GetCashflowTimeframe.parseBuckets(data.path("byMonth"), "month"),
            byQuarter = GetCashflowTimeframe.parseBuckets(data.path("byQuarter"), "quarter"),
            byCategory = GetCashflowEntities.parseByCategory(data.path("byCategory")),
            byCategoryGroup = GetCashflowEntities.parseByCategoryGroup(data.path("byCategoryGroup")),
            byMerchant = GetCashflowEntities.parseByMerchant(data.path("byMerchant")),
        )
}
