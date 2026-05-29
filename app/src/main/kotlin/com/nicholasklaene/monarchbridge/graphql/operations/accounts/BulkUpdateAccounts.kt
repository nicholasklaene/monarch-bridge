package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.Account
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateAccountsEntry
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateAccountsRequest
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateAccountsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.JsonMappers
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/**
 * Wraps Monarch's `updateAccounts` mutation (operationName `Common_BulkUpdateAccounts`).
 * Takes a list of `UpdateAccountsMutationInput` entries — each entry must include `id` plus
 * any subset of the patchable account fields.
 *
 * Output is the spec-generated [BulkUpdateAccountsResponseData] containing the updated
 * `accounts[]`. Errors are dropped here; the controller layer surfaces `PayloadError` via
 * the global `MonarchPayloadErrorException` path the way the single-row mutations do.
 */
object BulkUpdateAccounts : MonarchOperation<BulkUpdateAccounts.Input, BulkUpdateAccountsResponseData> {
    override val operationName: String = "Common_BulkUpdateAccounts"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("AccountFields", "PayloadErrorFields"))
    }

    data class Input(
        val entries: List<Map<String, Any?>>,
    ) {
        companion object {
            fun from(req: BulkUpdateAccountsRequest): Input = Input(entries = req.updates.map(::entryMap))

            internal fun entryMap(e: BulkUpdateAccountsEntry): Map<String, Any?> =
                mapOfNotNull(
                    "id" to e.id,
                    "name" to e.name,
                    "displayBalance" to e.displayBalance,
                    "type" to e.type,
                    "subtype" to e.subtype,
                    "includeInNetWorth" to e.includeInNetWorth,
                    "hideFromList" to e.hideFromList,
                    "hideTransactionsFromReports" to e.hideTransactionsFromReports,
                    "excludeFromDebtPaydown" to e.excludeFromDebtPaydown,
                    "includeInGoalBalance" to e.includeInGoalBalance,
                    "invertSyncedBalance" to e.invertSyncedBalance,
                    "currentBalance" to e.currentBalance,
                    "apr" to e.apr,
                    "interestRate" to e.interestRate,
                    "limit" to e.limit,
                    "minimumPayment" to e.minimumPayment,
                    "plannedPayment" to e.plannedPayment,
                    "useAvailableBalance" to e.useAvailableBalance,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to input.entries)

    override fun parseOutput(data: JsonNode): BulkUpdateAccountsResponseData {
        val accountsNode = data.path("updateAccounts").path("accounts")
        val accounts: List<Account> =
            if (accountsNode.isArray) accountsNode.map(JsonMappers::parseAccount) else emptyList()
        return BulkUpdateAccountsResponseData(accounts = accounts)
    }
}
