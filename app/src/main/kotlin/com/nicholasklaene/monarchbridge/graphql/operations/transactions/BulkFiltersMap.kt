package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.nicholasklaene.monarchbridge.generated.model.BulkTransactionFilters
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/**
 * Shared converter from the spec-generated [BulkTransactionFilters] (write-side, used by
 * the two bulk-tx mutations) into the GraphQL `filters` map Monarch expects. Only non-null
 * fields are emitted; lists are emitted as-is even when empty (matches read-side behavior).
 *
 * Lives at package level so [BulkUpdateTransactions] and [BulkDeleteTransactions] can both
 * reuse it without round-tripping through a [TransactionFilters] data class.
 */
internal fun filtersMap(f: BulkTransactionFilters): Map<String, Any?> =
    mapOfNotNull(
        "startDate" to f.startDate?.toString(),
        "endDate" to f.endDate?.toString(),
        "search" to f.search,
        "categories" to f.categories,
        "accounts" to f.accounts,
        "tags" to f.tags,
        "hasAttachments" to f.hasAttachments,
        "hasNotes" to f.hasNotes,
        "hideFromReports" to f.hideFromReports,
        "isSplit" to f.isSplit,
        "isRecurring" to f.isRecurring,
        "importedFromMint" to f.importedFromMint,
        "syncedFromInstitution" to f.syncedFromInstitution,
        "needsReview" to f.needsReview,
        "transactionVisibility" to f.transactionVisibility?.value,
    )
