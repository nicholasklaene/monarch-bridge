package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroup
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroupBudgetVariabilityRef
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryGroupResponseData
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateCategoryGroupBudgetVariabilityResponseData
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Category-groups CRUD endpoints on [CategoryController]:
 *  POST   /v1/category-groups                              createCategoryGroup
 *  PATCH  /v1/category-groups/{id}                         updateCategoryGroup
 *  DELETE /v1/category-groups/{id}                         deleteCategoryGroup
 *  PATCH  /v1/category-groups/{id}/budget-variability      updateCategoryGroupBudgetVariability
 */
@WebMvcTest(CategoryController::class)
@Import(GlobalExceptionHandler::class)
class CategoryControllerGroupsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `createCategoryGroup wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            CreateCategoryGroupResponseData(
                categoryGroup = CategoryGroup(id = "g-new", name = "Pets", type = "expense"),
            ),
        )
        mvc
            .perform(
                post("/v1/category-groups")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name":"Pets","type":"expense"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.categoryGroup.id").value("g-new"))
            .andExpect(jsonPath("$.data.categoryGroup.name").value("Pets"))
    }

    @Test
    fun `updateCategoryGroup wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            CreateCategoryGroupResponseData(
                categoryGroup = CategoryGroup(id = "g-1", name = "Renamed", type = "expense"),
            ),
        )
        mvc
            .perform(
                patch("/v1/category-groups/g-1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name":"Renamed"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.categoryGroup.name").value("Renamed"))
    }

    @Test
    fun `deleteCategoryGroup wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DeleteAccountResponseData(deleted = true))
        mvc
            .perform(delete("/v1/category-groups/g-1").param("moveToGroupId", "g-2"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").value(true))
    }

    @Test
    fun `updateCategoryGroupBudgetVariability wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateCategoryGroupBudgetVariabilityResponseData(
                categoryGroup =
                    CategoryGroupBudgetVariabilityRef(
                        id = "g-1",
                        budgetVariability = "fixed",
                        updatedAt = "2026-05-26T10:00:00Z",
                    ),
            ),
        )
        mvc
            .perform(
                patch("/v1/category-groups/g-1/budget-variability")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"budgetVariability":"fixed"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.categoryGroup.id").value("g-1"))
            .andExpect(jsonPath("$.data.categoryGroup.budgetVariability").value("fixed"))
    }
}
