package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteInstitutionResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Delete a Plaid credential (institution connection) from Monarch.
 *
 * Equivalent to Monarch web UI: Settings -> Data Sources -> unlink. The associated
 * accounts get soft-deleted; they still appear under `accounts(filters: {includeDeleted: true})`
 * with a non-null `deletedAt` but are excluded from default account queries.
 *
 * Use this to clean up stale credentials with `updateRequired: true` that no longer auth.
 *
 * Mutation shape (captured from Monarch web bundle):
 *   `mutation Common_DeleteCredentialMutation($input: DeleteCredentialInput!) {
 *      deleteCredential(input: $input) { deleted } }`
 * with `input = {credentialId: <id>}`. Note this mutation does NOT return a
 * `PayloadError` field; success vs failure is signalled by `deleted: true|false`
 * and by HTTP-level errors.
 */
object DeleteCredential : MonarchOperation<DeleteCredential.Input, DeleteInstitutionResponseData> {
    override val operationName: String = "Common_DeleteCredentialMutation"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val credentialId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("credentialId" to input.credentialId))

    override fun parseOutput(data: JsonNode): DeleteInstitutionResponseData =
        DeleteInstitutionResponseData(
            deleted = data.path("deleteCredential").path("deleted").asBoolean(false),
        )
}
