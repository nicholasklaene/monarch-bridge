package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.generated.model.GetTaxCategoriesResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTaxCategoryAggregatesResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTaxScheduleCategoryMappingsResponseData
import com.nicholasklaene.monarchbridge.generated.model.TaxCategoryAggregateRow
import com.nicholasklaene.monarchbridge.generated.model.TaxCategoryRef
import com.nicholasklaene.monarchbridge.generated.model.TaxCategoryWithSystem
import com.nicholasklaene.monarchbridge.generated.model.TaxLineItemInfo
import com.nicholasklaene.monarchbridge.generated.model.TaxScheduleCategoryMapping
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

@WebMvcTest(TaxController::class)
@Import(GlobalExceptionHandler::class)
class TaxControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getTaxCategories wraps category list in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTaxCategoriesResponseData(
                categories =
                    listOf(
                        TaxCategoryWithSystem(id = "c1", name = "Home Office", icon = "🏠", systemCategory = "homeOffice"),
                        TaxCategoryWithSystem(id = "c2", name = "Mileage", icon = "🚗", systemCategory = "mileage"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/tax/categories"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.categories[0].id").value("c1"))
            .andExpect(jsonPath("$.data.categories[0].systemCategory").value("homeOffice"))
            .andExpect(jsonPath("$.data.categories[1].name").value("Mileage"))
    }

    @Test
    fun `getTaxCategoryAggregates passes start and end to operation`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTaxCategoryAggregatesResponseData(
                rows =
                    listOf(
                        TaxCategoryAggregateRow(
                            category =
                                TaxCategoryWithSystem(
                                    id = "c1",
                                    name = "Home Office",
                                    icon = null,
                                    systemCategory = "homeOffice",
                                ),
                            sum = -1250.0,
                            count = 12,
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/tax/category-aggregates?start=2026-01-01&end=2026-12-31"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.rows[0].category.id").value("c1"))
            .andExpect(jsonPath("$.data.rows[0].sum").value(-1250.0))
            .andExpect(jsonPath("$.data.rows[0].count").value(12))
    }

    @Test
    fun `getTaxScheduleCategoryMappings requires schedule and taxYear`() {
        mvc
            .perform(get("/v1/tax/schedule-mappings"))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `getTaxScheduleCategoryMappings returns mappings list`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTaxScheduleCategoryMappingsResponseData(
                mappings =
                    listOf(
                        TaxScheduleCategoryMapping(
                            id = "m1",
                            lineItem = "OFFICE_EXPENSE",
                            schedule = "SCHEDULE_C",
                            taxYear = 2026,
                            category =
                                TaxCategoryRef(id = "c1", name = "Home Office", icon = null),
                            lineItemInfo =
                                TaxLineItemInfo(
                                    key = "OFFICE_EXPENSE",
                                    lineNumber = "18",
                                    description = "Office expense",
                                    lineType = "EXPENSE",
                                    sortOrder = 18,
                                ),
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/tax/schedule-mappings?schedule=SCHEDULE_C&taxYear=2026"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.mappings[0].id").value("m1"))
            .andExpect(jsonPath("$.data.mappings[0].lineItem").value("OFFICE_EXPENSE"))
            .andExpect(jsonPath("$.data.mappings[0].lineItemInfo.lineNumber").value("18"))
            .andExpect(jsonPath("$.data.mappings[0].category.name").value("Home Office"))
    }
}
