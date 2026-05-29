package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.loadFixture
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRequest
import com.nicholasklaene.monarchbridge.generated.model.SetTransactionTagsRequest
import com.nicholasklaene.monarchbridge.generated.model.Split
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionSplitsRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class TransactionOperationTest {
    // -- GetTransactions ---------------------------------------------------

    @Test
    fun `GetTransactions parses totalCount and full Transaction tree`() {
        val data = loadFixture("getTransactions/full")
        val out = GetTransactions.parseOutput(data)
        assertThat(out.totalCount).isEqualTo(42)
        assertThat(out.results).hasSize(2)
        val tx = out.results.first()
        assertThat(tx.id).isEqualTo("t-1")
        assertThat(tx.date).isEqualTo(LocalDate.parse("2026-05-25"))
        assertThat(tx.amount).isEqualTo(-19.99)
        assertThat(tx.account?.displayName).isEqualTo("Acme Bank")
        assertThat(tx.merchant?.name).isEqualTo("Starbucks")
        assertThat(tx.merchant?.transactionsCount).isEqualTo(12)
        assertThat(tx.category?.name).isEqualTo("Coffee")
        assertThat(tx.tags).hasSize(1)
        assertThat(tx.tags!!.first().name).isEqualTo("personal")
        assertThat(tx.tags.first().color).isEqualTo("#ffaa00")
        assertThat(out.results[1].isRecurring).isTrue()
        assertThat(out.results[1].amount).isEqualTo(4500.0)
    }

    @Test
    fun `GetTransactions defaults to empty results and zero count when allTransactions missing`() {
        val data = jsonNode("""{}""")
        val out = GetTransactions.parseOutput(data)
        assertThat(out.totalCount).isEqualTo(0)
        assertThat(out.results).isEmpty()
        assertThat(out.results).isInstanceOf(List::class.java)
    }

    @Test
    fun `GetTransactions variables always emit base filter keys with empty defaults`() {
        // Mirrors the python community lib pattern: search/categories/accounts/tags are
        // always present (default empty), and nullable booleans are omitted entirely.
        val vars = GetTransactions.variables(GetTransactions.Input(startDate = "2026-05-01", endDate = "2026-05-31"))

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters).containsKeys("startDate", "endDate", "search", "categories", "accounts", "tags")
        assertThat(filters["search"]).isEqualTo("")
        assertThat(filters["categories"]).isEqualTo(emptyList<String>())
        assertThat(filters["accounts"]).isEqualTo(emptyList<String>())
        assertThat(filters["tags"]).isEqualTo(emptyList<String>())
        // No nullable-bool keys present.
        assertThat(filters).doesNotContainKeys(
            "hasAttachments",
            "hasNotes",
            "hideFromReports",
            "isSplit",
            "isRecurring",
            "importedFromMint",
            "syncedFromInstitution",
            "needsReview",
            "transactionVisibility",
        )
        // Top-level: only the 'filters' key when limit/offset/orderBy are null.
        assertThat(vars.keys).containsExactly("filters")
    }

    @Test
    fun `GetTransactions variables include non-null bools and lists`() {
        val vars =
            GetTransactions.variables(
                GetTransactions.Input(
                    startDate = "2026-05-01",
                    endDate = "2026-05-31",
                    filters =
                        TransactionFilters(
                            search = "Netflix",
                            categoryIds = listOf("c-1", "c-2"),
                            accountIds = listOf("a-1"),
                            tagIds = listOf("t-1"),
                            hasAttachments = true,
                            isRecurring = false,
                            transactionVisibility = "all_transactions",
                        ),
                    limit = 50,
                    offset = 10,
                    orderBy = "amount",
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters["search"]).isEqualTo("Netflix")
        assertThat(filters["categories"]).isEqualTo(listOf("c-1", "c-2"))
        assertThat(filters["accounts"]).isEqualTo(listOf("a-1"))
        assertThat(filters["tags"]).isEqualTo(listOf("t-1"))
        assertThat(filters["hasAttachments"]).isEqualTo(true)
        assertThat(filters["isRecurring"]).isEqualTo(false) // false is not null — should be present
        assertThat(filters["transactionVisibility"]).isEqualTo("all_transactions")
        assertThat(filters).doesNotContainKeys("hasNotes", "hideFromReports", "isSplit", "needsReview")
        assertThat(vars["limit"]).isEqualTo(50)
        assertThat(vars["offset"]).isEqualTo(10)
        assertThat(vars["orderBy"]).isEqualTo("amount")
    }

    @Test
    fun `GetTransactions merges legacy accountId into the accounts list, de-duped`() {
        // Legacy single + new list: merged.
        val mergedVars =
            GetTransactions.variables(
                GetTransactions.Input(
                    startDate = "2026-05-01",
                    endDate = "2026-05-31",
                    filters = TransactionFilters(accountId = "a-legacy", accountIds = listOf("a-1", "a-2")),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val mergedFilters = mergedVars["filters"] as Map<String, Any?>
        assertThat(mergedFilters["accounts"]).isEqualTo(listOf("a-legacy", "a-1", "a-2"))

        // Legacy already present in list: not double-added.
        val dedupVars =
            GetTransactions.variables(
                GetTransactions.Input(
                    startDate = "2026-05-01",
                    endDate = "2026-05-31",
                    filters = TransactionFilters(accountId = "a-1", accountIds = listOf("a-1", "a-2")),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val dedupFilters = dedupVars["filters"] as Map<String, Any?>
        assertThat(dedupFilters["accounts"]).isEqualTo(listOf("a-1", "a-2"))

        // Legacy only, no list: single-element list.
        val onlyLegacy =
            GetTransactions.variables(
                GetTransactions.Input(
                    startDate = "2026-05-01",
                    endDate = "2026-05-31",
                    filters = TransactionFilters(accountId = "a-1"),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val onlyLegacyFilters = onlyLegacy["filters"] as Map<String, Any?>
        assertThat(onlyLegacyFilters["accounts"]).isEqualTo(listOf("a-1"))
    }

    @Test
    fun `GetTransactionsSummary variables share the same filter shape`() {
        val vars =
            GetTransactionsSummary.variables(
                GetTransactionsSummary.Input(
                    startDate = "2026-05-01",
                    endDate = "2026-05-31",
                    filters = TransactionFilters(search = "Costco", needsReview = true),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters["search"]).isEqualTo("Costco")
        assertThat(filters["needsReview"]).isEqualTo(true)
        assertThat(filters).doesNotContainKeys("isRecurring", "hasAttachments")
        // Date fields are optional on summary; both still emitted when provided.
        assertThat(filters["startDate"]).isEqualTo("2026-05-01")
        assertThat(filters["endDate"]).isEqualTo("2026-05-31")
    }

    @Test
    fun `GetTransactionsSummary variables omit date fields when not provided`() {
        // Summary supports windowless aggregates; null dates should not leak as null entries.
        val vars = GetTransactionsSummary.variables(GetTransactionsSummary.Input())

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters).doesNotContainKeys("startDate", "endDate")
        assertThat(filters["search"]).isEqualTo("")
    }

    @Test
    fun `GetCashflowSummary variables expose the full filter surface`() {
        val vars =
            GetCashflowSummary.variables(
                GetCashflowSummary.Input(
                    startDate = "2026-04-01",
                    endDate = "2026-04-30",
                    filters = TransactionFilters(categoryIds = listOf("c-rent"), hideFromReports = false),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters["categories"]).isEqualTo(listOf("c-rent"))
        assertThat(filters["hideFromReports"]).isEqualTo(false)
        assertThat(filters["startDate"]).isEqualTo("2026-04-01")
        assertThat(filters["endDate"]).isEqualTo("2026-04-30")
    }

    @Test
    fun `GetCashflowBreakdown variables expose the full filter surface`() {
        val vars =
            GetCashflowBreakdown.variables(
                GetCashflowBreakdown.Input(
                    startDate = "2026-04-01",
                    endDate = "2026-04-30",
                    filters =
                        TransactionFilters(
                            tagIds = listOf("biz"),
                            isSplit = true,
                            importedFromMint = false,
                        ),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters["tags"]).isEqualTo(listOf("biz"))
        assertThat(filters["isSplit"]).isEqualTo(true)
        assertThat(filters["importedFromMint"]).isEqualTo(false)
        assertThat(filters).doesNotContainKeys("isRecurring", "syncedFromInstitution")
    }

    @Test
    fun `GetTransactions tolerates transactions with missing optional sub-objects`() {
        val data = loadFixture("getTransactions/bare-transaction")
        val out = GetTransactions.parseOutput(data)
        assertThat(out.totalCount).isEqualTo(1)
        val tx = out.results.single()
        assertThat(tx.id).isEqualTo("t-bare")
        assertThat(tx.account).isNull()
        assertThat(tx.merchant).isNull()
        assertThat(tx.category).isNull()
        assertThat(tx.tags).isEmpty()
        assertThat(tx.pending).isFalse()
    }

    // -- CreateTransaction --------------------------------------------------

    @Test
    fun `CreateTransaction parses transactionId from nested transaction object`() {
        val data =
            jsonNode(
                """
                {
                  "createTransaction": {
                    "transaction": {"id": "tx-new-9001"},
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = CreateTransaction.parseOutput(data)
        assertThat(out.transactionId).isEqualTo("tx-new-9001")
        assertThat(out).isInstanceOf(
            com.nicholasklaene.monarchbridge.generated.model.CreateTransactionResponseData::class.java,
        )
        assertThat(out.transactionId).isNotBlank()
    }

    @Test
    fun `CreateTransaction defaults to empty transactionId when mutation payload missing`() {
        val data = jsonNode("""{}""")
        val out = CreateTransaction.parseOutput(data)
        assertThat(out.transactionId).isEqualTo("")
        assertThat(out.transactionId).isEmpty()
        assertThat(out).isNotNull
    }

    // -- GetTransactionDetails ----------------------------------------------

    @Test
    fun `GetTransactionDetails converts populated subtree to a typed Map`() {
        val data =
            jsonNode(
                """
                {
                  "getTransaction": {
                    "id": "t-detail-1",
                    "amount": -42.5,
                    "merchant": {"id": "m-1", "name": "Whole Foods"},
                    "category": {"id": "c-1", "name": "Groceries"},
                    "splitTransactions": []
                  }
                }
                """.trimIndent(),
            )
        val out = GetTransactionDetails.parseOutput(data)
        assertThat(out.transaction).isNotNull
        assertThat(out.transaction).isInstanceOf(Map::class.java)
        assertThat(out.transaction!!["id"]).isEqualTo("t-detail-1")
        assertThat(out.transaction["amount"]).isEqualTo(-42.5)
        @Suppress("UNCHECKED_CAST")
        val merchant = out.transaction["merchant"] as Map<String, Any>
        assertThat(merchant["name"]).isEqualTo("Whole Foods")
    }

    @Test
    fun `GetTransactionDetails returns null transaction when getTransaction missing`() {
        val data = jsonNode("""{}""")
        val out = GetTransactionDetails.parseOutput(data)
        assertThat(out.transaction).isNull()
        assertThat(out).isInstanceOf(
            com.nicholasklaene.monarchbridge.generated.model.GetTransactionDetailResponseData::class.java,
        )
        assertThat(out.transaction).isNotEqualTo(emptyMap<String, Any>())
    }

    @Test
    fun `GetTransactionDetails returns null transaction when getTransaction is explicit null`() {
        val data = jsonNode("""{"getTransaction": null}""")
        val out = GetTransactionDetails.parseOutput(data)
        assertThat(out.transaction).isNull()
        assertThat(out).isNotNull
        assertThat(out.transaction).isNotEqualTo(mapOf("id" to ""))
    }

    // -- UpdateTransaction --------------------------------------------------

    @Test
    fun `UpdateTransaction parses full Transaction from updateTransaction-transaction`() {
        val data =
            jsonNode(
                """
                {
                  "updateTransaction": {
                    "transaction": {
                      "id": "t-99",
                      "date": "2026-05-20",
                      "amount": -127.43,
                      "pending": false,
                      "plaidName": "AMZN MKTP",
                      "notes": "office supplies",
                      "hideFromReports": false,
                      "needsReview": false,
                      "isRecurring": false,
                      "isSplitTransaction": false,
                      "account": {"id": "a-99", "displayName": "Chase Sapphire"},
                      "merchant": {"id": "m-99", "name": "Amazon", "transactionsCount": 87},
                      "category": {"id": "c-99", "name": "Shopping"},
                      "tags": [{"id": "tg-99", "name": "work", "color": "#00aaff", "order": 2}]
                    },
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateTransaction.parseOutput(data)
        assertThat(out.transaction.id).isEqualTo("t-99")
        assertThat(out.transaction.amount).isEqualTo(-127.43)
        assertThat(out.transaction.date).isEqualTo(LocalDate.parse("2026-05-20"))
        assertThat(out.transaction.notes).isEqualTo("office supplies")
        assertThat(out.transaction.merchant?.name).isEqualTo("Amazon")
        assertThat(out.transaction.category?.name).isEqualTo("Shopping")
        assertThat(
            out.transaction.tags!!
                .single()
                .name,
        ).isEqualTo("work")
    }

    @Test
    fun `UpdateTransaction falls back to safe defaults when transaction subtree empty`() {
        val data = jsonNode("""{"updateTransaction": {}}""")
        val out = UpdateTransaction.parseOutput(data)
        assertThat(out.transaction.id).isEqualTo("")
        assertThat(out.transaction.amount).isEqualTo(0.0)
        assertThat(out.transaction.date).isEqualTo(LocalDate.parse("1970-01-01"))
        assertThat(out.transaction.merchant).isNull()
        assertThat(out.transaction.tags).isEmpty()
    }

    // -- DeleteTransaction --------------------------------------------------

    @Test
    fun `DeleteTransaction parses deleted-true from mutation payload`() {
        val data =
            jsonNode(
                """
                {
                  "deleteTransaction": {
                    "deleted": true,
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = DeleteTransaction.parseOutput(data)
        assertThat(out.deleted).isTrue()
        assertThat(out).isInstanceOf(
            com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData::class.java,
        )
        assertThat(out.deleted).isNotEqualTo(false)
    }

    @Test
    fun `DeleteTransaction defaults to deleted-false when payload absent`() {
        val data = jsonNode("""{}""")
        val out = DeleteTransaction.parseOutput(data)
        assertThat(out.deleted).isFalse()
        assertThat(out).isNotNull
        assertThat(out.deleted).isNotEqualTo(true)
    }

    @Test
    fun `DeleteTransaction parses deleted-false explicitly`() {
        val data = jsonNode("""{"deleteTransaction": {"deleted": false, "errors": [{"code":"X"}]}}""")
        val out = DeleteTransaction.parseOutput(data)
        assertThat(out.deleted).isFalse()
        assertThat(out).isNotNull
        assertThat(out.deleted).isFalse()
    }

    // -- SetTransactionTags -------------------------------------------------

    @Test
    fun `SetTransactionTags parses transactionId and ordered tagIds`() {
        val data =
            jsonNode(
                """
                {
                  "setTransactionTags": {
                    "transaction": {
                      "id": "t-tagged-1",
                      "tags": [
                        {"id": "tg-1", "name": "personal"},
                        {"id": "tg-2", "name": "work"},
                        {"id": "tg-3", "name": "tax"}
                      ]
                    },
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = SetTransactionTags.parseOutput(data)
        assertThat(out.transactionId).isEqualTo("t-tagged-1")
        assertThat(out.tagIds).containsExactly("tg-1", "tg-2", "tg-3")
        assertThat(out.tagIds).hasSize(3)
    }

    @Test
    fun `SetTransactionTags returns empty tagIds when transaction has no tags`() {
        val data =
            jsonNode(
                """
                {
                  "setTransactionTags": {
                    "transaction": {"id": "t-bare", "tags": []},
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = SetTransactionTags.parseOutput(data)
        assertThat(out.transactionId).isEqualTo("t-bare")
        assertThat(out.tagIds).isEmpty()
        assertThat(out.tagIds).isInstanceOf(List::class.java)
    }

    @Test
    fun `SetTransactionTags returns empty transactionId and tagIds when mutation key missing`() {
        val data = jsonNode("""{}""")
        val out = SetTransactionTags.parseOutput(data)
        assertThat(out.transactionId).isEqualTo("")
        assertThat(out.tagIds).isEmpty()
        assertThat(out).isNotNull
    }

    // -- GetTransactionSplits -----------------------------------------------

    @Test
    fun `GetTransactionSplits parses id, amount, merchant, category, and splits`() {
        val data =
            jsonNode(
                """
                {
                  "getTransaction": {
                    "id": "t-split-1",
                    "amount": -100.0,
                    "merchant": {"id": "m-1", "name": "Costco"},
                    "category": {"id": "c-1", "name": "Groceries"},
                    "splitTransactions": [
                      {
                        "id": "s-1",
                        "amount": -60.0,
                        "notes": "food half",
                        "merchant": {"name": "Costco"},
                        "category": {"name": "Groceries"}
                      },
                      {
                        "id": "s-2",
                        "amount": -40.0,
                        "notes": null,
                        "merchant": {"name": "Costco"},
                        "category": {"name": "Household"}
                      }
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetTransactionSplits.parseOutput(data)
        assertThat(out.id).isEqualTo("t-split-1")
        assertThat(out.amount).isEqualTo(-100.0)
        assertThat(out.merchant?.name).isEqualTo("Costco")
        assertThat(out.merchant?.id).isEqualTo("m-1")
        assertThat(out.category?.name).isEqualTo("Groceries")
        assertThat(out.splits).hasSize(2)
        val first = out.splits.first()
        assertThat(first.id).isEqualTo("s-1")
        assertThat(first.amount).isEqualTo(-60.0)
        assertThat(first.notes).isEqualTo("food half")
        assertThat(first.merchantName).isEqualTo("Costco")
        assertThat(first.categoryName).isEqualTo("Groceries")
        assertThat(out.splits[1].notes).isNull()
        assertThat(out.splits[1].categoryName).isEqualTo("Household")
    }

    @Test
    fun `GetTransactionSplits returns null refs and empty splits when transaction bare`() {
        val data =
            jsonNode(
                """
                {
                  "getTransaction": {
                    "id": "t-empty",
                    "amount": 0.0
                  }
                }
                """.trimIndent(),
            )
        val out = GetTransactionSplits.parseOutput(data)
        assertThat(out.id).isEqualTo("t-empty")
        assertThat(out.amount).isEqualTo(0.0)
        assertThat(out.merchant).isNull()
        assertThat(out.category).isNull()
        assertThat(out.splits).isEmpty()
    }

    // -- UpdateTransactionSplits --------------------------------------------

    @Test
    fun `UpdateTransactionSplits parses transactionId, flag, and split list`() {
        val data =
            jsonNode(
                """
                {
                  "updateTransactionSplit": {
                    "transaction": {
                      "id": "t-100",
                      "hasSplitTransactions": true,
                      "splitTransactions": [
                        {
                          "id": "s-A",
                          "amount": -25.0,
                          "notes": "lunch share",
                          "merchant": {"name": "Diner"},
                          "category": {"name": "Restaurants"}
                        },
                        {
                          "id": "s-B",
                          "amount": -75.0,
                          "notes": null,
                          "merchant": {"name": "Diner"},
                          "category": {"name": "Personal"}
                        }
                      ]
                    },
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateTransactionSplits.parseOutput(data)
        assertThat(out.transactionId).isEqualTo("t-100")
        assertThat(out.hasSplitTransactions).isTrue()
        assertThat(out.splitTransactions).hasSize(2)
        val a = out.splitTransactions.first()
        assertThat(a.id).isEqualTo("s-A")
        assertThat(a.amount).isEqualTo(-25.0)
        assertThat(a.notes).isEqualTo("lunch share")
        assertThat(a.merchantName).isEqualTo("Diner")
        assertThat(a.categoryName).isEqualTo("Restaurants")
        assertThat(out.splitTransactions[1].notes).isNull()
    }

    @Test
    fun `UpdateTransactionSplits returns empty list and false flag when splits cleared`() {
        val data =
            jsonNode(
                """
                {
                  "updateTransactionSplit": {
                    "transaction": {
                      "id": "t-cleared",
                      "hasSplitTransactions": false,
                      "splitTransactions": []
                    },
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateTransactionSplits.parseOutput(data)
        assertThat(out.transactionId).isEqualTo("t-cleared")
        assertThat(out.hasSplitTransactions).isFalse()
        assertThat(out.splitTransactions).isEmpty()
    }

    // -- GetTransactionsSummary --------------------------------------------

    @Test
    fun `GetTransactionsSummary parses object-shape aggregates with all fields`() {
        val data =
            jsonNode(
                """
                {
                  "aggregates": {
                    "summary": {
                      "count": 87,
                      "sum": -1245.67,
                      "avg": -14.32,
                      "min": -500.0,
                      "max": 2400.0,
                      "first": "2026-05-01",
                      "last": "2026-05-25"
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = GetTransactionsSummary.parseOutput(data)
        assertThat(out.summary.count).isEqualTo(87)
        assertThat(out.summary.sum).isEqualTo(-1245.67)
        assertThat(out.summary.avg).isEqualTo(-14.32)
        assertThat(out.summary.min).isEqualTo(-500.0)
        assertThat(out.summary.max).isEqualTo(2400.0)
        assertThat(out.summary.first).isEqualTo(LocalDate.parse("2026-05-01"))
        assertThat(out.summary.last).isEqualTo(LocalDate.parse("2026-05-25"))
    }

    @Test
    fun `GetTransactionsSummary parses array-shape aggregates by reading first element`() {
        val data =
            jsonNode(
                """
                {
                  "aggregates": [
                    {
                      "summary": {
                        "count": 5,
                        "sum": -50.0,
                        "avg": -10.0,
                        "min": -25.0,
                        "max": -1.0,
                        "first": "2026-04-01",
                        "last": "2026-04-30"
                      }
                    },
                    {
                      "summary": {"count": 999}
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetTransactionsSummary.parseOutput(data)
        assertThat(out.summary.count).isEqualTo(5)
        assertThat(out.summary.sum).isEqualTo(-50.0)
        assertThat(out.summary.first).isEqualTo(LocalDate.parse("2026-04-01"))
        assertThat(out.summary.last).isEqualTo(LocalDate.parse("2026-04-30"))
        assertThat(out.summary.avg).isEqualTo(-10.0)
    }

    @Test
    fun `GetTransactionsSummary returns count-zero and null fields when aggregates missing`() {
        val data = jsonNode("""{}""")
        val out = GetTransactionsSummary.parseOutput(data)
        assertThat(out.summary.count).isEqualTo(0)
        assertThat(out.summary.sum).isNull()
        assertThat(out.summary.avg).isNull()
        assertThat(out.summary.first).isNull()
        assertThat(out.summary.last).isNull()
    }

    // -- GetCashflowSummary -------------------------------------------------

    @Test
    fun `GetCashflowSummary parses object-shape summary with income, expense, savings`() {
        val data =
            jsonNode(
                """
                {
                  "summary": {
                    "summary": {
                      "sumIncome": 5000.0,
                      "sumExpense": -3200.5,
                      "savings": 1799.5,
                      "savingsRate": 0.36
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = GetCashflowSummary.parseOutput(data)
        assertThat(out.summary.sumIncome).isEqualTo(5000.0)
        assertThat(out.summary.sumExpense).isEqualTo(-3200.5)
        assertThat(out.summary.savings).isEqualTo(1799.5)
        assertThat(out.summary.savingsRate).isEqualTo(0.36)
    }

    @Test
    fun `GetCashflowSummary parses array-shape summary by reading first element`() {
        val data =
            jsonNode(
                """
                {
                  "summary": [
                    {
                      "summary": {
                        "sumIncome": 9000.0,
                        "sumExpense": -4500.0,
                        "savings": 4500.0,
                        "savingsRate": 0.5
                      }
                    },
                    {
                      "summary": {"sumIncome": -1.0}
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetCashflowSummary.parseOutput(data)
        assertThat(out.summary.sumIncome).isEqualTo(9000.0)
        assertThat(out.summary.sumExpense).isEqualTo(-4500.0)
        assertThat(out.summary.savings).isEqualTo(4500.0)
        assertThat(out.summary.savingsRate).isEqualTo(0.5)
    }

    @Test
    fun `GetCashflowSummary returns all-null summary fields when summary missing`() {
        val data = jsonNode("""{}""")
        val out = GetCashflowSummary.parseOutput(data)
        assertThat(out.summary.sumIncome).isNull()
        assertThat(out.summary.sumExpense).isNull()
        assertThat(out.summary.savings).isNull()
        assertThat(out.summary.savingsRate).isNull()
    }

    // -- GetCashflowBreakdown ----------------------------------------------

    @Test
    fun `GetCashflowBreakdown parses all four buckets with object-shape summary`() {
        val data =
            jsonNode(
                """
                {
                  "byCategory": [
                    {"groupBy": {"category": {"id":"c-1","name":"Coffee"}}, "summary": {"sumExpense": -150.0}},
                    {"groupBy": {"category": {"id":"c-2","name":"Rent"}},   "summary": {"sumExpense": -2200.0}}
                  ],
                  "byCategoryGroup": [
                    {"groupBy": {"categoryGroup": {"id":"g-1","name":"Food"}}, "summary": {"sumExpense": -700.0}}
                  ],
                  "byMerchant": [
                    {"groupBy": {"merchant": {"id":"m-1","name":"Starbucks"}}, "summary": {"sumExpense": -150.0}},
                    {"groupBy": {"merchant": {"id":"m-2","name":"Amazon"}},    "summary": {"sumExpense": -432.10}},
                    {"groupBy": {"merchant": {"id":"m-3","name":"Costco"}},    "summary": {"sumExpense": -90.0}}
                  ],
                  "summary": {
                    "summary": {
                      "sumIncome": 5000.0,
                      "sumExpense": -3200.5,
                      "savings": 1799.5,
                      "savingsRate": 0.36
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = GetCashflowBreakdown.parseOutput(data)
        assertThat(out.byCategory).hasSize(2)
        assertThat(out.byCategoryGroup).hasSize(1)
        assertThat(out.byMerchant).hasSize(3)
        assertThat(out.summary).isNotNull
        assertThat(out.summary!!["sumIncome"]).isEqualTo(5000.0)
        assertThat(out.summary["sumExpense"]).isEqualTo(-3200.5)
        assertThat(out.summary["savingsRate"]).isEqualTo(0.36)
        @Suppress("UNCHECKED_CAST")
        val firstBucket = out.byCategory.first()
        assertThat(firstBucket["summary"]).isInstanceOf(Map::class.java)
    }

    @Test
    fun `GetCashflowBreakdown parses array-shape summary by reading first element`() {
        val data =
            jsonNode(
                """
                {
                  "byCategory": [],
                  "byCategoryGroup": [],
                  "byMerchant": [],
                  "summary": [
                    {
                      "summary": {
                        "sumIncome": 100.0,
                        "sumExpense": -40.0,
                        "savings": 60.0,
                        "savingsRate": 0.6
                      }
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetCashflowBreakdown.parseOutput(data)
        assertThat(out.byCategory).isEmpty()
        assertThat(out.byCategoryGroup).isEmpty()
        assertThat(out.byMerchant).isEmpty()
        assertThat(out.summary).isNotNull
        assertThat(out.summary!!["sumIncome"]).isEqualTo(100.0)
        assertThat(out.summary["savingsRate"]).isEqualTo(0.6)
    }

    @Test
    fun `GetCashflowBreakdown returns empty buckets and null summary when payload empty`() {
        val data = jsonNode("""{}""")
        val out = GetCashflowBreakdown.parseOutput(data)
        assertThat(out.byCategory).isEmpty()
        assertThat(out.byCategoryGroup).isEmpty()
        assertThat(out.byMerchant).isEmpty()
        assertThat(out.summary).isNull()
    }

    // -- GetTransactionAttachmentUploadInfo --------------------------------

    @Test
    fun `GetTransactionAttachmentUploadInfo parses cloudinaryPath and all signed-upload params`() {
        val data =
            jsonNode(
                """
                {
                  "getTransactionAttachmentUploadInfo": {
                    "info": {
                      "path": "https://api.cloudinary.com/v1_1/monarch-money/image/upload/",
                      "requestParams": {
                        "timestamp": "1748180000",
                        "folder": "monarch/attachments/tx-1",
                        "signature": "deadbeefcafebabe",
                        "api_key": "key-12345",
                        "upload_preset": "monarch_attachment_unsigned"
                      }
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = GetTransactionAttachmentUploadInfo.parseOutput(data)
        assertThat(out.cloudinaryPath).isEqualTo("https://api.cloudinary.com/v1_1/monarch-money/image/upload/")
        assertThat(out.timestamp).isEqualTo("1748180000")
        assertThat(out.folder).isEqualTo("monarch/attachments/tx-1")
        assertThat(out.signature).isEqualTo("deadbeefcafebabe")
        assertThat(out.apiKey).isEqualTo("key-12345")
        assertThat(out.uploadPreset).isEqualTo("monarch_attachment_unsigned")
    }

    @Test
    fun `GetTransactionAttachmentUploadInfo defaults all fields to empty strings when payload missing`() {
        val out = GetTransactionAttachmentUploadInfo.parseOutput(jsonNode("""{}"""))
        assertThat(out.cloudinaryPath).isEmpty()
        assertThat(out.timestamp).isEmpty()
        assertThat(out.folder).isEmpty()
        assertThat(out.signature).isEmpty()
        assertThat(out.apiKey).isEmpty()
        assertThat(out.uploadPreset).isEmpty()
    }

    @Test
    fun `GetTransactionAttachmentUploadInfo defaults to empty strings for missing requestParams sub-fields`() {
        val data =
            jsonNode(
                """
                {
                  "getTransactionAttachmentUploadInfo": {
                    "info": {
                      "path": "https://api.cloudinary.com/upload/",
                      "requestParams": {}
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = GetTransactionAttachmentUploadInfo.parseOutput(data)
        assertThat(out.cloudinaryPath).isEqualTo("https://api.cloudinary.com/upload/")
        assertThat(out.timestamp).isEmpty()
        assertThat(out.folder).isEmpty()
        assertThat(out.signature).isEmpty()
        assertThat(out.apiKey).isEmpty()
        assertThat(out.uploadPreset).isEmpty()
    }

    // -- AddTransactionAttachment -----------------------------------------

    @Test
    fun `AddTransactionAttachment parses every TransactionAttachment field`() {
        val data =
            jsonNode(
                """
                {
                  "addTransactionAttachment": {
                    "attachment": {
                      "id": "att-987",
                      "publicId": "monarch/attachments/tx-1/abc123",
                      "extension": "pdf",
                      "sizeBytes": 204800,
                      "filename": "receipt.pdf",
                      "originalAssetUrl": "https://res.cloudinary.com/monarch/raw/upload/v1/monarch/attachments/tx-1/abc123.pdf"
                    },
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = AddTransactionAttachment.parseOutput(data)
        assertThat(out.id).isEqualTo("att-987")
        assertThat(out.publicId).isEqualTo("monarch/attachments/tx-1/abc123")
        assertThat(out.extension).isEqualTo("pdf")
        assertThat(out.sizeBytes).isEqualTo(204800)
        assertThat(out.filename).isEqualTo("receipt.pdf")
        assertThat(out.originalAssetUrl).isEqualTo(
            "https://res.cloudinary.com/monarch/raw/upload/v1/monarch/attachments/tx-1/abc123.pdf",
        )
        assertThat(out).isInstanceOf(
            com.nicholasklaene.monarchbridge.generated.model.TransactionAttachment::class.java,
        )
    }

    @Test
    fun `AddTransactionAttachment defaults id to empty and nullable fields to null when attachment missing`() {
        val out = AddTransactionAttachment.parseOutput(jsonNode("""{}"""))
        assertThat(out.id).isEqualTo("")
        assertThat(out.publicId).isNull()
        assertThat(out.extension).isNull()
        assertThat(out.sizeBytes).isNull()
        assertThat(out.filename).isNull()
        assertThat(out.originalAssetUrl).isNull()
    }

    @Test
    fun `AddTransactionAttachment leaves nullable fields null when attachment has only id`() {
        val data = jsonNode("""{"addTransactionAttachment": {"attachment": {"id": "att-bare"}, "errors": null}}""")
        val out = AddTransactionAttachment.parseOutput(data)
        assertThat(out.id).isEqualTo("att-bare")
        assertThat(out.publicId).isNull()
        assertThat(out.extension).isNull()
        assertThat(out.sizeBytes).isNull()
        assertThat(out.filename).isNull()
        assertThat(out.originalAssetUrl).isNull()
    }

    // -- BulkUpdateTransactions --------------------------------------------

    @Test
    fun `BulkUpdateTransactions parses success and affectedCount from mutation payload`() {
        val data =
            jsonNode(
                """
                {
                  "bulkUpdateTransactions": {
                    "success": true,
                    "affectedCount": 42,
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = BulkUpdateTransactions.parseOutput(data)
        assertThat(out.success).isTrue()
        assertThat(out.affectedCount).isEqualTo(42)
        assertThat(out.errors).isNull()
    }

    @Test
    fun `BulkUpdateTransactions defaults to success-false and zero when payload absent`() {
        val out = BulkUpdateTransactions.parseOutput(jsonNode("""{}"""))
        assertThat(out.success).isFalse()
        assertThat(out.affectedCount).isEqualTo(0)
        assertThat(out.errors).isNull()
    }

    @Test
    fun `BulkUpdateTransactions variables wire selection set + updates + filters verbatim`() {
        val vars =
            BulkUpdateTransactions.variables(
                BulkUpdateTransactions.Input(
                    selectedTransactionIds = listOf("t-1", "t-2"),
                    excludedTransactionIds = null,
                    allSelected = false,
                    expectedAffectedTransactionCount = 2,
                    updates = mapOf("categoryId" to "c-99", "notes" to "auto-categorize"),
                    filters = mapOf("search" to "Costco"),
                ),
            )
        assertThat(vars["selectedTransactionIds"]).isEqualTo(listOf("t-1", "t-2"))
        assertThat(vars["excludedTransactionIds"]).isNull()
        assertThat(vars["allSelected"]).isEqualTo(false)
        assertThat(vars["expectedAffectedTransactionCount"]).isEqualTo(2)

        @Suppress("UNCHECKED_CAST")
        val updates = vars["updates"] as Map<String, Any?>
        assertThat(updates["categoryId"]).isEqualTo("c-99")
        assertThat(updates["notes"]).isEqualTo("auto-categorize")

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters["search"]).isEqualTo("Costco")
    }

    @Test
    fun `BulkUpdateTransactions Input from picks non-null update fields and applies allSelected default`() {
        val req =
            com.nicholasklaene.monarchbridge.generated.model.BulkUpdateTransactionsRequest(
                expectedAffectedTransactionCount = 3,
                updates =
                    com.nicholasklaene.monarchbridge.generated.model.BulkTransactionUpdates(
                        categoryId = "c-1",
                        notes = "bulk",
                        hide = true,
                    ),
                selectedTransactionIds = listOf("t-a", "t-b", "t-c"),
                allSelected = null,
            )
        val input = BulkUpdateTransactions.Input.from(req)
        assertThat(input.allSelected).isFalse()
        assertThat(input.expectedAffectedTransactionCount).isEqualTo(3)
        assertThat(input.selectedTransactionIds).containsExactly("t-a", "t-b", "t-c")
        assertThat(input.updates).containsEntry("categoryId", "c-1")
        assertThat(input.updates).containsEntry("notes", "bulk")
        assertThat(input.updates).containsEntry("hide", true)
        // Null update fields must be omitted, not present as null.
        assertThat(input.updates).doesNotContainKeys("merchantName", "date", "tags")
        assertThat(input.filters).isNull()
    }

    @Test
    fun `BulkUpdateTransactions Input from converts filter dates and enum verbatim`() {
        val req =
            com.nicholasklaene.monarchbridge.generated.model.BulkUpdateTransactionsRequest(
                expectedAffectedTransactionCount = 99,
                updates =
                    com.nicholasklaene.monarchbridge.generated.model.BulkTransactionUpdates(
                        categoryId = "c-2",
                    ),
                allSelected = true,
                filters =
                    com.nicholasklaene.monarchbridge.generated.model.BulkTransactionFilters(
                        startDate = LocalDate.parse("2026-01-01"),
                        endDate = LocalDate.parse("2026-12-31"),
                        accounts = listOf("a-1"),
                        transactionVisibility =
                            com.nicholasklaene.monarchbridge.generated.model
                                .BulkTransactionFilters.TransactionVisibility.ALL_TRANSACTIONS,
                    ),
            )
        val input = BulkUpdateTransactions.Input.from(req)
        assertThat(input.allSelected).isTrue()
        val filters = input.filters!!
        assertThat(filters["startDate"]).isEqualTo("2026-01-01")
        assertThat(filters["endDate"]).isEqualTo("2026-12-31")
        assertThat(filters["accounts"]).isEqualTo(listOf("a-1"))
        assertThat(filters["transactionVisibility"]).isEqualTo("all_transactions")
        // Unset filter fields are omitted.
        assertThat(filters).doesNotContainKeys("search", "categories", "tags", "hasAttachments", "isRecurring")
    }

    // -- BulkDeleteTransactions --------------------------------------------

    @Test
    fun `BulkDeleteTransactions parses success and affectedCount from mutation payload`() {
        val data =
            jsonNode(
                """
                {
                  "bulkDeleteTransactions": {
                    "success": true,
                    "affectedCount": 7,
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = BulkDeleteTransactions.parseOutput(data)
        assertThat(out.success).isTrue()
        assertThat(out.affectedCount).isEqualTo(7)
        assertThat(out.errors).isNull()
    }

    @Test
    fun `BulkDeleteTransactions defaults to success-false and zero when payload absent`() {
        val out = BulkDeleteTransactions.parseOutput(jsonNode("""{}"""))
        assertThat(out.success).isFalse()
        assertThat(out.affectedCount).isEqualTo(0)
    }

    @Test
    fun `BulkDeleteTransactions variables include selection set and filters but never updates`() {
        val vars =
            BulkDeleteTransactions.variables(
                BulkDeleteTransactions.Input(
                    selectedTransactionIds = listOf("t-1"),
                    excludedTransactionIds = listOf("t-9"),
                    allSelected = true,
                    expectedAffectedTransactionCount = 100,
                    filters = mapOf("hideFromReports" to true),
                ),
            )
        assertThat(vars["selectedTransactionIds"]).isEqualTo(listOf("t-1"))
        assertThat(vars["excludedTransactionIds"]).isEqualTo(listOf("t-9"))
        assertThat(vars["allSelected"]).isEqualTo(true)
        assertThat(vars["expectedAffectedTransactionCount"]).isEqualTo(100)
        assertThat(vars).doesNotContainKey("updates")

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters["hideFromReports"]).isEqualTo(true)
    }

    @Test
    fun `BulkDeleteTransactions Input from preserves allSelected default and unwraps filter enum`() {
        val req =
            com.nicholasklaene.monarchbridge.generated.model.BulkDeleteTransactionsRequest(
                expectedAffectedTransactionCount = 1,
                selectedTransactionIds = listOf("t-only"),
                allSelected = null,
                filters =
                    com.nicholasklaene.monarchbridge.generated.model.BulkTransactionFilters(
                        transactionVisibility =
                            com.nicholasklaene.monarchbridge.generated.model
                                .BulkTransactionFilters.TransactionVisibility.HIDDEN_TRANSACTIONS_ONLY,
                    ),
            )
        val input = BulkDeleteTransactions.Input.from(req)
        assertThat(input.allSelected).isFalse()
        assertThat(input.selectedTransactionIds).containsExactly("t-only")
        assertThat(input.filters?.get("transactionVisibility")).isEqualTo("hidden_transactions_only")
    }

    @Test
    fun `GetAttachment parses id and originalAssetUrl`() {
        val data =
            jsonNode(
                """
                {"transactionAttachment": {"id": "att-1", "originalAssetUrl": "https://example.com/receipt.png"}}
                """.trimIndent(),
            )
        val out = GetAttachment.parseOutput(data)
        assertThat(out.attachment.id).isEqualTo("att-1")
        assertThat(out.attachment.originalAssetUrl).isEqualTo("https://example.com/receipt.png")
    }

    @Test
    fun `GetAttachment handles missing originalAssetUrl`() {
        val data = jsonNode("""{"transactionAttachment": {"id": "att-2"}}""")
        val out = GetAttachment.parseOutput(data)
        assertThat(out.attachment.id).isEqualTo("att-2")
        assertThat(out.attachment.originalAssetUrl).isNull()
    }

    @Test
    fun `GetReviewSummaryByUser pivots aggregates rows to per-user counts`() {
        val data =
            jsonNode(
                """
                {
                  "byNeedsReviewByUser": [
                    {"groupBy": {"needsReviewByUser": {"id": "u-1", "name": "Sam"}}, "summary": {"count": 7}},
                    {"groupBy": {"needsReviewByUser": {"id": "u-2", "name": "Pat"}}, "summary": {"count": 3}}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetReviewSummaryByUser.parseOutput(data)
        assertThat(out.rows).hasSize(2)
        assertThat(out.rows[0].userId).isEqualTo("u-1")
        assertThat(out.rows[0].name).isEqualTo("Sam")
        assertThat(out.rows[0].count).isEqualTo(7)
        assertThat(out.rows[1].count).isEqualTo(3)
    }

    @Test
    fun `GetReviewSummaryByUser returns empty rows when nobody has review queue items`() {
        val out = GetReviewSummaryByUser.parseOutput(jsonNode("""{"byNeedsReviewByUser": []}"""))
        assertThat(out.rows).isEmpty()
    }

    // -- CreateTransaction variables + Input.from ---------------------------

    @Test
    fun `CreateTransaction Input from maps full request and defaults nullable notes`() {
        val req =
            CreateTransactionRequest(
                date = "2026-05-25",
                accountId = "a-1",
                amount = -19.99,
                merchantName = "Starbucks",
                categoryId = "c-1",
                notes = "coffee",
                shouldUpdateBalance = true,
            )
        val input = CreateTransaction.Input.from(req)
        assertThat(input.date).isEqualTo("2026-05-25")
        assertThat(input.accountId).isEqualTo("a-1")
        assertThat(input.amount).isEqualTo(-19.99)
        assertThat(input.merchantName).isEqualTo("Starbucks")
        assertThat(input.categoryId).isEqualTo("c-1")
        assertThat(input.notes).isEqualTo("coffee")
        assertThat(input.shouldUpdateBalance).isTrue

        val sparse =
            CreateTransactionRequest(
                date = "2026-05-25",
                accountId = "a-1",
                amount = 50.0,
                merchantName = "Refund",
                categoryId = "c-2",
                notes = null,
                shouldUpdateBalance = null,
            )
        val sparseIn = CreateTransaction.Input.from(sparse)
        assertThat(sparseIn.notes).isEqualTo("")
        assertThat(sparseIn.shouldUpdateBalance).isFalse
    }

    @Test
    fun `CreateTransaction variables nest under input with every field`() {
        val vars =
            CreateTransaction.variables(
                CreateTransaction.Input(
                    date = "2026-05-25",
                    accountId = "a-1",
                    amount = -19.99,
                    merchantName = "Starbucks",
                    categoryId = "c-1",
                    notes = "coffee",
                    shouldUpdateBalance = true,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = vars["input"] as Map<String, Any?>
        assertThat(inner["date"]).isEqualTo("2026-05-25")
        assertThat(inner["accountId"]).isEqualTo("a-1")
        assertThat(inner["amount"]).isEqualTo(-19.99)
        assertThat(inner["merchantName"]).isEqualTo("Starbucks")
        assertThat(inner["categoryId"]).isEqualTo("c-1")
        assertThat(inner["notes"]).isEqualTo("coffee")
        assertThat(inner["shouldUpdateBalance"]).isEqualTo(true)
    }

    // -- DeleteTransaction variables ----------------------------------------

    @Test
    fun `DeleteTransaction variables nest transactionId under input`() {
        val vars = DeleteTransaction.variables(DeleteTransaction.Input(transactionId = "t-9"))

        @Suppress("UNCHECKED_CAST")
        val inner = vars["input"] as Map<String, Any?>
        assertThat(inner["transactionId"]).isEqualTo("t-9")
    }

    // -- UpdateTransaction variables + Input.from ---------------------------

    @Test
    fun `UpdateTransaction Input from copies all optional fields verbatim`() {
        val req =
            UpdateTransactionRequest(
                category = "c-new",
                merchantName = "New Name",
                amount = -25.0,
                date = "2026-05-26",
                notes = "updated",
                hideFromReports = true,
                needsReview = false,
                reviewed = true,
                goalId = "g-1",
            )
        val input = UpdateTransaction.Input.from(id = "t-1", req = req)
        assertThat(input.id).isEqualTo("t-1")
        assertThat(input.category).isEqualTo("c-new")
        assertThat(input.merchantName).isEqualTo("New Name")
        assertThat(input.amount).isEqualTo(-25.0)
        assertThat(input.date).isEqualTo("2026-05-26")
        assertThat(input.notes).isEqualTo("updated")
        assertThat(input.hideFromReports).isTrue
        assertThat(input.needsReview).isFalse
        assertThat(input.reviewed).isTrue
        assertThat(input.goalId).isEqualTo("g-1")
    }

    @Test
    fun `UpdateTransaction variables only emit non-null fields under input`() {
        val varsFull =
            UpdateTransaction.variables(
                UpdateTransaction.Input(
                    id = "t-1",
                    category = "c-x",
                    merchantName = "Foo",
                    amount = 1.0,
                    date = "2026-05-25",
                    hideFromReports = true,
                    needsReview = false,
                    reviewed = true,
                    goalId = "g-1",
                    notes = "n",
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val full = varsFull["input"] as Map<String, Any?>
        assertThat(full).containsKeys(
            "id",
            "category",
            "name",
            "amount",
            "date",
            "hideFromReports",
            "needsReview",
            "reviewed",
            "goalId",
            "notes",
        )
        // The GraphQL field name is `name`, not `merchantName`.
        assertThat(full["name"]).isEqualTo("Foo")

        val varsSparse = UpdateTransaction.variables(UpdateTransaction.Input(id = "t-1"))

        @Suppress("UNCHECKED_CAST")
        val sparse = varsSparse["input"] as Map<String, Any?>
        assertThat(sparse.keys).containsExactly("id")
    }

    // -- SetTransactionTags variables + Input.from --------------------------

    @Test
    fun `SetTransactionTags Input from carries transactionId and tagIds`() {
        val input =
            SetTransactionTags.Input.from(
                transactionId = "t-1",
                req = SetTransactionTagsRequest(tagIds = listOf("tag-1", "tag-2")),
            )
        assertThat(input.transactionId).isEqualTo("t-1")
        assertThat(input.tagIds).containsExactly("tag-1", "tag-2")
    }

    @Test
    fun `SetTransactionTags variables nest both fields under input`() {
        val vars =
            SetTransactionTags.variables(
                SetTransactionTags.Input(transactionId = "t-1", tagIds = listOf("tag-1")),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = vars["input"] as Map<String, Any?>
        assertThat(inner["transactionId"]).isEqualTo("t-1")
        assertThat(inner["tagIds"]).isEqualTo(listOf("tag-1"))

        val empty = SetTransactionTags.variables(SetTransactionTags.Input(transactionId = "t-2", tagIds = emptyList()))

        @Suppress("UNCHECKED_CAST")
        val emptyInner = empty["input"] as Map<String, Any?>
        assertThat(emptyInner["tagIds"]).isEqualTo(emptyList<String>())
    }

    // -- UpdateTransactionSplits variables + Input.from ---------------------

    @Test
    fun `UpdateTransactionSplits Input from maps split rows`() {
        val req =
            UpdateTransactionSplitsRequest(
                splitData =
                    listOf(
                        Split(merchantName = "Coffee", amount = -5.0, categoryId = "c-1"),
                        Split(merchantName = "Snack", amount = -3.0, categoryId = "c-2"),
                    ),
            )
        val input = UpdateTransactionSplits.Input.from(transactionId = "t-9", req = req)
        assertThat(input.transactionId).isEqualTo("t-9")
        assertThat(input.splitData).hasSize(2)
        assertThat(input.splitData[0].merchantName).isEqualTo("Coffee")
        assertThat(input.splitData[0].amount).isEqualTo(-5.0)
        assertThat(input.splitData[0].categoryId).isEqualTo("c-1")
    }

    @Test
    fun `UpdateTransactionSplits variables serialize splits as list of maps`() {
        val vars =
            UpdateTransactionSplits.variables(
                UpdateTransactionSplits.Input(
                    transactionId = "t-1",
                    splitData =
                        listOf(
                            UpdateTransactionSplits.Split(merchantName = "Coffee", amount = -5.0, categoryId = "c-1"),
                        ),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = vars["input"] as Map<String, Any?>
        assertThat(inner["transactionId"]).isEqualTo("t-1")

        @Suppress("UNCHECKED_CAST")
        val splits = inner["splitData"] as List<Map<String, Any?>>
        assertThat(splits).hasSize(1)
        assertThat(splits[0]["merchantName"]).isEqualTo("Coffee")
        assertThat(splits[0]["amount"]).isEqualTo(-5.0)
        assertThat(splits[0]["categoryId"]).isEqualTo("c-1")
    }

    // -- AddTransactionAttachment variables ---------------------------------

    @Test
    fun `AddTransactionAttachment variables nest all five fields under input`() {
        val vars =
            AddTransactionAttachment.variables(
                AddTransactionAttachment.Input(
                    transactionId = "t-1",
                    filename = "receipt.jpg",
                    publicId = "pub-1",
                    extension = "jpg",
                    sizeBytes = 12_345,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = vars["input"] as Map<String, Any?>
        assertThat(inner["transactionId"]).isEqualTo("t-1")
        assertThat(inner["filename"]).isEqualTo("receipt.jpg")
        assertThat(inner["publicId"]).isEqualTo("pub-1")
        assertThat(inner["extension"]).isEqualTo("jpg")
        assertThat(inner["sizeBytes"]).isEqualTo(12_345)
    }

    // -- GetAttachment variables --------------------------------------------

    @Test
    fun `GetAttachment variables forward attachmentId at top level`() {
        val vars = GetAttachment.variables(GetAttachment.Input(attachmentId = "att-1"))
        assertThat(vars["attachmentId"]).isEqualTo("att-1")
    }

    // -- ExplainTransaction --------------------------------------------------

    @Test
    fun `ExplainTransaction parses explanation text from envelope`() {
        val data = jsonNode("""{"explainTransaction": {"explanation": "Recurring monthly subscription."}}""")
        val out = ExplainTransaction.parseOutput(data)
        assertThat(out.explanation).isEqualTo("Recurring monthly subscription.")
    }

    @Test
    fun `ExplainTransaction returns null explanation when payload missing`() {
        val empty = ExplainTransaction.parseOutput(jsonNode("""{"explainTransaction": {}}"""))
        assertThat(empty.explanation).isNull()
        val noKey = ExplainTransaction.parseOutput(jsonNode("""{}"""))
        assertThat(noKey.explanation).isNull()
    }

    @Test
    fun `ExplainTransaction variables forward id at top level`() {
        val vars = ExplainTransaction.variables(ExplainTransaction.Input(id = "t-9"))
        assertThat(vars).containsExactlyEntriesOf(mapOf("id" to "t-9"))
    }

    // -- GetAccountsForTransactionFilter -------------------------------------

    @Test
    fun `GetAccountsForTransactionFilter parses every nested ref field`() {
        val data =
            jsonNode(
                """
                {
                  "getAccountsForTransactions": [
                    {
                      "id": "a-1",
                      "displayName": "Checking",
                      "dataProvider": "plaid",
                      "icon": "🏦",
                      "logoUrl": "https://cdn/chase.png",
                      "type": {"name": "depository", "display": "Depository"},
                      "subtype": {"name": "checking"},
                      "institution": {"id": "inst-1", "logo": "https://cdn/chase.png", "primaryColor": "#0066B2"}
                    },
                    {"id": "a-2"}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetAccountsForTransactionFilter.parseOutput(data)
        assertThat(out.accounts).hasSize(2)
        assertThat(out.accounts[0].id).isEqualTo("a-1")
        assertThat(out.accounts[0].displayName).isEqualTo("Checking")
        assertThat(out.accounts[0].dataProvider).isEqualTo("plaid")
        assertThat(out.accounts[0].typeName).isEqualTo("depository")
        assertThat(out.accounts[0].subtypeName).isEqualTo("checking")
        assertThat(out.accounts[0].institutionId).isEqualTo("inst-1")
        assertThat(out.accounts[0].institutionPrimaryColor).isEqualTo("#0066B2")
        assertThat(out.accounts[1].displayName).isNull()
        assertThat(out.accounts[1].institutionId).isNull()
    }

    @Test
    fun `GetAccountsForTransactionFilter returns empty list when query result missing`() {
        val out = GetAccountsForTransactionFilter.parseOutput(jsonNode("""{}"""))
        assertThat(out.accounts).isEmpty()
    }

    @Test
    fun `GetAccountsForTransactionFilter variables embed dates in filters and set selectors to null and isAllSelected true`() {
        val both =
            GetAccountsForTransactionFilter.variables(
                GetAccountsForTransactionFilter.Input(
                    startDate = LocalDate.of(2026, 5, 1),
                    endDate = LocalDate.of(2026, 5, 31),
                ),
            )
        assertThat(both["selectedTransactionIds"]).isNull()
        assertThat(both["excludedTransactionIds"]).isNull()
        assertThat(both["isAllSelected"]).isEqualTo(true)

        @Suppress("UNCHECKED_CAST")
        val filters = both["filters"] as Map<String, Any?>
        assertThat(filters["startDate"]).isEqualTo("2026-05-01")
        assertThat(filters["endDate"]).isEqualTo("2026-05-31")

        val none = GetAccountsForTransactionFilter.variables(GetAccountsForTransactionFilter.Input(null, null))

        @Suppress("UNCHECKED_CAST")
        val noneFilters = none["filters"] as Map<String, Any?>
        assertThat(noneFilters).isEmpty()
    }

    // -- GetCashflowDashboard ------------------------------------------------

    @Test
    fun `GetCashflowDashboard parses every day with non-blank groupBy day`() {
        val data =
            jsonNode(
                """
                {
                  "byDay": [
                    {"groupBy": {"day": "2026-05-01"}, "summary": {"sumExpense": -42.5}},
                    {"groupBy": {"day": "2026-05-02"}, "summary": {"sumExpense": -19.99}}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetCashflowDashboard.parseOutput(data)
        assertThat(out.byDay).hasSize(2)
        assertThat(out.byDay[0].day).isEqualTo(LocalDate.of(2026, 5, 1))
        assertThat(out.byDay[0].sumExpense).isEqualTo(-42.5)
        assertThat(out.byDay[1].sumExpense).isEqualTo(-19.99)
    }

    @Test
    fun `GetCashflowDashboard skips entries with blank groupBy day`() {
        val data =
            jsonNode(
                """
                {
                  "byDay": [
                    {"groupBy": {"day": ""}, "summary": {"sumExpense": -100.0}},
                    {"groupBy": {"day": "2026-05-03"}, "summary": {"sumExpense": -25.0}}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetCashflowDashboard.parseOutput(data)
        assertThat(out.byDay).hasSize(1)
        assertThat(out.byDay[0].day).isEqualTo(LocalDate.of(2026, 5, 3))
    }

    @Test
    fun `GetCashflowDashboard returns empty byDay when payload missing`() {
        val out = GetCashflowDashboard.parseOutput(jsonNode("""{}"""))
        assertThat(out.byDay).isEmpty()
    }

    @Test
    fun `GetCashflowDashboard variables emit dates under filters when set and an empty map when null`() {
        val both =
            GetCashflowDashboard.variables(
                GetCashflowDashboard.Input(LocalDate.of(2026, 5, 1), LocalDate.of(2026, 5, 31)),
            )

        @Suppress("UNCHECKED_CAST")
        val filters = both["filters"] as Map<String, Any?>
        assertThat(filters["startDate"]).isEqualTo("2026-05-01")
        assertThat(filters["endDate"]).isEqualTo("2026-05-31")

        val none = GetCashflowDashboard.variables(GetCashflowDashboard.Input(null, null))

        @Suppress("UNCHECKED_CAST")
        val noneFilters = none["filters"] as Map<String, Any?>
        assertThat(noneFilters).isEmpty()
    }

    // -- GetCashflowTimeframe ------------------------------------------------

    @Test
    fun `GetCashflowTimeframe parses bucket lists for each timeframe`() {
        val data =
            jsonNode(
                """
                {
                  "byYear": [
                    {"groupBy": {"year": "2026"}, "summary": {"sumIncome": 100000.0, "sumExpense": -60000.0, "savings": 40000.0, "savingsRate": 0.4}}
                  ],
                  "byMonth": [
                    {"groupBy": {"month": "2026-05-01"}, "summary": {"sumIncome": 8500.0, "sumExpense": -4200.0, "savings": 4300.0, "savingsRate": 0.51}}
                  ],
                  "byQuarter": [
                    {"groupBy": {"quarter": "2026-Q2"}, "summary": {"sumIncome": 25500.0, "sumExpense": -12500.0, "savings": 13000.0, "savingsRate": 0.51}}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetCashflowTimeframe.parseOutput(data)
        assertThat(out.byYear).hasSize(1)
        assertThat(out.byYear[0].period).isEqualTo("2026")
        assertThat(out.byYear[0].sumIncome).isEqualTo(100000.0)
        assertThat(out.byMonth[0].period).isEqualTo("2026-05-01")
        assertThat(out.byMonth[0].savingsRate).isEqualTo(0.51)
        assertThat(out.byQuarter[0].period).isEqualTo("2026-Q2")
    }

    @Test
    fun `GetCashflowTimeframe defaults to empty lists when missing`() {
        val out = GetCashflowTimeframe.parseOutput(jsonNode("""{}"""))
        assertThat(out.byYear).isEmpty()
        assertThat(out.byMonth).isEmpty()
        assertThat(out.byQuarter).isEmpty()
    }

    @Test
    fun `GetCashflowTimeframe variables embed dates under filters`() {
        val vars =
            GetCashflowTimeframe.variables(
                GetCashflowTimeframe.Input(LocalDate.of(2026, 1, 1), LocalDate.of(2026, 12, 31)),
            )

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters["startDate"]).isEqualTo("2026-01-01")
        assertThat(filters["endDate"]).isEqualTo("2026-12-31")
    }

    // -- GetCashflowEntities -------------------------------------------------

    @Test
    fun `GetCashflowEntities parses category, group, merchant rows and summary`() {
        val data =
            jsonNode(
                """
                {
                  "byCategory": [
                    {"groupBy": {"category": {"id": "c-1", "name": "Groceries", "icon": "🛒", "group": {"id": "g-1", "type": "expense"}}}, "summary": {"sum": -350.5}}
                  ],
                  "byCategoryGroup": [
                    {"groupBy": {"categoryGroup": {"id": "g-1", "name": "Food", "type": "expense"}}, "summary": {"sum": -1200.0}}
                  ],
                  "byMerchant": [
                    {"groupBy": {"merchant": {"id": "m-1", "name": "Whole Foods", "logoUrl": "https://cdn/wf.png"}}, "summary": {"sumIncome": 0.0, "sumExpense": -350.5}}
                  ],
                  "summary": {"summary": {"sumIncome": 9000.0, "sumExpense": -5000.0, "savings": 4000.0, "savingsRate": 0.44}}
                }
                """.trimIndent(),
            )
        val out = GetCashflowEntities.parseOutput(data)
        assertThat(out.byCategory).hasSize(1)
        assertThat(out.byCategory[0].category.id).isEqualTo("c-1")
        assertThat(out.byCategory[0].category.groupId).isEqualTo("g-1")
        assertThat(out.byCategory[0].sum).isEqualTo(-350.5)
        assertThat(out.byCategoryGroup).hasSize(1)
        assertThat(out.byCategoryGroup[0].categoryGroup.name).isEqualTo("Food")
        assertThat(out.byMerchant).hasSize(1)
        assertThat(out.byMerchant[0].merchant.logoUrl).isEqualTo("https://cdn/wf.png")
        assertThat(out.byMerchant[0].sumExpense).isEqualTo(-350.5)
        assertThat(out.summary).isNotNull
        assertThat(out.summary!!.savings).isEqualTo(4000.0)
        assertThat(out.summary.savingsRate).isEqualTo(0.44)
    }

    @Test
    fun `GetCashflowEntities defaults to empty lists and null summary when payload empty`() {
        val out = GetCashflowEntities.parseOutput(jsonNode("""{}"""))
        assertThat(out.byCategory).isEmpty()
        assertThat(out.byCategoryGroup).isEmpty()
        assertThat(out.byMerchant).isEmpty()
        assertThat(out.summary).isNull()
    }

    @Test
    fun `GetCashflowEntities variables embed dates under filters`() {
        val vars =
            GetCashflowEntities.variables(
                GetCashflowEntities.Input(LocalDate.of(2026, 5, 1), null),
            )

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters["startDate"]).isEqualTo("2026-05-01")
        assertThat(filters).doesNotContainKey("endDate")
    }

    // -- GetCashflowFiltered -------------------------------------------------

    @Test
    fun `GetCashflowFiltered composes summary, timeframe buckets, and entity rows`() {
        val data =
            jsonNode(
                """
                {
                  "summary": {"summary": {"sumIncome": 8500.0, "sumExpense": -4200.0, "savings": 4300.0, "savingsRate": 0.51}},
                  "byYear": [{"groupBy": {"year": "2026"}, "summary": {"sumIncome": 100000.0}}],
                  "byMonth": [{"groupBy": {"month": "2026-05-01"}, "summary": {"sumIncome": 8500.0}}],
                  "byQuarter": [{"groupBy": {"quarter": "2026-Q2"}, "summary": {"sumIncome": 25500.0}}],
                  "byCategory": [{"groupBy": {"category": {"id": "c-1", "name": "Food"}}, "summary": {"sum": -350.0}}],
                  "byCategoryGroup": [{"groupBy": {"categoryGroup": {"id": "g-1", "name": "Food", "type": "expense"}}, "summary": {"sum": -1200.0}}],
                  "byMerchant": [{"groupBy": {"merchant": {"id": "m-1", "name": "Whole Foods"}}, "summary": {"sumExpense": -350.0}}]
                }
                """.trimIndent(),
            )
        val out = GetCashflowFiltered.parseOutput(data)
        assertThat(out.summary).isNotNull
        assertThat(out.summary!!.savings).isEqualTo(4300.0)
        assertThat(out.byYear).hasSize(1)
        assertThat(out.byYear!![0].period).isEqualTo("2026")
        assertThat(out.byMonth).hasSize(1)
        assertThat(out.byMonth!![0].period).isEqualTo("2026-05-01")
        assertThat(out.byQuarter).hasSize(1)
        assertThat(out.byCategory).hasSize(1)
        assertThat(out.byCategory!![0].category.id).isEqualTo("c-1")
        assertThat(out.byCategoryGroup).hasSize(1)
        assertThat(out.byMerchant).hasSize(1)
    }

    @Test
    fun `GetCashflowFiltered defaults summary to null when payload empty`() {
        val out = GetCashflowFiltered.parseOutput(jsonNode("""{}"""))
        assertThat(out.summary).isNull()
        assertThat(out.byYear).isEmpty()
        assertThat(out.byMonth).isEmpty()
        assertThat(out.byQuarter).isEmpty()
    }

    @Test
    fun `GetCashflowFiltered variables forward each id list and the date range at top level`() {
        val vars =
            GetCashflowFiltered.variables(
                GetCashflowFiltered.Input(
                    startDate = LocalDate.of(2026, 5, 1),
                    endDate = LocalDate.of(2026, 5, 31),
                    accounts = listOf("a-1"),
                    categories = listOf("c-1", "c-2"),
                    categoryGroups = listOf("g-1"),
                    merchants = listOf("m-1"),
                    tags = listOf("t-1"),
                ),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-05-01")
        assertThat(vars["endDate"]).isEqualTo("2026-05-31")
        assertThat(vars["accounts"]).isEqualTo(listOf("a-1"))
        assertThat(vars["categories"]).isEqualTo(listOf("c-1", "c-2"))
        assertThat(vars["categoryGroups"]).isEqualTo(listOf("g-1"))
        assertThat(vars["merchants"]).isEqualTo(listOf("m-1"))
        assertThat(vars["tags"]).isEqualTo(listOf("t-1"))

        val nulls =
            GetCashflowFiltered.variables(
                GetCashflowFiltered.Input(null, null, null, null, null, null, null),
            )
        assertThat(nulls).containsEntry("startDate", null).containsEntry("accounts", null)
    }

    // -- GetTransactionsDashboard --------------------------------------------

    @Test
    fun `GetTransactionsDashboard parses totals, ruleCount, summaryCount, and row refs`() {
        val data =
            jsonNode(
                """
                {
                  "allTransactions": {
                    "totalCount": 42,
                    "totalSelectableCount": 38,
                    "results": [
                      {
                        "id": "t-1",
                        "date": "2026-05-25",
                        "amount": -19.99,
                        "notes": "coffee",
                        "plaidName": "STARBUCKS #123",
                        "merchant": {"name": "Starbucks"},
                        "category": {"name": "Coffee"},
                        "account": {"displayName": "Acme Bank"}
                      }
                    ]
                  },
                  "transactionRules": [{"id": "r-1"}, {"id": "r-2"}],
                  "aggregates": {"summary": {"count": 42}}
                }
                """.trimIndent(),
            )
        val out = GetTransactionsDashboard.parseOutput(data)
        assertThat(out.totalCount).isEqualTo(42)
        assertThat(out.totalSelectableCount).isEqualTo(38)
        assertThat(out.ruleCount).isEqualTo(2)
        assertThat(out.summaryCount).isEqualTo(42)
        assertThat(out.results).hasSize(1)
        val row = out.results.single()
        assertThat(row.id).isEqualTo("t-1")
        assertThat(row.date).isEqualTo(LocalDate.of(2026, 5, 25))
        assertThat(row.amount).isEqualTo(-19.99)
        assertThat(row.merchantName).isEqualTo("Starbucks")
        assertThat(row.categoryName).isEqualTo("Coffee")
        assertThat(row.accountDisplayName).isEqualTo("Acme Bank")
        assertThat(row.plaidName).isEqualTo("STARBUCKS #123")
        assertThat(row.notes).isEqualTo("coffee")
    }

    @Test
    fun `GetTransactionsDashboard defaults to empty results and nulls when payload empty`() {
        val out = GetTransactionsDashboard.parseOutput(jsonNode("""{}"""))
        assertThat(out.totalCount).isNull()
        assertThat(out.totalSelectableCount).isNull()
        assertThat(out.ruleCount).isNull()
        assertThat(out.summaryCount).isNull()
        assertThat(out.results).isEmpty()
    }

    @Test
    fun `GetTransactionsDashboard variables emit pagination at top level and dates under filters`() {
        val vars =
            GetTransactionsDashboard.variables(
                GetTransactionsDashboard.Input(
                    startDate = LocalDate.of(2026, 5, 1),
                    endDate = LocalDate.of(2026, 5, 31),
                    limit = 25,
                    offset = 50,
                ),
            )
        assertThat(vars["limit"]).isEqualTo(25)
        assertThat(vars["offset"]).isEqualTo(50)

        @Suppress("UNCHECKED_CAST")
        val filters = vars["filters"] as Map<String, Any?>
        assertThat(filters["startDate"]).isEqualTo("2026-05-01")
        assertThat(filters["endDate"]).isEqualTo("2026-05-31")
    }
}
