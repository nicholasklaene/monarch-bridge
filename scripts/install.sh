#!/usr/bin/env bash
# scripts/install.sh: one-command install for end users (no repo clone needed).
#
# What it does:
#   1. Verify prereqs (curl, docker).
#   2. Pull the latest ghcr.io/nicholasklaene/monarch-bridge image.
#   3. Start the bridge on :9084 via docker run (idempotent: replaces existing
#      container of the same name).
#   4. Drop the bash CLI into PREFIX (default /usr/local/bin).
#   5. Print a clean "next steps" panel with the docker-exec bootstrap command.
#
# Intended one-liner:
#   curl -fsSL https://raw.githubusercontent.com/nicholasklaene/monarch-bridge/main/scripts/install.sh | bash
#
# Environment overrides:
#   PREFIX               Install dir for the CLI (default /usr/local/bin)
#   IMAGE                Container image (default ghcr.io/nicholasklaene/monarch-bridge:latest)
#   CONTAINER_NAME       Docker container name (default monarch-bridge)
#   SESSION_DIR          Host dir for the session JSON (default ~/.config/monarch-bridge)
#   PORT                 Host port (default 9084)
#   CLI_BRANCH           Branch to pull cli/monarch from (default main)
#   SKIP_CLI=1           Skip installing the CLI symlink
#   SKIP_DOCKER=1        Skip docker pull / run (CLI only)
#
# Idempotent. Exits 0 on rerun. Separate from scripts/setup.sh, which is for
# contributors who cloned the repo (gradle build, interactive bootstrap, etc).

set -euo pipefail

# -------------------- colors --------------------
if [ -t 1 ] && command -v tput >/dev/null 2>&1; then
  RED=$(tput setaf 1); GREEN=$(tput setaf 2); YELLOW=$(tput setaf 3)
  BLUE=$(tput setaf 4); BOLD=$(tput bold); DIM=$(tput dim); NC=$(tput sgr0)
else
  RED=""; GREEN=""; YELLOW=""; BLUE=""; BOLD=""; DIM=""; NC=""
fi

banner() {
  cat <<BANNER
${BOLD}
+----------------------------------------------------+
|         monarch-bridge installer (curl|bash)       |
|   Local Monarch Money bridge for AI + CLI + HTTP   |
+----------------------------------------------------+
${NC}
BANNER
}

step_num=0
TOTAL_STEPS=4
step()  { step_num=$((step_num + 1)); printf "\n${BLUE}[%d/%d]${NC} ${BOLD}%s${NC}\n" "$step_num" "$TOTAL_STEPS" "$1"; }
ok()    { printf "  ${GREEN}+${NC} %s\n" "$1"; }
info()  { printf "  ${DIM}%s${NC}\n" "$1"; }
warn()  { printf "  ${YELLOW}!${NC} %s\n" "$1"; }
die()   { printf "  ${RED}x${NC} %s\n" "$1" >&2; exit 1; }

# -------------------- config --------------------
PREFIX="${PREFIX:-/usr/local/bin}"
IMAGE="${IMAGE:-ghcr.io/nicholasklaene/monarch-bridge:latest}"
CONTAINER_NAME="${CONTAINER_NAME:-monarch-bridge}"
SESSION_DIR="${SESSION_DIR:-${HOME}/.config/monarch-bridge}"
PORT="${PORT:-9084}"
CLI_BRANCH="${CLI_BRANCH:-main}"
CLI_URL="https://raw.githubusercontent.com/nicholasklaene/monarch-bridge/${CLI_BRANCH}/cli/monarch"

banner
info "Image:       ${IMAGE}"
info "Container:   ${CONTAINER_NAME}"
info "Port:        ${PORT}"
info "Session dir: ${SESSION_DIR}"
info "CLI prefix:  ${PREFIX}"

# -------------------- prereqs --------------------
step "Checking prerequisites"
command -v curl >/dev/null 2>&1 || die "curl not found"
ok "curl"

if [ "${SKIP_DOCKER:-0}" != "1" ]; then
  command -v docker >/dev/null 2>&1 || die "docker not found. Install: https://docs.docker.com/get-docker/"
  ok "docker"
  docker info >/dev/null 2>&1 || die "docker daemon not running. Start Docker Desktop / dockerd, then re-run."
  ok "docker daemon"
else
  warn "SKIP_DOCKER=1; not checking docker"
fi

