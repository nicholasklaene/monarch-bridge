# Code + test patterns

Conventions that make monarch-bridge's surface easy to extend without the codebase
fraying. If you're adding an endpoint, follow [CONTRIBUTING.md](../CONTRIBUTING.md);
this doc explains the *why* behind each pattern so you can keep applying it as new
shapes show up.

## Code patterns

### 1. Spec-first, generated-API-first

Every controller implements a generated `*Api` interface from
`openapi/monarch-bridge.yaml`. HTTP paths, query params, validation annotations, and
response envelope types come from the spec. **Never hand-write a `@GetMapping(...)`
path string in a controller.** If the path drifts from the spec, the controller
stops compiling (it would need a method signature that doesn't exist on the
interface).

Why: one source of truth. The OpenAPI spec drives the spring controllers, the
Kotlin / Python / TypeScript clients under `clients/`, the Swagger UI, AND the MCP
server's tool list. If any of those drift, the others tell you immediately.

### 2. Companion-factory mapping from request DTO to op input

```kotlin
object CreateTransactionTag : MonarchOperation<CreateTransactionTag.Input, ...> {
    data class Input(val name: String, val color: String?)

    companion object {
        fun Input.Companion.from(req: CreateTagRequest) =
            Input(name = req.name, color = req.color)
    }
}
```

In the controller:

```kotlin
override fun createTag(req: CreateTagRequest) =
    ResponseEntity.ok(CreateTag200Response(
        data = exec(CreateTransactionTag, CreateTransactionTag.Input.from(req))))
```

Why: keeps the mapping co-located with the operation that defines the shape. No
sprawling extension functions on generated request DTOs (which would orphan when
the spec regenerates). The companion-factory pattern survives spec changes
cleanly.

### 3. Use the JSON helper functions

In `graphql/`:

- `asTextOrNull()`, `asDoubleOrNull()`, `asIntOrNull()`, `asBooleanOrNull()`: safe
  field access that returns null instead of `""` / `0.0` / `0` / `false` for
  missing-or-null nodes.
- `pathOrNull(name)`: returns null for missing-or-null instead of a `MissingNode`,
  so `?.let { ... }` works.
- `mapOfNotNull(...)`: builds variables maps without `null` entries.

```kotlin
override fun parseOutput(data: JsonNode) =
    SomeResponseData(
        id = data.path("id").asText(""),               // required, default empty
        name = data.path("name").asTextOrNull(),       // nullable
        amount = data.path("amount").asDoubleOrNull(),
        nested = data.pathOrNull("nested")?.let { ... }, // null-safe nested object
    )
```

Why: parsing Monarch's GraphQL responses involves *a lot* of nullable nested
objects. The helpers force you to make a deliberate choice (`asText("")` to
default, or `asTextOrNull()` to surface nullability) for every field.

### 4. Lazy query loading + fragment composition

```kotlin
override val query: String by lazy {
    GraphQLLoader.load(operationName, fragments = listOf("AccountFields", "CategoryFields"))
}
```

`GraphQLLoader.load(operationName)` reads
`app/src/main/resources/graphql/operations/<operationName>.graphql` and appends any
named fragments from `graphql/fragments/`. The `by lazy` evaluates once per
operation, on first call.

Why: avoid string-concatenating queries at every call site, and let multiple
operations share fragment text.

### 5. Long parseOutput methods get a Suppress, not a split

If a parseOutput maps a wide response shape and pushes past detekt's
`LongMethod` threshold, annotate it:

```kotlin
@Suppress("LongMethod")
override fun parseOutput(data: JsonNode) = ...
```

Why: splitting these for the sake of line counts hurts readability - you end up
with three private helpers each used once. The whole point of parseOutput is to
show *exactly* how each spec field is filled. Keep it in one place.

### 6. Standard PayloadError contract for mutations

Every mutation passes through `MonarchClient.execute()` which inspects
`data.<mutation>.errors[]`. Non-empty array → throws `PayloadErrorException`.
`GlobalExceptionHandler` maps that to **HTTP 422** with the structured error body.
Don't try to parse errors in your Operation's parseOutput.

### 7. Controllers stay thin

