package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.DeleteMerchantResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetMerchantResponseData
import com.nicholasklaene.monarchbridge.generated.model.Merchant
import com.nicholasklaene.monarchbridge.generated.model.SearchMerchantsResponseData
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * MockMvc slice for [MerchantController]. Hits each MerchantsApi endpoint plus the two
 * `withLogo=true|false` branches on `searchMerchants` (which dispatches to two different
 * upstream queries depending on the flag).
 */
@WebMvcTest(MerchantController::class)
@Import(GlobalExceptionHandler::class)
class MerchantControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `searchMerchants without withLogo wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            SearchMerchantsResponseData(
                merchants =
                    listOf(
                        Merchant(id = "m1", name = "Starbucks", transactionCount = 12),
                        Merchant(id = "m2", name = "Whole Foods", transactionCount = 5),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/merchants/search").param("q", "coffee"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.merchants[0].id").value("m1"))
            .andExpect(jsonPath("$.data.merchants[0].name").value("Starbucks"))
            .andExpect(jsonPath("$.data.merchants[1].id").value("m2"))
    }

    @Test
    fun `searchMerchants with withLogo=true also wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            SearchMerchantsResponseData(
                merchants = listOf(Merchant(id = "m1", name = "Netflix", logoUrl = "https://cdn/netflix.png")),
            ),
        )
        mvc
            .perform(get("/v1/merchants/search").param("withLogo", "true").param("q", "netflix"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.merchants[0].id").value("m1"))
            .andExpect(jsonPath("$.data.merchants[0].logoUrl").value("https://cdn/netflix.png"))
    }

    @Test
    fun `searchMerchants returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/merchants/search"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getMerchant wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetMerchantResponseData(
                merchant = Merchant(id = "m-7", name = "Spotify", transactionCount = 24, canBeDeleted = true),
            ),
        )
        mvc
            .perform(get("/v1/merchants/m-7"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.merchant.id").value("m-7"))
            .andExpect(jsonPath("$.data.merchant.name").value("Spotify"))
            .andExpect(jsonPath("$.data.merchant.canBeDeleted").value(true))
    }

    @Test
    fun `deleteMerchant wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DeleteMerchantResponseData(deleted = true))
        mvc
            .perform(delete("/v1/merchants/m-1").param("moveToId", "m-2"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").value(true))
    }

    @Test
    fun `setMerchantLogo wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetMerchantResponseData(
                merchant = Merchant(id = "m-1", name = "Netflix", logoUrl = "https://cdn/abc.png"),
            ),
        )
        mvc
            .perform(
                patch("/v1/merchants/m-1/logo")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"cloudinaryPublicId":"abc"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.merchant.id").value("m-1"))
            .andExpect(jsonPath("$.data.merchant.logoUrl").value("https://cdn/abc.png"))
    }
}
