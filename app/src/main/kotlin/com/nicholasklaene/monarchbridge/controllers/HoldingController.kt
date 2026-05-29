package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.HoldingsApi
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateHoldingsRequest
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateHoldingsResponse
import com.nicholasklaene.monarchbridge.generated.model.CreateManualAccountResponse
import com.nicholasklaene.monarchbridge.generated.model.CreateManualHoldingRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateManualHoldingResponse
import com.nicholasklaene.monarchbridge.generated.model.CreateManualInvestmentsAccountRequest
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponse
import com.nicholasklaene.monarchbridge.generated.model.GetHoldingHistoryResponse
import com.nicholasklaene.monarchbridge.generated.model.GetHoldingTransactionsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetPortfolioAllocationByHoldingsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetPortfolioAllocationHoldingsDetailResponse
import com.nicholasklaene.monarchbridge.generated.model.GetPortfolioAllocationResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSecurityDetailsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSecurityDividendsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSecurityHistoricalPerformanceResponse
import com.nicholasklaene.monarchbridge.generated.model.SearchSecuritiesResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateHoldingRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateHoldingResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.CreateManualHolding
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.CreateManualInvestmentsAccount
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.DeleteHolding
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.SecuritySearch
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.UpdateHolding
import com.nicholasklaene.monarchbridge.graphql.operations.holdings.BulkUpdateHoldings
import com.nicholasklaene.monarchbridge.graphql.operations.holdings.GetHoldingTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.investments.GetHoldingHistory
import com.nicholasklaene.monarchbridge.graphql.operations.investments.GetPortfolioAllocation
import com.nicholasklaene.monarchbridge.graphql.operations.investments.GetPortfolioAllocationByAccount
import com.nicholasklaene.monarchbridge.graphql.operations.investments.GetPortfolioAllocationByHoldings
import com.nicholasklaene.monarchbridge.graphql.operations.investments.GetPortfolioAllocationHoldingsDetail
import com.nicholasklaene.monarchbridge.graphql.operations.investments.GetSecurityDetails
import com.nicholasklaene.monarchbridge.graphql.operations.investments.GetSecurityDividends
import com.nicholasklaene.monarchbridge.graphql.operations.investments.GetSecurityHistoricalPerformance
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

/**
 * Manual holdings, manual investments accounts, and Monarch's security catalog search.
 * All HTTP wiring (paths, params, response types) comes from the spec-generated [HoldingsApi];
 * this class dispatches each method to the matching GraphQL operation and wraps the typed
 * payload in the matching spec-generated `*Response` envelope.
 *
 * `createManualInvestmentsAccount` and `deleteHolding` return spec types that the OpenAPI
 * generator deduplicated against existing account schemas (identical shape) — the GraphQL
 * operations target Monarch's holding/investment mutations regardless of the typename reuse.
 */
@RestController
@Suppress("TooManyFunctions", "LargeClass")
class HoldingController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    HoldingsApi {
    override fun createManualHolding(
        id: String,
        createManualHoldingRequest: CreateManualHoldingRequest,
    ): ResponseEntity<CreateManualHoldingResponse> =
        ResponseEntity.ok(
            CreateManualHoldingResponse(
                data = exec(CreateManualHolding, CreateManualHolding.Input.from(id, createManualHoldingRequest)),
            ),
        )

    override fun updateHolding(
        id: String,
        updateHoldingRequest: UpdateHoldingRequest,
    ): ResponseEntity<UpdateHoldingResponse> =
        ResponseEntity.ok(
            UpdateHoldingResponse(
                data = exec(UpdateHolding, UpdateHolding.Input.from(id, updateHoldingRequest)),
            ),
        )

    override fun deleteHolding(id: String): ResponseEntity<DeleteAccountResponse> =
        ResponseEntity.ok(DeleteAccountResponse(data = exec(DeleteHolding, DeleteHolding.Input(id))))

    override fun createManualInvestmentsAccount(
        createManualInvestmentsAccountRequest: CreateManualInvestmentsAccountRequest,
    ): ResponseEntity<CreateManualAccountResponse> =
        ResponseEntity.ok(
            CreateManualAccountResponse(
                data =
                    exec(
                        CreateManualInvestmentsAccount,
                        CreateManualInvestmentsAccount.Input.from(createManualInvestmentsAccountRequest),
                    ),
            ),
        )

    override fun searchSecurities(
        q: String,
        limit: Int?,
        orderByPopularity: Boolean?,
    ): ResponseEntity<SearchSecuritiesResponse> =
        ResponseEntity.ok(
            SearchSecuritiesResponse(
                data =
                    exec(
                        SecuritySearch,
                        SecuritySearch.Input(search = q, limit = limit, orderByPopularity = orderByPopularity),
                    ),
            ),
        )

