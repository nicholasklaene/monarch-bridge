# Security

## What this service holds

A single **Monarch Money session token**, written by the interactive bootstrap CLI to:

```
~/.config/monarch-bridge/.mm-session.json
```

Permissions: the parent directory is created `0700`, the file itself `0600` (owner read/write only).
The token grants full read + write access to your Monarch account. Treat it like a password.

The service does **not** store any other personal data on disk. Account balances, transactions,
budgets, etc. are streamed from Monarch on every request.

## Defaults: localhost-only

The bridge binds to `127.0.0.1` by default (`server.address` in `application.yaml`). It has
**no per-request authentication**, so anything that can reach `localhost:9084` can read every
account and make every supported mutation. This is fine for personal single-user use on a
local machine; it is **not safe** to bind to a public interface without a reverse proxy
that handles auth.

To expose beyond localhost (only behind your own auth layer like Tailscale, Cloudflare Access,
an mTLS terminator, or HTTP Basic at the proxy):

```bash
API_BIND=0.0.0.0 docker compose up -d
```

## Swagger UI

`/docs` (and `/v3/api-docs`, `/v3/api-docs.yaml`) are open by default. Anyone who can reach
the bridge can browse the spec. The interactive "Try it out" button is **disabled** by default
(`springdoc.swagger-ui.try-it-out-enabled: false`) so the UI can't drive live writes against
your Monarch data.

## Bootstrap password handling

`./gradlew :app:bootstrapMonarch` reads your Monarch password via `Console.readPassword()`
(no terminal echo). When run from a non-TTY context (IntelliJ run config, CI), the password
will be echoed and may end up in the shell scrollback or IDE console history. **Prefer a
proper terminal for first-run bootstrap.**

After bootstrap, the password is discarded; only the returned session token persists.

## Reporting a vulnerability

If you find a security issue, please open a private security advisory on GitHub:
<https://github.com/nicholasklaene/monarch-bridge/security/advisories/new>

Please do **not** open a public issue for vulnerabilities. Response time is best-effort
(personal-project maintainer).

## Threat model: what this does NOT protect against

- A malicious local user on the same machine. The session JSON is `0600` but root and your
  own processes can read it. Don't run this on a shared workstation.
- A compromised Monarch Money account. The bridge only mirrors what you can already do via
  the Monarch web app; if your credentials are compromised, the bridge is downstream of that.
- A man-in-the-middle on `api.monarch.com`. TLS verification uses the JDK default trust
  store; if your machine trusts a malicious CA, the bridge can't see that.
- Out-of-date dependencies. Check `gradle/libs.versions.toml` periodically; CI does not yet
  run a dependency-vulnerability scan.

## Monarch Money's terms of service

You are responsible for ensuring your use of this bridge complies with
[Monarch Money's Terms of Service](https://www.monarchmoney.com/terms-of-service).
The bridge talks to Monarch's GraphQL endpoint the same way the official web app does;
it does not bypass rate limits or scrape pages.
