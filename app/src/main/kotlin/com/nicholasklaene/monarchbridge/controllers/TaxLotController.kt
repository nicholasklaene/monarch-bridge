package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.TaxLotsApi
import com.nicholasklaene.monarchbridge.generated.model.CreateManualTaxLotRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateManualTaxLotResponse
import com.nicholasklaene.monarchbridge.generated.model.CreateManualTaxLotsBulkRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateManualTaxLotsBulkResponse
import com.nicholasklaene.monarchbridge.generated.model.DeleteTaxLotResponse
import com.nicholasklaene.monarchbridge.generated.model.DeleteTaxLotsBulkRequest
import com.nicholasklaene.monarchbridge.generated.model.DeleteTaxLotsBulkResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTaxLotPerformanceResponse
import com.nicholasklaene.monarchbridge.generated.model.ListTaxLotsResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateTaxLotRequest
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.taxlots.CreateManualTaxLot
import com.nicholasklaene.monarchbridge.graphql.operations.taxlots.CreateManualTaxLotsBulk
import com.nicholasklaene.monarchbridge.graphql.operations.taxlots.DeleteTaxLot
import com.nicholasklaene.monarchbridge.graphql.operations.taxlots.DeleteTaxLotsBulk
import com.nicholasklaene.monarchbridge.graphql.operations.taxlots.GetTaxLotPerformance
import com.nicholasklaene.monarchbridge.graphql.operations.taxlots.ListTaxLots
import com.nicholasklaene.monarchbridge.graphql.operations.taxlots.UpdateTaxLot
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Manual tax-lot CRUD + per-lot performance chart. All HTTP wiring comes from the
 * spec-generated [TaxLotsApi]; this class dispatches to operations under
 * `graphql.operations.taxlots/` and wraps each payload in the spec-generated
 * `*Response` envelope.
 *
 * The OpenAPI generator deduplicates `updateTaxLot`'s response shape against
 * `createManualTaxLot` (both return `{taxLot: TaxLot}`), so `updateTaxLot` is wired
 * through `CreateManualTaxLotResponse`.
 */
@RestController
class TaxLotController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    TaxLotsApi {
    /** List manual tax lots attached to one holding. */
    override fun listTaxLots(id: String): ResponseEntity<ListTaxLotsResponse> =
        ResponseEntity.ok(ListTaxLotsResponse(data = exec(ListTaxLots, ListTaxLots.Input(holdingId = id))))

    /** Create one manual tax lot under a holding. */
    override fun createManualTaxLot(
        id: String,
        createManualTaxLotRequest: CreateManualTaxLotRequest,
    ): ResponseEntity<CreateManualTaxLotResponse> =
        ResponseEntity.ok(
            CreateManualTaxLotResponse(
                data = exec(CreateManualTaxLot, CreateManualTaxLot.Input.from(id, createManualTaxLotRequest)),
            ),
        )

    /** Bulk-create manual tax lots under one investments account. */
    override fun createManualTaxLotsBulk(
        id: String,
        createManualTaxLotsBulkRequest: CreateManualTaxLotsBulkRequest,
    ): ResponseEntity<CreateManualTaxLotsBulkResponse> =
        ResponseEntity.ok(
            CreateManualTaxLotsBulkResponse(
                data = exec(CreateManualTaxLotsBulk, CreateManualTaxLotsBulk.Input.from(id, createManualTaxLotsBulkRequest)),
            ),
        )

    /** Partial-update one manual tax lot. */
    override fun updateTaxLot(
        id: String,
        updateTaxLotRequest: UpdateTaxLotRequest,
    ): ResponseEntity<CreateManualTaxLotResponse> =
        ResponseEntity.ok(
            CreateManualTaxLotResponse(
                data = exec(UpdateTaxLot, UpdateTaxLot.Input.from(id, updateTaxLotRequest)),
            ),
        )

    /** Delete one manual tax lot. */
    override fun deleteTaxLot(id: String): ResponseEntity<DeleteTaxLotResponse> =
        ResponseEntity.ok(DeleteTaxLotResponse(data = exec(DeleteTaxLot, DeleteTaxLot.Input(id))))

    /** Bulk-delete tax lots by id. */
    override fun deleteTaxLotsBulk(deleteTaxLotsBulkRequest: DeleteTaxLotsBulkRequest): ResponseEntity<DeleteTaxLotsBulkResponse> =
        ResponseEntity.ok(
            DeleteTaxLotsBulkResponse(
                data = exec(DeleteTaxLotsBulk, DeleteTaxLotsBulk.Input.from(deleteTaxLotsBulkRequest)),
            ),
        )

    /** Per-holding tax-lot performance chart (cost basis / unrealized gains / return percent). */
    override fun getTaxLotPerformance(id: String): ResponseEntity<GetTaxLotPerformanceResponse> =
        ResponseEntity.ok(
            GetTaxLotPerformanceResponse(
                data = exec(GetTaxLotPerformance, GetTaxLotPerformance.Input(holdingId = id)),
            ),
        )
}
