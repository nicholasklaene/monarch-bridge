package com.nicholasklaene.monarchbridge.graphql.operations.accounts

/**
 * Snapshot of a Monarch balance-history upload session. Returned both by the parse trigger
 * [ParseUploadBalanceHistorySession] and by the status-poll [GetUploadBalanceHistorySession].
 */
data class SessionStatus(
    val sessionKey: String,
    val status: String,
)
