package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetEntitlementsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/** Subscription entitlement keys + subscription id (used to gate Plus-only flows). */
object GetEntitlements : MonarchOperation<Unit, GetEntitlementsResponseData> {
    override val operationName: String = "Common_GetEntitlements"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetEntitlementsResponseData {
        val sub = data.path("subscription")
        return GetEntitlementsResponseData(
            id = sub.path("id").asText(""),
            entitlements = sub.path("entitlements").map { it.asText("") },
        )
    }
}
