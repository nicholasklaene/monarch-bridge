package com.nicholasklaene.monarchbridge.graphql

import com.fasterxml.jackson.databind.JsonNode

/**
 * A typed GraphQL operation (query or mutation) that this proxy exposes.
 *
 * Bundles four things in a single Kotlin `object`:
 *
 * 1. [operationName] — the GraphQL `operationName` field sent with every request. Must match
 *    the `query Foo(...)` / `mutation Foo(...)` keyword in the corresponding `.graphql` file.
 * 2. [query] — the GraphQL document, lazy-loaded from `src/main/resources/graphql/operations/<Name>.graphql`
 *    via [GraphQLLoader] and composed with any declared fragment dependencies.
 * 3. [variables] — converts a typed [TInput] into the `variables` map Monarch expects.
 * 4. [parseOutput] — converts Monarch's raw `data` JsonNode into a typed [TOutput].
 *
 * Concrete operations live in `graphql/operations/<resource>/<Name>.kt` and follow this shape:
 *
 * ```
 * object GetAccounts : MonarchOperation<Unit, GetAccounts.Output> {
 *     override val operationName = "GetAccounts"
 *     override val query by lazy { GraphQLLoader.load(operationName, fragments = listOf("AccountFields")) }
 *
 *     data class Output(val accounts: List<Account>)
 *
 *     override fun variables(input: Unit): Map<String, Any?> = emptyMap()
 *     override fun parseOutput(data: JsonNode): Output =
 *         Output(accounts = data.path("accounts").map { Account.parse(it) })
 * }
 * ```
 *
 * Invoke via [MonarchClient.execute]: the returned value is [TOutput], not a raw `JsonNode`.
 */
interface MonarchOperation<TInput, TOutput> {
    val operationName: String
    val query: String

    fun variables(input: TInput): Map<String, Any?>

    fun parseOutput(data: JsonNode): TOutput
}
