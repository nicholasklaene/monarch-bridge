package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Poll Monarch for the current parse status of a balance-history upload session. Clients
 * call this on a loop until `status == "completed"` (or `"failed"`). Output reuses the
 * package-level [SessionStatus] shared with [ParseUploadBalanceHistorySession].
 */
object GetUploadBalanceHistorySession :
    MonarchOperation<GetUploadBalanceHistorySession.Input, SessionStatus> {
    override val operationName: String = "Web_GetUploadBalanceHistorySession"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val sessionKey: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("sessionKey" to input.sessionKey)

    override fun parseOutput(data: JsonNode): SessionStatus {
        val session = data.path("uploadBalanceHistorySession")
        return SessionStatus(
            sessionKey = session.path("sessionKey").asText(""),
            status = session.path("status").asText("unknown"),
        )
    }
}
