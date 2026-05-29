package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.SearchMerchantsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Logo-enabled merchant search. Same shape as [SearchMerchants] but with `logoUrl` for
 * each merchant and `offset` pagination (instead of `includeIds`).
 *
 * Wraps Monarch's `GetMerchantsSearchWithLogo` query. Reuses [SearchMerchantsResponseData]
 * because the spec response shape is identical (an array of `Merchant`); `Merchant.logoUrl`
 * is nullable, so the without-logo variant just leaves it null.
 */
object SearchMerchantsWithLogo : MonarchOperation<SearchMerchantsWithLogo.Input, SearchMerchantsResponseData> {
    override val operationName: String = "GetMerchantsSearchWithLogo"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val search: String? = null,
        val limit: Int? = null,
        val offset: Int? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "search" to input.search,
            "limit" to input.limit,
            "offset" to input.offset,
        )

    override fun parseOutput(data: JsonNode): SearchMerchantsResponseData =
        SearchMerchantsResponseData(
            merchants = data.path("merchants").map(MerchantMappers::parseMerchant),
        )
}
