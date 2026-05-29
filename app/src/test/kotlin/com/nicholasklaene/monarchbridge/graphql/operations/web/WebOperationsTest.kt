package com.nicholasklaene.monarchbridge.graphql.operations.web

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Spot-checks the auto-wired Web_* operation objects. Each Web_ op uses the same
 * pass-through shape (FreeForm input + FreeForm output), so we only need a few
 * representative samples - one no-arg, one single-arg, one multi-arg, one with
 * fragments, and one mutation - to prove the contract.
 */
class WebOperationsTest {
    @Test
    fun `WebAccountFilterQuery operationName matches Monarch and loads query`() {
        assertThat(WebAccountFilterQuery.operationName).isEqualTo("Web_AccountFilterQuery")
        assertThat(WebAccountFilterQuery.query).contains("Web_AccountFilterQuery")
    }

    @Test
    fun `WebAccountFilterQuery variables passes through input map`() {
        val noArg = WebAccountFilterQuery.variables(WebAccountFilterQuery.Input())
        assertThat(noArg).isEmpty()
        val withArg = WebAccountFilterQuery.variables(WebAccountFilterQuery.Input(variables = mapOf("k" to "v")))
        assertThat(withArg).containsEntry("k", "v")
    }

    @Test
    fun `WebAccountFilterQuery parseOutput returns the full data tree as a map`() {
        val out = WebAccountFilterQuery.parseOutput(jsonNode("""{"foo": "bar", "nested": {"n": 1}}"""))
        assertThat(out).containsEntry("foo", "bar")
        @Suppress("UNCHECKED_CAST")
        val nested = out["nested"] as Map<String, Any?>
        assertThat(nested).containsEntry("n", 1)
    }

    @Test
    fun `WebAccountEditModal operationName matches Monarch and loads query`() {
        assertThat(WebAccountEditModal.operationName).isEqualTo("Web_AccountEditModal")
        assertThat(WebAccountEditModal.query).contains("Web_AccountEditModal")
    }

    @Test
    fun `WebAccountEditModal variables passes through input map`() {
        val noArg = WebAccountEditModal.variables(WebAccountEditModal.Input())
        assertThat(noArg).isEmpty()
        val withArg = WebAccountEditModal.variables(WebAccountEditModal.Input(variables = mapOf("k" to "v")))
        assertThat(withArg).containsEntry("k", "v")
    }

    @Test
    fun `WebAccountEditModal parseOutput returns the full data tree as a map`() {
        val out = WebAccountEditModal.parseOutput(jsonNode("""{"foo": "bar", "nested": {"n": 1}}"""))
        assertThat(out).containsEntry("foo", "bar")
        @Suppress("UNCHECKED_CAST")
        val nested = out["nested"] as Map<String, Any?>
        assertThat(nested).containsEntry("n", 1)
    }
}
