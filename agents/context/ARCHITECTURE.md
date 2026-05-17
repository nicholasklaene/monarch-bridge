# Architecture — monarch-proxy

> **TL;DR — no DB / no events / pass-through only.** See `docs/HLD.md` for rationale.

## What it is

A thin Kotlin/Spring Boot HTTP wrapper over Monarch Money's GraphQL API. Exposes 8 REST
endpoints. Stateless except for a file-cached session token. Personal repo
(`nicholasklaene/monarch-proxy`) — Monarch holds personal financial data.

## Flat 6-package layout

```
api/src/main/kotlin/com/nicholasklaene/monarchproxy/
├── Application.kt                   # Spring entry point
├── MonarchBootstrapMain.kt          # Interactive CLI — NOT called by the app server
│
├── controllers/
│   └── MonarchController.kt         # @RestController — the 8 pass-through endpoints
│
├── services/
│   ├── MonarchClient.kt             # RestClient wrapper; GraphQL POST; SSRF allowlist
│   ├── MonarchSessionService.kt     # Loads/saves JSON session file from disk
│   ├── MonarchAuth.kt               # login + MFA + TOTP (not called automatically)
│   ├── MonarchQueries.kt            # 7 GraphQL operation const vals
│   ├── MonarchFragments.kt          # 5 GraphQL fragment const vals
│   └── Totp.kt                      # RFC 6238 TOTP (HmacSHA1, no Bouncy Castle)
│
├── models/
│   ├── MonarchSession.kt            # Data class (token, email, lastVerifiedAt)
│   ├── HealthResponse.kt
│   ├── AuthStatusResponse.kt
│   └── ErrorResponse.kt             # Uniform error shape (code, message, details)
│
├── exceptions/
│   ├── MonarchSessionMissingException.kt   # → 503
│   ├── MonarchSessionExpiredException.kt   # → 401
│   ├── MonarchMfaRequiredException.kt      # → thrown during bootstrap only
│   ├── MonarchRateLimitedException.kt      # → 429 + Retry-After
│   └── MonarchRequestFailedException.kt    # → 502
│
└── config/
    ├── MonarchProperties.kt         # @ConfigurationProperties for monarch.*
    └── GlobalExceptionHandler.kt    # @RestControllerAdvice — maps exceptions to HTTP

# Note: MonarchClient builds its RestClient inline (per token); no separate @Bean.
```

No `persistence/` package — no JPA, no Flyway, no Postgres driver on the classpath.
No `kafka/` package — no Spring Kafka, no kre-events lib, no outbox relay.

## Why only 6 packages

No `persistence/` (no DB) and no `kafka/` (no event publishing) — leaving 6 top-level packages.
ArchUnit enforces `noNestedSubpackages` over the 6 that remain.

## Key design constraints (enforced by ArchUnit)

- Controllers annotated `@RestController`, named `*Controller`.
- Models contain no Spring or JPA imports.
- All exceptions extend `RuntimeException`.
- No nested sub-packages under any of the 6 dirs.

## Session lifecycle

```
host filesystem: ~/.config/monarch-proxy/.mm-session.json
        │
        │  (written once by bootstrapMonarch CLI)
        ▼
MonarchSessionService.load()        ← called at startup + on POST /v1/auth/refresh
        │
        ▼  null → MonarchSessionMissingException → 503
MonarchClient  ─── Authorization: Token <t> ──►  api.monarch.com/graphql
```

The container never writes the session file. The host directory is bind-mounted
(read-only in production, read-write for bootstrap flow).

## Mesh — KRE account-gateway

```
KRE account-gateway (:8084)  ─HTTP RestClient─▶  monarch-proxy (this repo, :9084)
        │                                                │
        │  reads canonical Account/Transaction DTOs       │  reads raw Monarch GraphQL JSON
        │  applies scope filter                           │  manages session token
        ▼                                                 ▼
  KRE business consumers                            api.monarch.com/graphql
```

`klaene-real-estate/account-gateway` is the only production consumer today. It calls our
8 data endpoints, maps each Monarch JSON response → canonical Account/Transaction/etc DTOs,
and filters to the KRE-allowed subset before returning to its own callers. Our service is
unaware of this — we return raw Monarch shape verbatim.

## Plan references

V1 scope and deferred work: `~/.claude/plans/declarative-singing-yao.md`.
Personal/KRE split + new `account-gateway`: `~/.claude/plans/where-did-i-get-merry-harp.md`.

## What's intentionally missing (do not add without a new plan)

| Capability | Why missing |
|---|---|
| Postgres / JPA | Monarch owns the data; no reason to duplicate it |
| Flyway migrations | No schema to migrate |
| Event publishing | No domain events to publish |
| Per-source supersession | Monarch handles dedup upstream |
| PII encryption at rest | Nothing persisted |
| MCP wrapper | Deferred — ticket `monarch-mcp-wrapper` |
| CLI wrapper | Deferred — ticket `monarch-cli-wrapper` |
