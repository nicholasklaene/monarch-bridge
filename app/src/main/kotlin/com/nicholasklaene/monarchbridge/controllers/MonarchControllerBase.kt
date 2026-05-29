package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Shared scaffold for per-resource controllers. Holds the two dependencies every controller
 * needs (the GraphQL client and the session service) and provides [exec] — the helper that
 * powers virtually every endpoint:
 *
 * ```
 * override fun listAccounts(): ResponseEntity<ListAccountsResponse> =
 *     ResponseEntity.ok(ListAccountsResponse(data = exec(GetAccounts, Unit)))
 * ```
 *
 * `exec` gates on a session (throws → HTTP 503 if missing), calls Monarch, and returns the
 * operation's typed [MonarchOperation.parseOutput] result. The operation's output is the
 * inner `data` payload (one of the spec-generated `*ResponseData` types); each concrete
 * controller method wraps that payload in the matching spec-generated `*Response`
 * envelope, satisfying the `{"data": …}` contract baked into the OpenAPI spec.
 *
 * Concrete controllers implement a spec-generated `*Api` interface (one per OpenAPI tag).
 * The base is abstract on purpose — Spring should never try to instantiate it as a bean.
 */
abstract class MonarchControllerBase(
    protected val sessionService: MonarchSessionService,
    protected val client: MonarchClient,
) {
    /**
     * Require a session, run the operation against Monarch, return the typed inner-data
     * payload. The concrete controller wraps that payload in the spec-generated
     * `*Response` envelope before returning to Spring.
     */
    protected fun <TInput, TOutput> exec(
        operation: MonarchOperation<TInput, TOutput>,
        input: TInput,
    ): TOutput {
        sessionService.requireCurrent()
        return client.execute(operation, input)
    }
}
