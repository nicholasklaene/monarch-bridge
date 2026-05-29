#!/usr/bin/env bash
#
# verify-parity.sh - operation-count parity guard for the generated clients.
#
# The OpenAPI spec at openapi/monarch-bridge.yaml is the single source of truth.
# Every generated client under clients/<lang>/ must expose one callable surface
# per operationId in the spec. This script counts operationIds in the spec, counts
# operations in each generated client with a per-language heuristic, prints a table,
# and exits non-zero if any present client is materially below the spec count.
#
# It is a STATIC check: it reads generated source only and never starts the bridge.
#
# Usage:
#   clients/verify-parity.sh            # check every present client
#   TOLERANCE=2 clients/verify-parity.sh  # allow N ops of slack before failing
#
# Exit codes:
#   0  every present client is at parity (within TOLERANCE)
#   1  at least one present client is materially below the spec count
#   2  could not determine the spec op count (spec missing/unreadable)
#
# Requires bash 4.3+ (associative arrays). macOS ships bash 3.2; brew install bash.

set -uo pipefail

# Resolve repo root from this script's location (clients/ -> repo root).
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
CLIENTS_DIR="$SCRIPT_DIR"
SPEC_MAIN="$REPO_ROOT/openapi/monarch-bridge.yaml"
SPEC_PATHS_GLOB="$REPO_ROOT/openapi/paths"

# Ops of slack tolerated before a client is treated as failing. A generator may
# legitimately collapse or rename an op or two; a material gap is the drift signal.
TOLERANCE="${TOLERANCE:-0}"

