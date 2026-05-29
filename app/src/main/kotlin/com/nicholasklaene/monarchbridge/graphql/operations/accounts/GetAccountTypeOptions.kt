package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.GetAccountTypeOptionsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Valid (type, subtype) combinations for manual account creation. Use this to
 * populate dropdowns or validate the `--type` / `--subtype` args of
 * `monarch account create`. Output is the spec-generated [GetAccountTypeOptionsResponseData].
 */
object GetAccountTypeOptions : MonarchOperation<Unit, GetAccountTypeOptionsResponseData> {
    override val operationName: String = "GetAccountTypeOptions"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetAccountTypeOptionsResponseData {
        val mapper = ObjectMapper()
        @Suppress("UNCHECKED_CAST")
        return GetAccountTypeOptionsResponseData(
            accountTypeOptions =
                data.path("accountTypeOptions").map {
                    mapper.convertValue(it, Map::class.java) as Map<String, Any>
                },
        )
    }
}
