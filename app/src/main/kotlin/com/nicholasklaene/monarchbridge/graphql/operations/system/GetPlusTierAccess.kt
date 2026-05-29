package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetPlusTierAccessResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Entitlements plus Plus-trial window timestamps (`plusTrialEndsAt`, `canceledPlusTrialAt`). */
object GetPlusTierAccess : MonarchOperation<Unit, GetPlusTierAccessResponseData> {
    override val operationName: String = "Common_GetPlusTierAccess"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetPlusTierAccessResponseData {
        val sub = data.path("subscription")
        return GetPlusTierAccessResponseData(
            id = sub.path("id").asText(""),
            entitlements = sub.path("entitlements").map { it.asText("") },
            plusTrialEndsAt = sub.path("plusTrialEndsAt").asTextOrNull(),
            canceledPlusTrialAt = sub.path("canceledPlusTrialAt").asTextOrNull(),
        )
    }
}
