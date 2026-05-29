package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Remove a category. Optionally remap its transactions to another category before deletion.
 *
 * Output reuses [DeleteAccountResponseData] because the generator dedupes — both
 * deletion responses share the same `{deleted: Boolean}` shape.
 */
object DeleteCategory : MonarchOperation<DeleteCategory.Input, DeleteAccountResponseData> {
    override val operationName: String = "Web_DeleteCategory"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val categoryId: String,
        val moveToCategoryId: String? = null,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.categoryId, "moveToCategoryId" to input.moveToCategoryId)

    override fun parseOutput(data: JsonNode): DeleteAccountResponseData =
        DeleteAccountResponseData(deleted = data.path("deleteCategory").path("deleted").asBoolean(false))
}
