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

@WebMvcTest(ReportConfigController::class)
@Import(GlobalExceptionHandler::class)
@Suppress("LargeClass")
class ReportConfigControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `reportConfigsCommandPalette returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/report-configs/command-palette"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `reportConfigsCreate returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/report-configs/create"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `reportConfigsDelete returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/report-configs/delete"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `reportConfigsList returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/report-configs"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `reportConfigsUpdate returns FeatureArea envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/report-configs/update"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }
}
