package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchRequestFailedException
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.AccountForFilterRow
import com.nicholasklaene.monarchbridge.generated.model.AttachmentDetail
import com.nicholasklaene.monarchbridge.generated.model.CashflowCategoryGroupRef
import com.nicholasklaene.monarchbridge.generated.model.CashflowCategoryGroupRow
import com.nicholasklaene.monarchbridge.generated.model.CashflowCategoryRef
import com.nicholasklaene.monarchbridge.generated.model.CashflowDayPoint
import com.nicholasklaene.monarchbridge.generated.model.CashflowEntityCategoryRow
import com.nicholasklaene.monarchbridge.generated.model.CashflowMerchantRef
import com.nicholasklaene.monarchbridge.generated.model.CashflowMerchantRow
import com.nicholasklaene.monarchbridge.generated.model.CashflowSummary
import com.nicholasklaene.monarchbridge.generated.model.CashflowTimeframeBucket
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionResponseData
import com.nicholasklaene.monarchbridge.generated.model.DashboardTransactionRow
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.generated.model.ExplainTransactionResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetAccountsForTransactionFilterResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetAttachmentResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowBreakdownResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowDashboardResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowEntitiesResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowFilteredResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowTimeframeResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetReviewSummaryByUserResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionDetailResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionSplitsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionsDashboardResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionsSummaryResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListTransactionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponseData
import com.nicholasklaene.monarchbridge.generated.model.MerchantRef
import com.nicholasklaene.monarchbridge.generated.model.ReviewSummaryByUserRow
import com.nicholasklaene.monarchbridge.generated.model.SetTransactionTagsResponseData
import com.nicholasklaene.monarchbridge.generated.model.Transaction
import com.nicholasklaene.monarchbridge.generated.model.TransactionAccountRef
import com.nicholasklaene.monarchbridge.generated.model.TransactionAttachment
import com.nicholasklaene.monarchbridge.generated.model.TransactionSplit
import com.nicholasklaene.monarchbridge.generated.model.TransactionsSummary
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionSplitsResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.MultipartFilePart
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.AddTransactionAttachment
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetCashflowBreakdown
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetCashflowSummary
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactionAttachmentUploadInfo
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.transactions.GetTransactionsSummary
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.doThrow
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

/**
 * MockMvc slice for [TransactionController]. Happy path per endpoint, one representative
 * session-missing test, and a body-validation test exercising the `^\d{4}-\d{2}-\d{2}$`
 * @Pattern on [com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRequest.date].
 */