# ----------------------------------------------------------------------------
# Spec op count: union of operationIds defined inline in monarch-bridge.yaml and
# in the split openapi/paths/*.yaml files the bundled spec $refs. The two sets are
# disjoint by construction (inline vs split-out), so a sorted-unique union is the
# true resolved operation count the generators consume.
# ----------------------------------------------------------------------------
spec_op_count() {
  if [ ! -f "$SPEC_MAIN" ]; then
    echo "0"
    return 1
  fi
  {
    grep -hoE 'operationId:[[:space:]]*[A-Za-z0-9_]+' "$SPEC_MAIN" 2>/dev/null
    if compgen -G "$SPEC_PATHS_GLOB/"'*.yaml' >/dev/null 2>&1; then
      grep -hoE 'operationId:[[:space:]]*[A-Za-z0-9_]+' "$SPEC_PATHS_GLOB"/*.yaml 2>/dev/null
    fi
  } | sed -E 's/.*operationId:[[:space:]]*//' | sort -u | grep -cE '^[A-Za-z0-9_]+$'
}

# ----------------------------------------------------------------------------
# Per-language op counters. Each returns the number of distinct operation surfaces
# the generated client exposes, using a marker that the generator emits exactly
# once per operationId. Returns empty string if the client is not present.
# ----------------------------------------------------------------------------

# python (urllib3): public method per op; the generator also emits
# <op>_with_http_info / <op>_without_preload_content / <op>_serialize helpers.
count_python() {
  local d="$CLIENTS_DIR/python"
  compgen -G "$d/"'*/api/*_api.py' >/dev/null 2>&1 || return 1
  grep -rhoE '^[[:space:]]*def [a-z][a-zA-Z0-9_]*\(' "$d"/*/api/*_api.py 2>/dev/null \
    | sed -E 's/.*def ([a-z][a-zA-Z0-9_]*)\(.*/\1/' \
    | grep -vE '_with_http_info$|_without_preload_content$|_serialize$' \
    | sort -u | grep -c .
}

# typescript-axios: one `public <op>(` per operation on the *Api classes in api.ts.
count_typescript() {
  local f="$CLIENTS_DIR/typescript/api.ts"
  [ -f "$f" ] || return 1
  grep -oE 'public [a-zA-Z0-9_]+\(' "$f" 2>/dev/null \
    | sed -E 's/public ([a-zA-Z0-9_]+)\(/\1/' \
    | sort -u | grep -c .
}

# kotlin (OkHttp): one `fun <op>(` per op; generator also emits <op>WithHttpInfo
# and <op>RequestConfig helpers.
count_kotlin() {
  local d="$CLIENTS_DIR/kotlin"
  compgen -G "$d/"'src/main/kotlin/**/apis/*Api.kt' >/dev/null 2>&1 \
    || compgen -G "$d/"'src/main/kotlin/*/*/*/*/*/apis/*Api.kt' >/dev/null 2>&1 \
    || { find "$d/src/main" -name '*Api.kt' -print -quit 2>/dev/null | grep -q . || return 1; }
  find "$d/src/main" -name '*Api.kt' 2>/dev/null -exec grep -hoE 'fun [a-z][a-zA-Z0-9]*\(' {} + \
    | sed -E 's/fun ([a-z][a-zA-Z0-9]*)\(/\1/' \
    | grep -vE 'WithHttpInfo$|RequestConfig$' \
    | grep -vxE 'encodeURIComponent|toString' \
    | sort -u | grep -c .
}

# bash: one `call_<op>()` shell function per operation.
count_bash() {
  local f="$CLIENTS_DIR/bash/monarch-api"
  [ -f "$f" ] || return 1
  grep -cE '^call_[A-Za-z0-9_]+\(\)' "$f" 2>/dev/null
}

# go: one `func (a *<Tag>APIService) <Op>Execute(` per operation.
count_go() {
  local d="$CLIENTS_DIR/go"
  compgen -G "$d/"'api_*.go' >/dev/null 2>&1 || return 1
  grep -rhoE 'func \(a \*[A-Za-z0-9]+APIService\) [A-Za-z0-9]+Execute\(' "$d"/api_*.go 2>/dev/null \
    | sort -u | grep -c .
}

# ruby: one `def <op>` per operation; generator also emits <op>_with_http_info.
count_ruby() {
  local d="$CLIENTS_DIR/ruby"
  compgen -G "$d/"'lib/*/api/*.rb' >/dev/null 2>&1 || return 1
  grep -rhoE '^[[:space:]]*def [a-z_][a-zA-Z0-9_]*' "$d"/lib/*/api/*.rb 2>/dev/null \
    | sed -E 's/.*def ([a-z_][a-zA-Z0-9_]*).*/\1/' \
    | grep -vE '_with_http_info$' | grep -vxE 'initialize' \
    | sort -u | grep -c .
}

# rust: one `pub async fn <op>(` per operation in src/apis/*_api.rs.
count_rust() {
  local d="$CLIENTS_DIR/rust"
  compgen -G "$d/"'src/apis/*_api.rs' >/dev/null 2>&1 || return 1
  grep -rhoE 'pub async fn [a-z_][a-zA-Z0-9_]*\(' "$d"/src/apis/*_api.rs 2>/dev/null \
    | sed -E 's/pub async fn ([a-z_][a-zA-Z0-9_]*)\(/\1/' \
    | sort -u | grep -c .
}

# csharp (generichost): one `<Op>OrDefaultAsync(` per operation.
count_csharp() {
  local d="$CLIENTS_DIR/csharp"
  local hit
  hit=$(find "$d" -path '*/Api/*Api.cs' ! -name '*Tests.cs' -print -quit 2>/dev/null)
  [ -n "$hit" ] || return 1
  find "$d" -path '*/Api/*Api.cs' ! -name '*Tests.cs' 2>/dev/null \
    -exec grep -hoE '[A-Za-z0-9_]+OrDefaultAsync\(' {} + \
    | sed -E 's/([A-Za-z0-9_]+)OrDefaultAsync\(/\1/' \
    | sort -u | grep -c .
}

# php: one `public function <op>Request(` request-builder per operation.
count_php() {
  local d="$CLIENTS_DIR/php"
  compgen -G "$d/"'lib/Api/*.php' >/dev/null 2>&1 || return 1
  grep -rhoE 'public function [a-zA-Z0-9_]+Request\(' "$d"/lib/Api/*.php 2>/dev/null \
    | sed -E 's/public function ([a-zA-Z0-9_]+)Request\(/\1/' \
    | sort -u | grep -c .
}

# java (okhttp-gson): one `<op>WithHttpInfo(` per operation in the api/*.java files.
count_java() {
  local d="$CLIENTS_DIR/java"
  local hit
  hit=$(find "$d/src/main" -path '*/api/*.java' -print -quit 2>/dev/null)
  [ -n "$hit" ] || return 1
  find "$d/src/main" -path '*/api/*.java' 2>/dev/null \
    -exec grep -hoE '[a-z][A-Za-z0-9]*WithHttpInfo\(' {} + \
    | sed -E 's/([a-z][A-Za-z0-9]*)WithHttpInfo\(/\1/' \
    | sort -u | grep -c .
}

# Ordered list of languages and their counter functions.
LANGS=(python typescript kotlin bash go ruby rust csharp php java)

# ----------------------------------------------------------------------------
main() {
  local spec
  spec="$(spec_op_count)"
  if [ -z "$spec" ] || [ "$spec" -eq 0 ] 2>/dev/null; then
    echo "ERROR: could not determine spec op count from $SPEC_MAIN" >&2
    exit 2
  fi

  printf '%-12s | %10s | %8s | %s\n' "language" "client ops" "spec ops" "status"
  printf '%-12s-+-%10s-+-%8s-+-%s\n' "------------" "----------" "--------" "--------------------"

  local fail=0 present=0
  for lang in "${LANGS[@]}"; do
    local n status
    n="$(count_"$lang" 2>/dev/null)"
    if [ -z "$n" ]; then
      printf '%-12s | %10s | %8s | %s\n' "$lang" "-" "$spec" "absent (not generated)"
      continue
    fi
    present=$((present + 1))
    if [ "$n" -ge "$((spec - TOLERANCE))" ]; then
      status="ok"
    else
      status="DRIFT (-$((spec - n)))"
      fail=1
    fi
    printf '%-12s | %10s | %8s | %s\n' "$lang" "$n" "$spec" "$status"
  done

  echo
  if [ "$present" -eq 0 ]; then
    echo "No generated clients found under $CLIENTS_DIR. Nothing to verify." >&2
    exit 1
  fi
  if [ "$fail" -ne 0 ]; then
    echo "PARITY FAILED: at least one client is materially below the spec ($spec ops)." >&2
    echo "Regenerate the drifting client(s) from openapi/monarch-bridge.yaml (see clients/README.md)." >&2
    exit 1
  fi
  echo "PARITY OK: all $present generated client(s) expose >= $((spec - TOLERANCE)) of $spec spec operations."
}

main "$@"
