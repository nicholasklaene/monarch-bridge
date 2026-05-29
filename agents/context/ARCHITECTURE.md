# Architecture: monarch-bridge

> **TL;DR: no DB, no events, pass-through only.** See `docs/HLD.md` for rationale.

## What it is

A thin Kotlin/Spring Boot HTTP wrapper over Monarch Money's GraphQL API. Stateless except
for a file-cached session token. Personal repo (`nicholasklaene/monarch-bridge`); Monarch
holds the data.

The spec is the source of truth. `openapi/monarch-bridge.yaml` (with sibling files under
`openapi/paths/` and `openapi/components/parameters/`) drives the entire HTTP layer:
request DTOs, response DTOs, **and** the Spring `*Api` interface that each controller
implements. There is no hand-written `@GetMapping` / `@PostMapping` / path string anywhere
in the codebase. Change the spec, regenerate, and the compiler tells you what to update.

## Package layout

Two Gradle modules: `:app` (Spring Boot HTTP service) and `:mcp` (Model Context Protocol
server). They share the OpenAPI spec under `openapi/` and nothing else.

```
app/src/main/kotlin/com/nicholasklaene/monarchbridge/
├── Application.kt                   # Spring entry point
│
├── controllers/                     # 24 per-resource @RestControllers + base class only
│   ├── MonarchControllerBase.kt     # Abstract: shared sessionService + client + `exec(op,input)` helper
│   ├── SystemController.kt          # implements SystemApi
│   ├── AccountController.kt         # implements AccountsApi
│   ├── TransactionController.kt     # implements TransactionsApi
│   ├── BudgetController.kt          # implements BudgetsApi
│   ├── RecurringController.kt       # implements RecurringApi
│   ├── CategoryController.kt        # implements CategoriesApi
│   ├── TagController.kt             # implements TagsApi
│   ├── GoalController.kt            # implements GoalsApi
│   ├── HoldingController.kt         # implements HoldingsApi
│   ├── MerchantController.kt        # implements MerchantsApi
│   ├── PaycheckController.kt        # implements PaychecksApi
│   ├── RuleController.kt            # implements RulesApi
│   ├── SettingsController.kt        # implements SettingsApi (me + household + preferences)
│   ├── TaxController.kt             # implements TaxApi (tax-prep: categories + aggregates + schedule mappings)
│   ├── TaxLotController.kt          # implements TaxLotApi
│   ├── AdviceController.kt          # implements AdviceApi (insights feed)
│   ├── ForecastController.kt        # implements ForecastApi
│   ├── BillsController.kt           # implements BillsApi
│   ├── EquityGrantsController.kt    # implements EquityGrantsApi
│   ├── BusinessEntityController.kt  # implements BusinessEntityApi
│   ├── ReportConfigController.kt    # implements ReportConfigApi
│   ├── WebScreensController.kt      # implements WebScreensApi (screen-aggregate pass-through)
│   ├── MobileScreensController.kt   # implements MobileScreensApi (screen-aggregate pass-through)
│   └── LongTailController.kt        # implements LongTailApi (opaque /v1/x/* pass-throughs)
│
├── auth/                            # Owns everything auth + session
│   ├── MonarchBootstrapMain.kt      # Interactive CLI (NOT called by the app server)
│   ├── MonarchAuth.kt               # login + MFA + TOTP
│   ├── MonarchSessionService.kt     # Load / save session JSON from disk
│   ├── MonarchSession.kt            # Data class (token, email, lastVerifiedAt)
│   ├── Totp.kt                      # RFC 6238 TOTP helper
│   ├── MonarchSessionMissingException.kt   # → 503
│   ├── MonarchSessionExpiredException.kt   # → 401
│   └── MonarchMfaRequiredException.kt      # → thrown during bootstrap only
│
├── graphql/                         # GraphQL transport + operation registry
│   ├── MonarchClient.kt             # RestClient wrapper; SSRF allowlist; PayloadError check
│   ├── MonarchOperation.kt          # Interface: operationName + query + variables(input)
│   ├── GraphQLLoader.kt             # Loads .graphql resources, composes with fragments
│   ├── JsonMappers.kt               # Shared JsonNode → generated-DTO helpers (parseAccount, parseTransaction, …)
│   ├── PayloadError.kt              # Data class + PayloadErrorException
│   ├── VariableBuilders.kt          # `mapOfNotNull` helper for patch-style input maps
│   └── operations/                  # One file per operation, grouped by resource.
│       │                            # Illustrative subset; the full tree covers the
│       │                            # entire 768-operation surface across these groups.
│       ├── transactions/   accounts/    tags/       categories/
│       ├── budgets/        recurring/   system/     goals/
│       ├── investments/    merchants/   paychecks/  rules/
│       ├── settings/       tax/         taxlots/    advice/
│       ├── forecast/       bills/       equity/     entities/
│       ├── reports/        screens/                 # web + mobile screen aggregates
│       └── longtail/                                # opaque /v1/x/* pass-throughs
│
├── generated/                       # OPENAPI CODEGEN OUTPUT, never hand-edit.
│   ├── api/                         # One `*Api` interface per OpenAPI tag.
│   │   ├── SystemApi.kt    AccountsApi.kt    TransactionsApi.kt
│   │   ├── BudgetsApi.kt   RecurringApi.kt   CategoriesApi.kt   TagsApi.kt
│   └── model/                       # All request + response DTOs.
│       ├── Account.kt   Transaction.kt   Tag.kt   Category.kt   …  (leaf models)
│       ├── *Request.kt                                              (request bodies)
│       └── *200Response.kt + *200ResponseData.kt                    (per-endpoint envelopes)
│
├── exceptions/                      # Non-auth exceptions (auth ones live in auth/)
│   ├── MonarchRateLimitedException.kt      # → 429 + Retry-After
│   └── MonarchRequestFailedException.kt    # → 502
│
└── config/
    ├── MonarchProperties.kt         # @ConfigurationProperties for monarch.*
    └── GlobalExceptionHandler.kt    # Maps all exceptions to HTTP (incl. PayloadError → 422)

mcp/src/main/kotlin/com/nicholasklaene/monarchbridge/mcp/
└── MonarchMcpServer.kt              # Stdio MCP server: reads openapi/monarch-bridge.yaml,
                                     # exposes one MCP tool per OpenAPI operation,
                                     # forwards calls to monarch-bridge on :9084.
```

