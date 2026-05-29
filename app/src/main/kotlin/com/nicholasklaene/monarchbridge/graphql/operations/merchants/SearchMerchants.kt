package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.SearchMerchantsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Search merchants by name, ordered by transaction count. Wraps Monarch's
 * `GetMerchantsSearch` query.
 *
 * The logo-enabled variant is [SearchMerchantsWithLogo]; the controller picks between
 * them based on the `withLogo` query param. `includeIds` is only honored by this variant.
 */
object SearchMerchants : MonarchOperation<SearchMerchants.Input, SearchMerchantsResponseData> {
    override val operationName: String = "GetMerchantsSearch"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val search: String? = null,
        val limit: Int? = null,
        val includeIds: List<String>? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "search" to input.search,
            "limit" to input.limit,
            "includeIds" to input.includeIds,
        )

    override fun parseOutput(data: JsonNode): SearchMerchantsResponseData =
        SearchMerchantsResponseData(
            merchants = data.path("merchants").map(MerchantMappers::parseMerchant),
        )
}
