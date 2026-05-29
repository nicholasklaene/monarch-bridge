package com.nicholasklaene.monarchbridge.graphql.operations.tags

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateTagRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TagOperationTest {
    @Test
    fun `GetTransactionTags parses each tag`() {
        val data =
            jsonNode(
                """
                {
                  "householdTransactionTags": [
                    {"id":"t1","name":"Reimbursable","color":"#19D2A5","order":1,"transactionCount":42},
                    {"id":"t2","name":"Tax-deductible","color":"#FFAA00","order":2,"transactionCount":7}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetTransactionTags.parseOutput(data)
        assertThat(out.tags).hasSize(2)
        val first = out.tags.first()
        assertThat(first.id).isEqualTo("t1")
        assertThat(first.name).isEqualTo("Reimbursable")
        assertThat(first.color).isEqualTo("#19D2A5")
        assertThat(first.order).isEqualTo(1)
        assertThat(first.transactionCount).isEqualTo(42)
        assertThat(out.tags[1].name).isEqualTo("Tax-deductible")
        assertThat(out.tags[1].transactionCount).isEqualTo(7)
    }

    @Test
    fun `GetTransactionTags returns empty list when array empty`() {
        val data = jsonNode("""{"householdTransactionTags": []}""")
        val out = GetTransactionTags.parseOutput(data)
        assertThat(out.tags).isEmpty()
    }

    @Test
    fun `GetTransactionTags defaults missing numeric fields to zero`() {
        val data =
            jsonNode(
                """
                {"householdTransactionTags": [
                  {"id":"t9","name":"Bare","color":"#000000"}
                ]}
                """.trimIndent(),
            )
        val out = GetTransactionTags.parseOutput(data)
        assertThat(out.tags).hasSize(1)
        assertThat(out.tags.first().order).isEqualTo(0)
        assertThat(out.tags.first().transactionCount).isEqualTo(0)
    }

    @Test
    fun `CreateTransactionTag parses the new tag from nested response`() {
        val data =
            jsonNode(
                """
                {
                  "createTransactionTag": {
                    "tag": {
                      "id":"new-t","name":"Travel","color":"#3366FF","order":10,"transactionCount":0
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = CreateTransactionTag.parseOutput(data)
        assertThat(out.tag.id).isEqualTo("new-t")
        assertThat(out.tag.name).isEqualTo("Travel")
        assertThat(out.tag.color).isEqualTo("#3366FF")
        assertThat(out.tag.order).isEqualTo(10)
        assertThat(out.tag.transactionCount).isEqualTo(0)
    }

    @Test
    fun `CreateTransactionTag falls back to defaults when fields missing`() {
        val data = jsonNode("""{"createTransactionTag": {"tag": {"id":"y"}}}""")
        val out = CreateTransactionTag.parseOutput(data)
        assertThat(out.tag.id).isEqualTo("y")
        assertThat(out.tag.name).isEmpty()
        assertThat(out.tag.color).isEmpty()
        assertThat(out.tag.order).isEqualTo(0)
        assertThat(out.tag.transactionCount).isEqualTo(0)
    }

    @Test
    fun `CreateTransactionTag Input from copies name and color verbatim`() {
        val req = CreateTagRequest(name = "Travel", color = "#3366FF")
        val input = CreateTransactionTag.Input.from(req)
        assertThat(input.name).isEqualTo("Travel")
        assertThat(input.color).isEqualTo("#3366FF")
    }

    @Test
    fun `CreateTransactionTag variables nest both fields under input`() {
        val vars =
            CreateTransactionTag.variables(
                CreateTransactionTag.Input(name = "Travel", color = "#3366FF"),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = vars["input"] as Map<String, Any?>
        assertThat(inner["name"]).isEqualTo("Travel")
        assertThat(inner["color"]).isEqualTo("#3366FF")
    }
}
