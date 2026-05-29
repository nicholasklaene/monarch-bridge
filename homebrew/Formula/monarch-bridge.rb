# Homebrew formula for monarch-bridge.
#
# Installs:
#   - the bash `monarch` CLI to bin/monarch
#   - a launchd plist that pulls + runs the docker image on boot, bound to :9084
#
# Runtime deps: docker (Cask), jq, curl.
#
# ----------------------------------------------------------------------------
# How to publish this formula to a Homebrew tap (one-time owner setup)
# ----------------------------------------------------------------------------
# 1. Create a NEW PUBLIC repo on GitHub named exactly:
#      homebrew-monarch-bridge
#    under the github user `nicholasklaene` (must start with `homebrew-` so the
#    `brew tap` command auto-discovers it).
#
# 2. Copy THIS file to that repo at:
#      Formula/monarch-bridge.rb
#
# 3. Commit + push. End users then install with:
#      brew install nicholasklaene/monarch-bridge/monarch-bridge
#    (the `nicholasklaene/monarch-bridge` segment is the tap; brew expands it
#    to `https://github.com/nicholasklaene/homebrew-monarch-bridge`.)
#
# 4. On every release, bump the `version` + `sha256` below to match the
#    GitHub Release tarball (publish-release.yml workflow produces the
#    `monarch-bridge-<version>.tar.gz` asset + a `.sha256` file). Update those
#    two lines in the tap repo and push.
# ----------------------------------------------------------------------------

class MonarchBridge < Formula
  desc "Local HTTP bridge to your Monarch Money data (CLI + AI + scripts)"
  homepage "https://github.com/nicholasklaene/monarch-bridge"
  url "https://github.com/nicholasklaene/monarch-bridge/releases/download/v1.0.0/monarch-bridge-1.0.0.tar.gz"
  version "1.0.0"
  # Replace with the actual sha256 of the release tarball at publish time;
  # the publish-release.yml workflow ships a <tarball>.sha256 sidecar.
  sha256 "0000000000000000000000000000000000000000000000000000000000000000"
  license "MIT"

  depends_on "curl"
  depends_on "jq"
  # docker is shipped via Homebrew Cask, not core, so it can't be a strict
  # `depends_on` here. Surface the requirement loudly in caveats instead.

  def install
    # The release tarball contains cli/monarch + clients/bash/* + install.sh.
    bin.install "cli/monarch"
    # The CLI sources monarch-lib.sh from its own dir at startup, so it must land
    # in the same bin dir or the installed `monarch` dies on first invocation.
    bin.install "cli/monarch-lib.sh"

    # Drop the bash client tree (if present in the tarball) into share/, so
    # users can source it from scripts without polluting bin/.
    if Dir.exist?("clients/bash")
      (share/"monarch-bridge").install "clients/bash"
    end
  end

  def post_install
    # Pull the docker image so the first `brew services start monarch-bridge`
    # boots fast. Best-effort: skip silently if docker isn't installed yet, so
    # `brew install` itself doesn't fail.
    if which("docker") && system("docker", "info", out: File::NULL, err: File::NULL)
      system "docker", "pull", "ghcr.io/nicholasklaene/monarch-bridge:latest"
    else
      opoo "docker not available; skipping image pull. Install Docker Desktop, then: docker pull ghcr.io/nicholasklaene/monarch-bridge:latest"
    end

    # Make sure the host session dir exists so the docker bind-mount has a
    # target. The bridge tolerates the JSON file being absent (returns 503).
    session_dir = "#{Dir.home}/.config/monarch-bridge"
    FileUtils.mkdir_p(session_dir)
  end

  service do
    # `brew services start monarch-bridge` writes a launchd plist that runs
    # this docker command on login.
    docker_path = which("docker") || "/usr/local/bin/docker"
    run [
      docker_path.to_s,
      "run",
      "--rm",
      "--name", "monarch-bridge",
      "-p", "127.0.0.1:9084:9084",
      "-e", "API_BIND=0.0.0.0",
      "-e", "MONARCH_SESSION_PATH=/var/monarch-bridge/session/.mm-session.json",
      "-v", "#{Dir.home}/.config/monarch-bridge:/var/monarch-bridge/session",
      "ghcr.io/nicholasklaene/monarch-bridge:latest",
    ]
    keep_alive true
    log_path var/"log/monarch-bridge.log"
    error_log_path var/"log/monarch-bridge.err.log"
  end

  def caveats
    <<~EOS
      monarch-bridge wraps the docker image; you need Docker Desktop installed:
        brew install --cask docker

      Start the bridge in the background (launchd):
        brew services start monarch-bridge

      One-time auth (interactive prompts for email / password / MFA):
        monarch bootstrap

      Verify:
        curl http://localhost:9084/healthz
        monarch accounts

      Swagger UI:
        open http://localhost:9084/docs

      Session JSON lives at ~/.config/monarch-bridge/.mm-session.json
      (bind-mounted into the container).
    EOS
  end

  test do
    # Smoke test: the CLI prints its help banner without contacting the network.
    # `monarch help` exits 0, so don't pass an expected non-zero status to
    # shell_output (the default expected exit code is 0).
    assert_match "monarch", shell_output("#{bin}/monarch help 2>&1").downcase
  end
end
