package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Pokes Monarch to re-poll Plaid. Empty `accountIds` = refresh ALL linked accounts;
 * a non-empty list = refresh only those accounts. Mirrors the python lib's
 * `request_accounts_refresh(account_ids: List[str])` signature.
 */
object ForceRefreshAccounts : MonarchOperation<ForceRefreshAccounts.Input, ForceRefreshAccounts.Output> {
    override val operationName: String = "Common_ForceRefreshAccountsMutation"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    /** Optional per-account scope. Empty list = refresh all linked accounts. */
    data class Input(
        val accountIds: List<String> = emptyList(),
    )

    /** `true` if Monarch accepted the refresh request. */
    data class Output(
        val success: Boolean,
    )

    // Monarch's `ForceRefreshAccountsInput!` is non-nullable AND `accountIds: null`
    // is rejected with a generic 400; empirically only `accountIds: []` or a populated
    // list works. Empty array = refresh all linked accounts.
    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("accountIds" to input.accountIds))

    override fun parseOutput(data: JsonNode): Output = Output(success = data.path("forceRefreshAccounts").path("success").asBoolean(false))
}
