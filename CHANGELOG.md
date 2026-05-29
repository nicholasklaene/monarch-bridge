# Changelog

All notable changes to monarch-bridge.

The format follows [Keep a Changelog](https://keepachangelog.com/en/1.1.0/).
Version numbers follow [Semantic Versioning](https://semver.org/).

## [1.0.0] - 2026-05-26

First public release. Open-source under MIT.

The goal is for the bridge to eventually mirror everything you can do on
monarchmoney.com. v1.0 ships **768 REST endpoints** covering the bulk of the
practical surface, captured directly from Monarch's web GraphQL bundle (most
of these don't appear in either public python lib).

### Surface

- **768 REST endpoints** across 24 controllers, each implementing a
  spec-generated `*Api` interface. Core data domains (System, Account,
  Transaction, Budget, Recurring, Category, Tag, Rule, Goal, Paycheck, Holding,
  Merchant, Settings, Tax, TaxLot) plus the deeper-surface controllers (Advice,
  Forecast, Bills, EquityGrants, BusinessEntity, ReportConfig) and the
  screen-aggregate pass-through tier (WebScreens, MobileScreens, LongTail) that
  together cover the entire wrappable Monarch GraphQL surface.
- **Spec-first end-to-end.** `openapi/monarch-bridge.yaml` (with sibling files
  under `openapi/paths/` and `openapi/components/parameters/`) is the source
  of truth. Both request DTOs **and** response DTOs are generated from it via
  `openapi-generator-gradle-plugin` (`kotlin-spring`). Controllers implement
  the generated `*Api` interfaces; no hand-written `@GetMapping` /
  `@PostMapping` path strings anywhere.
- **PayloadError contract.** Monarch's application-level errors surface as
  HTTP 422 with the structured error body.
- **OpenAPI 3.1 spec** drives generation + Swagger UI (`/docs`).
- **Bundled bash CLI** (`cli/monarch`) covering the core read + write
  surface; `--raw` for piping, `--yes` for destructive ops. New v1.0 endpoints
  beyond the original 48-endpoint set are reachable via HTTP / MCP; CLI
  wrappers for the new surface are a tracked follow-up.
- **`:mcp` Kotlin module** that exposes every endpoint as a native Model Context
  Protocol tool, auto-derived from the OpenAPI spec at startup. Drops into
  Claude Desktop, Cursor, Continue, Cline, etc. via one config-file entry
  (`./gradlew :mcp:installDist`, then point your MCP client at
  `mcp/build/install/monarch-bridge-mcp/bin/monarch-bridge-mcp`).
- **One-command setup**: `./scripts/setup.sh` walks through prereqs check,
  build, interactive auth, docker up, health + auth verification.

### Beyond v1.0 surface (added during launch)

- `GET /v1/recap/weekly`: Monarch's weekly recap (the same block you see at the
  top of the web app on Mondays). Great for "summarize my week" AI prompts.
- `GET /v1/insights`, `GET /v1/insights/{id}`: financial insights feed
  (Monarch's surfaced anomalies / suggestions).
- `GET /v1/portfolio/allocation`, `/v1/portfolio/allocation/by-holdings`,
  `/v1/portfolio/allocation/by-account`, `/v1/portfolio/allocation/holdings-detail`:
  portfolio allocation views matching Monarch's investments tab.
- `GET /v1/securities/{id}/performance`: per-security historical performance.
- `GET /v1/credentials`: all linked Plaid credentials in one call (separate
  from `/v1/institutions`, which couples credentials + accounts + subscription).
- `GET /v1/refresh/latest`: last force-refresh operation status.
- `GET /v1/transactions/review-summary`: count + per-account breakdown of
  txns currently flagged for review.
- `GET /v1/attachments/{id}`: download a single attachment by id.

### Coverage highlights

**Account + investment surface:**
- Accounts CRUD, hidden / include-in-net-worth toggles, history, holdings.
- `POST /v1/accounts/manual-investments`: create a manual investments account
  (e.g. a 401k Monarch can't sync).
- `POST /v1/account/{id}/holdings`: add a manual holding.
- `PATCH /v1/holdings/{id}` + `DELETE /v1/holdings/{id}`: edit / remove
  manual holdings.
- `GET /v1/securities/search?q=`: search securities (ticker / name).
- `POST /v1/accounts/{id}/balance-history` + `GET /v1/balance-history/{key}/status`:
  bulk CSV balance backfill.
- `DELETE /v1/institutions/{id}`: unlink a Plaid credential. Cleans up dead
  connections that no longer auth.

**Transactions:**
- Full CRUD + splits + tags + attachments.
- `GET /v1/transactions` exposes the **full `TransactionFilterInput`**
  (13 fields: `accountIds`, `categoryIds`, `tagIds`, `search`, `hasAttachments`,
  `hasNotes`, `hideFromReports`, `isSplit`, `isRecurring`, `importedFromMint`,
  `syncedFromInstitution`, `needsReview`, `transactionVisibility`).
- `PATCH /v1/transactions/bulk` + `POST /v1/transactions/bulk-delete`: apply
  one update / delete to many txns by id list or by filter.
- `POST /v1/transactions/{id}/attachments`: receipt photo / PDF upload (3-step
  Monarch -> Cloudinary -> Monarch link flow handled internally; SSRF-allowlisted).
- `GET /v1/transactions/duplicates`: server-side dedupe-grouping by
  `(date, amount, plaidName, accountId)`.
- `POST /v1/transactions/{id}/not-recurring`: explicit override.

**Categories + category groups:**
- Categories CRUD + bulk-delete.
- Category groups full CRUD: create, update, delete (with optional
  `moveToGroupId`), update budget-variability (fixed / flexible).

**Budgets:**
- Read window + flex-budget mgmt + per-item set + reset.
- Flex rollover settings.

**Recurring:**
- Upcoming items, all items (extended detail), streams (parent objects),
  monthly aggregate.
- `PATCH /v1/merchants/{id}/recurrence`.

**Transaction rules** (auto-categorization automation):
- `GET/POST/PATCH/DELETE /v1/transaction-rules`.
- `POST /v1/transaction-rules/preview`: dry-run against current transactions;
  returns matches without persisting.

**Savings goals:**
- Full CRUD + contribute + archive / unarchive / hard-delete.
- `GET /v1/goals/{id}/events`: events log.
- `GET /v1/goals/totals/current-month`: progress this month.
- `PUT /v1/goals/priorities`: reorder.
- `PUT /v1/goals/{id}/budget`: monthly budget allocation.

**Paychecks:**
- Full CRUD on paychecks + paycheck-employers.
- `GET /v1/paychecks/summary`: aggregate stats.

**Merchants:**
- `GET /v1/merchants/search?q=`: full-text search with optional logo flag.
- `GET /v1/merchants/{id}`: detail.
- `DELETE /v1/merchants/{id}`, `PATCH /v1/merchants/{id}/logo`.

**System:**
- Health, auth status, auth refresh, force-refresh Plaid (with optional
  `accountIds[]`), refresh-and-wait, subscription, credit history (Spinwheel),
  bulk account update.

### Beats both public python libs

Strict superset of `hammem/monarchmoney` and `bradleyseanf/monarchmoneycommunity`:
every op + every arg they expose is covered, plus the additional surfaces above
(none of which appear in either python lib) captured directly from Monarch's
web JS bundle.

### Quality

- ArchUnit-enforced package conventions + Spotless ktlint + detekt.
- Validation on all write Request DTOs via `jakarta.validation` (constraints
  emitted from the spec).
- CI: GitHub Actions build + test + secret scan on every push.
- Kover line-coverage gate at 90% (the variables() builders are exercised
  end-to-end via the controller WebMvcTests; per-op `parseOutput` tests cover
  the newer paycheck / holdings / merchant / goals-deeper operations).

### Security

- Binds to `127.0.0.1` by default; override via `API_BIND` env var only behind
  a reverse-proxy auth layer.
- Session JSON file written with `0600` permissions.
- Swagger "Try it out" disabled by default to prevent UI-driven writes.
- See [SECURITY.md](SECURITY.md) for full threat model + reporting.

### Documentation (the 5 standard context files)

- `README.md`: public overview, install, consume-five-ways table.
- `CONTRIBUTING.md`: spec-first add-an-endpoint walkthrough.
- `agents/context/AGENTS.md`: single agent-facing reference covering every
  endpoint, every quirk, every error code.
- `agents/context/ARCHITECTURE.md`: package layout + design rationale.
- `agents/context/CURRENT_STATE.md`: what's running right now.

### Still out of scope

- Monarch web surfaces requiring complex onboarding wizards (Plaid Link
  initiation, MX / Finicity Connect token flows). Tied to in-browser widgets
  and not useful through an HTTP bridge.
- Stripe subscription management, in-app message threads, retail sync,
  notifications. Not user-relevant for a power-user bridge.

### Tracked follow-ups

- CLI wrappers for the new v1.0 endpoints (paychecks, holdings, merchants,
  category-group CRUD, savings-goals-deeper, recurring-deeper, transaction
  rules, bulk txn ops). Use HTTP / MCP for now.
- Continue backfilling per-op `parseOutput` tests for operations added in the
  surface expansion; keep the kover gate at 90%.
