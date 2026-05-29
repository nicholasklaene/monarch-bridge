package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CredentialInstitutionRow
import com.nicholasklaene.monarchbridge.generated.model.GetCredentialInstitutionsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * List of credentials with institution metadata (per-provider ids + preferred provider).
 * Richer than `/v1/credentials` which only returns Plaid id and basic name/logo.
 */
object GetCredentialInstitutions : MonarchOperation<Unit, GetCredentialInstitutionsResponseData> {
    override val operationName: String = "Common_GetCredentialInstitutions"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetCredentialInstitutionsResponseData =
        GetCredentialInstitutionsResponseData(
            credentials =
                data.path("credentials").map { c ->
                    val inst = c.path("institution")
                    CredentialInstitutionRow(
                        credentialId = c.path("id").asText(""),
                        institutionId = inst.path("id").asTextOrNull(),
                        name = inst.path("name").asTextOrNull(),
                        plaidInstitutionId = inst.path("plaidInstitutionId").asTextOrNull(),
                        finicityInstitutionId = inst.path("finicityInstitutionId").asTextOrNull(),
                        mxInstitutionId = inst.path("mxInstitutionId").asTextOrNull(),
                        preferredDataProvider = inst.path("preferredDataProvider").asTextOrNull(),
                        logo = inst.path("logo").asTextOrNull(),
                    )
                },
        )
}
