package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetSubscriptionDetailsResponseData
import com.nicholasklaene.monarchbridge.generated.model.SubscriptionFullDetails
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Full subscription detail bundle (Settings - Billing - Plan). Distinct from the slim
 * [GetSubscriptionDetails] query: this one carries tier, status, renewal date,
 * billing frequency, the current amount, currency, payment method, and trial-ends-at.
 */
object GetSubscriptionFullDetails : MonarchOperation<Unit, GetSubscriptionDetailsResponseData> {
    override val operationName: String = "Common_GetSubscriptionFullDetails"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetSubscriptionDetailsResponseData {
        val s = data.path("subscription")
        return GetSubscriptionDetailsResponseData(
            details =
                SubscriptionFullDetails(
                    tier = s.path("tier").asTextOrNull(),
                    status = s.path("status").asTextOrNull(),
                    renewalDate = s.path("renewalDate").asTextOrNull()?.let { java.time.LocalDate.parse(it) },
                    billingFrequency = s.path("billingFrequency").asTextOrNull(),
                    amount = s.path("amount").asDoubleOrNull(),
                    currency = s.path("currency").asTextOrNull(),
                    paymentMethod = s.path("paymentMethod").asTextOrNull(),
                    trialEndsAt = s.path("trialEndsAt").asTextOrNull(),
                ),
        )
    }
}
