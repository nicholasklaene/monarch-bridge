package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreditScoreSnapshot
import com.nicholasklaene.monarchbridge.generated.model.GetCreditHistoryResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Credit score history from Monarch's Spinwheel integration. Returns one snapshot
 * per reporting event (typically monthly). Empty for users without Spinwheel enabled.
 *
 * Output is the spec-generated inner `data` payload (CreditHistoryResponse-shaped).
 */
object GetCreditHistory : MonarchOperation<Unit, GetCreditHistoryResponseData> {
    override val operationName: String = "Common_GetSpinwheelCreditScoreSnapshots"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetCreditHistoryResponseData =
        GetCreditHistoryResponseData(
            snapshots =
                data.path("creditScoreSnapshots").map { node ->
                    CreditScoreSnapshot(
                        reportedDate = LocalDate.parse(node.path("reportedDate").asText("1970-01-01")),
                        score = node.path("score").asInt(0),
                        userId = node.path("user").path("id").asTextOrNull(),
                    )
                },
        )
}
