package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MarkTransactionAsReviewedOperationTest {
    @Test
    fun `parseOutput extracts id reviewedAt and needsReview from the updateTransaction payload`() {
        val data =
            jsonNode(
                """
                {
                  "updateTransaction": {
                    "transaction": {
                      "id": "txn-1",
                      "reviewedAt": "2026-05-26T18:00:00Z",
                      "needsReview": false
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = MarkTransactionAsReviewed.parseOutput(data)
        assertThat(out.id).isEqualTo("txn-1")
        assertThat(out.reviewedAt).isEqualTo("2026-05-26T18:00:00Z")
        assertThat(out.needsReview).isFalse()
    }

    @Test
    fun `parseOutput leaves reviewedAt null when Monarch omits the field`() {
        val data =
            jsonNode(
                """
                {"updateTransaction": {"transaction": {"id": "txn-2", "needsReview": true}}}
                """.trimIndent(),
            )
        val out = MarkTransactionAsReviewed.parseOutput(data)
        assertThat(out.id).isEqualTo("txn-2")
        assertThat(out.reviewedAt).isNull()
        assertThat(out.needsReview).isTrue()
    }

    @Test
    fun `variables nest id and reviewed=true under input`() {
        val vars = MarkTransactionAsReviewed.variables(MarkTransactionAsReviewed.Input(id = "txn-3"))

        @Suppress("UNCHECKED_CAST")
        val inner = vars["input"] as Map<String, Any?>
        assertThat(inner["id"]).isEqualTo("txn-3")
        assertThat(inner["reviewed"]).isEqualTo(true)
    }

    @Test
    fun `operationName matches the graphql file mutation identifier`() {
        assertThat(MarkTransactionAsReviewed.operationName).isEqualTo("Common_MarkTransactionAsReviewed")
    }

    @Test
    fun `query loads and includes the PayloadErrorFields fragment`() {
        val q = MarkTransactionAsReviewed.query
        assertThat(q).contains("mutation Common_MarkTransactionAsReviewed")
        assertThat(q).contains("fragment PayloadErrorFields")
    }
}
