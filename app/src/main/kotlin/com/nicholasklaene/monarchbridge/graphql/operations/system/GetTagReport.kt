package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTagReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.TagReport
import com.nicholasklaene.monarchbridge.generated.model.TagReportMonth
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Historical per-month series for one transaction tag. Each month carries both the sum
 * amount and the transaction count, so callers can render either a spend chart or a
 * frequency chart from one response.
 */
object GetTagReport : MonarchOperation<GetTagReport.Input, GetTagReportResponseData> {
    override val operationName: String = "Web_GetTagReport"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val tagId: String,
        val startDate: LocalDate? = null,
        val endDate: LocalDate? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "tagId" to input.tagId,
            "startDate" to input.startDate?.toString(),
            "endDate" to input.endDate?.toString(),
        )

    override fun parseOutput(data: JsonNode): GetTagReportResponseData {
        val node = data.path("tagReport")
        return GetTagReportResponseData(
            report =
                TagReport(
                    tagId = node.path("tagId").asText(""),
                    tagName = node.path("tagName").asTextOrNull(),
                    totalAmount = node.path("totalAmount").asDoubleOrNull(),
                    transactionCount = node.path("transactionCount").asIntOrNull(),
                    months =
                        node.path("months").map { m ->
                            TagReportMonth(
                                month = m.path("month").asTextOrNull(),
                                amount = m.path("amount").asDoubleOrNull(),
                                count = m.path("count").asIntOrNull(),
                            )
                        },
                ),
        )
    }
}
