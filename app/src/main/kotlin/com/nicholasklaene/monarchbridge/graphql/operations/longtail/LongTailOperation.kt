package com.nicholasklaene.monarchbridge.graphql.operations.longtail

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Base class for every long-tail operation under `graphql/operations/longtail/`.
 *
 * The long-tail surface is the wide tier of Monarch GraphQL ops that haven't been
 * promoted to typed resource controllers yet. Each subclass binds one upstream
 * operation by name and reuses the same generic plumbing:
 *
 *  * The Kotlin object's `operationName` matches `graphql/operations/<name>.graphql`.
 *  * `variables(input)` forwards the caller's raw GraphQL variables map verbatim.
 *  * `parseOutput(data)` materializes the `data` JsonNode as a `Map<String, Any?>`
 *    so the controller can wrap it in the shared `LongTailResponse` envelope.
 *
 * Concrete subclasses are one-liners that pass the GraphQL operation name to the
 * constructor. Keeps per-operation overhead at a single declaration.
 */
abstract class LongTailOperation(
    final override val operationName: String,
) : MonarchOperation<Map<String, Any?>, Map<String, Any>> {
    final override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Map<String, Any?>): Map<String, Any?> = input

    /**
     * Materialize the upstream `data` JsonNode as a `Map<String, Any>`. Null values are
     * dropped at the top level so the result satisfies the non-nullable `Map<String, Any>`
     * shape the generated DTO requires; the nested tree retains its original JSON nulls.
     */
    override fun parseOutput(data: JsonNode): Map<String, Any> {
        val raw: Map<String, Any?> = MAPPER.convertValue(data, MAP_TYPE)
        return raw.filterValues { it != null }.mapValues { it.value as Any }
    }

    companion object {
        private val MAPPER = ObjectMapper()
        private val MAP_TYPE =
            MAPPER.typeFactory.constructMapType(
                LinkedHashMap::class.java,
                String::class.java,
                Any::class.java,
            )
    }
}
