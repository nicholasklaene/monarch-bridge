package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.generated.model.GetRecurringForecastResponseData
import com.nicholasklaene.monarchbridge.generated.model.RecurringForecastEntry
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
import java.time.LocalDate

@WebMvcTest(RecurringController::class)
@Import(GlobalExceptionHandler::class)
class RecurringControllerForecastTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getRecurringForecast wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetRecurringForecastResponseData(
                forecast =
                    listOf(
                        RecurringForecastEntry(
                            date = LocalDate.parse("2026-06-01"),
                            amount = -15.99,
                            merchantName = "Netflix",
                            streamId = "s-1",
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/recurring/forecast?start=2026-06-01&end=2026-06-30"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.forecast[0].date").value("2026-06-01"))
            .andExpect(jsonPath("$.data.forecast[0].merchantName").value("Netflix"))
            .andExpect(jsonPath("$.data.forecast[0].amount").value(-15.99))
            .andExpect(jsonPath("$.data.forecast[0].streamId").value("s-1"))
    }
}
