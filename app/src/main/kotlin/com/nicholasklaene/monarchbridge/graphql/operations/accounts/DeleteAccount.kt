package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/** Remove an account. Destructive — drops all linked transactions. Output is the spec-generated [DeleteAccountResponseData]. */
object DeleteAccount : MonarchOperation<DeleteAccount.Input, DeleteAccountResponseData> {
    override val operationName: String = "Common_DeleteAccount"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val accountId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.accountId)

    override fun parseOutput(data: JsonNode): DeleteAccountResponseData =
        DeleteAccountResponseData(
            deleted = data.path("deleteAccount").path("deleted").asBoolean(false),
        )
}
