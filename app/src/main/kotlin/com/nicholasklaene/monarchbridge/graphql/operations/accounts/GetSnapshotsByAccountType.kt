package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.AccountTypeReference
import com.nicholasklaene.monarchbridge.generated.model.GetNetworthByTypeResponseData
import com.nicholasklaene.monarchbridge.generated.model.SnapshotByAccountType
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Balance history grouped by account type (real_estate, brokerage, loan, ...).
 * Output is the spec-generated [GetNetworthByTypeResponseData].
 */
object GetSnapshotsByAccountType :
    MonarchOperation<GetSnapshotsByAccountType.Input, GetNetworthByTypeResponseData> {
    override val operationName: String = "GetSnapshotsByAccountType"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: String,
        val timeframe: String = "month",
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("startDate" to input.startDate, "timeframe" to input.timeframe)

    override fun parseOutput(data: JsonNode): GetNetworthByTypeResponseData =
        GetNetworthByTypeResponseData(
            snapshotsByAccountType =
                data.path("snapshotsByAccountType").map {
                    // Monarch returns `month` as `YYYY-MM-DD` (day/week timeframe),
                    // `YYYY-MM` (month timeframe), or `YYYY` (year timeframe). Coerce
                    // all to a full LocalDate by padding with `-01` for first-of-month
                    // and `-01-01` for first-of-year.
                    val raw = it.path("month").asText("1970-01-01")
                    val padded =
                        when (raw.count { ch -> ch == '-' }) {
                            0 -> "$raw-01-01"
                            1 -> "$raw-01"
                            else -> raw
                        }
                    SnapshotByAccountType(
                        date = LocalDate.parse(padded),
                        accountType = it.path("accountType").asText(""),
                        balance = it.path("balance").asDouble(0.0),
                    )
                },
            accountTypes =
                data.path("accountTypes").map {
                    AccountTypeReference(
                        name = it.path("name").asText(""),
                        display = null,
                        group = it.path("group").asTextOrNull(),
                    )
                },
        )
}
