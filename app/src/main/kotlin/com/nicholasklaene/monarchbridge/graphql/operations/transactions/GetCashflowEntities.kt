package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CashflowCategoryGroupRef
import com.nicholasklaene.monarchbridge.generated.model.CashflowCategoryGroupRow
import com.nicholasklaene.monarchbridge.generated.model.CashflowCategoryRef
import com.nicholasklaene.monarchbridge.generated.model.CashflowEntityCategoryRow
import com.nicholasklaene.monarchbridge.generated.model.CashflowMerchantRef
import com.nicholasklaene.monarchbridge.generated.model.CashflowMerchantRow
import com.nicholasklaene.monarchbridge.generated.model.CashflowSummary
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowEntitiesResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull
import java.time.LocalDate

/**
 * Cashflow grouped three ways (by category, by category-group, by merchant) plus a
 * summary aggregate. Great for "where did my money go" style prompts.
 */
object GetCashflowEntities : MonarchOperation<GetCashflowEntities.Input, GetCashflowEntitiesResponseData> {
    override val operationName: String = "Common_GetCashFlowEntityAggregates"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: LocalDate?,
        val endDate: LocalDate?,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "filters" to
                mutableMapOf<String, Any?>().apply {
                    input.startDate?.let { put("startDate", it.toString()) }
                    input.endDate?.let { put("endDate", it.toString()) }
                },
        )

    override fun parseOutput(data: JsonNode): GetCashflowEntitiesResponseData =
        GetCashflowEntitiesResponseData(
            byCategory = parseByCategory(data.path("byCategory")),
            byCategoryGroup = parseByCategoryGroup(data.path("byCategoryGroup")),
            byMerchant = parseByMerchant(data.path("byMerchant")),
            summary =
                data.pathOrNull("summary")?.let { s ->
                    val summaryNode = s.path("summary")
                    CashflowSummary(
                        sumIncome = summaryNode.path("sumIncome").asDoubleOrNull(),
                        sumExpense = summaryNode.path("sumExpense").asDoubleOrNull(),
                        savings = summaryNode.path("savings").asDoubleOrNull(),
                        savingsRate = summaryNode.path("savingsRate").asDoubleOrNull(),
                    )
                },
        )

    internal fun parseByCategory(node: JsonNode): List<CashflowEntityCategoryRow> =
        node.map { agg ->
            val cat = agg.path("groupBy").path("category")
            CashflowEntityCategoryRow(
                category =
                    CashflowCategoryRef(
                        id = cat.path("id").asText(""),
                        name = cat.path("name").asTextOrNull(),
                        icon = cat.path("icon").asTextOrNull(),
                        groupId = cat.path("group").path("id").asTextOrNull(),
                        groupType = cat.path("group").path("type").asTextOrNull(),
                    ),
                sum = agg.path("summary").path("sum").asDoubleOrNull(),
            )
        }

    internal fun parseByCategoryGroup(node: JsonNode): List<CashflowCategoryGroupRow> =
        node.map { agg ->
            val cg = agg.path("groupBy").path("categoryGroup")
            CashflowCategoryGroupRow(
                categoryGroup =
                    CashflowCategoryGroupRef(
                        id = cg.path("id").asText(""),
                        name = cg.path("name").asTextOrNull(),
                        type = cg.path("type").asTextOrNull(),
                    ),
                sum = agg.path("summary").path("sum").asDoubleOrNull(),
            )
        }

    internal fun parseByMerchant(node: JsonNode): List<CashflowMerchantRow> =
        node.map { agg ->
            val m = agg.path("groupBy").path("merchant")
            CashflowMerchantRow(
                merchant =
                    CashflowMerchantRef(
                        id = m.path("id").asText(""),
                        name = m.path("name").asTextOrNull(),
                        logoUrl = m.path("logoUrl").asTextOrNull(),
                    ),
                sumIncome = agg.path("summary").path("sumIncome").asDoubleOrNull(),
                sumExpense = agg.path("summary").path("sumExpense").asDoubleOrNull(),
            )
        }
}
