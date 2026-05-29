package com.nicholasklaene.monarchbridge.graphql

import java.util.concurrent.ConcurrentHashMap

/**
 * Loads `.graphql` resource files from the classpath and composes them with their required
 * fragments. Results are cached so repeated calls are free after warmup.
 *
 * Files live at:
 * - `src/main/resources/graphql/operations/<OperationName>.graphql`
 * - `src/main/resources/graphql/fragments/<FragmentName>.graphql`
 *
 * Filenames must match the GraphQL `operation`/`fragment` identifier exactly (e.g.
 * `Web_SetTransactionTags.graphql`, `PayloadErrorFields.graphql`).
 *
 * Composition rule: the loaded query body is concatenated with each fragment body, separated
 * by blank lines. Monarch's GraphQL endpoint parses the combined document and resolves
 * `...FragmentName` references against the appended fragment definitions.
 */
object GraphQLLoader {
    private val cache = ConcurrentHashMap<String, String>()

    /**
     * Load an operation document, optionally composed with fragments.
     *
     * @param operationName matches the file at `graphql/operations/<operationName>.graphql`
     * @param fragments names of fragments at `graphql/fragments/<name>.graphql`; appended verbatim
     * @return the full GraphQL document ready to POST to Monarch
     */
    fun load(
        operationName: String,
        fragments: List<String> = emptyList(),
    ): String {
        val cacheKey = if (fragments.isEmpty()) operationName else "$operationName::${fragments.joinToString(",")}"
        return cache.getOrPut(cacheKey) {
            val body = loadResource("operations/$operationName.graphql")
            if (fragments.isEmpty()) {
                body
            } else {
                val fragmentBodies = fragments.joinToString("\n\n") { loadResource("fragments/$it.graphql") }
                "$body\n\n$fragmentBodies"
            }
        }
    }

    /** Load a single fragment body. Useful for tests; production code uses [load]. */
    fun fragment(name: String): String = loadResource("fragments/$name.graphql")

    private fun loadResource(relativePath: String): String {
        val path = "graphql/$relativePath"
        val stream =
            this::class.java.classLoader.getResourceAsStream(path)
                ?: error(
                    "GraphQL resource not found: $path. " +
                        "Check src/main/resources/$path exists and the filename matches the operation/fragment name.",
                )
        return stream.bufferedReader().use { it.readText() }.trim()
    }
}
