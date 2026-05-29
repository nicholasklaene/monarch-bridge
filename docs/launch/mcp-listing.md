# MCP marketplace listing

## Name

monarch-bridge

## One-line description

A local MCP server that lets AI assistants read your Monarch Money data (accounts, transactions, cashflow, holdings, budgets) using your own session, with nothing leaving your machine.

## Install

```
brew install nicholasklaene/monarch-bridge/monarch-bridge
```

Then authenticate once:

```
monarch bootstrap
```

Point your MCP client at the monarch-bridge MCP server (see the repo README for the exact client config block).

## Example prompts

- "What is my current net worth?"
- "How much did I spend on dining out last month?"
- "List my transactions over $200 in the last 30 days."
- "What is my savings rate this quarter, income vs expenses?"
- "Show me my account balances grouped by type."
- "What positions do I hold in my brokerage account?"

## Requirements

- An active Monarch Money subscription.
- Runs locally; authenticates with your own credentials. Your token and data stay on your machine.
- Not affiliated with or endorsed by Monarch Money.

## Repo

https://github.com/nicholasklaene/monarch-bridge
