package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.TransactionAttachment
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Step 3 of the three-step `upload_attachment` flow. After Cloudinary accepts the binary,
 * call this mutation to link the upload (by `publicId`) to the transaction; Monarch records
 * it as an attachment and hands back a durable [TransactionAttachment] reference.
 */
object AddTransactionAttachment : MonarchOperation<AddTransactionAttachment.Input, TransactionAttachment> {
    override val operationName: String = "Common_AddTransactionAttachment"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val transactionId: String,
        val filename: String,
        val publicId: String,
        val extension: String,
        val sizeBytes: Int,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "extension" to input.extension,
                    "transactionId" to input.transactionId,
                    "filename" to input.filename,
                    "publicId" to input.publicId,
                    "sizeBytes" to input.sizeBytes,
                ),
        )

    override fun parseOutput(data: JsonNode): TransactionAttachment {
        val a = data.path("addTransactionAttachment").path("attachment")
        return TransactionAttachment(
            id = a.path("id").asText(""),
            publicId = a.path("publicId").asTextOrNull(),
            extension = a.path("extension").asTextOrNull(),
            sizeBytes = a.path("sizeBytes").asIntOrNull(),
            filename = a.path("filename").asTextOrNull(),
            originalAssetUrl = a.path("originalAssetUrl").asTextOrNull(),
        )
    }
}
