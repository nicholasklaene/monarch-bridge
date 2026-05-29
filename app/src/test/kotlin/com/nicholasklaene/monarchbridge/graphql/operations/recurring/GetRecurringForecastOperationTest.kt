package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class GetRecurringForecastOperationTest {
    @Test
    fun `parses forecast entries with optional fields`() {
        val data =
            jsonNode(
                """
                {
                  "recurringTransactionForecast": {
                    "forecast": [
                      {"date": "2026-06-01", "amount": -15.99, "merchantName": "Netflix", "streamId": "s-1"},
                      {"date": "2026-06-15", "amount": null, "merchantName": null, "streamId": null}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetRecurringForecast.parseOutput(data)
        assertThat(out.forecast).hasSize(2)
        assertThat(out.forecast[0].date).isEqualTo(LocalDate.parse("2026-06-01"))
        assertThat(out.forecast[0].amount).isEqualTo(-15.99)
        assertThat(out.forecast[0].merchantName).isEqualTo("Netflix")
        assertThat(out.forecast[0].streamId).isEqualTo("s-1")
        assertThat(out.forecast[1].date).isEqualTo(LocalDate.parse("2026-06-15"))
        assertThat(out.forecast[1].amount).isNull()
        assertThat(out.forecast[1].merchantName).isNull()
        assertThat(out.forecast[1].streamId).isNull()
    }

    @Test
    fun `returns empty list when forecast field missing`() {
        val out = GetRecurringForecast.parseOutput(jsonNode("""{}"""))
        assertThat(out.forecast).isEmpty()
    }

    @Test
    fun `variables include both dates when provided`() {
        val vars =
            GetRecurringForecast.variables(
                GetRecurringForecast.Input(
                    startDate = LocalDate.parse("2026-06-01"),
                    endDate = LocalDate.parse("2026-06-30"),
                ),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-06-01")
        assertThat(vars["endDate"]).isEqualTo("2026-06-30")
    }

    @Test
    fun `variables forward nulls when dates absent`() {
        val vars = GetRecurringForecast.variables(GetRecurringForecast.Input())
        assertThat(vars["startDate"]).isNull()
        assertThat(vars["endDate"]).isNull()
    }

    @Test
    fun `operation name matches the bundle`() {
        assertThat(GetRecurringForecast.operationName).isEqualTo("Web_GetRecurringForecast")
    }
}
