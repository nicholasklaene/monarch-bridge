package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.FiscalYearPreferences
import com.nicholasklaene.monarchbridge.generated.model.SetFiscalYearRequest
import com.nicholasklaene.monarchbridge.generated.model.SetFiscalYearResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/** Set the household fiscal-year start (month required 1-12, day optional 1-31). */
object SetFiscalYear : MonarchOperation<SetFiscalYear.Input, SetFiscalYearResponseData> {
    override val operationName: String = "Common_SetFiscalYearPreferences"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val startMonth: Int,
        val startDay: Int? = null,
    ) {
        companion object {
            fun from(req: SetFiscalYearRequest): Input =
                Input(
                    startMonth = req.startMonth,
                    startDay = req.startDay,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOfNotNull(
                    "startMonth" to input.startMonth,
                    "startDay" to input.startDay,
                ),
        )

    override fun parseOutput(data: JsonNode): SetFiscalYearResponseData {
        val node = data.path("setFiscalYearPreferences").path("fiscalYearPreferences")
        return SetFiscalYearResponseData(
            fiscalYear =
                FiscalYearPreferences(
                    startMonth = node.path("startMonth").asIntOrNull(),
                    startDay = node.path("startDay").asIntOrNull(),
                ),
        )
    }
}
