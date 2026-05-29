package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetDownloadTransactionsSessionResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Poll for a transactions CSV download session. When complete, `url` is non-null. */
object GetDownloadTransactionsSession :
    MonarchOperation<GetDownloadTransactionsSession.Input, GetDownloadTransactionsSessionResponseData> {
    override val operationName: String = "Web_GetDownloadTransactionsSession"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val sessionKey: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("sessionKey" to input.sessionKey)

    override fun parseOutput(data: JsonNode): GetDownloadTransactionsSessionResponseData {
        val node = data.path("downloadTransactionsSession")
        return GetDownloadTransactionsSessionResponseData(
            sessionKey = node.path("sessionKey").asText(""),
            status = node.path("status").asTextOrNull(),
            errorMessage = node.path("errorMessage").asTextOrNull(),
            url = node.path("url").asTextOrNull(),
        )
    }
}
