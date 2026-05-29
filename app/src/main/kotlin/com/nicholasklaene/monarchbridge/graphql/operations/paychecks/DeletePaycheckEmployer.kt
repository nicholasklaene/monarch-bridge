package com.nicholasklaene.monarchbridge.graphql.operations.paychecks

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Delete a paycheck-employer entry by id. Monarch refuses if any paychecks are still
 * attributed to this employer; in that case the proxy surfaces the upstream error.
 * Monarch's mutation returns `success: Boolean`; surfaced as `{deleted: Boolean}`.
 */
object DeletePaycheckEmployer : MonarchOperation<DeletePaycheckEmployer.Input, DeleteAccountResponseData> {
    override val operationName: String = "Common_DeletePaycheckEmployer"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): DeleteAccountResponseData =
        DeleteAccountResponseData(
            deleted = data.path("deletePaycheckEmployer").path("success").asBoolean(false),
        )
}
