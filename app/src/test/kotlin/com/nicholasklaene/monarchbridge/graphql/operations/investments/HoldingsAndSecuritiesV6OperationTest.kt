package com.nicholasklaene.monarchbridge.graphql.operations.investments

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class HoldingsAndSecuritiesV6OperationTest {
    // -- GetHoldingHistory ------------------------------------------------

    @Test
    fun `GetHoldingHistory parses every history field`() {
        val data =
            jsonNode(
                """
                {
                  "holdingHistory": {
                    "history": [
                      {"date": "2026-04-01", "quantity": 100.0, "value": 5000.0, "price": 50.0},
                      {"date": "2026-04-02", "quantity": 100.0, "value": 5050.0, "price": 50.5}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetHoldingHistory.parseOutput(data)
        assertThat(out.history).hasSize(2)
        val p = out.history[0]
        assertThat(p.date).isEqualTo(LocalDate.parse("2026-04-01"))
        assertThat(p.quantity).isEqualTo(100.0)
        assertThat(p.value).isEqualTo(5000.0)
        assertThat(p.price).isEqualTo(50.0)
    }

    @Test
    fun `GetHoldingHistory tolerates empty payload`() {
        val out = GetHoldingHistory.parseOutput(jsonNode("""{}"""))
        assertThat(out.history).isEmpty()
    }

    @Test
    fun `GetHoldingHistory variables include holdingId and optional dates`() {
        val vars =
            GetHoldingHistory.variables(
                GetHoldingHistory.Input(
                    holdingId = "h-1",
                    startDate = LocalDate.parse("2026-01-01"),
                    endDate = LocalDate.parse("2026-05-01"),
                ),
            )
        assertThat(vars["holdingId"]).isEqualTo("h-1")
        assertThat(vars["startDate"]).isEqualTo("2026-01-01")
        assertThat(vars["endDate"]).isEqualTo("2026-05-01")
    }

    @Test
    fun `GetHoldingHistory variables forward nulls for dates`() {
        val vars = GetHoldingHistory.variables(GetHoldingHistory.Input(holdingId = "h-2"))
        assertThat(vars["holdingId"]).isEqualTo("h-2")
        assertThat(vars["startDate"]).isNull()
        assertThat(vars["endDate"]).isNull()
    }

    // -- GetSecurityDetails ----------------------------------------------

    @Test
    fun `GetSecurityDetails parses every field`() {
        val data =
            jsonNode(
                """
                {
                  "security": {
                    "id": "s-1",
                    "ticker": "AAPL",
                    "name": "Apple Inc",
                    "type": "EQUITY",
                    "currentPrice": 180.0,
                    "closingPrice": 178.5,
                    "sector": "Technology",
                    "industry": "Consumer Electronics",
                    "marketCap": 2800000000000.0,
                    "peRatio": 32.1,
                    "dividendYield": 0.005
                  }
                }
                """.trimIndent(),
            )
        val out = GetSecurityDetails.parseOutput(data)
        val s = out.security
        assertThat(s.id).isEqualTo("s-1")
        assertThat(s.ticker).isEqualTo("AAPL")
        assertThat(s.name).isEqualTo("Apple Inc")
        assertThat(s.type).isEqualTo("EQUITY")
        assertThat(s.currentPrice).isEqualTo(180.0)
        assertThat(s.closingPrice).isEqualTo(178.5)
        assertThat(s.sector).isEqualTo("Technology")
        assertThat(s.industry).isEqualTo("Consumer Electronics")
        assertThat(s.marketCap).isEqualTo(2800000000000.0)
        assertThat(s.peRatio).isEqualTo(32.1)
        assertThat(s.dividendYield).isEqualTo(0.005)
    }

    @Test
    fun `GetSecurityDetails defaults id to empty when missing`() {
        val out = GetSecurityDetails.parseOutput(jsonNode("""{}"""))
        assertThat(out.security.id).isEqualTo("")
        assertThat(out.security.ticker).isNull()
    }

    @Test
    fun `GetSecurityDetails variables pass id verbatim`() {
        assertThat(GetSecurityDetails.variables(GetSecurityDetails.Input(id = "s-1"))).containsEntry("id", "s-1")
    }

    // -- GetSecurityDividends --------------------------------------------

    @Test
    fun `GetSecurityDividends parses dividend list`() {
        val data =
            jsonNode(
                """
                {
                  "securityDividends": {
                    "dividends": [
                      {"date": "2026-03-15", "amount": 0.24, "type": "regular"},
                      {"date": "2026-01-15", "amount": 1.0, "type": "special"}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetSecurityDividends.parseOutput(data)
        assertThat(out.dividends).hasSize(2)
        assertThat(out.dividends[0].date).isEqualTo(LocalDate.parse("2026-03-15"))
        assertThat(out.dividends[0].amount).isEqualTo(0.24)
        assertThat(out.dividends[0].type).isEqualTo("regular")
        assertThat(out.dividends[1].type).isEqualTo("special")
    }

    @Test
    fun `GetSecurityDividends returns empty list when missing`() {
        val out = GetSecurityDividends.parseOutput(jsonNode("""{}"""))
        assertThat(out.dividends).isEmpty()
    }

    @Test
    fun `GetSecurityDividends variables include id and dates`() {
        val vars =
            GetSecurityDividends.variables(
                GetSecurityDividends.Input(id = "s-1", startDate = LocalDate.parse("2026-01-01"), endDate = LocalDate.parse("2026-05-01")),
            )
        assertThat(vars["id"]).isEqualTo("s-1")
        assertThat(vars["startDate"]).isEqualTo("2026-01-01")
        assertThat(vars["endDate"]).isEqualTo("2026-05-01")
    }
}
