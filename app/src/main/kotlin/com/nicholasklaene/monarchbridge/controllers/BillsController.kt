package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.BillsApi
import com.nicholasklaene.monarchbridge.generated.model.FeatureAreaResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.features.BillingSettingsCancelSponsorship
import com.nicholasklaene.monarchbridge.graphql.operations.features.BillingSettingsHouseholdCountry
import com.nicholasklaene.monarchbridge.graphql.operations.features.BillingZipModalUpdatePostalCode
import com.nicholasklaene.monarchbridge.graphql.operations.features.ClaimBillItem
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetAdvisorBillingPage
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetBill
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetBillingSettings
import com.nicholasklaene.monarchbridge.graphql.operations.features.GetEmployeeBillingState
import com.nicholasklaene.monarchbridge.graphql.operations.features.MobileSignupBillingZipUpdatePostalCode
import com.nicholasklaene.monarchbridge.graphql.operations.features.OnboardingBillingZipGetPostalCode
import com.nicholasklaene.monarchbridge.graphql.operations.features.OnboardingBillingZipUpdatePostalCode
import com.nicholasklaene.monarchbridge.graphql.operations.features.RegisterBillSplitParticipant
import com.nicholasklaene.monarchbridge.graphql.operations.features.SetEmployeeBillingIssue
import com.nicholasklaene.monarchbridge.graphql.operations.features.SubmitBillSplitInitiatorEdit
import com.nicholasklaene.monarchbridge.graphql.operations.features.ToggleBillSyncTracking
import com.nicholasklaene.monarchbridge.graphql.operations.features.UnclaimBillItem
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Bills surface endpoints. Each route forwards exactly one Monarch
 * GraphQL operation as an opaque FreeForm response. Bill detail, bill-splits, billing-settings, postal-code flows.
 *
 * Wiring layer only: the deep response tree is passed through as
 * `Map<String, Any?>`. If a specific endpoint becomes load-bearing for a caller,
 * lift it out of here into a typed response shape.
 */
@RestController
@Suppress("LargeClass", "TooManyFunctions")
class BillsController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    BillsApi {
    /** Pass-through for `Web_GetAdvisorBillingPage` */
    override fun billsAdvisorBilling(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(GetAdvisorBillingPage, Unit)))

    /** Pass-through for `GetBillingSettings` */
    override fun billsBillingSettings(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(GetBillingSettings, Unit)))

    /** Pass-through for `Web_BillingSettingsCancelSponsorship` */
    override fun billsCancelSponsorship(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(BillingSettingsCancelSponsorship, Unit)))

    /** Pass-through for `Web_ClaimBillItem` */
    override fun billsClaimItem(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(ClaimBillItem, Unit)))

    /** Pass-through for `Web_GetBill` */
    override fun billsDetail(): ResponseEntity<FeatureAreaResponse> = ResponseEntity.ok(FeatureAreaResponse(data = exec(GetBill, Unit)))

    /** Pass-through for `Web_GetEmployeeBillingState` */
    override fun billsEmployeeBillingState(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(GetEmployeeBillingState, Unit)))

    /** Pass-through for `Web_BillingSettings_HouseholdCountry` */
    override fun billsHouseholdCountry(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(BillingSettingsHouseholdCountry, Unit)))

    /** Pass-through for `Mobile_SignupBillingZip_UpdateBillingPostalCode` */
    override fun billsMobileSignupUpdatePostalCode(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(MobileSignupBillingZipUpdatePostalCode, Unit)))

    /** Pass-through for `Web_OnboardingBillingZip_GetPostalCode` */
    override fun billsOnboardingGetPostalCode(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(OnboardingBillingZipGetPostalCode, Unit)))

    /** Pass-through for `Web_OnboardingBillingZip_UpdateBillingPostalCode` */
    override fun billsOnboardingUpdatePostalCode(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(OnboardingBillingZipUpdatePostalCode, Unit)))

    /** Pass-through for `Web_RegisterBillSplitParticipant` */
    override fun billsRegisterSplitParticipant(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(RegisterBillSplitParticipant, Unit)))

    /** Pass-through for `Web_SetEmployeeBillingIssue` */
    override fun billsSetEmployeeBillingIssue(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(SetEmployeeBillingIssue, Unit)))

    /** Pass-through for `Web_SubmitBillSplitInitiatorEdit` */
    override fun billsSubmitSplitInitiatorEdit(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(SubmitBillSplitInitiatorEdit, Unit)))

    /** Pass-through for `Common_ToggleBillSyncTracking` */
    override fun billsToggleSyncTracking(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(ToggleBillSyncTracking, Unit)))

    /** Pass-through for `Web_UnclaimBillItem` */
    override fun billsUnclaimItem(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(UnclaimBillItem, Unit)))

    /** Pass-through for `Web_BillingZipModal_UpdateBillingPostalCode` */
    override fun billsUpdatePostalCode(): ResponseEntity<FeatureAreaResponse> =
        ResponseEntity.ok(FeatureAreaResponse(data = exec(BillingZipModalUpdatePostalCode, Unit)))
}
