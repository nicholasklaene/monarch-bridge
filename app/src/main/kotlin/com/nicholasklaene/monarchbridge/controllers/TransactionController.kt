package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.TransactionsApi
import com.nicholasklaene.monarchbridge.generated.model.BulkDeleteTransactionsRequest
import com.nicholasklaene.monarchbridge.generated.model.BulkDeleteTransactionsResponse
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateTransactionsRequest
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateTransactionsResponse
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionResponse
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponse
import com.nicholasklaene.monarchbridge.generated.model.DuplicateGroupKey
import com.nicholasklaene.monarchbridge.generated.model.ExplainTransactionResponse
import com.nicholasklaene.monarchbridge.generated.model.GetAccountsForTransactionFilterResponse
import com.nicholasklaene.monarchbridge.generated.model.GetAttachmentResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowBreakdownResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowDashboardResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowEntitiesResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowFilteredResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowTimeframeResponse
import com.nicholasklaene.monarchbridge.generated.model.GetDownloadTransactionsSessionResponse
import com.nicholasklaene.monarchbridge.generated.model.GetReviewSummaryByUserResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSpendingDashboardResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSpendingTrendsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionAuditLogResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionDetailResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionNotesResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionSplitTemplatesResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionSplitsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionsDashboardResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionsDuplicatesResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionsDuplicatesResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionsDuplicatesResponseDataGroupsInner
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionsSummaryResponse
import com.nicholasklaene.monarchbridge.generated.model.ListTransactionsResponse
import com.nicholasklaene.monarchbridge.generated.model.MarkAsRecurringRequest
import com.nicholasklaene.monarchbridge.generated.model.MarkAsRecurringResponse
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionAsReviewedResponse
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponse
import com.nicholasklaene.monarchbridge.generated.model.MatchSearchTransactionsResponse
import com.nicholasklaene.monarchbridge.generated.model.MoveTransactionsRequest
import com.nicholasklaene.monarchbridge.generated.model.MoveTransactionsResponse
import com.nicholasklaene.monarchbridge.generated.model.SetTransactionTagsRequest
import com.nicholasklaene.monarchbridge.generated.model.SetTransactionTagsResponse
import com.nicholasklaene.monarchbridge.generated.model.StartDownloadTransactionsRequest
import com.nicholasklaene.monarchbridge.generated.model.StartDownloadTransactionsResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionSplitsRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionSplitsResponse
import com.nicholasklaene.monarchbridge.generated.model.UploadTransactionAttachmentResponse
import com.nicholasklaene.monarchbridge.generated.model.UploadTransactionAttachmentResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.MultipartFilePart
import com.nicholasklaene.monarchbridge.graphql.operations.recurring.MarkAsRecurring
import com.nicholasklaene.monarchbridge.graphql.operations.recurring.MarkStreamAsNotRecurring
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.AddTransactionAttachment
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.BulkDeleteTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.BulkUpdateTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.CreateTransaction
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.DeleteTransaction
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.ExplainTransaction
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetAccountsForTransactionFilter
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetAttachment
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetCashflowBreakdown
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetCashflowDashboard
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetCashflowEntities
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetCashflowFiltered
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetCashflowSummary
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetCashflowTimeframe
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetDownloadTransactionsSession
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetReviewSummaryByUser
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetSpendingDashboard
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetSpendingTrends
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactionAttachmentUploadInfo
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactionAuditLog
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactionDetails
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactionNotes
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactionSplitTemplates
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactionSplits
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactionsDashboard
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactionsSummary
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.MarkTransactionAsReviewed
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.MatchSearchTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.MoveTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.SetTransactionTags
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.StartDownloadTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.TransactionFilters
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.UpdateTransaction
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.UpdateTransactionSplits
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDate

/**
 * Transactions, splits, tags-on-transactions, cashflow, summaries. All HTTP wiring comes
 * from the spec-generated [TransactionsApi]; this class dispatches to operations and
 * wraps each payload in the matching spec-generated `*Response` envelope.
 *
 * The four read endpoints (`listTransactions`, `getTransactionsSummary`, `getCashflow`,
 * `getCashflowBreakdown`) accept the full Monarch `TransactionFilterInput` surface via
 * [TransactionFilters] — search, category/account/tag id lists, and nine nullable bool
 * predicates plus a visibility enum.
 *
 * Note: `deleteTransaction` returns `DeleteAccountResponse` — the spec-generator
 * dedupes responses with identical `{deleted: Boolean}` shape under the first-seen name.
 */
