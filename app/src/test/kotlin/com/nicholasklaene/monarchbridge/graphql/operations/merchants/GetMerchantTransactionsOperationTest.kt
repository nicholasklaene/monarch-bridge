package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GetMerchantTransactionsOperationTest {
    @Test
    fun `parses transaction rows with optional fields`() {
        val data =
            jsonNode(
                """
                {
                  "merchantTransactions": {
                    "transactions": [
                      {"id": "t-1", "date": "2026-05-01", "amount": -19.99, "merchantName": "Starbucks", "categoryName": "Coffee"},
                      {"id": "t-2", "date": null, "amount": null, "merchantName": null, "categoryName": null}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetMerchantTransactions.parseOutput(data)
        assertThat(out.transactions).hasSize(2)
        assertThat(out.transactions[0].id).isEqualTo("t-1")
        assertThat(out.transactions[0].date).isEqualTo("2026-05-01")
        assertThat(out.transactions[0].amount).isEqualTo(-19.99)
        assertThat(out.transactions[0].merchantName).isEqualTo("Starbucks")
        assertThat(out.transactions[0].categoryName).isEqualTo("Coffee")
        assertThat(out.transactions[1].id).isEqualTo("t-2")
        assertThat(out.transactions[1].date).isNull()
        assertThat(out.transactions[1].amount).isNull()
        assertThat(out.transactions[1].merchantName).isNull()
        assertThat(out.transactions[1].categoryName).isNull()
    }

    @Test
    fun `returns empty list when transactions field missing`() {
        val out = GetMerchantTransactions.parseOutput(jsonNode("""{}"""))
        assertThat(out.transactions).isEmpty()
    }

    @Test
    fun `variables include merchantId and optional pagination`() {
        val vars =
            GetMerchantTransactions.variables(
                GetMerchantTransactions.Input(merchantId = "m-1", limit = 25, offset = 50),
            )
        assertThat(vars["merchantId"]).isEqualTo("m-1")
        assertThat(vars["limit"]).isEqualTo(25)
        assertThat(vars["offset"]).isEqualTo(50)
    }

    @Test
    fun `variables forward nulls when limit and offset absent`() {
        val vars = GetMerchantTransactions.variables(GetMerchantTransactions.Input(merchantId = "m-2"))
        assertThat(vars["merchantId"]).isEqualTo("m-2")
        assertThat(vars["limit"]).isNull()
        assertThat(vars["offset"]).isNull()
    }

    @Test
    fun `operation name matches the bundle`() {
        assertThat(GetMerchantTransactions.operationName).isEqualTo("Web_GetMerchantTransactions")
    }
}
