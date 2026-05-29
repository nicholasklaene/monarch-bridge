package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CategoryReport
import com.nicholasklaene.monarchbridge.generated.model.CategoryReportMonth
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryReportResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Historical per-month series for one category. Backs the "click category -> drill down"
 * view in the web Reports tab. Returns total + monthly average; `months[].amount` is the
 * per-month sum.
 */
object GetCategoryReport : MonarchOperation<GetCategoryReport.Input, GetCategoryReportResponseData> {
    override val operationName: String = "Web_GetCategoryReport"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val categoryId: String,
        val startDate: LocalDate? = null,
        val endDate: LocalDate? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "categoryId" to input.categoryId,
            "startDate" to input.startDate?.toString(),
            "endDate" to input.endDate?.toString(),
        )

    override fun parseOutput(data: JsonNode): GetCategoryReportResponseData {
        val node = data.path("categoryReport")
        return GetCategoryReportResponseData(
            report =
                CategoryReport(
                    categoryId = node.path("categoryId").asText(""),
                    categoryName = node.path("categoryName").asTextOrNull(),
                    totalAmount = node.path("totalAmount").asDoubleOrNull(),
                    averagePerMonth = node.path("averagePerMonth").asDoubleOrNull(),
                    months =
                        node.path("months").map { m ->
                            CategoryReportMonth(
                                month = m.path("month").asTextOrNull(),
                                amount = m.path("amount").asDoubleOrNull(),
                            )
                        },
                ),
        )
    }
}
