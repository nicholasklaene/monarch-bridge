package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.GetInstitutionsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * All linked credential / institution records (the connection pipes — distinct from
 * the accounts themselves). Useful for spotting stale/broken Plaid links. Output is the
 * spec-generated [GetInstitutionsResponseData]; credentials/accounts/subscription
 * are passed through as free-form maps since their upstream shapes are deep + volatile.
 */
object GetInstitutions : MonarchOperation<Unit, GetInstitutionsResponseData> {
    override val operationName: String = "Web_GetInstitutionSettings"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetInstitutionsResponseData {
        val mapper = ObjectMapper()
        return GetInstitutionsResponseData(
            credentials = data.path("credentials").toListOfMaps(mapper),
            accounts = data.path("accounts").toListOfMaps(mapper),
            subscription = data.path("subscription").takeIf { !it.isMissingNode && !it.isNull }?.toMap(mapper),
        )
    }

    @Suppress("UNCHECKED_CAST")
    private fun JsonNode.toListOfMaps(mapper: ObjectMapper): List<Map<String, Any>> =
        if (isArray) map { mapper.convertValue(it, Map::class.java) as Map<String, Any> } else emptyList()

    @Suppress("UNCHECKED_CAST")
    private fun JsonNode.toMap(mapper: ObjectMapper): Map<String, Any> = mapper.convertValue(this, Map::class.java) as Map<String, Any>
}
