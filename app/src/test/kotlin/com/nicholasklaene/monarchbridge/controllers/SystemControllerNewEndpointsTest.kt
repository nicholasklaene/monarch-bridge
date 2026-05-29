package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.DismissNotificationResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetEntitlementsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetNotificationsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetNotificationsResponseDataEdgesInner
import com.nicholasklaene.monarchbridge.generated.model.GetPlusTierAccessResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetZestimateResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetZestimateResponseDataZestimatesInner
import com.nicholasklaene.monarchbridge.generated.model.MarkAllNotificationsAsReadResponseData
import com.nicholasklaene.monarchbridge.generated.model.MarkNotificationAsReadResponseData
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(SystemController::class)
@Import(GlobalExceptionHandler::class)
class SystemControllerNewEndpointsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getEntitlements wraps subscription id + entitlements`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, GetEntitlementsResponseData(id = "s-1", entitlements = listOf("a", "b")))
        mvc
            .perform(get("/v1/entitlements"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("s-1"))
            .andExpect(jsonPath("$.data.entitlements[0]").value("a"))
    }

    @Test
    fun `getEntitlements returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/entitlements"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getPlusTierAccess returns trial window`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetPlusTierAccessResponseData(
                id = "s-1",
                entitlements = listOf("plus"),
                plusTrialEndsAt = "2026-06-01T00:00:00Z",
            ),
        )
        mvc
            .perform(get("/v1/plus-tier"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.plusTrialEndsAt").value("2026-06-01T00:00:00Z"))
    }

    @Test
    fun `getNotifications returns paginated edges`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetNotificationsResponseData(
                hasNextPage = true,
                endCursor = "c",
                edges =
                    listOf(
                        GetNotificationsResponseDataEdgesInner(id = "n-1", title = "Hello"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/notifications").param("first", "20"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.hasNextPage").value(true))
            .andExpect(jsonPath("$.data.edges[0].title").value("Hello"))
    }

    @Test
    fun `markNotificationAsRead returns readAt`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, MarkNotificationAsReadResponseData(id = "n-1", readAt = "now"))
        mvc
            .perform(post("/v1/notifications/n-1/read"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("n-1"))
            .andExpect(jsonPath("$.data.readAt").value("now"))
    }

    @Test
    fun `dismissNotification returns dismissedAt`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DismissNotificationResponseData(id = "n-1", dismissedAt = "now"))
        mvc
            .perform(post("/v1/notifications/n-1/dismiss"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.dismissedAt").value("now"))
    }

    @Test
    fun `markAllNotificationsAsRead returns echoed edges`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            MarkAllNotificationsAsReadResponseData(
                edges =
                    listOf(
                        MarkNotificationAsReadResponseData(id = "n-1", readAt = "now"),
                    ),
            ),
        )
        mvc
            .perform(post("/v1/notifications/read-all"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.edges[0].id").value("n-1"))
    }

    @Test
    fun `clearAllNotifications returns success`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, MarkTransactionStreamAsNotRecurringResponseData(success = true))
        mvc
            .perform(post("/v1/notifications/clear-all"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.success").value(true))
    }

    @Test
    fun `getZestimate forwards address and returns zestimates`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetZestimateResponseData(
                zestimates =
                    listOf(
                        GetZestimateResponseDataZestimatesInner(
                            zpid = "z1",
                            addressCity = "Seattle",
                            zestimate = 750000.0,
                        ),
                    ),
            ),
        )
        mvc
            .perform(
                post("/v1/zillow/zestimate")
                    .contentType("application/json")
                    .content("""{"address": "1 Main St"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.zestimates[0].zpid").value("z1"))
            .andExpect(jsonPath("$.data.zestimates[0].zestimate").value(750000.0))
    }
}