@RestController
@Suppress("TooManyFunctions", "LongParameterList", "LargeClass")
class TransactionController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    TransactionsApi {
    companion object {
        private const val DEFAULT_DAYS_BACK = 30L
        private const val DUPLICATES_FETCH_LIMIT = 500
    }

    @Suppress("LongMethod")
    override fun listTransactions(
        start: LocalDate?,
        end: LocalDate?,
        limit: Int?,
        offset: Int?,
        accountId: String?,
        accountIds: List<String>?,
        categoryIds: List<String>?,
        tagIds: List<String>?,
        orderBy: String?,
        search: String?,
        hasAttachments: Boolean?,
        hasNotes: Boolean?,
        hideFromReports: Boolean?,
        isSplit: Boolean?,
        isRecurring: Boolean?,
        importedFromMint: Boolean?,
        syncedFromInstitution: Boolean?,
        needsReview: Boolean?,
        transactionVisibility: String?,
    ): ResponseEntity<ListTransactionsResponse> =
        ResponseEntity.ok(
            ListTransactionsResponse(
                data =
                    exec(
                        GetTransactions,
                        GetTransactions.Input(
                            startDate = (start ?: LocalDate.now().minusDays(DEFAULT_DAYS_BACK)).toString(),
                            endDate = (end ?: LocalDate.now()).toString(),
                            filters =
                                buildFilters(
                                    accountId = accountId,
                                    accountIds = accountIds,
                                    categoryIds = categoryIds,
                                    tagIds = tagIds,
                                    search = search,
                                    hasAttachments = hasAttachments,
                                    hasNotes = hasNotes,
                                    hideFromReports = hideFromReports,
                                    isSplit = isSplit,
                                    isRecurring = isRecurring,
                                    importedFromMint = importedFromMint,
                                    syncedFromInstitution = syncedFromInstitution,
                                    needsReview = needsReview,
                                    transactionVisibility = transactionVisibility,
                                ),
                            limit = limit,
                            offset = offset,
                            orderBy = orderBy,
                        ),
                    ),
            ),
        )

    override fun getCashflow(
        start: LocalDate?,
        end: LocalDate?,
        accountIds: List<String>?,
        categoryIds: List<String>?,
        tagIds: List<String>?,
        search: String?,
        hasAttachments: Boolean?,
        hasNotes: Boolean?,
        hideFromReports: Boolean?,
        isSplit: Boolean?,
        isRecurring: Boolean?,
        importedFromMint: Boolean?,
        syncedFromInstitution: Boolean?,
        needsReview: Boolean?,
        transactionVisibility: String?,
    ): ResponseEntity<GetCashflowResponse> =
        ResponseEntity.ok(
            GetCashflowResponse(
                data =
                    exec(
                        GetCashflowSummary,
                        GetCashflowSummary.Input(
                            startDate = (start ?: LocalDate.now().minusDays(DEFAULT_DAYS_BACK)).toString(),
                            endDate = (end ?: LocalDate.now()).toString(),
                            filters =
                                buildFilters(
                                    accountId = null,
                                    accountIds = accountIds,
                                    categoryIds = categoryIds,
                                    tagIds = tagIds,
                                    search = search,
                                    hasAttachments = hasAttachments,
                                    hasNotes = hasNotes,
                                    hideFromReports = hideFromReports,
                                    isSplit = isSplit,
                                    isRecurring = isRecurring,
                                    importedFromMint = importedFromMint,
                                    syncedFromInstitution = syncedFromInstitution,
                                    needsReview = needsReview,
                                    transactionVisibility = transactionVisibility,
                                ),
                        ),
                    ),
            ),
        )

