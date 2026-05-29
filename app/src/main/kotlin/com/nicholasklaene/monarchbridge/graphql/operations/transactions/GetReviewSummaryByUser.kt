package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetReviewSummaryByUserResponseData
import com.nicholasklaene.monarchbridge.generated.model.ReviewSummaryByUserRow
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * For each household member, how many transactions are currently flagged as needing
 * review. Pivots Monarch's aggregates over the `needsReview=true` filter, grouped by
 * `needsReviewByUser`. Empty list = nothing waiting.
 */
object GetReviewSummaryByUser : MonarchOperation<Unit, GetReviewSummaryByUserResponseData> {
    override val operationName: String = "Common_GetReviewSummaryByUser"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetReviewSummaryByUserResponseData =
        GetReviewSummaryByUserResponseData(
            rows =
                data.path("byNeedsReviewByUser").map { row ->
                    val user = row.path("groupBy").path("needsReviewByUser")
                    ReviewSummaryByUserRow(
                        userId = user.path("id").asTextOrNull(),
                        name = user.path("name").asTextOrNull(),
                        count = row.path("summary").path("count").asInt(0),
                    )
                },
        )
}
