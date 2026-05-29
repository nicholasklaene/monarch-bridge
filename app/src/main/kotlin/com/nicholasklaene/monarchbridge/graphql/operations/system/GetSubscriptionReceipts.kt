package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetSubscriptionReceiptsResponseData
import com.nicholasklaene.monarchbridge.generated.model.SubscriptionReceipt
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Subscription receipts (renewal-by-renewal). Each receipt has an issue date,
 * amount, currency, and a download URL for the PDF.
 *
 * Lighter than the per-invoice view: just the renewal-summary records.
 */
object GetSubscriptionReceipts : MonarchOperation<Unit, GetSubscriptionReceiptsResponseData> {
    override val operationName: String = "Common_GetSubscriptionReceipts"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetSubscriptionReceiptsResponseData =
        GetSubscriptionReceiptsResponseData(
            receipts =
                data.path("subscriptionReceipts").map { r ->
                    SubscriptionReceipt(
                        id = r.path("id").asText(""),
                        issueDate = r.path("issueDate").asTextOrNull()?.let { java.time.LocalDate.parse(it) },
                        amount = r.path("amount").asDoubleOrNull(),
                        currency = r.path("currency").asTextOrNull(),
                        downloadUrl = r.path("downloadUrl").asTextOrNull(),
                    )
                },
        )
}
