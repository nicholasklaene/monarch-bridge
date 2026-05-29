package com.nicholasklaene.monarchbridge.graphql.operations.investments

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetSecurityDividendsResponseData
import com.nicholasklaene.monarchbridge.generated.model.SecurityDividend
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/** Dividend payment history for one security across a window. */
object GetSecurityDividends : MonarchOperation<GetSecurityDividends.Input, GetSecurityDividendsResponseData> {
    override val operationName: String = "Web_GetSecurityDividends"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
        val startDate: LocalDate? = null,
        val endDate: LocalDate? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "id" to input.id,
            "startDate" to input.startDate?.toString(),
            "endDate" to input.endDate?.toString(),
        )

    override fun parseOutput(data: JsonNode): GetSecurityDividendsResponseData =
        GetSecurityDividendsResponseData(
            dividends =
                data.path("securityDividends").path("dividends").map { d ->
                    SecurityDividend(
                        date = LocalDate.parse(d.path("date").asText("1970-01-01")),
                        amount = d.path("amount").asDoubleOrNull(),
                        type = d.path("type").asTextOrNull(),
                    )
                },
        )
}
