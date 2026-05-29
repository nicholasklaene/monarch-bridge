package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.SettingsApi
import com.nicholasklaene.monarchbridge.generated.model.GetAppearanceResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCookiePreferencesResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCurrencyResponse
import com.nicholasklaene.monarchbridge.generated.model.GetEmailNotificationPrefsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetFiscalYearResponse
import com.nicholasklaene.monarchbridge.generated.model.GetHouseholdMembersResponse
import com.nicholasklaene.monarchbridge.generated.model.GetHouseholdPreferencesResponse
import com.nicholasklaene.monarchbridge.generated.model.GetMeResponse
import com.nicholasklaene.monarchbridge.generated.model.GetMyHouseholdResponse
import com.nicholasklaene.monarchbridge.generated.model.GetNotificationPreferencesResponse
import com.nicholasklaene.monarchbridge.generated.model.InviteHouseholdMemberRequest
import com.nicholasklaene.monarchbridge.generated.model.InviteHouseholdMemberResponse
import com.nicholasklaene.monarchbridge.generated.model.RemoveHouseholdMemberResponse
import com.nicholasklaene.monarchbridge.generated.model.SetCurrencyRequest
import com.nicholasklaene.monarchbridge.generated.model.SetCurrencyResponse
import com.nicholasklaene.monarchbridge.generated.model.SetEmailNotificationPrefsRequest
import com.nicholasklaene.monarchbridge.generated.model.SetFiscalYearRequest
import com.nicholasklaene.monarchbridge.generated.model.SetFiscalYearResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateAppearanceRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateCookiePreferencesRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdNameRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdNameResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdPreferencesRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdPreferencesResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateMeRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateMeResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateNotificationPreferencesRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateNotificationPreferencesResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetAppearance
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetCookiePreferences
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetCurrency
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetEmailNotificationPrefs
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetFiscalYear
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetHouseholdMembers
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetHouseholdPreferences
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetMe
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetMyHousehold
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetNotificationPreferences
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetPushNotificationPrefs
import com.nicholasklaene.monarchbridge.graphql.operations.system.InviteHouseholdMember
import com.nicholasklaene.monarchbridge.graphql.operations.system.RemoveHouseholdMember
import com.nicholasklaene.monarchbridge.graphql.operations.system.SetCurrency
import com.nicholasklaene.monarchbridge.graphql.operations.system.SetEmailNotificationPrefs
import com.nicholasklaene.monarchbridge.graphql.operations.system.SetFiscalYear
import com.nicholasklaene.monarchbridge.graphql.operations.system.SetPushNotificationPrefs
import com.nicholasklaene.monarchbridge.graphql.operations.system.UpdateAppearance
import com.nicholasklaene.monarchbridge.graphql.operations.system.UpdateCookiePreferences
import com.nicholasklaene.monarchbridge.graphql.operations.system.UpdateHouseholdName
import com.nicholasklaene.monarchbridge.graphql.operations.system.UpdateHouseholdPreferences
import com.nicholasklaene.monarchbridge.graphql.operations.system.UpdateMe
import com.nicholasklaene.monarchbridge.graphql.operations.system.UpdateNotificationPreferences
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
@Suppress("TooManyFunctions", "LargeClass")
class SettingsController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    SettingsApi {
    override fun getMe(): ResponseEntity<GetMeResponse> = ResponseEntity.ok(GetMeResponse(data = exec(GetMe, Unit)))

    override fun updateMe(updateMeRequest: UpdateMeRequest): ResponseEntity<UpdateMeResponse> =
        ResponseEntity.ok(UpdateMeResponse(data = exec(UpdateMe, UpdateMe.Input.from(updateMeRequest))))

    override fun getMyHousehold(): ResponseEntity<GetMyHouseholdResponse> =
        ResponseEntity.ok(GetMyHouseholdResponse(data = exec(GetMyHousehold, Unit)))

    override fun getHouseholdMembers(): ResponseEntity<GetHouseholdMembersResponse> =
        ResponseEntity.ok(GetHouseholdMembersResponse(data = exec(GetHouseholdMembers, Unit)))

    override fun getHouseholdPreferences(): ResponseEntity<GetHouseholdPreferencesResponse> =
        ResponseEntity.ok(GetHouseholdPreferencesResponse(data = exec(GetHouseholdPreferences, Unit)))

    override fun updateHouseholdPreferences(
        updateHouseholdPreferencesRequest: UpdateHouseholdPreferencesRequest,
    ): ResponseEntity<UpdateHouseholdPreferencesResponse> =
        ResponseEntity.ok(
            UpdateHouseholdPreferencesResponse(
                data = exec(UpdateHouseholdPreferences, UpdateHouseholdPreferences.Input.from(updateHouseholdPreferencesRequest)),
            ),
        )

    override fun getNotificationPreferences(): ResponseEntity<GetNotificationPreferencesResponse> =
        ResponseEntity.ok(GetNotificationPreferencesResponse(data = exec(GetNotificationPreferences, Unit)))

