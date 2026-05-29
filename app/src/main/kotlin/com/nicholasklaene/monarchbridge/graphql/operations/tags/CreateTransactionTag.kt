package com.nicholasklaene.monarchbridge.graphql.operations.tags

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateTagRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateTagResponseData
import com.nicholasklaene.monarchbridge.generated.model.Tag
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Create a new transaction tag.
 * `color` is 6-digit RGB hex with leading # (e.g. "#19D2A5").
 * Note: response uses a simplified `errors` shape — just `{ message }` per item.
 *
 * Output is the spec-generated inner `data` payload.
 */
object CreateTransactionTag : MonarchOperation<CreateTransactionTag.Input, CreateTagResponseData> {
    override val operationName: String = "Common_CreateTransactionTag"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val name: String,
        val color: String,
    ) {
        companion object {
            /** Map a generated REST request body into the GraphQL input. */
            fun from(req: CreateTagRequest): Input = Input(name = req.name, color = req.color)
        }
    }

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("name" to input.name, "color" to input.color))

    override fun parseOutput(data: JsonNode): CreateTagResponseData {
        val node = data.path("createTransactionTag").path("tag")
        return CreateTagResponseData(
            tag =
                Tag(
                    id = node.path("id").asText(""),
                    name = node.path("name").asText(""),
                    color = node.path("color").asText(""),
                    order = node.path("order").asInt(0),
                    transactionCount = node.path("transactionCount").asInt(0),
                ),
        )
    }
}
