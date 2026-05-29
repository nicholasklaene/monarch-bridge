package com.nicholasklaene.monarchbridge.graphql.operations.tags

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DeleteHouseholdTransactionTagOperationTest {
    @Test
    fun `parseOutput returns deleted=true when errors array is empty`() {
        val data = jsonNode("""{"deleteTransactionTag": {"errors": []}}""")
        val out = DeleteHouseholdTransactionTag.parseOutput(data)
        assertThat(out.deleted).isTrue()
    }

    @Test
    fun `parseOutput returns deleted=true when errors field is missing`() {
        val data = jsonNode("""{"deleteTransactionTag": {}}""")
        val out = DeleteHouseholdTransactionTag.parseOutput(data)
        assertThat(out.deleted).isTrue()
    }

    @Test
    fun `parseOutput returns deleted=false when errors array contains entries`() {
        val data =
            jsonNode(
                """
                {"deleteTransactionTag": {"errors": [{"message": "tag in use"}]}}
                """.trimIndent(),
            )
        val out = DeleteHouseholdTransactionTag.parseOutput(data)
        assertThat(out.deleted).isFalse()
    }

    @Test
    fun `variables wraps tagId at top level (not inside input)`() {
        val vars = DeleteHouseholdTransactionTag.variables(DeleteHouseholdTransactionTag.Input(tagId = "tag-99"))
        assertThat(vars).containsEntry("tagId", "tag-99")
        assertThat(vars).doesNotContainKey("input")
    }

    @Test
    fun `operationName matches the graphql file mutation identifier`() {
        assertThat(DeleteHouseholdTransactionTag.operationName).isEqualTo("Common_DeleteHouseholdTransactionTag")
    }

    @Test
    fun `query loads and includes the PayloadErrorFields fragment`() {
        val q = DeleteHouseholdTransactionTag.query
        assertThat(q).contains("mutation Common_DeleteHouseholdTransactionTag")
        assertThat(q).contains("fragment PayloadErrorFields")
    }
}
