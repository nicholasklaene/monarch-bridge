package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetInstitutionByPlaidIdResponseData
import com.nicholasklaene.monarchbridge.generated.model.InstitutionDetail
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull

/** Institution lookup by Plaid id. Includes connection-health flags. */
object GetInstitutionByPlaidId : MonarchOperation<GetInstitutionByPlaidId.Input, GetInstitutionByPlaidIdResponseData> {
    override val operationName: String = "Common_GetInstitution"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val plaidId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("plaidId" to input.plaidId)

    override fun parseOutput(data: JsonNode): GetInstitutionByPlaidIdResponseData =
        GetInstitutionByPlaidIdResponseData(
            institution =
                data.pathOrNull("institution")?.let { n ->
                    InstitutionDetail(
                        id = n.path("id").asTextOrNull(),
                        name = n.path("name").asTextOrNull(),
                        logo = n.path("logo").asTextOrNull(),
                        newConnectionsDisabled = n.path("newConnectionsDisabled").asBooleanOrNull(),
                        hasIssuesReported = n.path("hasIssuesReported").asBooleanOrNull(),
                        hasIssuesReportedMessage = n.path("hasIssuesReportedMessage").asTextOrNull(),
                        plaidStatus = n.path("plaidStatus").asTextOrNull(),
                        status = n.path("status").asTextOrNull(),
                        balanceStatus = n.path("balanceStatus").asTextOrNull(),
                        transactionsStatus = n.path("transactionsStatus").asTextOrNull(),
                    )
                },
        )
}
