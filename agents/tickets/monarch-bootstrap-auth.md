---
title: Run Monarch auth bootstrap + verify endpoints end-to-end
slug: monarch-bootstrap-auth
priority: P0
status: todo
created: 2026-05-09
repo: monarch-proxy
labels: [monarch-proxy, monarch, auth, bootstrap]
---

# Monarch Auth Bootstrap

## Context

The V1 pass-through service (Stages 1–5) compiled and ships with the interactive bootstrap
CLI (`MonarchBootstrapMain.kt`) but the CLI has NOT been run. All data endpoints return 503
until `~/.config/monarch-proxy/.mm-session.json` is written.

The service logs `MONARCH_SESSION missing — bootstrap required` on startup when the file is
absent.

## Goal / acceptance

- `./gradlew :api:bootstrapMonarch` runs interactively (Nick enters email + password + MFA).
- `~/.config/monarch-proxy/.mm-session.json` is written with `token`, `email`, `lastVerifiedAt`.
- `./gradlew :api:bootRun` (or `docker compose up`) starts cleanly.
- `curl http://localhost:9084/healthz` → `{"authenticated":true,...}`.
- `curl http://localhost:9084/v1/accounts | jq '.data.accounts | length'` → matches Monarch
  account count.
- `curl 'http://localhost:9084/v1/transactions?limit=10' | jq '.data.allTransactions.totalCount'` → > 0.

## Approach

```bash
cd ~/Desktop/monarch-proxy
JAVA_HOME=/opt/homebrew/opt/openjdk@21 ./gradlew :api:bootstrapMonarch
# Follow prompts for email / password / MFA
```

If MFA is a TOTP authenticator: have the code ready. If using a TOTP secret seed, pass
`--mfa-secret=<seed>` (see `MonarchBootstrapMain.kt` for the flag).

After bootstrap, trigger session reload without restart:
```bash
curl -X POST http://localhost:9084/v1/auth/refresh
```

## Open questions

- Does `MonarchAuth.kt` login payload shape match the live API? See `// VERIFY-AT-BOOTSTRAP`
  comments — reconcile via `monarch-auth-payload-verify` in the same session.
- Does session expire on a fixed clock or only on API rejection? Log a note in `MonarchSession.kt`.

## Out of scope

- Automated session refresh (session typically lasts months).
- MFA secret rotation.

## Refs

- `api/src/main/kotlin/.../MonarchBootstrapMain.kt` — bootstrap CLI entry point
- `api/src/main/kotlin/.../services/MonarchAuth.kt` — login + MFA (VERIFY-AT-BOOTSTRAP comments)
- `api/src/main/kotlin/.../services/MonarchSessionService.kt` — session load/save
- Ticket: `monarch-auth-payload-verify` — shape reconciliation (do in same session)
