package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.CategoriesApi
import com.nicholasklaene.monarchbridge.generated.model.BulkDeleteCategoriesRequest
import com.nicholasklaene.monarchbridge.generated.model.BulkDeleteCategoriesResponse
import com.nicholasklaene.monarchbridge.generated.model.BulkDeleteCategoriesResponseData
import com.nicholasklaene.monarchbridge.generated.model.BulkDeleteFailure
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryGroupRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryGroupResponse
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryResponse
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryDeletionInfoResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryEditResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryGroupDetailsResponse
import com.nicholasklaene.monarchbridge.generated.model.ListCategoriesResponse
import com.nicholasklaene.monarchbridge.generated.model.ListCategoryGroupsResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateCategoryGroupBudgetVariabilityRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateCategoryGroupBudgetVariabilityResponse
import com.nicholasklaene.monarchbridge.generated.model.UpdateCategoryGroupRequest
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.categories.CreateCategory
import com.nicholasklaene.monarchbridge.graphql.operations.categories.CreateCategoryGroup
import com.nicholasklaene.monarchbridge.graphql.operations.categories.DeleteCategory
import com.nicholasklaene.monarchbridge.graphql.operations.categories.DeleteCategoryGroup
import com.nicholasklaene.monarchbridge.graphql.operations.categories.GetCategories
import com.nicholasklaene.monarchbridge.graphql.operations.categories.GetCategoryDeletionInfo
import com.nicholasklaene.monarchbridge.graphql.operations.categories.GetCategoryEdit
import com.nicholasklaene.monarchbridge.graphql.operations.categories.GetCategoryGroupDetails
import com.nicholasklaene.monarchbridge.graphql.operations.categories.GetCategoryGroups
import com.nicholasklaene.monarchbridge.graphql.operations.categories.UpdateCategoryGroup
import com.nicholasklaene.monarchbridge.graphql.operations.categories.UpdateCategoryGroupBudgetVariability
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Transaction categories + category-groups. All HTTP wiring comes from the spec-generated
 * [CategoriesApi]; this class dispatches to operations and wraps payloads.
 *
 * Note: `deleteCategory` returns `DeleteAccountResponse` — generator dedupes identical
 * `{deleted: Boolean}` response shapes.
 */
@RestController
@Suppress("TooManyFunctions")
class CategoryController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    CategoriesApi {
    override fun listCategories(): ResponseEntity<ListCategoriesResponse> =
        ResponseEntity.ok(ListCategoriesResponse(data = exec(GetCategories, Unit)))

    /** Parent groups (one tier above individual categories). Used by budget endpoints. */
    override fun listCategoryGroups(): ResponseEntity<ListCategoryGroupsResponse> =
        ResponseEntity.ok(ListCategoryGroupsResponse(data = exec(GetCategoryGroups, Unit)))

    override fun createCategory(createCategoryRequest: CreateCategoryRequest): ResponseEntity<CreateCategoryResponse> =
        ResponseEntity.ok(CreateCategoryResponse(data = exec(CreateCategory, CreateCategory.Input.from(createCategoryRequest))))

    override fun deleteCategory(
        id: String,
        moveToCategoryId: String?,
    ): ResponseEntity<DeleteAccountResponse> =
        ResponseEntity.ok(DeleteAccountResponse(data = exec(DeleteCategory, DeleteCategory.Input(id, moveToCategoryId))))

    override fun createCategoryGroup(createCategoryGroupRequest: CreateCategoryGroupRequest): ResponseEntity<CreateCategoryGroupResponse> =
        ResponseEntity.ok(
            CreateCategoryGroupResponse(
                data = exec(CreateCategoryGroup, CreateCategoryGroup.Input.from(createCategoryGroupRequest)),
            ),
        )