    override fun getCashflowBreakdown(
        start: LocalDate?,
        end: LocalDate?,
        accountIds: List<String>?,
        categoryIds: List<String>?,
        tagIds: List<String>?,
        search: String?,
        hasAttachments: Boolean?,
        hasNotes: Boolean?,
        hideFromReports: Boolean?,
        isSplit: Boolean?,
        isRecurring: Boolean?,
        importedFromMint: Boolean?,
        syncedFromInstitution: Boolean?,
        needsReview: Boolean?,
        transactionVisibility: String?,
    ): ResponseEntity<GetCashflowBreakdownResponse> =
        ResponseEntity.ok(
            GetCashflowBreakdownResponse(
                data =
                    exec(
                        GetCashflowBreakdown,
                        GetCashflowBreakdown.Input(
                            startDate = (start ?: LocalDate.now().minusDays(DEFAULT_DAYS_BACK)).toString(),
                            endDate = (end ?: LocalDate.now()).toString(),
                            filters =
                                buildFilters(
                                    accountId = null,
                                    accountIds = accountIds,
                                    categoryIds = categoryIds,
                                    tagIds = tagIds,
                                    search = search,
                                    hasAttachments = hasAttachments,
                                    hasNotes = hasNotes,
                                    hideFromReports = hideFromReports,
                                    isSplit = isSplit,
                                    isRecurring = isRecurring,
                                    importedFromMint = importedFromMint,
                                    syncedFromInstitution = syncedFromInstitution,
                                    needsReview = needsReview,
                                    transactionVisibility = transactionVisibility,
                                ),
                        ),
                    ),
            ),
        )

    override fun getTransactionsSummary(
        start: LocalDate?,
        end: LocalDate?,
        accountId: String?,
        accountIds: List<String>?,
        categoryIds: List<String>?,
        tagIds: List<String>?,
        search: String?,
        hasAttachments: Boolean?,
        hasNotes: Boolean?,
        hideFromReports: Boolean?,
        isSplit: Boolean?,
        isRecurring: Boolean?,
        importedFromMint: Boolean?,
        syncedFromInstitution: Boolean?,
        needsReview: Boolean?,
        transactionVisibility: String?,
    ): ResponseEntity<GetTransactionsSummaryResponse> =
        ResponseEntity.ok(
            GetTransactionsSummaryResponse(
                data =
                    exec(
                        GetTransactionsSummary,
                        GetTransactionsSummary.Input(
                            startDate = start?.toString(),
                            endDate = end?.toString(),
                            filters =
                                buildFilters(
                                    accountId = accountId,
                                    accountIds = accountIds,
                                    categoryIds = categoryIds,
                                    tagIds = tagIds,
                                    search = search,
                                    hasAttachments = hasAttachments,
                                    hasNotes = hasNotes,
                                    hideFromReports = hideFromReports,
                                    isSplit = isSplit,
                                    isRecurring = isRecurring,
                                    importedFromMint = importedFromMint,
                                    syncedFromInstitution = syncedFromInstitution,
                                    needsReview = needsReview,
                                    transactionVisibility = transactionVisibility,
                                ),
                        ),
                    ),
            ),
        )

    /**
     * Server-side composite. Pulls one page of recent transactions (up to
     * [DUPLICATES_FETCH_LIMIT]) over the requested window, groups them by the
     * tuple `(date, amount, plaidName, accountId)` per the python lib's
     * `find_duplicate_transactions` semantics, and returns groups with size > 1.
     * No new GraphQL operation: reuses `GetTransactions`.
     *
     * Uses `plaidName` (the raw Plaid description) rather than `merchantName`
     * (Monarch's normalized display name) to avoid false positives: two
     * genuine same-day same-merchant same-amount charges carry different
     * `plaidName` reference strings; only true double-inserts share an
     * identical `plaidName`.
     */
    @Suppress("LongMethod") // Composite logic (filter merge + Monarch fetch + grouping) reads
    // more clearly inline than fragmented across helpers.
    override fun getTransactionsDuplicates(
        start: LocalDate?,
        end: LocalDate?,
        accountId: String?,
        accountIds: List<String>?,
    ): ResponseEntity<GetTransactionsDuplicatesResponse> {
        val mergedAccounts =
            (listOfNotNull(accountId) + accountIds.orEmpty())
                .distinct()
                .filter { it.isNotBlank() }
        val filters =
            if (mergedAccounts.isEmpty()) {
                TransactionFilters()
            } else {
                TransactionFilters(accountIds = mergedAccounts)
            }
        val page =
            exec(
                GetTransactions,
                GetTransactions.Input(
                    startDate = (start ?: LocalDate.now().minusDays(DEFAULT_DAYS_BACK)).toString(),
                    endDate = (end ?: LocalDate.now()).toString(),
                    filters = filters,
                    limit = DUPLICATES_FETCH_LIMIT,
                ),
            )
        val groups =
            page.results
                .groupBy { txn ->
                    DuplicateGroupKey(
                        date = txn.date,
                        amount = txn.amount,
                        accountId = txn.account?.id,
                        plaidName = txn.plaidName,
                    )
                }.filterValues { it.size > 1 }
                .map { (key, txns) ->
                    GetTransactionsDuplicatesResponseDataGroupsInner(key = key, transactions = txns)
                }
        return ResponseEntity.ok(
            GetTransactionsDuplicatesResponse(
                data = GetTransactionsDuplicatesResponseData(groups = groups),
            ),
        )
    }

