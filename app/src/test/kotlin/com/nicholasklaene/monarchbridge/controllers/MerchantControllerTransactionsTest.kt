package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.generated.model.GetMerchantTransactionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.MerchantTransactionRow
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

@WebMvcTest(MerchantController::class)
@Import(GlobalExceptionHandler::class)
class MerchantControllerTransactionsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getMerchantTransactions wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetMerchantTransactionsResponseData(
                transactions =
                    listOf(
                        MerchantTransactionRow(
                            id = "t-1",
                            date = "2026-05-01",
                            amount = -19.99,
                            merchantName = "Starbucks",
                            categoryName = "Coffee",
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/merchants/m-1/transactions?limit=10&offset=0"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.transactions[0].id").value("t-1"))
            .andExpect(jsonPath("$.data.transactions[0].merchantName").value("Starbucks"))
            .andExpect(jsonPath("$.data.transactions[0].categoryName").value("Coffee"))
    }
}
