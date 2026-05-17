package com.nicholasklaene.monarchproxy.controllers

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchproxy.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchproxy.models.AuthStatusResponse
import com.nicholasklaene.monarchproxy.models.HealthResponse
import com.nicholasklaene.monarchproxy.services.MonarchClient
import com.nicholasklaene.monarchproxy.services.MonarchQueries
import com.nicholasklaene.monarchproxy.services.MonarchSessionService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

/**
 * Pass-through REST endpoints that proxy GraphQL calls to Monarch Money.
 *
 * Stateless — all state lives in [MonarchSessionService] (in-memory session token loaded from disk).
 * Returns 503 via [com.nicholasklaene.monarchproxy.config.GlobalExceptionHandler] when no session
 * is loaded, for every data endpoint.
 *
 * Endpoint inventory:
 *  GET  /healthz                   — health + auth status (no session required)
 *  GET  /v1/accounts               — GET_ACCOUNTS
 *  GET  /v1/account/{id}/history   — GET_ACCOUNT_HISTORY
 *  GET  /v1/transactions           — GET_TRANSACTIONS (params: start, end, limit, offset, accountId)
 *  GET  /v1/cashflow               — GET_CASHFLOW_SUMMARY (params: start, end)
 *  GET  /v1/categories             — GET_TRANSACTION_CATEGORIES
 *  GET  /v1/tags                   — GET_TRANSACTION_TAGS
 *  POST /v1/refresh                — REQUEST_ACCOUNTS_REFRESH → 202
 *  GET  /v1/auth/status            — auth status (no session required)
 *  POST /v1/auth/refresh           — reloads session from disk, returns new auth status
 */
@RestController
@Suppress("TooManyFunctions")
class MonarchController(
    private val monarchClient: MonarchClient,
    private val monarchSessionService: MonarchSessionService,
) {
    companion object {
        private const val DEFAULT_DAYS_BACK = 30L
    }

    // -----------------------------------------------------------------------------------------
    // Health — no session required
    // -----------------------------------------------------------------------------------------

    @GetMapping("/healthz")
    fun healthz(): ResponseEntity<HealthResponse> = ResponseEntity.ok(HealthResponse.from(monarchSessionService))

    // -----------------------------------------------------------------------------------------
    // Auth — no session required
    // -----------------------------------------------------------------------------------------

    @GetMapping("/v1/auth/status")
    fun authStatus(): ResponseEntity<AuthStatusResponse> {
        val session = monarchSessionService.current()
        return ResponseEntity.ok(AuthStatusResponse.from(session))
    }

    @PostMapping("/v1/auth/refresh")
    fun authRefresh(): ResponseEntity<AuthStatusResponse> {
        val session = monarchSessionService.reload()
        return ResponseEntity.ok(AuthStatusResponse.from(session))
    }

    // -----------------------------------------------------------------------------------------
    // Data endpoints — all require a session (enforced here; 503 via ExceptionHandler)
    // -----------------------------------------------------------------------------------------

    @GetMapping("/v1/accounts")
    fun getAccounts(): ResponseEntity<Map<String, JsonNode>> {
        requireSession()
        val data = monarchClient.executeGraphQL("GetAccounts", MonarchQueries.GET_ACCOUNTS, emptyMap())
        return ResponseEntity.ok(mapOf("data" to data))
    }

    @GetMapping("/v1/account/{id}/history")
    fun getAccountHistory(
        @PathVariable id: String,
    ): ResponseEntity<Map<String, JsonNode>> {
        requireSession()
        val variables = mapOf("id" to id)
        val data =
            monarchClient.executeGraphQL(
                "AccountDetails_getAccount",
                MonarchQueries.GET_ACCOUNT_HISTORY,
                variables,
            )
        return ResponseEntity.ok(mapOf("data" to data))
    }

    @GetMapping("/v1/transactions")
    fun getTransactions(
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) start: LocalDate?,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) end: LocalDate?,
        @RequestParam(required = false) limit: Int?,
        @RequestParam(required = false) offset: Int?,
        @RequestParam(required = false) accountId: String?,
    ): ResponseEntity<Map<String, JsonNode>> {
        requireSession()
        val resolvedStart = start ?: LocalDate.now().minusDays(DEFAULT_DAYS_BACK)
        val resolvedEnd = end ?: LocalDate.now()

        val filters =
            buildMap<String, Any?> {
                put("startDate", resolvedStart.toString())
                put("endDate", resolvedEnd.toString())
                if (accountId != null) put("accountIds", listOf(accountId))
            }
        val variables =
            buildMap<String, Any?> {
                put("filters", filters)
                if (limit != null) put("limit", limit)
                if (offset != null) put("offset", offset)
            }
        val data = monarchClient.executeGraphQL("GetTransactionsList", MonarchQueries.GET_TRANSACTIONS, variables)
        return ResponseEntity.ok(mapOf("data" to data))
    }

    @GetMapping("/v1/cashflow")
    fun getCashflow(
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) start: LocalDate?,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) end: LocalDate?,
    ): ResponseEntity<Map<String, JsonNode>> {
        requireSession()
        val resolvedStart = start ?: LocalDate.now().minusDays(DEFAULT_DAYS_BACK)
        val resolvedEnd = end ?: LocalDate.now()

        val filters =
            mapOf(
                "startDate" to resolvedStart.toString(),
                "endDate" to resolvedEnd.toString(),
            )
        val variables = mapOf("filters" to filters)
        val data =
            monarchClient.executeGraphQL(
                "Web_GetCashFlowPage",
                MonarchQueries.GET_CASHFLOW_SUMMARY,
                variables,
            )
        return ResponseEntity.ok(mapOf("data" to data))
    }

    @GetMapping("/v1/categories")
    fun getCategories(): ResponseEntity<Map<String, JsonNode>> {
        requireSession()
        val data =
            monarchClient.executeGraphQL(
                "GetCategories",
                MonarchQueries.GET_TRANSACTION_CATEGORIES,
                emptyMap(),
            )
        return ResponseEntity.ok(mapOf("data" to data))
    }

    @GetMapping("/v1/tags")
    fun getTags(): ResponseEntity<Map<String, JsonNode>> {
        requireSession()
        val data =
            monarchClient.executeGraphQL(
                "GetHouseholdTransactionTags",
                MonarchQueries.GET_TRANSACTION_TAGS,
                emptyMap(),
            )
        return ResponseEntity.ok(mapOf("data" to data))
    }

    @PostMapping("/v1/refresh")
    fun requestRefresh(): ResponseEntity<Unit> {
        requireSession()
        monarchClient.executeGraphQL(
            "RequestAccountsRefresh",
            MonarchQueries.REQUEST_ACCOUNTS_REFRESH,
            emptyMap(),
        )
        return ResponseEntity.accepted().build()
    }

    // -----------------------------------------------------------------------------------------
    // Internal helpers
    // -----------------------------------------------------------------------------------------

    private fun requireSession() {
        if (monarchSessionService.current() == null) {
            throw MonarchSessionMissingException()
        }
    }
}
