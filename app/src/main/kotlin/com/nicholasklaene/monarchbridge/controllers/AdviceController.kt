package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.AdviceApi
import com.nicholasklaene.monarchbridge.generated.model.FeatureAreaResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.features.AdviceItemDrawerQuery
import com.nicholasklaene.monarchbridge.graphql.operations.features.AdviceQuery
import com.nicholasklaene.monarchbridge.graphql.operations.features.AdviceQuestionnaire
import com.nicholasklaene.monarchbridge.graphql.operations.features.AdviceTaskDrawerQuery
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetAdviceDashboardWidget
import com.nicholasklaene.monarchbridge.graphql.operations.features.MarkAdviceTaskComplete
import com.nicholasklaene.monarchbridge.graphql.operations.features.MarkAdviceTaskIncomplete
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Advice surface endpoints. Each route forwards exactly one Monarch
 * GraphQL operation as an opaque FreeForm response. Advice items, tasks, dashboard widget, questionnaire.
 *
 * Wiring layer only: the deep response tree is passed through as
 * `Map<String, Any?>`. If a specific endpoint becomes load-bearing for a caller,
 * lift it out of here into a typed response shape.
 */
@RestController
@Suppress("LargeClass", "TooManyFunctions")
class AdviceController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    AdviceApi {
    /** Pass-through for `AdviceQuery_Web` */
    override fun advice(): ResponseEntity<FeatureAreaResponse> = ResponseEntity.ok(FeatureAreaResponse(data = exec(AdviceQuery, Unit)))

    /** Pass-through for `Web_GetAdviceDashboardWidget` */
    override fun adviceDashboardWidget(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(GetAdviceDashboardWidget, Unit)))

    /** Pass-through for `AdviceItemDrawerQuery_Web` */
    override fun adviceItemDrawer(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(AdviceItemDrawerQuery, Unit)))

    /** Pass-through for `Web_AdviceQuestionnaire` */
    override fun adviceQuestionnaire(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(AdviceQuestionnaire, Unit)))

    /** Pass-through for `Web_MarkAdviceTaskComplete` */
    override fun adviceTaskComplete(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(MarkAdviceTaskComplete, Unit)))

    /** Pass-through for `AdviceTaskDrawerQuery_Web` */
    override fun adviceTaskDrawer(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(AdviceTaskDrawerQuery, Unit)))

    /** Pass-through for `Web_MarkAdviceTaskIncomplete` */
    override fun adviceTaskIncomplete(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(MarkAdviceTaskIncomplete, Unit)))
}
