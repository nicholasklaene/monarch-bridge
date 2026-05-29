package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.loadFixture
import com.nicholasklaene.monarchbridge.generated.model.CreateManualAccountRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class AccountOperationTest {
    // -- GetAccounts -------------------------------------------------------

    @Test
    fun `GetAccounts parses every Account field through JsonMappers`() {
        val data = loadFixture("getAccounts/multi-type")
        val out = GetAccounts.parseOutput(data)
        assertThat(out.accounts).hasSize(2)
        val a = out.accounts[0]
        assertThat(a.id).isEqualTo("a-1")
        assertThat(a.displayName).isEqualTo("Checking")
        assertThat(a.type).isEqualTo("depository")
        assertThat(a.subtype).isEqualTo("checking")
        assertThat(a.mask).isEqualTo("1234")
        assertThat(a.currentBalance).isEqualTo(1234.56)
        assertThat(a.displayBalance).isEqualTo(1200.00)
        assertThat(a.isHidden).isFalse()
        assertThat(a.includeInNetWorth).isTrue()
        assertThat(a.isAsset).isTrue()
        assertThat(a.isManual).isFalse()
        assertThat(a.institution?.name).isEqualTo("Chase")
        assertThat(a.institution?.id).isEqualTo("i-1")
        assertThat(a.institution?.primaryColor).isEqualTo("#0F0")
        assertThat(a.institution?.url).isEqualTo("chase.com")
        assertThat(a.institution?.plaidInstitutionId).isEqualTo("ins_56")

        val b = out.accounts[1]
        assertThat(b.id).isEqualTo("a-2")
        assertThat(b.currentBalance).isEqualTo(-842.10)
        assertThat(b.isAsset).isFalse()
        assertThat(b.isManual).isTrue()
        assertThat(b.institution).isNull()
    }

    @Test
    fun `GetAccounts is tolerant of missing optional subtrees and empty arrays`() {
        val bareData = jsonNode("""{"accounts":[{"id":"a-bare","displayName":"Bare"}]}""")
        val bareOut = GetAccounts.parseOutput(bareData)
        assertThat(bareOut.accounts).hasSize(1)
        val bare = bareOut.accounts.first()
        assertThat(bare.id).isEqualTo("a-bare")
        assertThat(bare.displayName).isEqualTo("Bare")
        assertThat(bare.type).isNull()
        assertThat(bare.subtype).isNull()
        assertThat(bare.mask).isNull()
        assertThat(bare.currentBalance).isNull()
        assertThat(bare.institution).isNull()

        val emptyOut = GetAccounts.parseOutput(jsonNode("""{"accounts":[]}"""))
        assertThat(emptyOut.accounts).isEmpty()

        val missingOut = GetAccounts.parseOutput(jsonNode("""{}"""))
        assertThat(missingOut.accounts).isEmpty()
    }

    // -- GetInstitutions ---------------------------------------------------

    @Test
    fun `GetInstitutions passes through free-form credentials, accounts, and subscription maps`() {
        val data =
            jsonNode(
                """
                {
                  "credentials": [
                    {"id": "cred-1", "updateRequired": false, "disconnectedFromDataProviderAt": null,
                     "institution": {"id": "i-1", "name": "Chase", "plaidInstitutionId": "ins_56"}},
                    {"id": "cred-2", "updateRequired": true,
                     "institution": {"id": "i-2", "name": "Vanguard"}}
                  ],
                  "accounts": [
                    {"id": "a-1", "displayName": "Checking", "isManual": false},
                    {"id": "a-2", "displayName": "Manual cash", "isManual": true}
                  ],
                  "subscription": {"isOnFreeTrial": false, "hasPremiumEntitlement": true}
                }
                """.trimIndent(),
            )
        val out = GetInstitutions.parseOutput(data)
        assertThat(out.credentials).hasSize(2)
        assertThat(out.credentials[0]["id"]).isEqualTo("cred-1")
        assertThat(out.credentials[0]["updateRequired"]).isEqualTo(false)
        @Suppress("UNCHECKED_CAST")
        val inst0 = out.credentials[0]["institution"] as Map<String, Any>
        assertThat(inst0["name"]).isEqualTo("Chase")
        assertThat(inst0["plaidInstitutionId"]).isEqualTo("ins_56")
        assertThat(out.credentials[1]["id"]).isEqualTo("cred-2")
        assertThat(out.credentials[1]["updateRequired"]).isEqualTo(true)

        assertThat(out.accounts).hasSize(2)
        assertThat(out.accounts[0]["displayName"]).isEqualTo("Checking")
        assertThat(out.accounts[1]["isManual"]).isEqualTo(true)

        assertThat(out.subscription).isNotNull
        assertThat(out.subscription?.get("hasPremiumEntitlement")).isEqualTo(true)
        assertThat(out.subscription?.get("isOnFreeTrial")).isEqualTo(false)
    }

    @Test
    fun `GetInstitutions tolerates missing or null subscription and empty arrays`() {
        val nullSub = jsonNode("""{"credentials":[],"accounts":[],"subscription":null}""")
        val out = GetInstitutions.parseOutput(nullSub)
        assertThat(out.credentials).isEmpty()
        assertThat(out.accounts).isEmpty()
        assertThat(out.subscription).isNull()

        val missingSub = jsonNode("""{"credentials":[{"id":"x"}],"accounts":[]}""")
        val out2 = GetInstitutions.parseOutput(missingSub)
        assertThat(out2.credentials).hasSize(1)
        assertThat(out2.accounts).isEmpty()
        assertThat(out2.subscription).isNull()
    }

    // -- GetAccountTypeOptions ---------------------------------------------

    @Test
    fun `GetAccountTypeOptions passes through accountTypeOptions list of maps`() {
        val data =
            jsonNode(
                """
                {
                  "accountTypeOptions": [
                    {
                      "type": {"name": "depository", "display": "Cash"},
                      "subtypes": [
                        {"name": "checking", "display": "Checking"},
                        {"name": "savings", "display": "Savings"}
                      ]
                    },
                    {
                      "type": {"name": "brokerage", "display": "Investments"},
                      "subtypes": [{"name": "401k", "display": "401k"}]
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetAccountTypeOptions.parseOutput(data)
        assertThat(out.accountTypeOptions).hasSize(2)
        @Suppress("UNCHECKED_CAST")
        val depositoryType = out.accountTypeOptions[0]["type"] as Map<String, Any>
        assertThat(depositoryType["name"]).isEqualTo("depository")
        assertThat(depositoryType["display"]).isEqualTo("Cash")
        @Suppress("UNCHECKED_CAST")
        val depositorySubtypes = out.accountTypeOptions[0]["subtypes"] as List<Map<String, Any>>
        assertThat(depositorySubtypes).hasSize(2)
        assertThat(depositorySubtypes[0]["name"]).isEqualTo("checking")
        assertThat(depositorySubtypes[1]["name"]).isEqualTo("savings")
        @Suppress("UNCHECKED_CAST")
        val brokerageType = out.accountTypeOptions[1]["type"] as Map<String, Any>
        assertThat(brokerageType["name"]).isEqualTo("brokerage")
    }

    @Test
    fun `GetAccountTypeOptions returns empty list when accountTypeOptions missing or empty`() {
        val emptyOut = GetAccountTypeOptions.parseOutput(jsonNode("""{"accountTypeOptions":[]}"""))
        assertThat(emptyOut.accountTypeOptions).isEmpty()
        assertThat(emptyOut.accountTypeOptions).isInstanceOf(List::class.java)

        val missingOut = GetAccountTypeOptions.parseOutput(jsonNode("""{}"""))
        assertThat(missingOut.accountTypeOptions).isEmpty()
        assertThat(missingOut.accountTypeOptions).isInstanceOf(List::class.java)
    }

    // -- GetAccountHistory -------------------------------------------------

    @Test
    fun `GetAccountHistory parses account, recentTransactions, and snapshots`() {
        val data =
            jsonNode(
                """
                {
                  "account": {
                    "id": "a-99",
                    "displayName": "8811 Mortgage",
                    "type": {"name": "loan"},
                    "subtype": {"name": "mortgage"},
                    "currentBalance": -250000.00,
                    "isAsset": false,
                    "isManual": false,
                    "institution": {"id": "i-9", "name": "Wells Fargo"}
                  },
                  "transactions": {
                    "totalCount": 2,
                    "results": [
                      {
                        "id": "t-1",
                        "date": "2026-05-20",
                        "amount": -1234.56,
                        "pending": false,
                        "plaidName": "MORTGAGE PMT",
                        "notes": "auto-pay",
                        "hideFromReports": false,
                        "needsReview": false,
                        "isRecurring": true,
                        "isSplitTransaction": false,
                        "account": {"id": "a-99", "displayName": "8811 Mortgage"},
                        "merchant": {"id": "m-1", "name": "Wells Fargo", "transactionsCount": 12},
                        "category": {"id": "c-1", "name": "Mortgage"},
                        "tags": [{"id": "tag-1", "name": "8811", "color": "#ff0000"}]
                      },
                      {
                        "id": "t-2",
                        "date": "2026-05-01",
                        "amount": -1234.56
                      }
                    ]
                  },
                  "snapshots": [
                    {"date": "2026-05-01", "signedBalance": -250500.00},
                    {"date": "2026-05-15", "signedBalance": -250250.00}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetAccountHistory.parseOutput(data)
        assertThat(out.account).isNotNull
        assertThat(out.account?.id).isEqualTo("a-99")
        assertThat(out.account?.displayName).isEqualTo("8811 Mortgage")
        assertThat(out.account?.type).isEqualTo("loan")
        assertThat(out.account?.currentBalance).isEqualTo(-250000.00)
        assertThat(out.account?.institution?.name).isEqualTo("Wells Fargo")

        assertThat(out.recentTransactions).hasSize(2)
        val t = out.recentTransactions[0]
        assertThat(t.id).isEqualTo("t-1")
        assertThat(t.date).isEqualTo(LocalDate.parse("2026-05-20"))
        assertThat(t.amount).isEqualTo(-1234.56)
        assertThat(t.isRecurring).isTrue()
        assertThat(t.plaidName).isEqualTo("MORTGAGE PMT")
        assertThat(t.account?.id).isEqualTo("a-99")
        assertThat(t.merchant?.name).isEqualTo("Wells Fargo")
        assertThat(t.category?.name).isEqualTo("Mortgage")
        assertThat(t.tags).hasSize(1)
        assertThat(t.tags?.first()?.name).isEqualTo("8811")

        assertThat(out.snapshots).hasSize(2)
        assertThat(out.snapshots[0].date).isEqualTo(LocalDate.parse("2026-05-01"))
        assertThat(out.snapshots[0].balance).isEqualTo(-250500.00)
        assertThat(out.snapshots[1].balance).isEqualTo(-250250.00)
    }

    @Test
    fun `GetAccountHistory handles null account, empty transactions, and empty snapshots`() {
        val data =
            jsonNode(
                """
                {
                  "account": null,
                  "transactions": {"totalCount": 0, "results": []},
                  "snapshots": []
                }
                """.trimIndent(),
            )
        val out = GetAccountHistory.parseOutput(data)
        assertThat(out.account).isNull()
        assertThat(out.recentTransactions).isEmpty()
        assertThat(out.snapshots).isEmpty()

        val missingOut = GetAccountHistory.parseOutput(jsonNode("""{}"""))
        assertThat(missingOut.account).isNull()
        assertThat(missingOut.recentTransactions).isEmpty()
        assertThat(missingOut.snapshots).isEmpty()
    }

    // -- GetAccountHoldings ------------------------------------------------

    @Test
    fun `GetAccountHoldings parses every Holding from portfolio aggregateHoldings edges`() {
        val data =
            jsonNode(
                """
                {
                  "portfolio": {
                    "aggregateHoldings": {
                      "edges": [
                        {
                          "node": {
                            "id": "h-1",
                            "quantity": 100.0,
                            "basis": 15000.00,
                            "totalValue": 18250.50,
                            "security": {
                              "id": "sec-1",
                              "ticker": "VTI",
                              "name": "Vanguard Total Stock Market",
                              "type": "etf",
                              "currentPrice": 182.505
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "h-2",
                            "quantity": 25.5,
                            "basis": 5000.00,
                            "totalValue": 6125.75,
                            "security": {
                              "id": "sec-2",
                              "ticker": "AAPL",
                              "name": "Apple Inc.",
                              "type": "equity",
                              "currentPrice": 240.225
                            }
                          }
                        }
                      ]
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = GetAccountHoldings.parseOutput(data)
        assertThat(out.holdings).hasSize(2)
        val h0 = out.holdings[0]
        assertThat(h0.id).isEqualTo("h-1")
        assertThat(h0.ticker).isEqualTo("VTI")
        assertThat(h0.name).isEqualTo("Vanguard Total Stock Market")
        assertThat(h0.type).isEqualTo("etf")
        assertThat(h0.totalValue).isEqualTo(18250.50)
        assertThat(h0.totalQuantity).isEqualTo(100.0)
        assertThat(h0.costBasis).isEqualTo(15000.00)
        assertThat(h0.lastPrice).isEqualTo(182.505)

        val h1 = out.holdings[1]
        assertThat(h1.ticker).isEqualTo("AAPL")
        assertThat(h1.totalQuantity).isEqualTo(25.5)
        assertThat(h1.costBasis).isEqualTo(5000.00)
        assertThat(h1.lastPrice).isEqualTo(240.225)
    }

    @Test
    fun `GetAccountHoldings tolerates empty edges and missing security subtrees`() {
        val emptyEdges = jsonNode("""{"portfolio":{"aggregateHoldings":{"edges":[]}}}""")
        val emptyOut = GetAccountHoldings.parseOutput(emptyEdges)
        assertThat(emptyOut.holdings).isEmpty()

        val missingPortfolio = GetAccountHoldings.parseOutput(jsonNode("""{}"""))
        assertThat(missingPortfolio.holdings).isEmpty()

        val sparse =
            jsonNode(
                """
                {
                  "portfolio": {
                    "aggregateHoldings": {
                      "edges": [
                        {"node": {"id": "h-bare", "totalValue": 100.0}}
                      ]
                    }
                  }
                }
                """.trimIndent(),
            )
        val sparseOut = GetAccountHoldings.parseOutput(sparse)
        assertThat(sparseOut.holdings).hasSize(1)
        val h = sparseOut.holdings.first()
        assertThat(h.id).isEqualTo("h-bare")
        assertThat(h.totalValue).isEqualTo(100.0)
        assertThat(h.ticker).isNull()
        assertThat(h.name).isNull()
        assertThat(h.type).isNull()
        assertThat(h.lastPrice).isNull()
        assertThat(h.costBasis).isNull()
        assertThat(h.totalQuantity).isNull()
    }

    // -- GetAggregateSnapshots ---------------------------------------------

    @Test
    fun `GetAggregateSnapshots parses date, balance, assetsBalance, liabilitiesBalance`() {
        val data =
            jsonNode(
                """
                {
                  "aggregateSnapshots": [
                    {"date": "2026-05-01", "balance": 125000.00, "assetsBalance": 425000.00, "liabilitiesBalance": -300000.00},
                    {"date": "2026-05-25", "balance": 130250.50, "assetsBalance": 430250.50, "liabilitiesBalance": -300000.00}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetAggregateSnapshots.parseOutput(data)
        assertThat(out.aggregateSnapshots).hasSize(2)
        val s = out.aggregateSnapshots[0]
        assertThat(s.date).isEqualTo(LocalDate.parse("2026-05-01"))
        assertThat(s.balance).isEqualTo(125000.00)
        assertThat(s.assetsBalance).isEqualTo(425000.00)
        assertThat(s.liabilitiesBalance).isEqualTo(-300000.00)
        assertThat(out.aggregateSnapshots[1].date).isEqualTo(LocalDate.parse("2026-05-25"))
        assertThat(out.aggregateSnapshots[1].balance).isEqualTo(130250.50)
    }

    @Test
    fun `GetAggregateSnapshots treats missing assets and liabilities as null`() {
        val data =
            jsonNode(
                """
                {
                  "aggregateSnapshots": [
                    {"date": "2026-04-01", "balance": 100000.00}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetAggregateSnapshots.parseOutput(data)
        assertThat(out.aggregateSnapshots).hasSize(1)
        val s = out.aggregateSnapshots.first()
        assertThat(s.date).isEqualTo(LocalDate.parse("2026-04-01"))
        assertThat(s.balance).isEqualTo(100000.00)
        assertThat(s.assetsBalance).isNull()
        assertThat(s.liabilitiesBalance).isNull()

        val emptyOut = GetAggregateSnapshots.parseOutput(jsonNode("""{"aggregateSnapshots":[]}"""))
        assertThat(emptyOut.aggregateSnapshots).isEmpty()
    }

    // -- GetRecentAccountBalances ------------------------------------------

    @Test
    fun `GetRecentAccountBalances parses id, displayName, recentBalances list`() {
        val data =
            jsonNode(
                """
                {
                  "accounts": [
                    {"id": "a-1", "displayName": "Checking", "recentBalances": [1000.00, 1100.50, 1050.25, 1200.00]},
                    {"id": "a-2", "displayName": "Brokerage", "recentBalances": [50000.00, 51234.56]}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetRecentAccountBalances.parseOutput(data)
        assertThat(out.accounts).hasSize(2)
        val a = out.accounts[0]
        assertThat(a.id).isEqualTo("a-1")
        assertThat(a.displayName).isEqualTo("Checking")
        assertThat(a.recentBalances).containsExactly(1000.00, 1100.50, 1050.25, 1200.00)
        val b = out.accounts[1]
        assertThat(b.id).isEqualTo("a-2")
        assertThat(b.displayName).isEqualTo("Brokerage")
        assertThat(b.recentBalances).containsExactly(50000.00, 51234.56)
    }

    @Test
    fun `GetRecentAccountBalances handles empty arrays and missing displayName`() {
        val data =
            jsonNode(
                """
                {
                  "accounts": [
                    {"id": "a-bare", "recentBalances": []}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetRecentAccountBalances.parseOutput(data)
        assertThat(out.accounts).hasSize(1)
        val a = out.accounts.first()
        assertThat(a.id).isEqualTo("a-bare")
        assertThat(a.displayName).isNull()
        assertThat(a.recentBalances).isEmpty()

        val missingOut = GetRecentAccountBalances.parseOutput(jsonNode("""{}"""))
        assertThat(missingOut.accounts).isEmpty()
    }

    // -- GetSnapshotsByAccountType -----------------------------------------

    @Test
    fun `GetSnapshotsByAccountType parses snapshotsByAccountType and accountTypes`() {
        val data =
            jsonNode(
                """
                {
                  "snapshotsByAccountType": [
                    {"month": "2026-04-01", "accountType": "real_estate", "balance": 350000.00},
                    {"month": "2026-05-01", "accountType": "real_estate", "balance": 360000.00},
                    {"month": "2026-05-01", "accountType": "brokerage", "balance": 87500.50}
                  ],
                  "accountTypes": [
                    {"name": "real_estate", "group": "asset"},
                    {"name": "brokerage", "group": "asset"},
                    {"name": "loan", "group": "liability"}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetSnapshotsByAccountType.parseOutput(data)
        assertThat(out.snapshotsByAccountType).hasSize(3)
        val s = out.snapshotsByAccountType[0]
        assertThat(s.date).isEqualTo(LocalDate.parse("2026-04-01"))
        assertThat(s.accountType).isEqualTo("real_estate")
        assertThat(s.balance).isEqualTo(350000.00)
        assertThat(out.snapshotsByAccountType[2].accountType).isEqualTo("brokerage")
        assertThat(out.snapshotsByAccountType[2].balance).isEqualTo(87500.50)

        assertThat(out.accountTypes).hasSize(3)
        assertThat(out.accountTypes[0].name).isEqualTo("real_estate")
        assertThat(out.accountTypes[0].group).isEqualTo("asset")
        assertThat(out.accountTypes[0].display).isNull()
        assertThat(out.accountTypes[2].name).isEqualTo("loan")
        assertThat(out.accountTypes[2].group).isEqualTo("liability")
    }

    @Test
    fun `GetSnapshotsByAccountType handles missing group and empty arrays`() {
        val data =
            jsonNode(
                """
                {
                  "snapshotsByAccountType": [],
                  "accountTypes": [{"name": "depository"}]
                }
                """.trimIndent(),
            )
        val out = GetSnapshotsByAccountType.parseOutput(data)
        assertThat(out.snapshotsByAccountType).isEmpty()
        assertThat(out.accountTypes).hasSize(1)
        assertThat(out.accountTypes.first().name).isEqualTo("depository")
        assertThat(out.accountTypes.first().group).isNull()
        assertThat(out.accountTypes.first().display).isNull()

        val missingOut = GetSnapshotsByAccountType.parseOutput(jsonNode("""{}"""))
        assertThat(missingOut.snapshotsByAccountType).isEmpty()
        assertThat(missingOut.accountTypes).isEmpty()
    }

    // -- CreateManualAccount -----------------------------------------------

    @Test
    fun `CreateManualAccount parses accountId from createManualAccount account id`() {
        val data =
            jsonNode(
                """
                {
                  "createManualAccount": {
                    "account": {"id": "new-acct-123", "displayName": "Cash on hand"},
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = CreateManualAccount.parseOutput(data)
        assertThat(out.accountId).isEqualTo("new-acct-123")
        assertThat(out.accountId).isNotEmpty()
        assertThat(out).isInstanceOf(
            com.nicholasklaene.monarchbridge.generated.model.CreateManualAccountResponseData::class.java,
        )
    }

    @Test
    fun `CreateManualAccount returns empty accountId when account or id missing`() {
        val missingAccount =
            CreateManualAccount.parseOutput(
                jsonNode("""{"createManualAccount": {"account": null, "errors": []}}"""),
            )
        assertThat(missingAccount.accountId).isEqualTo("")

        val missingMutation = CreateManualAccount.parseOutput(jsonNode("""{}"""))
        assertThat(missingMutation.accountId).isEqualTo("")

        val missingId =
            CreateManualAccount.parseOutput(
                jsonNode("""{"createManualAccount": {"account": {"displayName": "no-id"}}}"""),
            )
        assertThat(missingId.accountId).isEqualTo("")
    }

    // -- UpdateAccount -----------------------------------------------------

    @Test
    fun `UpdateAccount parses full Account from updateAccount account subtree`() {
        val data =
            jsonNode(
                """
                {
                  "updateAccount": {
                    "account": {
                      "id": "a-1",
                      "displayName": "Renamed Checking",
                      "type": {"name": "depository"},
                      "subtype": {"name": "checking"},
                      "currentBalance": 9999.99,
                      "displayBalance": 9999.99,
                      "isHidden": false,
                      "hideFromList": true,
                      "includeInNetWorth": true,
                      "isAsset": true,
                      "isManual": false,
                      "institution": {"id": "i-1", "name": "Chase"}
                    },
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateAccount.parseOutput(data)
        assertThat(out.account.id).isEqualTo("a-1")
        assertThat(out.account.displayName).isEqualTo("Renamed Checking")
        assertThat(out.account.type).isEqualTo("depository")
        assertThat(out.account.subtype).isEqualTo("checking")
        assertThat(out.account.currentBalance).isEqualTo(9999.99)
        assertThat(out.account.displayBalance).isEqualTo(9999.99)
        assertThat(out.account.hideFromList).isTrue()
        assertThat(out.account.includeInNetWorth).isTrue()
        assertThat(out.account.institution?.name).isEqualTo("Chase")
    }

    @Test
    fun `UpdateAccount produces Account with default empty fields when account subtree missing`() {
        // Parser uses parseAccount which defaults id and displayName to empty string when absent.
        val out = UpdateAccount.parseOutput(jsonNode("""{"updateAccount": {}}"""))
        assertThat(out.account.id).isEqualTo("")
        assertThat(out.account.displayName).isEqualTo("")
        assertThat(out.account.institution).isNull()
        assertThat(out.account.currentBalance).isNull()
        assertThat(out.account.type).isNull()
        assertThat(out.account.subtype).isNull()
    }

    // -- DeleteAccount -----------------------------------------------------

    @Test
    fun `DeleteAccount returns deleted true when deleteAccount deleted true`() {
        val data = jsonNode("""{"deleteAccount": {"deleted": true}}""")
        val out = DeleteAccount.parseOutput(data)
        assertThat(out.deleted).isTrue()
        assertThat(out).isInstanceOf(
            com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData::class.java,
        )
    }

    @Test
    fun `DeleteAccount defaults to false when deleted flag is missing, explicit false, or whole mutation missing`() {
        val explicitFalse = DeleteAccount.parseOutput(jsonNode("""{"deleteAccount": {"deleted": false}}"""))
        assertThat(explicitFalse.deleted).isFalse()

        val missingFlag = DeleteAccount.parseOutput(jsonNode("""{"deleteAccount": {}}"""))
        assertThat(missingFlag.deleted).isFalse()

        val missingMutation = DeleteAccount.parseOutput(jsonNode("""{}"""))
        assertThat(missingMutation.deleted).isFalse()
    }

    // -- DeleteCredential --------------------------------------------------

    @Test
    fun `DeleteCredential returns deleted true when deleteCredential deleted true`() {
        val data = jsonNode("""{"deleteCredential": {"deleted": true}}""")
        val out = DeleteCredential.parseOutput(data)
        assertThat(out.deleted).isTrue()
        assertThat(out).isInstanceOf(
            com.nicholasklaene.monarchbridge.generated.model.DeleteInstitutionResponseData::class.java,
        )
    }

    @Test
    fun `DeleteCredential defaults to false when deleted flag is missing or whole mutation missing`() {
        val explicitFalse = DeleteCredential.parseOutput(jsonNode("""{"deleteCredential": {"deleted": false}}"""))
        assertThat(explicitFalse.deleted).isFalse()

        val missingFlag = DeleteCredential.parseOutput(jsonNode("""{"deleteCredential": {}}"""))
        assertThat(missingFlag.deleted).isFalse()

        val missingMutation = DeleteCredential.parseOutput(jsonNode("""{}"""))
        assertThat(missingMutation.deleted).isFalse()
    }

    // -- ParseUploadBalanceHistorySession ----------------------------------

    @Test
    fun `ParseUploadBalanceHistorySession parses sessionKey and status from parseBalanceHistory payload`() {
        val data =
            jsonNode(
                """
                {
                  "parseBalanceHistory": {
                    "uploadBalanceHistorySession": {
                      "sessionKey": "sess-abc-123",
                      "status": "parsing"
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = ParseUploadBalanceHistorySession.parseOutput(data)
        assertThat(out.sessionKey).isEqualTo("sess-abc-123")
        assertThat(out.status).isEqualTo("parsing")
        assertThat(out).isInstanceOf(SessionStatus::class.java)
    }

    @Test
    fun `ParseUploadBalanceHistorySession defaults sessionKey to empty and status to unknown when payload missing`() {
        val out = ParseUploadBalanceHistorySession.parseOutput(jsonNode("""{}"""))
        assertThat(out.sessionKey).isEqualTo("")
        assertThat(out.status).isEqualTo("unknown")
    }

    @Test
    fun `ParseUploadBalanceHistorySession defaults status to unknown when only sessionKey present`() {
        val data =
            jsonNode(
                """
                {
                  "parseBalanceHistory": {
                    "uploadBalanceHistorySession": {
                      "sessionKey": "sess-xyz"
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = ParseUploadBalanceHistorySession.parseOutput(data)
        assertThat(out.sessionKey).isEqualTo("sess-xyz")
        assertThat(out.status).isEqualTo("unknown")
    }

    // -- GetUploadBalanceHistorySession ------------------------------------

    @Test
    fun `GetUploadBalanceHistorySession parses sessionKey and status from uploadBalanceHistorySession`() {
        val data =
            jsonNode(
                """
                {
                  "uploadBalanceHistorySession": {
                    "sessionKey": "sess-poll-1",
                    "status": "completed"
                  }
                }
                """.trimIndent(),
            )
        val out = GetUploadBalanceHistorySession.parseOutput(data)
        assertThat(out.sessionKey).isEqualTo("sess-poll-1")
        assertThat(out.status).isEqualTo("completed")
        assertThat(out).isInstanceOf(SessionStatus::class.java)
    }

    @Test
    fun `GetUploadBalanceHistorySession defaults sessionKey to empty and status to unknown when payload missing`() {
        val out = GetUploadBalanceHistorySession.parseOutput(jsonNode("""{}"""))
        assertThat(out.sessionKey).isEqualTo("")
        assertThat(out.status).isEqualTo("unknown")
    }

    @Test
    fun `GetUploadBalanceHistorySession parses status-failed and other terminal states verbatim`() {
        val failedData =
            jsonNode("""{"uploadBalanceHistorySession": {"sessionKey": "sess-failed", "status": "failed"}}""")
        val failedOut = GetUploadBalanceHistorySession.parseOutput(failedData)
        assertThat(failedOut.sessionKey).isEqualTo("sess-failed")
        assertThat(failedOut.status).isEqualTo("failed")

        val pendingData =
            jsonNode("""{"uploadBalanceHistorySession": {"sessionKey": "sess-p", "status": "pending"}}""")
        val pendingOut = GetUploadBalanceHistorySession.parseOutput(pendingData)
        assertThat(pendingOut.status).isEqualTo("pending")
    }

    // -- BulkUpdateAccounts ------------------------------------------------

    @Test
    fun `BulkUpdateAccounts parses every Account from updateAccounts accounts list`() {
        val data =
            jsonNode(
                """
                {
                  "updateAccounts": {
                    "accounts": [
                      {
                        "id": "a-1",
                        "displayName": "Checking",
                        "type": {"name": "depository"},
                        "subtype": {"name": "checking"},
                        "currentBalance": 100.0,
                        "isHidden": false,
                        "hideFromList": false,
                        "includeInNetWorth": true,
                        "isAsset": true,
                        "isManual": false
                      },
                      {
                        "id": "a-2",
                        "displayName": "Vacation Fund",
                        "type": {"name": "depository"},
                        "subtype": {"name": "savings"},
                        "currentBalance": 5000.0,
                        "isHidden": true,
                        "hideFromList": true,
                        "includeInNetWorth": false,
                        "isAsset": true,
                        "isManual": true
                      }
                    ],
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = BulkUpdateAccounts.parseOutput(data)
        assertThat(out.accounts).hasSize(2)
        assertThat(out.accounts[0].id).isEqualTo("a-1")
        assertThat(out.accounts[0].displayName).isEqualTo("Checking")
        assertThat(out.accounts[0].includeInNetWorth).isTrue()
        assertThat(out.accounts[1].id).isEqualTo("a-2")
        assertThat(out.accounts[1].hideFromList).isTrue()
        assertThat(out.accounts[1].includeInNetWorth).isFalse()
    }

    @Test
    fun `BulkUpdateAccounts returns empty list when accounts missing or payload empty`() {
        val emptyAccounts = BulkUpdateAccounts.parseOutput(jsonNode("""{"updateAccounts": {"accounts": []}}"""))
        assertThat(emptyAccounts.accounts).isEmpty()

        val nullAccounts = BulkUpdateAccounts.parseOutput(jsonNode("""{"updateAccounts": {"accounts": null}}"""))
        assertThat(nullAccounts.accounts).isEmpty()

        val missing = BulkUpdateAccounts.parseOutput(jsonNode("""{}"""))
        assertThat(missing.accounts).isEmpty()
    }

    @Test
    fun `BulkUpdateAccounts variables wrap the entries list in the input key`() {
        val vars =
            BulkUpdateAccounts.variables(
                BulkUpdateAccounts.Input(
                    entries =
                        listOf(
                            mapOf("id" to "a-1", "name" to "Renamed"),
                            mapOf("id" to "a-2", "hideFromList" to true),
                        ),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val entries = vars["input"] as List<Map<String, Any?>>
        assertThat(entries).hasSize(2)
        assertThat(entries[0]["id"]).isEqualTo("a-1")
        assertThat(entries[0]["name"]).isEqualTo("Renamed")
        assertThat(entries[1]["hideFromList"]).isEqualTo(true)
    }

    @Test
    fun `BulkUpdateAccounts Input from preserves id and drops null entry fields`() {
        val req =
            com.nicholasklaene.monarchbridge.generated.model.BulkUpdateAccountsRequest(
                updates =
                    listOf(
                        com.nicholasklaene.monarchbridge.generated.model.BulkUpdateAccountsEntry(
                            id = "a-1",
                            name = "Renamed",
                            includeInNetWorth = false,
                        ),
                        com.nicholasklaene.monarchbridge.generated.model.BulkUpdateAccountsEntry(
                            id = "a-2",
                            displayBalance = 1234.56,
                            hideFromList = true,
                        ),
                    ),
            )
        val input = BulkUpdateAccounts.Input.from(req)
        assertThat(input.entries).hasSize(2)
        val e0 = input.entries[0]
        assertThat(e0["id"]).isEqualTo("a-1")
        assertThat(e0["name"]).isEqualTo("Renamed")
        assertThat(e0["includeInNetWorth"]).isEqualTo(false)
        // Null fields must be omitted so the GraphQL input doesn't carry meaningless nulls.
        assertThat(e0).doesNotContainKeys("displayBalance", "hideFromList", "type", "subtype")

        val e1 = input.entries[1]
        assertThat(e1["id"]).isEqualTo("a-2")
        assertThat(e1["displayBalance"]).isEqualTo(1234.56)
        assertThat(e1["hideFromList"]).isEqualTo(true)
        assertThat(e1).doesNotContainKeys("name", "includeInNetWorth")
    }

    @Test
    fun `ListLinkedCredentials maps credential plus institution fields`() {
        val data =
            jsonNode(
                """
                {
                  "credentials": [
                    {"id": "c-1", "institution": {"id": "i-1", "name": "Chase", "logo": "https://example.com/chase.png"}},
                    {"id": "c-2", "institution": {"id": "i-2", "name": "Schwab", "logo": null}}
                  ]
                }
                """.trimIndent(),
            )
        val out = ListLinkedCredentials.parseOutput(data)
        assertThat(out.credentials).hasSize(2)
        assertThat(out.credentials[0].id).isEqualTo("c-1")
        assertThat(out.credentials[0].institutionId).isEqualTo("i-1")
        assertThat(out.credentials[0].institutionName).isEqualTo("Chase")
        assertThat(out.credentials[0].institutionLogo).isEqualTo("https://example.com/chase.png")
        assertThat(out.credentials[1].institutionLogo).isNull()
    }

    @Test
    fun `ListLinkedCredentials returns empty list when none linked`() {
        val out = ListLinkedCredentials.parseOutput(jsonNode("""{"credentials": []}"""))
        assertThat(out.credentials).isEmpty()
    }

    // -- CreateManualAccount variables + Input.from -------------------------

    @Test
    fun `CreateManualAccount Input from defaults nullable balance and netWorth`() {
        val populated =
            CreateManualAccountRequest(
                type = "depository",
                subtype = "checking",
                name = "Cash",
                displayBalance = 1234.56,
                includeInNetWorth = false,
            )
        val in1 = CreateManualAccount.Input.from(populated)
        assertThat(in1.type).isEqualTo("depository")
        assertThat(in1.subtype).isEqualTo("checking")
        assertThat(in1.name).isEqualTo("Cash")
        assertThat(in1.displayBalance).isEqualTo(1234.56)
        assertThat(in1.includeInNetWorth).isFalse

        val sparse =
            CreateManualAccountRequest(
                type = "credit",
                subtype = "credit_card",
                name = "Visa",
                displayBalance = null,
                includeInNetWorth = null,
            )
        val in2 = CreateManualAccount.Input.from(sparse)
        assertThat(in2.displayBalance).isEqualTo(0.0)
        assertThat(in2.includeInNetWorth).isTrue
    }

    @Test
    fun `CreateManualAccount variables nest every field under input`() {
        val vars =
            CreateManualAccount.variables(
                CreateManualAccount.Input(
                    type = "depository",
                    subtype = "checking",
                    name = "Cash",
                    displayBalance = 100.0,
                    includeInNetWorth = true,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = vars["input"] as Map<String, Any?>
        assertThat(inner["type"]).isEqualTo("depository")
        assertThat(inner["subtype"]).isEqualTo("checking")
        assertThat(inner["name"]).isEqualTo("Cash")
        assertThat(inner["displayBalance"]).isEqualTo(100.0)
        assertThat(inner["includeInNetWorth"]).isEqualTo(true)
    }

    // -- UpdateAccount variables + Input.from -------------------------------

    @Test
    fun `UpdateAccount Input from carries every optional field`() {
        val req =
            UpdateAccountRequest(
                name = "Renamed",
                displayBalance = 999.99,
                type = "credit",
                subtype = "credit_card",
                includeInNetWorth = false,
                hideFromList = true,
                hideTransactionsFromReports = true,
            )
        val input = UpdateAccount.Input.from(id = "a-1", req = req)
        assertThat(input.id).isEqualTo("a-1")
        assertThat(input.name).isEqualTo("Renamed")
        assertThat(input.displayBalance).isEqualTo(999.99)
        assertThat(input.type).isEqualTo("credit")
        assertThat(input.subtype).isEqualTo("credit_card")
        assertThat(input.includeInNetWorth).isFalse
        assertThat(input.hideFromList).isTrue
        assertThat(input.hideTransactionsFromReports).isTrue
    }

    @Test
    fun `UpdateAccount variables only emit non-null fields under input`() {
        val varsFull =
            UpdateAccount.variables(
                UpdateAccount.Input(
                    id = "a-1",
                    name = "Renamed",
                    displayBalance = 100.0,
                    type = "depository",
                    subtype = "checking",
                    includeInNetWorth = true,
                    hideFromList = false,
                    hideTransactionsFromReports = false,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val full = varsFull["input"] as Map<String, Any?>
        assertThat(full).containsKeys(
            "id",
            "name",
            "displayBalance",
            "type",
            "subtype",
            "includeInNetWorth",
            "hideFromList",
            "hideTransactionsFromReports",
        )

        val varsSparse = UpdateAccount.variables(UpdateAccount.Input(id = "a-2"))

        @Suppress("UNCHECKED_CAST")
        val sparse = varsSparse["input"] as Map<String, Any?>
        assertThat(sparse.keys).containsExactly("id")
    }

    // -- DeleteAccount variables --------------------------------------------

    @Test
    fun `DeleteAccount variables forward accountId as id at top level`() {
        val vars = DeleteAccount.variables(DeleteAccount.Input(accountId = "a-7"))
        assertThat(vars["id"]).isEqualTo("a-7")
    }

    // -- GetAccountHoldings variables ---------------------------------------

    @Test
    fun `GetAccountHoldings variables wrap account window under input`() {
        val vars =
            GetAccountHoldings.variables(
                GetAccountHoldings.Input(
                    accountId = "a-1",
                    asOfDate = "2026-05-01",
                    includeHidden = false,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = vars["input"] as Map<String, Any?>
        assertThat(inner["accountIds"]).isEqualTo(listOf("a-1"))
        assertThat(inner["startDate"]).isEqualTo("2026-05-01")
        assertThat(inner["endDate"]).isEqualTo("2026-05-01")
        assertThat(inner["includeHiddenHoldings"]).isEqualTo(false)
    }

    // -- GetCredentialInstitutions -------------------------------------------

    @Test
    fun `GetCredentialInstitutions parses each credential with institution metadata`() {
        val data =
            com.nicholasklaene.monarchbridge.controllers
                .TestFixtures
                .jsonNode(
                    """
                    {
                      "credentials": [
                        {
                          "id": "cred-1",
                          "institution": {
                            "id": "inst-1",
                            "name": "Chase",
                            "plaidInstitutionId": "ins_3",
                            "finicityInstitutionId": null,
                            "mxInstitutionId": "chase_mx",
                            "preferredDataProvider": "plaid",
                            "logo": "https://cdn/chase.png"
                          }
                        },
                        {
                          "id": "cred-2",
                          "institution": {"id": "inst-2", "name": "Acme Bank"}
                        }
                      ]
                    }
                    """.trimIndent(),
                )
        val out = GetCredentialInstitutions.parseOutput(data)
        assertThat(out.credentials).hasSize(2)
        val first = out.credentials[0]
        assertThat(first.credentialId).isEqualTo("cred-1")
        assertThat(first.institutionId).isEqualTo("inst-1")
        assertThat(first.name).isEqualTo("Chase")
        assertThat(first.plaidInstitutionId).isEqualTo("ins_3")
        assertThat(first.finicityInstitutionId).isNull()
        assertThat(first.mxInstitutionId).isEqualTo("chase_mx")
        assertThat(first.preferredDataProvider).isEqualTo("plaid")
        assertThat(first.logo).isEqualTo("https://cdn/chase.png")
        assertThat(out.credentials[1].institutionId).isEqualTo("inst-2")
        assertThat(out.credentials[1].plaidInstitutionId).isNull()
    }

    @Test
    fun `GetCredentialInstitutions returns empty list when no credentials`() {
        val out =
            GetCredentialInstitutions.parseOutput(
                com.nicholasklaene.monarchbridge.controllers
                    .TestFixtures
                    .jsonNode("""{}"""),
            )
        assertThat(out.credentials).isEmpty()
    }

    @Test
    fun `GetCredentialInstitutions variables is empty map`() {
        assertThat(GetCredentialInstitutions.variables(Unit)).isEmpty()
    }

    // -- GetInstitutionByPlaidId ---------------------------------------------

    @Test
    fun `GetInstitutionByPlaidId parses institution detail including health flags`() {
        val data =
            com.nicholasklaene.monarchbridge.controllers
                .TestFixtures
                .jsonNode(
                    """
                    {
                      "institution": {
                        "id": "inst-1",
                        "name": "Chase",
                        "logo": "https://cdn/chase.png",
                        "newConnectionsDisabled": false,
                        "hasIssuesReported": true,
                        "hasIssuesReportedMessage": "Plaid degraded",
                        "plaidStatus": "DEGRADED",
                        "status": "ACTIVE",
                        "balanceStatus": "HEALTHY",
                        "transactionsStatus": "DEGRADED"
                      }
                    }
                    """.trimIndent(),
                )
        val out = GetInstitutionByPlaidId.parseOutput(data)
        assertThat(out.institution).isNotNull
        val inst = out.institution!!
        assertThat(inst.id).isEqualTo("inst-1")
        assertThat(inst.name).isEqualTo("Chase")
        assertThat(inst.newConnectionsDisabled).isFalse
        assertThat(inst.hasIssuesReported).isTrue
        assertThat(inst.hasIssuesReportedMessage).isEqualTo("Plaid degraded")
        assertThat(inst.plaidStatus).isEqualTo("DEGRADED")
        assertThat(inst.status).isEqualTo("ACTIVE")
        assertThat(inst.balanceStatus).isEqualTo("HEALTHY")
        assertThat(inst.transactionsStatus).isEqualTo("DEGRADED")
    }

    @Test
    fun `GetInstitutionByPlaidId returns null institution when missing`() {
        val out =
            GetInstitutionByPlaidId.parseOutput(
                com.nicholasklaene.monarchbridge.controllers
                    .TestFixtures
                    .jsonNode("""{}"""),
            )
        assertThat(out.institution).isNull()
    }

    @Test
    fun `GetInstitutionByPlaidId variables forward plaidId at top level`() {
        val vars = GetInstitutionByPlaidId.variables(GetInstitutionByPlaidId.Input(plaidId = "ins_3"))
        assertThat(vars).containsExactlyEntriesOf(mapOf("plaidId" to "ins_3"))
    }

    // -- GetTopInstitutionGroups ---------------------------------------------

    @Test
    fun `GetTopInstitutionGroups parses summary counts and per-group institutions`() {
        val data =
            com.nicholasklaene.monarchbridge.controllers
                .TestFixtures
                .jsonNode(
                    """
                    {
                      "equityAccountsCount": 5,
                      "credentials": [{"id": "c1"}, {"id": "c2"}],
                      "topInstitutionGroups": [
                        {
                          "type": "POPULAR",
                          "title": "Popular Banks",
                          "shortTitle": "Popular",
                          "accountsConnectedCount": 12,
                          "institutions": [
                            {"id": "i-1", "name": "Chase", "logo": "https://cdn/chase.png"},
                            {"id": "i-2", "name": "Wells Fargo", "logo": null}
                          ]
                        },
                        {
                          "type": "BROKERAGE",
                          "institutions": []
                        }
                      ]
                    }
                    """.trimIndent(),
                )
        val out = GetTopInstitutionGroups.parseOutput(data)
        assertThat(out.equityAccountsCount).isEqualTo(5)
        assertThat(out.credentialsCount).isEqualTo(2)
        assertThat(out.groups).hasSize(2)
        val first = out.groups[0]
        assertThat(first.type).isEqualTo("POPULAR")
        assertThat(first.title).isEqualTo("Popular Banks")
        assertThat(first.shortTitle).isEqualTo("Popular")
        assertThat(first.accountsConnectedCount).isEqualTo(12)
        assertThat(first.institutions).hasSize(2)
        assertThat(first.institutions!![0].name).isEqualTo("Chase")
        assertThat(first.institutions[1].logo).isNull()
        assertThat(out.groups[1].institutions).isEmpty()
    }

    @Test
    fun `GetTopInstitutionGroups defaults to null counts and empty groups when payload empty`() {
        val out =
            GetTopInstitutionGroups.parseOutput(
                com.nicholasklaene.monarchbridge.controllers
                    .TestFixtures
                    .jsonNode("""{}"""),
            )
        assertThat(out.equityAccountsCount).isNull()
        assertThat(out.credentialsCount).isNull()
        assertThat(out.groups).isEmpty()
    }

    @Test
    fun `GetTopInstitutionGroups variables forward dataProviders list`() {
        val vars =
            GetTopInstitutionGroups.variables(
                GetTopInstitutionGroups.Input(dataProviders = listOf("plaid", "finicity")),
            )
        assertThat(vars["dataProviders"]).isEqualTo(listOf("plaid", "finicity"))
    }
}