GraphQL query strings live in **`app/src/main/resources/graphql/`**: `operations/*.graphql`
files + `fragments/*.graphql` files. Real `$variable` syntax (no `${'$'}` Kotlin escaping).
`GraphQLLoader` concatenates each operation with its declared fragment dependencies at
load time.

Plus the bash CLI at `cli/monarch` (~1850 lines): subcommand router over the REST surface,
with `--yes` confirmation for destructive ops. Symlinked to `~/bin/monarch` per host setup.

Plus the `:mcp` Kotlin module: a Model Context Protocol server that reads the same
OpenAPI spec at startup, generates one MCP tool per operation, and forwards tool
invocations to the bridge over HTTP. Stdio transport, built on Anthropic's official Kotlin
MCP SDK (`io.modelcontextprotocol:kotlin-sdk`). Drops into Claude Desktop, Cursor,
Continue, Cline, etc. via a config-file entry. Build with `./gradlew :mcp:installDist`. See
`mcp/README.md` for the install + per-client config snippets.

### Why this shape

- **Spec drives the web layer.** Every controller implements a spec-generated `*Api`
  interface. Path strings, parameter binding, request body deserialization, response
  envelope shapes; all baked in by the generator. The controller method body is just
  "dispatch to the GraphQL operation and wrap the result in the matching
  spec-generated `*200Response`."
- **One file per GraphQL operation** = navigate by mutation name, never grep through
  a 600-line const-val pile.
