package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteMerchantResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Remove a merchant. Pass `moveToId` to reassign this merchant's transactions and rules
 * to another merchant before deletion. Monarch returns a top-level `success` boolean;
 * this op surfaces it as `deleted` to match the rest of the proxy's delete shape.
 */
object DeleteMerchant : MonarchOperation<DeleteMerchant.Input, DeleteMerchantResponseData> {
    override val operationName: String = "Common_DeleteMerchant"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val merchantId: String,
        val moveToId: String? = null,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("merchantId" to input.merchantId, "moveToId" to input.moveToId)

    override fun parseOutput(data: JsonNode): DeleteMerchantResponseData =
        DeleteMerchantResponseData(deleted = data.path("deleteMerchant").path("success").asBoolean(false))
}
