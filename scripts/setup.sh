#!/usr/bin/env bash
# scripts/setup.sh: one-command first-run setup for monarch-bridge.
#
# Validates prereqs, builds the app, walks through Monarch auth interactively,
# starts Docker, runs health + auth checks, and prints next steps.
#
# Usage:  ./scripts/setup.sh
#
# Inspired by Datadog PUP-style guided installers.

set -euo pipefail

# -------------------- colors --------------------
if [ -t 1 ] && command -v tput >/dev/null 2>&1; then
  RED=$(tput setaf 1); GREEN=$(tput setaf 2); YELLOW=$(tput setaf 3)
  BLUE=$(tput setaf 4); BOLD=$(tput bold); DIM=$(tput dim); NC=$(tput sgr0)
else
  RED=""; GREEN=""; YELLOW=""; BLUE=""; BOLD=""; DIM=""; NC=""
fi

# -------------------- output helpers --------------------
banner() {
  cat <<BANNER
${BOLD}
╔════════════════════════════════════════════════════╗
║         monarch-bridge setup wizard                ║
║   Local bridge from Monarch Money to your tools    ║
╚════════════════════════════════════════════════════╝
${NC}
BANNER
}

step_num=0
step() {
  step_num=$((step_num + 1))
  printf "\n${BLUE}[%02d/%02d]${NC} ${BOLD}%s${NC}\n" "$step_num" "$TOTAL_STEPS" "$1"
}

ok()    { printf "  ${GREEN}✓${NC} %s\n" "$1"; }
info()  { printf "  ${DIM}%s${NC}\n" "$1"; }
warn()  { printf "  ${YELLOW}!${NC} %s\n" "$1"; }
die()   { printf "  ${RED}✗${NC} %s\n" "$1" >&2; exit 1; }

# -------------------- prereqs --------------------
TOTAL_STEPS=5
REPO_ROOT=$(cd "$(dirname "$0")/.." && pwd)
cd "$REPO_ROOT"

banner
info "Repo: $REPO_ROOT"

step "Checking prerequisites"
command -v docker >/dev/null 2>&1 || die "docker not found. Install: https://docs.docker.com/get-docker/"
ok "docker"
docker info >/dev/null 2>&1 || die "docker daemon not running. Start Docker Desktop, then re-run."
ok "docker daemon running"
command -v jq >/dev/null 2>&1 || die "jq not found. Install: brew install jq (mac) or apt install jq (linux)"
ok "jq"
command -v curl >/dev/null 2>&1 || die "curl not found"
ok "curl"

# JDK 21 only needed for the interactive bootstrap (not for docker-run).
JAVA_HOME_USED="${JAVA_HOME:-}"
if [ -z "$JAVA_HOME_USED" ] && [ -x /usr/libexec/java_home ]; then
  if /usr/libexec/java_home -v 21 >/dev/null 2>&1; then
    JAVA_HOME_USED=$(/usr/libexec/java_home -v 21)
  fi
fi
[ -z "$JAVA_HOME_USED" ] && die "JDK 21 not found. macOS: brew install openjdk@21; Linux: install openjdk-21-jdk, then set JAVA_HOME."
ok "JDK 21 at $JAVA_HOME_USED"

# -------------------- auth bootstrap --------------------
step "Authenticating with Monarch"
SESSION_PATH="${HOME}/.config/monarch-bridge/.mm-session.json"
if [ -f "$SESSION_PATH" ]; then
  warn "Existing session at $SESSION_PATH"
  read -r -p "  Re-authenticate? [y/N] " reply
  if [[ "$reply" =~ ^[Yy]$ ]]; then
    info "Running interactive bootstrap (prompts: email / password / MFA)..."
    JAVA_HOME="$JAVA_HOME_USED" ./gradlew :app:bootstrapMonarch --console=plain
  else
    ok "Keeping existing session"
  fi
else
  info "No session yet; running interactive bootstrap (prompts: email / password / MFA)..."
  JAVA_HOME="$JAVA_HOME_USED" ./gradlew :app:bootstrapMonarch --console=plain
fi
[ -f "$SESSION_PATH" ] || die "Bootstrap finished but session file is missing; check output above."
ok "Session at $SESSION_PATH"

# -------------------- docker --------------------
step "Starting docker container"
docker compose up -d --build --quiet-pull >/dev/null
ok "Container starting"

# Wait for health endpoint to come up (service starts in ~5-10s).
attempts=0
until curl -sf http://localhost:9084/healthz >/dev/null 2>&1; do
  attempts=$((attempts + 1))
  [ "$attempts" -gt 30 ] && die "Service did not become healthy in 30s; check 'docker compose logs monarch-bridge'"
  sleep 1
done
ok "Service healthy on http://localhost:9084"

# -------------------- verify --------------------
step "Verifying authentication"
status_json=$(curl -sS http://localhost:9084/v1/auth/status)
authed=$(echo "$status_json" | jq -r '.authenticated')
if [ "$authed" != "true" ]; then
  die "Auth check failed; /v1/auth/status returned: $status_json"
fi
account_count=$(curl -sS http://localhost:9084/v1/accounts | jq '.data.accounts | length')
ok "Authenticated as $(echo "$status_json" | jq -r .email)"
ok "Reading $account_count account(s) from Monarch"

# -------------------- next steps --------------------
step "Done"
cat <<NEXT

${BOLD}${GREEN}Setup complete!${NC}

Next steps:

  ${BOLD}1. Install the CLI to your PATH${NC}
     ${YELLOW}ln -sf "$(pwd)/cli/monarch" ~/bin/monarch${NC}

  ${BOLD}2. Try it${NC}
     ${YELLOW}monarch help${NC}        full subcommand reference
     ${YELLOW}monarch health${NC}      service + auth status
     ${YELLOW}monarch accounts${NC}    your accounts
     ${YELLOW}monarch cashflow --start $(date -v-30d +%Y-%m-%d 2>/dev/null || date -d "-30 days" +%Y-%m-%d) --end $(date +%Y-%m-%d)${NC}

  ${BOLD}3. Explore the API${NC}
     ${YELLOW}open http://localhost:9084/docs${NC}    interactive Swagger UI
     ${YELLOW}curl http://localhost:9084/v3/api-docs.yaml${NC}   OpenAPI 3.1 spec

  ${BOLD}4. Generate a client (any language)${NC}
     ${YELLOW}npx @openapitools/openapi-generator-cli generate -i openapi/monarch-bridge.yaml -g kotlin -o clients/kotlin${NC}
     ${DIM}(swap 'kotlin' for python, typescript, go, rust, etc.)${NC}

  ${BOLD}5. Service controls${NC}
     ${YELLOW}docker compose logs -f monarch-bridge${NC}    tail logs
     ${YELLOW}docker compose restart${NC}                   restart after rebuild
     ${YELLOW}docker compose down${NC}                      stop the service

Reference: ${BOLD}agents/context/AGENTS.md${NC} (every endpoint, every quirk, every error code).
NEXT
