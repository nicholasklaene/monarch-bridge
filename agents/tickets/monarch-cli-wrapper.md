---
title: Thin CLI wrapper over monarch-proxy HTTP service
slug: monarch-cli-wrapper
priority: P2
status: todo
created: 2026-05-09
repo: monarch-proxy
labels: [monarch-proxy, monarch, cli]
---

# Monarch CLI Wrapper

## Context

monarch-proxy exposes Monarch data via HTTP. Quick manual inspection currently requires
curl commands with flags. A thin CLI wrapper would simplify day-to-day use from the terminal.

## Goal / acceptance

- `monarch accounts` — prints linked accounts + balances (formatted table).
- `monarch transactions --start 2026-05-01 --end 2026-05-31` — prints recent transactions.
- `monarch cashflow --start 2026-05-01 --end 2026-05-31` — prints income/expense/savings.
- `monarch refresh` — triggers Monarch to re-poll Plaid.
- Works when monarch-proxy is running on localhost:9084.

## Approach (sketch)

Shell script or small Python script using `curl` + `jq` (or `httpx` + `rich` for formatted
output). Installed to `~/bin/monarch` or via the KRE skills profile. No compilation needed.

```bash
#!/usr/bin/env bash
# monarch — thin CLI over monarch-proxy HTTP
GATEWAY=${MONARCH_GATEWAY:-http://localhost:9084}
case "$1" in
  accounts)  curl -sf "$GATEWAY/v1/accounts" | jq '.data.accounts[] | {name, balance, institution}' ;;
  # ...
esac
```

## Blocks on

- `monarch-bootstrap-auth` (need live service)

## Out of scope

- Replacing the HTTP service or bootstrap CLI.
- Interactive TUI.
