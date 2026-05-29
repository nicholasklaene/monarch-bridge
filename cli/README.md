# monarch CLI

Thin bash CLI for the monarch-bridge HTTP service. Calls `curl` against
`http://localhost:9084` (override with `MONARCH_GATEWAY`) and formats responses
with `jq`. Same shape as `~/bin/{gws,gh,git,gcloud}`. Bash 3.2 compatible.

This is the **curated** CLI: ergonomic subcommands over the operations you
reach for daily. For complete shell parity with the spec (one subcommand per
operationId, 768/768), see the generated bash client at
[`clients/bash/`](../clients/bash/README.md).

## Install

```bash
ln -sf "$(pwd)/cli/monarch" ~/bin/monarch
monarch health
```

## Authenticate

The service needs a Monarch session before any data command works. If `monarch
health` shows `authenticated=false`, run the interactive login:

```bash
monarch bootstrap
```

This runs `docker exec -it monarch-bridge java -jar /app/app.jar
--bootstrap-monarch` inside the running container, prompting for your Monarch
email, password, and (if enabled) MFA code. Set `MONARCH_CONTAINER` to override
the container name. For a repo install (no container), run interactive auth via
Gradle instead: `./gradlew :app:bootstrapMonarch`.

## Usage

### Reads

```bash
monarch                          # show usage
monarch health                   # service + auth status
monarch bootstrap                # interactive Monarch login (one-time, in Docker)
monarch accounts                 # linked accounts table
monarch networth --start 2026-01-01
monarch transactions --start 2026-05-01 --limit 5
monarch holdings <account-id>
```

All read commands accept `--raw` to bypass jq formatting (raw JSON for piping).

### Writes

Mutating commands. Destructive ones (`delete`) prompt for confirmation unless `--yes` is passed (or `YES=1` env is set).

```bash
# Transactions
monarch tx create --account <id> --date 2026-05-25 --amount -42.50 \
                  --merchant "Lowe's" --category <cat-id> --notes "rehab notes"
monarch tx update <txn-id> --category <new-cat>
monarch tx update <txn-id> --hide true --notes "ignored from reports"
monarch tx tags <txn-id> <tag-id-1>,<tag-id-2>     # overwrites; empty CSV removes all
monarch tx delete <txn-id> --yes
monarch tx split <txn-id> '[{"merchantName":"A","amount":-10,"categoryId":"cat-1"},
                             {"merchantName":"B","amount":-32.50,"categoryId":"cat-2"}]'

# Accounts
monarch account create --type depository --subtype savings --name "Manual savings" --balance 1000
monarch account update <id> --name "Renamed" --hide-from-list true
monarch account delete <id> --yes

# Tags
monarch tag create "Business" --color "#19D2A5"

# Categories
monarch category create "Home improvement" --group <group-id>
monarch category delete <cat-id> --move-to <other-cat-id> --yes
```

Mutating commands print only the relevant `data.<mutation>` node. Add `--raw` to inspect the full response.

**PayloadErrors are mapped to HTTP 422 by the bridge.** If a mutation fails at the application level (e.g. "category not found", "tag name already exists"), the CLI exits non-zero with the structured error body; no need to grep `data.<mutation>.errors[]` yourself.

## Sourceable helpers (`monarch-lib.sh`)

The CLI's HTTP helpers live in `cli/monarch-lib.sh` and can be sourced from any other bash script:

```bash
source /path/to/cli/monarch-lib.sh

call GET /v1/accounts | emit '.data.accounts[]'
call POST /v1/transactions "$(jq -n '{accountId:"...",date:"...",amount:-1,merchantName:"...",categoryId:"..."}')" \
  | emit '.data.transaction.id'

# Inside another script:
confirm "About to nuke 47 things"
parse_flags "$@"
call GET "/v1/transactions$(build_query)" | emit '.data.results'
```

Functions exported: `call`, `call_multipart`, `confirm`, `emit`, `fmt_table`,
`build_query`, `parse_flags`, `_truthy`, `_urlenc`, `_visibility`. Env knobs:
`MONARCH_GATEWAY` (default `http://localhost:9084`), `RAW` (`1` to bypass
jq/column formatting), `YES` (`1` to auto-confirm prompts).

## Not yet wrapped (use `clients/bash/monarch-api` or curl)

The curated CLI covers the day-to-day surface. These operations are spec-supported and reachable via the generated bash client (`clients/bash/monarch-api`), the MCP server, or plain `curl`, but they don't have an ergonomic curated wrapper yet:

| operationId | Path | What |
|---|---|---|
| `getMe` | `GET /v1/me` | Current user profile (name, email, household id) |
| `getMyHousehold` | `GET /v1/household` | Household details and feature settings |
| `getHouseholdMembers` | `GET /v1/household/members` | List members of the household |
| `getEntitlements` | `GET /v1/entitlements` | Subscription / plus-tier entitlement flags |
| `getCookiePreferences` | `GET /v1/me/cookies` | The user's cookie consent preferences |
| `getNotifications` | `GET /v1/notifications` | In-app notification feed |
| `getNotificationPreferences` | `GET /v1/notifications/preferences` | Combined notification prefs |
| `getMerchantStats` | `GET /v1/merchants/{id}/stats` | Per-merchant aggregate stats |
| `getHoldingTransactions` | `GET /v1/holdings/{id}/transactions` | Buy/sell history for one holding |
| `getSpendingTrends` | `GET /v1/dashboard/spending/trends` | YoY spending trend series |
| `getIncomeVsExpenseYoy` | `GET /v1/reports/income-vs-expense-yoy` | YoY income vs expense |

Use the generated client (same arg style for every operation):

```bash
# Requires bash 4.3+ (brew install bash on macOS)
clients/bash/monarch-api --host http://localhost:9084 getMe
clients/bash/monarch-api --host http://localhost:9084 getMyHousehold
clients/bash/monarch-api --host http://localhost:9084 getMerchantStats id=<merchant-id>
clients/bash/monarch-api --host http://localhost:9084 getHoldingTransactions id=<holding-id>
clients/bash/monarch-api --host http://localhost:9084 getSpendingTrends start=2026-01-01 end=2026-05-27
```

Or plain `curl`:

```bash
curl -s http://localhost:9084/v1/me | jq
curl -s "http://localhost:9084/v1/merchants/<id>/stats" | jq
```

Add ergonomic curated wrappers for these (or others) by editing the dispatch in `cli/monarch`. They are intentionally not auto-generated so the curated surface stays opinionated about what's worth a friendly shorthand.

## Environment

- `MONARCH_GATEWAY` (default `http://localhost:9084`) points at the service.

## Requirements

`curl`, `jq` (both standard on macOS / brew).
