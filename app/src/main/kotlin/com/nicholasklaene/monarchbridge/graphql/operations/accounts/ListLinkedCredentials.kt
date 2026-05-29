package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.LinkedCredential
import com.nicholasklaene.monarchbridge.generated.model.ListLinkedCredentialsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Lightweight list of every linked data-provider credential plus its institution
 * (id, name, logo). Use this for "show my connected banks" lists; for richer per-
 * credential settings (sync state, update-required flag, owner) use the existing
 * institution-settings endpoint.
 */
object ListLinkedCredentials : MonarchOperation<Unit, ListLinkedCredentialsResponseData> {
    override val operationName: String = "Web_GetLinkedCredentials"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): ListLinkedCredentialsResponseData =
        ListLinkedCredentialsResponseData(
            credentials =
                data.path("credentials").map { node ->
                    val inst = node.path("institution")
                    LinkedCredential(
                        id = node.path("id").asText(""),
                        institutionId = inst.path("id").asTextOrNull(),
                        institutionName = inst.path("name").asTextOrNull(),
                        institutionLogo = inst.path("logo").asTextOrNull(),
                    )
                },
        )
}
