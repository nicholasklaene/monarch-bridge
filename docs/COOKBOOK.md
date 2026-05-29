# Cookbook

Copy-pasteable recipes for common monarch-bridge tasks. Each recipe assumes the service
is running locally on `http://localhost:9084` and bootstrap has been completed.

For the full endpoint reference, see [../agents/context/AGENTS.md](../agents/context/AGENTS.md).
For high-level rationale, see [HLD.md](HLD.md).

## Recipe index

- [Auth + health](#auth--health)
- [Daily spend digest](#daily-spend-digest)
- [Tag every Uber charge in a month](#tag-every-uber-charge-in-a-month)
- [Find duplicate transactions](#find-duplicate-transactions)
- [Net worth snapshot CSV](#net-worth-snapshot-csv)
- [Bulk recategorize a merchant](#bulk-recategorize-a-merchant)
- [Backfill balance history from CSV](#backfill-balance-history-from-csv)
- [Receipt upload + attach](#receipt-upload--attach)
- [Rule dry-run before commit](#rule-dry-run-before-commit)
- [Cashflow by category for the last quarter](#cashflow-by-category-for-the-last-quarter)
- [Portfolio allocation roll-up](#portfolio-allocation-roll-up)
- [Weekly recap pipeline into Slack](#weekly-recap-pipeline-into-slack)
- [Detecting a stale session before a long job](#detecting-a-stale-session-before-a-long-job)
- [Force-refresh and wait](#force-refresh-and-wait)

## Auth + health

```bash
curl -s http://localhost:9084/healthz | jq .
# {"status":"UP","authenticated":true,"sessionExpiresAt":"..."}

# Re-read the session JSON from disk without restarting (after re-running bootstrap):
curl -sX POST http://localhost:9084/v1/auth/refresh
```

CLI shorthand:

```bash
monarch health
monarch auth refresh
```

## Daily spend digest

Pull today's transactions for a quick standup-style summary.

```bash
TODAY=$(date +%F)
monarch transactions --start "$TODAY" --end "$TODAY"
```

For a 7-day rolling window with totals:

```bash
START=$(date -v-6d +%F); END=$(date +%F)
monarch transactions --start "$START" --end "$END" --raw \
  | jq '[.data.transactions[] | select(.category.name != "Transfer")]
        | {count: length, total: (map(.amount) | add)}'
```

## Tag every Uber charge in a month

Two-step: search by merchant, then bulk-update.

```bash
# Step 1: find the txn IDs
IDS=$(monarch transactions --start 2026-05-01 --end 2026-05-31 --search "Uber" --raw \
        | jq -r '.data.transactions[].id' | paste -sd, -)

# Step 2: bulk-set tags (replace any existing tag-set)
curl -sX PATCH http://localhost:9084/v1/transactions/bulk \
  -H 'content-type: application/json' \
  -d "{\"ids\": [$IDS], \"tagIds\": [\"<tag-id>\"]}" | jq .
```

To find the tag ID first: `monarch tags`.

## Find duplicate transactions

Server-side dedupe grouping by `(date, amount, plaidName, accountId)`.

```bash
monarch tx duplicates --start 2026-04-01
```

Pipe to `--raw` for programmatic use:

```bash
monarch tx duplicates --start 2026-04-01 --raw \
  | jq '.data.duplicates[] | {date, amount, count: (.txnIds | length)}'
```

## Net worth snapshot CSV

```bash
START=$(date -v-365d +%F)
monarch networth --start "$START" --raw \
  | jq -r '.data.history[] | [.date, .total, .assets, .liabilities] | @csv' \
  > networth-12mo.csv
```

## Bulk recategorize a merchant

Move every Starbucks charge to "Coffee".

```bash
MERCHANT_ID=$(monarch merchants search "Starbucks" --raw | jq -r '.data.merchants[0].id')
CAT_ID=$(monarch categories --raw | jq -r '.data.categories[] | select(.name=="Coffee") | .id')

IDS=$(curl -s "http://localhost:9084/v1/transactions?merchantId=$MERCHANT_ID&limit=500" \
        | jq -r '.data.transactions[].id' | paste -sd, -)

curl -sX PATCH http://localhost:9084/v1/transactions/bulk \
  -H 'content-type: application/json' \
  -d "{\"ids\": [$IDS], \"categoryId\": \"$CAT_ID\"}" | jq .
```

Or, more durable: create a transaction rule so future Starbucks charges auto-categorize.

```bash
# Preview first (dry-run, doesn't persist)
curl -sX POST http://localhost:9084/v1/transaction-rules/preview \
  -H 'content-type: application/json' \
  -d "{\"merchantCriteria\": {\"operator\":\"equals\",\"value\":\"$MERCHANT_ID\"},
       \"setCategoryAction\": \"$CAT_ID\"}" | jq '.data.matchCount'

# Then create the rule for real
curl -sX POST http://localhost:9084/v1/transaction-rules \
  -H 'content-type: application/json' \
  -d "{\"merchantCriteria\": {\"operator\":\"equals\",\"value\":\"$MERCHANT_ID\"},
       \"setCategoryAction\": \"$CAT_ID\"}"
```

## Backfill balance history from CSV

For a manual account where you have historical balances in a spreadsheet.

```bash
ACCT_ID="<manual-account-id>"

# Upload (returns a session key)
SESSION=$(curl -sX POST http://localhost:9084/v1/accounts/$ACCT_ID/balance-history \
            -F "file=@./balances.csv" | jq -r '.data.sessionKey')

# Poll status
while :; do
  STATUS=$(monarch balance-history status "$SESSION" --raw | jq -r '.data.status')
  echo "status=$STATUS"
  [[ "$STATUS" == "completed" || "$STATUS" == "failed" ]] && break
  sleep 5
done
```

CSV format: see [AGENTS.md balance-history upload section](../agents/context/AGENTS.md).

## Receipt upload + attach

Three-step under the hood (Monarch -> Cloudinary -> Monarch link), but the bridge does
all three for you in one call.

```bash
TXN_ID="<txn-id>"
curl -sX POST http://localhost:9084/v1/transactions/$TXN_ID/attachments \
  -F "file=@./receipt.pdf" | jq .
```

Then list a transaction's attachments:

```bash
curl -s http://localhost:9084/v1/transactions/$TXN_ID \
  | jq '.data.attachments[]'
```

Download an individual attachment by ID:

```bash
ATT_ID="<attachment-id>"
curl -s http://localhost:9084/v1/attachments/$ATT_ID \
  | jq -r '.data.originalUrl'  # pre-signed URL; fetch directly with curl
```

## Rule dry-run before commit

Always preview the match count before persisting a rule that touches lots of txns.

```bash
curl -sX POST http://localhost:9084/v1/transaction-rules/preview \
  -H 'content-type: application/json' \
  -d @rule.json | jq '.data | {matchCount, sample: .matchedTransactions[0:5]}'
```

If matchCount is reasonable, POST the same body without `/preview`.

## Cashflow by category for the last quarter

```bash
END=$(date +%F)
START=$(date -v-90d +%F)

monarch cashflow breakdown --start "$START" --end "$END" --raw \
  | jq -r '.data.byCategory[] | [.category.name, .net] | @tsv' \
  | sort -k2 -n
```

For a "where did my money go" summary grouped by category-group:

```bash
monarch cashflow breakdown --start "$START" --end "$END" --raw \
  | jq '.data.byCategoryGroup[] | {group: .group.name, net}'
```

## Portfolio allocation roll-up

```bash
# By classification (security type, etc.)
monarch portfolio allocation

# Per investments account
monarch portfolio allocation by-account

# Per ticker
monarch portfolio allocation by-holdings --limit 50
```

Drill into a single bucket:

```bash
monarch portfolio allocation holdings-detail --classification SECURITY_TYPE --value EQUITY
```

## Weekly recap pipeline into Slack

Monday recap, send to a Slack webhook.

```bash
# start = last Monday, end = yesterday (Sunday)
START=$(date -v-Mon -v-7d +%F); END=$(date -v-Mon -v-1d +%F)

RECAP=$(monarch recap weekly --start "$START" --end "$END" --raw \
          | jq -r '.data.summary')

curl -sX POST "$SLACK_WEBHOOK_URL" \
  -H 'content-type: application/json' \
  -d "{\"text\": $(jq -Rn --arg s "$RECAP" '$s')}"
```

## Detecting a stale session before a long job

```bash
AUTH=$(curl -s http://localhost:9084/v1/auth/status)
OK=$(echo "$AUTH" | jq -r '.authenticated')

if [[ "$OK" != "true" ]]; then
  echo "Session is gone; re-run :app:bootstrapMonarch before continuing." >&2
  exit 1
fi
```

CLI shorthand: `monarch health` (exits non-zero if not authenticated).

## Force-refresh and wait

Trigger Monarch to re-poll Plaid, then block until done.

```bash
monarch refresh --wait --timeout 120
```

Or, for a subset of accounts:

```bash
monarch refresh --account "<id-1>" --account "<id-2>" --wait
```

Under the hood: `POST /v1/refresh` returns a job ID; the `--wait` flag polls
`GET /v1/refresh/status` until every account's `hasSyncInProgress` is false (or the
timeout is hit).
