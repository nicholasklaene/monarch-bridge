package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class MerchantStatsOperationTest {
    @Test
    fun `GetMerchantStats parses every aggregate including first and last seen`() {
        val data =
            jsonNode(
                """
                {
                  "merchantStats": {
                    "merchantId":"m1",
                    "totalSpend":-1842.50,
                    "transactionCount":42,
                    "averageTransaction":-43.87,
                    "firstSeen":"2024-08-15",
                    "lastSeen":"2026-05-20",
                    "monthsActive":21
                  }
                }
                """.trimIndent(),
            )
        val out = GetMerchantStats.parseOutput(data)
        assertThat(out.stats.merchantId).isEqualTo("m1")
        assertThat(out.stats.totalSpend).isEqualTo(-1842.50)
        assertThat(out.stats.transactionCount).isEqualTo(42)
        assertThat(out.stats.averageTransaction).isEqualTo(-43.87)
        assertThat(out.stats.firstSeen).isEqualTo("2024-08-15")
        assertThat(out.stats.lastSeen).isEqualTo("2026-05-20")
        assertThat(out.stats.monthsActive).isEqualTo(21)
    }

    @Test
    fun `GetMerchantStats handles merchant with no activity in window (nullable totals)`() {
        // A merchant the user added manually but never had a transaction with — the stats
        // exist but every aggregate is null.
        val out =
            GetMerchantStats.parseOutput(jsonNode("""{"merchantStats":{"merchantId":"m-empty"}}"""))
        assertThat(out.stats.merchantId).isEqualTo("m-empty")
        assertThat(out.stats.totalSpend).isNull()
        assertThat(out.stats.transactionCount).isNull()
        assertThat(out.stats.monthsActive).isNull()
        assertThat(out.stats.firstSeen).isNull()
    }

    @Test
    fun `GetMerchantStats variables forward merchantId and stringify dates`() {
        val full =
            GetMerchantStats.variables(
                GetMerchantStats.Input(
                    merchantId = "m1",
                    startDate = LocalDate.parse("2026-01-01"),
                    endDate = LocalDate.parse("2026-12-31"),
                ),
            )
        assertThat(full["merchantId"]).isEqualTo("m1")
        assertThat(full["startDate"]).isEqualTo("2026-01-01")
        assertThat(full["endDate"]).isEqualTo("2026-12-31")
    }

    @Test
    fun `GetMerchantStats variables emit null dates when window unspecified`() {
        // No window = lifetime stats. We keep the keys in the map so the GraphQL variable
        // signature matches, but with null values that Monarch interprets as "no bound".
        val none = GetMerchantStats.variables(GetMerchantStats.Input(merchantId = "m1"))
        assertThat(none["merchantId"]).isEqualTo("m1")
        assertThat(none["startDate"]).isNull()
        assertThat(none["endDate"]).isNull()
    }
}
