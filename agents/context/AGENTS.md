# AGENTS.md: using monarch-bridge

This file is the **single source of truth** for any agent (AI or human) consuming the
bridge. Read it once; you'll know every endpoint, every quirk, and every error code.

The bridge is a thin HTTP/JSON wrapper over Monarch Money's GraphQL. Behavior mirrors
Monarch's actual semantics; when Monarch surprises you, the bridge surprises you the
same way. This doc documents those surprises.

## TL;DR

- **Base URL:** `http://localhost:9084`
- **Auth:** none on the wire; the bridge holds the Monarch session token itself.
  Until the session file exists, every data endpoint returns `503`.
- **Wire shape:** every success body is `{"data": <typed object>}`.
- **Errors:** every failure body is `{"code": "...", "message": "...", "details": {...}}`.
- **CLI:** `monarch <cmd>` (bash wrapper); `monarch help` for full reference; add `--raw`
  to any read command to emit JSON instead of a table.

## Auth model

- Token lives at `~/.config/monarch-bridge/.mm-session.json`. Written **once** by the
  interactive bootstrap CLI (`./gradlew :app:bootstrapMonarch`).
- Service auto-loads on startup. After re-bootstrapping, hit
  `POST /v1/auth/refresh` so the running service picks up the new file without a restart.
- `/healthz` and `/v1/auth/status` work even without a session; both return
  `authenticated: false`.

## Response envelope

Every successful 2xx body is:

```json
{ "data": { /* typed payload */ } }
```

The `data` object's shape is the spec-generated `*200ResponseData` type for that endpoint
(see `generated.model.*` under `build/generated/openapi/`). Field types come from
`openapi/monarch-bridge.yaml`; Jackson serializes them straight to JSON.

## Error model

