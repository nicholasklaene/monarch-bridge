---
title: Expose monarch-proxy endpoints as MCP tools
slug: monarch-mcp-wrapper
priority: P2
status: todo
created: 2026-05-09
repo: monarch-proxy
labels: [monarch-proxy, monarch, mcp, ai-access]
---

# Monarch MCP Wrapper

## Context

monarch-proxy exposes 8 REST endpoints over Monarch data. Claude agents currently access
these via `curl` (Bash tool) or by reading the HTTP response directly. Wrapping the endpoints
as MCP tools would give Claude structured, schema-validated access without shell round-trips.

Two viable approaches:

**Option A — Community MCP server:** Install `bradleyseanf/monarchmoneycommunity` or an
equivalent Monarch MCP server alongside monarch-proxy. Simpler, lower maintenance.

**Option B — Custom shim:** Small Python or Kotlin shim that re-exposes the monarch-proxy
HTTP endpoints as MCP tools. Adds schema validation and KRE-specific descriptions.

## Goal / acceptance (TBD at design time)

- Claude can call `get_accounts`, `get_transactions`, `get_cashflow`, etc. as MCP tools
  without using the Bash tool.
- MCP server runs alongside monarch-proxy (separate process or embedded).
- Tool descriptions are KRE-specific (not generic Monarch descriptions).

## Approach (sketch)

Evaluate community MCP options first. If none fit, build a small Python shim:
```python
# Thin MCP wrapper using the Python MCP SDK
# Calls localhost:9084 endpoints and returns structured results
```

## Blocks on

- `monarch-bootstrap-auth` (need live service)

## Out of scope

- Replacing the HTTP service with MCP-only access (keep HTTP for BFFE callers).
