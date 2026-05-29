package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetMyHouseholdResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Household-level metadata (name, mailing address). One row per Monarch household. */
object GetMyHousehold : MonarchOperation<Unit, GetMyHouseholdResponseData> {
    override val operationName: String = "Common_GetMyHousehold"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetMyHouseholdResponseData {
        val h = data.path("myHousehold")
        return GetMyHouseholdResponseData(
            id = h.path("id").asText(""),
            name = h.path("name").asTextOrNull(),
            address = h.path("address").asTextOrNull(),
            city = h.path("city").asTextOrNull(),
            state = h.path("state").asTextOrNull(),
            zipCode = h.path("zipCode").asTextOrNull(),
            country = h.path("country").asTextOrNull(),
        )
    }
}
