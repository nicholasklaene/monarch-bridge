package com.nicholasklaene.monarchbridge.graphql

import com.fasterxml.jackson.databind.JsonNode

/**
 * Null-safe accessors for [JsonNode] used throughout the typed `parseOutput` paths.
 *
 * Each returns `null` when the underlying node is missing, of the wrong type, or explicit
 * JSON `null`. This is in contrast to Jackson's `asText()` / `asDouble()` / `asBoolean()`
 * which silently coerce / default — behavior that's fine for forgiving consumers but bad
 * when we want a Kotlin `Double?` to mean "Monarch did not return this field".
 */
fun JsonNode.asTextOrNull(): String? =
    when {
        isMissingNode || isNull -> null
        isTextual -> asText()
        else -> null
    }

fun JsonNode.asDoubleOrNull(): Double? =
    when {
        isMissingNode || isNull -> null
        isNumber -> asDouble()
        else -> null
    }

fun JsonNode.asIntOrNull(): Int? =
    when {
        isMissingNode || isNull -> null
        isNumber -> asInt()
        else -> null
    }

fun JsonNode.asBooleanOrNull(): Boolean? =
    when {
        isMissingNode || isNull -> null
        isBoolean -> asBoolean()
        else -> null
    }

/**
 * Get a child node by path; returns `null` if missing or explicit JSON `null`.
 * Use when you want to detect "field absent" vs "field present with default value".
 */
fun JsonNode.pathOrNull(field: String): JsonNode? {
    val node = path(field)
    return if (node.isMissingNode || node.isNull) null else node
}
