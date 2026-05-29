# Launch collateral

Draft posts and listings for announcing monarch-bridge. Edit tone and details per channel before posting.

## Contents

- [show-hn.md](show-hn.md) - Show HN post (title + body). Factual, gh-for-GitHub framing, honest about the subscription requirement and private-GraphQL risk.
- [reddit-monarchmoney.md](reddit-monarchmoney.md) - r/MonarchMoney post. Friendlier tone, leads with "I built this for myself", emphasizes data stays local and you stay a paying customer.
- [mcp-listing.md](mcp-listing.md) - Entry for an MCP marketplace/directory: name, one-line description, install command, example prompts, repo link.

## Pre-launch checklist

Run through this before posting any of the above.

- [ ] Set PyPI publish secret (`PYPI_API_TOKEN`) so the Python client publishes on tag.
- [ ] Set NPM publish secret (`NPM_TOKEN`) so the TypeScript client publishes on tag.
- [ ] Create the Homebrew tap repo `homebrew-monarch-bridge` under `nicholasklaene` (must be public, must start with `homebrew-`) and copy `homebrew/Formula/monarch-bridge.rb` into it at `Formula/monarch-bridge.rb`.
- [ ] Tag `v1.0.0` and push the tag to trigger the release + Docker publish workflows.
- [ ] Update the formula `version` + `sha256` in the tap repo to match the published release tarball.
- [ ] Verify the Docker image pulls cleanly: `docker pull ghcr.io/nicholasklaene/monarch-bridge:latest`.
- [ ] Smoke-test the install one-liner end to end: `brew install nicholasklaene/monarch-bridge/monarch-bridge`, then `monarch bootstrap`, then `monarch accounts`.
- [ ] Confirm the repo README links (install, Docker, MCP config) all resolve.
