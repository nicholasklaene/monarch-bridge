# High-Level Design — monarch-proxy

## What this is

`monarch-proxy` is a **stateless HTTP pass-through wrapper** over Monarch Money's GraphQL
API. It exposes Monarch's financial data (accounts, transactions, cashflow, categories, tags)
as REST endpoints for consumption by personal finance tooling and AI agents.

Port: **9084**. Repo: `nicholasklaene/monarch-proxy` (private). Lives in personal GitHub
because the data is personal — every account, transaction, and balance reachable through
Monarch belongs to Nick, not to any business entity.

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

- A **file-cached session token** (`~/.config/monarch-proxy/.mm-session.json`). Written
  once by the interactive bootstrap CLI; read on startup and on-demand via `POST /v1/auth/refresh`.
  See `api/src/main/kotlin/.../services/MonarchSessionService.kt`.
- The **GraphQL query strings** ported from `bradleyseanf/monarchmoneycommunity@dev`
  (`monarchmoney/monarchmoney.py`). See `services/MonarchQueries.kt` and `services/MonarchFragments.kt`.
- The **HTTP surface** — 8 endpoints described below.

## What it does NOT own

- Account balances, transaction history, cashflow data — all live in Monarch.
- Auth credentials — never stored; session token is the only persisted artifact.
- Cross-account identity mapping — callers attribute accounts to entities themselves.

## Auth-deferred posture

The bootstrap flow (`./gradlew :api:bootstrapMonarch`) is interactive and intentionally NOT
run autonomously. The service starts cleanly with no session — data endpoints return 503 with
`{"code":"session_missing","message":"Run :api:bootstrapMonarch"}`. This is a feature, not a
bug: it makes the "not bootstrapped" state visible and explicit.

Full end-to-end auth is tracked in ticket `monarch-bootstrap-auth`
(`agents/tickets/monarch-bootstrap-auth.md`).

## Bootstrap flow (after first-run auth)

```
1. ./gradlew :api:bootstrapMonarch
   → prompts for email + password + MFA code (or TOTP secret)
   → writes ~/.config/monarch-proxy/.mm-session.json

2. POST /v1/auth/refresh
   → MonarchSessionService reloads from disk
   → subsequent GET /v1/accounts returns real data
```

## Endpoints

| Method | Path | Notes |
|---|---|---|
| GET | `/healthz` | Always 200. `authenticated` reflects session presence. |
| GET | `/v1/accounts` | Monarch `get_accounts`. Balances + institution. |
| GET | `/v1/account/{id}/history` | Monarch `get_account_history`. Daily balances. |
| GET | `/v1/transactions` | Monarch `get_transactions`. Params: start/end/limit/offset/accountId. |
| GET | `/v1/cashflow` | Monarch `get_cashflow_summary`. Params: start/end. |
| GET | `/v1/categories` | Monarch `get_transaction_categories`. |
| GET | `/v1/tags` | Monarch `get_transaction_tags`. |
| POST | `/v1/refresh` | Monarch `request_accounts_refresh` mutation. Returns 202. |
| GET | `/v1/auth/status` | `{authenticated, email, lastVerifiedAt}`. |
| POST | `/v1/auth/refresh` | Reload session from disk (post-bootstrap, no restart needed). |

## Deployment

- **Local dev:** `docker compose up -d` (repo root `docker-compose.yml`).
- **Session mount:** bind-mount `${HOME}/.config/monarch-proxy` to `/var/monarch-proxy/session`.

## Plan reference

Full V1 scope, stage-by-stage implementation plan, and deferred items:
`~/.claude/plans/declarative-singing-yao.md`
