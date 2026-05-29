package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TaxV7OperationTest {
    // -- GetTaxYearOverview -----------------------------------------------

    @Test
    fun `GetTaxYearOverview parses every field including per-schedule summaries`() {
        val data =
            jsonNode(
                """
                {
                  "taxYearOverview": {
                    "taxYear":2025,
                    "totalIncome":120000.0,
                    "totalDeductions":-22000.0,
                    "estimatedTax":18500.0,
                    "transactionCount":342,
                    "scheduleSummaries":[
                      {"schedule":"SCHEDULE_C","total":-12500.0,"lineItemCount":18},
                      {"schedule":"SCHEDULE_E","total":-9500.0,"lineItemCount":7}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetTaxYearOverview.parseOutput(data)
        assertThat(out.overview.taxYear).isEqualTo(2025)
        assertThat(out.overview.totalIncome).isEqualTo(120000.0)
        assertThat(out.overview.totalDeductions).isEqualTo(-22000.0)
        assertThat(out.overview.estimatedTax).isEqualTo(18500.0)
        assertThat(out.overview.transactionCount).isEqualTo(342)
        assertThat(out.overview.scheduleSummaries).hasSize(2)
        assertThat(out.overview.scheduleSummaries[0].schedule).isEqualTo("SCHEDULE_C")
        assertThat(out.overview.scheduleSummaries[0].total).isEqualTo(-12500.0)
        assertThat(out.overview.scheduleSummaries[0].lineItemCount).isEqualTo(18)
    }

    @Test
    fun `GetTaxYearOverview defaults taxYear to zero and schedule summaries to empty on bare payload`() {
        val out = GetTaxYearOverview.parseOutput(jsonNode("""{"taxYearOverview":{}}"""))
        assertThat(out.overview.taxYear).isZero
        assertThat(out.overview.totalIncome).isNull()
        assertThat(out.overview.transactionCount).isNull()
        assertThat(out.overview.scheduleSummaries).isEmpty()
    }

    @Test
    fun `GetTaxYearOverview variables forward taxYear at top level`() {
        val vars = GetTaxYearOverview.variables(GetTaxYearOverview.Input(taxYear = 2025))
        assertThat(vars).containsExactlyEntriesOf(mapOf("taxYear" to 2025))
    }

    // -- GetTaxBracketEstimates -------------------------------------------

    @Test
    fun `GetTaxBracketEstimates parses every rate, bound, and per-bracket row`() {
        val data =
            jsonNode(
                """
                {
                  "taxBracketEstimates": {
                    "taxYear":2025,
                    "filingStatus":"single",
                    "estimatedAgi":85000.0,
                    "marginalRate":0.22,
                    "effectiveRate":0.135,
                    "brackets":[
                      {"lowerBound":0.0,"upperBound":11600.0,"rate":0.10,"taxOwed":1160.0},
                      {"lowerBound":11600.0,"upperBound":47150.0,"rate":0.12,"taxOwed":4266.0},
                      {"lowerBound":47150.0,"upperBound":100525.0,"rate":0.22,"taxOwed":5037.0}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetTaxBracketEstimates.parseOutput(data)
        assertThat(out.estimates.taxYear).isEqualTo(2025)
        assertThat(out.estimates.filingStatus).isEqualTo("single")
        assertThat(out.estimates.estimatedAgi).isEqualTo(85000.0)
        assertThat(out.estimates.marginalRate).isEqualTo(0.22)
        assertThat(out.estimates.effectiveRate).isEqualTo(0.135)
        assertThat(out.estimates.brackets).hasSize(3)
        // The first bracket is the 10% bracket, fully consumed.
        assertThat(out.estimates.brackets[0].rate).isEqualTo(0.10)
        assertThat(out.estimates.brackets[0].taxOwed).isEqualTo(1160.0)
        // The third bracket is the marginal one.
        assertThat(out.estimates.brackets[2].rate).isEqualTo(0.22)
    }

    @Test
    fun `GetTaxBracketEstimates handles last bracket with null upperBound (open-ended top bracket)`() {
        // The top federal bracket has no upper bound — Monarch returns null.
        // We must preserve null rather than coerce.
        val data =
            jsonNode(
                """
                {"taxBracketEstimates":{"taxYear":2025,"brackets":[
                  {"lowerBound":609350.0,"upperBound":null,"rate":0.37,"taxOwed":0.0}
                ]}}
                """.trimIndent(),
            )
        val out = GetTaxBracketEstimates.parseOutput(data)
        assertThat(out.estimates.brackets).hasSize(1)
        assertThat(
            out.estimates.brackets
                .first()
                .upperBound,
        ).isNull()
        assertThat(
            out.estimates.brackets
                .first()
                .rate,
        ).isEqualTo(0.37)
    }

    @Test
    fun `GetTaxBracketEstimates variables include taxYear always and filingStatus only when set`() {
        val withStatus =
            GetTaxBracketEstimates.variables(
                GetTaxBracketEstimates.Input(taxYear = 2025, filingStatus = "married_jointly"),
            )
        assertThat(withStatus).containsEntry("taxYear", 2025)
        assertThat(withStatus).containsEntry("filingStatus", "married_jointly")

        val noStatus = GetTaxBracketEstimates.variables(GetTaxBracketEstimates.Input(taxYear = 2025))
        assertThat(noStatus).containsEntry("taxYear", 2025)
        // mapOfNotNull drops null values — confirm filingStatus is absent, not present-as-null.
        assertThat(noStatus).doesNotContainKey("filingStatus")
    }
}
