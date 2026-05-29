package com.nicholasklaene.monarchbridge.graphql.operations.paychecks

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ListPaycheckEmployersResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull

/**
 * List paycheck employers. Supports optional free-text `search` and standard
 * `limit` / `offset` paging. `paycheckEmployerCount` from the root query is
 * surfaced as `totalCount` in the response envelope for client paging.
 */
object GetPaycheckEmployers : MonarchOperation<GetPaycheckEmployers.Input, ListPaycheckEmployersResponseData> {
    override val operationName: String = "Common_GetPaycheckEmployers"
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

    override fun parseOutput(data: JsonNode): ListPaycheckEmployersResponseData =
        ListPaycheckEmployersResponseData(
            employers = data.path("paycheckEmployers").map(PaycheckJsonMappers::parseEmployer),
            totalCount = data.path("paycheckEmployerCount").asIntOrNull(),
        )
}
