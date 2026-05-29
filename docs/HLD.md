# High-Level Design: monarch-bridge

## What this is

`monarch-bridge` is a **stateless HTTP pass-through wrapper** over Monarch Money's GraphQL
API. It exposes the full Monarch surface (accounts, transactions, cashflow, categories,
tags, splits, manual account management) as REST endpoints for consumption by personal
finance tooling, the bundled `monarch` CLI, MCP-aware AI assistants, and any HTTP client.
Reads and writes both supported.

Port: **9084**. Repo: `nicholasklaene/monarch-bridge`, MIT-licensed.

## Why no DB / events / persistence

| Capability | Decision |
|---|---|
| Postgres / JPA | None. Monarch owns the data; duplicating it buys nothing. |
| Flyway migrations | None. No schema. |
| Event publishing | None. Monarch data doesn't change minute-to-minute. Force-refresh on demand. |
| Per-source supersession | None. Monarch handles dedup upstream. |
| PII encryption at rest | Not applicable. Nothing persisted. |

Same principle as any thin pass-through: front an external system with a stateless HTTP layer,
let that system own the state.

## What it owns

- A **file-cached session token** (`~/.config/monarch-bridge/.mm-session.json`). Written
  once by the interactive bootstrap CLI; read on startup and on-demand via `POST /v1/auth/refresh`.
  See `app/src/main/kotlin/.../auth/MonarchSessionService.kt`.
- The **GraphQL operation strings** covering Monarch's full read + mutation surface.
  Each operation lives in `app/src/main/resources/graphql/operations/*.graphql` with a
  matching Kotlin object in `graphql/operations/<resource>/`.
- The **HTTP surface**: 768 endpoints (full reference in `agents/context/AGENTS.md`).
- The **bundled `monarch` CLI** (`cli/monarch`): bash + curl + jq wrapper covering every
  endpoint. Destructive ops prompt for confirmation unless `--yes`/`YES=1`.
- The **`:mcp` module**: a Model Context Protocol server that derives one MCP tool per
  spec operation at startup, so Claude Desktop / Cursor / Continue / Cline can call every
  endpoint as a native tool.

## What it does NOT own

- Account balances, transaction history, cashflow data: all live in Monarch.
- Auth credentials: never stored; session token is the only persisted artifact.
- Consumer-side concerns (scope tagging, multi-tenant filtering, entity attribution):
  downstream services do that on their side.

## Auth-deferred posture

The bootstrap flow (`./gradlew :app:bootstrapMonarch`) is interactive and intentionally NOT
run autonomously. The service starts cleanly with no session; data endpoints return 503 with
`{"code":"session_missing","message":"Run :app:bootstrapMonarch"}`. This is a feature, not a
bug: it makes the "not bootstrapped" state visible and explicit.

## Bootstrap flow (after first-run auth)

```
1. ./gradlew :app:bootstrapMonarch
   → prompts for email + password + MFA code (or TOTP secret)
   → writes ~/.config/monarch-bridge/.mm-session.json

2. POST /v1/auth/refresh
   → MonarchSessionService reloads from disk
   → subsequent GET /v1/accounts returns real data
```

## Endpoints + error model

Full endpoint reference (params, response shapes, per-endpoint quirks) and the complete
HTTP error code mapping live in **[../agents/context/AGENTS.md](../agents/context/AGENTS.md)**,
one file for both AI agents and humans consuming the bridge.

This design doc focuses on the *why*; the agent-facing doc covers the *what*.

## Deployment

- **Local dev:** `docker compose up -d` (repo root `docker-compose.yml`).
- **Session mount:** bind-mount `${HOME}/.config/monarch-bridge` to `/var/monarch-bridge/session`.
- **Always-on:** wire up via your platform's service manager (launchd on macOS, systemd on Linux).
  The container is stateless (session JSON is bind-mounted), so any idempotent `docker compose up -d`
  wrapper works.
