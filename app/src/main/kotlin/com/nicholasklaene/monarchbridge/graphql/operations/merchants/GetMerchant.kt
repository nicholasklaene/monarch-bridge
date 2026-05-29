package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetMerchantResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Single-merchant detail read. Wraps Monarch's `Common_GetEditMerchant` query — the
 * richest single-merchant read in the bundle, including `transactionCount`, `ruleCount`,
 * `canBeDeleted`, `hasActiveRecurringStreams`, and the recurring stream.
 */
object GetMerchant : MonarchOperation<GetMerchant.Input, GetMerchantResponseData> {
    override val operationName: String = "Common_GetEditMerchant"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val merchantId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("merchantId" to input.merchantId)

    override fun parseOutput(data: JsonNode): GetMerchantResponseData =
        GetMerchantResponseData(merchant = MerchantMappers.parseMerchant(data.path("merchant")))
}
