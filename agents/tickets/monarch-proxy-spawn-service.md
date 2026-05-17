---
title: Spawn monarch-proxy service
slug: monarch-proxy-spawn-service
priority: P0
status: done
created: 2026-05-03
repo: monarch-proxy
labels: [monarch-proxy, scaffold, bootstrap]
---

# Spawn monarch-proxy Service

## Context

`monarch-proxy` is the financial-aggregation service that consolidates accounts (bank,
brokerage, real estate-as-asset, etc.) into a unified ledger view. Originally intended as a
full KRE microservice (Postgres + outbox + events). Pivoted to a stateless pass-through over
Monarch Money's GraphQL API — see `docs/HLD.md` for rationale.

## Goal / acceptance

- Private GitHub repo `nicholasklaene/monarch-proxy` created and populated.
- Kotlin/Spring Boot scaffold with minimal deps (no JPA, Flyway, Kafka, kre-events).
- `./gradlew :api:check` green.
- Service wired into `kre-stack` under `monarch` Compose profile, port 9084.
- `agents/context/CURRENT_STATE.md` seeded.

## Resolution

Completed in `feat/v1-pass-through-wrapper` (Stages 1–5). Merged to main.
Service is a stateless Monarch pass-through (no DB, no events). Auth bootstrap deferred to
`monarch-bootstrap-auth`. See `docs/HLD.md` and `agents/context/ARCHITECTURE.md`.
