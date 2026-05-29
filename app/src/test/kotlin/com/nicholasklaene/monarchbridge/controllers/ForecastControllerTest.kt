package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(ForecastController::class)
@Import(GlobalExceptionHandler::class)
@Suppress("LargeClass")
class ForecastControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `forecastCreateScenario returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/scenarios/create"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastDeleteScenario returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/scenarios/delete"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastDuplicateScenario returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/scenarios/duplicate"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastInitialize returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/initialize"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastOnboardingComplete returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/onboarding/complete"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastReplaceEvents returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/events/replace"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastResetData returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/data/reset"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastResetOnboarding returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/onboarding/reset"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastSaveAccounts returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/accounts"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastSaveParticipantOverrides returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/participant-overrides"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastSavePriorityRules returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/priority-rules"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastSaveScenarioKpis returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/scenario-kpis"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastScenario returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/scenario"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastScenarios returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/scenarios"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastUpdateScenario returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/scenarios/update"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastUpdateScenarioOrder returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/scenarios/order"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `forecastUpdateUserFinancialProfile returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/forecast/user-financial-profile"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }
}
