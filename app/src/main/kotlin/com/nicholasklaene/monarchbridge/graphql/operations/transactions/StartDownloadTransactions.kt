package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.StartDownloadTransactionsRequest
import com.nicholasklaene.monarchbridge.generated.model.StartDownloadTransactionsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Start the async transactions-CSV download job. Returns a session key for polling. */
object StartDownloadTransactions :
    MonarchOperation<StartDownloadTransactions.Input, StartDownloadTransactionsResponseData> {
    override val operationName: String = "Web_DownloadTransactions"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val filters: Map<String, Any>,
        val orderBy: String?,
    ) {
        companion object {
            fun from(req: StartDownloadTransactionsRequest): Input = Input(filters = req.filters ?: emptyMap(), orderBy = req.orderBy)
        }
    }

    override fun variables(input: Input): Map<String, Any?> = mapOf("filters" to input.filters, "orderBy" to input.orderBy)

    override fun parseOutput(data: JsonNode): StartDownloadTransactionsResponseData {
        val node = data.path("startDownloadTransactionsSession")
        return StartDownloadTransactionsResponseData(
            sessionKey = node.path("sessionKey").asText(""),
            status = node.path("status").asTextOrNull(),
        )
    }
}
