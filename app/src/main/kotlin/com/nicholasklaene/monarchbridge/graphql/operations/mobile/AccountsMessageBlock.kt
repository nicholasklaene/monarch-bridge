package com.nicholasklaene.monarchbridge.graphql.operations.mobile

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Mobile screen-aggregate query wired as an opaque FreeForm pass-through. The
 * deep response tree is intentionally untyped (Map<String, Any>) because Monarch's
 * mobile-bundle aggregates change shape across app releases; modeling each field
 * would create churn with no caller benefit. Null leaves are dropped to satisfy the
 * spec-generated non-nullable value type on FreeForm.
 */
object AccountsMessageBlock : MonarchOperation<Unit, Map<String, Any>> {
    override val operationName: String = "Mobile_AccountsMessageBlock"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any> = emptyMap()

    @Suppress("UNCHECKED_CAST")
    override fun parseOutput(data: JsonNode): Map<String, Any> {
        val mapped =
            ObjectMapper()
                .convertValue(data, Map::class.java)
                ?: emptyMap<String, Any?>()
        val raw = mapped as Map<String, Any?>
        return raw.filterValues { it != null } as Map<String, Any>
    }
}
