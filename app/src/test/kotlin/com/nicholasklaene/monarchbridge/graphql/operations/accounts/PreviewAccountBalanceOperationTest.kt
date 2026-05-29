package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PreviewAccountBalanceOperationTest {
    @Test
    fun `parses display balance preview from account node`() {
        val out =
            PreviewAccountBalance.parseOutput(
                jsonNode("""{"account": {"id": "a-1", "displayBalancePreview": 12345.67}}"""),
            )
        assertThat(out.id).isEqualTo("a-1")
        assertThat(out.displayBalancePreview).isEqualTo(12345.67)
    }

    @Test
    fun `parses null preview gracefully`() {
        val out =
            PreviewAccountBalance.parseOutput(
                jsonNode("""{"account": {"id": "a-1", "displayBalancePreview": null}}"""),
            )
        assertThat(out.displayBalancePreview).isNull()
    }

    @Test
    fun `variables forward the three params`() {
        val vars =
            PreviewAccountBalance.variables(
                PreviewAccountBalance.Input(accountId = "a-1", invertSyncedBalance = true, useAvailableBalance = false),
            )
        assertThat(vars).containsEntry("accountId", "a-1")
        assertThat(vars).containsEntry("invertSyncedBalance", true)
        assertThat(vars).containsEntry("useAvailableBalance", false)
    }

    @Test
    fun `operation name matches the bundle`() {
        assertThat(PreviewAccountBalance.operationName).isEqualTo("Common_GetDisplayBalancePreview")
    }
}