    /** Allocation breakdown by `classificationField` (security type, asset class, sector). */
    override fun getPortfolioAllocation(
        accountIds: List<String>?,
        classificationField: String?,
    ): ResponseEntity<GetPortfolioAllocationResponse> =
        ResponseEntity.ok(
            GetPortfolioAllocationResponse(
                data =
                    exec(
                        GetPortfolioAllocation,
                        GetPortfolioAllocation.Input(
                            accountIds = accountIds,
                            classificationField = classificationField,
                        ),
                    ),
            ),
        )

    /** Allocation grouped per investments account; each row = one account. */
    override fun getPortfolioAllocationByAccount(
        accountIds: List<String>?,
        limit: Int?,
    ): ResponseEntity<GetPortfolioAllocationByHoldingsResponse> =
        ResponseEntity.ok(
            GetPortfolioAllocationByHoldingsResponse(
                data =
                    exec(
                        GetPortfolioAllocationByAccount,
                        GetPortfolioAllocationByAccount.Input(accountIds = accountIds, limit = limit),
                    ),
            ),
        )

    /** Allocation grouped per holding (ticker / security name); each row = one security. */
    override fun getPortfolioAllocationByHoldings(
        accountIds: List<String>?,
        limit: Int?,
    ): ResponseEntity<GetPortfolioAllocationByHoldingsResponse> =
        ResponseEntity.ok(
            GetPortfolioAllocationByHoldingsResponse(
                data =
                    exec(
                        GetPortfolioAllocationByHoldings,
                        GetPortfolioAllocationByHoldings.Input(accountIds = accountIds, limit = limit),
                    ),
            ),
        )

    /** Drill-down: individual holdings within one allocation bucket. */
    override fun getPortfolioAllocationHoldingsDetail(
        classificationField: String,
        classificationValue: String,
        accountIds: List<String>?,
        limit: Int?,
        offset: Int?,
    ): ResponseEntity<GetPortfolioAllocationHoldingsDetailResponse> =
        ResponseEntity.ok(
            GetPortfolioAllocationHoldingsDetailResponse(
                data =
                    exec(
                        GetPortfolioAllocationHoldingsDetail,
                        GetPortfolioAllocationHoldingsDetail.Input(
                            classificationField = classificationField,
                            classificationValue = classificationValue,
                            accountIds = accountIds,
                            limit = limit,
                            offset = offset,
                        ),
                    ),
            ),
        )

    /** Per-day price and cumulative-return chart for one security plus its current and closing price. */
    override fun getSecurityHistoricalPerformance(
        id: String,
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetSecurityHistoricalPerformanceResponse> =
        ResponseEntity.ok(
            GetSecurityHistoricalPerformanceResponse(
                data =
                    exec(
                        GetSecurityHistoricalPerformance,
                        GetSecurityHistoricalPerformance.Input(
                            securityId = id,
                            startDate = start,
                            endDate = end,
                        ),
                    ),
            ),
        )

    /** Per-day quantity / value / price series for one holding. */
    override fun getHoldingHistory(
        id: String,
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetHoldingHistoryResponse> =
        ResponseEntity.ok(
            GetHoldingHistoryResponse(
                data =
                    exec(
                        GetHoldingHistory,
                        GetHoldingHistory.Input(holdingId = id, startDate = start, endDate = end),
                    ),
            ),
        )

    /** Full security metadata (ticker, name, sector, fundamentals). */
    override fun getSecurityDetails(id: String): ResponseEntity<GetSecurityDetailsResponse> =
        ResponseEntity.ok(
            GetSecurityDetailsResponse(
                data = exec(GetSecurityDetails, GetSecurityDetails.Input(id = id)),
            ),
        )

    /** Dividend payment history for one security across a window. */
    override fun getSecurityDividends(
        id: String,
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetSecurityDividendsResponse> =
        ResponseEntity.ok(
            GetSecurityDividendsResponse(
                data =
                    exec(
                        GetSecurityDividends,
                        GetSecurityDividends.Input(id = id, startDate = start, endDate = end),
                    ),
            ),
        )

    /** Multi-holding update in one round-trip; returns updated + failed counts plus failure rows. */
    override fun bulkUpdateHoldings(bulkUpdateHoldingsRequest: BulkUpdateHoldingsRequest): ResponseEntity<BulkUpdateHoldingsResponse> =
        ResponseEntity.ok(
            BulkUpdateHoldingsResponse(
                data = exec(BulkUpdateHoldings, BulkUpdateHoldings.Input.from(bulkUpdateHoldingsRequest)),
            ),
        )

    /** Lots / trades for one holding over a date window. */
    override fun getHoldingTransactions(
        id: String,
        start: LocalDate?,
        end: LocalDate?,
        limit: Int?,
        offset: Int?,
    ): ResponseEntity<GetHoldingTransactionsResponse> =
        ResponseEntity.ok(
            GetHoldingTransactionsResponse(
                data =
                    exec(
                        GetHoldingTransactions,
                        GetHoldingTransactions.Input(
                            holdingId = id,
                            startDate = start,
                            endDate = end,
                            limit = limit,
                            offset = offset,
                        ),
                    ),
            ),
        )
}
