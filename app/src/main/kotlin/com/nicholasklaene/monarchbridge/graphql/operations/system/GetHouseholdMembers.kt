package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetHouseholdMembersResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetHouseholdMembersResponseDataMembersInner
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Household member roster + the caller's user id (`meId`) for "you are this person" UI hints. */
object GetHouseholdMembers : MonarchOperation<Unit, GetHouseholdMembersResponseData> {
    override val operationName: String = "Common_GetHouseholdMembers"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetHouseholdMembersResponseData {
        val household = data.path("myHousehold")
        return GetHouseholdMembersResponseData(
            meId = data.path("me").path("id").asText(""),
            householdId = household.path("id").asText(""),
            members =
                household.path("users").map { user ->
                    GetHouseholdMembersResponseDataMembersInner(
                        id = user.path("id").asText(""),
                        name = user.path("name").asTextOrNull(),
                        displayName = user.path("displayName").asTextOrNull(),
                        householdRole = user.path("householdRole").asTextOrNull(),
                        profilePictureUrl = user.path("profilePictureUrl").asTextOrNull(),
                    )
                },
        )
    }
}
