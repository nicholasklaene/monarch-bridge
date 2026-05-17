# monarch-proxy

Personal thin pass-through HTTP wrapper over [Monarch Money's](https://www.monarchmoney.com) GraphQL API.

Stateless Kotlin/Spring Boot service that holds a session token in a local JSON file and proxies GraphQL calls to `api.monarch.com`. No database, no events. Lives in personal GitHub because the data (every account, transaction, and balance reachable through Monarch) is personal. If/when business tooling needs a slice of this data, the bright line is HTTP — a separate `account-gateway` would call this service and filter to the business-relevant subset.

## What it owns

- Session token cache (single JSON file, gitignored).
- The 7 GraphQL queries we care about (accounts, transactions, balances, history, cashflow, categories, tags).
- 8 REST endpoints exposing those calls.
- A bootstrap CLI for one-time auth (run by hand; not auto-run).

## What it does NOT own

- No persistent database (Monarch is the source of truth).
- No event mesh (Monarch data doesn't change minute-to-minute).
- No per-source supersession or fact tables (Monarch handles dedup; this service is pure pass-through).
- No cross-account identity resolution (callers attribute accounts to entities themselves).

## Endpoints (after bootstrap)

| Method | Path | Underlying Monarch call |
|---|---|---|
| `GET` | `/healthz` | none — returns `{authenticated, lastVerifiedAt}` |
| `GET` | `/v1/accounts` | `get_accounts` |
| `GET` | `/v1/account/{id}/history` | `get_account_history` |
| `GET` | `/v1/transactions?start&end&limit&offset&accountId` | `get_transactions` |
| `GET` | `/v1/cashflow?start&end` | `get_cashflow_summary` |
| `GET` | `/v1/categories` | `get_transaction_categories` |
| `GET` | `/v1/tags` | `get_transaction_tags` |
| `POST` | `/v1/refresh` | `request_accounts_refresh` (mutation) |
| `GET` | `/v1/auth/status` | none — session presence check |
| `POST` | `/v1/auth/refresh` | none — reload session JSON from disk |

Without a session loaded, the data endpoints return `503` with `{"code": "session_missing"}`.

## Setup

### 1. Build

```bash
JAVA_HOME=/opt/homebrew/opt/openjdk@21 ./gradlew :api:check
```

### 2. One-time Monarch authentication

The bootstrap CLI is interactive. It asks for your Monarch email + password + (optional) MFA:

```bash
./gradlew :api:bootstrapMonarch
```

Or with a TOTP secret for non-interactive use:

```bash
./gradlew :api:bootstrapMonarch --args='--mfa-secret=JBSWY3DPEHPK3PXP...'
```

The session is saved to `~/.config/monarch-proxy/.mm-session.json` (override via `MONARCH_SESSION_PATH`).

### 3. Run

```bash
./gradlew :api:bootRun
```

Then:

```bash
curl http://localhost:9084/healthz
curl http://localhost:9084/v1/accounts | jq
```

## Account naming convention

This service returns Monarch's data verbatim — no rewrite. Display names in Monarch use a convention that callers can parse to attribute accounts to entities:

- `Personal — Chase Checking`
- `KRE LLC — Operating (PNC)`
- `8811 — Operating (BoA)`

## Re-auth

Sessions last several months but eventually expire. When endpoints start returning `401 session_expired`:

1. Re-run `./gradlew :api:bootstrapMonarch`.
2. `POST http://localhost:9084/v1/auth/refresh` to make the live service pick up the new session (no restart needed).

## Deployment

Local: `docker compose up -d` from this repo. The session JSON file is bind-mounted into the container — bootstrap once on the host.

## License

Proprietary — personal tooling.
