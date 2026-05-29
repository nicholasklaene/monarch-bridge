# Contributing: monarch-bridge

A short, opinionated guide for adding new functionality to this codebase. Following these
patterns keeps the surface uniform and agent-maintainable.

The big picture: see [agents/context/ARCHITECTURE.md](agents/context/ARCHITECTURE.md) for
package layout and the why-this-shape rationale. Per-pattern *why* (companion factory,
JSON helpers, what makes a test worth writing) is in [docs/PATTERNS.md](docs/PATTERNS.md).

## Adding a new GraphQL operation (read or mutation)

Worked example: adding a `GET /v1/merchants` endpoint that returns all distinct merchants.

### 1. Add the endpoint to the OpenAPI spec

`openapi/monarch-bridge.yaml` (and the sibling files under `openapi/paths/` +
`openapi/components/parameters/`) is the source of truth. Add the new path entry plus any
new schema components:

```yaml
# openapi/monarch-bridge.yaml
paths:
  /v1/merchants:
    $ref: "./paths/merchants.yaml"
components:
  schemas:
    Merchant:
      type: object
      required: [id, name]
      properties:
        id: { type: string }
        name: { type: string }
        transactionsCount: { type: integer, nullable: true }
    ListMerchantsResponse:
      type: object
      required: [data]
      properties:
        data:
          type: object
          required: [merchants]
          properties:
            merchants:
              type: array
              items:
                $ref: "#/components/schemas/Merchant"
```

```yaml
# openapi/paths/merchants.yaml
get:
  tags: [Merchants]
  summary: List all merchants
  operationId: listMerchants
  responses:
    "200":
      description: All merchants.
      content:
        application/json:
          schema:
            $ref: "../monarch-bridge.yaml#/components/schemas/ListMerchantsResponse"
```

Run codegen; the new `*Api` interface method + DTOs appear under `build/generated/openapi/`:

```bash
./gradlew :app:openApiGenerate
```

### 2. Drop a `.graphql` file

```
app/src/main/resources/graphql/operations/GetMerchants.graphql
```

```graphql
query GetMerchants {
  merchants {
    id
    name
    transactionsCount
    __typename
  }
}
```

Filenames match the GraphQL operation name. If the query references a fragment
(`...PayloadErrorFields`, etc.) that fragment must exist in
`resources/graphql/fragments/`.

### 3. Create the Kotlin operation object

```
app/src/main/kotlin/com/nicholasklaene/monarchbridge/graphql/operations/merchants/GetMerchants.kt
```

```kotlin
package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ListMerchants200ResponseData
import com.nicholasklaene.monarchbridge.generated.model.Merchant
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

object GetMerchants : MonarchOperation<Unit, ListMerchants200ResponseData> {
    override val operationName: String = "GetMerchants"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): ListMerchants200ResponseData =
        ListMerchants200ResponseData(
            merchants = data.path("merchants").map { node ->
                Merchant(
                    id = node.path("id").asText(""),
                    name = node.path("name").asText(""),
                    transactionsCount = node.path("transactionsCount").takeIf { it.isInt }?.asInt(),
                )
            },
        )
}
```

Every operation is a Kotlin `object` (singleton). The interface is `MonarchOperation<TInput, TOutput>`,
where `TOutput` is the spec-generated `*200ResponseData` for the endpoint. Operations return
the inner `data` payload; the controller wraps it in the corresponding `*200Response`
envelope.

If `TOutput` is a shared leaf (e.g. `Account`, `Transaction`), reuse the parsers in
`graphql/JsonMappers.kt` rather than rewriting field-by-field mapping.

### 4. (Writes only) Add an `Input` + companion factory

For mutation endpoints, define `Input` data class on the Operation with a
`companion object { fun from(req: <GeneratedRequest>): Input }` factory:

```kotlin
data class Input(val name: String) {
    companion object {
        fun from(req: CreateMerchantRequest): Input = Input(name = req.name)
    }
}
```

Per project convention, mappers are companion factories (`Input.from(req)`), never top-level
extension methods (`fun CreateMerchantRequest.toDto()`).

Skip this step for read endpoints (where the controller constructs the Input from path /
query params directly).

