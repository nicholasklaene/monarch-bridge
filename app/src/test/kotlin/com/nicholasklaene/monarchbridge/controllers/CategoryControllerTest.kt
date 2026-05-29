package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.Category
import com.nicholasklaene.monarchbridge.generated.model.CategoryDeletionInfo
import com.nicholasklaene.monarchbridge.generated.model.CategoryEditFields
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroup
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroupChildCategory
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroupDetails
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryResponseData
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryDeletionInfoResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryEditResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryGroupDetailsResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListCategoriesResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListCategoryGroupsResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.categories.DeleteCategory
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(CategoryController::class)
@Import(GlobalExceptionHandler::class)
class CategoryControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `listCategories wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListCategoriesResponseData(
                categories =
                    listOf(
                        Category(id = "c1", name = "Groceries", icon = "🛒"),
                        Category(id = "c2", name = "Gas", icon = "⛽"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/categories"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.categories[0].id").value("c1"))
            .andExpect(jsonPath("$.data.categories[0].name").value("Groceries"))
            .andExpect(jsonPath("$.data.categories[1].id").value("c2"))
    }

    @Test
    fun `listCategories returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/categories"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `listCategoryGroups wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListCategoryGroupsResponseData(
                categoryGroups =
                    listOf(
                        CategoryGroup(id = "g1", name = "Food", type = "expense"),
                        CategoryGroup(id = "g2", name = "Transport", type = "expense"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/category-groups"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.categoryGroups[0].id").value("g1"))
            .andExpect(jsonPath("$.data.categoryGroups[0].name").value("Food"))
            .andExpect(jsonPath("$.data.categoryGroups[1].id").value("g2"))
    }

    @Test
    fun `createCategory wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            CreateCategoryResponseData(
                category = Category(id = "c99", name = "Home improvement", icon = "🔧"),
            ),
        )
        mvc
            .perform(
                post("/v1/categories")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"group":"g1","name":"Home improvement","icon":"🔧"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.category.id").value("c99"))
            .andExpect(jsonPath("$.data.category.name").value("Home improvement"))
    }

    @Test
    fun `createCategory returns 400 when required field missing`() {
        mvc
            .perform(
                post("/v1/categories")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"group":"g1"}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `deleteCategory wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DeleteAccountResponseData(deleted = true))
        mvc
            .perform(delete("/v1/categories/c1").param("moveToCategoryId", "c2"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").value(true))
    }

    /**
     * Register `any()` matchers for both generic args of `MonarchClient.execute` while
     * handing Kotlin's non-null call chain a real, non-null value so the `as` cast doesn't
     * NPE. Mirrors the helper pattern in SystemControllerTest.
     */
    @Suppress("UNCHECKED_CAST")
    private fun anyOp(): com.nicholasklaene.monarchbridge.graphql.MonarchOperation<Any, Any> {
        ArgumentMatchers.any<com.nicholasklaene.monarchbridge.graphql.MonarchOperation<Any, Any>>()
        return DeleteCategory as com.nicholasklaene.monarchbridge.graphql.MonarchOperation<Any, Any>
    }

    private fun anyInput(): Any {
        ArgumentMatchers.any<Any>()
        return Unit
    }

    /**
     * Bulk-delete partitions ids by per-call outcome. We discriminate on the
     * `DeleteCategory.Input` to simulate success for `c1`/`c3` and failure for `c2` in one
     * call (the canned [TestFixtures.stubExec] helpers always match every invocation).
     */
    @Test
    fun `bulkDeleteCategories partitions ids by per-call outcome`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        `when`(client.execute(anyOp(), anyInput())).thenAnswer { inv ->
            val input = inv.getArgument<DeleteCategory.Input>(1)
            if (input.categoryId == "c2") {
                throw com.nicholasklaene.monarchbridge.exceptions.MonarchRequestFailedException(
                    422,
                    "{}",
                    "category in use",
                )
            }
            DeleteAccountResponseData(deleted = true)
        }
        mvc
            .perform(
                post("/v1/categories/bulk-delete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"ids":["c1","c2","c3"],"moveToCategoryId":"c-other"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").isArray)
            .andExpect(jsonPath("$.data.deleted.length()").value(2))
            .andExpect(jsonPath("$.data.deleted[0]").value("c1"))
            .andExpect(jsonPath("$.data.deleted[1]").value("c3"))
            .andExpect(jsonPath("$.data.failed").isArray)
            .andExpect(jsonPath("$.data.failed.length()").value(1))
            .andExpect(jsonPath("$.data.failed[0].id").value("c2"))
            .andExpect(jsonPath("$.data.failed[0].reason").value("category in use"))
    }

    @Test
    fun `bulkDeleteCategories returns empty partitions when ids is empty`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        mvc
            .perform(
                post("/v1/categories/bulk-delete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"ids":[]}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted.length()").value(0))
            .andExpect(jsonPath("$.data.failed.length()").value(0))
    }

    @Test
    fun `bulkDeleteCategories returns 400 when ids missing`() {
        mvc
            .perform(
                post("/v1/categories/bulk-delete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `getCategoryEdit wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCategoryEditResponseData(
                category =
                    CategoryEditFields(
                        id = "c-1",
                        name = "Groceries",
                        icon = "🛒",
                        budgetVariability = "fixed",
                        groupId = "g-1",
                    ),
            ),
        )
        mvc
            .perform(get("/v1/categories/c-1/edit"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.category.id").value("c-1"))
            .andExpect(jsonPath("$.data.category.name").value("Groceries"))
            .andExpect(jsonPath("$.data.category.budgetVariability").value("fixed"))
            .andExpect(jsonPath("$.data.category.groupId").value("g-1"))
    }

    @Test
    fun `getCategoryDeletionInfo wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCategoryDeletionInfoResponseData(
                category = CategoryDeletionInfo(id = "c-1", name = "Groceries", icon = "🛒", isSystemCategory = false),
            ),
        )
        mvc
            .perform(get("/v1/categories/c-1/deletion-info"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.category.id").value("c-1"))
            .andExpect(jsonPath("$.data.category.isSystemCategory").value(false))
    }

    @Test
    fun `getCategoryGroupDetails wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCategoryGroupDetailsResponseData(
                categoryGroup =
                    CategoryGroupDetails(
                        id = "g-1",
                        name = "Food",
                        type = "expense",
                        categories =
                            listOf(
                                CategoryGroupChildCategory(id = "c-1", name = "Groceries", icon = "🛒"),
                            ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/category-groups/g-1/details").param("includeDisabledSystemCategories", "true"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.categoryGroup.id").value("g-1"))
            .andExpect(jsonPath("$.data.categoryGroup.name").value("Food"))
            .andExpect(jsonPath("$.data.categoryGroup.categories[0].id").value("c-1"))
    }
}