    override fun getTransactionDetail(id: String): ResponseEntity<GetTransactionDetailResponse> =
        ResponseEntity.ok(
            GetTransactionDetailResponse(data = exec(GetTransactionDetails, GetTransactionDetails.Input(id))),
        )

    override fun getTransactionSplits(id: String): ResponseEntity<GetTransactionSplitsResponse> =
        ResponseEntity.ok(GetTransactionSplitsResponse(data = exec(GetTransactionSplits, GetTransactionSplits.Input(id))))

    override fun createTransaction(createTransactionRequest: CreateTransactionRequest): ResponseEntity<CreateTransactionResponse> =
        ResponseEntity.ok(
            CreateTransactionResponse(data = exec(CreateTransaction, CreateTransaction.Input.from(createTransactionRequest))),
        )

    override fun updateTransaction(
        id: String,
        updateTransactionRequest: UpdateTransactionRequest,
    ): ResponseEntity<UpdateTransactionResponse> =
        ResponseEntity.ok(
            UpdateTransactionResponse(data = exec(UpdateTransaction, UpdateTransaction.Input.from(id, updateTransactionRequest))),
        )

    override fun deleteTransaction(id: String): ResponseEntity<DeleteAccountResponse> =
        ResponseEntity.ok(DeleteAccountResponse(data = exec(DeleteTransaction, DeleteTransaction.Input(id))))

    /**
     * `id` here is the recurring-stream id (NOT the transaction id) — Monarch's mutation
     * pivots on `streamId`. See the path doc; the proxy does not resolve transaction→stream
     * server-side.
     */
    override fun markTransactionStreamAsNotRecurring(id: String): ResponseEntity<MarkTransactionStreamAsNotRecurringResponse> =
        ResponseEntity.ok(
            MarkTransactionStreamAsNotRecurringResponse(
                data = exec(MarkStreamAsNotRecurring, MarkStreamAsNotRecurring.Input(id)),
            ),
        )

    override fun bulkUpdateTransactions(
        bulkUpdateTransactionsRequest: BulkUpdateTransactionsRequest,
    ): ResponseEntity<BulkUpdateTransactionsResponse> =
        ResponseEntity.ok(
            BulkUpdateTransactionsResponse(
                data = exec(BulkUpdateTransactions, BulkUpdateTransactions.Input.from(bulkUpdateTransactionsRequest)),
            ),
        )

    override fun bulkDeleteTransactions(
        bulkDeleteTransactionsRequest: BulkDeleteTransactionsRequest,
    ): ResponseEntity<BulkDeleteTransactionsResponse> =
        ResponseEntity.ok(
            BulkDeleteTransactionsResponse(
                data = exec(BulkDeleteTransactions, BulkDeleteTransactions.Input.from(bulkDeleteTransactionsRequest)),
            ),
        )

    override fun setTransactionTags(
        id: String,
        setTransactionTagsRequest: SetTransactionTagsRequest,
    ): ResponseEntity<SetTransactionTagsResponse> =
        ResponseEntity.ok(
            SetTransactionTagsResponse(data = exec(SetTransactionTags, SetTransactionTags.Input.from(id, setTransactionTagsRequest))),
        )

