package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.CookiePreferences
import com.nicholasklaene.monarchbridge.generated.model.GetCookiePreferencesResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(SettingsController::class)
@Import(GlobalExceptionHandler::class)
class SettingsControllerCookiesTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getCookiePreferences returns current consents`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCookiePreferencesResponseData(
                preferences =
                    CookiePreferences(
                        analytics = true,
                        marketing = false,
                        functional = true,
                        updatedAt = "2026-05-26T10:00:00Z",
                    ),
            ),
        )
        mvc
            .perform(get("/v1/me/cookies"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.preferences.analytics").value(true))
            .andExpect(jsonPath("$.data.preferences.marketing").value(false))
            .andExpect(jsonPath("$.data.preferences.functional").value(true))
            .andExpect(jsonPath("$.data.preferences.updatedAt").value("2026-05-26T10:00:00Z"))
    }

    @Test
    fun `getCookiePreferences returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/me/cookies"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `updateCookiePreferences echoes back the updated consents`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCookiePreferencesResponseData(
                preferences =
                    CookiePreferences(analytics = false, marketing = false, functional = true, updatedAt = "now"),
            ),
        )
        mvc
            .perform(
                patch("/v1/me/cookies")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"analytics":false}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.preferences.analytics").value(false))
            .andExpect(jsonPath("$.data.preferences.functional").value(true))
    }

    @Test
    fun `updateCookiePreferences accepts empty body since all fields are optional patches`() {
        // The spec marks no fields required on UpdateCookiePreferencesRequest; empty body is valid.
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCookiePreferencesResponseData(preferences = CookiePreferences()),
        )
        mvc
            .perform(
                patch("/v1/me/cookies")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{}"""),
            ).andExpect(status().isOk)
    }

    @Test
    fun `updateCookiePreferences returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(
                patch("/v1/me/cookies")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"analytics":true}"""),
            ).andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
