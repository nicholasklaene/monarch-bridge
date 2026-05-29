package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.DashboardRecurringItem
import com.nicholasklaene.monarchbridge.generated.model.GetRecurringDashboardResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListAllRecurringResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListRecurringAggregateResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListRecurringResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListRecurringStreamsResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateMerchantRecurrenceResponseData
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

@WebMvcTest(RecurringController::class)
@Import(GlobalExceptionHandler::class)
class RecurringControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `listRecurring wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListRecurringResponseData(
                items =
                    listOf(
                        mapOf("id" to "r1", "merchantName" to "Netflix"),
                        mapOf("id" to "r2", "merchantName" to "Spotify"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/recurring"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.items[0].id").value("r1"))
            .andExpect(jsonPath("$.data.items[0].merchantName").value("Netflix"))
            .andExpect(jsonPath("$.data.items[1].id").value("r2"))
    }

    @Test
    fun `listRecurring returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/recurring"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `listAllRecurring wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListAllRecurringResponseData(
                items = listOf(mapOf("stream" to mapOf("id" to "s-1", "name" to "Netflix"))),
            ),
        )
        mvc
            .perform(get("/v1/recurring/all").param("includeLiabilities", "true").param("includePending", "false"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.items").isArray)
            .andExpect(jsonPath("$.data.items[0].stream.name").value("Netflix"))
    }

    @Test
    fun `listRecurringStreams wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListRecurringStreamsResponseData(
                streams = listOf(mapOf("stream" to mapOf("id" to "s-2", "frequency" to "monthly"))),
            ),
        )
        mvc
            .perform(get("/v1/recurring/streams"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.streams[0].stream.id").value("s-2"))
    }

    @Test
    fun `listRecurringAggregate wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListRecurringAggregateResponseData(
                aggregate = mapOf("groups" to listOf(mapOf("groupBy" to mapOf("status" to "completed")))),
            ),
        )
        mvc
            .perform(get("/v1/recurring/aggregate"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.aggregate.groups[0].groupBy.status").value("completed"))
    }

    @Test
    fun `getRecurringDashboard wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetRecurringDashboardResponseData(
                items =
                    listOf(
                        DashboardRecurringItem(
                            date = java.time.LocalDate.parse("2026-05-15"),
                            amount = -15.99,
                            isPast = false,
                            streamId = "s-1",
                            streamName = "Netflix",
                        ),
                    ),
                remainingDueAmount = 200.0,
            ),
        )
        mvc
            .perform(get("/v1/recurring/dashboard"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.remainingDueAmount").value(200.0))
            .andExpect(jsonPath("$.data.items[0].streamName").value("Netflix"))
            .andExpect(jsonPath("$.data.items[0].amount").value(-15.99))
    }

    @Test
    fun `updateMerchantRecurrence wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateMerchantRecurrenceResponseData(
                merchant = mapOf("id" to "m1", "name" to "Netflix", "isRecurring" to true),
            ),
        )
        mvc
            .perform(
                patch("/v1/merchants/m1/recurrence")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name":"Netflix","isRecurring":true,"frequency":"monthly"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.merchant.id").value("m1"))
            .andExpect(jsonPath("$.data.merchant.name").value("Netflix"))
            .andExpect(jsonPath("$.data.merchant.isRecurring").value(true))
    }
}
