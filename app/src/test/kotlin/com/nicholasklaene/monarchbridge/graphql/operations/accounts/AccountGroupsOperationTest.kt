package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountGroupOrderRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountGroupsOperationTest {
    // -- GetAccountGroups -------------------------------------------------

    @Test
    fun `GetAccountGroups parses every field on each group`() {
        val data =
            jsonNode(
                """
                {
                  "accountGroups": [
                    {"id":"g1","name":"Banking","order":1,"isCollapsed":false,
                     "accountIds":["a1","a2","a3"]},
                    {"id":"g2","name":"Brokerage","order":2,"isCollapsed":true,
                     "accountIds":["a4"]}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetAccountGroups.parseOutput(data)
        assertThat(out.groups).hasSize(2)
        val first = out.groups.first()
        assertThat(first.id).isEqualTo("g1")
        assertThat(first.name).isEqualTo("Banking")
        assertThat(first.order).isEqualTo(1)
        assertThat(first.isCollapsed).isFalse
        assertThat(first.accountIds).containsExactly("a1", "a2", "a3")
        assertThat(out.groups[1].isCollapsed).isTrue
    }

    @Test
    fun `GetAccountGroups returns empty list when array empty`() {
        val out = GetAccountGroups.parseOutput(jsonNode("""{"accountGroups": []}"""))
        assertThat(out.groups).isEmpty()
    }

    @Test
    fun `GetAccountGroups defaults isCollapsed to null when field missing`() {
        // Older payloads (pre-collapse-feature) might omit isCollapsed entirely.
        // We expect null, not a coerced false, so callers can distinguish "unset" from "expanded".
        val data =
            jsonNode("""{"accountGroups":[{"id":"g1","name":"X","order":0,"accountIds":[]}]}""")
        val out = GetAccountGroups.parseOutput(data)
        assertThat(out.groups.first().isCollapsed).isNull()
    }

    @Test
    fun `GetAccountGroups variables are empty`() {
        assertThat(GetAccountGroups.variables(Unit)).isEmpty()
    }

    // -- UpdateAccountGroupOrder ------------------------------------------

    @Test
    fun `UpdateAccountGroupOrder parses each id-order pair`() {
        val data =
            jsonNode(
                """
                {
                  "updateAccountGroupOrder": {
                    "accountGroups": [
                      {"id":"g1","order":0},
                      {"id":"g2","order":1},
                      {"id":"g3","order":2}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateAccountGroupOrder.parseOutput(data)
        assertThat(out.groups).hasSize(3)
        assertThat(out.groups.map { it.id to it.order })
            .containsExactly("g1" to 0, "g2" to 1, "g3" to 2)
    }

    @Test
    fun `UpdateAccountGroupOrder defaults id to empty string and order to zero when payload bare`() {
        val data = jsonNode("""{"updateAccountGroupOrder":{"accountGroups":[{}]}}""")
        val out = UpdateAccountGroupOrder.parseOutput(data)
        assertThat(out.groups).hasSize(1)
        assertThat(out.groups.first().id).isEmpty()
        assertThat(out.groups.first().order).isZero
    }

    @Test
    fun `UpdateAccountGroupOrder variables wrap groupIds inside input`() {
        val vars =
            UpdateAccountGroupOrder.variables(
                UpdateAccountGroupOrder.Input(groupIds = listOf("g3", "g1", "g2")),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input["groupIds"]).isEqualTo(listOf("g3", "g1", "g2"))
    }

    @Test
    fun `UpdateAccountGroupOrder Input from copies groupIds from request`() {
        val req = UpdateAccountGroupOrderRequest(groupIds = listOf("g1", "g2"))
        val input = UpdateAccountGroupOrder.Input.from(req)
        assertThat(input.groupIds).containsExactly("g1", "g2")
    }
}
