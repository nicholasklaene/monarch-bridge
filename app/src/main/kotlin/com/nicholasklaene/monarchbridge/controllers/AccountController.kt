package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.AccountsApi
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateAccountsRequest
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateAccountsResponse
import com.nicholasklaene.monarchbridge.generated.model.CreateManualAccountRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateManualAccountResponse
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponse
import com.nicholasklaene.monarchbridge.generated.model.DeleteInstitutionResponse
import com.nicholasklaene.monarchbridge.generated.model.GetAccountBalanceAtDateResponse
import com.nicholasklaene.monarchbridge.generated.model.GetAccountGroupsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetAccountHistoryResponse
import com.nicholasklaene.monarchbridge.generated.model.GetAccountHoldingsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetAccountTypeOptionsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetBalanceHistoryStatusResponse
import com.nicholasklaene.monarchbridge.generated.model.GetBalanceHistoryStatusResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetCredentialInstitutionsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetInstitutionByPlaidIdResponse
import com.nicholasklaene.monarchbridge.generated.model.GetInstitutionsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetNetworthByTypeResponse
import com.nicholasklaene.monarchbridge.generated.model.GetNetworthRecentResponse
import com.nicholasklaene.monarchbridge.generated.model.GetNetworthResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTopInstitutionGroupsResponse
import com.nicholasklaene.monarchbridge.generated.model.ListAccountsResponse
import com.nicholasklaene.monarchbridge.generated.model.ListLinkedCredentialsResponse
import com.nicholasklaene.monarchbridge.generated.model.PreviewAccountBalanceResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountGroupOrderRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountGroupOrderResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountResponse
import com.nicholasklaene.monarchbridge.generated.model.UploadAccountBalanceHistory202Response
import com.nicholasklaene.monarchbridge.generated.model.UploadAccountBalanceHistory202ResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.MultipartFilePart
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.BulkUpdateAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.CreateManualAccount
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.DeleteAccount
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.DeleteCredential
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetAccountGroups
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetAccountHistory
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetAccountHoldings
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetAccountTypeOptions
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetAggregateSnapshots
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetCredentialInstitutions
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetDisplayBalanceAtDate
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetInstitutionByPlaidId
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetInstitutions
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetRecentAccountBalances
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetSnapshotsByAccountType
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetTopInstitutionGroups
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetUploadBalanceHistorySession
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.ListLinkedCredentials
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.ParseUploadBalanceHistorySession
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.PreviewAccountBalance
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.UpdateAccount
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.UpdateAccountGroupOrder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDate

/**
 * Accounts, balances, institutions, holdings, networth. All HTTP wiring (paths, params,
 * response types) comes from the spec-generated [AccountsApi] interface; this class only
 * dispatches each method to the matching GraphQL operation and wraps the typed payload in
 * the spec-generated `*Response` envelope.
 */
@RestController
@Suppress("TooManyFunctions", "LargeClass")
class AccountController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    AccountsApi {
    companion object {
        private const val DEFAULT_DAYS_BACK = 30L
    }

    override fun listAccounts(): ResponseEntity<ListAccountsResponse> =
        ResponseEntity.ok(ListAccountsResponse(data = exec(GetAccounts, Unit)))

    override fun getInstitutions(): ResponseEntity<GetInstitutionsResponse> =
        ResponseEntity.ok(GetInstitutionsResponse(data = exec(GetInstitutions, Unit)))

    override fun getAccountTypeOptions(): ResponseEntity<GetAccountTypeOptionsResponse> =
        ResponseEntity.ok(GetAccountTypeOptionsResponse(data = exec(GetAccountTypeOptions, Unit)))

    override fun getAccountHistory(id: String): ResponseEntity<GetAccountHistoryResponse> =
        ResponseEntity.ok(GetAccountHistoryResponse(data = exec(GetAccountHistory, GetAccountHistory.Input(id))))

    /** Display balance for one account on a specific date (walks the daily snapshot series). */
    override fun getAccountBalanceAtDate(
        id: String,
        date: LocalDate,
    ): ResponseEntity<GetAccountBalanceAtDateResponse> =
        ResponseEntity.ok(
            GetAccountBalanceAtDateResponse(
                data = exec(GetDisplayBalanceAtDate, GetDisplayBalanceAtDate.Input(accountId = id, date = date)),
            ),
        )

