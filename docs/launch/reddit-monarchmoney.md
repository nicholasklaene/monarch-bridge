# r/MonarchMoney post

## Title

I built a local tool so I can query my Monarch data from Claude, scripts, or the terminal

## Body

Hey all. I love Monarch but I kept wishing I could pull my own numbers out of it without clicking through the dashboard, so I built a little tool for myself and figured some of you might want it too.

It runs entirely on your own machine. It logs in with your Monarch credentials (email, password, and MFA) and then talks to the same GraphQL backend the Monarch web app uses. Your session token and your financial data stay local. Nothing gets sent to me or any third party. You keep paying Monarch like normal; this just gives you another way to get at the data you already have.

What can it do:

- Pull accounts, balances, transactions, cashflow, holdings, budgets, and the rest of the non-UI Monarch operation surface over a small local HTTP API.
- Plug into AI assistants through an MCP server, so I can literally ask Claude "what did I spend on groceries last month" and it reads straight from Monarch.

Install (Homebrew):

```
brew install nicholasklaene/monarch-bridge/monarch-bridge
```

Then run `monarch bootstrap` once to log in, and you are off.

Fair warning: it needs an active Monarch subscription, and since it rides their private GraphQL it could break if they change things. I am not affiliated with Monarch in any way, just a happy customer who wanted programmatic access. Happy to answer questions.
