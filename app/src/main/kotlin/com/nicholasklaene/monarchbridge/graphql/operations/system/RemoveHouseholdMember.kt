package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.RemoveHouseholdMemberResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull

/** Remove a member from the household. Idempotent - re-calling with an already-removed id returns `removed=true`. */
object RemoveHouseholdMember : MonarchOperation<RemoveHouseholdMember.Input, RemoveHouseholdMemberResponseData> {
    override val operationName: String = "Common_RemoveHouseholdMember"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): RemoveHouseholdMemberResponseData {
        val node = data.path("removeHouseholdMember")
        return RemoveHouseholdMemberResponseData(
            removed = node.path("deleted").asBooleanOrNull(),
        )
    }
}
