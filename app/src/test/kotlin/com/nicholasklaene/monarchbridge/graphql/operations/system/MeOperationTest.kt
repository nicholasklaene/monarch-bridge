package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateMeRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class MeOperationTest {
    @Test
    fun `GetMe parses the full me node`() {
        val data =
            jsonNode(
                """
                {"me": {"id": "u-1", "email": "n@x.com", "name": "Sam", "displayName": "Sam",
                "timezone": "America/Los_Angeles", "birthday": "1990-01-01",
                "hasPassword": true, "hasMfaOn": false, "householdRole": "owner",
                "createdAt": "2024-01-01T00:00:00Z"}}
                """.trimIndent(),
            )
        val out = GetMe.parseOutput(data)
        assertThat(out.id).isEqualTo("u-1")
        assertThat(out.email).isEqualTo("n@x.com")
        assertThat(out.displayName).isEqualTo("Sam")
        assertThat(out.householdRole).isEqualTo("owner")
        assertThat(out.hasPassword).isTrue()
        assertThat(out.hasMfaOn).isFalse()
    }

    @Test
    fun `GetMe is forgiving of missing fields`() {
        val out = GetMe.parseOutput(jsonNode("""{"me": {"id": "u-1"}}"""))
        assertThat(out.id).isEqualTo("u-1")
        assertThat(out.email).isNull()
        assertThat(out.hasPassword).isNull()
    }

    @Test
    fun `UpdateMe parses the response and only forwards non-null fields`() {
        val input =
            UpdateMe.Input.from(
                UpdateMeRequest(
                    email = "n@x.com",
                    name = null,
                    birthday = LocalDate.parse("1990-01-01"),
                    timezone = null,
                ),
            )
        val vars = UpdateMe.variables(input)

        @Suppress("UNCHECKED_CAST")
        val inputMap = vars["input"] as Map<String, Any?>
        assertThat(inputMap).containsEntry("email", "n@x.com")
        assertThat(inputMap).containsEntry("birthday", "1990-01-01")
        assertThat(inputMap).doesNotContainKey("name")
        assertThat(inputMap).doesNotContainKey("timezone")

        val data =
            jsonNode(
                """
                {"updateMe": {"me": {"id": "u-1", "email": "n@x.com", "name": "Sam",
                "displayName": "Sam", "timezone": null, "birthday": "1990-01-01"}}}
                """.trimIndent(),
            )
        val out = UpdateMe.parseOutput(data)
        assertThat(out.id).isEqualTo("u-1")
        assertThat(out.email).isEqualTo("n@x.com")
        assertThat(out.timezone).isNull()
    }

    @Test
    fun `GetMyHousehold parses the household`() {
        val out =
            GetMyHousehold.parseOutput(
                jsonNode(
                    """
                    {"myHousehold": {"id": "h-1", "name": "Acme Household", "address": "1 Main",
                    "city": "Seattle", "state": "WA", "zipCode": "98101", "country": "US"}}
                    """.trimIndent(),
                ),
            )
        assertThat(out.id).isEqualTo("h-1")
        assertThat(out.city).isEqualTo("Seattle")
    }

    @Test
    fun `GetHouseholdMembers extracts meId, householdId, and users`() {
        val out =
            GetHouseholdMembers.parseOutput(
                jsonNode(
                    """
                    {"me": {"id": "u-1"},
                     "myHousehold": {"id": "h-1", "users": [
                       {"id": "u-1", "name": "Sam", "displayName": "Sam",
                        "householdRole": "owner", "profilePictureUrl": "u"},
                       {"id": "u-2", "name": null, "displayName": "Other", "householdRole": "member",
                        "profilePictureUrl": null}
                     ]}}
                    """.trimIndent(),
                ),
            )
        assertThat(out.meId).isEqualTo("u-1")
        assertThat(out.householdId).isEqualTo("h-1")
        assertThat(out.members).hasSize(2)
        assertThat(out.members[1].name).isNull()
        assertThat(out.members[0].householdRole).isEqualTo("owner")
    }

    @Test
    fun `operation names match the bundle`() {
        assertThat(GetMe.operationName).isEqualTo("Common_GetMe")
        assertThat(UpdateMe.operationName).isEqualTo("Common_UpdateMe")
        assertThat(GetMyHousehold.operationName).isEqualTo("Common_GetMyHousehold")
        assertThat(GetHouseholdMembers.operationName).isEqualTo("Common_GetHouseholdMembers")
    }
}
