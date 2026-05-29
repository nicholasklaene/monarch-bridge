package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.InviteHouseholdMemberRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdNameRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HouseholdAndPasswordOperationTest {
    // -- InitiatePasswordChange -------------------------------------------

    @Test
    fun `InitiatePasswordChange parses requestId and email`() {
        val data =
            jsonNode(
                """
                {"initiatePasswordChange":{"requestId":"req-abc","email":"u@example.com"}}
                """.trimIndent(),
            )
        val out = InitiatePasswordChange.parseOutput(data)
        assertThat(out.requestId).isEqualTo("req-abc")
        assertThat(out.email).isEqualTo("u@example.com")
    }

    @Test
    fun `InitiatePasswordChange tolerates missing fields`() {
        val out = InitiatePasswordChange.parseOutput(jsonNode("""{"initiatePasswordChange":{}}"""))
        assertThat(out.requestId).isNull()
        assertThat(out.email).isNull()
    }

    @Test
    fun `InitiatePasswordChange variables are empty`() {
        assertThat(InitiatePasswordChange.variables(Unit)).isEmpty()
    }

    // -- UpdateHouseholdName ----------------------------------------------

    @Test
    fun `UpdateHouseholdName parses new name from mutation envelope`() {
        val data =
            jsonNode("""{"updateHouseholdName":{"household":{"id":"h-1","name":"Acme Home"}}}""")
        val out = UpdateHouseholdName.parseOutput(data)
        assertThat(out.name).isEqualTo("Acme Home")
    }

    @Test
    fun `UpdateHouseholdName tolerates empty household payload`() {
        val out = UpdateHouseholdName.parseOutput(jsonNode("""{"updateHouseholdName":{}}"""))
        assertThat(out.name).isNull()
    }

    @Test
    fun `UpdateHouseholdName variables wrap name under input key`() {
        val vars = UpdateHouseholdName.variables(UpdateHouseholdName.Input(name = "New Name"))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("name", "New Name")
    }

    @Test
    fun `UpdateHouseholdName Input from copies request name`() {
        val input = UpdateHouseholdName.Input.from(UpdateHouseholdNameRequest(name = "Smiths"))
        assertThat(input.name).isEqualTo("Smiths")
    }

    // -- InviteHouseholdMember --------------------------------------------

    @Test
    fun `InviteHouseholdMember marks invited true when invitation node present`() {
        val data =
            jsonNode(
                """
                {"inviteHouseholdMember":{"invitation":{"email":"new@example.com","role":"member"}}}
                """.trimIndent(),
            )
        val out = InviteHouseholdMember.parseOutput(data)
        assertThat(out.invited).isTrue
        assertThat(out.email).isEqualTo("new@example.com")
        assertThat(out.role).isEqualTo("member")
    }

    @Test
    fun `InviteHouseholdMember marks invited false when invitation node missing`() {
        val out = InviteHouseholdMember.parseOutput(jsonNode("""{"inviteHouseholdMember":{}}"""))
        assertThat(out.invited).isFalse
        assertThat(out.email).isNull()
    }

    @Test
    fun `InviteHouseholdMember variables require email and drop null role`() {
        val vars = InviteHouseholdMember.variables(InviteHouseholdMember.Input(email = "new@example.com"))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("email", "new@example.com")
        assertThat(input).doesNotContainKey("role")
    }

    @Test
    fun `InviteHouseholdMember variables include role when provided`() {
        val vars =
            InviteHouseholdMember.variables(
                InviteHouseholdMember.Input(email = "new@example.com", role = "viewer"),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("email", "new@example.com").containsEntry("role", "viewer")
    }

    @Test
    fun `InviteHouseholdMember Input from extracts role enum value`() {
        val input =
            InviteHouseholdMember.Input.from(
                InviteHouseholdMemberRequest(
                    email = "x@example.com",
                    role = InviteHouseholdMemberRequest.Role.OWNER,
                ),
            )
        assertThat(input.email).isEqualTo("x@example.com")
        assertThat(input.role).isEqualTo("owner")
    }

    @Test
    fun `InviteHouseholdMember Input from leaves role null when request role is null`() {
        val input =
            InviteHouseholdMember.Input.from(
                InviteHouseholdMemberRequest(email = "x@example.com", role = null),
            )
        assertThat(input.role).isNull()
    }

    // -- RemoveHouseholdMember --------------------------------------------

    @Test
    fun `RemoveHouseholdMember parses deleted boolean`() {
        val data = jsonNode("""{"removeHouseholdMember":{"deleted":true}}""")
        val out = RemoveHouseholdMember.parseOutput(data)
        assertThat(out.removed).isTrue
    }

    @Test
    fun `RemoveHouseholdMember tolerates missing deleted flag`() {
        val out = RemoveHouseholdMember.parseOutput(jsonNode("""{"removeHouseholdMember":{}}"""))
        assertThat(out.removed).isNull()
    }

    @Test
    fun `RemoveHouseholdMember variables include id at top level`() {
        val vars = RemoveHouseholdMember.variables(RemoveHouseholdMember.Input(id = "user-42"))
        assertThat(vars).containsEntry("id", "user-42")
    }
}
