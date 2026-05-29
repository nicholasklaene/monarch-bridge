package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.BusinessEntityApi
import com.nicholasklaene.monarchbridge.generated.model.FeatureAreaResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.features.AvailableBusinessEntityDemoScenarios
import com.nicholasklaene.monarchbridge.graphql.operations.features.DeleteBusinessEntity
import com.nicholasklaene.monarchbridge.graphql.operations.features.DeleteBusinessEntityLogo
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetBusinessEntity
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetBusinessEntityFinancials
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetBusinessEntityReportsDataByCategory
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetBusinessEntityReportsDataByGroup
import com.nicholasklaene.monarchbridge.graphql.operations.features.PopulateBusinessEntityDemo
import com.nicholasklaene.monarchbridge.graphql.operations.features.UpsertBusinessEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Business-entity surface endpoints. Each route forwards exactly one Monarch
 * GraphQL operation as an opaque FreeForm response. Business entity detail, upsert, financials, reports, demo.
 *
 * Wiring layer only: the deep response tree is passed through as
 * `Map<String, Any?>`. If a specific endpoint becomes load-bearing for a caller,
 * lift it out of here into a typed response shape.
 */
@RestController
@Suppress("LargeClass", "TooManyFunctions")
class BusinessEntityController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    BusinessEntityApi {
    /** Pass-through for `Common_DeleteBusinessEntity` */
    override fun businessEntitiesDelete(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(DeleteBusinessEntity, Unit)))

    /** Pass-through for `Common_DeleteBusinessEntityLogo` */
    override fun businessEntitiesDeleteLogo(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(DeleteBusinessEntityLogo, Unit)))

    /** Pass-through for `Web_PopulateBusinessEntityDemo` */
    override fun businessEntitiesDemoPopulate(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(PopulateBusinessEntityDemo, Unit)))

    /** Pass-through for `Web_AvailableBusinessEntityDemoScenarios` */
    override fun businessEntitiesDemoScenarios(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(AvailableBusinessEntityDemoScenarios, Unit)))

    /** Pass-through for `Common_GetBusinessEntity` */
    override fun businessEntitiesDetail(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(GetBusinessEntity, Unit)))

    /** Pass-through for `Common_GetBusinessEntityFinancials` */
    override fun businessEntitiesFinancials(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(GetBusinessEntityFinancials, Unit)))

    /** Pass-through for `Common_GetBusinessEntityReportsDataByCategory` */
    override fun businessEntitiesReportsByCategory(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(GetBusinessEntityReportsDataByCategory, Unit)))

    /** Pass-through for `Common_GetBusinessEntityReportsDataByGroup` */
    override fun businessEntitiesReportsByGroup(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(GetBusinessEntityReportsDataByGroup, Unit)))

    /** Pass-through for `Common_UpsertBusinessEntity` */
    override fun businessEntitiesUpsert(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(UpsertBusinessEntity, Unit)))
}