| HTTP | code | When |
|---|---|---|
| 400 | `invalid_input` | Body validation failed (e.g. missing required field on a write). |
| 400 | `invalid_param` | URL/path param wrong type (e.g. `start=not-a-date`). |
| 401 | `session_expired` | Session JSON loaded but Monarch rejected the token. Re-run bootstrap. |
| 404 | `not_found` | Unknown URL path. |
| 422 | `payload_error` | Monarch accepted the request but reported application errors in `data.<mutation>.errors[]`. **Mutation-only.** See [PayloadError](#payloaderror-the-mutation-gotcha). |
| 429 | `rate_limited` | Monarch rate-limited us. Response includes `Retry-After`. |
| 502 | `monarch_request_failed` | Monarch returned non-2xx or a GraphQL `errors[]` envelope. `details.upstream_status` has the original HTTP code. |
| 503 | `session_missing` | No session JSON on disk yet. Run bootstrap. |
| 500 | `internal_error` | Bug in the bridge. File an issue; full stack trace is in bridge logs (never in the response). |

## Reads

All reads return `{"data": <Output>}`. Wherever the doc says "default window," the bridge
substitutes `[today-30d, today]` when neither `start` nor `end` is provided.

### `GET /healthz`

Always 200. Returns `{status, authenticated, lastVerifiedAt}`. No session required.

### `GET /v1/auth/status`

Returns `{authenticated, email, lastVerifiedAt}`. No session required (returns
`authenticated: false` when missing).

### `GET /v1/accounts`

All linked accounts (every status, hidden and excluded too). Returns
`{accounts: [Account]}`. `Account` includes `id`, `displayName`, `currentBalance`
(signed: liabilities negative), `displayBalance` (unsigned), `includeInNetWorth`,
`hideFromList`, `isHidden`, `isAsset`, `type` (name + display + group), `subtype`,
`institution`, `mask`. Hidden / excluded accounts are **included** in the response;
filter client-side via `hideFromList` / `includeInNetWorth` if you only want visible ones.

### `GET /v1/account/{id}/history`

Daily balance snapshots for one account. Returns `{snapshots: [{date, signedBalance}]}`.

**Quirks:**
- History starts on the date the account was **linked** in Monarch, not earlier.
  Don't expect snapshots from before that date.
- Snapshots are one-per-day, including weekends (Monarch carries forward the last value).
- Returned **chronologically ascending** (oldest first).

### `GET /v1/account/{id}/holdings`

Investment positions in one account. Returns `{holdings: [Holding]}` where `Holding`
has `id`, `quantity`, `basis` (cost basis $), `totalValue`, `security` (ticker, name,
type, currentPrice, closingPrice, oneDayChange*).

**Quirks:**
- Brokerage accounts only. Depository / credit / loan accounts return `holdings: []`, not 404.
- `quantity` can be fractional (e.g. `0.168029`).
- `closingPrice` is yesterday's close; `currentPrice` is intraday if markets are open.

### `GET /v1/transactions`

Paginated transaction list. Returns `{totalCount: Int, results: [Transaction]}`.

**Params** (all optional). All filter params translate directly to fields on Monarch's
`TransactionFilterInput`, so behavior matches the web UI's Transactions page filter dropdowns
1:1.

| Param | Type | Default | Notes |
|---|---|---|---|
| `start` | `YYYY-MM-DD` | 30 days ago | **Lower bound** on transaction date (inclusive). |
| `end` | `YYYY-MM-DD` | today | **Upper bound** on transaction date (inclusive). |
| `limit` | int | Monarch's default (typically 100) | Page size. |
| `offset` | int | 0 | Skip count. |
| `accountId` | string | (none) | Filter to one account (legacy single-value form; kept for back-compat). |
| `accountIds` | string[] | (none) | Filter to multiple accounts. Merges with `accountId` if both passed. Use `?accountIds=a&accountIds=b`. |
| `categoryIds` | string[] | (none) | Filter to one or more categories. |
| `tagIds` | string[] | (none) | Filter to one or more tags. |
| `search` | string | (none) | Free-text search; matches merchant, notes, plaid name. |
| `hasAttachments` | bool | (none) | Only txns with / without attachments. |
| `hasNotes` | bool | (none) | Only txns with / without notes. |
| `hideFromReports` | bool | (none) | Only txns that are / aren't hidden from reports. |
| `isSplit` | bool | (none) | Only split-parent txns (or non-split). |
| `isRecurring` | bool | (none) | Only Monarch-flagged recurring txns. |
| `importedFromMint` | bool | (none) | Only txns ingested from a Mint export. |
| `syncedFromInstitution` | bool | (none) | Only txns synced via Plaid (vs manually created). |
| `needsReview` | bool | (none) | Only txns flagged for review. |
| `transactionVisibility` | enum | (default: visible only) | `hidden_transactions_only` (only hidden) or `all_transactions` (hidden + visible). |
| `orderBy` | string | `date` | See "Ordering" below. |

**Date semantics, the #1 surprise:**

> Results come back **newest-first** within the `[start, end]` window. `start` is the
> *oldest allowed date*, **not** "scroll forward starting here." So
> `?start=2023-07-01&limit=10` returns the 10 newest transactions on or after July 2023,
> which is probably last month, not July 2023. To get July 2023 specifically, bound both
> sides: `?start=2023-07-01&end=2023-07-31`. To page backward in time from today, leave
> `start` default and increment `offset`.

**Ordering:**

Monarch's `TransactionOrdering` enum accepts exactly two values:

- `date` (default): newest date first
- `amount`: largest absolute amount first

**Direction is fixed per field; there is no asc/desc toggle in Monarch's API.** The
bridge does not fake one. If you need ascending order, fetch in chunks and sort
client-side, or page with `offset` from the newest backward.

**Transaction shape highlights:**

- `amount` is signed: expenses negative, income positive.
- `date` is `YYYY-MM-DD`, no time.
- `pending: true` means Plaid hasn't finalized the transaction yet.
- `merchant.transactionsCount` is the lifetime count for that merchant, useful as a
  "how often do I shop here" signal.
- `tags` is an empty array (`[]`), never null, when no tags assigned.

### `GET /v1/cashflow`

Aggregated income/expense/savings for a window. Returns
`{summary: {sumIncome, sumExpense, savings, savingsRate}}`.

**Params:** `start`, `end` (both `YYYY-MM-DD`; defaults to last 30 days).

**Quirks:**
- `sumExpense` is **negative** (matches transaction sign convention).
- `savings = sumIncome + sumExpense` (so it's negative if you spent more than you earned).
- `savingsRate` is a fraction (`0.4` = 40%); `0.0` when income is zero.
- Empty / unsupported windows return `{summary: {sumIncome: null, ...}}` rather than
  erroring.

### `GET /v1/networth`

Net-worth-over-time. Returns `{aggregateSnapshots: [{date, balance}]}`.

**Params:** `start` (required for a useful response), `end`, `accountType` (filter to
one type group like `brokerage`).

**Quirks:**
- One snapshot per day, ascending by date.
- `balance` is total net worth at end-of-day.
- The earliest available date is when Monarch started tracking your accounts, not earlier.

### `GET /v1/networth/recent`

Per-account recent balance fluctuations. Returns
`{accounts: [{accountId, recentBalances: [Double?]}]}`. `recentBalances` is an array of
the last N daily balances (`N` defaults to ~6); entries can be `null` for days with no data.

**Params:** `start` (lower bound on the window).

### `GET /v1/networth/by-type`

Balance history grouped by account type group. Returns
`{snapshotsByAccountType: [{month, accountType, balance}]}`.

**Params:**
- `start` (lower bound).
- `timeframe`: `month` (default) or `day` or `year`.

### `GET /v1/categories`

All transaction categories. Returns `{categories: [Category]}`. `Category` has `id`,
`name`, `order`, `systemCategory`, `isSystemCategory`, `isDisabled`, `group` (with `id`,
`name`, `type` = `expense`/`income`/`transfer`).

**Use this to look up the `categoryId` you need for `POST /v1/transactions` or
`PATCH /v1/transactions/{id}`.**

### `GET /v1/tags`

All transaction tags. Returns `{tags: [Tag]}`. `Tag` has `id`, `name`, `color` (hex),
`order`, `transactionCount` (lifetime).

### `GET /v1/transactions/{id}`

Single-transaction full detail: splits, attachments, original-transaction info,
merchant + recurring-stream link. Heavier than the per-row data in `/v1/transactions`,
useful for "what does Monarch know about THIS one charge."

Returns `{transaction: {...}}`. Shape is the verbatim GraphQL `getTransaction` payload.

### `GET /v1/transactions/{id}/splits`

Just the splits for one transaction (lighter than `/v1/transactions/{id}`). Returns
`{id, amount, merchant, category, splits: [{id, amount, notes, merchant, category}]}`.

### `GET /v1/transactions/summary`

Aggregate stats (count / sum / avg / max / first / last date) across a transaction
window. Cheaper than fetching every row when all you want is the totals.

**Params:** `start`, `end`, `accountId` (all optional).

### `GET /v1/transactions/duplicates`

Server-side duplicate detection. Pulls a transaction window and groups rows that match
on `(date, amount, plaidName, accountId)`. Returns `{groups: [{key, transactions: [...]}]}`;
single-row "groups" are excluded. Useful for cleanup after a Plaid re-pull double-posts a
transfer or after a manual import overlaps an auto-import.

Keying on `plaidName` (the raw Plaid description) rather than the normalized
`merchantName` avoids false positives: two genuine same-day same-merchant same-amount
charges carry different `plaidName` reference strings; only true double-inserts share
an identical `plaidName`.

**Params:** `start`, `end`, `accountId`, `accountIds`.

**Quirks:**
- Internal fetch window is hardcoded at 500 rows (`DUPLICATES_FETCH_LIMIT`). Not
  user-overridable; if you need more, narrow the date window or filter by `accountId`.

### `GET /v1/cashflow/breakdown`

Cashflow grouped by category, group, AND merchant, plus the same overall summary as
`/v1/cashflow`. Returns `{byCategory: [...], byCategoryGroup: [...], byMerchant: [...], summary: {...}}`.

### `GET /v1/category-groups`

Parent groups (one tier above individual categories). Returns
`{categoryGroups: [{id, name, order, type, updatedAt, createdAt}]}`. `type` is
`expense` / `income` / `transfer`. **Used by budget endpoints**: the budget API targets
groups OR categories, not bare names.

### `GET /v1/institutions`

Linked Plaid credentials (the connection pipes, distinct from the accounts they hold).
Returns `{credentials: [...], accounts: [...], subscription: {...}}`. Each credential
exposes `updateRequired` and `disconnectedFromDataProviderAt`; use these to spot stale
or broken connections.

### `GET /v1/account-type-options`

Valid `(type, subtype)` combinations for creating manual accounts. Returns
`{accountTypeOptions: [{type, subtype}]}`. Use this to populate the `--type` /
`--subtype` args of `POST /v1/accounts`.

### `GET /v1/subscription`

Monarch subscription tier + payment source. Returns
`{id, paymentSource, referralCode, isOnFreeTrial, hasPremiumEntitlement}`. Useful for
"does this account have Plaid access" gating.

### `GET /v1/credit/history`

Credit-score snapshots from Monarch's Spinwheel integration. Returns
`{snapshots: [{reportedDate, score, userId}]}`. **Empty array** for users who don't
have Spinwheel enabled, not 404.

### `GET /v1/budgets`

Monthly budget + actuals across a date range. Returns
`{budgetData: {...}, categoryGroups: [...]}`, the full Monarch budget tree:

- `budgetData.monthlyAmountsByCategory[]`: planned vs. actual per category per month.
- `budgetData.monthlyAmountsByCategoryGroup[]`: same at the group level.
- `budgetData.monthlyAmountsForFlexExpense[]`: Flex bucket allocations.
- `budgetData.totalsByMonth[]`: income / expense / fixed / flexible totals per month.
- `categoryGroups[]`: the budget scaffold (groups + their categories + rollover periods).

**Defaults:** when both dates omitted, returns last-month → next-month (3 months of
window). Single-month: pass `start=YYYY-MM-01&end=YYYY-MM-01`.

### `GET /v1/recurring`

Upcoming + recent recurring transaction occurrences (subscriptions, bills, paychecks).
Returns `{items: [{date, amount, isPast, transactionId, stream: {...}, merchant: {...}, account: {...}, category: {...}}]}`.

**Defaults:** when both dates omitted, returns start-of-this-month → start-of-next-month
(Monarch's UI default). Widen the window to see further out.

### `GET /v1/refresh/status`

Per-account `hasSyncInProgress` flags + a convenience `allComplete: Boolean`. Use this
AFTER `POST /v1/refresh` to poll until every account has finished re-pulling.

### `GET /v1/balance-history/{sessionKey}/status`

Poll the parse status of a balance-history CSV upload (session keys come from
`POST /v1/accounts/{id}/balance-history`). Returns `{status: "pending"|"processing"|"completed"|"failed", ...}`.
Once `completed`, the rows have been merged into the account's `BalanceSnapshot` series
and will appear in `GET /v1/account/{id}/history`.

### `GET /v1/credentials`

Lightweight list of every linked data-provider credential plus its institution
(id, name, logo). For richer per-credential settings (preferred provider,
per-provider institution ids), use `GET /v1/credentials/institutions` instead.

### `GET /v1/credentials/institutions`

Credentials with their institutions and the per-credential `preferredDataProvider`.
Richer than `/v1/credentials` because it includes per-provider institution ids (Plaid,
Finicity, MX).

### `GET /v1/institutions/by-plaid/{plaidId}`

Institution metadata (logo, status, connection health) by Plaid institution id.

**Params:** `plaidId` (path) - Plaid institution id (e.g. `ins_3`).

### `GET /v1/institutions/top-groups`

Monarch's top-N institutions grouped by category, scoped to the requested data
providers. Used by the Add-Account UI.

**Params:** `dataProvider` - one or more providers (`PLAID`, `FINICITY`, `MX`).
Repeat the query param to pass multiple.

### `GET /v1/budgets/status`

Cheap status check on the budget tree: returns has-budget, has-transactions, and a
flag for Monarch's empty-default-categories bootstrap path. Use to gate "show
onboarding" vs "show budget" UI.

### `GET /v1/budgets/month`

Trimmed single-month budget data: budget system + per-category monthly amounts for
one month. Lighter than `GET /v1/budgets` when you only need the per-category
plan/actual view for a specific month.

**Params:** `month` (required) - first-of-month date, e.g. `2026-05-01`.

### `GET /v1/categories/{id}/edit`

Single category enriched with edit-form fields: budget variability, rollover period,
group metadata, system-category flag. Use as the source of truth before constructing
an update payload.

### `GET /v1/categories/{id}/deletion-info`

Slim category snapshot (id, name, icon, `isSystemCategory`) for the delete-confirm
flow. Cheaper than the full `/v1/categories/{id}/edit` view.

### `GET /v1/category-groups/{id}/details`

Category group plus its child categories (id, name, icon) and the group-level
rollover period config.

**Params:** `includeDisabledSystemCategories` (optional bool).

### `GET /v1/recurring/all`

Stream-shaped recurring view: one entry per recurring transaction stream (NOT per
occurrence; that's `GET /v1/recurring`). Each entry carries the stream definition,
the next forecasted occurrence, plus merchant, category, and account resolved to
full objects.

**Params:**
- `includeLiabilities` (bool, default false) - also include credit-report-derived
  streams (loan payments, credit-card minimum payments).
- `includePending` (bool, default false) - include streams Monarch hasn't yet
  confirmed as recurring.

### `GET /v1/recurring/streams`

Raw recurrence rules behind each stream: review status, base date, frequency
(`weekly`, `monthly`, etc.), expected day-of-month, and any linked credit-report
liability account. Lighter than `/v1/recurring/all`; pair with
`PATCH /v1/merchants/{id}/recurrence` to mutate a rule.

**Params:** `includeLiabilities` (bool).

### `GET /v1/recurring/aggregate`

Month-by-month rollup of recurring-transaction occurrences, grouped by status
(`completed`, `remaining`, etc.) and totaled by `expense` / `creditCard` / `income`
per-group and across the whole window.

**Params:** `start`, `end`. Use for "what recurring spend hits this month" or
"what's already happened vs still pending" summaries.

### `GET /v1/recurring/dashboard`

Per-item upcoming recurring transaction stream plus the remaining-due dollar total
for the same window. Drop-in shape for a "next 30 days bills" widget.

**Params:** `start`, `end`, `includeLiabilities` (bool).

### `GET /v1/goals`

Every v2 savings goal: active, archived, soft-deleted-but-still-visible, both debt
and savings types together. Each entry carries name, target amount, current
progress, priority, linked accounts, and `archivedAt`.

**Quirks:**
- Filter client-side on `archivedAt == null` to hide archived.
- Sort on `priority` for the user's intended display order.
- For one goal's detail use `GET /v1/goals/{id}`; for the event log use
  `GET /v1/goals/{id}/events`.

### `GET /v1/goals/{id}`

Full detail for one savings goal: name, target amount, current balance, target
date, type (`savings` or `debt`), priority, linked accounts, archive state.

### `GET /v1/goals/{id}/events`

Full event ledger for one goal: every contribution, withdrawal, and transaction
Monarch auto-linked to the goal. Each event has type, amount, date, account, and
source transaction id (if any).

### `GET /v1/goals/totals/current-month`

Sum of `totalPlannedAmount` across the requested month window, broken out per goal.
Use for "how much am I planning to contribute this month and to which goals" without
pulling each goal's full plan series.

**Params:** `startMonth`, `endMonth` (both `YYYY-MM-01`). Default is the current
calendar month when both omitted.

### `GET /v1/transaction-rules`

All auto-categorization rules in display order. Each rule has matching criteria
(merchant, amount range, account, current category) and a set of actions (set
category, add tags, hide from reports, split, set merchant name) applied whenever
a transaction matches.

### `GET /v1/merchants/search`

Free-text search across merchant names, ordered by transaction count (most-used
first). Use to populate a merchant picker, resolve an id by name, or browse the
catalog.

**Params:**
- `q` - search text.
- `limit` - max merchants to return.
- `offset` - page offset (only respected when `withLogo: true`).
- `withLogo` (bool, default false) - switch to the logo-enabled variant; includes
  `logoUrl` per merchant but drops `includeIds`.
- `includeIds` - pin specific merchant ids into the result set. Repeat the query
  param. Only honored when `withLogo: false`.

**Quirks:**
- Two backing GraphQL queries based on `withLogo`. The default (no logo) is faster
  and supports `includeIds`; the logo variant supports `offset` pagination.

### `GET /v1/merchants/{id}`

Full single-merchant detail: id, name, `logoUrl`, `transactionCount`, `ruleCount`,
`canBeDeleted`, `hasActiveRecurringStreams`, plus the merchant's recurring stream
definition when present.

Use before a delete to check `canBeDeleted`, or before a recurrence PATCH to read
the current name (required by `PATCH /v1/merchants/{id}/recurrence`).

### `GET /v1/securities/search`

Free-text search across Monarch's security catalog (Plaid-backed plus user-added).
Use to resolve a ticker or company name to the `securityId` required by
`POST /v1/account/{id}/holdings`.

**Params:**
- `q` (required) - search text (ticker, name, partial substring).
- `limit` - cap result count; Monarch defaults to a small page when omitted.
- `orderByPopularity` (bool) - when true, rank by holding-popularity instead of
  relevance.

### `GET /v1/securities/{id}/performance`

Per-day price history for one security plus current and closing price.
`historicalChart` is a list of `(date, returnPercent, value)` points where
`returnPercent` is the cumulative return from the window start.

**Params:** `start`, `end`.

### `GET /v1/portfolio/allocation`

Pie-chart-style allocation breakdown for the portfolio (or a subset via
`accountIds`). Returns each bucket's percent + dollar value, plus total portfolio
value.

**Params:**
- `accountIds` - filter to specific investments accounts (repeat the query param).
- `classificationField` - `PortfolioAllocationClassificationField` enum
  (`SECURITY_TYPE`, `ASSET_CLASS`, `SECTOR`, etc.). Omit to use Monarch's default.

### `GET /v1/portfolio/allocation/by-account`

Allocation breakdown bucketed per investments account. Each row is one account
with its percent of portfolio and total dollar value.

**Params:** `accountIds`, `limit`.

### `GET /v1/portfolio/allocation/by-holdings`

Allocation breakdown bucketed per holding (ticker / security name), capped at
`limit` rows. Each row is one security with its percent of portfolio and total
dollar value.

**Params:** `accountIds`, `limit`.

### `GET /v1/portfolio/allocation/holdings-detail`

Drill-down: lists individual holdings inside one classification bucket (e.g.
every equity inside the "Equities" classification value).

**Params:**
- `classificationField` (required).
- `classificationValue` (required) - the specific bucket within the field to
  drill into.
- `accountIds`, `limit`, `offset`.

### `GET /v1/paychecks`

Paycheck records (Monarch's structured paycheck model, not raw transactions).
Each entry has `payDate`, gross, net, employer, owner (household member), plus
deductions and deposits arrays.

**Params:** `start`, `end` (on `payDate`; omit both for full history),
`ownerId`, `employerId`.

### `GET /v1/paychecks/{id}`

Full breakdown for one paycheck: pay date, gross, net, employer, owner, per-line
`deductions` (taxes, retirement, insurance), per-account `deposits`.

### `GET /v1/paychecks/summary`

One rollup row over the filtered paycheck set: `count`, `totalGross`,
`totalDeductions`, `totalNet`, `deductionRate` (deductions / gross), plus a
breakdown by deduction type (federal tax, state tax, 401k, health insurance, etc.).

**Params:** `start`, `end`, `employerId`, `ownerIds[]`. Defaults to all-time when
both dates omitted.

### `GET /v1/paycheck-employers`

Named-employer registry. Each entry is a reusable employer id referenced by
paycheck records via `employerId`.

**Params:** `search` (free-text, case-insensitive), `limit`, `offset`.

### `GET /v1/tax/categories`

Every category with its `systemCategory` tag, so callers can map to tax schedules
without re-querying per category.

### `GET /v1/tax/category-aggregates`

`{sum, count}` per category across the window, with `systemCategory` attached.
Same shape as cashflow-by-category but pre-joined for tax-prep flows.

**Params:** `start`, `end`.

### `GET /v1/tax/schedule-mappings`

Monarch's mappings from tax-schedule line items to user categories for a given
`taxYear`. Use as the lookup layer when preparing Schedule C from transaction
aggregates.

**Params:** `schedule` (e.g. `SCHEDULE_C`), `taxYear` (4-digit).

### `GET /v1/insights`

Monarch's AI-driven money-saving opportunities (subscription audits, bill
negotiation candidates, etc.). Each insight has a savings estimate range, effort
tag, and current annual cost.

Also returns an aggregate `summary` over the window (counts + identified savings
totals) and `latestRun` metadata to gauge freshness.

**Params:**
- `status` - filter to `InsightStatusEnum` values (`NEW`, `ACCEPTED`, etc.).
  Repeat the param for each.
- `summaryStart`, `summaryEnd` - bounds for the `summary` aggregate window.

### `GET /v1/insights/{id}`

Detail view of one insight, including the optional `playbook.diySteps`
(do-it-yourself walkthrough text) and `paymentAccount` label when relevant.

### `GET /v1/insights/latest-run`

Just the latest insight-run metadata (id, status, errorMessage,
insightsGeneratedCount) and the current total insights count. Faster than
`/v1/insights` when all you need is freshness.

### `GET /v1/refresh/latest`

Latest force-refresh operation (id + state) for this user. Lightweight alternative
to `/v1/refresh/status` when you only need to know "is a refresh currently running"
rather than per-account breakdown. States observed: `IN_PROGRESS`, `COMPLETED`,
`FAILED`. May be null if the user has never triggered a force refresh.

### `GET /v1/recap/weekly`

AI-generated narrative recap for one week. Monarch backfills this on a schedule.
Pick `start` = Monday, `end` = Sunday of the target week. Returns `null` recap if
Monarch hasn't generated one for that window yet.

Includes a top-level `summary` plus per-module `cards` (cashflow card, biggest
spend, savings progress, etc.) with both rich-block JSON and markdown variants.

**Params:** `start` (required), `end` (required).

### `GET /v1/cashflow/dashboard`

Day-by-day expense series for a date window. Lightweight series for charting spend
over time; sparser shape than `/v1/cashflow`, only the day-grain summary.

**Params:** `start`, `end`.

### `GET /v1/cashflow/timeframe`

Income, expense, savings, and savings-rate aggregated three ways: by year, by
month, by quarter. Good for "how does this year compare to last."

**Params:** `start`, `end`.

### `GET /v1/cashflow/entities`

Three breakdowns over the same date window: by category, by category group, by
merchant. Plus a totals summary (income, expense, savings, savings rate). Useful
for "where did my money go" prompts.

**Params:** `start`, `end`.

### `GET /v1/cashflow/filtered`

Filterable cashflow query: summary aggregates plus year/month/quarter bucketing
AND category/group/merchant breakdowns in one shot.

**Params:** `start`, `end`, `accountId[]`, `categoryId[]`, `categoryGroupId[]`,
`merchantId[]`, `tagId[]` (repeat each query param for multiple ids).

### `GET /v1/transactions/dashboard`

Transaction rows scoped to a date window plus pagination, with a totalCount,
totalSelectableCount, and a rule-count sidecar. Lightweight shape for dashboard
widgets.

**Params:** `start`, `end`, `limit`, `offset`.

### `GET /v1/transactions/accounts-for-filter`

Accounts that would be touched by a bulk transaction operation given the supplied
filter. Currently date-window-only (extends to a full filter via repeat params).

**Params:** `start`, `end`.

### `GET /v1/transactions/review-summary`

Per-household-member count of transactions currently flagged as needing review.
Empty list = nothing in the review queue.

### `GET /v1/transactions/explain/{id}`

Monarch's AI-generated explanation for why a transaction was categorized the way
it was. Useful for surfacing context in audit or review flows.

### `GET /v1/attachments/{id}`

Resolve an attachment id to its `originalAssetUrl` (a pre-signed download URL).
Use the URL to GET the underlying file from Monarch's storage backend.

## Writes

Request bodies are typed JSON. Path `{id}` is injected into the GraphQL input on
PATCH/DELETE. Every write response is `{"data": <Output>}`.

**The PayloadError contract applies to ALL writes** (see below).

### `POST /v1/auth/refresh`

Reload session JSON from disk. Body: empty. Use after re-running bootstrap.

### `POST /v1/refresh`

Pokes Monarch to re-poll Plaid. Returns 202. Body: empty.

### `POST /v1/refresh/wait`

Synchronous refresh: kicks `POST /v1/refresh` then blocks until every account reports
`hasSyncInProgress: false` (or `timeoutSeconds` elapses). Returns the final
`/v1/refresh/status` payload. Saves the caller from a manual poll loop.

```json
{ "timeoutSeconds": 120 }   // optional, default 120
```

Poll interval defaults to 2s; override at startup with
`MONARCH_REFRESH_POLL_INTERVAL_MS` (or `monarch.refresh.poll-interval-ms` Spring
property).

### `POST /v1/transactions`

Create a transaction.

```json
{
  "accountId": "<from /v1/accounts>",
  "date": "2026-05-25",
  "amount": -42.50,
  "merchantName": "Lowe's",
  "categoryId": "<from /v1/categories>",
  "notes": "optional",
  "shouldUpdateBalance": false
}
```

### `PATCH /v1/transactions/{id}`

Partial update. Send only the fields you want to change. Available:
`category`, `name` (merchant), `amount`, `date`, `notes`, `hideFromReports`,
`needsReview`, `reviewed`, `goalId`.

### `DELETE /v1/transactions/{id}`

Delete one transaction.

### `PUT /v1/transactions/{id}/tags`

**Full overwrite** of the tag set on a transaction.

```json
{ "tagIds": ["tag-id-1", "tag-id-2"] }
```

Pass `{"tagIds": []}` to remove all tags.

### `POST /v1/transactions/{id}/splits`

Replace the splits on a transaction.

```json
{
  "splitData": [
    { "merchantName": "A", "amount": -10.0, "categoryId": "cat-1" },
    { "merchantName": "B", "amount": -32.50, "categoryId": "cat-2" }
  ]
}
```

The sum of split amounts must equal the original transaction's `amount`. Monarch
enforces this; if you violate it, the bridge returns 422 with the field error.

### `POST /v1/transactions/{id}/attachments`

Attach a receipt (image or PDF) to a transaction. Content-type is `multipart/form-data`
with a single `file` part; everything else (signed Cloudinary URL, transaction-attachment
mutation) is internal. Returns `{attachment: {id, publicId, extension, sizeBytes, originalAssetUrl}}`.

```bash
curl -X POST http://localhost:9084/v1/transactions/$TX_ID/attachments \
  -F file=@receipt.pdf
```

Three GraphQL calls run server-side:
`GetTransactionAttachmentUploadInfo` (signed Cloudinary params) →
multipart POST to `api.cloudinary.com` (SSRF-allowlisted) →
`AddTransactionAttachment` (link asset to txn). The Monarch session token never leaves
the bridge.

### `POST /v1/accounts`

Create a manual (non-Plaid) account.

```json
{
  "type": "depository",
  "subtype": "savings",
  "name": "Manual savings",
  "displayBalance": 1000.0,
  "includeInNetWorth": true
}
```

### `PATCH /v1/accounts/{id}`

Partial update. Available: `name`, `displayBalance`, `type`, `subtype`,
`hideFromList`, `includeInNetWorth`, `hideTransactionsFromReports`.

### `DELETE /v1/accounts/{id}`

Delete an account. Destructive; also removes all linked transactions.

### `DELETE /v1/institutions/{id}`

Unlink a Plaid credential (institution connection). Equivalent to Monarch web UI:
Settings → Data Sources → unlink. The `{id}` here is the **credential id** from
`GET /v1/institutions` `credentials[].id`, not an account id.

Use this to clean up stale credentials with `updateRequired: true` that no longer auth
(broken Plaid connections that accumulate over time and clutter the Data Sources page).
Linked accounts are **soft-deleted**: they still appear in `GET /v1/institutions` under
`accounts[]` with a non-null `deletedAt`, but disappear from default `GET /v1/accounts`
results. Their transaction history is preserved.

Returns `{deleted: true}` on success. PayloadError → 422 if Monarch rejects.

### `POST /v1/accounts/{id}/balance-history`

Bulk-backfill historical balance snapshots for a manual account from a CSV.
Content-type is `multipart/form-data` with a single `file` part containing a CSV with
`date,balance` rows (Monarch's own format). Returns `{sessionKey: "..."}` immediately;
parsing is asynchronous. Poll `GET /v1/balance-history/{sessionKey}/status` until
`status: "completed"`, then the snapshots show up in `GET /v1/account/{id}/history`.

```bash
curl -X POST http://localhost:9084/v1/accounts/$ACCOUNT_ID/balance-history \
  -F file=@balances.csv
```

Plaid-linked accounts reject this; Plaid is the system of record for those balances.

### `POST /v1/tags`

```json
{ "name": "Business", "color": "#19D2A5" }
```

### `POST /v1/categories`

```json
{
  "group": "<group-id from /v1/categories[].group.id>",
  "name": "Home improvement",
  "icon": "🔧",
  "rolloverEnabled": false,
  "rolloverType": "monthly",
  "rolloverStartMonth": "2026-05-01"
}
```

### `DELETE /v1/categories/{id}?moveToCategoryId={other-id}`

Delete a category. Pass `moveToCategoryId` to remap its transactions to another
category; omit to leave those transactions uncategorized.

### `POST /v1/categories/bulk-delete`

Delete many categories in one request. Wraps `DELETE /v1/categories/{id}` per id and
returns a partitioned result so a single bad id doesn't roll back the rest.

```json
{
  "categoryIds": ["cat-1", "cat-2", "cat-3"],
  "moveToCategoryId": "<optional fallback>"
}
```

Response: `{succeeded: ["cat-1", "cat-3"], failed: [{id: "cat-2", error: "..."}]}`.
HTTP 200 even when some ids fail; check the `failed` array. `moveToCategoryId` applies
to every id in the batch.

### `POST /v1/budgets/items`

Set the planned budget amount for **one** category OR category-group for a given month.
Pass exactly one of `categoryId` / `categoryGroupId`; Monarch rejects both-set and
both-null.

```json
{
  "amount": 250.0,
  "startDate": "2026-05-01",
  "categoryId": "<cat-id>",           // OR categoryGroupId, not both
  "timeframe": "month",               // optional, only valid value today
  "applyToFuture": false              // optional, true = also future months
}
```

`amount: 0` clears (un-sets) the budget for that category.

### `POST /v1/budgets/reset`

Reset all planned amounts for a single month back to defaults. Body: `{"startDate": "YYYY-MM-01"}`.

### `PUT /v1/budgets/flex`

Update the Flex bucket total for a month (the `fixed_and_flex` system's flexible-expense
allowance, distinct from per-category budgets).

```json
{ "amount": 1500.0, "startDate": "2026-05-01", "applyToFuture": false }
```

### `PUT /v1/budgets/flex/rollover`

Reset / configure the Flex bucket rollover period. Common use: point the rollover start
to the current month with `rolloverStartingBalance: 0` to clear accumulated negative
rollover from many over-budget months.

```json
{
  "rolloverStartMonth": "2026-05-01",
  "rolloverStartingBalance": 0.0,
  "rolloverEnabled": true,
  "budgetSystem": "fixed_and_flex"
}
```

### `PATCH /v1/merchants/{id}/recurrence`

Update a merchant's recurring-transaction settings (frequency, base date, amount,
active flag). **`name` is required**; Monarch's mutation always validates it. Pass
the merchant's existing display name if you only want to change recurrence fields.

```json
{
  "name": "Netflix",
  "isRecurring": true,
  "frequency": "monthly",       // or weekly / biweekly / etc.
  "baseDate": "2026-05-25",
  "amount": -15.99,
  "isActive": true
}
```

### `PATCH /v1/accounts/bulk`

Bulk account updates in one round-trip. Forwards Monarch's `updateAccounts`
mutation. Send one or more `UpdateAccountsMutationInput` entries; each must include
`id` plus any subset of the patchable fields. Returns every updated account.

Use for "rename three accounts at once," "hide a set of accounts," or "flip
`includeInNetWorth` on a list" without firing N single `PATCH /v1/accounts/{id}`
calls.

### `PATCH /v1/transactions/bulk`

Bulk transaction updates. Two selection modes share one shape (`allSelected`
discriminates):

- `allSelected: false` + `selectedTransactionIds: [a,b,c]` - apply `updates` to
  exactly those N transactions.
- `allSelected: true` + `filters: {...}` + optional
  `excludedTransactionIds: [...]` - "select everything matching the filter, minus
  these."

`expectedAffectedTransactionCount` is a safety check: Monarch refuses the mutation
if its actual affected-row count differs (race prevention).

`updates` is Monarch's `TransactionUpdateParams` shape (same fields as
`PATCH /v1/transactions/{id}`: categoryId, merchantName, notes, date, hide, etc.).

### `POST /v1/transactions/bulk-delete`

Bulk transaction delete with the same two-mode selection as bulk-update:

- `allSelected: false` + `selectedTransactionIds: [a,b,c]` to delete exactly N.
- `allSelected: true` + `filters: {...}` + optional `excludedTransactionIds: [...]`
  to delete everything matching minus a hand-picked exclusion list.

`expectedAffectedTransactionCount` is the same race-prevention guard. Destructive;
prefer `GET /v1/transactions/duplicates` first to scope the selection.

### `POST /v1/transactions/{id}/not-recurring`

Tell Monarch the recurring stream a transaction is attached to is NOT actually
recurring. Used to dismiss false-positive recurrence detections.

**Quirks:**
- The path `{id}` is the transaction's `stream.id` (visible on the transaction
  detail), NOT the transaction id itself. Monarch's mutation takes a `streamId`.

### `POST /v1/category-groups`

Create a category group (parent grouping for individual categories).

```json
{
  "name": "Home & Garden",
  "type": "expense",            // income / expense / transfer
  "orderBefore": "<group-id>",  // optional; omit to append
  "budgetVariability": "flexible"  // optional, default flexible
}
```

Attach child categories afterward via `POST /v1/categories` with the new group's
id as `groupId`.

### `PATCH /v1/category-groups/{id}`

Patch a category group. Only non-null fields are forwarded; omit a field to leave
it untouched. Editable: `name`, `type`, `budgetVariability`,
`groupLevelBudgetingEnabled`, icon, color.

For the narrow "just set fixed vs flex" case, use
`PATCH /v1/category-groups/{id}/budget-variability` instead.

### `PATCH /v1/category-groups/{id}/budget-variability`

Targeted single-field update for `budgetVariability` on a category group. Values:

- `fixed` - predictable monthly amount (e.g. rent).
- `flexible` - variable spend (e.g. groceries); rolls into the Flex bucket.
- `non_monthly` - irregular (e.g. holiday gifts).

The wider `PATCH /v1/category-groups/{id}` does the same thing; this exists as a
narrower, intent-revealing call.

### `DELETE /v1/category-groups/{id}?moveToGroupId={other-id}`

Delete a category group. Pass `moveToGroupId` to remap every child category under
this group to another group before deletion; omit and the orphans may need manual
cleanup (Monarch will leave them pointing at a no-longer-existing parent).

**Quirks:**
- System groups (Monarch's built-ins) cannot be deleted.

### `POST /v1/goals`

Create a savings or debt-payoff goal. Wraps Monarch's `createSavingsGoals` batch
mutation with a single-goal body.

```json
{
  "name": "Emergency fund",
  "targetAmount": 10000,
  "targetDate": "2026-12-31",  // optional
  "type": "savings",           // optional, default "savings"; "debt" for payoff
  "accounts": ["<acct-id>"],   // optional, pre-link funding accounts
  "imageStorageProvider": "...",
  "imageStorageProviderId": "..."
}
```

`type: "debt"` flips the sign convention: progress = paying it DOWN. Once created,
set monthly contributions via `PUT /v1/goals/{id}/budget` and log actuals via
`POST /v1/goals/{id}/contributions`.

### `PATCH /v1/goals/{id}`

Patch one goal. Only populated fields forwarded; omit a field to leave it
untouched. Common edits: rename, change `targetAmount` / `targetDate`, re-link
`accounts`, update icon.

To re-order priority across goals use `PUT /v1/goals/priorities` instead. To
archive use `DELETE /v1/goals/{id}` (reversible) or `DELETE /v1/goals/{id}/hard`
(permanent).

### `DELETE /v1/goals/{id}`

**Soft-deletes** the goal by setting its `archivedAt` timestamp. The goal stays
visible via `GET /v1/goals` (filter on `archivedAt` to hide), `status` flips to
`archived`, and it drops out of active-goal aggregates.

Reversible via `POST /v1/goals/{id}/unarchive`. For permanent removal use
`DELETE /v1/goals/{id}/hard`.

### `DELETE /v1/goals/{id}/hard`

Permanently remove the goal. **No undo.** Distinct from `DELETE /v1/goals/{id}`
(which archives / soft-deletes). After this call the goal disappears from
`GET /v1/goals` and its event log is no longer queryable.

### `POST /v1/goals/{id}/unarchive`

Restore a previously archived goal back to active state. Inverse of
`DELETE /v1/goals/{id}`: clears `archivedAt` and flips `status` back to `active`.
No-op if the goal is already active.

### `POST /v1/goals/{id}/contributions`

Log a contribution event against a goal from a specific account. Required:
`accountId` and `amount` (dollars, positive for contribution, negative for
withdrawal). `date` defaults to today.

```json
{ "accountId": "<acct-id>", "amount": 500.0, "date": "2026-05-26" }
```

Updates the goal's `currentAmount` and appends to its event log (visible via
`GET /v1/goals/{id}/events`).

Distinct from `PUT /v1/goals/{id}/budget` which sets the planned monthly
contribution (forecast), not the actual.

### `PUT /v1/goals/{id}/budget`

Set the planned monthly contribution for a goal. With `applyToFuture: true`,
cascades the same amount to every subsequent month. This is the FORECAST, not a
recorded contribution.

```json
{
  "startDate": "2026-05-01",
  "amount": 500.0,
  "accountId": "<acct-id>",      // optional; omit for household-level planned
  "applyToFuture": true
}
```

Pair with `GET /v1/goals/totals/current-month` to read back planned totals.

### `PUT /v1/goals/priorities`

Re-order goals. Send the COMPLETE goal id list in the desired order; the bridge
assigns `priority = index` (0-based) and calls Monarch's batch priority mutation
in one round-trip.

```json
{ "goalIds": ["g1", "g2", "g3"] }
```

Goals missing from the list keep their current priority but end up after all
listed goals. Use after a drag-and-drop reorder.

### `POST /v1/transaction-rules`

Create a transaction rule. Criteria and actions are both partial: omit any field
to leave it unset (e.g. omit `merchantName` to match on amount-range only).

Criteria support: merchant name, amount range, account, current category.
Actions support: set category, add tags, set merchant name, hide from reports,
split.

**Quirks:**
- Rules apply to incoming transactions on next sync. Monarch does not
  retroactively categorize unless the user explicitly runs the rule from the UI.
- To dry-run a rule shape before saving, use `POST /v1/transaction-rules/preview`.

### `POST /v1/transaction-rules/preview`

Dry-run a tentative rule shape. Returns the transactions that *would* match it if
saved, with the proposed new values (`newCategory`, `newTags`, `newName`, etc.).
No persistence.

Returns up to 30 results per call; page with `offset`.

### `PATCH /v1/transaction-rules/{id}`

Replace the criteria and actions on an existing rule.

**Quirks:**
- Monarch's mutation takes the FULL rule shape, NOT a partial patch. The bridge
  forwards what you send verbatim. Omit any sub-tree you want to clear, but be
  aware that omitting an array you wanted to keep will wipe it. Fetch the
  current rule via `GET /v1/transaction-rules` first if in doubt.

### `DELETE /v1/transaction-rules/{id}`

Delete one auto-categorization rule. **Non-cascading**: existing transactions
that the rule previously categorized keep their assigned category. To
temporarily disable a rule without deleting, use the PATCH endpoint with the
rule paused.

### `DELETE /v1/merchants/{id}?moveToId={other-id}`

Delete a merchant. **Destructive** for any transactions and rules that
referenced this merchant unless you remap.

Pass `moveToId` to reassign every transaction and every auto-categorization rule
pointing at this merchant to a different merchant before deletion. Omit to
orphan them (transactions fall back to displaying the raw `plaidName`).

Check `canBeDeleted` and `transactionCount` via `GET /v1/merchants/{id}` first.

### `PATCH /v1/merchants/{id}/logo`

Point a merchant at an existing Cloudinary asset by public id.

**Quirks:**
- Monarch's `setMerchantLogo` mutation does NOT accept a binary upload. The asset
  must already exist on Cloudinary (typically uploaded via Monarch's web UI).
  Pass the asset's `cloudinaryPublicId`; send `null` or omit to clear the logo.
- To upload a fresh logo you'd need to upload to Cloudinary out-of-band first.

### `POST /v1/account/{id}/holdings`

Add a manual holding (security position) inside a brokerage account that Monarch
can't auto-sync (e.g. employer 401k, private fund).

```json
{
  "securityId": "<from /v1/securities/search>",
  "quantity": 100,
  "costBasis": 12345.67
}
```

`securityId` must be a real Monarch security id; use `GET /v1/securities/search`
to look one up by ticker or name.

### `PATCH /v1/holdings/{id}`

Partial-update a holding. Fields are independent: pass only what changed.
`userCostBasis` is stored separately from any data-provider basis, so setting it
overrides for display only.

### `DELETE /v1/holdings/{id}`

Delete one security position from its account. **No soft-delete.**

**Quirks:**
- On Plaid-synced brokerage accounts the holding may reappear on next sync if
  the position still exists at the data provider. For manual investments
  accounts the delete sticks.

### `POST /v1/accounts/manual-investments`

Create a brokerage-style account Monarch cannot auto-sync (e.g. employer 401k
where Plaid lacks coverage). Two tracking methods:

- `balances` - single account-level balance, no per-security detail.
- `holdings` - per-security positions (seed via `initialHoldings`).

`trackingMethod` defaults are inferred by Monarch from whether `initialHoldings`
is present. Add or update positions later via the dedicated holdings endpoints.

### `POST /v1/paychecks`

Record a paycheck from scratch. Required: `employerId`, `ownerId`, `payDate`,
`gross`, `net`. Optional: `deductions[]` (per-line: taxes, retirement,
insurance) and `deposits[]` (per-account splits of the net).

`employerId` must already exist; register via `POST /v1/paycheck-employers`
first. Deductions and deposits can be filled in later via
`PATCH /v1/paychecks/{id}`.

### `PATCH /v1/paychecks/{id}`

Patch one paycheck. Only fields present in the body are forwarded.

**Quirks:**
- The `deductions` and `deposits` arrays are NOT delta updates. When either is
  present in the body it WHOLESALE REPLACES the existing list (Monarch's
  `UpdatePaycheckInput` semantics). To add a single deduction, GET the current
  list first, then send the merged list back.

### `DELETE /v1/paychecks/{id}`

Delete one paycheck and its deductions/deposits. **Destructive.**

**Quirks:**
- The underlying transaction (the actual deposit on the bank side) is NOT
  deleted by this call - only the Monarch paycheck record that links the gross
  + deductions + deposit structure.

### `POST /v1/paycheck-employers`

Register a new employer in the registry so it can be attached to paycheck
records. Required: `name`. The returned id is the `employerId` to pass when
creating paychecks via `POST /v1/paychecks`.

### `PATCH /v1/paycheck-employers/{id}`

Rename an employer. The new name propagates to every paycheck record attributed
to this employer (paychecks reference employer by id, not by name).

```json
{ "name": "New name" }
```

### `DELETE /v1/paycheck-employers/{id}`

Delete an employer from the registry. **Refuses with 422** if any paycheck
records are still attributed to this employer - reassign or delete those first.

## PayloadError: the mutation gotcha

Monarch's mutations can succeed at the GraphQL level (HTTP 200, no `errors[]`) while
still reporting application errors in `data.<mutation>.errors[]`. Examples: "category
not found," "tag name already in use," "split sum doesn't match transaction amount."

**The bridge inspects these and returns HTTP 422** with the structured error body:

```json
{
  "code": "payload_error",
  "message": "Monarch returned application errors.",
  "details": {
    "errors": [
      { "message": "...", "code": "...", "fieldErrors": [{"field": "...", "messages": [...]}] }
    ]
  }
}
```

So as a caller you only need to check for non-2xx. You **don't** need to grep
`data.<mutation>.errors` yourself.

## CLI

`cli/monarch` is a thin bash wrapper covering every endpoint. Subcommands map 1:1:

```bash
monarch                                         # usage
monarch health
monarch accounts
monarch history <account-id>
monarch holdings <account-id>
monarch institutions
monarch account-types
monarch transactions [--start --end --account-id --limit --offset --order-by FIELD]
monarch cashflow [--start --end]
monarch cashflow breakdown [--start --end]
monarch networth [--start --end --account-type]
monarch networth recent [--start]
monarch networth by-type [--start --timeframe]
monarch categories
monarch category-groups
monarch tags
monarch subscription
monarch credit history
monarch budgets [--start --end]
monarch recurring [--start --end]
monarch tx detail <id>
monarch tx splits <id>
monarch tx summary [--start --end --account-id]

monarch refresh                                 # poke Plaid
monarch refresh status                          # per-account sync flags
monarch tx create|update|delete|tags|split ...
monarch account create|update|delete ...
monarch tag create ...
monarch category create|delete ...
```

**Flags:**
- `--raw` on any read command emits raw JSON instead of a formatted table (pipe-friendly).
- `--yes` / `YES=1` on destructive ops skips the confirmation prompt.

**Env:**
- `MONARCH_GATEWAY` (default `http://localhost:9084`): point at a different host:port.

See `cli/README.md` for the full subcommand reference with examples.

## Common gotchas

1. **`start` is a lower-bound filter, not a pagination cursor.** Results come
   newest-first. See [/v1/transactions](#get-v1transactions) for the workaround.
2. **There is no asc/desc toggle on transactions.** `orderBy` is one of `date` or
   `amount`, both descending. If you need ascending, sort client-side.
3. **Account history only goes back to the link date.** Earlier dates aren't 404;
   the snapshot array just starts at the link date.
4. **Holdings are brokerage-only.** Depository/credit/loan accounts return `[]`, not 404.
5. **Categories live in groups; groups have a `type`.** When creating a category, the
   `group` field is a group ID, not a string name.
6. **Account `currentBalance` is signed.** Liabilities (credit cards, loans) are
   negative. `displayBalance` is unsigned (for UI). Either is fine; pick one and stick
   to it.
7. **Transaction amounts are signed.** Expenses negative, income positive. The
   `cashflow` endpoint reflects this; `sumExpense` is negative.
8. **Hidden/excluded accounts are returned by `/v1/accounts`.** Filter client-side via
   `hideFromList` / `includeInNetWorth` if you don't want them.
9. **PUT `/v1/transactions/{id}/tags` is a full overwrite.** Send the complete final
   tag set, not a delta.
10. **Mutations that fail at the application level return 422, not 200.** No need to
    grep `data.<mutation>.errors`; just check the HTTP status.

## Coverage notes

This bridge is a strict superset of the public Monarch python libraries
(`hammem/monarchmoney`, `bradleyseanf/monarchmoneycommunity`): every operation those
libs expose plus five extras that previously required client-side loops or multipart
handling:

- `POST /v1/transactions/{id}/attachments`: receipt photo / PDF upload (3-step
  Monarch → Cloudinary → Monarch link flow handled internally; caller sees a single
  multipart POST).
- `POST /v1/accounts/{id}/balance-history` + `GET /v1/balance-history/{sessionKey}/status`:
  bulk CSV backfill for manual accounts; upload returns a session key, poll for status.
- `GET /v1/transactions/duplicates`: server-side dedupe-grouping over `GetTransactions`.
- `POST /v1/categories/bulk-delete`: bulk wrapper over `DELETE /v1/categories/{id}`
  with per-id success/failure partitioning.
- `POST /v1/refresh/wait`: synchronous variant of `POST /v1/refresh` that blocks until
  every account reports `hasSyncInProgress: false` (or `timeoutSeconds` elapses).

Transaction rules (auto-categorization) and savings goals were both web-UI-only on
the python libs; the bridge wraps both now (see the `Rules` and `Goals` tags). Surfaces
still not wrapped: Plaid-link initiation, notifications, investment rebalancing, manual
snapshot creation. Adding any of these to this bridge is mechanically cheap (one
`.graphql` file + one `Operation.kt` + one spec entry) but requires capturing the
GraphQL operation names and shapes from a live Monarch web session first (browser
devtools → Network tab).

## Settings, household, notifications, plus-tier (added post-v1.0 expansion)

A surface expansion added Me / Household / Preferences endpoints plus the Monarch
notifications + entitlements + Zillow zestimate + transactions move/download surfaces.

### `GET /v1/me` + `PATCH /v1/me`

The current logged-in Monarch user: id, email, name, profile fields. PATCH accepts a
subset of the same fields.

### `GET /v1/household`

The Monarch household for the current user. Households can have multiple members in
the Plus tier.

### `GET /v1/household/members`

All members of the current household (id, email, name, role).

### `GET /v1/household/preferences` + `PATCH /v1/household/preferences`

Household-level preferences (default currency, timezone, fiscal-year start, etc.).
PATCH takes a partial update.

### `GET /v1/entitlements`

What features the current Monarch account is entitled to: Plus / Premium feature flags,
trial state, billing cycle.

### `GET /v1/plus-tier`

A focused view of Plus-tier access (active vs trial vs none, days left if trial).

### `GET /v1/notifications` + activity-event writes

The notification center feed (Monarch's "Activity" page) plus four mutation endpoints:
- `POST /v1/notifications/{id}/read` - mark one as read
- `POST /v1/notifications/{id}/dismiss` - dismiss one
- `POST /v1/notifications/read-all` - mark all as read
- `POST /v1/notifications/clear-all` - dismiss the entire feed

### `POST /v1/zillow/zestimate`

Pull a Zillow Zestimate for an address (uses Monarch's Zillow integration). Useful for
adding a manual real-estate account where Monarch can keep the value fresh.

### Transactions: move / download / match-search

- `POST /v1/transactions/move` - reassign txns to a different account (e.g. after a
  Plaid relinks under a new account id).
- `GET /v1/transactions/match-search` - server-side fuzzy match for the "find similar"
  flow.
- `POST /v1/transactions/download` + `GET /v1/transactions/download/{sessionKey}` -
  large-batch download flow (returns a session key; poll the status endpoint).

### Goals v2 family

Beyond the basic `/v1/goals` CRUD, the bridge now wraps Monarch's v2 goal lifecycle:
- `POST /v1/goals/{id}/complete` / `incomplete` - mark a goal complete or back
- `POST /v1/goals/{id}/spend` - log a spend event against goal balance
- `POST /v1/goals/{id}/withdraw` - withdraw goal balance back to the source account
- `DELETE /v1/goals/{id}/v2-delete` - delete the v2 goal record
- `POST /v1/transactions/{id}/goal-link` + `DELETE /v1/transactions/{id}/goal-link` -
  link a transaction to a goal's reconciliation flow (or unlink)

### `GET /v1/accounts/{id}/balance/preview`

A lightweight version of the balance call: just the rendered display balance + the
include-in-net-worth flag. Cheaper than full account detail for dashboard widgets.

### `PATCH /v1/budgets/settings`

Mutate household-level budget defaults (rollover behavior, flex-budget rules).

## Known-broken endpoints

- `GET /v1/portfolio/allocation/holdings-detail` - Monarch upstream currently rejects
  the `$classificationField: PortfolioAllocationClassificationField!` argument with a
  400; the underlying GraphQL schema appears to have been renamed. Sister allocation
  endpoints work.

## Coverage vs. Monarch's web bundle

### The four counts (glossary)

These numbers describe different things; don't conflate them:

| Count | Meaning |
|---|---|
| **752** | Distinct GraphQL operations found in Monarch's public web bundle (snapshot 2026-05-27). The raw upstream universe, including UI-only / subscription / internal-infra ops. |
| **542** | The `Wrappable` subset of those 752: operations with a clean request/response REST shape (excludes UI-coupled flows, WebSocket subscriptions, internal-infra bootstrap aggregates, and auth-flow ops). |
| **762** | Distinct Monarch `operationName`s the bridge actually binds across its operation objects. |
| **768** | REST endpoints exposed in the OpenAPI spec. Slightly higher than 762 because a few typed controllers serve more than one route per upstream op (e.g. merchant logo + recurrence variants). This is the headline number throughout the docs. |

Every one of the 542 `Wrappable` operations is covered: 535 wired directly, 7 as
canonical prefix-variants of an already-wrapped op.

## Monarch operations intentionally NOT wrapped

Every REST-wrappable Monarch operation is wrapped. The following cannot be exposed
over HTTP and are intentionally excluded: each is either UI-coupled (only invokable
inside Monarch's own web/mobile client), a WebSocket subscription (persistent
server-to-client push with no request/response REST shape), an internal-infra
bootstrap aggregate already covered by a dedicated endpoint, or an interactive
auth-flow op. The Mobile_/Web_ screen-aggregate duplicates of canonical Common_
resource endpoints are also not separately wrapped.

| operationName | classification | reason |
|---|---|---|
| `ApplyStripeCancelDiscountOffer` | UI-only | Cancellation discount offer; only triggered from inside Monarch's in-app cancel flow |
| `Common_BasicUser` | Internal-infra | Web-bundle bootstrap aggregate; covered by existing /v1/me endpoint |
| `Common_CreateFinicityConnectFixUrlMutation` | UI-only | Finicity Connect widget URL; opened inside browser iframe to capture credentials |
| `Common_CreateFinicityConnectUrlMutation` | UI-only | Finicity Connect widget URL; opened inside browser iframe to capture credentials |
| `Common_CreateFinicityCredentialsMutation` | UI-only | Finicity post-Connect credential payload; submitted by Finicity widget |
| `Common_CreateMXConnectFixUrlMutation` | UI-only | MX Connect widget URL; opened inside browser iframe |
| `Common_CreateMXConnectUrlMutation` | UI-only | MX Connect widget URL; opened inside browser iframe |
| `Common_CreateMXCredentialsMutation` | UI-only | MX post-Connect credential payload; submitted by MX widget |
| `Common_CreatePlaidLinkTokenMutation` | UI-only | Bootstraps Plaid Link widget; link token is consumed by Plaid's JS bundle in browser |
| `Common_CreateSpinwheelTokenMutation` | UI-only | Spinwheel widget token; consumed by Spinwheel SDK in browser |
| `Common_CreateStripeCheckoutSession` | UI-only | Returns a Stripe Checkout session URL; only useful when opened in browser to complete payment |
| `Common_EndBrowserAutomation` | UI-only | Browser-puppeteer assistant flow; live session can only be observed via the subscription channel |
| `Common_GetActiveBrowserAutomationSession` | UI-only | Browser-puppeteer assistant flow; live session can only be observed via the subscription channel |
| `Common_GetAnonymousId` | Internal-infra | Web analytics anonymous ID; meaningful only inside the web bundle's Segment session |
| `Common_GetProductboardCode` | Internal-infra | Productboard SSO token; consumed by Productboard iframe in browser |
| `Common_GetSharedConstants` | Internal-infra | Web-bundle bootstrap constants; covered by individual /v1/app/* config endpoints |
| `Common_OnBrowserAutomationStatus` | Subscription | GraphQL subscription; needs WebSocket transport, not REST-mappable |
| `Common_RunBrowserAgent` | UI-only | Browser-puppeteer assistant flow; live session can only be observed via the subscription channel |
| `Common_StartBrowserAutomation` | UI-only | Browser-puppeteer assistant flow; live session can only be observed via the subscription channel |
| `GetStripeCancellationDiscountOffer` | UI-only | Reads the active cancellation discount; only meaningful inside in-app cancel flow |
| `GetTranscriptionKey` | Internal-infra | Speech transcription (Deepgram) key; only used by in-app voice feature |
| `Mobile_CreatePlaidLinkTokenMutation` | UI-only | Bootstraps Plaid Link widget; link token is consumed by Plaid's JS bundle in browser |
| `Mobile_OnMessageCreated` | Subscription | GraphQL subscription; needs WebSocket transport, not REST-mappable |
| `Mobile_OnMessageThreadUpdated` | Subscription | GraphQL subscription; needs WebSocket transport, not REST-mappable |
| `Mobile_OnMessageUpdated` | Subscription | GraphQL subscription; needs WebSocket transport, not REST-mappable |
| `Web_OnMessageCreated` | Subscription | GraphQL subscription; needs WebSocket transport, not REST-mappable |
| `Web_OnMessageThreadUpdated` | Subscription | GraphQL subscription; needs WebSocket transport, not REST-mappable |
| `Web_OnMessageUpdated` | Subscription | GraphQL subscription; needs WebSocket transport, not REST-mappable |
| `Web_OnMinimizedMessageCreated` | Subscription | GraphQL subscription; needs WebSocket transport, not REST-mappable |
| `Web_SubscribeToBillEvents` | Subscription | GraphQL subscription; needs WebSocket transport, not REST-mappable |
| `Web_createRecoveryCode` | Auth-flow | Recovery-code generation tied to interactive account-settings UI; requires browser session |

### Wrappable gap: CLOSED

The wrappable gap is now zero. All 542 `Wrappable`-classified bundle operations are
bound to a REST route: 535 are wired directly, and the remaining 7 are canonical
prefix-variants (bare names whose `Common_` / `Mobile_` / `Web_` twin is already
wrapped; wiring the bare name too would just duplicate the same upstream operation).
The final coverage-expansion pass wired the last 36 ops, all as `LongTailOperation`
opaque pass-throughs under `/v1/x/*` (35 long-tail ops plus one `_Web` screen
aggregate). What remains unwrapped is only the hard-exclusion set in the table above
(UI-coupled flows, the 9 WebSocket subscriptions, internal-infra bootstrap aggregates,
and one auth-flow op) plus the screen-aggregate `Web_` / `Mobile_` duplicates whose
fields the canonical `Common_` resource endpoints already serve.

## Where to look next

- **Add a new endpoint:** `CONTRIBUTING.md` walks through the spec-first add-an-endpoint loop.
- **Understand the package layout:** `agents/context/ARCHITECTURE.md`.
- **See current deployment state:** `agents/context/CURRENT_STATE.md`.
- **GraphQL operation strings:** `app/src/main/resources/graphql/operations/*.graphql`.
- **Request / response DTOs (generated):** `app/build/generated/openapi/src/main/kotlin/.../generated/model/*.kt` (driven by `openapi/monarch-bridge.yaml`).
