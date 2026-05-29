package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetIntegrationStatusResponseData
import com.nicholasklaene.monarchbridge.generated.model.IntegrationStatus
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Per-credential health for each linked provider (Plaid / MX / Finicity). The web app's
 * "Connection issues" banner walks this list and surfaces any row with `needsReauth=true`
 * or a non-null `errorCode`.
 *
 * `status` values: `connected`, `syncing`, `error`, `disconnected`.
 */
object GetIntegrationStatus : MonarchOperation<Unit, GetIntegrationStatusResponseData> {
    override val operationName: String = "Common_GetIntegrationStatus"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetIntegrationStatusResponseData =
        GetIntegrationStatusResponseData(
            integrations =
                data.path("integrationStatus").map { i ->
                    IntegrationStatus(
                        credentialId = i.path("credentialId").asText(""),
                        institutionName = i.path("institutionName").asTextOrNull(),
                        provider = i.path("provider").asTextOrNull(),
                        status = i.path("status").asTextOrNull(),
                        lastSyncedAt = i.path("lastSyncedAt").asTextOrNull(),
                        errorCode = i.path("errorCode").asTextOrNull(),
                        errorMessage = i.path("errorMessage").asTextOrNull(),
                        needsReauth = i.path("needsReauth").asBooleanOrNull(),
                    )
                },
        )
}
