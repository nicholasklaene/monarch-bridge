package com.nicholasklaene.monarchbridge.graphql.operations.investments

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.loadFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class InvestmentsOperationTest {
    @Test
    fun `GetPortfolioAllocation parses buckets and total value`() {
        val data =
            jsonNode(
                """
                {
                  "portfolio": {
                    "allocationSimple": [
                      {"type": "equity", "typeDisplay": "Equity", "allocationPercent": 0.65, "totalValue": 65000.0},
                      {"type": "fixed_income", "typeDisplay": "Fixed Income", "allocationPercent": 0.35, "totalValue": 35000.0}
                    ],
                    "performance": {"totalValue": 100000.0}
                  }
                }
                """.trimIndent(),
            )
        val out = GetPortfolioAllocation.parseOutput(data)
        assertThat(out.buckets).hasSize(2)
        assertThat(out.buckets[0].type).isEqualTo("equity")
        assertThat(out.buckets[0].typeDisplay).isEqualTo("Equity")
        assertThat(out.buckets[0].allocationPercent).isEqualTo(0.65)
        assertThat(out.buckets[0].totalValue).isEqualTo(65000.0)
        assertThat(out.totalValue).isEqualTo(100000.0)
    }

    @Test
    fun `GetPortfolioAllocation handles missing performance`() {
        val data = jsonNode("""{"portfolio": {"allocationSimple": []}}""")
        val out = GetPortfolioAllocation.parseOutput(data)
        assertThat(out.buckets).isEmpty()
        assertThat(out.totalValue).isNull()
    }

    @Test
    fun `GetPortfolioAllocation variables omit accounts when empty list`() {
        val withAccounts = GetPortfolioAllocation.variables(GetPortfolioAllocation.Input(accountIds = listOf("a-1")))
        assertThat(withAccounts["porfolioInput"]).isEqualTo(mapOf("accounts" to listOf("a-1")))

        val withoutAccounts = GetPortfolioAllocation.variables(GetPortfolioAllocation.Input(accountIds = emptyList()))
        assertThat(withoutAccounts["porfolioInput"]).isNull()

        val withNullAccounts = GetPortfolioAllocation.variables(GetPortfolioAllocation.Input(accountIds = null))
        assertThat(withNullAccounts["porfolioInput"]).isNull()
    }

    @Test
    fun `GetPortfolioAllocationByHoldings parses bucket list`() {
        val data =
            jsonNode(
                """
                {
                  "portfolio": {
                    "allocationSimple": [
                      {"type": "VTI", "typeDisplay": "Vanguard Total Stock", "allocationPercent": 0.5, "totalValue": 50000.0}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetPortfolioAllocationByHoldings.parseOutput(data)
        assertThat(out.buckets).hasSize(1)
        assertThat(out.buckets[0].type).isEqualTo("VTI")
    }

    @Test
    fun `GetPortfolioAllocationByAccount parses bucket list`() {
        val data =
            jsonNode(
                """
                {
                  "portfolio": {
                    "allocationSimple": [
                      {"type": "acc-1", "typeDisplay": "Fidelity Brokerage", "allocationPercent": 1.0, "totalValue": 250000.0}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetPortfolioAllocationByAccount.parseOutput(data)
        assertThat(out.buckets).hasSize(1)
        assertThat(out.buckets[0].totalValue).isEqualTo(250000.0)
    }

    @Test
    fun `GetPortfolioAllocationHoldingsDetail parses holdings and total count`() {
        val data = loadFixture("investments/holdings-detail")
        val out = GetPortfolioAllocationHoldingsDetail.parseOutput(data)
        assertThat(out.holdings).hasSize(1)
        val h = out.holdings[0]
        assertThat(h.securityName).isEqualTo("Apple Inc.")
        assertThat(h.ticker).isEqualTo("AAPL")
        assertThat(h.holdingIds).containsExactly("h-1", "h-2")
        assertThat(h.quantity).isEqualTo(10.0)
        assertThat(out.totalCount).isEqualTo(42)
    }

    @Test
    fun `GetPortfolioAllocationHoldingsDetail forwards variables`() {
        val vars =
            GetPortfolioAllocationHoldingsDetail.variables(
                GetPortfolioAllocationHoldingsDetail.Input(
                    classificationField = "SECURITY_TYPE",
                    classificationValue = "equity",
                    accountIds = listOf("a-1"),
                    limit = 50,
                    offset = 10,
                ),
            )
        assertThat(vars["classificationField"]).isEqualTo("SECURITY_TYPE")
        assertThat(vars["classificationValue"]).isEqualTo("equity")
        assertThat(vars["limit"]).isEqualTo(50)
        assertThat(vars["offset"]).isEqualTo(10)
        assertThat(vars["porfolioInput"]).isEqualTo(mapOf("accounts" to listOf("a-1")))
    }

    @Test
    fun `GetSecurityHistoricalPerformance parses security and chart points`() {
        val data =
            jsonNode(
                """
                {
                  "securityHistoricalPerformance": {
                    "security": {
                      "id": "sec-1",
                      "currentPrice": 180.5,
                      "closingPrice": 179.9,
                      "currentPriceUpdatedAt": "2026-05-26T15:30:00Z"
                    },
                    "historicalChart": [
                      {"date": "2026-05-24", "returnPercent": 0.0, "value": 170.0},
                      {"date": "2026-05-25", "returnPercent": 0.05, "value": 178.5},
                      {"date": "2026-05-26", "returnPercent": 0.06, "value": 180.2}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetSecurityHistoricalPerformance.parseOutput(data)
        assertThat(out.security.id).isEqualTo("sec-1")
        assertThat(out.security.currentPrice).isEqualTo(180.5)
        assertThat(out.chart).hasSize(3)
        assertThat(out.chart[0].date).isEqualTo(LocalDate.of(2026, 5, 24))
        assertThat(out.chart[1].returnPercent).isEqualTo(0.05)
        assertThat(out.chart[2].value).isEqualTo(180.2)
    }

    @Test
    fun `GetSecurityHistoricalPerformance variables wrap input under input key`() {
        val vars =
            GetSecurityHistoricalPerformance.variables(
                GetSecurityHistoricalPerformance.Input(
                    securityId = "sec-2",
                    startDate = LocalDate.of(2026, 1, 1),
                    endDate = LocalDate.of(2026, 5, 1),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val nested = vars["input"] as Map<String, Any?>
        assertThat(nested["securityId"]).isEqualTo("sec-2")
        assertThat(nested["startDate"]).isEqualTo("2026-01-01")
        assertThat(nested["endDate"]).isEqualTo("2026-05-01")

        val noDates =
            GetSecurityHistoricalPerformance.variables(
                GetSecurityHistoricalPerformance.Input(securityId = "sec-3"),
            )

        @Suppress("UNCHECKED_CAST")
        val nested2 = noDates["input"] as Map<String, Any?>
        assertThat(nested2["securityId"]).isEqualTo("sec-3")
        assertThat(nested2).doesNotContainKeys("startDate", "endDate")
    }

    @Test
    fun `GetPortfolioAllocationByAccount variables wire portfolioInput and limit`() {
        val withAll =
            GetPortfolioAllocationByAccount.variables(
                GetPortfolioAllocationByAccount.Input(accountIds = listOf("a-1", "a-2"), limit = 25),
            )
        assertThat(withAll["porfolioInput"]).isEqualTo(mapOf("accounts" to listOf("a-1", "a-2")))
        assertThat(withAll["limit"]).isEqualTo(25)

        val withoutAccounts =
            GetPortfolioAllocationByAccount.variables(
                GetPortfolioAllocationByAccount.Input(accountIds = emptyList(), limit = null),
            )
        assertThat(withoutAccounts["porfolioInput"]).isNull()
        assertThat(withoutAccounts["limit"]).isNull()

        val withNullAccounts =
            GetPortfolioAllocationByAccount.variables(
                GetPortfolioAllocationByAccount.Input(accountIds = null),
            )
        assertThat(withNullAccounts["porfolioInput"]).isNull()
    }

    @Test
    fun `GetPortfolioAllocationByHoldings variables wire portfolioInput and limit`() {
        val withAll =
            GetPortfolioAllocationByHoldings.variables(
                GetPortfolioAllocationByHoldings.Input(accountIds = listOf("a-1"), limit = 100),
            )
        assertThat(withAll["porfolioInput"]).isEqualTo(mapOf("accounts" to listOf("a-1")))
        assertThat(withAll["limit"]).isEqualTo(100)

        val withoutAccounts =
            GetPortfolioAllocationByHoldings.variables(
                GetPortfolioAllocationByHoldings.Input(accountIds = emptyList(), limit = null),
            )
        assertThat(withoutAccounts["porfolioInput"]).isNull()
        assertThat(withoutAccounts["limit"]).isNull()

        val withNullAccounts =
            GetPortfolioAllocationByHoldings.variables(
                GetPortfolioAllocationByHoldings.Input(accountIds = null),
            )
        assertThat(withNullAccounts["porfolioInput"]).isNull()
    }

    @Test
    fun `GetPortfolioAllocation forwards classificationField alongside accounts`() {
        val vars =
            GetPortfolioAllocation.variables(
                GetPortfolioAllocation.Input(
                    accountIds = listOf("a-1"),
                    classificationField = "SECURITY_TYPE",
                ),
            )
        assertThat(vars["classificationField"]).isEqualTo("SECURITY_TYPE")
        assertThat(vars["porfolioInput"]).isEqualTo(mapOf("accounts" to listOf("a-1")))
    }
}
