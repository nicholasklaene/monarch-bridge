package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SubscriptionOperationTest {
    @Test
    fun `GetEntitlements parses subscription id and entitlements array`() {
        val out =
            GetEntitlements.parseOutput(
                jsonNode("""{"subscription": {"id": "s-1", "entitlements": ["a", "b", "c"]}}"""),
            )
        assertThat(out.id).isEqualTo("s-1")
        assertThat(out.entitlements).containsExactly("a", "b", "c")
    }

    @Test
    fun `GetEntitlements handles empty entitlements list`() {
        val out = GetEntitlements.parseOutput(jsonNode("""{"subscription": {"id": "s-1", "entitlements": []}}"""))
        assertThat(out.entitlements).isEmpty()
    }

    @Test
    fun `GetPlusTierAccess parses trial timestamps`() {
        val out =
            GetPlusTierAccess.parseOutput(
                jsonNode(
                    """
                    {"subscription": {"id": "s-1", "entitlements": ["plus"],
                     "plusTrialEndsAt": "2026-06-01T00:00:00Z", "canceledPlusTrialAt": null}}
                    """.trimIndent(),
                ),
            )
        assertThat(out.id).isEqualTo("s-1")
        assertThat(out.plusTrialEndsAt).isEqualTo("2026-06-01T00:00:00Z")
        assertThat(out.canceledPlusTrialAt).isNull()
    }

    @Test
    fun `operation names match`() {
        assertThat(GetEntitlements.operationName).isEqualTo("Common_GetEntitlements")
        assertThat(GetPlusTierAccess.operationName).isEqualTo("Common_GetPlusTierAccess")
    }
}
