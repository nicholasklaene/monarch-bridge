package com.nicholasklaene.monarchbridge.graphql

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class GraphQLLoaderTest {
    @Test
    fun `load returns an operation body when no fragments are requested`() {
        val q = GraphQLLoader.load("GetAccounts")
        assertThat(q).contains("query GetAccounts").contains("...AccountFields")
    }

    @Test
    fun `load composes operation with declared fragments`() {
        val q = GraphQLLoader.load("Web_SetTransactionTags", fragments = listOf("PayloadErrorFields"))
        assertThat(q).contains("mutation Web_SetTransactionTags")
        assertThat(q).contains("fragment PayloadErrorFields on PayloadError")
    }

    @Test
    fun `load is cached — second call returns the same composed string`() {
        val first = GraphQLLoader.load("GetCategories", fragments = listOf("CategoryFields"))
        val second = GraphQLLoader.load("GetCategories", fragments = listOf("CategoryFields"))
        assertThat(first).isSameAs(second)
    }

    @Test
    fun `load throws when operation resource is missing`() {
        assertThatThrownBy { GraphQLLoader.load("DoesNotExist") }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("GraphQL resource not found")
            .hasMessageContaining("operations/DoesNotExist.graphql")
    }

    @Test
    fun `load throws when a declared fragment is missing`() {
        assertThatThrownBy { GraphQLLoader.load("GetAccounts", fragments = listOf("NotARealFragment")) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("fragments/NotARealFragment.graphql")
    }

    @Test
    fun `fragment loads a single fragment body verbatim`() {
        val f = GraphQLLoader.fragment("PayloadErrorFields")
        assertThat(f).contains("fragment PayloadErrorFields on PayloadError")
        assertThat(f).contains("fieldErrors").contains("message").contains("code")
    }
}
