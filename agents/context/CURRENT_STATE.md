---
last_human_verified: 2026-05-25
freshness_horizon: 14d
---

# Current State: monarch-bridge

## What's running

Kotlin/Spring Boot service on port **9084**. Stateless except for a session-token JSON
file on disk. The entire wrappable Monarch GraphQL surface (every non-UI operation;
762 distinct Monarch operations) exposed across **768 REST endpoints** spread over
24 controllers. Core data domains (System, Account, Transaction, Budget, Recurring,
Category, Tag, Rule, Goal, Paycheck, Holding, Merchant, Settings, Tax, TaxLot) plus
deeper-surface controllers (Advice, Forecast, Bills, EquityGrants, BusinessEntity,
ReportConfig) and the screen-aggregate pass-through tier (WebScreens, MobileScreens,
LongTail). The 31 operations Monarch only exposes through UI widgets or WebSocket
subscriptions are documented as intentional exclusions in AGENTS.md. Every
controller implements a spec-generated `*Api` interface from `openapi/monarch-bridge.yaml`.
A Kotlin MCP server in `mcp/` reads the same spec and surfaces every endpoint as an MCP
tool for Claude Desktop / Cursor / Continue / Cline.

## How to run (local, no Docker)

```bash
./gradlew :app:bootRun    # from the repo root; JDK 21 required
# listening on http://localhost:9084
curl http://localhost:9084/healthz
# {"status":"UP","authenticated":false,...}   (expected until bootstrap)
```

## How to run (Docker)

```bash
docker compose up -d
curl http://localhost:9084/healthz
```

## Auth bootstrap (one-time, interactive)

```bash
./gradlew :app:bootstrapMonarch    # JDK 21 required
# prompts for email / password / MFA code or TOTP secret
# writes ~/.config/monarch-bridge/.mm-session.json
```

After writing the session, either restart the service or:

```bash
curl -X POST http://localhost:9084/v1/auth/refresh
```

## Endpoint reference

Every endpoint, with notes on per-endpoint quirks, parameters, error codes, and
PayloadError semantics, lives in **[AGENTS.md](AGENTS.md)**. That doc is the single
source of truth for the HTTP surface; this file is intentionally kept short so the two
don't drift.

## Contracts (carried by every endpoint)

**Write contract.** Request bodies are spec-generated DTOs from `openapi/monarch-bridge.yaml`
(`generated.model.*Request`). Each Operation has a `companion object { fun from(req): Input }`
factory that maps the request DTO to the GraphQL input shape. Path `{id}` segments are
injected into the GraphQL input by the controller. Validation (`@Pattern`, `@NotNull`, etc.)
comes from the spec via the generator. Bad bodies return 400 with structured errors.

**Response contract.** Every successful 2xx body is `{"data": <typed object>}`, where the
inner data shape is the spec-generated `*200ResponseData` type. The only exceptions are
`/healthz`, `/v1/auth/status`, and `/v1/auth/refresh`, which return their bodies plain so
health probes stay zero-parse.

**PayloadError contract.** After each mutation, `MonarchClient.execute()` inspects
`data.<mutation>.errors[]`. If non-empty, throws `PayloadErrorException`;
`GlobalExceptionHandler` returns **HTTP 422** with the error body. HTTP-level + GraphQL
`errors`-array failures map to 401 / 429 / 502 as before.

## Consumers

The bundled `monarch` CLI (`cli/monarch`, symlinked to `~/bin/monarch`) is the primary
terminal consumer. The MCP server in `mcp/` is the primary AI-assistant consumer (Claude
Desktop, Cursor, Continue, etc.) and exposes every endpoint as a native MCP tool derived
from the OpenAPI spec at startup. Any downstream service that wants Monarch data calls
this HTTP surface directly (default `http://localhost:9084`; in docker via
`host.docker.internal:9084`). Consumer-side concerns (scope filtering, multi-tenant
attribution, downstream tagging) are not this service's problem.

## Regenerating client code

The OpenAPI spec at `openapi/monarch-bridge.yaml` is the source of truth. Generate a typed
client in any language:

```bash
npx @openapitools/openapi-generator-cli generate \
  -i openapi/monarch-bridge.yaml -g <kotlin|python|typescript-axios|go|rust|...> \
  -o clients/<lang>
```
