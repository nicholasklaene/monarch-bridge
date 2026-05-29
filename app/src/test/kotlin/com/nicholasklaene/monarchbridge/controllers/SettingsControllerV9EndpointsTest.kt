package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.ChannelNotificationPrefs
import com.nicholasklaene.monarchbridge.generated.model.CurrencyPreferences
import com.nicholasklaene.monarchbridge.generated.model.FiscalYearPreferences
import com.nicholasklaene.monarchbridge.generated.model.GetCurrencyResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetEmailNotificationPrefsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetFiscalYearResponseData
import com.nicholasklaene.monarchbridge.generated.model.InviteHouseholdMemberResponseData
import com.nicholasklaene.monarchbridge.generated.model.RemoveHouseholdMemberResponseData
import com.nicholasklaene.monarchbridge.generated.model.SetCurrencyResponseData
import com.nicholasklaene.monarchbridge.generated.model.SetFiscalYearResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdNameResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * v9 (currency, fiscal year, per-channel notification prefs, household name,
 * household member invite + remove) on [SettingsController].
 */
@WebMvcTest(SettingsController::class)
@Import(GlobalExceptionHandler::class)
@Suppress("LargeClass", "LongMethod")
class SettingsControllerV9EndpointsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    // -- Currency ---------------------------------------------------------

    @Test
    fun `getCurrency returns current currency preferences`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCurrencyResponseData(
                currency = CurrencyPreferences(currency = "USD", symbol = "$", position = "before"),
            ),
        )
        mvc
            .perform(get("/v1/me/currency"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.currency.currency").value("USD"))
            .andExpect(jsonPath("$.data.currency.symbol").value("$"))
            .andExpect(jsonPath("$.data.currency.position").value("before"))
    }

    @Test
    fun `getCurrency returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/me/currency"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `setCurrency echoes back the updated currency`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            SetCurrencyResponseData(
                currency = CurrencyPreferences(currency = "EUR", symbol = "€", position = "after"),
            ),
        )
        mvc
            .perform(
                put("/v1/me/currency")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"currency":"EUR","position":"after"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.currency.currency").value("EUR"))
            .andExpect(jsonPath("$.data.currency.position").value("after"))
    }

    @Test
    fun `setCurrency rejects body missing the required currency field`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        mvc
            .perform(
                put("/v1/me/currency")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"position":"before"}"""),
            ).andExpect(status().isBadRequest)
    }

    // -- Fiscal Year ------------------------------------------------------

    @Test
    fun `getFiscalYear returns current fiscal year settings`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetFiscalYearResponseData(
                fiscalYear = FiscalYearPreferences(startMonth = 7, startDay = 1),
            ),
        )
        mvc
            .perform(get("/v1/household/fiscal-year"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.fiscalYear.startMonth").value(7))
            .andExpect(jsonPath("$.data.fiscalYear.startDay").value(1))
    }

    @Test
    fun `setFiscalYear echoes back the updated settings`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            SetFiscalYearResponseData(
                fiscalYear = FiscalYearPreferences(startMonth = 4, startDay = 1),
            ),
        )
        mvc
            .perform(
                put("/v1/household/fiscal-year")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"startMonth":4,"startDay":1}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.fiscalYear.startMonth").value(4))
    }

    // -- Email notification prefs -----------------------------------------

    @Test
    fun `getEmailNotificationPrefs returns every toggle`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetEmailNotificationPrefsResponseData(
                prefs =
                    ChannelNotificationPrefs(
                        weeklyRecap = true,
                        budgetAlerts = false,
                        billReminders = true,
                        goalUpdates = false,
                        marketingTips = true,
                    ),
            ),
        )
        mvc
            .perform(get("/v1/preferences/notifications/email"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.prefs.weeklyRecap").value(true))
            .andExpect(jsonPath("$.data.prefs.budgetAlerts").value(false))
            .andExpect(jsonPath("$.data.prefs.marketingTips").value(true))
    }

    @Test
    fun `setEmailNotificationPrefs echoes back the updated toggles`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetEmailNotificationPrefsResponseData(
                prefs = ChannelNotificationPrefs(weeklyRecap = false, billReminders = true),
            ),
        )
        mvc
            .perform(
                put("/v1/preferences/notifications/email")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"weeklyRecap":false}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.prefs.weeklyRecap").value(false))
    }

    // -- Push notification prefs ------------------------------------------

    @Test
    fun `getPushNotificationPrefs returns every toggle`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetEmailNotificationPrefsResponseData(
                prefs =
                    ChannelNotificationPrefs(
                        weeklyRecap = false,
                        budgetAlerts = true,
                        billReminders = false,
                        goalUpdates = true,
                        marketingTips = false,
                    ),
            ),
        )
        mvc
            .perform(get("/v1/preferences/notifications/push"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.prefs.weeklyRecap").value(false))
            .andExpect(jsonPath("$.data.prefs.goalUpdates").value(true))
    }

    @Test
    fun `setPushNotificationPrefs echoes back the updated toggles`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetEmailNotificationPrefsResponseData(
                prefs = ChannelNotificationPrefs(billReminders = false),
            ),
        )
        mvc
            .perform(
                put("/v1/preferences/notifications/push")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"billReminders":false}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.prefs.billReminders").value(false))
    }

    // -- Household name ---------------------------------------------------

    @Test
    fun `updateHouseholdName echoes back the new name`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateHouseholdNameResponseData(name = "Klaene Home"),
        )
        mvc
            .perform(
                put("/v1/household/name")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name":"Klaene Home"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.name").value("Klaene Home"))
    }

    @Test
    fun `updateHouseholdName rejects body missing the required name field`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        mvc
            .perform(
                put("/v1/household/name")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{}"""),
            ).andExpect(status().isBadRequest)
    }

    // -- Household members ------------------------------------------------

    @Test
    fun `inviteHouseholdMember returns invitation confirmation`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            InviteHouseholdMemberResponseData(
                invited = true,
                email = "new@example.com",
                role = "member",
            ),
        )
        mvc
            .perform(
                post("/v1/household/members/invite")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"email":"new@example.com","role":"member"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.invited").value(true))
            .andExpect(jsonPath("$.data.email").value("new@example.com"))
            .andExpect(jsonPath("$.data.role").value("member"))
    }

    @Test
    fun `inviteHouseholdMember rejects body missing the required email field`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        mvc
            .perform(
                post("/v1/household/members/invite")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"role":"member"}"""),
            ).andExpect(status().isBadRequest)
    }

    @Test
    fun `removeHouseholdMember returns removal confirmation`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            RemoveHouseholdMemberResponseData(removed = true),
        )
        mvc
            .perform(delete("/v1/household/members/user-42"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.removed").value(true))
    }

    @Test
    fun `removeHouseholdMember returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(delete("/v1/household/members/user-42"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
