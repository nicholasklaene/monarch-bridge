package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateMerchantRecurrenceRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RecurringOperationTest {
    // -- GetRecurringTransactions -----------------------------------------

    @Test
    fun `GetRecurringTransactions parses items list`() {
        val data =
            jsonNode(
                """
                {
                  "recurringTransactionItems": [
                    {
                      "stream": {"id": "s1", "frequency": "monthly"},
                      "date": "2026-05-15",
                      "amount": -12.99,
                      "merchant": {"name": "Spotify"}
                    },
                    {
                      "stream": {"id": "s2", "frequency": "biweekly"},
                      "date": "2026-05-20",
                      "amount": 2500.0,
                      "merchant": {"name": "Employer"}
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetRecurringTransactions.parseOutput(data)
        assertThat(out.items).hasSize(2)
        assertThat(out.items[0]["date"]).isEqualTo("2026-05-15")
        assertThat(out.items[0]["amount"]).isEqualTo(-12.99)
        @Suppress("UNCHECKED_CAST")
        val merchant0 = out.items[0]["merchant"] as Map<String, Any>
        assertThat(merchant0["name"]).isEqualTo("Spotify")
        @Suppress("UNCHECKED_CAST")
        val stream1 = out.items[1]["stream"] as Map<String, Any>
        assertThat(stream1["frequency"]).isEqualTo("biweekly")
    }

    @Test
    fun `GetRecurringTransactions returns empty list when items missing`() {
        val data = jsonNode("""{}""")
        val out = GetRecurringTransactions.parseOutput(data)
        assertThat(out.items).isNotNull
        assertThat(out.items).isEmpty()
        assertThat(out.items).isInstanceOf(List::class.java)
    }

    @Test
    fun `GetRecurringTransactions returns empty list when items is explicitly empty`() {
        val data = jsonNode("""{"recurringTransactionItems": []}""")
        val out = GetRecurringTransactions.parseOutput(data)
        assertThat(out.items).isEmpty()
    }

    // -- UpdateMerchantRecurrence -----------------------------------------

    @Test
    fun `UpdateMerchantRecurrence parses merchant map with recurrence stream`() {
        val data =
            jsonNode(
                """
                {
                  "updateMerchant": {
                    "merchant": {
                      "id": "m-42",
                      "name": "Netflix",
                      "recurringTransactionStream": {
                        "id": "rts-1",
                        "frequency": "monthly",
                        "isActive": true,
                        "amount": -15.49,
                        "baseDate": "2026-05-01"
                      }
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateMerchantRecurrence.parseOutput(data)
        assertThat(out.merchant).isNotNull
        assertThat(out.merchant?.get("id")).isEqualTo("m-42")
        assertThat(out.merchant?.get("name")).isEqualTo("Netflix")
        @Suppress("UNCHECKED_CAST")
        val stream = out.merchant?.get("recurringTransactionStream") as Map<String, Any>
        assertThat(stream["frequency"]).isEqualTo("monthly")
        assertThat(stream["amount"]).isEqualTo(-15.49)
    }

    @Test
    fun `UpdateMerchantRecurrence returns null merchant when missing`() {
        val data = jsonNode("""{"updateMerchant": {}}""")
        val out = UpdateMerchantRecurrence.parseOutput(data)
        assertThat(out.merchant).isNull()
        assertThat(out).isInstanceOf(
            com.nicholasklaene.monarchbridge.generated.model.UpdateMerchantRecurrenceResponseData::class.java,
        )
    }

    @Test
    fun `UpdateMerchantRecurrence returns null merchant when explicitly null`() {
        val data = jsonNode("""{"updateMerchant": {"merchant": null}}""")
        val out = UpdateMerchantRecurrence.parseOutput(data)
        assertThat(out.merchant).isNull()
    }

    @Test
    fun `UpdateMerchantRecurrence returns null merchant when entire mutation key missing`() {
        val data = jsonNode("""{}""")
        val out = UpdateMerchantRecurrence.parseOutput(data)
        assertThat(out.merchant).isNull()
    }

    // -- GetAggregatedRecurringItems --------------------------------------

    @Test
    fun `GetAggregatedRecurringItems parses aggregate as opaque map with groups and aggregatedSummary`() {
        val data =
            jsonNode(
                """
                {
                  "aggregatedRecurringItems": {
                    "groups": [
                      {
                        "groupBy": {"status": "completed"},
                        "results": [
                          {
                            "stream": {"id": "s-1", "frequency": "monthly", "name": "Netflix"},
                            "date": "2026-05-10",
                            "amount": -15.49,
                            "isCompleted": true
                          }
                        ],
                        "summary": {
                          "expense": {"total": -150.00},
                          "creditCard": {"total": 0.0},
                          "income": {"total": 5000.0}
                        }
                      }
                    ],
                    "aggregatedSummary": {
                      "expense": {"completed": -150.0, "remaining": 0.0, "total": -150.0, "count": 1},
                      "creditCard": {"completed": 0.0, "remaining": 0.0, "total": 0.0, "count": 0},
                      "income": {"completed": 5000.0, "remaining": 0.0, "total": 5000.0}
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = GetAggregatedRecurringItems.parseOutput(data)
        assertThat(out.aggregate).isNotNull
        @Suppress("UNCHECKED_CAST")
        val groups = out.aggregate!!["groups"] as List<Map<String, Any>>
        assertThat(groups).hasSize(1)
        @Suppress("UNCHECKED_CAST")
        val groupBy = groups[0]["groupBy"] as Map<String, Any>
        assertThat(groupBy["status"]).isEqualTo("completed")

        @Suppress("UNCHECKED_CAST")
        val aggregatedSummary = out.aggregate["aggregatedSummary"] as Map<String, Any>

        @Suppress("UNCHECKED_CAST")
        val income = aggregatedSummary["income"] as Map<String, Any>
        assertThat(income["total"]).isEqualTo(5000.0)
    }

    @Test
    fun `GetAggregatedRecurringItems returns null aggregate when aggregatedRecurringItems missing or null`() {
        val missing = GetAggregatedRecurringItems.parseOutput(jsonNode("""{}"""))
        assertThat(missing.aggregate).isNull()

        val explicitNull =
            GetAggregatedRecurringItems.parseOutput(jsonNode("""{"aggregatedRecurringItems": null}"""))
        assertThat(explicitNull.aggregate).isNull()
    }

    @Test
    fun `GetAggregatedRecurringItems variables pass startDate, endDate, and null filters`() {
        val vars =
            GetAggregatedRecurringItems.variables(
                GetAggregatedRecurringItems.Input(startDate = "2026-05-01", endDate = "2026-05-31"),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-05-01")
        assertThat(vars["endDate"]).isEqualTo("2026-05-31")
        assertThat(vars).containsEntry("filters", null)
    }

    // -- GetAllRecurringTransactionItems ----------------------------------

    @Test
    fun `GetAllRecurringTransactionItems parses recurringTransactionStreams items as list of maps`() {
        val data =
            jsonNode(
                """
                {
                  "recurringTransactionStreams": [
                    {
                      "stream": {"id": "s-1", "frequency": "monthly", "name": "Netflix"},
                      "nextForecastedTransaction": {"date": "2026-06-10", "amount": -15.49},
                      "category": {"id": "c-1", "name": "Subscriptions"},
                      "account": {"id": "a-1", "displayName": "Checking"}
                    },
                    {
                      "stream": {"id": "s-2", "frequency": "biweekly"},
                      "nextForecastedTransaction": null,
                      "category": null,
                      "account": null
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetAllRecurringTransactionItems.parseOutput(data)
        assertThat(out.items).hasSize(2)
        @Suppress("UNCHECKED_CAST")
        val firstStream = out.items[0]["stream"] as Map<String, Any>
        assertThat(firstStream["id"]).isEqualTo("s-1")
        assertThat(firstStream["frequency"]).isEqualTo("monthly")
        @Suppress("UNCHECKED_CAST")
        val next = out.items[0]["nextForecastedTransaction"] as Map<String, Any>
        assertThat(next["date"]).isEqualTo("2026-06-10")
        assertThat(next["amount"]).isEqualTo(-15.49)
    }

    @Test
    fun `GetAllRecurringTransactionItems returns empty list when recurringTransactionStreams missing`() {
        val out = GetAllRecurringTransactionItems.parseOutput(jsonNode("""{}"""))
        assertThat(out.items).isEmpty()
    }

    @Test
    fun `GetAllRecurringTransactionItems variables forward null filters and the two flags`() {
        val withFlags =
            GetAllRecurringTransactionItems.variables(
                GetAllRecurringTransactionItems.Input(includeLiabilities = true, includePending = false),
            )
        assertThat(withFlags).containsEntry("filters", null)
        assertThat(withFlags["includeLiabilities"]).isEqualTo(true)
        assertThat(withFlags["includePending"]).isEqualTo(false)

        val bare =
            GetAllRecurringTransactionItems.variables(GetAllRecurringTransactionItems.Input())
        assertThat(bare).containsEntry("filters", null)
        assertThat(bare).containsEntry("includeLiabilities", null)
        assertThat(bare).containsEntry("includePending", null)
    }

    // -- GetRecurringStreams ----------------------------------------------

    @Test
    fun `GetRecurringStreams parses streams as list of maps preserving nested account refs`() {
        val data =
            jsonNode(
                """
                {
                  "recurringTransactionStreams": [
                    {
                      "stream": {
                        "id": "s-1",
                        "reviewStatus": "approved",
                        "frequency": "monthly",
                        "amount": -15.49,
                        "baseDate": "2026-05-01",
                        "dayOfTheMonth": 1,
                        "isApproximate": false,
                        "name": "Netflix",
                        "logoUrl": null,
                        "recurringType": "merchant",
                        "merchant": {"id": "m-1"},
                        "creditReportLiabilityAccount": null
                      }
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetRecurringStreams.parseOutput(data)
        assertThat(out.streams).hasSize(1)
        @Suppress("UNCHECKED_CAST")
        val stream = out.streams[0]["stream"] as Map<String, Any?>
        assertThat(stream["id"]).isEqualTo("s-1")
        assertThat(stream["frequency"]).isEqualTo("monthly")
        assertThat(stream["amount"]).isEqualTo(-15.49)
        assertThat(stream["dayOfTheMonth"]).isEqualTo(1)
        assertThat(stream["recurringType"]).isEqualTo("merchant")
        assertThat(stream["creditReportLiabilityAccount"]).isNull()
    }

    @Test
    fun `GetRecurringStreams returns empty list when recurringTransactionStreams missing`() {
        val out = GetRecurringStreams.parseOutput(jsonNode("""{}"""))
        assertThat(out.streams).isEmpty()
    }

    @Test
    fun `GetRecurringStreams variables forward includeLiabilities verbatim`() {
        val withFlag = GetRecurringStreams.variables(GetRecurringStreams.Input(includeLiabilities = true))
        assertThat(withFlag).containsEntry("includeLiabilities", true)

        val bare = GetRecurringStreams.variables(GetRecurringStreams.Input())
        assertThat(bare).containsEntry("includeLiabilities", null)
    }

    // -- MarkStreamAsNotRecurring -----------------------------------------

    @Test
    fun `MarkStreamAsNotRecurring surfaces markStreamAsNotRecurring success`() {
        val data = jsonNode("""{"markStreamAsNotRecurring": {"success": true, "errors": null}}""")
        val out = MarkStreamAsNotRecurring.parseOutput(data)
        assertThat(out.success).isTrue()
    }

    @Test
    fun `MarkStreamAsNotRecurring defaults to success false when payload missing or false`() {
        val explicitFalse =
            MarkStreamAsNotRecurring.parseOutput(jsonNode("""{"markStreamAsNotRecurring": {"success": false}}"""))
        assertThat(explicitFalse.success).isFalse()

        val missingFlag = MarkStreamAsNotRecurring.parseOutput(jsonNode("""{"markStreamAsNotRecurring": {}}"""))
        assertThat(missingFlag.success).isFalse()

        val missingMutation = MarkStreamAsNotRecurring.parseOutput(jsonNode("""{}"""))
        assertThat(missingMutation.success).isFalse()
    }

    @Test
    fun `MarkStreamAsNotRecurring variables forward streamId verbatim`() {
        val vars = MarkStreamAsNotRecurring.variables(MarkStreamAsNotRecurring.Input(streamId = "s-9"))
        assertThat(vars).containsEntry("streamId", "s-9")
        assertThat(vars).hasSize(1)
    }

    // -- GetRecurringTransactions variables ---------------------------------

    @Test
    fun `GetRecurringTransactions variables forward date range and null filters`() {
        val vars =
            GetRecurringTransactions.variables(
                GetRecurringTransactions.Input(startDate = "2026-05-01", endDate = "2026-05-31"),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-05-01")
        assertThat(vars["endDate"]).isEqualTo("2026-05-31")
        assertThat(vars["filters"]).isNull()
    }

    // -- UpdateMerchantRecurrence variables + Input.from --------------------

    @Test
    fun `UpdateMerchantRecurrence Input from copies every optional patch field`() {
        val req =
            UpdateMerchantRecurrenceRequest(
                name = "Netflix",
                isRecurring = true,
                frequency = "monthly",
                baseDate = "2026-05-01",
                amount = -15.99,
                isActive = true,
            )
        val input = UpdateMerchantRecurrence.Input.from(merchantId = "m-1", req = req)
        assertThat(input.merchantId).isEqualTo("m-1")
        assertThat(input.name).isEqualTo("Netflix")
        assertThat(input.isRecurring).isTrue
        assertThat(input.frequency).isEqualTo("monthly")
        assertThat(input.baseDate).isEqualTo("2026-05-01")
        assertThat(input.amount).isEqualTo(-15.99)
        assertThat(input.isActive).isTrue
    }

    @Test
    fun `UpdateMerchantRecurrence variables emit only non-null recurrence fields`() {
        val full =
            UpdateMerchantRecurrence.variables(
                UpdateMerchantRecurrence.Input(
                    merchantId = "m-1",
                    name = "Netflix",
                    isRecurring = true,
                    frequency = "monthly",
                    baseDate = "2026-05-01",
                    amount = -15.99,
                    isActive = true,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = full["input"] as Map<String, Any?>
        assertThat(inner["merchantId"]).isEqualTo("m-1")
        assertThat(inner["name"]).isEqualTo("Netflix")

        @Suppress("UNCHECKED_CAST")
        val recurrence = inner["recurringTransactionStream"] as Map<String, Any?>
        assertThat(recurrence).containsKeys("isRecurring", "frequency", "baseDate", "amount", "isActive")
        assertThat(recurrence["amount"]).isEqualTo(-15.99)
    }

    @Test
    fun `UpdateMerchantRecurrence variables skip recurringTransactionStream when no patch fields set`() {
        val nameOnly =
            UpdateMerchantRecurrence.variables(
                UpdateMerchantRecurrence.Input(merchantId = "m-1", name = "Netflix"),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = nameOnly["input"] as Map<String, Any?>
        assertThat(inner["merchantId"]).isEqualTo("m-1")
        assertThat(inner["name"]).isEqualTo("Netflix")
        assertThat(inner).doesNotContainKey("recurringTransactionStream")
    }

    // -- GetRecurringDashboard --------------------------------------------

    @Test
    fun `GetRecurringDashboard parses upcoming items and remainingDueAmount`() {
        val data =
            com.nicholasklaene.monarchbridge.controllers
                .TestFixtures
                .jsonNode(
                    """
                    {
                      "recurringRemainingDue": {"amount": 234.99},
                      "recurringTransactionItems": [
                        {
                          "date": "2026-05-15",
                          "amount": -15.99,
                          "isPast": false,
                          "stream": {
                            "id": "s-1",
                            "name": "Netflix",
                            "frequency": "monthly",
                            "logoUrl": "https://cdn/netflix.png",
                            "merchant": {"id": "m-netflix"}
                          },
                          "account": {"id": "a-1"}
                        },
                        {
                          "date": "2026-05-22",
                          "amount": -9.99,
                          "isPast": true,
                          "stream": {"id": "s-2", "name": "Spotify"}
                        }
                      ]
                    }
                    """.trimIndent(),
                )
        val out = GetRecurringDashboard.parseOutput(data)
        assertThat(out.remainingDueAmount).isEqualTo(234.99)
        assertThat(out.items).hasSize(2)
        val first = out.items[0]
        assertThat(first.date).isEqualTo(java.time.LocalDate.of(2026, 5, 15))
        assertThat(first.amount).isEqualTo(-15.99)
        assertThat(first.isPast).isFalse
        assertThat(first.streamId).isEqualTo("s-1")
        assertThat(first.streamName).isEqualTo("Netflix")
        assertThat(first.frequency).isEqualTo("monthly")
        assertThat(first.logoUrl).isEqualTo("https://cdn/netflix.png")
        assertThat(first.merchantId).isEqualTo("m-netflix")
        assertThat(first.accountId).isEqualTo("a-1")
        assertThat(out.items[1].isPast).isTrue
        assertThat(out.items[1].streamName).isEqualTo("Spotify")
    }

    @Test
    fun `GetRecurringDashboard skips entries with blank date`() {
        val data =
            com.nicholasklaene.monarchbridge.controllers
                .TestFixtures
                .jsonNode(
                    """
                    {
                      "recurringTransactionItems": [
                        {"date": "", "amount": -15.99},
                        {"date": "2026-05-22", "amount": -9.99}
                      ]
                    }
                    """.trimIndent(),
                )
        val out = GetRecurringDashboard.parseOutput(data)
        assertThat(out.items).hasSize(1)
        assertThat(out.items[0].date).isEqualTo(java.time.LocalDate.of(2026, 5, 22))
    }

    @Test
    fun `GetRecurringDashboard defaults to empty items when payload empty`() {
        val out =
            GetRecurringDashboard.parseOutput(
                com.nicholasklaene.monarchbridge.controllers
                    .TestFixtures
                    .jsonNode("""{}"""),
            )
        assertThat(out.items).isEmpty()
        assertThat(out.remainingDueAmount).isNull()
    }

    @Test
    fun `GetRecurringDashboard variables forward date range and includeLiabilities`() {
        val withFlag =
            GetRecurringDashboard.variables(
                GetRecurringDashboard.Input(
                    startDate = java.time.LocalDate.of(2026, 5, 1),
                    endDate = java.time.LocalDate.of(2026, 5, 31),
                    includeLiabilities = true,
                ),
            )
        assertThat(withFlag["startDate"]).isEqualTo("2026-05-01")
        assertThat(withFlag["endDate"]).isEqualTo("2026-05-31")
        assertThat(withFlag["includeLiabilities"]).isEqualTo(true)

        val noFlag =
            GetRecurringDashboard.variables(
                GetRecurringDashboard.Input(
                    startDate = java.time.LocalDate.of(2026, 5, 1),
                    endDate = java.time.LocalDate.of(2026, 5, 31),
                    includeLiabilities = null,
                ),
            )
        assertThat(noFlag["includeLiabilities"]).isNull()
    }
}
