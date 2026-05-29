package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTopInstitutionGroupsResponseData
import com.nicholasklaene.monarchbridge.generated.model.TopInstitution
import com.nicholasklaene.monarchbridge.generated.model.TopInstitutionGroup
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Top institution groups (popular providers by category). Used by Add-Account UI. */
object GetTopInstitutionGroups : MonarchOperation<GetTopInstitutionGroups.Input, GetTopInstitutionGroupsResponseData> {
    override val operationName: String = "Web_GetTopInstitutionGroups"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val dataProviders: List<String>,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("dataProviders" to input.dataProviders)

    override fun parseOutput(data: JsonNode): GetTopInstitutionGroupsResponseData =
        GetTopInstitutionGroupsResponseData(
            equityAccountsCount = data.path("equityAccountsCount").asIntOrNull(),
            credentialsCount = data.path("credentials").takeIf { it.isArray }?.size(),
            groups =
                data.path("topInstitutionGroups").map { g ->
                    TopInstitutionGroup(
                        type = g.path("type").asText(""),
                        title = g.path("title").asTextOrNull(),
                        shortTitle = g.path("shortTitle").asTextOrNull(),
                        accountsConnectedCount = g.path("accountsConnectedCount").asIntOrNull(),
                        institutions =
                            g.path("institutions").map { i ->
                                TopInstitution(
                                    id = i.path("id").asText(""),
                                    name = i.path("name").asTextOrNull(),
                                    logo = i.path("logo").asTextOrNull(),
                                )
                            },
                    )
                },
        )
}
