package com.nicholasklaene.monarchbridge.mcp

import io.swagger.v3.parser.OpenAPIV3Parser
import io.swagger.v3.parser.core.models.ParseOptions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths

/**
 * Sanity-check: the OpenAPI spec parses and yields the expected number of operations.
 * Catches "I broke the spec" before the MCP client even tries to connect.
 */
class SpecLoadingTest {
    @Test
    fun `spec parses and exposes the expected endpoint count`() {
        // Repo-relative path. Test runs from the :mcp module root.
        val spec = Paths.get("../openapi/monarch-bridge.yaml").toAbsolutePath()
        val options =
            ParseOptions().apply {
                isResolve = true
                isResolveFully = true
            }
        val result = OpenAPIV3Parser().readLocation(spec.toString(), null, options)
        val openApi = result.openAPI

        assertThat(openApi).withFailMessage("Parse errors: ${result.messages}").isNotNull
        // 73 path items times the HTTP methods on each = 96 total operations.
        val opCount =
            openApi.paths.values.sumOf { item ->
                listOfNotNull(item.get, item.post, item.put, item.patch, item.delete).size
            }
        assertThat(opCount).isEqualTo(EXPECTED_OPERATION_COUNT)
        // Every operation has an operationId - required for MCP tool naming.
        val missingOpId =
            openApi.paths.values
                .flatMap { item ->
                    listOfNotNull(item.get, item.post, item.put, item.patch, item.delete)
                }.filter { it.operationId.isNullOrBlank() }
        assertThat(missingOpId).withFailMessage("Operations missing operationId").isEmpty()
    }

    companion object {
        private const val EXPECTED_OPERATION_COUNT = 768
    }
}
