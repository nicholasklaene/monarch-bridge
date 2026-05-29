package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.AttachmentDetail
import com.nicholasklaene.monarchbridge.generated.model.GetAttachmentResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Resolve one attachment id to its `originalAssetUrl` (a pre-signed download URL).
 * Pair with the existing attachment upload + transaction-list endpoints to round-trip
 * receipt-style assets without hitting Monarch's GraphQL layer directly.
 */
object GetAttachment : MonarchOperation<GetAttachment.Input, GetAttachmentResponseData> {
    override val operationName: String = "Mobile_GetAttachmentDetails"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val attachmentId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("attachmentId" to input.attachmentId)

    override fun parseOutput(data: JsonNode): GetAttachmentResponseData {
        val node = data.path("transactionAttachment")
        return GetAttachmentResponseData(
            attachment =
                AttachmentDetail(
                    id = node.path("id").asText(""),
                    originalAssetUrl = node.path("originalAssetUrl").asTextOrNull(),
                ),
        )
    }
}
