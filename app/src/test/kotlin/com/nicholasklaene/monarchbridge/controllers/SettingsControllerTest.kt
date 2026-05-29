package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.GetHouseholdMembersResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetHouseholdMembersResponseDataMembersInner
import com.nicholasklaene.monarchbridge.generated.model.GetHouseholdPreferencesResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetMeResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetMyHouseholdResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdPreferencesResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateMeResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(SettingsController::class)
@Import(GlobalExceptionHandler::class)
class SettingsControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getMe wraps the me payload`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetMeResponseData(id = "u-1", email = "n@x.com", displayName = "Sam", householdRole = "owner"),
        )
        mvc
            .perform(get("/v1/me"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("u-1"))
            .andExpect(jsonPath("$.data.email").value("n@x.com"))
            .andExpect(jsonPath("$.data.householdRole").value("owner"))
    }

    @Test
    fun `getMe returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/me"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `updateMe forwards body and returns updated profile`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateMeResponseData(id = "u-1", email = "new@x.com", name = "Sam"),
        )
        mvc
            .perform(
                patch("/v1/me")
                    .contentType("application/json")
                    .content("""{"email": "new@x.com"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.email").value("new@x.com"))
    }

    @Test
    fun `getMyHousehold returns the household envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, GetMyHouseholdResponseData(id = "h-1", name = "Acme Household", city = "Seattle"))
        mvc
            .perform(get("/v1/household"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("h-1"))
            .andExpect(jsonPath("$.data.city").value("Seattle"))
    }

    @Test
    fun `getHouseholdMembers returns meId, householdId, and member list`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetHouseholdMembersResponseData(
                meId = "u-1",
                householdId = "h-1",
                members =
                    listOf(
                        GetHouseholdMembersResponseDataMembersInner(id = "u-1", name = "Sam", householdRole = "owner"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/household/members"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.meId").value("u-1"))
            .andExpect(jsonPath("$.data.members[0].id").value("u-1"))
    }

    @Test
    fun `getHouseholdPreferences returns prefs envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetHouseholdPreferencesResponseData(
                id = "p-1",
                newTransactionsNeedReview = true,
                aiAssistantEnabled = false,
            ),
        )
        mvc
            .perform(get("/v1/household/preferences"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("p-1"))
            .andExpect(jsonPath("$.data.newTransactionsNeedReview").value(true))
            .andExpect(jsonPath("$.data.aiAssistantEnabled").value(false))
    }

    @Test
    fun `updateHouseholdPreferences returns updated prefs`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateHouseholdPreferencesResponseData(id = "p-1", aiAssistantEnabled = true),
        )
        mvc
            .perform(
                patch("/v1/household/preferences")
                    .contentType("application/json")
                    .content("""{"aiAssistantEnabled": true}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.aiAssistantEnabled").value(true))
    }
}
