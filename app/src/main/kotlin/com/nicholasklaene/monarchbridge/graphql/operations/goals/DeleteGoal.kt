package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Hard-delete a savings goal. Distinct from archive (soft-delete): archived goals remain
 * visible in `listGoals` with `status="archived"`; deleted goals are removed entirely.
 *
 * Returns Monarch's reported `success` flag verbatim. The spec response shape
 * (`{deleted: Boolean}`) collapses into the shared [DeleteAccountResponseData] under
 * openapi-generator's first-seen dedup rule.
 */
object DeleteGoal : MonarchOperation<DeleteGoal.Input, DeleteAccountResponseData> {
    override val operationName: String = "Common_DeleteSavingsGoal"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val goalId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("id" to input.goalId))

    override fun parseOutput(data: JsonNode): DeleteAccountResponseData =
        DeleteAccountResponseData(
            deleted = data.path("deleteSavingsGoal").path("success").asBoolean(false),
        )
}
