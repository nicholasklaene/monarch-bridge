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

@WebMvcTest(EquityGrantsController::class)
@Import(GlobalExceptionHandler::class)
@Suppress("LargeClass")
class EquityGrantsControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `equityGrantsCreate returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/equity-grants/create"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `equityGrantsDelete returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/equity-grants/delete"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `equityGrantsEditModal returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/equity-grants/edit-modal/detail"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `equityGrantsList returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/equity-grants"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `equityGrantsManageHoldingsModal returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/equity-grants/manage-holdings-modal"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `equityGrantsPreview returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/equity-grants/preview"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `equityGrantsUpdate returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/equity-grants/update"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }
}
