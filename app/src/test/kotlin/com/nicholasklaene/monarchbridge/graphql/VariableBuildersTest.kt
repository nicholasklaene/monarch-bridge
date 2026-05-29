package com.nicholasklaene.monarchbridge.graphql

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VariableBuildersTest {
    @Test
    fun `mapOfNotNull drops nulls`() {
        val result = mapOfNotNull("a" to 1, "b" to null, "c" to "x")
        assertThat(result).containsOnlyKeys("a", "c")
        assertThat(result["a"]).isEqualTo(1)
        assertThat(result["c"]).isEqualTo("x")
    }

    @Test
    fun `mapOfNotNull empty when all nulls`() {
        val result = mapOfNotNull("a" to null, "b" to null)
        assertThat(result).isEmpty()
    }

    @Test
    fun `mapOfNotNull preserves all when no nulls`() {
        val result = mapOfNotNull("x" to 1, "y" to 2, "z" to 3)
        assertThat(result).hasSize(3)
        assertThat(result).containsEntry("y", 2)
    }

    @Test
    fun `mapOfNotNull with empty vararg returns empty`() {
        assertThat(mapOfNotNull()).isEmpty()
    }

    @Test
    fun `mapOfNotNull keeps zero and empty string and false`() {
        val result = mapOfNotNull("zero" to 0, "empty" to "", "false" to false)
        assertThat(result).hasSize(3)
    }
}
