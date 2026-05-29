package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.SetCurrencyRequest
import com.nicholasklaene.monarchbridge.generated.model.SetFiscalYearRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CurrencyAndFiscalYearOperationTest {
    // -- GetCurrency ------------------------------------------------------

    @Test
    fun `GetCurrency parses currency, symbol, position`() {
        val data =
            jsonNode(
                """
                {"currencyPreferences":{"currency":"USD","symbol":"$","position":"before"}}
                """.trimIndent(),
            )
        val out = GetCurrency.parseOutput(data)
        assertThat(out.currency.currency).isEqualTo("USD")
        assertThat(out.currency.symbol).isEqualTo("$")
        assertThat(out.currency.position).isEqualTo("before")
    }

    @Test
    fun `GetCurrency tolerates missing fields`() {
        val out = GetCurrency.parseOutput(jsonNode("""{}"""))
        assertThat(out.currency.currency).isNull()
        assertThat(out.currency.symbol).isNull()
        assertThat(out.currency.position).isNull()
    }

    @Test
    fun `GetCurrency variables are empty`() {
        assertThat(GetCurrency.variables(Unit)).isEmpty()
    }

    // -- SetCurrency ------------------------------------------------------

    @Test
    fun `SetCurrency parses updated currency from mutation envelope`() {
        val data =
            jsonNode(
                """
                {"setCurrencyPreferences":{"currencyPreferences":
                  {"currency":"EUR","symbol":"€","position":"after"}}}
                """.trimIndent(),
            )
        val out = SetCurrency.parseOutput(data)
        assertThat(out.currency?.currency).isEqualTo("EUR")
        assertThat(out.currency?.symbol).isEqualTo("€")
        assertThat(out.currency?.position).isEqualTo("after")
    }

    @Test
    fun `SetCurrency tolerates empty mutation result`() {
        val out = SetCurrency.parseOutput(jsonNode("""{"setCurrencyPreferences":{}}"""))
        assertThat(out.currency?.currency).isNull()
    }

    @Test
    fun `SetCurrency variables include currency and drop null position`() {
        val vars = SetCurrency.variables(SetCurrency.Input(currency = "USD"))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("currency", "USD")
        assertThat(input).doesNotContainKey("position")
    }

    @Test
    fun `SetCurrency variables include position when provided`() {
        val vars = SetCurrency.variables(SetCurrency.Input(currency = "USD", position = "before"))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("currency", "USD").containsEntry("position", "before")
    }

    @Test
    fun `SetCurrency Input from copies request fields`() {
        val input = SetCurrency.Input.from(SetCurrencyRequest(currency = "EUR", position = "after"))
        assertThat(input.currency).isEqualTo("EUR")
        assertThat(input.position).isEqualTo("after")
    }

    // -- GetFiscalYear ----------------------------------------------------

    @Test
    fun `GetFiscalYear parses startMonth and startDay`() {
        val data =
            jsonNode("""{"fiscalYearPreferences":{"startMonth":7,"startDay":1}}""")
        val out = GetFiscalYear.parseOutput(data)
        assertThat(out.fiscalYear.startMonth).isEqualTo(7)
        assertThat(out.fiscalYear.startDay).isEqualTo(1)
    }

    @Test
    fun `GetFiscalYear tolerates missing fields`() {
        val out = GetFiscalYear.parseOutput(jsonNode("""{}"""))
        assertThat(out.fiscalYear.startMonth).isNull()
        assertThat(out.fiscalYear.startDay).isNull()
    }

    @Test
    fun `GetFiscalYear variables are empty`() {
        assertThat(GetFiscalYear.variables(Unit)).isEmpty()
    }

    // -- SetFiscalYear ----------------------------------------------------

    @Test
    fun `SetFiscalYear parses updated fiscal year from mutation envelope`() {
        val data =
            jsonNode(
                """
                {"setFiscalYearPreferences":{"fiscalYearPreferences":{"startMonth":1,"startDay":1}}}
                """.trimIndent(),
            )
        val out = SetFiscalYear.parseOutput(data)
        assertThat(out.fiscalYear?.startMonth).isEqualTo(1)
        assertThat(out.fiscalYear?.startDay).isEqualTo(1)
    }

    @Test
    fun `SetFiscalYear tolerates empty mutation result`() {
        val out = SetFiscalYear.parseOutput(jsonNode("""{"setFiscalYearPreferences":{}}"""))
        assertThat(out.fiscalYear?.startMonth).isNull()
    }

    @Test
    fun `SetFiscalYear variables require startMonth and omit null startDay`() {
        val vars = SetFiscalYear.variables(SetFiscalYear.Input(startMonth = 4))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("startMonth", 4)
        assertThat(input).doesNotContainKey("startDay")
    }

    @Test
    fun `SetFiscalYear variables include startDay when set`() {
        val vars = SetFiscalYear.variables(SetFiscalYear.Input(startMonth = 4, startDay = 15))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("startMonth", 4).containsEntry("startDay", 15)
    }

    @Test
    fun `SetFiscalYear Input from copies request fields`() {
        val input =
            SetFiscalYear.Input.from(SetFiscalYearRequest(startMonth = 7, startDay = 1))
        assertThat(input.startMonth).isEqualTo(7)
        assertThat(input.startDay).isEqualTo(1)
    }
}
