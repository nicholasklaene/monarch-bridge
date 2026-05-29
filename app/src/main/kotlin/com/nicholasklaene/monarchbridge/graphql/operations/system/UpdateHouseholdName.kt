package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdNameRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdNameResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Rename the household. The new name appears in invitations and on every member's home screen. */
object UpdateHouseholdName : MonarchOperation<UpdateHouseholdName.Input, UpdateHouseholdNameResponseData> {
    override val operationName: String = "Common_UpdateHouseholdName"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val name: String,
    ) {
        companion object {
            fun from(req: UpdateHouseholdNameRequest): Input = Input(name = req.name)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to mapOf("name" to input.name),
        )

    override fun parseOutput(data: JsonNode): UpdateHouseholdNameResponseData {
        val node = data.path("updateHouseholdName").path("household")
        return UpdateHouseholdNameResponseData(
            name = node.path("name").asTextOrNull(),
        )
    }
}
