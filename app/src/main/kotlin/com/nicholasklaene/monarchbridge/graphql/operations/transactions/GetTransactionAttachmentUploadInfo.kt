package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Step 1 of the three-step `upload_attachment` flow. Asks Monarch for a signed Cloudinary
 * upload URL plus the form fields (timestamp, folder, signature, api_key, upload_preset)
 * that Cloudinary needs to accept the file. The proxy then forwards the file to
 * [UploadInfo.cloudinaryPath] using [com.nicholasklaene.monarchbridge.graphql.MonarchClient.uploadToExternal].
 */
object GetTransactionAttachmentUploadInfo :
    MonarchOperation<GetTransactionAttachmentUploadInfo.Input, GetTransactionAttachmentUploadInfo.UploadInfo> {
    override val operationName: String = "Common_GetTransactionAttachmentUploadInfo"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val transactionId: String,
    )

    /**
     * Cloudinary signed-upload params. [cloudinaryPath] is the full URL (e.g.
     * `https://api.cloudinary.com/v1_1/monarch-money/image/upload/`); the rest are form
     * fields posted alongside the file.
     */
    data class UploadInfo(
        val cloudinaryPath: String,
        val timestamp: String,
        val folder: String,
        val signature: String,
        val apiKey: String,
        val uploadPreset: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("transactionId" to input.transactionId)

    override fun parseOutput(data: JsonNode): UploadInfo {
        val info = data.path("getTransactionAttachmentUploadInfo").path("info")
        val params = info.path("requestParams")
        return UploadInfo(
            cloudinaryPath = info.path("path").asText(""),
            timestamp = params.path("timestamp").asText(""),
            folder = params.path("folder").asText(""),
            signature = params.path("signature").asText(""),
            apiKey = params.path("api_key").asText(""),
            uploadPreset = params.path("upload_preset").asText(""),
        )
    }
}
