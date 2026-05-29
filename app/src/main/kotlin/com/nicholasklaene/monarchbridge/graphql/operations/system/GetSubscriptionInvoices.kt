package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetSubscriptionInvoicesResponseData
import com.nicholasklaene.monarchbridge.generated.model.SubscriptionInvoice
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Billing history rows shown on the Settings → Billing page. Each row is one charge
 * (monthly / annual / proration) with status, amount, and the PDF receipt URL.
 *
 * `status` values seen in production: `paid`, `pending`, `failed`, `refunded`.
 */
object GetSubscriptionInvoices : MonarchOperation<Unit, GetSubscriptionInvoicesResponseData> {
    override val operationName: String = "Common_GetSubscriptionInvoices"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetSubscriptionInvoicesResponseData =
        GetSubscriptionInvoicesResponseData(
            invoices =
                data.path("subscriptionInvoices").map { i ->
                    SubscriptionInvoice(
                        id = i.path("id").asText(""),
                        date = i.path("date").asTextOrNull(),
                        amount = i.path("amount").asDoubleOrNull(),
                        status = i.path("status").asTextOrNull(),
                        pdfUrl = i.path("pdfUrl").asTextOrNull(),
                        periodStart = i.path("periodStart").asTextOrNull(),
                        periodEnd = i.path("periodEnd").asTextOrNull(),
                    )
                },
        )
}
