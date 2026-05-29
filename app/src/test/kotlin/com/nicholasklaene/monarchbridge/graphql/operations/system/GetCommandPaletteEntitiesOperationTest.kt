package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GetCommandPaletteEntitiesOperationTest {
    @Test
    fun `parseOutput flattens semanticSearch results into a typed list`() {
        val data =
            jsonNode(
                """
                {
                  "semanticSearch": {
                    "results": [
                      {"id":"a1","type":"account","name":"Chase Checking","icon":null,"logoUrl":"https://logo/chase.png"},
                      {"id":"c1","type":"category","name":"Coffee","icon":"coffee","logoUrl":null},
                      {"id":"t1","type":"tag","name":"Reimbursable","icon":null,"logoUrl":null}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetCommandPaletteEntities.parseOutput(data)
        assertThat(out.results).hasSize(3)
        val first = out.results[0]
        assertThat(first.id).isEqualTo("a1")
        assertThat(first.type).isEqualTo("account")
        assertThat(first.name).isEqualTo("Chase Checking")
        assertThat(first.icon).isNull()
        assertThat(first.logoUrl).isEqualTo("https://logo/chase.png")
        assertThat(out.results[1].type).isEqualTo("category")
        assertThat(out.results[2].type).isEqualTo("tag")
    }

    @Test
    fun `parseOutput returns empty list when results array is empty`() {
        val data = jsonNode("""{"semanticSearch": {"results": []}}""")
        val out = GetCommandPaletteEntities.parseOutput(data)
        assertThat(out.results).isEmpty()
    }

    @Test
    fun `parseOutput defaults missing scalar fields rather than throwing`() {
        val data =
            jsonNode(
                """
                {"semanticSearch": {"results": [{"id":"x"}]}}
                """.trimIndent(),
            )
        val out = GetCommandPaletteEntities.parseOutput(data)
        assertThat(out.results).hasSize(1)
        val only = out.results.first()
        assertThat(only.id).isEqualTo("x")
        assertThat(only.type).isEmpty()
        assertThat(only.name).isEmpty()
        assertThat(only.icon).isNull()
        assertThat(only.logoUrl).isNull()
    }

    @Test
    fun `variables passes the query string verbatim`() {
        val vars = GetCommandPaletteEntities.variables(GetCommandPaletteEntities.Input(query = "chase"))
        assertThat(vars).containsEntry("query", "chase")
    }

    @Test
    fun `operationName matches the graphql file query identifier`() {
        assertThat(GetCommandPaletteEntities.operationName).isEqualTo("Web_GetCommandPaletteEntities")
    }
}
