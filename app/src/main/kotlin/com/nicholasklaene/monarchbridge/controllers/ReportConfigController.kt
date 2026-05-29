package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.ReportConfigApi
import com.nicholasklaene.monarchbridge.generated.model.FeatureAreaResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.features.CreateReportConfiguration
import com.nicholasklaene.monarchbridge.graphql.operations.features.DeleteReportConfiguration
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetReportConfigurations
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetReportConfigurationsForCommandPalette
import com.nicholasklaene.monarchbridge.graphql.operations.features.UpdateReportConfiguration
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Saved-report configurations endpoints. Each route forwards exactly one Monarch
 * GraphQL operation as an opaque FreeForm response. Saved-report configurations CRUD.
 *
 * Wiring layer only: the deep response tree is passed through as
 * `Map<String, Any?>`. If a specific endpoint becomes load-bearing for a caller,
 * lift it out of here into a typed response shape.
 */
@RestController
@Suppress("LargeClass", "TooManyFunctions")
class ReportConfigController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    ReportConfigApi {
    /** Pass-through for `Web_GetReportConfigurationsForCommandPalette` */
    override fun reportConfigsCommandPalette(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(GetReportConfigurationsForCommandPalette, Unit)))

    /** Pass-through for `Common_CreateReportConfiguration` */
    override fun reportConfigsCreate(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(CreateReportConfiguration, Unit)))

    /** Pass-through for `Common_DeleteReportConfiguration` */
    override fun reportConfigsDelete(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(DeleteReportConfiguration, Unit)))

    /** Pass-through for `Common_GetReportConfigurations` */
    override fun reportConfigsList(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(GetReportConfigurations, Unit)))

    /** Pass-through for `Common_UpdateReportConfiguration` */
    override fun reportConfigsUpdate(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(UpdateReportConfiguration, Unit)))
}
