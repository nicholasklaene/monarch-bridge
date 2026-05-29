package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.MerchantsApi
import com.nicholasklaene.monarchbridge.generated.model.DeleteMerchantResponse
import com.nicholasklaene.monarchbridge.generated.model.GetMerchantResponse
import com.nicholasklaene.monarchbridge.generated.model.GetMerchantStatsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetMerchantTransactionsResponse
import com.nicholasklaene.monarchbridge.generated.model.SearchMerchantsResponse
import com.nicholasklaene.monarchbridge.generated.model.SetMerchantLogoRequest
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.merchants.DeleteMerchant
import com.nicholasklaene.monarchbridge.graphql.operations.merchants.GetMerchant
import com.nicholasklaene.monarchbridge.graphql.operations.merchants.GetMerchantStats
import com.nicholasklaene.monarchbridge.graphql.operations.merchants.GetMerchantTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.merchants.SearchMerchants
import com.nicholasklaene.monarchbridge.graphql.operations.merchants.SearchMerchantsWithLogo
import com.nicholasklaene.monarchbridge.graphql.operations.merchants.SetMerchantLogo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

/**
 * Merchants — search, single-merchant detail, deletion, and logo updates. All HTTP wiring
 * comes from the spec-generated [MerchantsApi]; this class dispatches each method to the
 * matching GraphQL operation and wraps the typed payload.
 *
 * Notes on spec-generator dedupe:
 * - `setMerchantLogo` shares its response shape with `getMerchant`, so the generator
 *   collapses both into [GetMerchantResponse].
 */
@RestController
class MerchantController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    MerchantsApi {
    /**
     * Free-text search. `withLogo` flips between the two upstream queries:
     * - false (default): `GetMerchantsSearch` — no `logoUrl`, but honors `includeIds`.
     * - true: `GetMerchantsSearchWithLogo` — includes `logoUrl` and supports `offset`.
     *
     * The two upstream queries take different variable sets, so we pick one per call
     * rather than try to merge them.
     */
    override fun searchMerchants(
        q: String?,
        limit: Int?,
        offset: Int?,
        withLogo: Boolean,
        includeIds: List<String>?,
    ): ResponseEntity<SearchMerchantsResponse> {
        val data =
            if (withLogo) {
                exec(SearchMerchantsWithLogo, SearchMerchantsWithLogo.Input(search = q, limit = limit, offset = offset))
            } else {
                exec(SearchMerchants, SearchMerchants.Input(search = q, limit = limit, includeIds = includeIds))
            }
        return ResponseEntity.ok(SearchMerchantsResponse(data = data))
    }

    override fun getMerchant(id: String): ResponseEntity<GetMerchantResponse> =
        ResponseEntity.ok(GetMerchantResponse(data = exec(GetMerchant, GetMerchant.Input(id))))

    override fun deleteMerchant(
        id: String,
        moveToId: String?,
    ): ResponseEntity<DeleteMerchantResponse> =
        ResponseEntity.ok(DeleteMerchantResponse(data = exec(DeleteMerchant, DeleteMerchant.Input(id, moveToId))))

    /**
     * Returns [GetMerchantResponse] because the generator dedupes — `setMerchantLogo`
     * and `getMerchant` both return a `{merchant: Merchant}` envelope.
     */
    override fun setMerchantLogo(
        id: String,
        setMerchantLogoRequest: SetMerchantLogoRequest,
    ): ResponseEntity<GetMerchantResponse> =
        ResponseEntity.ok(
            GetMerchantResponse(data = exec(SetMerchantLogo, SetMerchantLogo.Input.from(id, setMerchantLogoRequest))),
        )

    /** Transaction list scoped to a single merchant id. */
    override fun getMerchantTransactions(
        id: String,
        limit: Int?,
        offset: Int?,
    ): ResponseEntity<GetMerchantTransactionsResponse> =
        ResponseEntity.ok(
            GetMerchantTransactionsResponse(
                data = exec(GetMerchantTransactions, GetMerchantTransactions.Input(merchantId = id, limit = limit, offset = offset)),
            ),
        )

    /** Per-merchant aggregate stats across a window (totals, count, average, first/last seen). */
    override fun getMerchantStats(
        id: String,
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetMerchantStatsResponse> =
        ResponseEntity.ok(
            GetMerchantStatsResponse(
                data = exec(GetMerchantStats, GetMerchantStats.Input(merchantId = id, startDate = start, endDate = end)),
            ),
        )
}
