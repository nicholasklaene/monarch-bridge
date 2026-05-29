package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.BudgetTimelineMonth
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetTimelineResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull
import java.time.LocalDate

/** Month-by-month budget vs. actual rollup over a window. */
object GetBudgetTimeline : MonarchOperation<GetBudgetTimeline.Input, GetBudgetTimelineResponseData> {
    override val operationName: String = "Web_GetBudgetTimeline"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startMonth: LocalDate,
        val monthCount: Int? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOfNotNull(
            "startMonth" to input.startMonth.toString(),
            "monthCount" to input.monthCount,
        )

    override fun parseOutput(data: JsonNode): GetBudgetTimelineResponseData =
        GetBudgetTimelineResponseData(
            months =
                data.path("budgetTimeline").path("months").map { m ->
                    BudgetTimelineMonth(
                        month = m.path("month").asTextOrNull(),
                        totalBudget = m.path("totalBudget").asDoubleOrNull(),
                        totalActual = m.path("totalActual").asDoubleOrNull(),
                        varianceAmount = m.path("varianceAmount").asDoubleOrNull(),
                        variancePercent = m.path("variancePercent").asDoubleOrNull(),
                    )
                },
        )
}
