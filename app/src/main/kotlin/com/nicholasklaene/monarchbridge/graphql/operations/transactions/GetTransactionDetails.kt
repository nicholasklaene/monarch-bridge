package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionDetailResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Single-transaction full detail — splits + attachments + original-transaction info,
 * which the paginated list endpoint omits. Output is the spec-generated
 * [GetTransactionDetailResponseData]; `transaction` is a free-form `Map<String, Any>?`
 * since the upstream tree is too deep/volatile to model.
 */
object GetTransactionDetails : MonarchOperation<GetTransactionDetails.Input, GetTransactionDetailResponseData> {
    override val operationName: String = "GetTransactionDrawer"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
        val redirectPosted: Boolean = true,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id, "redirectPosted" to input.redirectPosted)

    override fun parseOutput(data: JsonNode): GetTransactionDetailResponseData {
        val node = data.path("getTransaction")
        if (node.isMissingNode || node.isNull) return GetTransactionDetailResponseData(transaction = null)
        @Suppress("UNCHECKED_CAST")
        val map = ObjectMapper().convertValue(node, Map::class.java) as Map<String, Any>
        return GetTransactionDetailResponseData(transaction = map)
    }
}