# -------------------- docker --------------------
if [ "${SKIP_DOCKER:-0}" != "1" ]; then
  step "Pulling image + starting container"
  mkdir -p "${SESSION_DIR}"
  ok "Session dir ready: ${SESSION_DIR}"

  if ! docker pull "${IMAGE}" >/dev/null 2>&1; then
    die "Failed to pull ${IMAGE}. If this image hasn't been published yet, build locally with 'docker build -t monarch-bridge .' and re-run with IMAGE=monarch-bridge."
  fi
  ok "Pulled ${IMAGE}"

  # Idempotent: if a container of the same name exists, replace it.
  if docker ps -a --format '{{.Names}}' | grep -Fxq "${CONTAINER_NAME}"; then
    info "Existing container '${CONTAINER_NAME}' found; replacing"
    docker rm -f "${CONTAINER_NAME}" >/dev/null
  fi

  docker run -d \
    --name "${CONTAINER_NAME}" \
    --restart unless-stopped \
    -p "127.0.0.1:${PORT}:9084" \
    -e API_BIND=0.0.0.0 \
    -e MONARCH_SESSION_PATH=/var/monarch-bridge/session/.mm-session.json \
    -v "${SESSION_DIR}:/var/monarch-bridge/session" \
    "${IMAGE}" >/dev/null
  ok "Container '${CONTAINER_NAME}' started"

  # Wait for the health endpoint to respond. The service comes up in ~5-10s
  # after the image is warm, longer on a cold first boot.
  attempts=0
  until curl -fsS "http://localhost:${PORT}/healthz" >/dev/null 2>&1; do
    attempts=$((attempts + 1))
    [ "$attempts" -gt 30 ] && die "Service did not become healthy in 30s; check 'docker logs ${CONTAINER_NAME}'"
    sleep 1
  done
  ok "Service healthy on http://localhost:${PORT}"
else
  step "Skipping docker (SKIP_DOCKER=1)"
  warn "Bridge service NOT started; you'll need to run it yourself."
fi

# -------------------- CLI --------------------
step "Installing the monarch CLI"
if [ "${SKIP_CLI:-0}" = "1" ]; then
  warn "SKIP_CLI=1; not installing CLI"
else
  # Pick a sudo wrapper only if PREFIX isn't writable by the current user.
  SUDO=""
  if [ ! -w "${PREFIX}" ] && [ ! -w "$(dirname "${PREFIX}")" ]; then
    if command -v sudo >/dev/null 2>&1; then
      SUDO="sudo"
      info "Using sudo to install to ${PREFIX}"
    else
      die "PREFIX (${PREFIX}) is not writable and sudo is unavailable. Re-run with PREFIX=\$HOME/.local/bin."
    fi
  fi

  tmp=$(mktemp -t monarch.XXXXXX)
  trap 'rm -f "${tmp}"' EXIT
  if ! curl -fsSL "${CLI_URL}" -o "${tmp}"; then
    die "Failed to download CLI from ${CLI_URL}"
  fi
  $SUDO install -m 0755 "${tmp}" "${PREFIX}/monarch"
  rm -f "${tmp}"
  trap - EXIT
  ok "Installed ${PREFIX}/monarch"

  # The CLI sources monarch-lib.sh from its own directory; ship it alongside.
  libtmp=$(mktemp -t monarch-lib.XXXXXX)
  if curl -fsSL "${CLI_URL%/monarch}/monarch-lib.sh" -o "${libtmp}"; then
    $SUDO install -m 0644 "${libtmp}" "${PREFIX}/monarch-lib.sh"
    rm -f "${libtmp}"
    ok "Installed ${PREFIX}/monarch-lib.sh"
  else
    warn "Could not fetch monarch-lib.sh; the CLI will not run without it"
  fi

  # Sanity check: the CLI on PATH should exit cleanly when run with no args.
  if command -v monarch >/dev/null 2>&1; then
    ok "'monarch' is on PATH"
  else
    warn "'monarch' is not on PATH; add ${PREFIX} to PATH"
  fi
fi

# -------------------- next steps --------------------
step_num=$((step_num + 1))
printf "\n${BOLD}${GREEN}Install complete.${NC}\n"

cat <<NEXT

${BOLD}One-time auth (do this once)${NC}
  The bridge needs your Monarch session token. Run the bootstrap inside the
  container; it prompts for email / password / MFA, then writes the session
  JSON into ${SESSION_DIR}.

  ${YELLOW}docker exec -it ${CONTAINER_NAME} sh -c 'java -jar /app/app.jar --bootstrap-monarch'${NC}

  Or, if you cloned the repo and have JDK 21 installed:
  ${YELLOW}./gradlew :app:bootstrapMonarch${NC}

${BOLD}Verify${NC}
  ${YELLOW}curl http://localhost:${PORT}/healthz${NC}
  ${YELLOW}curl http://localhost:${PORT}/v1/auth/status${NC}
  ${YELLOW}monarch accounts${NC}

${BOLD}Service controls${NC}
  ${YELLOW}docker logs -f ${CONTAINER_NAME}${NC}   tail logs
  ${YELLOW}docker restart ${CONTAINER_NAME}${NC}   restart
  ${YELLOW}docker stop ${CONTAINER_NAME}${NC}      stop
  ${YELLOW}docker start ${CONTAINER_NAME}${NC}     start

${BOLD}Docs${NC}
  Swagger UI:  ${YELLOW}http://localhost:${PORT}/docs${NC}
  Full README: ${YELLOW}https://github.com/nicholasklaene/monarch-bridge${NC}

NEXT
