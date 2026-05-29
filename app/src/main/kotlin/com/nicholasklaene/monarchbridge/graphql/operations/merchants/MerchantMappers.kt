package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.Merchant
import com.nicholasklaene.monarchbridge.generated.model.MerchantRecurringStream
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull

/**
 * Shared parser for merchant nodes. The search variants only populate `id`, `name`,
 * `transactionCount`, and (with logos) `logoUrl`; the edit / detail query also fills
 * `ruleCount`, `canBeDeleted`, `hasActiveRecurringStreams`, and the recurring stream.
 * Every field is read defensively so the same mapper works for all variants.
 */
internal object MerchantMappers {
    fun parseMerchant(node: JsonNode): Merchant =
        Merchant(
            id = node.path("id").asText(""),
            name = node.path("name").asText(""),
            logoUrl = node.path("logoUrl").asTextOrNull(),
            transactionCount = node.path("transactionCount").asIntOrNull(),
            ruleCount = node.path("ruleCount").asIntOrNull(),
            canBeDeleted = node.path("canBeDeleted").asBooleanOrNull(),
            hasActiveRecurringStreams = node.path("hasActiveRecurringStreams").asBooleanOrNull(),
            recurringTransactionStream =
                node.pathOrNull("recurringTransactionStream")?.let { r ->
                    MerchantRecurringStream(
                        id = r.path("id").asTextOrNull(),
                        frequency = r.path("frequency").asTextOrNull(),
                        amount = r.path("amount").asDoubleOrNull(),
                        baseDate = r.path("baseDate").asTextOrNull(),
                        isActive = r.path("isActive").asBooleanOrNull(),
                    )
                },
        )
}
