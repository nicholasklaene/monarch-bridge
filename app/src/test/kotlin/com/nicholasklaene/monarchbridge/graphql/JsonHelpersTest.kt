package com.nicholasklaene.monarchbridge.graphql

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JsonHelpersTest {
    private val mapper = ObjectMapper()

    private fun node(json: String) = mapper.readTree(json)

    @Test
    fun `asTextOrNull returns text for textual nodes`() {
        assertThat(node("""{"x":"hello"}""").path("x").asTextOrNull()).isEqualTo("hello")
    }

    @Test
    fun `asTextOrNull returns null for missing, null, or non-text nodes`() {
        assertThat(node("{}").path("x").asTextOrNull()).isNull()
        assertThat(node("""{"x":null}""").path("x").asTextOrNull()).isNull()
        assertThat(node("""{"x":42}""").path("x").asTextOrNull()).isNull()
        assertThat(node("""{"x":true}""").path("x").asTextOrNull()).isNull()
    }

    @Test
    fun `asDoubleOrNull returns double for numeric nodes`() {
        assertThat(node("""{"x":42.5}""").path("x").asDoubleOrNull()).isEqualTo(42.5)
        assertThat(node("""{"x":7}""").path("x").asDoubleOrNull()).isEqualTo(7.0)
    }

    @Test
    fun `asDoubleOrNull returns null for missing, null, or non-numeric nodes`() {
        assertThat(node("{}").path("x").asDoubleOrNull()).isNull()
        assertThat(node("""{"x":null}""").path("x").asDoubleOrNull()).isNull()
        assertThat(node("""{"x":"42"}""").path("x").asDoubleOrNull()).isNull()
    }

    @Test
    fun `asIntOrNull returns int for numeric nodes`() {
        assertThat(node("""{"x":42}""").path("x").asIntOrNull()).isEqualTo(42)
    }

    @Test
    fun `asIntOrNull returns null for missing or non-numeric nodes`() {
        assertThat(node("{}").path("x").asIntOrNull()).isNull()
        assertThat(node("""{"x":null}""").path("x").asIntOrNull()).isNull()
        assertThat(node("""{"x":"42"}""").path("x").asIntOrNull()).isNull()
    }

    @Test
    fun `asBooleanOrNull returns boolean for boolean nodes`() {
        assertThat(node("""{"x":true}""").path("x").asBooleanOrNull()).isTrue()
        assertThat(node("""{"x":false}""").path("x").asBooleanOrNull()).isFalse()
    }

    @Test
    fun `asBooleanOrNull returns null for missing or non-boolean nodes`() {
        assertThat(node("{}").path("x").asBooleanOrNull()).isNull()
        assertThat(node("""{"x":null}""").path("x").asBooleanOrNull()).isNull()
        assertThat(node("""{"x":"true"}""").path("x").asBooleanOrNull()).isNull()
    }

    @Test
    fun `pathOrNull returns node when present and non-null`() {
        val sub = node("""{"x":{"y":1}}""").pathOrNull("x")
        assertThat(sub).isNotNull
        assertThat(sub?.path("y")?.asInt()).isEqualTo(1)
    }

    @Test
    fun `pathOrNull returns null when missing or explicit json null`() {
        assertThat(node("{}").pathOrNull("x")).isNull()
        assertThat(node("""{"x":null}""").pathOrNull("x")).isNull()
    }
}
