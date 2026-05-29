# :mcp module

Kotlin MCP (Model Context Protocol) server that exposes [monarch-bridge](../)'s REST
surface as AI tools. Drop into Claude Desktop, Cursor, Continue, Cline, or any other MCP
client and your assistant can read accounts, transactions, budgets, etc. straight from
your local Monarch session.

## How it works

Reads `../openapi/monarch-bridge.yaml` at startup and registers one MCP tool per operation
(768 tools total). Tool names come from each spec `operationId`; descriptions come from
the spec's `summary` + `description`; input schemas are derived from the operation's
parameters and request body. Tool invocations forward to the running monarch-bridge HTTP
service on `localhost:9084`. Stdio transport, in-process Kotlin, same toolchain as
`:app`. No extra runtime.

```
Claude Desktop / Cursor / etc.
        │  (stdio JSON-RPC)
        ▼
monarch-bridge-mcp  ─HTTP─▶  monarch-bridge :9084  ─GraphQL─▶  api.monarch.com
```

## Build + install

Requires the parent monarch-bridge to already be running
(`docker compose up -d` from the repo root) and an active Monarch session
(`./gradlew :app:bootstrapMonarch` once, then `POST /v1/auth/refresh`).

```bash
./gradlew :mcp:installDist
```

Produces an executable launcher script at:

```
mcp/build/install/monarch-bridge-mcp/bin/monarch-bridge-mcp
```

The script is self-contained (it bundles every dependency jar under `lib/`). JDK 21 is
required to run it.

## Wire it into Claude Desktop

Edit `~/Library/Application Support/Claude/claude_desktop_config.json` (macOS) or the
equivalent on your OS. Add a `monarch` entry under `mcpServers`:

```json
{
  "mcpServers": {
    "monarch": {
      "command": "/absolute/path/to/monarch-bridge/mcp/build/install/monarch-bridge-mcp/bin/monarch-bridge-mcp"
    }
  }
}
```

Restart Claude Desktop. The 768 monarch tools (`listAccounts`, `getNetworth`,
`createTransaction`, etc.) show up in the tool picker.

## Wire it into Cursor

Cursor reads MCP config from `~/.cursor/mcp.json`:

```json
{
  "mcpServers": {
    "monarch": {
      "command": "/absolute/path/to/monarch-bridge/mcp/build/install/monarch-bridge-mcp/bin/monarch-bridge-mcp"
    }
  }
}
```

Other MCP clients (Continue, Cline, Zed, etc.) follow the same pattern.

## Environment

| Var | Default | Purpose |
|---|---|---|
| `MONARCH_BRIDGE_BASE` | `http://localhost:9084` | Base URL of the running bridge. |
| `MONARCH_BRIDGE_SPEC` | auto-detected from a sibling `openapi/monarch-bridge.yaml` | Path to the OpenAPI spec to derive tools from. |

Set these in the MCP client config's `env` block if the bridge isn't on the default port
or the script is moved away from the repo.

## What you can ask

Tool descriptions come straight from the OpenAPI spec's `summary` + `description`, so
Claude / Cursor / etc. pick the right one for natural-language questions like:

- "What was my biggest spending category last month?"
- "Show me every transaction over $200 since May 1."
- "What's my net worth right now and how has it changed in the last 90 days?"
- "Did Netflix bill me twice this month?"
- "Tag this transaction as `business`."
- "Create a category called `Home Improvement` under the `Bills` group."

The assistant picks the right tool, fills in the JSON args, and you see the raw HTTP
response come back. No data leaves your laptop except the GraphQL calls the bridge itself
makes to `api.monarch.com`.

## Updating after a spec change

Whenever `openapi/monarch-bridge.yaml` changes (e.g. a new endpoint is added to the bridge),
the MCP server picks it up automatically: rebuild (`./gradlew :mcp:installDist`) and
restart your MCP client. No code edits needed; the tool list is derived from the spec at
startup.

## Security notes

- The MCP server runs entirely on your machine and talks only to `localhost:9084`.
- The monarch-bridge session token is held by the bridge, never read or transmitted by this
  MCP server.
- MCP clients (Claude Desktop, Cursor, etc.) prompt for user confirmation before
  executing tools by default; for destructive operations (`deleteTransaction`,
  `deleteAccount`, etc.) leave confirmations on.
- See [../SECURITY.md](../SECURITY.md) for the bridge's broader threat model.
