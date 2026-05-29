package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.BudgetMonthCategoryAmounts
import com.nicholasklaene.monarchbridge.generated.model.BudgetMonthMonthlyAmount
import com.nicholasklaene.monarchbridge.generated.model.BudgetStatus
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetMonthResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetStatusResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetsResponseData
import com.nicholasklaene.monarchbridge.generated.model.ResetBudgetResponseData
import com.nicholasklaene.monarchbridge.generated.model.SetBudgetAmountResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateFlexRolloverSettingsResponseData
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(BudgetController::class)
@Import(GlobalExceptionHandler::class)
class BudgetControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getBudgets wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetBudgetsResponseData(
                categoryGroups = listOf(mapOf("id" to "g1", "name" to "Food")),
                budgetData = mapOf("foo" to "bar"),
            ),
        )
        mvc
            .perform(get("/v1/budgets"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.budgetData.foo").value("bar"))
            .andExpect(jsonPath("$.data.categoryGroups[0].id").value("g1"))
            .andExpect(jsonPath("$.data.categoryGroups[0].name").value("Food"))
    }

    @Test
    fun `setBudgetAmount validates body and returns 200`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, SetBudgetAmountResponseData(id = "b1", budgetAmount = 250.0))
        mvc
            .perform(
                post("/v1/budgets/items")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"amount":250.0,"startDate":"2026-05-01","categoryId":"c1"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("b1"))
            .andExpect(jsonPath("$.data.budgetAmount").value(250.0))
    }

    @Test
    fun `setBudgetAmount returns 400 when startDate pattern fails`() {
        mvc
            .perform(
                post("/v1/budgets/items")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"amount":250.0,"startDate":"not-a-date","categoryId":"c1"}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `resetBudget wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, ResetBudgetResponseData(reset = true))
        mvc
            .perform(
                post("/v1/budgets/reset")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"startDate":"2026-05-01"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.reset").value(true))
    }

    @Test
    fun `updateFlexibleBudget wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, SetBudgetAmountResponseData(id = "flex1", budgetAmount = 500.0))
        mvc
            .perform(
                put("/v1/budgets/flex")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"amount":500.0,"startDate":"2026-05-01"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("flex1"))
            .andExpect(jsonPath("$.data.budgetAmount").value(500.0))
    }

    @Test
    fun `updateFlexRolloverSettings wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateFlexRolloverSettingsResponseData(
                id = "roll1",
                startMonth = "2026-05-01",
                startingBalance = 0.0,
            ),
        )
        mvc
            .perform(
                put("/v1/budgets/flex/rollover")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"rolloverStartMonth":"2026-05-01","rolloverStartingBalance":0.0}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("roll1"))
            .andExpect(jsonPath("$.data.startMonth").value("2026-05-01"))
            .andExpect(jsonPath("$.data.startingBalance").value(0.0))
    }

    @Test
    fun `getBudgets returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/budgets"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getBudgetStatus wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetBudgetStatusResponseData(
                status = BudgetStatus(hasBudget = true, hasTransactions = true, willCreateBudgetFromEmptyDefaultCategories = false),
            ),
        )
        mvc
            .perform(get("/v1/budgets/status"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.status.hasBudget").value(true))
            .andExpect(jsonPath("$.data.status.hasTransactions").value(true))
            .andExpect(jsonPath("$.data.status.willCreateBudgetFromEmptyDefaultCategories").value(false))
    }

    @Test
    fun `getBudgetMonth wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetBudgetMonthResponseData(
                budgetSystem = "fixed_and_flex",
                byCategory =
                    listOf(
                        BudgetMonthCategoryAmounts(
                            categoryId = "c-1",
                            monthlyAmounts =
                                listOf(
                                    BudgetMonthMonthlyAmount(
                                        month = java.time.LocalDate.parse("2026-05-01"),
                                        plannedCashFlowAmount = 500.0,
                                        actualAmount = 425.5,
                                    ),
                                ),
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/budgets/month").param("month", "2026-05-01"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.budgetSystem").value("fixed_and_flex"))
            .andExpect(jsonPath("$.data.byCategory[0].categoryId").value("c-1"))
            .andExpect(jsonPath("$.data.byCategory[0].monthlyAmounts[0].plannedCashFlowAmount").value(500.0))
            .andExpect(jsonPath("$.data.byCategory[0].monthlyAmounts[0].actualAmount").value(425.5))
    }
}
