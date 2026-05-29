package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.AggregateSnapshot
import com.nicholasklaene.monarchbridge.generated.model.GetNetworthResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import java.time.LocalDate

/**
 * Aggregate net-worth-over-time snapshots, optionally filtered by account type.
 * Output is the spec-generated [GetNetworthResponseData].
 */
object GetAggregateSnapshots : MonarchOperation<GetAggregateSnapshots.Input, GetNetworthResponseData> {
    override val operationName: String = "GetAggregateSnapshots"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: String,
        val endDate: String,
        val accountType: String? = null,
    )

    override fun variables(input: Input): Map<String, Any?> {
        val filters =
            buildMap<String, Any?> {
                put("startDate", input.startDate)
                put("endDate", input.endDate)
                if (input.accountType != null) put("accountType", input.accountType)
            }
        return mapOf("filters" to filters)
    }

    override fun parseOutput(data: JsonNode): GetNetworthResponseData =
        GetNetworthResponseData(
            aggregateSnapshots =
                data.path("aggregateSnapshots").map {
                    AggregateSnapshot(
                        date = LocalDate.parse(it.path("date").asText("1970-01-01")),
                        balance = it.path("balance").asDouble(0.0),
                        assetsBalance = it.path("assetsBalance").asDoubleOrNull(),
                        liabilitiesBalance = it.path("liabilitiesBalance").asDoubleOrNull(),
                    )
                },
        )
}