### 5. Implement the controller method

The matching `<Resource>Controller` extends `MonarchControllerBase` and implements the
spec-generated `*Api` interface. Implement the new method by dispatching to the operation
and wrapping the typed payload in the matching `*200Response`:

```kotlin
override fun listMerchants(): ResponseEntity<ListMerchants200Response> =
    ResponseEntity.ok(ListMerchants200Response(data = exec(GetMerchants, Unit)))
```

For mutations:

```kotlin
override fun createMerchant(
    createMerchantRequest: CreateMerchantRequest,
): ResponseEntity<CreateMerchant200Response> =
    ResponseEntity.ok(
        CreateMerchant200Response(
            data = exec(CreateMerchant, CreateMerchant.Input.from(createMerchantRequest)),
        ),
    )
```

`exec(op, input)` (from `MonarchControllerBase`) does the session check, calls Monarch via
`MonarchClient`, and returns the typed `parseOutput` result. The controller is responsible
for the response envelope; that wrapping is what makes the spec's `{"data": ...}` contract
explicit.

### 6. (Optional) Extend the bash CLI

Add a subcommand in `cli/monarch`:

```bash
merchants)
  call GET /v1/merchants | emit '.data.merchants[] | [.name, (.transactionsCount|tostring)] | @tsv' | column -t -s $'\t'
  ;;
```

And update the `usage()` block.

## Conventions

- **Spec-first.** The OpenAPI yaml in `openapi/` is authoritative for request + response
  shapes AND for HTTP wiring (paths, methods, parameter binding, status codes). Never
  hand-write a `@GetMapping("...")`; implement the spec-generated `*Api` interface.
- **No raw `JsonNode` in controllers or above.** All parsing happens in
  `Operation.parseOutput` (returning a spec-generated DTO) or in shared `JsonMappers.kt`
  helpers. Controllers are spec-typed end-to-end.
- **Operation singleton naming**: `kotlin object`, not class. The operation name in
  `operationName` is the GraphQL identifier (often with PascalCase + module prefix like
  `Common_` / `Web_`).
- **`parseOutput` is forgiving.** Use `asTextOrNull` / `pathOrNull` for optional fields.
  Use `.asText("")` / `.asInt(0)` for fields you expect Monarch to always send.
- **Companion factory mappers.** Request DTO → Operation Input uses
  `Operation.Input.from(req)`, never `fun Req.toInput()`.

## Generated clients

`openapi/monarch-bridge.yaml` is the source of truth and is consumed by external developers via openapi-generator. To keep the surface friendly to consumers who only want a slice of the API, the spec tags every operation. Generators accept a `--global-property apis=Tag1,Tag2` filter, so a consumer who only needs accounts and transactions can emit ~10% of the surface.

When you add an endpoint, ALWAYS set a `tags:` entry on the operation in its `paths/*.yaml` file. Use one of the 12 existing tags; do not invent new ones without updating the tag table in `README.md` and in `openapi/monarch-bridge.yaml`.

`clients/` holds four pre-generated clients (Python, TypeScript, Kotlin, bash) checked in as a showcase. After a meaningful spec change you can regenerate them with the commands documented in `clients/README.md`, but they are not part of CI and not required to be kept in lockstep with every commit; refresh on a deliberate cadence (release prep, after a spec milestone).

## Build

```bash
./gradlew :app:check     # compile + spotless + detekt + tests + kover gate
./gradlew :app:bootRun   # run the bridge on :9084 with the loaded session
docker compose up -d --build   # rebuild + restart container
```

If you see `ArgumentListWrapping` / `Wrapping` complaints from detekt: that conflicts with
spotless's ktlint. Both rules are intentionally disabled in `config/detekt/detekt.yml`;
spotless is the authoritative formatter.

## Coverage

Gate is defined in `app/build.gradle.kts` under `kover { verify { rule { minBound(...) } } }`.
Excluded from coverage (documented in the same block):

- `Application*`: Spring entry point
- `auth.MonarchBootstrapMain*`: interactive CLI
- `auth.MonarchAuth*`: live-network auth
- `generated.*` / `generated.**`: codegen output

Everything else should be tested. If you're tempted to add an exclusion, add a test instead.
