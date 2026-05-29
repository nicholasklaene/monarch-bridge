package com.nicholasklaene.monarchbridge.graphql.operations.rules

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Delete a rule by id. Destructive. Existing transactions previously categorized by the
 * rule keep their assigned values; Monarch does not re-run categorization on delete.
 *
 * Note: the controller returns `DeleteAccountResponse` because the spec generator
 * dedupes responses with identical `{deleted: Boolean}` shape under the first-seen name.
 * Same pattern as `deleteTransaction`.
 */
object DeleteTransactionRule : MonarchOperation<DeleteTransactionRule.Input, DeleteAccountResponseData> {
    override val operationName: String = "Common_DeleteTransactionRule"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val ruleId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.ruleId)

    override fun parseOutput(data: JsonNode): DeleteAccountResponseData =
        DeleteAccountResponseData(
            deleted = data.path("deleteTransactionRule").path("deleted").asBoolean(false),
        )
}