    override fun updateNotificationPreferences(
        updateNotificationPreferencesRequest: UpdateNotificationPreferencesRequest,
    ): ResponseEntity<UpdateNotificationPreferencesResponse> =
        ResponseEntity.ok(
            UpdateNotificationPreferencesResponse(
                data = exec(UpdateNotificationPreferences, UpdateNotificationPreferences.Input.from(updateNotificationPreferencesRequest)),
            ),
        )

    override fun getAppearance(): ResponseEntity<GetAppearanceResponse> =
        ResponseEntity.ok(GetAppearanceResponse(data = exec(GetAppearance, Unit)))

    override fun updateAppearance(updateAppearanceRequest: UpdateAppearanceRequest): ResponseEntity<GetAppearanceResponse> =
        ResponseEntity.ok(
            GetAppearanceResponse(
                data = exec(UpdateAppearance, UpdateAppearance.Input.from(updateAppearanceRequest)),
            ),
        )

    override fun getCookiePreferences(): ResponseEntity<GetCookiePreferencesResponse> =
        ResponseEntity.ok(GetCookiePreferencesResponse(data = exec(GetCookiePreferences, Unit)))

    override fun updateCookiePreferences(
        updateCookiePreferencesRequest: UpdateCookiePreferencesRequest,
    ): ResponseEntity<GetCookiePreferencesResponse> =
        ResponseEntity.ok(
            GetCookiePreferencesResponse(
                data = exec(UpdateCookiePreferences, UpdateCookiePreferences.Input.from(updateCookiePreferencesRequest)),
            ),
        )

    override fun getCurrency(): ResponseEntity<GetCurrencyResponse> = ResponseEntity.ok(GetCurrencyResponse(data = exec(GetCurrency, Unit)))

    override fun setCurrency(setCurrencyRequest: SetCurrencyRequest): ResponseEntity<SetCurrencyResponse> =
        ResponseEntity.ok(
            SetCurrencyResponse(data = exec(SetCurrency, SetCurrency.Input.from(setCurrencyRequest))),
        )

    override fun getFiscalYear(): ResponseEntity<GetFiscalYearResponse> =
        ResponseEntity.ok(GetFiscalYearResponse(data = exec(GetFiscalYear, Unit)))

    override fun setFiscalYear(setFiscalYearRequest: SetFiscalYearRequest): ResponseEntity<SetFiscalYearResponse> =
        ResponseEntity.ok(
            SetFiscalYearResponse(data = exec(SetFiscalYear, SetFiscalYear.Input.from(setFiscalYearRequest))),
        )

    override fun getEmailNotificationPrefs(): ResponseEntity<GetEmailNotificationPrefsResponse> =
        ResponseEntity.ok(GetEmailNotificationPrefsResponse(data = exec(GetEmailNotificationPrefs, Unit)))

    override fun setEmailNotificationPrefs(
        setEmailNotificationPrefsRequest: SetEmailNotificationPrefsRequest,
    ): ResponseEntity<GetEmailNotificationPrefsResponse> =
        ResponseEntity.ok(
            GetEmailNotificationPrefsResponse(
                data = exec(SetEmailNotificationPrefs, SetEmailNotificationPrefs.Input.from(setEmailNotificationPrefsRequest)),
            ),
        )

    override fun getPushNotificationPrefs(): ResponseEntity<GetEmailNotificationPrefsResponse> =
        ResponseEntity.ok(GetEmailNotificationPrefsResponse(data = exec(GetPushNotificationPrefs, Unit)))

    override fun setPushNotificationPrefs(
        setEmailNotificationPrefsRequest: SetEmailNotificationPrefsRequest,
    ): ResponseEntity<GetEmailNotificationPrefsResponse> =
        ResponseEntity.ok(
            GetEmailNotificationPrefsResponse(
                data = exec(SetPushNotificationPrefs, SetPushNotificationPrefs.Input.from(setEmailNotificationPrefsRequest)),
            ),
        )

    override fun updateHouseholdName(updateHouseholdNameRequest: UpdateHouseholdNameRequest): ResponseEntity<UpdateHouseholdNameResponse> =
        ResponseEntity.ok(
            UpdateHouseholdNameResponse(
                data = exec(UpdateHouseholdName, UpdateHouseholdName.Input.from(updateHouseholdNameRequest)),
            ),
        )

    override fun inviteHouseholdMember(
        inviteHouseholdMemberRequest: InviteHouseholdMemberRequest,
    ): ResponseEntity<InviteHouseholdMemberResponse> =
        ResponseEntity.ok(
            InviteHouseholdMemberResponse(
                data = exec(InviteHouseholdMember, InviteHouseholdMember.Input.from(inviteHouseholdMemberRequest)),
            ),
        )

    override fun removeHouseholdMember(id: String): ResponseEntity<RemoveHouseholdMemberResponse> =
        ResponseEntity.ok(
            RemoveHouseholdMemberResponse(
                data = exec(RemoveHouseholdMember, RemoveHouseholdMember.Input(id = id)),
            ),
        )
}
