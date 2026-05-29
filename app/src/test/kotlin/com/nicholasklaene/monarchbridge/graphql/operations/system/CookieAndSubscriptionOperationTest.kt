package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateCookiePreferencesRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CookieAndSubscriptionOperationTest {
    // -- GetCookiePreferences ---------------------------------------------

    @Test
    fun `GetCookiePreferences parses every consent and the updatedAt timestamp`() {
        val data =
            jsonNode(
                """
                {"cookiePreferences":{"analytics":true,"marketing":false,
                 "functional":true,"updatedAt":"2026-05-26T10:00:00Z"}}
                """.trimIndent(),
            )
        val out = GetCookiePreferences.parseOutput(data)
        assertThat(out.preferences.analytics).isTrue
        assertThat(out.preferences.marketing).isFalse
        assertThat(out.preferences.functional).isTrue
        assertThat(out.preferences.updatedAt).isEqualTo("2026-05-26T10:00:00Z")
    }

    @Test
    fun `GetCookiePreferences leaves every consent null when never set`() {
        // Pre-consent users have no row — Monarch returns nulls, not coerced false.
        // The UI then knows to show the banner instead of assuming any setting.
        val out = GetCookiePreferences.parseOutput(jsonNode("""{"cookiePreferences":{}}"""))
        assertThat(out.preferences.analytics).isNull()
        assertThat(out.preferences.marketing).isNull()
        assertThat(out.preferences.functional).isNull()
        assertThat(out.preferences.updatedAt).isNull()
    }

    @Test
    fun `GetCookiePreferences variables are empty`() {
        assertThat(GetCookiePreferences.variables(Unit)).isEmpty()
    }

    // -- UpdateCookiePreferences ------------------------------------------

    @Test
    fun `UpdateCookiePreferences parses updated consents from the mutation envelope`() {
        val data =
            jsonNode(
                """
                {"updateCookiePreferences":{"cookiePreferences":
                  {"analytics":false,"marketing":false,"functional":true,
                   "updatedAt":"2026-05-26T12:00:00Z"}}}
                """.trimIndent(),
            )
        val out = UpdateCookiePreferences.parseOutput(data)
        assertThat(out.preferences.analytics).isFalse
        assertThat(out.preferences.marketing).isFalse
        assertThat(out.preferences.functional).isTrue
        assertThat(out.preferences.updatedAt).isEqualTo("2026-05-26T12:00:00Z")
    }

    @Test
    fun `UpdateCookiePreferences variables drop unset fields so PATCH stays sparse`() {
        // Only `analytics` is being toggled here — `marketing` and `functional` should NOT
        // be sent (Monarch's PATCH treats absent = leave-untouched, present-null = clear).
        val justAnalytics =
            UpdateCookiePreferences.variables(UpdateCookiePreferences.Input(analytics = true))

        @Suppress("UNCHECKED_CAST")
        val input = justAnalytics["input"] as Map<String, Any?>
        assertThat(input).containsEntry("analytics", true)
        assertThat(input).doesNotContainKeys("marketing", "functional")

        // All-fields path: every key present.
        val all =
            UpdateCookiePreferences.variables(
                UpdateCookiePreferences.Input(analytics = true, marketing = false, functional = true),
            )

        @Suppress("UNCHECKED_CAST")
        val allInput = all["input"] as Map<String, Any?>
        assertThat(allInput)
            .containsEntry("analytics", true)
            .containsEntry("marketing", false)
            .containsEntry("functional", true)
    }

    @Test
    fun `UpdateCookiePreferences Input from copies each request field`() {
        val req =
            UpdateCookiePreferencesRequest(analytics = true, marketing = false, functional = true)
        val input = UpdateCookiePreferences.Input.from(req)
        assertThat(input.analytics).isTrue
        assertThat(input.marketing).isFalse
        assertThat(input.functional).isTrue
    }

    // -- GetSubscriptionInvoices ------------------------------------------

    @Test
    fun `GetSubscriptionInvoices parses each invoice with status and pdf url`() {
        val data =
            jsonNode(
                """
                {
                  "subscriptionInvoices": [
                    {"id":"inv-1","date":"2026-05-01","amount":99.0,"status":"paid",
                     "pdfUrl":"https://example.com/inv-1.pdf",
                     "periodStart":"2026-05-01","periodEnd":"2026-05-31"},
                    {"id":"inv-2","date":"2026-04-01","amount":99.0,"status":"refunded",
                     "pdfUrl":null,"periodStart":"2026-04-01","periodEnd":"2026-04-30"}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetSubscriptionInvoices.parseOutput(data)
        assertThat(out.invoices).hasSize(2)
        assertThat(out.invoices[0].id).isEqualTo("inv-1")
        assertThat(out.invoices[0].status).isEqualTo("paid")
        assertThat(out.invoices[0].pdfUrl).isEqualTo("https://example.com/inv-1.pdf")
        assertThat(out.invoices[1].status).isEqualTo("refunded")
        assertThat(out.invoices[1].pdfUrl).isNull()
    }

    @Test
    fun `GetSubscriptionInvoices returns empty list for new accounts`() {
        val out = GetSubscriptionInvoices.parseOutput(jsonNode("""{"subscriptionInvoices":[]}"""))
        assertThat(out.invoices).isEmpty()
    }

    @Test
    fun `GetSubscriptionInvoices variables are empty`() {
        assertThat(GetSubscriptionInvoices.variables(Unit)).isEmpty()
    }
}
