package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.FiscalYearPreferences
import com.nicholasklaene.monarchbridge.generated.model.GetFiscalYearResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull

/** Household fiscal-year start month + day (drives year-to-date rollups in reports). */
object GetFiscalYear : MonarchOperation<Unit, GetFiscalYearResponseData> {
    override val operationName: String = "Common_GetFiscalYearPreferences"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetFiscalYearResponseData {
        val node = data.path("fiscalYearPreferences")
        return GetFiscalYearResponseData(
            fiscalYear =
                FiscalYearPreferences(
                    startMonth = node.path("startMonth").asIntOrNull(),
                    startDay = node.path("startDay").asIntOrNull(),
                ),
        )
    }
}
