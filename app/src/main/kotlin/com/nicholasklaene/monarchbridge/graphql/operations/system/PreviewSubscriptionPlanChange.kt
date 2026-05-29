package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.PreviewSubscriptionPlanChangeRequest
import com.nicholasklaene.monarchbridge.generated.model.PreviewSubscriptionPlanChangeResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/**
 * Preview the prorated charge + new renewal date for a subscription plan change.
 * Does NOT mutate the subscription - safe to call before confirming a tier upgrade.
 */
object PreviewSubscriptionPlanChange :
    MonarchOperation<PreviewSubscriptionPlanChange.Input, PreviewSubscriptionPlanChangeResponseData> {
    override val operationName: String = "Common_PreviewSubscriptionPlanChange"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val targetTier: String,
        val billingFrequency: String? = null,
    ) {
        companion object {
            fun from(req: PreviewSubscriptionPlanChangeRequest): Input =
                Input(targetTier = req.targetTier, billingFrequency = req.billingFrequency)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOfNotNull("targetTier" to input.targetTier, "billingFrequency" to input.billingFrequency)

    override fun parseOutput(data: JsonNode): PreviewSubscriptionPlanChangeResponseData {
        val p = data.path("previewSubscriptionPlanChange")
        return PreviewSubscriptionPlanChangeResponseData(
            proratedCharge = p.path("proratedCharge").asDoubleOrNull(),
            newRenewalDate = p.path("newRenewalDate").asTextOrNull()?.let { java.time.LocalDate.parse(it) },
            currency = p.path("currency").asTextOrNull(),
            summary = p.path("summary").asTextOrNull(),
        )
    }
}
