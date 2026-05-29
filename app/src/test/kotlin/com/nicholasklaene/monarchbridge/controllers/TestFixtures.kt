package com.nicholasklaene.monarchbridge.controllers

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.auth.MonarchSession
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.doThrow
import java.time.Instant

/**
 * Kotlin-safe wrapper around [ArgumentMatchers.any]. `ArgumentMatchers.any()` registers the
 * matcher but returns `null` for object types, which crashes Kotlin's non-null `as` cast.
 * Calling the parameterized form registers the matcher; we then return a non-null sentinel
 * value Mockito's varargs collector accepts (the actual value is unused — the matcher is
 * what drives matching).
 */
@Suppress("UNCHECKED_CAST")
private fun <T> anyKt(): T {
    ArgumentMatchers.any<T>()
    return null as T
}

/**
 * Shared test fixtures for controller WebMvcTest classes.
 *
 * Two utilities:
 * - [FAKE_SESSION] — a valid [MonarchSession] for stubbing `sessionService.current()`.
 * - [stubExec] / [stubExecThrows] — wrap the type-erased Mockito matchers needed because
 *   `MonarchClient.execute<I, O>(...)` is a generic method that Mockito's type-safe matchers
 *   can't infer in Kotlin.
 */
internal object TestFixtures {
    val FAKE_SESSION =
        MonarchSession(
            token = "fake-token",
            email = "test@example.com",
            lastVerifiedAt = Instant.parse("2026-05-03T10:00:00Z"),
        )

    /** Stub `client.execute(<any op>, <any input>)` to return [result]. */
    fun <T : Any> stubExec(
        client: MonarchClient,
        result: T,
    ) {
        doReturn(result)
            .`when`(client)
            .execute(
                anyKt<MonarchOperation<Any, T>>(),
                anyKt<Any>(),
            )
    }

    /** Stub `client.execute(<any op>, <any input>)` to throw [throwable]. */
    fun stubExecThrows(
        client: MonarchClient,
        throwable: Throwable,
    ) {
        doThrow(throwable)
            .`when`(client)
            .execute(
                anyKt<MonarchOperation<Any, Any>>(),
                anyKt<Any>(),
            )
    }

    /** Parse a JSON-string fixture into a [JsonNode] using a small ObjectMapper. */
    fun jsonNode(text: String): JsonNode =
        com.fasterxml.jackson.databind
            .ObjectMapper()
            .readTree(text)

    /**
     * Load a JSON fixture from the classpath under `fixtures/`.
     *
     * Pass a slash-separated path relative to `src/test/resources/fixtures/`, with or
     * without the trailing `.json`. For example:
     *  - `loadFixture("getTransactions/full")`
     *  - `loadFixture("getAccounts/multi-type.json")`
     *
     * Throws [IllegalArgumentException] if the fixture is missing — fail-fast surfaces
     * typos at the call site rather than letting a null node cascade into a vague
     * downstream assertion failure.
     */
    fun loadFixture(name: String): JsonNode {
        val path = "fixtures/${name.removeSuffix(".json")}.json"
        val stream =
            TestFixtures::class.java.classLoader.getResourceAsStream(path)
                ?: throw IllegalArgumentException("Fixture not found on classpath: $path")
        return stream.use {
            com.fasterxml.jackson.databind
                .ObjectMapper()
                .readTree(it)
        }
    }
}
