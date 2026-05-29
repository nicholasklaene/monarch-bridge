package com.nicholasklaene.monarchbridge.graphql.operations.tags

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteTagResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Delete one household transaction tag. Monarch returns only an `errors` array on success
 * (no `deleted` flag), so we surface `deleted = errors.isEmpty()`. Output is the
 * spec-generated [DeleteTagResponseData].
 */
object DeleteHouseholdTransactionTag : MonarchOperation<DeleteHouseholdTransactionTag.Input, DeleteTagResponseData> {
    override val operationName: String = "Common_DeleteHouseholdTransactionTag"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val tagId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("tagId" to input.tagId)

    override fun parseOutput(data: JsonNode): DeleteTagResponseData {
        val errors = data.path("deleteTransactionTag").path("errors")
        val hasErrors = errors.isArray && errors.size() > 0
        return DeleteTagResponseData(deleted = !hasErrors)
    }
}
