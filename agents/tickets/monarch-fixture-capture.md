---
title: Capture Monarch fixture responses for replay-mode tests
slug: monarch-fixture-capture
priority: P2
status: todo
created: 2026-05-09
repo: monarch-proxy
labels: [monarch-proxy, monarch, testing, wiremock]
---

# Monarch Fixture Capture

## Context

Current WireMock tests use synthetic response bodies (minimal valid shapes). Real Monarch
responses may contain additional fields that affect downstream consumers. Capturing real
responses (secrets stripped) into `src/test/resources/monarch/` enables replay-mode tests
that verify the full deserialization path.

This mirrors the PDS WireMock pattern (see `property-data-service/api/src/test/resources/`).

## Goal / acceptance

- Real Monarch responses captured for each of the 7 GraphQL operations:
  `getAccounts`, `getTransactions`, `getAccountHistory`, `getCashflowSummary`,
  `getTransactionCategories`, `getTransactionTags`, `requestAccountsRefresh`.
- Secrets stripped (no auth tokens, account numbers, real balances — use zero/redacted values).
- Stored as JSON files in `api/src/test/resources/monarch/<operation>.json`.
- At least one WireMock test per controller endpoint updated to use the real fixture file
  (replay mode) rather than the hand-written stub.
- `./gradlew :api:check` green.

## Approach

After auth bootstrap succeeds:
1. Temporarily add response-capture middleware or use curl to capture raw GraphQL responses.
2. Redact sensitive values: replace token with `REDACTED`, account numbers with `****1234`,
   balances with `0.00`, institution names with generic names.
3. Place files in `api/src/test/resources/monarch/`.
4. Update `MonarchControllerTest` to load fixtures from classpath.

## Blocks on

- `monarch-bootstrap-auth` (need live session)
- `monarch-auth-payload-verify` (ensure shapes are stable before capturing)

## Refs

- `api/src/test/kotlin/.../controllers/MonarchControllerTest.kt` — tests to update
- `property-data-service/api/src/test/resources/` — PDS fixture pattern to mirror
