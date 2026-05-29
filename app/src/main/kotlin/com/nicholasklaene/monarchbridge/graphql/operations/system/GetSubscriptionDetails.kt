package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.SubscriptionDetails
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Monarch subscription tier + payment source. Output is the spec-generated [SubscriptionDetails]. */
object GetSubscriptionDetails : MonarchOperation<Unit, SubscriptionDetails> {
    override val operationName: String = "GetSubscriptionDetails"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): SubscriptionDetails {
        val s = data.path("subscription")
        return SubscriptionDetails(
            isOnFreeTrial = s.path("isOnFreeTrial").asBoolean(false),
            hasPremiumEntitlement = s.path("hasPremiumEntitlement").asBoolean(false),
            id = s.path("id").asTextOrNull(),
            paymentSource = s.path("paymentSource").asTextOrNull(),
            referralCode = s.path("referralCode").asTextOrNull(),
        )
    }
}