    override fun updateTransactionSplits(
        id: String,
        updateTransactionSplitsRequest: UpdateTransactionSplitsRequest,
    ): ResponseEntity<UpdateTransactionSplitsResponse> =
        ResponseEntity.ok(
            UpdateTransactionSplitsResponse(
                data = exec(UpdateTransactionSplits, UpdateTransactionSplits.Input.from(id, updateTransactionSplitsRequest)),
            ),
        )

    /**
     * Three-step `upload_attachment` flow. Caller sees one `multipart/form-data` POST with the file.
     *
     * 1. Ask Monarch for signed Cloudinary upload params via [GetTransactionAttachmentUploadInfo].
     * 2. Forward the file to Cloudinary via [MonarchClient.uploadToExternal] (no Monarch auth).
     * 3. Tell Monarch to link the upload via [AddTransactionAttachment], using the Cloudinary
     *    response's `public_id` + `format` + `bytes`.
     */
    @Suppress("LongMethod")
    override fun uploadTransactionAttachment(
        id: String,
        file: MultipartFile,
    ): ResponseEntity<UploadTransactionAttachmentResponse> {
        sessionService.requireCurrent()

        val uploadInfo = client.execute(GetTransactionAttachmentUploadInfo, GetTransactionAttachmentUploadInfo.Input(id))

        val originalFilename = file.originalFilename ?: "attachment"
        val contentType = file.contentType ?: "application/octet-stream"
        val filePart = MultipartFilePart(filename = originalFilename, contentType = contentType, bytes = file.bytes)

        val cloudinaryResponse =
            client.uploadToExternal(
                uploadInfo.cloudinaryPath,
                mapOf(
                    "file" to filePart,
                    "timestamp" to uploadInfo.timestamp,
                    "folder" to uploadInfo.folder,
                    "signature" to uploadInfo.signature,
                    "api_key" to uploadInfo.apiKey,
                    "upload_preset" to uploadInfo.uploadPreset,
                ),
            )

        val publicId = cloudinaryResponse.path("public_id").asText("")
        val extension = cloudinaryResponse.path("format").asText("")
        val sizeBytes = cloudinaryResponse.path("bytes").asInt(0)

        val attachment =
            client.execute(
                AddTransactionAttachment,
                AddTransactionAttachment.Input(
                    transactionId = id,
                    filename = originalFilename,
                    publicId = publicId,
                    extension = extension,
                    sizeBytes = sizeBytes,
                ),
            )

        return ResponseEntity.ok(
            UploadTransactionAttachmentResponse(
                data = UploadTransactionAttachmentResponseData(attachment = attachment),
            ),
        )
    }

    /**
     * Assemble a [TransactionFilters] from the loose nullable query-param wires.
     * Lives in the controller (not on [TransactionFilters] itself) because the input shape
     * is HTTP-specific (nullable lists from `@RequestParam`, etc.); the data class stays
     * pure Kotlin for unit testability.
     */
    @Suppress("LongParameterList")
    private fun buildFilters(
        accountId: String?,
        accountIds: List<String>?,
        categoryIds: List<String>?,
        tagIds: List<String>?,
        search: String?,
        hasAttachments: Boolean?,
        hasNotes: Boolean?,
        hideFromReports: Boolean?,
        isSplit: Boolean?,
        isRecurring: Boolean?,
        importedFromMint: Boolean?,
        syncedFromInstitution: Boolean?,
        needsReview: Boolean?,
        transactionVisibility: String?,
    ): TransactionFilters =
        TransactionFilters(
            search = search ?: "",
            categoryIds = categoryIds.orEmpty(),
            accountId = accountId,
            accountIds = accountIds.orEmpty(),
            tagIds = tagIds.orEmpty(),
            hasAttachments = hasAttachments,
            hasNotes = hasNotes,
            hideFromReports = hideFromReports,
            isSplit = isSplit,
            isRecurring = isRecurring,
            importedFromMint = importedFromMint,
            syncedFromInstitution = syncedFromInstitution,
            needsReview = needsReview,
            transactionVisibility = transactionVisibility,
        )

    /** Resolve an attachment id to its `originalAssetUrl`; GET that URL to download the binary. */
    override fun getAttachment(id: String): ResponseEntity<GetAttachmentResponse> =
        ResponseEntity.ok(GetAttachmentResponse(data = exec(GetAttachment, GetAttachment.Input(attachmentId = id))))

