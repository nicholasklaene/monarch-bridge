package com.nicholasklaene.monarchbridge.graphql.operations.web

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Web bundle screen-aggregate `Web_AssignTaxScheduleCategoryMapping` (mutation). Wired as opaque pass-through:
 * the proxy forwards `variables` as-is and returns Monarch's `data` tree wrapped
 * in a FreeForm map. Aggregate shape is volatile across Monarch web releases and
 * not typed end-to-end here.
 */
object WebAssignTaxScheduleCategoryMapping : MonarchOperation<WebAssignTaxScheduleCategoryMapping.Input, Map<String, Any>> {
    override val operationName: String = "Web_AssignTaxScheduleCategoryMapping"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    /** Pass-through variables. `null` and empty are both treated as "no variables". */
    data class Input(
        val variables: Map<String, Any>? = null,
    )

    override fun variables(input: Input): Map<String, Any> = input.variables.orEmpty()

    override fun parseOutput(data: JsonNode): Map<String, Any> = MAPPER.convertValue(data, MAP_TYPE)

    private val MAPPER = jacksonObjectMapper()
    private val MAP_TYPE = object : TypeReference<Map<String, Any>>() {}
}
