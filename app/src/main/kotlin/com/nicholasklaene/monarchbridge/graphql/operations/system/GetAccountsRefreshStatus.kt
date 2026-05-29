package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.AccountSyncStatus
import com.nicholasklaene.monarchbridge.generated.model.GetRefreshStatusResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Per-account `hasSyncInProgress` flags. Use this after `POST /v1/refresh` to poll
 * until every account has finished re-pulling from Plaid.
 *
 * `allComplete` is true if NO account is currently syncing — i.e. the refresh is done.
 * Output is the spec-generated inner `data` payload (RefreshStatusResponse-shaped).
 */
object GetAccountsRefreshStatus : MonarchOperation<Unit, GetRefreshStatusResponseData> {
    override val operationName: String = "ForceRefreshAccountsQuery"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetRefreshStatusResponseData {
        val accounts =
            data.path("accounts").map { node ->
                AccountSyncStatus(
                    id = node.path("id").asText(""),
                    hasSyncInProgress = node.path("hasSyncInProgress").asBoolean(false),
                )
            }
        return GetRefreshStatusResponseData(
            accounts = accounts,
            allComplete = accounts.none { it.hasSyncInProgress },
        )
    }
}
