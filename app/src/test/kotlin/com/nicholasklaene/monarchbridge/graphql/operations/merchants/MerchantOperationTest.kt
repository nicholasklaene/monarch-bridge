package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.SetMerchantLogoRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MerchantOperationTest {
    // -- GetMerchant -------------------------------------------------------

    @Test
    fun `GetMerchant parses every field including the recurring stream`() {
        val data =
            jsonNode(
                """
                {
                  "merchant": {
                    "id": "m-1",
                    "name": "Netflix",
                    "logoUrl": "https://example.com/netflix.png",
                    "transactionCount": 12,
                    "ruleCount": 2,
                    "canBeDeleted": false,
                    "hasActiveRecurringStreams": true,
                    "recurringTransactionStream": {
                      "id": "rts-1",
                      "frequency": "monthly",
                      "amount": -15.49,
                      "baseDate": "2026-05-01",
                      "isActive": true
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = GetMerchant.parseOutput(data)
        assertThat(out.merchant.id).isEqualTo("m-1")
        assertThat(out.merchant.name).isEqualTo("Netflix")
        assertThat(out.merchant.logoUrl).isEqualTo("https://example.com/netflix.png")
        assertThat(out.merchant.transactionCount).isEqualTo(12)
        assertThat(out.merchant.ruleCount).isEqualTo(2)
        assertThat(out.merchant.canBeDeleted).isFalse()
        assertThat(out.merchant.hasActiveRecurringStreams).isTrue()
        assertThat(out.merchant.recurringTransactionStream?.id).isEqualTo("rts-1")
        assertThat(out.merchant.recurringTransactionStream?.frequency).isEqualTo("monthly")
        assertThat(out.merchant.recurringTransactionStream?.amount).isEqualTo(-15.49)
        assertThat(out.merchant.recurringTransactionStream?.baseDate).isEqualTo("2026-05-01")
        assertThat(out.merchant.recurringTransactionStream?.isActive).isTrue()
    }

    @Test
    fun `GetMerchant tolerates missing recurring stream and optional fields`() {
        val data =
            jsonNode(
                """
                {
                  "merchant": {
                    "id": "m-bare",
                    "name": "Cash"
                  }
                }
                """.trimIndent(),
            )
        val out = GetMerchant.parseOutput(data)
        assertThat(out.merchant.id).isEqualTo("m-bare")
        assertThat(out.merchant.name).isEqualTo("Cash")
        assertThat(out.merchant.logoUrl).isNull()
        assertThat(out.merchant.transactionCount).isNull()
        assertThat(out.merchant.ruleCount).isNull()
        assertThat(out.merchant.canBeDeleted).isNull()
        assertThat(out.merchant.hasActiveRecurringStreams).isNull()
        assertThat(out.merchant.recurringTransactionStream).isNull()
    }

    @Test
    fun `GetMerchant defaults id and name to empty when merchant subtree absent`() {
        val out = GetMerchant.parseOutput(jsonNode("""{}"""))
        assertThat(out.merchant.id).isEqualTo("")
        assertThat(out.merchant.name).isEqualTo("")
        assertThat(out.merchant.recurringTransactionStream).isNull()
    }

    @Test
    fun `GetMerchant variables pass merchantId verbatim`() {
        val vars = GetMerchant.variables(GetMerchant.Input(merchantId = "m-42"))
        assertThat(vars).containsEntry("merchantId", "m-42")
        assertThat(vars).hasSize(1)
    }

    // -- SearchMerchants ---------------------------------------------------

    @Test
    fun `SearchMerchants parses id, name, and transactionCount from merchants list`() {
        val data =
            jsonNode(
                """
                {
                  "merchants": [
                    {"id": "m-1", "name": "Amazon", "transactionCount": 87},
                    {"id": "m-2", "name": "Starbucks", "transactionCount": 24}
                  ]
                }
                """.trimIndent(),
            )
        val out = SearchMerchants.parseOutput(data)
        assertThat(out.merchants).hasSize(2)
        assertThat(out.merchants[0].id).isEqualTo("m-1")
        assertThat(out.merchants[0].name).isEqualTo("Amazon")
        assertThat(out.merchants[0].transactionCount).isEqualTo(87)
        assertThat(out.merchants[0].logoUrl).isNull()
        assertThat(out.merchants[1].id).isEqualTo("m-2")
        assertThat(out.merchants[1].transactionCount).isEqualTo(24)
    }

    @Test
    fun `SearchMerchants returns empty list when merchants array empty or missing`() {
        val empty = SearchMerchants.parseOutput(jsonNode("""{"merchants": []}"""))
        assertThat(empty.merchants).isEmpty()

        val missing = SearchMerchants.parseOutput(jsonNode("""{}"""))
        assertThat(missing.merchants).isEmpty()
    }

    @Test
    fun `SearchMerchants variables forward search, limit, and includeIds`() {
        val withAll =
            SearchMerchants.variables(
                SearchMerchants.Input(search = "Amazon", limit = 25, includeIds = listOf("m-1", "m-2")),
            )
        assertThat(withAll["search"]).isEqualTo("Amazon")
        assertThat(withAll["limit"]).isEqualTo(25)
        assertThat(withAll["includeIds"]).isEqualTo(listOf("m-1", "m-2"))

        val bareDefaults = SearchMerchants.variables(SearchMerchants.Input())
        assertThat(bareDefaults).containsEntry("search", null)
        assertThat(bareDefaults).containsEntry("limit", null)
        assertThat(bareDefaults).containsEntry("includeIds", null)
    }

    // -- SearchMerchantsWithLogo -------------------------------------------

    @Test
    fun `SearchMerchantsWithLogo parses id, name, transactionCount, and logoUrl`() {
        val data =
            jsonNode(
                """
                {
                  "merchants": [
                    {"id": "m-1", "name": "Netflix", "transactionCount": 12, "logoUrl": "https://example.com/n.png"},
                    {"id": "m-2", "name": "Spotify", "transactionCount": 6, "logoUrl": null}
                  ]
                }
                """.trimIndent(),
            )
        val out = SearchMerchantsWithLogo.parseOutput(data)
        assertThat(out.merchants).hasSize(2)
        assertThat(out.merchants[0].logoUrl).isEqualTo("https://example.com/n.png")
        assertThat(out.merchants[0].transactionCount).isEqualTo(12)
        assertThat(out.merchants[1].logoUrl).isNull()
        assertThat(out.merchants[1].name).isEqualTo("Spotify")
    }

    @Test
    fun `SearchMerchantsWithLogo returns empty list when merchants missing`() {
        val out = SearchMerchantsWithLogo.parseOutput(jsonNode("""{}"""))
        assertThat(out.merchants).isEmpty()
    }

    @Test
    fun `SearchMerchantsWithLogo variables forward search, limit, and offset`() {
        val vars =
            SearchMerchantsWithLogo.variables(
                SearchMerchantsWithLogo.Input(search = "coffee", limit = 50, offset = 10),
            )
        assertThat(vars["search"]).isEqualTo("coffee")
        assertThat(vars["limit"]).isEqualTo(50)
        assertThat(vars["offset"]).isEqualTo(10)

        val bare = SearchMerchantsWithLogo.variables(SearchMerchantsWithLogo.Input())
        assertThat(bare).containsEntry("search", null)
        assertThat(bare).containsEntry("limit", null)
        assertThat(bare).containsEntry("offset", null)
    }

    // -- SetMerchantLogo ---------------------------------------------------

    @Test
    fun `SetMerchantLogo parses merchant from setMerchantLogo merchant payload`() {
        val data =
            jsonNode(
                """
                {
                  "setMerchantLogo": {
                    "merchant": {
                      "id": "m-1",
                      "name": "Netflix",
                      "logoUrl": "https://example.com/new-logo.png"
                    },
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = SetMerchantLogo.parseOutput(data)
        assertThat(out.merchant.id).isEqualTo("m-1")
        assertThat(out.merchant.name).isEqualTo("Netflix")
        assertThat(out.merchant.logoUrl).isEqualTo("https://example.com/new-logo.png")
    }

    @Test
    fun `SetMerchantLogo defaults id and name to empty when merchant subtree missing`() {
        val out = SetMerchantLogo.parseOutput(jsonNode("""{"setMerchantLogo": {}}"""))
        assertThat(out.merchant.id).isEqualTo("")
        assertThat(out.merchant.name).isEqualTo("")
        assertThat(out.merchant.logoUrl).isNull()
    }

    @Test
    fun `SetMerchantLogo variables wrap merchantId and cloudinaryPublicId inside input`() {
        val withId =
            SetMerchantLogo.variables(
                SetMerchantLogo.Input(merchantId = "m-1", cloudinaryPublicId = "monarch/logos/m-1/abc"),
            )

        @Suppress("UNCHECKED_CAST")
        val input = withId["input"] as Map<String, Any?>
        assertThat(input["merchantId"]).isEqualTo("m-1")
        assertThat(input["cloudinaryPublicId"]).isEqualTo("monarch/logos/m-1/abc")

        // Null public id (clear-logo intent) is forwarded explicitly so Monarch can clear it.
        val clear = SetMerchantLogo.variables(SetMerchantLogo.Input(merchantId = "m-2"))

        @Suppress("UNCHECKED_CAST")
        val clearInput = clear["input"] as Map<String, Any?>
        assertThat(clearInput["merchantId"]).isEqualTo("m-2")
        assertThat(clearInput).containsEntry("cloudinaryPublicId", null)
        assertThat(clearInput).containsKey("cloudinaryPublicId")
    }

    @Test
    fun `SetMerchantLogo Input from forwards merchantId and cloudinaryPublicId from request`() {
        val req = SetMerchantLogoRequest(cloudinaryPublicId = "public-123")
        val input = SetMerchantLogo.Input.from("m-9", req)
        assertThat(input.merchantId).isEqualTo("m-9")
        assertThat(input.cloudinaryPublicId).isEqualTo("public-123")

        val clearReq = SetMerchantLogoRequest(cloudinaryPublicId = null)
        val clearInput = SetMerchantLogo.Input.from("m-9", clearReq)
        assertThat(clearInput.merchantId).isEqualTo("m-9")
        assertThat(clearInput.cloudinaryPublicId).isNull()
    }

    // -- DeleteMerchant ----------------------------------------------------

    @Test
    fun `DeleteMerchant surfaces success as deleted true`() {
        val data = jsonNode("""{"deleteMerchant": {"success": true}}""")
        val out = DeleteMerchant.parseOutput(data)
        assertThat(out.deleted).isTrue()
    }

    @Test
    fun `DeleteMerchant defaults to deleted false when success missing or false`() {
        val explicitFalse = DeleteMerchant.parseOutput(jsonNode("""{"deleteMerchant": {"success": false}}"""))
        assertThat(explicitFalse.deleted).isFalse()

        val missingFlag = DeleteMerchant.parseOutput(jsonNode("""{"deleteMerchant": {}}"""))
        assertThat(missingFlag.deleted).isFalse()

        val missingMutation = DeleteMerchant.parseOutput(jsonNode("""{}"""))
        assertThat(missingMutation.deleted).isFalse()
    }

    @Test
    fun `DeleteMerchant variables include merchantId and moveToId`() {
        val withMove = DeleteMerchant.variables(DeleteMerchant.Input(merchantId = "m-1", moveToId = "m-2"))
        assertThat(withMove["merchantId"]).isEqualTo("m-1")
        assertThat(withMove["moveToId"]).isEqualTo("m-2")

        val withoutMove = DeleteMerchant.variables(DeleteMerchant.Input(merchantId = "m-3"))
        assertThat(withoutMove["merchantId"]).isEqualTo("m-3")
        assertThat(withoutMove).containsEntry("moveToId", null)
    }
}