    override fun getAccountHoldings(id: String): ResponseEntity<GetAccountHoldingsResponse> =
        ResponseEntity.ok(GetAccountHoldingsResponse(data = exec(GetAccountHoldings, GetAccountHoldings.Input(id))))

    override fun getNetworth(
        start: LocalDate?,
        end: LocalDate?,
        accountType: String?,
    ): ResponseEntity<GetNetworthResponse> =
        ResponseEntity.ok(
            GetNetworthResponse(
                data =
                    exec(
                        GetAggregateSnapshots,
                        GetAggregateSnapshots.Input(
                            startDate = (start ?: LocalDate.now().minusDays(DEFAULT_DAYS_BACK)).toString(),
                            endDate = (end ?: LocalDate.now()).toString(),
                            accountType = accountType,
                        ),
                    ),
            ),
        )

    override fun getNetworthRecent(start: LocalDate?): ResponseEntity<GetNetworthRecentResponse> =
        ResponseEntity.ok(
            GetNetworthRecentResponse(
                data =
                    exec(
                        GetRecentAccountBalances,
                        GetRecentAccountBalances.Input(
                            startDate = (start ?: LocalDate.now().minusDays(DEFAULT_DAYS_BACK)).toString(),
                        ),
                    ),
            ),
        )

    override fun getNetworthByType(
        start: LocalDate?,
        timeframe: String,
    ): ResponseEntity<GetNetworthByTypeResponse> =
        ResponseEntity.ok(
            GetNetworthByTypeResponse(
                data =
                    exec(
                        GetSnapshotsByAccountType,
                        GetSnapshotsByAccountType.Input(
                            startDate = (start ?: LocalDate.now().minusDays(DEFAULT_DAYS_BACK)).toString(),
                            timeframe = timeframe,
                        ),
                    ),
            ),
        )

    override fun createManualAccount(createManualAccountRequest: CreateManualAccountRequest): ResponseEntity<CreateManualAccountResponse> =
        ResponseEntity.ok(
            CreateManualAccountResponse(
                data = exec(CreateManualAccount, CreateManualAccount.Input.from(createManualAccountRequest)),
            ),
        )

    override fun updateAccount(
        id: String,
        updateAccountRequest: UpdateAccountRequest,
    ): ResponseEntity<UpdateAccountResponse> =
        ResponseEntity.ok(
            UpdateAccountResponse(
                data = exec(UpdateAccount, UpdateAccount.Input.from(id, updateAccountRequest)),
            ),
        )

    override fun bulkUpdateAccounts(bulkUpdateAccountsRequest: BulkUpdateAccountsRequest): ResponseEntity<BulkUpdateAccountsResponse> =
        ResponseEntity.ok(
            BulkUpdateAccountsResponse(
                data = exec(BulkUpdateAccounts, BulkUpdateAccounts.Input.from(bulkUpdateAccountsRequest)),
            ),
        )

    override fun deleteAccount(id: String): ResponseEntity<DeleteAccountResponse> =
        ResponseEntity.ok(DeleteAccountResponse(data = exec(DeleteAccount, DeleteAccount.Input(id))))

    override fun deleteInstitution(id: String): ResponseEntity<DeleteInstitutionResponse> =
        ResponseEntity.ok(DeleteInstitutionResponse(data = exec(DeleteCredential, DeleteCredential.Input(id))))

