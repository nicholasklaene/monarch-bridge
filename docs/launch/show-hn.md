# Show HN post

## Title

Show HN: monarch-bridge - programmatic API + MCP server for your Monarch Money subscription

## Body

Monarch Money is a personal finance app with a polished web UI but no official public API. If you pay for it, your data is locked behind their dashboard. monarch-bridge unlocks it for your own use.

It runs locally and talks to Monarch's own GraphQL backend using your session token, the same way the web app does. Nothing is proxied through a third party. Your token and your financial data never leave your machine. You stay a paying Monarch customer; this is just a different door into the data you already own.

What you get:

- A local HTTP API covering the full non-UI Monarch operation surface: accounts, balances, transactions, cashflow, holdings, budgets, and more.
- An MCP server, so AI assistants like Claude can answer questions about your finances directly.
- Generated, typed clients for Python, TypeScript, and Kotlin, plus a bash CLI.

Think of it as gh-for-GitHub, but for Monarch: a clean local interface over an API that was never meant to be public.

Honest caveats: it requires an active Monarch subscription, you authenticate with your own credentials (email, password, MFA), and because it rides Monarch's private GraphQL, they could change it. It is not affiliated with or endorsed by Monarch.

Repo, install instructions, and a Docker image are in the README. Feedback welcome.
