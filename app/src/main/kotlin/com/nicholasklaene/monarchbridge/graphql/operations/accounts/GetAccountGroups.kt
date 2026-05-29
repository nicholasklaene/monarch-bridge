package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.AccountGroup
import com.nicholasklaene.monarchbridge.generated.model.GetAccountGroupsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull

/** Visual account-tab groupings. */
object GetAccountGroups : MonarchOperation<Unit, GetAccountGroupsResponseData> {
    override val operationName: String = "Web_GetAccountGroups"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetAccountGroupsResponseData =
        GetAccountGroupsResponseData(
            groups =
                data.path("accountGroups").map { g ->
                    AccountGroup(
                        id = g.path("id").asText(""),
                        name = g.path("name").asText(""),
                        order = g.path("order").asInt(0),
                        isCollapsed = g.path("isCollapsed").asBooleanOrNull(),
                        accountIds = g.path("accountIds").map { it.asText("") },
                    )
                },
        )
}
