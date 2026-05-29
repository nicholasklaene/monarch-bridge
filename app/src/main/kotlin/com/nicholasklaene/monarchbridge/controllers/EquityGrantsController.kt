package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.EquityGrantsApi
import com.nicholasklaene.monarchbridge.generated.model.FeatureAreaResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.features.CreateEquityGrant
import com.nicholasklaene.monarchbridge.graphql.operations.features.DeleteEquityGrant
import com.nicholasklaene.monarchbridge.graphql.operations.features.EditEquityGrantModalGetEquityGrant
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetEquityGrants
import com.nicholasklaene.monarchbridge.graphql.operations.features.ManageEquityHoldingsModalGetEquityGrants
import com.nicholasklaene.monarchbridge.graphql.operations.features.PreviewEquityGrant
import com.nicholasklaene.monarchbridge.graphql.operations.features.UpdateEquityGrant
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Equity-grants feature endpoints. Each route forwards exactly one Monarch
 * GraphQL operation as an opaque FreeForm response. Equity grants CRUD + modal detail queries.
 *
 * Wiring layer only: the deep response tree is passed through as
 * `Map<String, Any?>`. If a specific endpoint becomes load-bearing for a caller,
 * lift it out of here into a typed response shape.
 */
@RestController
@Suppress("LargeClass", "TooManyFunctions")
class EquityGrantsController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    EquityGrantsApi {
    /** Pass-through for `Web_CreateEquityGrant` */
    override fun equityGrantsCreate(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(CreateEquityGrant, Unit)))

    /** Pass-through for `Web_DeleteEquityGrant` */
    override fun equityGrantsDelete(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(DeleteEquityGrant, Unit)))

    /** Pass-through for `Web_EditEquityGrantModal_GetEquityGrant` */
    override fun equityGrantsEditModal(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(EditEquityGrantModalGetEquityGrant, Unit)))

    /** Pass-through for `Web_GetEquityGrants` */
    override fun equityGrantsList(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(GetEquityGrants, Unit)))

    /** Pass-through for `Web_ManageEquityHoldingsModal_GetEquityGrants` */
    override fun equityGrantsManageHoldingsModal(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(ManageEquityHoldingsModalGetEquityGrants, Unit)))

    /** Pass-through for `Web_PreviewEquityGrant` */
    override fun equityGrantsPreview(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(PreviewEquityGrant, Unit)))

    /** Pass-through for `Web_UpdateEquityGrant` */
    override fun equityGrantsUpdate(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(UpdateEquityGrant, Unit)))
}
