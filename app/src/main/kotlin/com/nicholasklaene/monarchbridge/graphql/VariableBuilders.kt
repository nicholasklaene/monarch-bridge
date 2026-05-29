package com.nicholasklaene.monarchbridge.graphql

/**
 * Build a [Map] from `(key, value)` pairs, dropping any entry whose value is `null`.
 *
 * GraphQL operations that accept "patch"-style inputs (UpdateTransaction, UpdateAccount, etc.)
 * use this to assemble the `input` variable from a typed Kotlin data class with nullable
 * fields — only the non-null fields are serialized into the request body.
 *
 * ```
 * val input = mapOfNotNull(
 *     "id" to "abc",
 *     "category" to input.category,   // may be null — dropped if so
 *     "notes" to input.notes,
 * )
 * ```
 */
fun mapOfNotNull(vararg pairs: Pair<String, Any?>): Map<String, Any?> {
    val nonNull = pairs.mapNotNull { (k, v) -> v?.let { k to it } }
    return nonNull.toMap()
}
