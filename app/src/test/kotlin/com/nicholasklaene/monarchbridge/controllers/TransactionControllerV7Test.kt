package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.GetSpendingTrendsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionSplitTemplatesResponseData
import com.nicholasklaene.monarchbridge.generated.model.MarkAsRecurringResponseData
import com.nicholasklaene.monarchbridge.generated.model.RecurringStreamRef
import com.nicholasklaene.monarchbridge.generated.model.SpendingTrendCategory
import com.nicholasklaene.monarchbridge.generated.model.SpendingTrends
import com.nicholasklaene.monarchbridge.generated.model.SplitTemplate
import com.nicholasklaene.monarchbridge.generated.model.SplitTemplateEntry
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TransactionController::class)
@Import(GlobalExceptionHandler::class)
class TransactionControllerV7Test {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    // -- markAsRecurring --------------------------------------------------

    @Test
    fun `markAsRecurring returns success and the new stream id`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            MarkAsRecurringResponseData(
                success = true,
                stream = RecurringStreamRef(id = "s-new", name = "monthly"),
            ),
        )
        mvc
            .perform(
                post("/v1/transactions/t1/recurring")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"frequency":"monthly"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.success").value(true))
            .andExpect(jsonPath("$.data.stream.id").value("s-new"))
    }

    @Test
    fun `markAsRecurring returns 400 when frequency is outside enum`() {
        // frequency is a required enum-restricted field.
        mvc
            .perform(
                post("/v1/transactions/t1/recurring")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"frequency":"every_full_moon"}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `markAsRecurring returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(
                post("/v1/transactions/t1/recurring")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"frequency":"monthly"}"""),
            ).andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    // -- getSpendingTrends ------------------------------------------------

    @Test
    fun `getSpendingTrends returns delta plus rising and falling categories`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetSpendingTrendsResponseData(
                trends =
                    SpendingTrends(
                        timeframe = "month",
                        currentPeriodTotal = -3200.0,
                        previousPeriodTotal = -2800.0,
                        deltaAmount = -400.0,
                        deltaPercent = 0.142,
                        risingCategories =
                            listOf(SpendingTrendCategory(categoryId = "c1", name = "Dining", deltaPercent = 0.35)),
                        fallingCategories =
                            listOf(SpendingTrendCategory(categoryId = "c2", name = "Subs", deltaPercent = -0.50)),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/dashboard/spending/trends").param("timeframe", "month"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.trends.timeframe").value("month"))
            .andExpect(jsonPath("$.data.trends.deltaAmount").value(-400.0))
            .andExpect(jsonPath("$.data.trends.risingCategories[0].name").value("Dining"))
            .andExpect(jsonPath("$.data.trends.fallingCategories[0].deltaPercent").value(-0.50))
    }

    @Test
    fun `getSpendingTrends uses default timeframe when not provided`() {
        // timeframe has default=month in the spec; bare request must succeed.
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetSpendingTrendsResponseData(
                trends =
                    SpendingTrends(
                        risingCategories = emptyList(),
                        fallingCategories = emptyList(),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/dashboard/spending/trends"))
            .andExpect(status().isOk)
    }

    // NOTE: spec-side enum-on-query-param validation for `timeframe` is a follow-up.
    // The current spec accepts free-form strings; tightening to `enum: [month, quarter, year]`
    // is tracked separately so the 400-on-bad-enum test becomes meaningful again.

    // -- getTransactionSplitTemplates -------------------------------------

    @Test
    fun `getTransactionSplitTemplates returns each template with percent splits`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTransactionSplitTemplatesResponseData(
                templates =
                    listOf(
                        SplitTemplate(
                            id = "tpl-1",
                            name = "Costco run",
                            splits =
                                listOf(
                                    SplitTemplateEntry(categoryId = "c-grocery", categoryName = "Groceries", percent = 70.0),
                                    SplitTemplateEntry(categoryId = "c-household", categoryName = "Household", percent = 30.0),
                                ),
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/transactions/split-templates"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.templates[0].id").value("tpl-1"))
            .andExpect(jsonPath("$.data.templates[0].name").value("Costco run"))
            .andExpect(jsonPath("$.data.templates[0].splits[0].percent").value(70.0))
            .andExpect(jsonPath("$.data.templates[0].splits[1].categoryName").value("Household"))
    }

    @Test
    fun `getTransactionSplitTemplates returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/transactions/split-templates"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
