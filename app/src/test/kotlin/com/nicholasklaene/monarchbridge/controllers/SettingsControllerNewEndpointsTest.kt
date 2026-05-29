package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.generated.model.Appearance
import com.nicholasklaene.monarchbridge.generated.model.GetAppearanceResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetNotificationPreferencesResponseData
import com.nicholasklaene.monarchbridge.generated.model.NotificationPreference
import com.nicholasklaene.monarchbridge.generated.model.UpdateNotificationPreferencesResponseData
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

/**
 * Notification-prefs and appearance endpoints on [SettingsController]:
 *  GET   /v1/notifications/preferences  getNotificationPreferences
 *  PATCH /v1/notifications/preferences  updateNotificationPreferences
 *  GET   /v1/me/appearance              getAppearance
 *  PATCH /v1/me/appearance              updateAppearance
 */
@WebMvcTest(SettingsController::class)
@Import(GlobalExceptionHandler::class)
class SettingsControllerNewEndpointsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getNotificationPreferences returns preferences list`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetNotificationPreferencesResponseData(
                preferences =
                    listOf(
                        NotificationPreference(
                            id = "p-1",
                            group = "weekly",
                            type = "weekly_review",
                            title = "Weekly review",
                            emailEnabled = true,
                            pushEnabled = false,
                            inAppEnabled = true,
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/notifications/preferences"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.preferences[0].id").value("p-1"))
            .andExpect(jsonPath("$.data.preferences[0].emailEnabled").value(true))
            .andExpect(jsonPath("$.data.preferences[0].pushEnabled").value(false))
    }

    @Test
    fun `updateNotificationPreferences returns updated preference`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateNotificationPreferencesResponseData(
                preference =
                    NotificationPreference(
                        id = "p-1",
                        emailEnabled = false,
                        pushEnabled = false,
                        inAppEnabled = true,
                    ),
            ),
        )
        mvc
            .perform(
                patch("/v1/notifications/preferences")
                    .contentType("application/json")
                    .content("""{"id":"p-1","emailEnabled":false,"pushEnabled":false}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.preference.id").value("p-1"))
            .andExpect(jsonPath("$.data.preference.emailEnabled").value(false))
    }

    @Test
    fun `getAppearance returns theme color compactMode`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetAppearanceResponseData(
                appearance = Appearance(theme = "dark", accentColor = "#FF00FF", compactMode = false),
            ),
        )
        mvc
            .perform(get("/v1/me/appearance"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.appearance.theme").value("dark"))
            .andExpect(jsonPath("$.data.appearance.accentColor").value("#FF00FF"))
            .andExpect(jsonPath("$.data.appearance.compactMode").value(false))
    }

    @Test
    fun `updateAppearance forwards body and returns updated appearance`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetAppearanceResponseData(
                appearance = Appearance(theme = "system", accentColor = "#00FF00", compactMode = true),
            ),
        )
        mvc
            .perform(
                patch("/v1/me/appearance")
                    .contentType("application/json")
                    .content("""{"theme":"system","compactMode":true}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.appearance.theme").value("system"))
            .andExpect(jsonPath("$.data.appearance.compactMode").value(true))
    }
}