    /**
     * Two-step balance-history backfill. (1) POST the CSV multipart to Monarch's
     * `/account-balance-history/upload/` endpoint; (2) trigger Monarch's parser via the
     * `parseBalanceHistory` GraphQL mutation. Returns the session key + initial status;
     * clients poll [getBalanceHistoryStatus] until `status == "completed"`.
     */
    override fun uploadAccountBalanceHistory(
        id: String,
        file: MultipartFile,
    ): ResponseEntity<UploadAccountBalanceHistory202Response> {
        sessionService.requireCurrent()

        val filePart =
            MultipartFilePart(
                filename = "upload.csv",
                contentType = "text/csv",
                bytes = file.bytes,
            )
        val mappingJson = """{"upload.csv":"$id"}"""

        val uploadResponse =
            client.uploadMultipart(
                "/account-balance-history/upload/",
                mapOf(
                    "files" to filePart,
                    "account_files_mapping" to mappingJson,
                ),
            )
        val sessionKey = uploadResponse.path("session_key").asText("")

        val parsed = client.execute(ParseUploadBalanceHistorySession, ParseUploadBalanceHistorySession.Input(sessionKey))

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            UploadAccountBalanceHistory202Response(
                data =
                    UploadAccountBalanceHistory202ResponseData(
                        sessionKey = parsed.sessionKey,
                        status = parsed.status,
                    ),
            ),
        )
    }

    /** Lightweight list of every linked data-provider credential plus its institution (id, name, logo). */
    override fun listLinkedCredentials(): ResponseEntity<ListLinkedCredentialsResponse> =
        ResponseEntity.ok(ListLinkedCredentialsResponse(data = exec(ListLinkedCredentials, Unit)))

    override fun getBalanceHistoryStatus(sessionKey: String): ResponseEntity<GetBalanceHistoryStatusResponse> {
        sessionService.requireCurrent()
        val status = client.execute(GetUploadBalanceHistorySession, GetUploadBalanceHistorySession.Input(sessionKey))
        return ResponseEntity.ok(
            GetBalanceHistoryStatusResponse(
                data =
                    GetBalanceHistoryStatusResponseData(
                        sessionKey = status.sessionKey,
                        status = status.status,
                    ),
            ),
        )
    }

    /** Institution lookup by Plaid id (includes connection-health flags). */
    override fun getInstitutionByPlaidId(plaidId: String): ResponseEntity<GetInstitutionByPlaidIdResponse> =
        ResponseEntity.ok(
            GetInstitutionByPlaidIdResponse(
                data = exec(GetInstitutionByPlaidId, GetInstitutionByPlaidId.Input(plaidId)),
            ),
        )

    /** Linked credentials with institution metadata (per-provider ids + preferred provider). */
    override fun getCredentialInstitutions(): ResponseEntity<GetCredentialInstitutionsResponse> =
        ResponseEntity.ok(GetCredentialInstitutionsResponse(data = exec(GetCredentialInstitutions, Unit)))

    /** Top institution groups (popular providers by category). */
    override fun getTopInstitutionGroups(dataProvider: List<String>?): ResponseEntity<GetTopInstitutionGroupsResponse> =
        ResponseEntity.ok(
            GetTopInstitutionGroupsResponse(
                data =
                    exec(
                        GetTopInstitutionGroups,
                        GetTopInstitutionGroups.Input(
                            dataProviders = dataProvider?.takeIf { it.isNotEmpty() } ?: listOf("PLAID"),
                        ),
                    ),
            ),
        )

    /**
     * Preview an account's `displayBalance` under the edit-form toggles
     * (`invertSyncedBalance`, `useAvailableBalance`). Pure read-only.
     */
    override fun previewAccountBalance(
        id: String,
        invertSyncedBalance: Boolean?,
        useAvailableBalance: Boolean?,
    ): ResponseEntity<PreviewAccountBalanceResponse> =
        ResponseEntity.ok(
            PreviewAccountBalanceResponse(
                data =
                    exec(
                        PreviewAccountBalance,
                        PreviewAccountBalance.Input(
                            accountId = id,
                            invertSyncedBalance = invertSyncedBalance,
                            useAvailableBalance = useAvailableBalance,
                        ),
                    ),
            ),
        )

    /** Visual account-tab groupings (id, name, order, optional collapsed flag, member ids). */
    override fun getAccountGroups(): ResponseEntity<GetAccountGroupsResponse> =
        ResponseEntity.ok(GetAccountGroupsResponse(data = exec(GetAccountGroups, Unit)))

    /** Persist a reordered set of account groups; whole-set replace from the array index. */
    override fun updateAccountGroupOrder(
        updateAccountGroupOrderRequest: UpdateAccountGroupOrderRequest,
    ): ResponseEntity<UpdateAccountGroupOrderResponse> =
        ResponseEntity.ok(
            UpdateAccountGroupOrderResponse(
                data = exec(UpdateAccountGroupOrder, UpdateAccountGroupOrder.Input.from(updateAccountGroupOrderRequest)),
            ),
        )
}
