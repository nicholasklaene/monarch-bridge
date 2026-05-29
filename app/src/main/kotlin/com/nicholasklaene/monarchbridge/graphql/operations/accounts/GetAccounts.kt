package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ListAccountsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.JsonMappers
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * All linked accounts with balances + institution + type.
 * Output is the spec-generated [ListAccountsResponseData].
 */
object GetAccounts : MonarchOperation<Unit, ListAccountsResponseData> {
    override val operationName: String = "GetAccounts"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("AccountFields"))
    }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): ListAccountsResponseData =
        ListAccountsResponseData(
            accounts = data.path("accounts").map(JsonMappers::parseAccount),
        )
}
