package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateManualHoldingRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateManualInvestmentsAccountRequest
import com.nicholasklaene.monarchbridge.generated.model.InitialHoldingInput
import com.nicholasklaene.monarchbridge.generated.model.UpdateHoldingRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HoldingOperationTest {
    // -- CreateManualHolding -----------------------------------------------

    @Test
    fun `CreateManualHolding parses holdingId and ticker from createManualHolding holding`() {
        val data =
            jsonNode(
                """
                {
                  "createManualHolding": {
                    "holding": {"id": "h-new-1", "ticker": "VTI"},
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = CreateManualHolding.parseOutput(data)
        assertThat(out.holdingId).isEqualTo("h-new-1")
        assertThat(out.ticker).isEqualTo("VTI")
    }

    @Test
    fun `CreateManualHolding tolerates null ticker and missing holding subtree`() {
        val noTicker =
            CreateManualHolding.parseOutput(
                jsonNode("""{"createManualHolding": {"holding": {"id": "h-bare", "ticker": null}}}"""),
            )
        assertThat(noTicker.holdingId).isEqualTo("h-bare")
        assertThat(noTicker.ticker).isNull()

        val missing = CreateManualHolding.parseOutput(jsonNode("""{"createManualHolding": {}}"""))
        assertThat(missing.holdingId).isEqualTo("")
        assertThat(missing.ticker).isNull()

        val empty = CreateManualHolding.parseOutput(jsonNode("""{}"""))
        assertThat(empty.holdingId).isEqualTo("")
        assertThat(empty.ticker).isNull()
    }

    @Test
    fun `CreateManualHolding variables wrap accountId securityId quantity in the input key`() {
        val vars = CreateManualHolding.variables(CreateManualHolding.Input("acc-1", "sec-1", 12.5))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input["accountId"]).isEqualTo("acc-1")
        assertThat(input["securityId"]).isEqualTo("sec-1")
        assertThat(input["quantity"]).isEqualTo(12.5)
    }

    @Test
    fun `CreateManualHolding Input from injects accountId and copies req fields`() {
        val req = CreateManualHoldingRequest(securityId = "sec-1", quantity = 7.0)
        val input = CreateManualHolding.Input.from("acc-1", req)
        assertThat(input.accountId).isEqualTo("acc-1")
        assertThat(input.securityId).isEqualTo("sec-1")
        assertThat(input.quantity).isEqualTo(7.0)
    }

    // -- UpdateHolding -----------------------------------------------------

    @Test
    fun `UpdateHolding parses holdingId from updateHolding holding`() {
        val data = jsonNode("""{"updateHolding": {"holding": {"id": "h-1"}, "errors": null}}""")
        val out = UpdateHolding.parseOutput(data)
        assertThat(out.holdingId).isEqualTo("h-1")
    }

    @Test
    fun `UpdateHolding parses empty holdingId when payload missing`() {
        val out = UpdateHolding.parseOutput(jsonNode("""{}"""))
        assertThat(out.holdingId).isEqualTo("")
    }

    @Test
    fun `UpdateHolding variables drops null fields and forwards non-null ones inside input`() {
        val onlyQuantity = UpdateHolding.variables(UpdateHolding.Input(id = "h-1", quantity = 99.0))

        @Suppress("UNCHECKED_CAST")
        val input1 = onlyQuantity["input"] as Map<String, Any?>
        assertThat(input1["id"]).isEqualTo("h-1")
        assertThat(input1["quantity"]).isEqualTo(99.0)
        assertThat(input1).doesNotContainKeys("securityType", "userCostBasis")

        val full =
            UpdateHolding.variables(
                UpdateHolding.Input(
                    id = "h-2",
                    quantity = 10.0,
                    securityType = "equity",
                    userCostBasis = 1500.0,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val input2 = full["input"] as Map<String, Any?>
        assertThat(input2["id"]).isEqualTo("h-2")
        assertThat(input2["quantity"]).isEqualTo(10.0)
        assertThat(input2["securityType"]).isEqualTo("equity")
        assertThat(input2["userCostBasis"]).isEqualTo(1500.0)
    }

    @Test
    fun `UpdateHolding Input from injects id and forwards req fields including nulls`() {
        val req = UpdateHoldingRequest(quantity = 25.0, securityType = null, userCostBasis = 5000.0)
        val input = UpdateHolding.Input.from("h-7", req)
        assertThat(input.id).isEqualTo("h-7")
        assertThat(input.quantity).isEqualTo(25.0)
        assertThat(input.securityType).isNull()
        assertThat(input.userCostBasis).isEqualTo(5000.0)
    }

    // -- DeleteHolding -----------------------------------------------------

    @Test
    fun `DeleteHolding returns deleted true when deleteHolding deleted true`() {
        val out = DeleteHolding.parseOutput(jsonNode("""{"deleteHolding": {"deleted": true}}"""))
        assertThat(out.deleted).isTrue()
    }

    @Test
    fun `DeleteHolding defaults to false when flag missing, explicit false, or mutation absent`() {
        val explicit = DeleteHolding.parseOutput(jsonNode("""{"deleteHolding": {"deleted": false}}"""))
        assertThat(explicit.deleted).isFalse()

        val missingFlag = DeleteHolding.parseOutput(jsonNode("""{"deleteHolding": {}}"""))
        assertThat(missingFlag.deleted).isFalse()

        val missingMutation = DeleteHolding.parseOutput(jsonNode("""{}"""))
        assertThat(missingMutation.deleted).isFalse()
    }

    @Test
    fun `DeleteHolding variables map the holdingId onto the id key`() {
        val vars = DeleteHolding.variables(DeleteHolding.Input("h-42"))
        assertThat(vars["id"]).isEqualTo("h-42")
    }

    // -- CreateManualInvestmentsAccount ------------------------------------

    @Test
    fun `CreateManualInvestmentsAccount parses accountId from createManualInvestmentsAccount account`() {
        val data =
            jsonNode(
                """
                {
                  "createManualInvestmentsAccount": {
                    "account": {"id": "acc-new-1"},
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = CreateManualInvestmentsAccount.parseOutput(data)
        assertThat(out.accountId).isEqualTo("acc-new-1")
    }

    @Test
    fun `CreateManualInvestmentsAccount returns empty accountId when account or id missing`() {
        val missingAccount =
            CreateManualInvestmentsAccount.parseOutput(
                jsonNode("""{"createManualInvestmentsAccount": {"account": null}}"""),
            )
        assertThat(missingAccount.accountId).isEqualTo("")

        val empty = CreateManualInvestmentsAccount.parseOutput(jsonNode("""{}"""))
        assertThat(empty.accountId).isEqualTo("")
    }

    @Test
    fun `CreateManualInvestmentsAccount variables include required name and subtype, drop null optionals`() {
        val minimal =
            CreateManualInvestmentsAccount.variables(
                CreateManualInvestmentsAccount.Input(name = "401k", subtype = "401k"),
            )

        @Suppress("UNCHECKED_CAST")
        val input1 = minimal["input"] as Map<String, Any?>
        assertThat(input1["name"]).isEqualTo("401k")
        assertThat(input1["subtype"]).isEqualTo("401k")
        assertThat(input1).doesNotContainKeys(
            "manualInvestmentsTrackingMethod",
            "initialBalance",
            "initialHoldings",
        )
    }

    @Test
    fun `CreateManualInvestmentsAccount variables emit tracking method, initial balance, and initial holdings when set`() {
        val withHoldings =
            CreateManualInvestmentsAccount.variables(
                CreateManualInvestmentsAccount.Input(
                    name = "Brokerage",
                    subtype = "brokerage",
                    trackingMethod = "holdings",
                    initialHoldings =
                        listOf(
                            CreateManualInvestmentsAccount.InitialHolding(securityId = "sec-1", quantity = 100.0),
                            CreateManualInvestmentsAccount.InitialHolding(securityId = "sec-2", quantity = 25.5),
                        ),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val input = withHoldings["input"] as Map<String, Any?>
        assertThat(input["manualInvestmentsTrackingMethod"]).isEqualTo("holdings")

        @Suppress("UNCHECKED_CAST")
        val holdings = input["initialHoldings"] as List<Map<String, Any?>>
        assertThat(holdings).hasSize(2)
        assertThat(holdings[0]["securityId"]).isEqualTo("sec-1")
        assertThat(holdings[0]["quantity"]).isEqualTo(100.0)
        assertThat(holdings[1]["securityId"]).isEqualTo("sec-2")
        assertThat(holdings[1]["quantity"]).isEqualTo(25.5)

        val withBalance =
            CreateManualInvestmentsAccount.variables(
                CreateManualInvestmentsAccount.Input(
                    name = "401k",
                    subtype = "401k",
                    trackingMethod = "balances",
                    initialBalance = 12500.0,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val input2 = withBalance["input"] as Map<String, Any?>
        assertThat(input2["manualInvestmentsTrackingMethod"]).isEqualTo("balances")
        assertThat(input2["initialBalance"]).isEqualTo(12500.0)
        assertThat(input2).doesNotContainKey("initialHoldings")
    }

    @Test
    fun `CreateManualInvestmentsAccount Input from copies req fields and converts seed holdings`() {
        val req =
            CreateManualInvestmentsAccountRequest(
                name = "Roth IRA",
                subtype = "ira",
                trackingMethod = "holdings",
                initialBalance = null,
                initialHoldings =
                    listOf(
                        InitialHoldingInput(securityId = "sec-1", quantity = 50.0),
                    ),
            )
        val input = CreateManualInvestmentsAccount.Input.from(req)
        assertThat(input.name).isEqualTo("Roth IRA")
        assertThat(input.subtype).isEqualTo("ira")
        assertThat(input.trackingMethod).isEqualTo("holdings")
        assertThat(input.initialBalance).isNull()
        assertThat(input.initialHoldings).hasSize(1)
        assertThat(input.initialHoldings?.first()?.securityId).isEqualTo("sec-1")
        assertThat(input.initialHoldings?.first()?.quantity).isEqualTo(50.0)
    }

    // -- SecuritySearch ----------------------------------------------------

    @Test
    fun `SecuritySearch parses every Security field from securities list`() {
        val data =
            jsonNode(
                """
                {
                  "securities": [
                    {
                      "id": "sec-1",
                      "name": "Vanguard Total Stock Market",
                      "ticker": "VTI",
                      "type": "etf",
                      "typeDisplay": "ETF",
                      "logo": "https://example.com/vti.png",
                      "currentPrice": 250.50,
                      "closingPrice": 248.10,
                      "oneDayChangeDollars": 2.40,
                      "oneDayChangePercent": 0.97
                    },
                    {
                      "id": "sec-2",
                      "name": "Apple Inc.",
                      "ticker": "AAPL",
                      "type": "equity",
                      "currentPrice": 240.225
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = SecuritySearch.parseOutput(data)
        assertThat(out.securities).hasSize(2)
        val s0 = out.securities[0]
        assertThat(s0.id).isEqualTo("sec-1")
        assertThat(s0.name).isEqualTo("Vanguard Total Stock Market")
        assertThat(s0.ticker).isEqualTo("VTI")
        assertThat(s0.type).isEqualTo("etf")
        assertThat(s0.typeDisplay).isEqualTo("ETF")
        assertThat(s0.logo).isEqualTo("https://example.com/vti.png")
        assertThat(s0.currentPrice).isEqualTo(250.50)
        assertThat(s0.closingPrice).isEqualTo(248.10)
        assertThat(s0.oneDayChangeDollars).isEqualTo(2.40)
        assertThat(s0.oneDayChangePercent).isEqualTo(0.97)

        val s1 = out.securities[1]
        assertThat(s1.id).isEqualTo("sec-2")
        assertThat(s1.ticker).isEqualTo("AAPL")
        assertThat(s1.typeDisplay).isNull()
        assertThat(s1.closingPrice).isNull()
    }

    @Test
    fun `SecuritySearch tolerates empty securities list and missing root field`() {
        val empty = SecuritySearch.parseOutput(jsonNode("""{"securities": []}"""))
        assertThat(empty.securities).isEmpty()

        val missing = SecuritySearch.parseOutput(jsonNode("""{}"""))
        assertThat(missing.securities).isEmpty()
    }

    @Test
    fun `SecuritySearch variables forward search, limit, and orderByPopularity unwrapped`() {
        val withAll =
            SecuritySearch.variables(
                SecuritySearch.Input(search = "VTI", limit = 25, orderByPopularity = true),
            )
        assertThat(withAll["search"]).isEqualTo("VTI")
        assertThat(withAll["limit"]).isEqualTo(25)
        assertThat(withAll["orderByPopularity"]).isEqualTo(true)

        val onlySearch = SecuritySearch.variables(SecuritySearch.Input(search = "Apple"))
        assertThat(onlySearch["search"]).isEqualTo("Apple")
        assertThat(onlySearch["limit"]).isNull()
        assertThat(onlySearch["orderByPopularity"]).isNull()
    }
}
