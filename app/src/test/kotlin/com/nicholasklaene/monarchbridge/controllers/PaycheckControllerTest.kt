package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckEmployerResponseData
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckResponseData
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetPaychecksSummaryResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListPaycheckEmployersResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListPaychecksResponseData
import com.nicholasklaene.monarchbridge.generated.model.Paycheck
import com.nicholasklaene.monarchbridge.generated.model.PaycheckEmployer
import com.nicholasklaene.monarchbridge.generated.model.PaychecksSummary
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

@WebMvcTest(PaycheckController::class)
@Import(GlobalExceptionHandler::class)
class PaycheckControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `listPaychecks wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListPaychecksResponseData(
                paychecks =
                    listOf(
                        Paycheck(id = "pc-1", grossAmount = 5000.0, payDate = "2026-05-15"),
                        Paycheck(id = "pc-2", grossAmount = 5000.0, payDate = "2026-05-30"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/paychecks"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.paychecks[0].id").value("pc-1"))
            .andExpect(jsonPath("$.data.paychecks[0].grossAmount").value(5000.0))
            .andExpect(jsonPath("$.data.paychecks[1].id").value("pc-2"))
    }

    @Test
    fun `listPaychecks returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/paychecks"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getPaycheck wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            CreatePaycheckResponseData(paycheck = Paycheck(id = "pc-7", grossAmount = 4500.0, payDate = "2026-05-15")),
        )
        mvc
            .perform(get("/v1/paychecks/pc-7"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.paycheck.id").value("pc-7"))
            .andExpect(jsonPath("$.data.paycheck.grossAmount").value(4500.0))
    }

    @Test
    fun `getPaychecksSummary wraps summary in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetPaychecksSummaryResponseData(
                summary =
                    PaychecksSummary(
                        count = 6,
                        totalGross = 30000.0,
                        totalDeductions = 9000.0,
                        totalNet = 21000.0,
                        deductionRate = 0.3,
                    ),
            ),
        )
        mvc
            .perform(get("/v1/paychecks/summary").param("start", "2026-01-01").param("end", "2026-06-30"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.summary.count").value(6))
            .andExpect(jsonPath("$.data.summary.totalGross").value(30000.0))
            .andExpect(jsonPath("$.data.summary.totalNet").value(21000.0))
    }

    @Test
    fun `createPaycheck wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            CreatePaycheckResponseData(paycheck = Paycheck(id = "new-pc", grossAmount = 5000.0, payDate = "2026-05-15")),
        )
        mvc
            .perform(
                post("/v1/paychecks")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"employerId":"emp-1","grossAmount":5000.0,"payDate":"2026-05-15"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.paycheck.id").value("new-pc"))
            .andExpect(jsonPath("$.data.paycheck.grossAmount").value(5000.0))
    }

    @Test
    fun `createPaycheck returns 400 when required field missing`() {
        mvc
            .perform(
                post("/v1/paychecks")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"grossAmount":5000.0,"payDate":"2026-05-15"}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `updatePaycheck wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            CreatePaycheckResponseData(paycheck = Paycheck(id = "pc-1", grossAmount = 6000.0, payDate = "2026-05-31")),
        )
        mvc
            .perform(
                patch("/v1/paychecks/pc-1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"grossAmount":6000.0,"payDate":"2026-05-31"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.paycheck.grossAmount").value(6000.0))
    }

    @Test
    fun `deletePaycheck wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DeleteAccountResponseData(deleted = true))
        mvc
            .perform(delete("/v1/paychecks/pc-1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").value(true))
    }

    @Test
    fun `listPaycheckEmployers wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListPaycheckEmployersResponseData(
                employers =
                    listOf(
                        PaycheckEmployer(id = "e1", name = "Acme", paycheckCount = 12),
                        PaycheckEmployer(id = "e2", name = "Globex", paycheckCount = 3),
                    ),
                totalCount = 2,
            ),
        )
        mvc
            .perform(get("/v1/paycheck-employers"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.employers[0].id").value("e1"))
            .andExpect(jsonPath("$.data.employers[1].name").value("Globex"))
            .andExpect(jsonPath("$.data.totalCount").value(2))
    }

    @Test
    fun `createPaycheckEmployer wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, CreatePaycheckEmployerResponseData(employer = PaycheckEmployer(id = "e1", name = "Acme")))
        mvc
            .perform(
                post("/v1/paycheck-employers")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name":"Acme"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.employer.id").value("e1"))
            .andExpect(jsonPath("$.data.employer.name").value("Acme"))
    }

    @Test
    fun `createPaycheckEmployer returns 400 when name missing`() {
        mvc
            .perform(
                post("/v1/paycheck-employers")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `updatePaycheckEmployer wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, CreatePaycheckEmployerResponseData(employer = PaycheckEmployer(id = "e1", name = "Acme Corp")))
        mvc
            .perform(
                patch("/v1/paycheck-employers/e1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name":"Acme Corp"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.employer.name").value("Acme Corp"))
    }

    @Test
    fun `deletePaycheckEmployer wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DeleteAccountResponseData(deleted = true))
        mvc
            .perform(delete("/v1/paycheck-employers/e1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").value(true))
    }
}
