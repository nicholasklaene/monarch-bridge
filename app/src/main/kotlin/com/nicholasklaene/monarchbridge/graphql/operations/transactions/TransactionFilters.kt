package com.nicholasklaene.monarchbridge.graphql.operations.transactions

/**
 * Shared `TransactionFilterInput` shape used by [GetTransactions], [GetTransactionsSummary],
 * [GetCashflowSummary], and [GetCashflowBreakdown]. Mirrors the python community lib
 * (bradleyseanf/monarchmoneycommunity) `get_transactions(...)` args exactly so any caller
 * that knows the python interface gets the same Monarch behavior here.
 *
 * Build the GraphQL `filters` map via [toFiltersMap]: pre-populate `search` + the three id
 * lists with defaults, merge the legacy single [accountId] into `accounts`, then
 * conditionally add each nullable boolean / visibility only when the caller set it.
 */
@Suppress("LongParameterList")
data class TransactionFilters(
    val startDate: String? = null,
    val endDate: String? = null,
    val search: String = "",
    val categoryIds: List<String> = emptyList(),
    /**
     * Legacy single-account filter. Merged with [accountIds] into a single `accounts` list,
     * de-duped + order-preserving. Both parameters are accepted on every endpoint for
     * back-compat with pre-multi-account callers.
     */
    val accountId: String? = null,
    val accountIds: List<String> = emptyList(),
    val tagIds: List<String> = emptyList(),
    val hasAttachments: Boolean? = null,
    val hasNotes: Boolean? = null,
    val hideFromReports: Boolean? = null,
    val isSplit: Boolean? = null,
    val isRecurring: Boolean? = null,
    val importedFromMint: Boolean? = null,
    val syncedFromInstitution: Boolean? = null,
    val needsReview: Boolean? = null,
    /** `"hidden_transactions_only"` | `"all_transactions"`. Null = non-hidden only (Monarch default). */
    val transactionVisibility: String? = null,
) {
    /**
     * Build the GraphQL `filters` map. Date fields are emitted only when set so summary /
     * cashflow operations (which support windowless aggregates) can omit them.
     */
    @Suppress("CyclomaticComplexMethod") // Linear nullable-bool fan-out, no branches inside branches.
    fun toFiltersMap(): Map<String, Any?> =
        buildMap {
            if (startDate != null) put("startDate", startDate)
            if (endDate != null) put("endDate", endDate)
            put("search", search)
            put("categories", categoryIds)
            put("accounts", mergeAccountFilter(accountId, accountIds))
            put("tags", tagIds)
            if (hasAttachments != null) put("hasAttachments", hasAttachments)
            if (hasNotes != null) put("hasNotes", hasNotes)
            if (hideFromReports != null) put("hideFromReports", hideFromReports)
            if (isSplit != null) put("isSplit", isSplit)
            if (isRecurring != null) put("isRecurring", isRecurring)
            if (importedFromMint != null) put("importedFromMint", importedFromMint)
            if (syncedFromInstitution != null) put("syncedFromInstitution", syncedFromInstitution)
            if (needsReview != null) put("needsReview", needsReview)
            if (transactionVisibility != null) put("transactionVisibility", transactionVisibility)
        }

    companion object {
        /** Merge the legacy single-id form with the multi-id list, de-duped + order-preserving. */
        internal fun mergeAccountFilter(
            legacy: String?,
            multi: List<String>,
        ): List<String> =
            when {
                legacy == null -> multi
                multi.isEmpty() -> listOf(legacy)
                legacy in multi -> multi
                else -> listOf(legacy) + multi
            }
    }
}
