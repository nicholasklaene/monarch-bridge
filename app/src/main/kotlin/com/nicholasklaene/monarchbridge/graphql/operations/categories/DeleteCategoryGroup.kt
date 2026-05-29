package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Remove a category group. Pass `moveToGroupId` to remap this group's child categories
 * to another group before deletion. Monarch returns PayloadErrors when the group is in
 * use without a remap target; those surface as HTTP 422 via [com.nicholasklaene.monarchbridge.graphql.PayloadErrorException].
 *
 * Output reuses [DeleteAccountResponseData] because the spec generator dedupes — every
 * `{deleted: Boolean}` response collapses under the first-seen name.
 */
object DeleteCategoryGroup : MonarchOperation<DeleteCategoryGroup.Input, DeleteAccountResponseData> {
    override val operationName: String = "Common_DeleteCategoryGroup"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val groupId: String,
        val moveToGroupId: String? = null,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.groupId, "moveToGroupId" to input.moveToGroupId)

    override fun parseOutput(data: JsonNode): DeleteAccountResponseData =
        DeleteAccountResponseData(deleted = data.path("deleteCategoryGroup").path("deleted").asBoolean(false))
}
