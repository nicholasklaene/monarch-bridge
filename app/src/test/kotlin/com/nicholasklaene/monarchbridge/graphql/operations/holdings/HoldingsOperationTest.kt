package com.nicholasklaene.monarchbridge.graphql.operations.holdings

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateHoldingsEntry
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateHoldingsRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class HoldingsOperationTest {
    // -- GetHoldingTransactions -------------------------------------------

    @Test
    fun `GetHoldingTransactions parses each event type with monetary fields`() {
        val data =
            jsonNode(
                """
                {
                  "holdingTransactions": [
                    {"id":"ht1","date":"2026-05-01","type":"buy","quantity":10.0,
                     "price":150.25,"amount":-1502.50,"fees":0.0,"notes":"initial buy"},
                    {"id":"ht2","date":"2026-05-15","type":"dividend","quantity":0.0,
                     "price":0.0,"amount":12.40,"fees":0.0,"notes":null},
                    {"id":"ht3","date":"2026-05-20","type":"sell","quantity":-3.0,
                     "price":160.00,"amount":480.00,"fees":1.0,"notes":"trim"}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetHoldingTransactions.parseOutput(data)
        assertThat(out.transactions).hasSize(3)
        assertThat(out.transactions[0].type).isEqualTo("buy")
        assertThat(out.transactions[0].amount).isEqualTo(-1502.50)
        assertThat(out.transactions[0].notes).isEqualTo("initial buy")
        assertThat(out.transactions[1].type).isEqualTo("dividend")
        assertThat(out.transactions[1].notes).isNull()
        assertThat(out.transactions[2].fees).isEqualTo(1.0)
    }

    @Test
    fun `GetHoldingTransactions returns empty list when none in window`() {
        val out = GetHoldingTransactions.parseOutput(jsonNode("""{"holdingTransactions": []}"""))
        assertThat(out.transactions).isEmpty()
    }

    @Test
    fun `GetHoldingTransactions handles row with only id (every other field absent)`() {
        // Useful when Monarch returns a partial event during the polling-status window
        // we still want a valid row, not an exception.
        val out =
            GetHoldingTransactions.parseOutput(
                jsonNode("""{"holdingTransactions":[{"id":"ht-x"}]}"""),
            )
        assertThat(out.transactions).hasSize(1)
        val row = out.transactions.first()
        assertThat(row.id).isEqualTo("ht-x")
        assertThat(row.date).isNull()
        assertThat(row.type).isNull()
        assertThat(row.quantity).isNull()
        assertThat(row.amount).isNull()
    }

    @Test
    fun `GetHoldingTransactions variables include holdingId and only set windows`() {
        val full =
            GetHoldingTransactions.variables(
                GetHoldingTransactions.Input(
                    holdingId = "h1",
                    startDate = LocalDate.parse("2026-01-01"),
                    endDate = LocalDate.parse("2026-12-31"),
                    limit = 50,
                    offset = 100,
                ),
            )
        assertThat(full).containsEntry("holdingId", "h1")
        assertThat(full).containsEntry("startDate", "2026-01-01")
        assertThat(full).containsEntry("endDate", "2026-12-31")
        assertThat(full).containsEntry("limit", 50)
        assertThat(full).containsEntry("offset", 100)

        // Only-required: holdingId stays, every optional drops out.
        val minimal = GetHoldingTransactions.variables(GetHoldingTransactions.Input(holdingId = "h2"))
        assertThat(minimal).containsExactlyEntriesOf(mapOf("holdingId" to "h2"))
    }

    // -- BulkUpdateHoldings -----------------------------------------------

    @Test
    fun `BulkUpdateHoldings parses counts plus per-row failures`() {
        val data =
            jsonNode(
                """
                {
                  "bulkUpdateHoldings": {
                    "updatedCount": 8,
                    "failedCount": 2,
                    "failures": [
                      {"holdingId":"h-bad-1","reason":"quantity_negative"},
                      {"holdingId":"h-bad-2","reason":null}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = BulkUpdateHoldings.parseOutput(data)
        assertThat(out.updatedCount).isEqualTo(8)
        assertThat(out.failedCount).isEqualTo(2)
        assertThat(out.failures).hasSize(2)
        assertThat(out.failures[0].holdingId).isEqualTo("h-bad-1")
        assertThat(out.failures[0].reason).isEqualTo("quantity_negative")
        assertThat(out.failures[1].reason).isNull()
    }

    @Test
    fun `BulkUpdateHoldings defaults counts to zero and failures to empty when nothing returned`() {
        val out = BulkUpdateHoldings.parseOutput(jsonNode("""{"bulkUpdateHoldings": {}}"""))
        assertThat(out.updatedCount).isZero
        assertThat(out.failedCount).isZero
        assertThat(out.failures).isEmpty()
    }

    @Test
    fun `BulkUpdateHoldings variables drop nulls per row so Monarch sees only patched fields`() {
        val vars =
            BulkUpdateHoldings.variables(
                BulkUpdateHoldings.Input(
                    updates =
                        listOf(
                            BulkUpdateHoldings.Update(holdingId = "h1", quantity = 10.0, costBasis = 1500.0),
                            BulkUpdateHoldings.Update(holdingId = "h2", quantity = null, costBasis = 200.0),
                            BulkUpdateHoldings.Update(holdingId = "h3", quantity = 5.0),
                        ),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>

        @Suppress("UNCHECKED_CAST")
        val updates = input["updates"] as List<Map<String, Any?>>
        assertThat(updates).hasSize(3)
        assertThat(updates[0]).containsEntry("holdingId", "h1").containsEntry("quantity", 10.0).containsEntry("costBasis", 1500.0)
        assertThat(updates[1]).containsEntry("holdingId", "h2").containsEntry("costBasis", 200.0).doesNotContainKey("quantity")
        assertThat(updates[2]).containsEntry("holdingId", "h3").containsEntry("quantity", 5.0).doesNotContainKey("costBasis")
    }

    @Test
    fun `BulkUpdateHoldings Input from copies each entry from request`() {
        val req =
            BulkUpdateHoldingsRequest(
                updates =
                    listOf(
                        BulkUpdateHoldingsEntry(holdingId = "h1", quantity = 1.0, costBasis = 100.0),
                        BulkUpdateHoldingsEntry(holdingId = "h2"),
                    ),
            )
        val input = BulkUpdateHoldings.Input.from(req)
        assertThat(input.updates).hasSize(2)
        assertThat(input.updates[0].holdingId).isEqualTo("h1")
        assertThat(input.updates[0].quantity).isEqualTo(1.0)
        assertThat(input.updates[0].costBasis).isEqualTo(100.0)
        assertThat(input.updates[1].holdingId).isEqualTo("h2")
        assertThat(input.updates[1].quantity).isNull()
        assertThat(input.updates[1].costBasis).isNull()
    }
}