    /** Counts of transactions needing review, grouped per household member. */
    override fun getReviewSummaryByUser(): ResponseEntity<GetReviewSummaryByUserResponse> =
        ResponseEntity.ok(GetReviewSummaryByUserResponse(data = exec(GetReviewSummaryByUser, Unit)))

    /** Day-by-day expense series for a date window. Lightweight chart-friendly shape. */
    override fun getCashflowDashboard(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetCashflowDashboardResponse> =
        ResponseEntity.ok(
            GetCashflowDashboardResponse(
                data = exec(GetCashflowDashboard, GetCashflowDashboard.Input(start, end)),
            ),
        )

    /** Year / month / quarter cashflow summaries (savings, savings-rate, income, expense). */
    override fun getCashflowTimeframe(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetCashflowTimeframeResponse> =
        ResponseEntity.ok(
            GetCashflowTimeframeResponse(
                data = exec(GetCashflowTimeframe, GetCashflowTimeframe.Input(start, end)),
            ),
        )

    /** Cashflow by category, category-group, and merchant plus a summary. */
    override fun getCashflowEntities(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetCashflowEntitiesResponse> =
        ResponseEntity.ok(
            GetCashflowEntitiesResponse(
                data = exec(GetCashflowEntities, GetCashflowEntities.Input(start, end)),
            ),
        )

    /** Filterable cashflow page: summary + timeframe + entity breakdowns in one call. */
    @Suppress("LongParameterList")
    override fun getCashflowFiltered(
        start: LocalDate?,
        end: LocalDate?,
        accountId: List<String>?,
        categoryId: List<String>?,
        categoryGroupId: List<String>?,
        merchantId: List<String>?,
        tagId: List<String>?,
    ): ResponseEntity<GetCashflowFilteredResponse> =
        ResponseEntity.ok(
            GetCashflowFilteredResponse(
                data =
                    exec(
                        GetCashflowFiltered,
                        GetCashflowFiltered.Input(
                            startDate = start,
                            endDate = end,
                            accounts = accountId?.takeIf { it.isNotEmpty() },
                            categories = categoryId?.takeIf { it.isNotEmpty() },
                            categoryGroups = categoryGroupId?.takeIf { it.isNotEmpty() },
                            merchants = merchantId?.takeIf { it.isNotEmpty() },
                            tags = tagId?.takeIf { it.isNotEmpty() },
                        ),
                    ),
            ),
        )

    /** AI explanation for one transaction (legacy path `/v1/transactions/explain/{id}`). */
    override fun explainTransaction(id: String): ResponseEntity<ExplainTransactionResponse> =
        ResponseEntity.ok(ExplainTransactionResponse(data = exec(ExplainTransaction, ExplainTransaction.Input(id))))

    /** AI explanation for one transaction (canonical path `/v1/transactions/{id}/explain`). */
    override fun explainTransactionByPath(id: String): ResponseEntity<ExplainTransactionResponse> =
        ResponseEntity.ok(ExplainTransactionResponse(data = exec(ExplainTransaction, ExplainTransaction.Input(id))))

    /** Mark one transaction as reviewed - thin wrapper over `updateTransaction(reviewed=true)`. */
    override fun markTransactionAsReviewed(id: String): ResponseEntity<MarkTransactionAsReviewedResponse> =
        ResponseEntity.ok(
            MarkTransactionAsReviewedResponse(
                data = exec(MarkTransactionAsReviewed, MarkTransactionAsReviewed.Input(id = id)),
            ),
        )

    /** Dashboard transactions list (totals + per-row merchant/category/account refs). */
    override fun getTransactionsDashboard(
        start: LocalDate?,
        end: LocalDate?,
        limit: Int?,
        offset: Int?,
    ): ResponseEntity<GetTransactionsDashboardResponse> =
        ResponseEntity.ok(
            GetTransactionsDashboardResponse(
                data =
                    exec(
                        GetTransactionsDashboard,
                        GetTransactionsDashboard.Input(
                            startDate = start,
                            endDate = end,
                            limit = limit,
                            offset = offset,
                        ),
                    ),
            ),
        )

    /** Accounts touched by a transaction filter (date-range only here). */
    override fun getAccountsForTransactionFilter(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetAccountsForTransactionFilterResponse> =
        ResponseEntity.ok(
            GetAccountsForTransactionFilterResponse(
                data = exec(GetAccountsForTransactionFilter, GetAccountsForTransactionFilter.Input(start, end)),
            ),
        )

    /** Reassign N transactions to a target account. */
    override fun moveTransactions(moveTransactionsRequest: MoveTransactionsRequest): ResponseEntity<MoveTransactionsResponse> =
        ResponseEntity.ok(
            MoveTransactionsResponse(data = exec(MoveTransactions, MoveTransactions.Input.from(moveTransactionsRequest))),
        )

    /** Slim fuzzy transaction search powering the web "find a match" picker. */
    override fun matchSearchTransactions(
        search: String?,
        limit: Int,
    ): ResponseEntity<MatchSearchTransactionsResponse> =
        ResponseEntity.ok(
            MatchSearchTransactionsResponse(
                data = exec(MatchSearchTransactions, MatchSearchTransactions.Input(search = search, limit = limit)),
            ),
        )

    /** Kick off the async transactions-CSV download job. */
    override fun startDownloadTransactions(
        startDownloadTransactionsRequest: StartDownloadTransactionsRequest,
    ): ResponseEntity<StartDownloadTransactionsResponse> =
        ResponseEntity.ok(
            StartDownloadTransactionsResponse(
                data = exec(StartDownloadTransactions, StartDownloadTransactions.Input.from(startDownloadTransactionsRequest)),
            ),
        )

    /** Poll a transactions-CSV download session for the signed `url`. */
    override fun getDownloadTransactionsSession(sessionKey: String): ResponseEntity<GetDownloadTransactionsSessionResponse> =
        ResponseEntity.ok(
            GetDownloadTransactionsSessionResponse(
                data = exec(GetDownloadTransactionsSession, GetDownloadTransactionsSession.Input(sessionKey = sessionKey)),
            ),
        )

    /** Standalone notes accessor for one transaction; lighter than the full transaction detail. */
    override fun getTransactionNotes(id: String): ResponseEntity<GetTransactionNotesResponse> =
        ResponseEntity.ok(
            GetTransactionNotesResponse(
                data = exec(GetTransactionNotes, GetTransactionNotes.Input(id = id)),
            ),
        )

    /** History of changes against one transaction (timestamp, actor, field, old/new). */
    override fun getTransactionAuditLog(id: String): ResponseEntity<GetTransactionAuditLogResponse> =
        ResponseEntity.ok(
            GetTransactionAuditLogResponse(
                data = exec(GetTransactionAuditLog, GetTransactionAuditLog.Input(id = id)),
            ),
        )

    /** Home-tab spending widget: total spend, remaining budget, top categories. */
    override fun getSpendingDashboard(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetSpendingDashboardResponse> =
        ResponseEntity.ok(
            GetSpendingDashboardResponse(
                data = exec(GetSpendingDashboard, GetSpendingDashboard.Input(startDate = start, endDate = end)),
            ),
        )

    /** Tell Monarch a transaction IS the start of a recurring stream at the given frequency. */
    override fun markAsRecurring(
        id: String,
        markAsRecurringRequest: MarkAsRecurringRequest,
    ): ResponseEntity<MarkAsRecurringResponse> =
        ResponseEntity.ok(
            MarkAsRecurringResponse(
                data = exec(MarkAsRecurring, MarkAsRecurring.Input.from(id, markAsRecurringRequest)),
            ),
        )

    /** Period-over-period spend trend with top rising / falling categories. */
    override fun getSpendingTrends(timeframe: String): ResponseEntity<GetSpendingTrendsResponse> =
        ResponseEntity.ok(
            GetSpendingTrendsResponse(
                data = exec(GetSpendingTrends, GetSpendingTrends.Input(timeframe = timeframe)),
            ),
        )

    /** Saved split templates (reusable percent-based split definitions). */
    override fun getTransactionSplitTemplates(): ResponseEntity<GetTransactionSplitTemplatesResponse> =
        ResponseEntity.ok(
            GetTransactionSplitTemplatesResponse(
                data = exec(GetTransactionSplitTemplates, Unit),
            ),
        )
}