    /**
     * Patch a category group. Returns `CreateCategoryGroupResponse` because the spec
     * generator dedupes the matching response shape; both create + update return the
     * same `{categoryGroup: CategoryGroup}` envelope.
     */
    override fun updateCategoryGroup(
        id: String,
        updateCategoryGroupRequest: UpdateCategoryGroupRequest,
    ): ResponseEntity<CreateCategoryGroupResponse> =
        ResponseEntity.ok(
            CreateCategoryGroupResponse(
                data = exec(UpdateCategoryGroup, UpdateCategoryGroup.Input.from(id, updateCategoryGroupRequest)),
            ),
        )

    /**
     * Delete a category group. Returns `DeleteAccountResponse` because the spec
     * generator dedupes every `{deleted: Boolean}` response under that first-seen name.
     */
    override fun deleteCategoryGroup(
        id: String,
        moveToGroupId: String?,
    ): ResponseEntity<DeleteAccountResponse> =
        ResponseEntity.ok(
            DeleteAccountResponse(
                data = exec(DeleteCategoryGroup, DeleteCategoryGroup.Input(id, moveToGroupId)),
            ),
        )

    override fun updateCategoryGroupBudgetVariability(
        id: String,
        updateCategoryGroupBudgetVariabilityRequest: UpdateCategoryGroupBudgetVariabilityRequest,
    ): ResponseEntity<UpdateCategoryGroupBudgetVariabilityResponse> =
        ResponseEntity.ok(
            UpdateCategoryGroupBudgetVariabilityResponse(
                data =
                    exec(
                        UpdateCategoryGroupBudgetVariability,
                        UpdateCategoryGroupBudgetVariability.Input.from(id, updateCategoryGroupBudgetVariabilityRequest),
                    ),
            ),
        )

    /**
     * Server-side composite over [DeleteCategory]. Runs the delete per id; on success the id
     * is added to `deleted`, on exception the id + `throwable.message` are added to `failed`.
     * Per-id failures do not fail the whole request. The bulk endpoint always returns 200
     * so callers can inspect both partitions in one round-trip.
     */
    override fun bulkDeleteCategories(
        bulkDeleteCategoriesRequest: BulkDeleteCategoriesRequest,
    ): ResponseEntity<BulkDeleteCategoriesResponse> {
        val deleted = mutableListOf<String>()
        val failed = mutableListOf<BulkDeleteFailure>()
        val moveTo = bulkDeleteCategoriesRequest.moveToCategoryId
        for (id in bulkDeleteCategoriesRequest.ids) {
            runCatching {
                exec(DeleteCategory, DeleteCategory.Input(id, moveTo))
            }.onSuccess {
                deleted.add(id)
            }.onFailure { throwable ->
                val reason = throwable.message ?: throwable::class.java.simpleName
                failed.add(BulkDeleteFailure(id = id, reason = reason))
            }
        }
        return ResponseEntity.ok(
            BulkDeleteCategoriesResponse(
                data = BulkDeleteCategoriesResponseData(deleted = deleted, failed = failed),
            ),
        )
    }

    /** Category with the full edit-form field set (group + rollover + budget flags). */
    override fun getCategoryEdit(id: String): ResponseEntity<GetCategoryEditResponse> =
        ResponseEntity.ok(GetCategoryEditResponse(data = exec(GetCategoryEdit, GetCategoryEdit.Input(id))))

    /** Slim category snapshot for the delete-confirm dialog. */
    override fun getCategoryDeletionInfo(id: String): ResponseEntity<GetCategoryDeletionInfoResponse> =
        ResponseEntity.ok(
            GetCategoryDeletionInfoResponse(
                data = exec(GetCategoryDeletionInfo, GetCategoryDeletionInfo.Input(id)),
            ),
        )

    /** Category-group detail with its child categories. */
    override fun getCategoryGroupDetails(
        id: String,
        includeDisabledSystemCategories: Boolean?,
    ): ResponseEntity<GetCategoryGroupDetailsResponse> =
        ResponseEntity.ok(
            GetCategoryGroupDetailsResponse(
                data =
                    exec(
                        GetCategoryGroupDetails,
                        GetCategoryGroupDetails.Input(
                            id = id,
                            includeDisabledSystemCategories = includeDisabledSystemCategories,
                        ),
                    ),
            ),
        )
}
