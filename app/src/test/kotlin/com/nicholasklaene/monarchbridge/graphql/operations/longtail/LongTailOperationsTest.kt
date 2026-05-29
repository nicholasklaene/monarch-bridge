package com.nicholasklaene.monarchbridge.graphql.operations.longtail

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Smoke tests for the long-tail operation base + a handful of concrete subclasses.
 *
 * The long-tail surface is wide (165 operations) and intentionally generic. The base
 * class handles the actual plumbing (variable forwarding, JsonNode -> Map parsing); the
 * concrete subclasses are one-liners that only declare the upstream operation name. We
 * exercise the base behaviour once via the base class and a couple of representative
 * subclasses; doing this op-by-op would add nothing beyond compile-time guarantees the
 * controller test already provides.
 */
class LongTailOperationsTest {
    private val mapper = ObjectMapper()

    /** Concrete subclass used only by the unit test below. Mirrors the production pattern. */
    private object SampleOp : LongTailOperation("Sample")

    @Test
    fun `operationName is bound by the subclass constructor`() {
        assertThat(SampleOp.operationName).isEqualTo("Sample")
        assertThat(GetAccount.operationName).isEqualTo("Common_GetAccount")
        assertThat(ArchiveGoal.operationName).isEqualTo("Common_ArchiveGoal")
    }

    @Test
    fun `variables forwards the caller map verbatim`() {
        val input = mapOf("id" to "abc", "limit" to 10, "nested" to mapOf("flag" to true))
        assertThat(SampleOp.variables(input)).isEqualTo(input)
    }

    @Test
    fun `variables returns an empty map when caller passes nothing`() {
        assertThat(SampleOp.variables(emptyMap())).isEmpty()
    }

    @Test
    fun `parseOutput materializes the JsonNode as a top-level map`() {
        val json =
            """
            {
              "account": { "id": "a1", "displayName": "Brokerage" },
              "count": 7,
              "active": true
            }
            """.trimIndent()
        val result = SampleOp.parseOutput(mapper.readTree(json))
        assertThat(result["count"]).isEqualTo(7)
        assertThat(result["active"]).isEqualTo(true)
        @Suppress("UNCHECKED_CAST")
        val account = result["account"] as Map<String, Any>
        assertThat(account["id"]).isEqualTo("a1")
        assertThat(account["displayName"]).isEqualTo("Brokerage")
    }

    @Test
    fun `parseOutput drops top-level nulls so result satisfies the non-nullable map shape`() {
        val json =
            """
            {
              "kept": "value",
              "dropped": null
            }
            """.trimIndent()
        val result = SampleOp.parseOutput(mapper.readTree(json))
        assertThat(result).containsOnlyKeys("kept")
    }

    @Test
    fun `query lazy-loads from the classpath operation file`() {
        // GetAccount has a stub .graphql file under graphql/operations/Common_GetAccount.graphql.
        // The query body must be non-empty and reference the operation name.
        assertThat(GetAccount.query).contains("Common_GetAccount")
    }
}
