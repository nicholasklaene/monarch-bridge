package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Trigger Monarch's parse of a balance-history upload session. Run this right after the
 * multipart CSV POST to `/account-balance-history/upload/`. Returns the same
 * [SessionStatus] shape that [GetUploadBalanceHistorySession] returns when polling.
 */
object ParseUploadBalanceHistorySession :
    MonarchOperation<ParseUploadBalanceHistorySession.Input, SessionStatus> {
    override val operationName: String = "Web_ParseUploadBalanceHistorySession"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val sessionKey: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("sessionKey" to input.sessionKey))

    override fun parseOutput(data: JsonNode): SessionStatus {
        val session = data.path("parseBalanceHistory").path("uploadBalanceHistorySession")
        return SessionStatus(
            sessionKey = session.path("sessionKey").asText(""),
            status = session.path("status").asText("unknown"),
        )
    }
}
