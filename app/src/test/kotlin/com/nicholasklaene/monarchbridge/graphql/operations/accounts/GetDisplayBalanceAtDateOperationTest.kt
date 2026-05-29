package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class GetDisplayBalanceAtDateOperationTest {
    @Test
    fun `parseOutput picks the first matching account from the filtered list`() {
        val data =
            jsonNode(
                """
                {
                  "accounts": [
                    {
                      "id": "acc-1",
                      "displayBalance": 1234.56,
                      "includeInNetWorth": true,
                      "type": {"name": "brokerage"}
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetDisplayBalanceAtDate.parseOutput(data)
        assertThat(out.id).isEqualTo("acc-1")
        assertThat(out.displayBalance).isEqualTo(1234.56)
        assertThat(out.includeInNetWorth).isTrue()
        assertThat(out.accountType).isEqualTo("brokerage")
    }

    @Test
    fun `parseOutput returns blank id and null balance when accounts list is empty`() {
        val data = jsonNode("""{"accounts": []}""")
        val out = GetDisplayBalanceAtDate.parseOutput(data)
        assertThat(out.id).isEmpty()
        assertThat(out.displayBalance).isNull()
        assertThat(out.includeInNetWorth).isFalse()
        assertThat(out.accountType).isNull()
    }

    @Test
    fun `parseOutput surfaces null displayBalance when Monarch has no snapshot for that date`() {
        val data =
            jsonNode(
                """
                {"accounts": [{"id": "acc-1", "displayBalance": null, "includeInNetWorth": true, "type": {"name": "depository"}}]}
                """.trimIndent(),
            )
        val out = GetDisplayBalanceAtDate.parseOutput(data)
        assertThat(out.id).isEqualTo("acc-1")
        assertThat(out.displayBalance).isNull()
    }

    @Test
    fun `variables serialize date as ISO string and wrap accountId in filters_ids`() {
        val vars =
            GetDisplayBalanceAtDate.variables(
                GetDisplayBalanceAtDate.Input(accountId = "acc-1", date = LocalDate.parse("2026-05-01")),
            )
        assertThat(vars["date"]).isEqualTo("2026-05-01")

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters["ids"]).isEqualTo(listOf("acc-1"))
    }

    @Test
    fun `operationName matches the graphql file query identifier`() {
        assertThat(GetDisplayBalanceAtDate.operationName).isEqualTo("Common_GetDisplayBalanceAtDate")
    }
}
