package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.InviteHouseholdMemberRequest
import com.nicholasklaene.monarchbridge.generated.model.InviteHouseholdMemberResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/** Send a Monarch invitation email to a new household member. `email` required; `role` defaults to `member`. */
object InviteHouseholdMember : MonarchOperation<InviteHouseholdMember.Input, InviteHouseholdMemberResponseData> {
    override val operationName: String = "Common_InviteHouseholdMember"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val email: String,
        val role: String? = null,
    ) {
        companion object {
            fun from(req: InviteHouseholdMemberRequest): Input =
                Input(
                    email = req.email,
                    role = req.role?.value,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOfNotNull(
                    "email" to input.email,
                    "role" to input.role,
                ),
        )

    override fun parseOutput(data: JsonNode): InviteHouseholdMemberResponseData {
        val node = data.path("inviteHouseholdMember").path("invitation")
        return InviteHouseholdMemberResponseData(
            invited = !node.isMissingNode && !node.isNull,
            email = node.path("email").asTextOrNull(),
            role = node.path("role").asTextOrNull(),
        )
    }
}