- **Real `.graphql` files** = IDE syntax highlighting, no `${'$'}` escaping, can
  introspect dependencies via the fragments list.
- **Generated DTOs replace hand-written ones.** Request and response shapes both come
  from the spec; the only types in `generated.model.*` are codegen output. Hand-written
  domain classes do not exist.
- **`PayloadError` → 422** = mutations that fail at the application level (e.g.
  "category not found") surface as HTTP 422 instead of a silent 200 with
  `data.<mutation>.errors[]` the caller has to inspect.
- **Companion factories for input mapping.** Each Operation's `Input` data class has
  `companion object { fun from(req: <GeneratedRequest>): Input }`. The project convention
  is companion-factory-style (`XInput.from(req)`), never top-level extension
  (`fun XReq.toDto()`).

### Adding a new endpoint

The full add-an-endpoint loop is ~5 small edits (see [CONTRIBUTING.md](../../CONTRIBUTING.md)
for the worked example):

1. Add the path entry in `openapi/monarch-bridge.yaml` (referencing a sibling file under
   `openapi/paths/` if you want it separate) plus any new schemas under
   `components.schemas`. Run `./gradlew :app:openApiGenerate`; the new `*Api`
   interface method + DTOs appear under `build/generated/openapi/`.
2. Drop a `.graphql` file in `src/main/resources/graphql/operations/<Name>.graphql`.
3. Create `graphql/operations/<resource>/<Name>.kt`: `object Foo : MonarchOperation<Foo.Input, <SpecGeneratedDataType>>` with `variables` and `parseOutput`. The `parseOutput` returns the inner
   spec-generated `data` payload type directly.
4. Add a one-line method override on the matching controller; it dispatches to
   `exec(Foo, input)` and wraps the result in the spec-generated `*200Response`.
5. (Optional) extend `cli/monarch` with a subcommand.

### Sharing this repo (someday)

Notes for if/when this becomes public:
- License: MIT.
- Launchd plist + `monarch-bridge-up.sh` are macOS-specific. Either move to
  `docs/installation/macos.md` or add a `docs/installation/linux.md` with a systemd unit
  example.
- Package name `com.nicholasklaene.monarchbridge` is fine for a personal fork; rename to
  `com.monarchbridge` only if making canonical-upstream.
- Document Monarch Money's GraphQL schema version assumed by these operations.

No `persistence/` package: no JPA, no Flyway, no Postgres driver on the classpath.
No `kafka/` package: no Spring Kafka, no event publishing, no outbox relay.

## Key design constraints (enforced by ArchUnit)

- Controllers annotated `@RestController`, named `*Controller`, implement a spec-generated
  `*Api` interface.
- All exceptions extend `RuntimeException`.
- `@Component` beans live under `auth/`, `graphql/`, or `config/` only.
- Approved-package whitelist: adding a new top-level package requires extending the
  ArchUnit rule.

## Session lifecycle

```
host filesystem: ~/.config/monarch-bridge/.mm-session.json
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

## Consumers

```
~/bin/monarch (host CLI)  ─HTTP─▶  monarch-bridge (:9084)  ─GraphQL─▶  api.monarch.com
```

The bundled `monarch` CLI (host-side bash) is the primary consumer. Any other service that
wants Monarch data calls this HTTP surface; consumer-side concerns (scope filtering,
multi-tenant attribution, downstream tagging) are not this service's problem. It returns
raw Monarch shape verbatim.

## What's intentionally missing (do not add without a new plan)

| Capability | Why missing |
|---|---|
| Postgres / JPA | Monarch owns the data; no reason to duplicate it |
| Flyway migrations | No schema to migrate |
| Event publishing | No domain events to publish |
| Per-source supersession | Monarch handles dedup upstream |
| PII encryption at rest | Nothing persisted |
| Plaid-link initiation / notifications / investment rebalancing / manual snapshot creation | Browser-side GraphQL only; would need a live web session capture before wrapping. See `agents/context/AGENTS.md` "Coverage notes." |