Controller methods are one-liners (or two when there's a query-param translation).
Anything more belongs in the Operation class or a graphql helper. Specifically:

- Validation lives in the spec (`@Pattern`, `@NotNull`, ...) → controller does nothing.
- Path id injection lives in the controller (because spec generates the method
  signature) → controller does only `Input(id = id, ...)`.
- Field defaults / fall-backs live in the Operation's parseOutput, NOT in the
  controller.

If a controller method grows past 5 lines, push the logic into the Operation.

### 8. Filter-spread → buildFilters(...) in ONE step

Some endpoints (anything taking the full Monarch `TransactionFilterInput`) end up
with controller signatures like:

```kotlin
override fun getCashflowBreakdown(
    start: LocalDate?, end: LocalDate?,
    accountIds: List<String>?, categoryIds: List<String>?, tagIds: List<String>?,
    search: String?, hasAttachments: Boolean?, hasNotes: Boolean?,
    hideFromReports: Boolean?, isSplit: Boolean?, isRecurring: Boolean?,
    importedFromMint: Boolean?, syncedFromInstitution: Boolean?,
    needsReview: Boolean?, transactionVisibility: String?,
): ResponseEntity<...> = ...
```

That width is a generator-level cost of spec-first design - OpenAPI 3.x can't model
an object query parameter without `style: deepObject` URLs like
`?filter[start]=...&filter[isSplit]=true`, which break client / proxy compat and
the `monarch <cmd> --start D` CLI ergonomics. POST-with-body is wrong semantically
for a read.

**Rule**: collapse the filter args into a `buildFilters(...)` (or similar) helper
as the FIRST move inside the method body. Pass the resulting typed object to the
Operation. The signature is what it is; the body stays one expression:

```kotlin
override fun getCashflowBreakdown(start, end, ...all 14 args...) =
    ResponseEntity.ok(GetCashflowBreakdown200Response(
        data = exec(GetCashflowBreakdown, GetCashflowBreakdown.Input(
            startDate = (start ?: today.minusDays(DEFAULT)).toString(),
            endDate = (end ?: today).toString(),
            filters = buildFilters(accountIds, categoryIds, tagIds, search, ...),
        )),
    ))
```

The Operation's `Input` accepts the typed filter, the parser doesn't care about
the 14-arg signature. Only one ugly line, in one place.

Future option (not done): override the kotlin-spring Mustache `api.mustache` to
emit a single `@ModelAttribute` data-class parameter per operation. Possible but
ties us to template internals across `openapi-generator` upgrades.

## Test patterns

### 1. One Arrange-Act-Assert per test, backtick-named

```kotlin
@Test
fun `GetSpendingReport skips rows where category is null`() {
    val data = jsonNode("""{"rows": [{"category": null, "total": 10}, ...]}""")
    val out = GetSpendingReport.parseOutput(data)
    assertThat(out.rows).hasSize(1)
}
```

Read the function name without context - the behavior should be obvious. If you
can't name the test in one sentence, the test is doing too much.

### 2. Test behavior, not lines

If a line is uncovered and you can't write a test whose name describes a
behavior worth asserting, **don't write the test**. Either:
- The line is dead code → delete it.
- The line is one-shot CLI / bootstrap → add the class to the kover exclude list
  with a comment explaining why.

Tests written purely to flip a line green are tests that mock the implementation
so closely they break the next refactor without catching a real bug.

### 3. parseOutput tests cover three branches

Every Operation gets at least:
- **Happy path** with a representative complete payload.
- **Edge-case payload** with missing optional fields → asserts defaults / null.
- **Empty collection** if the operation returns a list.

### 4. variables() tests cover both branches

If `variables()` conditionally includes a field, test both "field present" and
"field omitted":

```kotlin
@Test
fun `GetTaxCategoryAggregates variables include only set date bounds`() {
    val both = GetTaxCategoryAggregates.variables(GetTaxCategoryAggregates.Input(
        startDate = LocalDate.parse("2026-01-01"), endDate = LocalDate.parse("2026-12-31")))
    val filters = both["filters"] as Map<*, *>
    assertThat(filters["startDate"]).isEqualTo("2026-01-01")
    assertThat(filters["endDate"]).isEqualTo("2026-12-31")

    val nullDates = GetTaxCategoryAggregates.variables(GetTaxCategoryAggregates.Input(null, null))
    assertThat((nullDates["filters"] as Map<*, *>)).isEmpty()
}
```

### 5. WebMvcTest asserts response SHAPE, not just status

```kotlin
mvc.perform(get("/v1/tax/categories"))
    .andExpect(status().isOk)
    .andExpect(jsonPath("$.data.categories[0].id").value("c1"))
    .andExpect(jsonPath("$.data.categories[0].systemCategory").value("homeOffice"))
```

`status().isOk` alone proves nothing - it just means a 2xx came back. Assert
specific JSON paths so a regression in the response wrapper or the parseOutput
contract gets caught here, not in production.

### 6. Every controller covers the session-missing 503 path

```kotlin
@Test
fun `listTags returns 503 when session missing`() {
    `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
    mvc.perform(get("/v1/tags"))
        .andExpect(status().isServiceUnavailable)
        .andExpect(jsonPath("$.code").value("session_missing"))
}
```

One per controller is enough - the rest of the controller's auth handling is
identical scaffold.

### 7. Use the shared TestFixtures

`controllers/TestFixtures.kt` provides:
- `FAKE_SESSION` - a valid `MonarchSession` for `sessionService.current()` stubs.
- `stubExec(client, data)` - stubs `MonarchClient.execute(op, input)` for any op.
- `jsonNode(json)` - parses a raw JSON string to a `JsonNode`.

Don't reinvent these per test class. If you find yourself writing a helper
that's general-purpose, lift it into TestFixtures.

### 8. Skip tests for generated code

The kover config excludes `generated.*` because tests for openapi-generator
output would just re-test the generator. Spec changes are caught at compile
time. Same logic applies to any future code-gen output you add.

## Files to mirror

When unsure, copy the closest existing pattern:

| Adding... | Mirror... |
|---|---|
| A read operation | `categories/GetCategories.kt` |
| A mutation operation | `tags/CreateTransactionTag.kt` |
| An operation with filters | `transactions/GetCashflowEntities.kt` |
| A controller | `controllers/TagController.kt` |
| A WebMvcTest | `controllers/TagControllerTest.kt` |
| A parseOutput test | `graphql/operations/categories/CategoryOperationTest.kt` |

Each of those is small and self-explanatory. Pick the closest match, copy, swap
the names + shapes.

## Anti-patterns (don't do these)

1. **Inline `ObjectMapper().readTree(...)`** in tests - use `TestFixtures.jsonNode`.
2. **`assertThat(out).isNotNull` ladder** - assert the values you care about.
3. **Single test asserting 10 unrelated things** - split it.
4. **Hand-rolled `@GetMapping` path strings** in controllers - implement the spec
   interface instead.
5. **Top-level `fun Req.toInput()` extension** - use the companion-factory pattern.
6. **String response wrappers** - return the spec-generated `*200Response`.
7. **Catching exceptions inside an Operation** - let them propagate;
   `GlobalExceptionHandler` maps them to HTTP.
8. **Tests that mock the Operation class itself** - mock at the MonarchClient
   boundary; the Operation is the unit under test.