@WebMvcTest(TransactionController::class)
@Import(GlobalExceptionHandler::class)
class TransactionControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `listTransactions returns totalCount and results`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListTransactionsResponseData(
                totalCount = 2,
                results =
                    listOf(
                        Transaction(id = "t1", date = LocalDate.parse("2026-05-01"), amount = -42.5),
                        Transaction(id = "t2", date = LocalDate.parse("2026-05-02"), amount = 100.0),
                    ),
            ),
        )

        mvc
            .perform(get("/v1/transactions"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.totalCount").value(2))
            .andExpect(jsonPath("$.data.results[0].id").value("t1"))
            .andExpect(jsonPath("$.data.results[0].amount").value(-42.5))
            .andExpect(jsonPath("$.data.results[1].id").value("t2"))
    }

    @Test
    fun `listTransactions returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(get("/v1/transactions"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getCashflow returns summary envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCashflowResponseData(
                summary =
                    CashflowSummary(
                        sumIncome = 5000.0,
                        sumExpense = -3000.0,
                        savings = 2000.0,
                        savingsRate = 0.4,
                    ),
            ),
        )

        mvc
            .perform(get("/v1/cashflow"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.summary.sumIncome").value(5000.0))
            .andExpect(jsonPath("$.data.summary.savings").value(2000.0))
            .andExpect(jsonPath("$.data.summary.savingsRate").value(0.4))
    }

    @Test
    fun `getCashflowBreakdown returns category and merchant groupings`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCashflowBreakdownResponseData(
                byCategory = listOf(mapOf("name" to "Groceries", "sum" to -250.0)),
                byCategoryGroup = listOf(mapOf("name" to "Food", "sum" to -500.0)),
                byMerchant = listOf(mapOf("name" to "Costco", "sum" to -120.0)),
                summary = mapOf("net" to -870.0),
            ),
        )

        mvc
            .perform(get("/v1/cashflow/breakdown"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.byCategory[0].name").value("Groceries"))
            .andExpect(jsonPath("$.data.byCategoryGroup[0].name").value("Food"))
            .andExpect(jsonPath("$.data.byMerchant[0].name").value("Costco"))
            .andExpect(jsonPath("$.data.summary.net").value(-870.0))
    }

    @Test
    fun `getTransactionsSummary returns aggregate stats`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTransactionsSummaryResponseData(
                summary =
                    TransactionsSummary(
                        count = 12,
                        sum = -2400.0,
                        avg = -200.0,
                        min = -500.0,
                        max = 0.0,
                        first = LocalDate.parse("2026-04-01"),
                        last = LocalDate.parse("2026-04-30"),
                    ),
            ),
        )

        mvc
            .perform(get("/v1/transactions/summary"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.summary.count").value(12))
            .andExpect(jsonPath("$.data.summary.sum").value(-2400.0))
            .andExpect(jsonPath("$.data.summary.first").value("2026-04-01"))
    }

    @Test
    fun `getTransactionsDuplicates groups by date amount accountId plaidName and drops singletons`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        // Build a result set where:
        //   t1/t2 collide on (2026-05-01, -19.99, a-1, "STARBUCKS #1234 PORTLAND"): one duplicate group.
        //   t3 has same date+amount but different account: singleton, filtered out.
        //   t4/t5 collide on (2026-05-02, -42.5, a-1, "COSTCO WHSE #0492"): second duplicate group.
        //   t6 has unique key entirely: singleton, filtered out.
        val starbucksA1May1A =
            Transaction(
                id = "t1",
                date = LocalDate.parse("2026-05-01"),
                amount = -19.99,
                account = TransactionAccountRef(id = "a-1"),
                merchant = MerchantRef(id = "m-sb", name = "Starbucks"),
                plaidName = "STARBUCKS #1234 PORTLAND",
            )
        val starbucksA1May1B = starbucksA1May1A.copy(id = "t2")
        val starbucksA2May1 =
            starbucksA1May1A.copy(id = "t3", account = TransactionAccountRef(id = "a-2"))
        val costcoA1May2A =
            Transaction(
                id = "t4",
                date = LocalDate.parse("2026-05-02"),
                amount = -42.5,
                account = TransactionAccountRef(id = "a-1"),
                merchant = MerchantRef(id = "m-cc", name = "Costco"),
                plaidName = "COSTCO WHSE #0492",
            )
        val costcoA1May2B = costcoA1May2A.copy(id = "t5")
        val loneRow =
            Transaction(
                id = "t6",
                date = LocalDate.parse("2026-05-03"),
                amount = -7.0,
                account = TransactionAccountRef(id = "a-1"),
                merchant = MerchantRef(id = "m-x", name = "Lone Bagel"),
                plaidName = "BAGEL CO PDX",
            )
        stubExec(
            client,
            ListTransactionsResponseData(
                totalCount = 6,
                results = listOf(starbucksA1May1A, starbucksA1May1B, starbucksA2May1, costcoA1May2A, costcoA1May2B, loneRow),
            ),
        )

        mvc
            .perform(get("/v1/transactions/duplicates"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.groups.length()").value(2))
            // Group order follows first-seen order from the upstream page.
            .andExpect(jsonPath("$.data.groups[0].key.date").value("2026-05-01"))
            .andExpect(jsonPath("$.data.groups[0].key.amount").value(-19.99))
            .andExpect(jsonPath("$.data.groups[0].key.accountId").value("a-1"))
            .andExpect(jsonPath("$.data.groups[0].key.plaidName").value("STARBUCKS #1234 PORTLAND"))
            .andExpect(jsonPath("$.data.groups[0].transactions.length()").value(2))
            .andExpect(jsonPath("$.data.groups[0].transactions[0].id").value("t1"))
            .andExpect(jsonPath("$.data.groups[0].transactions[1].id").value("t2"))
            .andExpect(jsonPath("$.data.groups[1].key.date").value("2026-05-02"))
            .andExpect(jsonPath("$.data.groups[1].key.plaidName").value("COSTCO WHSE #0492"))
            .andExpect(jsonPath("$.data.groups[1].transactions.length()").value(2))
            .andExpect(jsonPath("$.data.groups[1].transactions[0].id").value("t4"))
            .andExpect(jsonPath("$.data.groups[1].transactions[1].id").value("t5"))
    }

    @Test
    fun `getTransactionDetail returns transaction map`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTransactionDetailResponseData(
                transaction = mapOf("id" to "t1", "amount" to -42.5, "notes" to "Lunch"),
            ),
        )

        mvc
            .perform(get("/v1/transactions/t1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.transaction.id").value("t1"))
            .andExpect(jsonPath("$.data.transaction.notes").value("Lunch"))
    }

    @Test
    fun `getTransactionSplits returns splits array`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTransactionSplitsResponseData(
                id = "t1",
                amount = -100.0,
                splits =
                    listOf(
                        TransactionSplit(id = "s1", amount = -60.0, merchantName = "Costco", categoryName = "Groceries"),
                        TransactionSplit(id = "s2", amount = -40.0, merchantName = "Costco", categoryName = "Household"),
                    ),
            ),
        )

        mvc
            .perform(get("/v1/transactions/t1/splits"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("t1"))
            .andExpect(jsonPath("$.data.amount").value(-100.0))
            .andExpect(jsonPath("$.data.splits[0].id").value("s1"))
            .andExpect(jsonPath("$.data.splits[1].categoryName").value("Household"))
    }

    @Test
    fun `createTransaction accepts valid body and returns id`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, CreateTransactionResponseData(transactionId = "new-t1"))

        mvc
            .perform(
                post("/v1/transactions")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                        """
                        {
                          "date": "2026-05-25",
                          "accountId": "acc-1",
                          "amount": -42.5,
                          "merchantName": "Lowe's",
                          "categoryId": "cat-1"
                        }
                        """.trimIndent(),
                    ),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.transactionId").value("new-t1"))
    }

    @Test
    fun `createTransaction returns 400 when date pattern is invalid`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)

        // `date` has @Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$"). "2026/05/25" violates it.
        mvc
            .perform(
                post("/v1/transactions")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                        """
                        {
                          "date": "2026/05/25",
                          "accountId": "acc-1",
                          "amount": -42.5,
                          "merchantName": "Lowe's",
                          "categoryId": "cat-1"
                        }
                        """.trimIndent(),
                    ),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `updateTransaction patches fields and returns updated transaction`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateTransactionResponseData(
                transaction =
                    Transaction(
                        id = "t1",
                        date = LocalDate.parse("2026-05-01"),
                        amount = -42.5,
                        notes = "updated",
                    ),
            ),
        )

        mvc
            .perform(
                patch("/v1/transactions/t1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"notes": "updated"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.transaction.id").value("t1"))
            .andExpect(jsonPath("$.data.transaction.notes").value("updated"))
    }

    @Test
    fun `deleteTransaction returns deleted=true`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DeleteAccountResponseData(deleted = true))

        mvc
            .perform(delete("/v1/transactions/t1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").value(true))
    }

    @Test
    fun `bulkUpdateTransactions returns success and affectedCount`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            com.nicholasklaene.monarchbridge.generated.model.BulkUpdateTransactionsResponseData(
                success = true,
                affectedCount = 3,
            ),
        )

        mvc
            .perform(
                patch("/v1/transactions/bulk")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                        """
                        {
                          "selectedTransactionIds": ["t-1", "t-2", "t-3"],
                          "allSelected": false,
                          "expectedAffectedTransactionCount": 3,
                          "updates": {"categoryId": "c-99", "notes": "bulk move"}
                        }
                        """.trimIndent(),
                    ),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.success").value(true))
            .andExpect(jsonPath("$.data.affectedCount").value(3))
    }

    @Test
    fun `bulkUpdateTransactions returns 400 when updates body field missing`() {
        mvc
            .perform(
                patch("/v1/transactions/bulk")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"expectedAffectedTransactionCount": 1}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `bulkDeleteTransactions returns success and affectedCount`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            com.nicholasklaene.monarchbridge.generated.model.BulkDeleteTransactionsResponseData(
                success = true,
                affectedCount = 5,
            ),
        )

        mvc
            .perform(
                post("/v1/transactions/bulk-delete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                        """
                        {
                          "selectedTransactionIds": ["t-1", "t-2", "t-3", "t-4", "t-5"],
                          "allSelected": false,
                          "expectedAffectedTransactionCount": 5
                        }
                        """.trimIndent(),
                    ),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.success").value(true))
            .andExpect(jsonPath("$.data.affectedCount").value(5))
    }

    @Test
    fun `bulkDeleteTransactions returns 400 when expectedAffectedTransactionCount missing`() {
        mvc
            .perform(
                post("/v1/transactions/bulk-delete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"selectedTransactionIds": ["t-1"]}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `setTransactionTags returns transactionId and tagIds`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            SetTransactionTagsResponseData(
                transactionId = "t1",
                tagIds = listOf("tag-1", "tag-2"),
            ),
        )

        mvc
            .perform(
                put("/v1/transactions/t1/tags")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"tagIds": ["tag-1", "tag-2"]}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.transactionId").value("t1"))
            .andExpect(jsonPath("$.data.tagIds[0]").value("tag-1"))
            .andExpect(jsonPath("$.data.tagIds[1]").value("tag-2"))
    }

    @Test
    fun `updateTransactionSplits returns split allocation result`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateTransactionSplitsResponseData(
                transactionId = "t1",
                hasSplitTransactions = true,
                splitTransactions =
                    listOf(
                        TransactionSplit(id = "s1", amount = -60.0, merchantName = "Costco", categoryName = "Groceries"),
                    ),
            ),
        )

        mvc
            .perform(
                post("/v1/transactions/t1/splits")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                        """
                        {
                          "splitData": [
                            {"merchantName": "Costco", "amount": -60.0, "categoryId": "cat-1"},
                            {"merchantName": "Costco", "amount": -40.0, "categoryId": "cat-2"}
                          ]
                        }
                        """.trimIndent(),
                    ),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.transactionId").value("t1"))
            .andExpect(jsonPath("$.data.hasSplitTransactions").value(true))
            .andExpect(jsonPath("$.data.splitTransactions[0].id").value("s1"))
    }

    @Test
    fun `uploadTransactionAttachment runs the three-step flow and returns the attachment`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)

        val uploadInfo =
            GetTransactionAttachmentUploadInfo.UploadInfo(
                cloudinaryPath = "https://api.cloudinary.com/v1_1/monarch-money/image/upload/",
                timestamp = "1716595200",
                folder = "monarch/transactions",
                signature = "sig-abc",
                apiKey = "key-123",
                uploadPreset = "preset-x",
            )
        val attachment =
            TransactionAttachment(
                id = "att-1",
                publicId = "pub-1",
                extension = "jpg",
                sizeBytes = 1234,
                filename = "receipt.jpg",
                originalAssetUrl = "https://res.cloudinary.com/monarch-money/pub-1.jpg",
            )
        // Stub the two execute() calls by matching on the operation argument; cannot use
        // stubExec twice here because its matcher is `any to any`, so the second call would
        // overwrite the first.
        doReturn(uploadInfo)
            .`when`(client)
            .execute(eqOp(GetTransactionAttachmentUploadInfo), anyInput())
        doReturn(attachment)
            .`when`(client)
            .execute(eqOp(AddTransactionAttachment), anyInput())
        doReturn(jsonNode("""{"public_id": "pub-1", "format": "jpg", "bytes": 1234}"""))
            .`when`(client)
            .uploadToExternal(anyStringArg(), anyMapArg())

        val file = MockMultipartFile("file", "receipt.jpg", "image/jpeg", "fake-bytes".toByteArray())

        mvc
            .perform(multipart("/v1/transactions/t1/attachments").file(file))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.attachment.id").value("att-1"))
            .andExpect(jsonPath("$.data.attachment.publicId").value("pub-1"))
            .andExpect(jsonPath("$.data.attachment.extension").value("jpg"))
            .andExpect(jsonPath("$.data.attachment.sizeBytes").value(1234))
            .andExpect(jsonPath("$.data.attachment.filename").value("receipt.jpg"))
    }

    @Test
    fun `uploadTransactionAttachment returns 502 when Cloudinary upload fails`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)

        val uploadInfo =
            GetTransactionAttachmentUploadInfo.UploadInfo(
                cloudinaryPath = "https://api.cloudinary.com/v1_1/monarch-money/image/upload/",
                timestamp = "1716595200",
                folder = "monarch/transactions",
                signature = "sig-abc",
                apiKey = "key-123",
                uploadPreset = "preset-x",
            )
        doReturn(uploadInfo)
            .`when`(client)
            .execute(eqOp(GetTransactionAttachmentUploadInfo), anyInput())
        doThrow(MonarchRequestFailedException(500, "boom", "External upload to api.cloudinary.com returned HTTP 500"))
            .`when`(client)
            .uploadToExternal(anyStringArg(), anyMapArg())

        val file = MockMultipartFile("file", "receipt.jpg", "image/jpeg", "fake-bytes".toByteArray())

        mvc
            .perform(multipart("/v1/transactions/t1/attachments").file(file))
            .andExpect(status().isBadGateway)
            .andExpect(jsonPath("$.code").value("monarch_request_failed"))
    }

    @Test
    fun `listTransactions threads search, multi-id lists, and bool predicates into Input`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        val captured = stubExecAndCapture(client, ListTransactionsResponseData(totalCount = 0, results = emptyList()))

        mvc
            .perform(
                get("/v1/transactions")
                    .param("start", "2026-05-01")
                    .param("end", "2026-05-31")
                    .param("search", "Netflix")
                    .param("categoryIds", "c-1", "c-2")
                    .param("accountIds", "a-1", "a-2")
                    .param("tagIds", "t-1")
                    .param("isRecurring", "true")
                    .param("hasAttachments", "false")
                    .param("transactionVisibility", "all_transactions"),
            ).andExpect(status().isOk)

        val input = captured.last() as GetTransactions.Input
        assertThat(input.startDate).isEqualTo("2026-05-01")
        assertThat(input.endDate).isEqualTo("2026-05-31")
        assertThat(input.filters.search).isEqualTo("Netflix")
        assertThat(input.filters.categoryIds).containsExactly("c-1", "c-2")
        assertThat(input.filters.accountIds).containsExactly("a-1", "a-2")
        assertThat(input.filters.tagIds).containsExactly("t-1")
        assertThat(input.filters.isRecurring).isEqualTo(true)
        assertThat(input.filters.hasAttachments).isEqualTo(false)
        assertThat(input.filters.transactionVisibility).isEqualTo("all_transactions")
        // Untouched predicates stay null so the underlying filters map omits them.
        assertThat(input.filters.hasNotes).isNull()
        assertThat(input.filters.isSplit).isNull()
        assertThat(input.filters.needsReview).isNull()
    }

    @Test
    fun `getTransactionsSummary threads filter params into Input`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        val captured =
            stubExecAndCapture(
                client,
                GetTransactionsSummaryResponseData(summary = TransactionsSummary(count = 0)),
            )

        mvc
            .perform(
                get("/v1/transactions/summary")
                    .param("search", "Costco")
                    .param("hideFromReports", "true")
                    .param("needsReview", "false"),
            ).andExpect(status().isOk)

        val input = captured.last() as GetTransactionsSummary.Input
        assertThat(input.filters.search).isEqualTo("Costco")
        assertThat(input.filters.hideFromReports).isEqualTo(true)
        assertThat(input.filters.needsReview).isEqualTo(false)
        assertThat(input.filters.isSplit).isNull()
    }

    @Test
    fun `getCashflow threads filter params into Input`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        val captured = stubExecAndCapture(client, GetCashflowResponseData(summary = CashflowSummary()))

        mvc
            .perform(
                get("/v1/cashflow")
                    .param("categoryIds", "c-rent", "c-food")
                    .param("isRecurring", "true"),
            ).andExpect(status().isOk)

        val input = captured.last() as GetCashflowSummary.Input
        assertThat(input.filters.categoryIds).containsExactly("c-rent", "c-food")
        assertThat(input.filters.isRecurring).isEqualTo(true)
    }

    @Test
    fun `getCashflowBreakdown threads filter params into Input`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        val captured =
            stubExecAndCapture(
                client,
                GetCashflowBreakdownResponseData(
                    byCategory = emptyList(),
                    byCategoryGroup = emptyList(),
                    byMerchant = emptyList(),
                ),
            )

        mvc
            .perform(
                get("/v1/cashflow/breakdown")
                    .param("tagIds", "biz")
                    .param("isSplit", "true")
                    .param("importedFromMint", "false"),
            ).andExpect(status().isOk)

        val input = captured.last() as GetCashflowBreakdown.Input
        assertThat(input.filters.tagIds).containsExactly("biz")
        assertThat(input.filters.isSplit).isEqualTo(true)
        assertThat(input.filters.importedFromMint).isEqualTo(false)
    }

    @Test
    fun `getAttachment wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetAttachmentResponseData(
                attachment = AttachmentDetail(id = "att-1", originalAssetUrl = "https://cdn/receipt.jpg"),
            ),
        )
        mvc
            .perform(get("/v1/attachments/att-1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.attachment.id").value("att-1"))
            .andExpect(jsonPath("$.data.attachment.originalAssetUrl").value("https://cdn/receipt.jpg"))
    }

    @Test
    fun `markTransactionStreamAsNotRecurring wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, MarkTransactionStreamAsNotRecurringResponseData(success = true))
        mvc
            .perform(post("/v1/transactions/stream-1/not-recurring"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.success").value(true))
    }

    @Test
    fun `getReviewSummaryByUser returns row list`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetReviewSummaryByUserResponseData(
                rows =
                    listOf(
                        ReviewSummaryByUserRow(count = 5, userId = "u-1", name = "Sam"),
                        ReviewSummaryByUserRow(count = 3, userId = "u-2", name = "Pat"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/transactions/review-summary"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.rows[0].count").value(5))
            .andExpect(jsonPath("$.data.rows[0].userId").value("u-1"))
            .andExpect(jsonPath("$.data.rows[1].name").value("Pat"))
    }

    @Test
    fun `getCashflowDashboard wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCashflowDashboardResponseData(
                byDay =
                    listOf(
                        CashflowDayPoint(day = LocalDate.parse("2026-05-01"), sumExpense = -42.5),
                        CashflowDayPoint(day = LocalDate.parse("2026-05-02"), sumExpense = -19.99),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/cashflow/dashboard"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.byDay[0].day").value("2026-05-01"))
            .andExpect(jsonPath("$.data.byDay[0].sumExpense").value(-42.5))
            .andExpect(jsonPath("$.data.byDay[1].sumExpense").value(-19.99))
    }

    @Test
    fun `getCashflowTimeframe wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCashflowTimeframeResponseData(
                byYear = listOf(CashflowTimeframeBucket(period = "2026", sumIncome = 100000.0)),
                byMonth = listOf(CashflowTimeframeBucket(period = "2026-05-01", sumIncome = 8500.0)),
                byQuarter = listOf(CashflowTimeframeBucket(period = "2026-Q2", sumIncome = 25500.0)),
            ),
        )
        mvc
            .perform(get("/v1/cashflow/timeframe"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.byYear[0].period").value("2026"))
            .andExpect(jsonPath("$.data.byMonth[0].period").value("2026-05-01"))
            .andExpect(jsonPath("$.data.byQuarter[0].period").value("2026-Q2"))
    }

    @Test
    fun `getCashflowEntities wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCashflowEntitiesResponseData(
                byCategory =
                    listOf(
                        CashflowEntityCategoryRow(
                            category = CashflowCategoryRef(id = "c-1", name = "Groceries"),
                            sum = -350.5,
                        ),
                    ),
                byCategoryGroup =
                    listOf(
                        CashflowCategoryGroupRow(
                            categoryGroup = CashflowCategoryGroupRef(id = "g-1", name = "Food", type = "expense"),
                            sum = -1200.0,
                        ),
                    ),
                byMerchant =
                    listOf(
                        CashflowMerchantRow(
                            merchant = CashflowMerchantRef(id = "m-1", name = "Whole Foods"),
                            sumExpense = -350.5,
                        ),
                    ),
                summary = CashflowSummary(sumIncome = 9000.0, sumExpense = -5000.0, savings = 4000.0),
            ),
        )
        mvc
            .perform(get("/v1/cashflow/entities"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.byCategory[0].category.id").value("c-1"))
            .andExpect(jsonPath("$.data.byCategoryGroup[0].categoryGroup.name").value("Food"))
            .andExpect(jsonPath("$.data.byMerchant[0].merchant.name").value("Whole Foods"))
            .andExpect(jsonPath("$.data.summary.savings").value(4000.0))
    }

    @Test
    fun `getCashflowFiltered wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCashflowFilteredResponseData(
                summary = CashflowSummary(sumIncome = 8500.0),
                byMonth = listOf(CashflowTimeframeBucket(period = "2026-05-01", sumIncome = 8500.0)),
                byCategory =
                    listOf(
                        CashflowEntityCategoryRow(
                            category = CashflowCategoryRef(id = "c-1", name = "Food"),
                            sum = -350.0,
                        ),
                    ),
            ),
        )
        mvc
            .perform(
                get("/v1/cashflow/filtered")
                    .param("accountId", "a-1")
                    .param("categoryId", "c-1"),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.summary.sumIncome").value(8500.0))
            .andExpect(jsonPath("$.data.byMonth[0].period").value("2026-05-01"))
            .andExpect(jsonPath("$.data.byCategory[0].category.name").value("Food"))
    }

    @Test
    fun `explainTransaction wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, ExplainTransactionResponseData(explanation = "Monthly subscription"))
        mvc
            .perform(get("/v1/transactions/t-1/explain"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.explanation").value("Monthly subscription"))
    }

    @Test
    fun `getTransactionsDashboard wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTransactionsDashboardResponseData(
                results =
                    listOf(
                        DashboardTransactionRow(
                            id = "t-1",
                            date = LocalDate.parse("2026-05-25"),
                            amount = -19.99,
                            merchantName = "Starbucks",
                            accountDisplayName = "Acme Bank",
                        ),
                    ),
                totalCount = 42,
                totalSelectableCount = 38,
                ruleCount = 2,
                summaryCount = 42,
            ),
        )
        mvc
            .perform(get("/v1/transactions/dashboard").param("limit", "25").param("offset", "0"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.totalCount").value(42))
            .andExpect(jsonPath("$.data.totalSelectableCount").value(38))
            .andExpect(jsonPath("$.data.ruleCount").value(2))
            .andExpect(jsonPath("$.data.results[0].id").value("t-1"))
            .andExpect(jsonPath("$.data.results[0].merchantName").value("Starbucks"))
    }

    @Test
    fun `getAccountsForTransactionFilter wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetAccountsForTransactionFilterResponseData(
                accounts =
                    listOf(
                        AccountForFilterRow(id = "a-1", displayName = "Checking"),
                        AccountForFilterRow(id = "a-2", displayName = "Savings", institutionId = "inst-1"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/transactions/accounts-for-filter").param("start", "2026-05-01").param("end", "2026-05-31"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.accounts[0].id").value("a-1"))
            .andExpect(jsonPath("$.data.accounts[1].institutionId").value("inst-1"))
    }

    /**
     * Variant of `stubExec` that also captures each [Input] passed to `client.execute(...)`
     * via an Answer (no fragile ArgumentCaptor/eq dance — those don't compose cleanly with
     * Mockito's generic + Kotlin null-safety interaction). Returns a live list the test can
     * inspect after the MVC call.
     */
    private fun <T : Any> stubExecAndCapture(
        client: MonarchClient,
        result: T,
    ): MutableList<Any?> {
        val captured = mutableListOf<Any?>()
        doAnswer { invocation ->
            captured.add(invocation.getArgument(1))
            result
        }.`when`(client).execute(anyOp<Any, T>(), anyInputArg())
        return captured
    }

    @Suppress("UNCHECKED_CAST")
    private fun <I, O> anyOp(): MonarchOperation<I, O> {
        ArgumentMatchers.any<MonarchOperation<I, O>>()
        return MonarchOperationSentinel as MonarchOperation<I, O>
    }

    private fun anyInputArg(): Any {
        ArgumentMatchers.any<Any>()
        return Unit
    }

    private object MonarchOperationSentinel : MonarchOperation<Any, Any> {
        override val operationName: String = ""
        override val query: String = ""

        override fun variables(input: Any): Map<String, Any?> = emptyMap()

        override fun parseOutput(data: com.fasterxml.jackson.databind.JsonNode): Any = Unit
    }

    /**
     * `ArgumentMatchers.eq(value)` registers the matcher but returns `null` for object types,
     * which crashes Kotlin's non-null call site. Register the matcher, then return the same
     * non-null reference so Mockito's varargs collector accepts it.
     */
    @Suppress("UNCHECKED_CAST")
    private fun <I, O> eqOp(op: MonarchOperation<I, O>): MonarchOperation<Any, Any> {
        ArgumentMatchers.eq(op)
        return op as MonarchOperation<Any, Any>
    }

    /** Same trick for the input arg of [MonarchClient.execute]: register `any`, return non-null sentinel. */
    private fun anyInput(): Any {
        ArgumentMatchers.any<Any>()
        return Unit
    }

    private fun anyStringArg(): String {
        ArgumentMatchers.anyString()
        return ""
    }

    @Suppress("UNCHECKED_CAST")
    private fun anyMapArg(): Map<String, Any> {
        ArgumentMatchers.any<Map<String, Any>>()
        return emptyMap()
    }
}
