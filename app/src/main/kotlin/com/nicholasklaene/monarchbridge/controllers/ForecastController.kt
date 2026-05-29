package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.ForecastApi
import com.nicholasklaene.monarchbridge.generated.model.FeatureAreaResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.features.CreateForecastScenario
import com.nicholasklaene.monarchbridge.graphql.operations.features.DeleteForecastScenario
import com.nicholasklaene.monarchbridge.graphql.operations.features.DuplicateForecastScenario
import com.nicholasklaene.monarchbridge.graphql.operations.features.ForecastScenario
import com.nicholasklaene.monarchbridge.graphql.operations.features.ForecastScenarios
import com.nicholasklaene.monarchbridge.graphql.operations.features.ForecastUpdateUserFinancialProfile
import com.nicholasklaene.monarchbridge.graphql.operations.features.InitializeForecast
import com.nicholasklaene.monarchbridge.graphql.operations.features.MarkForecastOnboardingComplete
import com.nicholasklaene.monarchbridge.graphql.operations.features.ReplaceForecastEvents
import com.nicholasklaene.monarchbridge.graphql.operations.features.ResetForecastData
import com.nicholasklaene.monarchbridge.graphql.operations.features.ResetForecastOnboarding
import com.nicholasklaene.monarchbridge.graphql.operations.features.SaveForecastAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.features.SaveForecastParticipantOverrides
import com.nicholasklaene.monarchbridge.graphql.operations.features.SaveForecastPriorityRules
import com.nicholasklaene.monarchbridge.graphql.operations.features.SaveForecastScenarioKpis
import com.nicholasklaene.monarchbridge.graphql.operations.features.UpdateForecastScenario
import com.nicholasklaene.monarchbridge.graphql.operations.features.UpdateForecastScenarioOrder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Forecast feature endpoints. Each route forwards exactly one Monarch
 * GraphQL operation as an opaque FreeForm response. Forecast scenarios, events, accounts, KPIs, onboarding.
 *
 * Wiring layer only: the deep response tree is passed through as
 * `Map<String, Any?>`. If a specific endpoint becomes load-bearing for a caller,
 * lift it out of here into a typed response shape.
 */
@RestController
@Suppress("LargeClass", "TooManyFunctions")
class ForecastController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    ForecastApi {
    /** Pass-through for `Web_CreateForecastScenario` */
    override fun forecastCreateScenario(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(CreateForecastScenario, Unit)))

    /** Pass-through for `Web_DeleteForecastScenario` */
    override fun forecastDeleteScenario(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(DeleteForecastScenario, Unit)))

    /** Pass-through for `Web_DuplicateForecastScenario` */
    override fun forecastDuplicateScenario(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(DuplicateForecastScenario, Unit)))

    /** Pass-through for `Web_InitializeForecast` */
    override fun forecastInitialize(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(InitializeForecast, Unit)))

    /** Pass-through for `Web_MarkForecastOnboardingComplete` */
    override fun forecastOnboardingComplete(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(MarkForecastOnboardingComplete, Unit)))

    /** Pass-through for `Web_ReplaceForecastEvents` */
    override fun forecastReplaceEvents(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(ReplaceForecastEvents, Unit)))

    /** Pass-through for `Web_ResetForecastData` */
    override fun forecastResetData(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(ResetForecastData, Unit)))

    /** Pass-through for `Web_ResetForecastOnboarding` */
    override fun forecastResetOnboarding(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(ResetForecastOnboarding, Unit)))

    /** Pass-through for `Web_SaveForecastAccounts` */
    override fun forecastSaveAccounts(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(SaveForecastAccounts, Unit)))

    /** Pass-through for `Web_SaveForecastParticipantOverrides` */
    override fun forecastSaveParticipantOverrides(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(SaveForecastParticipantOverrides, Unit)))

    /** Pass-through for `Web_SaveForecastPriorityRules` */
    override fun forecastSavePriorityRules(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(SaveForecastPriorityRules, Unit)))

    /** Pass-through for `Web_SaveForecastScenarioKpis` */
    override fun forecastSaveScenarioKpis(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(SaveForecastScenarioKpis, Unit)))

    /** Pass-through for `Web_ForecastScenario` */
    override fun forecastScenario(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(ForecastScenario, Unit)))

    /** Pass-through for `Web_ForecastScenarios` */
    override fun forecastScenarios(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(ForecastScenarios, Unit)))

    /** Pass-through for `Web_UpdateForecastScenario` */
    override fun forecastUpdateScenario(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(UpdateForecastScenario, Unit)))

    /** Pass-through for `Web_UpdateForecastScenarioOrder` */
    override fun forecastUpdateScenarioOrder(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(UpdateForecastScenarioOrder, Unit)))

    /** Pass-through for `Web_ForecastUpdateUserFinancialProfile` */
    override fun forecastUpdateUserFinancialProfile(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(ForecastUpdateUserFinancialProfile, Unit)))
}
