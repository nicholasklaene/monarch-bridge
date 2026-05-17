---
title: Verify Monarch auth payload shape at first bootstrap
slug: monarch-auth-payload-verify
priority: P1
status: todo
created: 2026-05-09
repo: monarch-proxy
labels: [monarch-proxy, monarch, auth, verification]
---

# Monarch Auth Payload Verify

## Context

`MonarchAuth.kt` was written against the README contract and community reverse-engineering of
Monarch's login flow. Every payload-shape assumption is marked `// VERIFY-AT-BOOTSTRAP`.
The login form fields, MFA challenge response shape, and session token extraction path
were all inferred — NOT confirmed against a live response.

This ticket is companion to `monarch-bootstrap-auth` and should be done in the same session.

## Goal / acceptance

- Capture the raw HTTP response from Monarch's login endpoint during bootstrap (add a
  temporary `println` or use logging at DEBUG level).
- Reconcile every `// VERIFY-AT-BOOTSTRAP` comment in `MonarchAuth.kt` against the real
  payload. Update field names / paths as needed.
- Remove `// VERIFY-AT-BOOTSTRAP` markers from confirmed-correct lines; replace unresolved
  ones with a brief inline note explaining what was actually observed.
- Commit the reconciled `MonarchAuth.kt`.
- If shape differs materially: update `MonarchAuthTest.kt` WireMock stubs to match.

## Approach

Run bootstrap with DEBUG logging enabled:
```bash
JAVA_HOME=/opt/homebrew/opt/openjdk@21 \
  LOGGING_LEVEL_COM_KLAENEREALESTATE_ACCOUNTGATEWAY=DEBUG \
  ./gradlew :api:bootstrapMonarch
```

Capture the JSON response body and compare against `MonarchAuth.kt` assumptions.

## Out of scope

- Persistent debug logging in production builds.
- Changing the auth flow architecture.

## Refs

- `api/src/main/kotlin/.../services/MonarchAuth.kt` — VERIFY-AT-BOOTSTRAP markers
- `api/src/test/kotlin/.../services/MonarchAuthTest.kt` — WireMock stubs to update if shape differs
- Blocks: `monarch-fixture-capture`
