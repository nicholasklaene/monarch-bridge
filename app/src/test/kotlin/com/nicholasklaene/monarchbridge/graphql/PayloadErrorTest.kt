package com.nicholasklaene.monarchbridge.graphql

import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.exceptions.PayloadErrorException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PayloadErrorTest {
    private val mapper = ObjectMapper()

    @Test
    fun `fromNode parses full PayloadErrorFields shape`() {
        val json =
            """
            {
              "message": "Category not found",
              "code": "INVALID_ARGUMENT",
              "fieldErrors": [
                {"field": "categoryId", "messages": ["Invalid id", "Must be a UUID"]}
              ]
            }
            """.trimIndent()
        val err = PayloadError.fromNode(mapper.readTree(json))
        assertThat(err.message).isEqualTo("Category not found")
        assertThat(err.code).isEqualTo("INVALID_ARGUMENT")
        assertThat(err.fieldErrors).hasSize(1)
        assertThat(err.fieldErrors[0].field).isEqualTo("categoryId")
        assertThat(err.fieldErrors[0].messages).containsExactly("Invalid id", "Must be a UUID")
    }

    @Test
    fun `fromNode handles simplified Common_CreateTransactionTag shape`() {
        val json = """{"message": "Tag exists"}"""
        val err = PayloadError.fromNode(mapper.readTree(json))
        assertThat(err.message).isEqualTo("Tag exists")
        assertThat(err.code).isNull()
        assertThat(err.fieldErrors).isEmpty()
    }

    @Test
    fun `fromNode handles missing message and code`() {
        val err = PayloadError.fromNode(mapper.readTree("{}"))
        assertThat(err.message).isNull()
        assertThat(err.code).isNull()
        assertThat(err.fieldErrors).isEmpty()
    }

    @Test
    fun `fromNode skips field-error entries without field`() {
        val json =
            """
            {
              "fieldErrors": [
                {"messages": ["orphan"]},
                {"field": "good", "messages": ["m"]}
              ]
            }
            """.trimIndent()
        val err = PayloadError.fromNode(mapper.readTree(json))
        assertThat(err.fieldErrors).hasSize(1)
        assertThat(err.fieldErrors[0].field).isEqualTo("good")
    }

    @Test
    fun `PayloadErrorException message includes mutation name and first error message`() {
        val err = PayloadError("category not found", "INVALID", emptyList())
        val ex = PayloadErrorException("updateTransaction", listOf(err))
        assertThat(ex.message).contains("updateTransaction").contains("category not found")
    }

    @Test
    fun `PayloadErrorException message falls back when no error message`() {
        val ex = PayloadErrorException("foo", emptyList())
        assertThat(ex.message).contains("foo")
    }
}
