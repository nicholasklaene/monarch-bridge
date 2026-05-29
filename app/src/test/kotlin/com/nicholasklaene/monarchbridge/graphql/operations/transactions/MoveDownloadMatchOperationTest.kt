package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.MoveTransactionsRequest
import com.nicholasklaene.monarchbridge.generated.model.StartDownloadTransactionsRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoveDownloadMatchOperationTest {
    @Test
    fun `MoveTransactions parses count and flattens errors`() {
        val out =
            MoveTransactions.parseOutput(
                jsonNode(
                    """
                    {"moveTransactions": {"numTransactionsMoved": 3, "errors": [
                      {"message": "tx-9 is locked"},
                      {"message": null}
                    ]}}
                    """.trimIndent(),
                ),
            )
        assertThat(out.numTransactionsMoved).isEqualTo(3)
        assertThat(out.errors).isNotNull
        assertThat(out.errors).hasSize(2)
        assertThat(out.errors!![0].message).isEqualTo("tx-9 is locked")
    }

    @Test
    fun `MoveTransactions empty errors becomes null`() {
        val out = MoveTransactions.parseOutput(jsonNode("""{"moveTransactions": {"numTransactionsMoved": 5, "errors": []}}"""))
        assertThat(out.errors).isNull()
    }

    @Test
    fun `MoveTransactions variables wraps under input key`() {
        val vars =
            MoveTransactions.variables(
                MoveTransactions.Input.from(
                    MoveTransactionsRequest(transactionIds = listOf("t-1", "t-2"), toAccountId = "a-1"),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inputMap = vars["input"] as Map<String, Any?>
        assertThat(inputMap).containsEntry("toAccountId", "a-1")
        assertThat(inputMap["transactionIds"] as List<*>).containsExactly("t-1", "t-2")
    }

    @Test
    fun `MatchSearchTransactions parses results with nested account+merchant`() {
        val out =
            MatchSearchTransactions.parseOutput(
                jsonNode(
                    """
                    {"allTransactions": {"results": [
                      {"id": "t-1", "amount": -12.34, "date": "2026-05-26", "plaidName": "STARBUCKS",
                       "merchant": {"id": "m-1", "name": "Starbucks"},
                       "account": {"id": "a-1", "displayName": "Chase Checking"}},
                      {"id": "t-2", "amount": null, "date": null, "plaidName": null,
                       "merchant": null, "account": null}
                    ]}}
                    """.trimIndent(),
                ),
            )
        assertThat(out.results).hasSize(2)
        assertThat(out.results[0].amount).isEqualTo(-12.34)
        assertThat(out.results[0].merchant?.name).isEqualTo("Starbucks")
        assertThat(out.results[0].account?.displayName).isEqualTo("Chase Checking")
        assertThat(out.results[1].merchant).isNull()
        assertThat(out.results[1].account).isNull()
    }

    @Test
    fun `MatchSearchTransactions variables pass through`() {
        val vars = MatchSearchTransactions.variables(MatchSearchTransactions.Input(search = "starbucks", limit = 50))
        assertThat(vars).containsEntry("search", "starbucks").containsEntry("limit", 50)
    }

    @Test
    fun `StartDownloadTransactions parses sessionKey+status and Input from request`() {
        val input =
            StartDownloadTransactions.Input.from(
                StartDownloadTransactionsRequest(
                    filters = mapOf("search" to "rent"),
                    orderBy = "date",
                ),
            )
        assertThat(input.orderBy).isEqualTo("date")
        assertThat(input.filters).containsEntry("search", "rent")

        val out =
            StartDownloadTransactions.parseOutput(
                jsonNode("""{"startDownloadTransactionsSession": {"sessionKey": "sk-1", "status": "RUNNING"}}"""),
            )
        assertThat(out.sessionKey).isEqualTo("sk-1")
        assertThat(out.status).isEqualTo("RUNNING")
    }

    @Test
    fun `StartDownloadTransactions Input default filters to empty map when null`() {
        val input =
            StartDownloadTransactions.Input.from(
                StartDownloadTransactionsRequest(filters = null, orderBy = null),
            )
        assertThat(input.filters).isEmpty()
    }

    @Test
    fun `GetDownloadTransactionsSession parses url and errorMessage`() {
        val out =
            GetDownloadTransactionsSession.parseOutput(
                jsonNode(
                    """
                    {"downloadTransactionsSession": {"sessionKey": "sk-1", "status": "COMPLETE",
                     "errorMessage": null, "url": "https://x/file.csv"}}
                    """.trimIndent(),
                ),
            )
        assertThat(out.sessionKey).isEqualTo("sk-1")
        assertThat(out.url).isEqualTo("https://x/file.csv")
        assertThat(out.errorMessage).isNull()
    }

    @Test
    fun `operation names match the bundle`() {
        assertThat(MoveTransactions.operationName).isEqualTo("Web_MoveTransactions")
        assertThat(MatchSearchTransactions.operationName).isEqualTo("Web_FindMatchTransactions")
        assertThat(StartDownloadTransactions.operationName).isEqualTo("Web_DownloadTransactions")
        assertThat(GetDownloadTransactionsSession.operationName).isEqualTo("Web_GetDownloadTransactionsSession")
    }
}
