package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.AccountGroupOrderEntry
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountGroupOrderRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountGroupOrderResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/** Persist a reordered set of account groups. */
object UpdateAccountGroupOrder :
    MonarchOperation<UpdateAccountGroupOrder.Input, UpdateAccountGroupOrderResponseData> {
    override val operationName: String = "Web_UpdateAccountGroupOrder"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val groupIds: List<String>,
    ) {
        companion object {
            fun from(req: UpdateAccountGroupOrderRequest): Input = Input(groupIds = req.groupIds)
        }
    }

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("groupIds" to input.groupIds))

    override fun parseOutput(data: JsonNode): UpdateAccountGroupOrderResponseData =
        UpdateAccountGroupOrderResponseData(
            groups =
                data.path("updateAccountGroupOrder").path("accountGroups").map { g ->
                    AccountGroupOrderEntry(
                        id = g.path("id").asText(""),
                        order = g.path("order").asInt(0),
                    )
                },
        )
}
