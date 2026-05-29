package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRuleResponseData
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListTransactionRulesResponseData
import com.nicholasklaene.monarchbridge.generated.model.PreviewTransactionRuleResponseData
import com.nicholasklaene.monarchbridge.generated.model.Ref
import com.nicholasklaene.monarchbridge.generated.model.Transaction
import com.nicholasklaene.monarchbridge.generated.model.TransactionRule
import com.nicholasklaene.monarchbridge.generated.model.TransactionRulePreviewMatch
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionRuleResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

/**
 * MockMvc slice for [RuleController]. Covers list / create / update / delete / preview;
 * preview returns a typed payload of matched transactions plus the new field projections
 * Monarch would apply.
 */
@WebMvcTest(RuleController::class)
@Import(GlobalExceptionHandler::class)
class RuleControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `listTransactionRules wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListTransactionRulesResponseData(
                rules =
                    listOf(
                        TransactionRule(id = "r1", order = 1),
                        TransactionRule(id = "r2", order = 2),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/transaction-rules"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.rules[0].id").value("r1"))
            .andExpect(jsonPath("$.data.rules[0].order").value(1))
            .andExpect(jsonPath("$.data.rules[1].id").value("r2"))
    }

    @Test
    fun `listTransactionRules returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/transaction-rules"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `createTransactionRule wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, CreateTransactionRuleResponseData(created = true))
        mvc
            .perform(
                post("/v1/transaction-rules")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"setCategoryAction":"c-1"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.created").value(true))
    }

    @Test
    fun `updateTransactionRule wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, UpdateTransactionRuleResponseData(updated = true))
        mvc
            .perform(
                patch("/v1/transaction-rules/r-1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"setCategoryAction":"c-2"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.updated").value(true))
    }

    @Test
    fun `deleteTransactionRule wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DeleteAccountResponseData(deleted = true))
        mvc
            .perform(delete("/v1/transaction-rules/r-1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").value(true))
    }

    @Test
    fun `previewTransactionRule wraps total count and match list`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            PreviewTransactionRuleResponseData(
                totalCount = 1,
                results =
                    listOf(
                        TransactionRulePreviewMatch(
                            transaction = Transaction(id = "t-1", date = LocalDate.parse("2026-05-25"), amount = -19.99),
                            newCategory = Ref(id = "c-new"),
                            newName = "Renamed",
                        ),
                    ),
            ),
        )
        mvc
            .perform(
                post("/v1/transaction-rules/preview")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"setCategoryAction":"c-new"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.totalCount").value(1))
            .andExpect(jsonPath("$.data.results[0].transaction.id").value("t-1"))
            .andExpect(jsonPath("$.data.results[0].newName").value("Renamed"))
            .andExpect(jsonPath("$.data.results[0].newCategory.id").value("c-new"))
    }
}
