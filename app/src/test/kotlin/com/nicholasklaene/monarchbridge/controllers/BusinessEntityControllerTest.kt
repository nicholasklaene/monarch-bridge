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

@WebMvcTest(BusinessEntityController::class)
@Import(GlobalExceptionHandler::class)
@Suppress("LargeClass")
class BusinessEntityControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `businessEntitiesDelete returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/business-entities/delete"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `businessEntitiesDeleteLogo returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/business-entities/logo/delete"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `businessEntitiesDemoPopulate returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/business-entities/demo/populate"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `businessEntitiesDemoScenarios returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/business-entities/demo/scenarios"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `businessEntitiesDetail returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/business-entities/detail"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `businessEntitiesFinancials returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/business-entities/financials"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `businessEntitiesReportsByCategory returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/business-entities/reports/by-category"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `businessEntitiesReportsByGroup returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/business-entities/reports/by-group"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `businessEntitiesUpsert returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/business-entities/upsert"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }
}
