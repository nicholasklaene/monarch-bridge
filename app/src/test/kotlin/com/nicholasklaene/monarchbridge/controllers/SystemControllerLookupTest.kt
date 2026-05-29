package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.GetLookupResponseData
import com.nicholasklaene.monarchbridge.generated.model.LookupEntity
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(SystemController::class)
@Import(GlobalExceptionHandler::class)
@TestPropertySource(properties = ["monarch.refresh.poll-interval-ms=10"])
class SystemControllerLookupTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getLookup returns typed results envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetLookupResponseData(
                results =
                    listOf(
                        LookupEntity(id = "a1", type = "account", name = "Chase Checking", icon = null, logoUrl = "https://logo/chase.png"),
                        LookupEntity(id = "c1", type = "category", name = "Coffee", icon = "coffee", logoUrl = null),
                    ),
            ),
        )

        mvc
            .perform(get("/v1/lookup").param("q", "chase"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.results[0].id").value("a1"))
            .andExpect(jsonPath("$.data.results[0].type").value("account"))
            .andExpect(jsonPath("$.data.results[0].logoUrl").value("https://logo/chase.png"))
            .andExpect(jsonPath("$.data.results[1].type").value("category"))
    }

    @Test
    fun `getLookup returns 400 when q is missing`() {
        mvc
            .perform(get("/v1/lookup"))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `getLookup returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(get("/v1/lookup").param("q", "anything"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
