# monarch-lib.sh - sourceable helpers shared by the `monarch` CLI.
#
# Source from another bash script to get `call`, `call_multipart`, `confirm`,
# `emit`, `fmt_table`, `build_query`, `parse_flags`, `_truthy`, `_urlenc`,
# `_visibility`, plus the `GATEWAY` env handling.
#
# Bash 3.2 compatible (matches the host CLI). No `set -e` here so callers
# stay in control of their own shell options.
#
# Usage:
#   source /path/to/cli/monarch-lib.sh
#   call GET /v1/accounts | emit '.data.accounts[]'
#
# Env:
#   MONARCH_GATEWAY (default: http://localhost:9084)
#   RAW (default: 0; set to 1 to bypass jq + column formatting in emit/fmt_table)
#   YES (default: unset; set to 1 to auto-confirm prompts in `confirm`)

# Idempotency guard so duplicate sourcing is safe.
if [[ "${_MONARCH_LIB_SOURCED:-}" == "1" ]]; then
  return 0
fi
_MONARCH_LIB_SOURCED=1

# Defaults if the caller has not set them.
: "${GATEWAY:=${MONARCH_GATEWAY:-http://localhost:9084}}"
: "${RAW:=0}"

# call <method> <path> [<json-body>] - emits raw JSON; errors exit 1.
call() {
  local method="$1" path="$2" body_json="${3:-}"
  local resp http body curl_args=("-sS" "-w" "\n%{http_code}" "-X" "$method" "$GATEWAY$path")
  if [[ -n "$body_json" ]]; then
    curl_args+=("-H" "Content-Type: application/json" "-d" "$body_json")
  fi
  resp=$(curl "${curl_args[@]}") || {
    echo "monarch: request failed against $GATEWAY$path" >&2
    exit 1
  }
  http=$(echo "$resp" | tail -n1)
  body=$(echo "$resp" | sed '$d')
  if [[ "$http" -lt 200 || "$http" -ge 300 ]]; then
    echo "monarch: HTTP $http from $GATEWAY$path" >&2
    echo "$body" >&2
    exit 1
  fi
  printf '%s' "$body"
}

# call_multipart <method> <path> <file-field> <file-path> - multipart upload variant.
# Emits raw JSON; errors exit 1. Uses curl -F shorthand.
call_multipart() {
  local method="$1" path="$2" field="$3" file="$4"
  [[ -r "$file" ]] || { echo "monarch: file not readable: $file" >&2; exit 1; }
  local resp http body
  resp=$(curl -sS -w "\n%{http_code}" -X "$method" \
              -F "${field}=@${file}" \
              "$GATEWAY$path") || {
    echo "monarch: request failed against $GATEWAY$path" >&2
    exit 1
  }
  http=$(echo "$resp" | tail -n1)
  body=$(echo "$resp" | sed '$d')
  if [[ "$http" -lt 200 || "$http" -ge 300 ]]; then
    echo "monarch: HTTP $http from $GATEWAY$path" >&2
    echo "$body" >&2
    exit 1
  fi
  printf '%s' "$body"
}

# confirm "<prompt>" - exit 1 unless user types y/Y (or YES env var is set).
confirm() {
  if [[ "${YES:-}" == "1" ]]; then return 0; fi
  local reply
  printf "%s [y/N] " "$1" >&2
  read -r reply
  case "$reply" in
    y|Y|yes|YES) return 0 ;;
    *) echo "aborted" >&2; exit 1 ;;
  esac
}

# emit <jq-filter> - pipes stdin to jq unless RAW=1.
emit() {
  if [[ "$RAW" == "1" ]]; then cat; else jq -r "$@"; fi
}

# fmt_table - pretty-print a TSV stream from stdin as aligned columns,
# but pass through unchanged when --raw is set (so JSON survives intact).
fmt_table() {
  if [[ "$RAW" == "1" ]]; then cat; else column -t -s $'\t'; fi
}

# Build a query string from local START/END/LIMIT/ACCOUNT_ID/TIMEFRAME/ACCOUNT_TYPE/OFFSET/ORDER_BY
# plus the TransactionFilterInput surface (SEARCH, CATEGORY_IDS[], ACCOUNT_IDS[], TAG_IDS[],
# HAS_ATTACHMENTS/HAS_NOTES/HIDE_FROM_REPORTS/IS_SPLIT/IS_RECURRING/IMPORTED_FROM_MINT/
# SYNCED_FROM_INSTITUTION/NEEDS_REVIEW as T|F-decoded booleans, VISIBILITY).
build_query() {
  local q=""
  [[ -n "${START:-}" ]] && q+="&start=$START"
  [[ -n "${END:-}" ]] && q+="&end=$END"
  [[ -n "${LIMIT:-}" ]] && q+="&limit=$LIMIT"
  [[ -n "${OFFSET:-}" ]] && q+="&offset=$OFFSET"
  [[ -n "${ACCOUNT_ID:-}" ]] && q+="&accountId=$ACCOUNT_ID"
  [[ -n "${TIMEFRAME:-}" ]] && q+="&timeframe=$TIMEFRAME"
  [[ -n "${ACCOUNT_TYPE:-}" ]] && q+="&accountType=$ACCOUNT_TYPE"
  [[ -n "${ORDER_BY:-}" ]] && q+="&orderBy=$ORDER_BY"
  [[ -n "${SEARCH:-}" ]] && q+="&search=$(_urlenc "$SEARCH")"
  # Repeatable id flags (bash 3.2 compatible: parallel space-separated strings).
  if [[ -n "${ACCOUNT_IDS:-}" ]]; then
    for id in $ACCOUNT_IDS; do q+="&accountIds=$id"; done
  fi
  if [[ -n "${CATEGORY_IDS:-}" ]]; then
    for id in $CATEGORY_IDS; do q+="&categoryIds=$id"; done
  fi
  if [[ -n "${TAG_IDS:-}" ]]; then
    for id in $TAG_IDS; do q+="&tagIds=$id"; done
  fi
  [[ -n "${HAS_ATTACHMENTS:-}" ]] && q+="&hasAttachments=$HAS_ATTACHMENTS"
  [[ -n "${HAS_NOTES:-}" ]] && q+="&hasNotes=$HAS_NOTES"
  [[ -n "${HIDE_FROM_REPORTS:-}" ]] && q+="&hideFromReports=$HIDE_FROM_REPORTS"
  [[ -n "${IS_SPLIT:-}" ]] && q+="&isSplit=$IS_SPLIT"
  [[ -n "${IS_RECURRING:-}" ]] && q+="&isRecurring=$IS_RECURRING"
  [[ -n "${IMPORTED_FROM_MINT:-}" ]] && q+="&importedFromMint=$IMPORTED_FROM_MINT"
  [[ -n "${SYNCED_FROM_INSTITUTION:-}" ]] && q+="&syncedFromInstitution=$SYNCED_FROM_INSTITUTION"
  [[ -n "${NEEDS_REVIEW:-}" ]] && q+="&needsReview=$NEEDS_REVIEW"
  [[ -n "${VISIBILITY:-}" ]] && q+="&transactionVisibility=$VISIBILITY"
  echo "${q:+?${q:1}}"
}

# Decode a T|F|true|false|yes|no|1|0 flag into the literal 'true' / 'false'
# the proxy's Boolean @RequestParam expects. Empty stays empty (filter omitted).
_truthy() {
  case "$1" in
    t|T|true|TRUE|True|y|Y|yes|YES|1) echo "true" ;;
    f|F|false|FALSE|False|n|N|no|NO|0) echo "false" ;;
    "") echo "" ;;
    *) echo "monarch: expected T|F (got '$1')" >&2; exit 2 ;;
  esac
}

# Minimal URL-encoder for free-text fields (search). Handles spaces + reserved chars.
# Uses python3 (always present on macOS) rather than perl/jq to keep dependencies small.
_urlenc() {
  python3 -c 'import sys, urllib.parse; print(urllib.parse.quote(sys.argv[1], safe=""))' "$1"
}

# Normalize the transactionVisibility enum from CLI shorthand to wire value.
_visibility() {
  case "$1" in
    hidden|hidden_transactions_only) echo "hidden_transactions_only" ;;
    all|all_transactions) echo "all_transactions" ;;
    "") echo "" ;;
    *) echo "monarch: visibility must be 'hidden' or 'all' (got '$1')" >&2; exit 2 ;;
  esac
}

# parse_flags - sets START/END/LIMIT/etc from "$@". Repeatable flags
# (--account, --category, --tag) accumulate space-separated into ACCOUNT_IDS/etc.
parse_flags() {
  START=""; END=""; LIMIT=""; OFFSET=""; ACCOUNT_ID=""; TIMEFRAME=""; ACCOUNT_TYPE=""; ORDER_BY=""
  SEARCH=""; ACCOUNT_IDS=""; CATEGORY_IDS=""; TAG_IDS=""
  HAS_ATTACHMENTS=""; HAS_NOTES=""; HIDE_FROM_REPORTS=""; IS_SPLIT=""; IS_RECURRING=""
  IMPORTED_FROM_MINT=""; SYNCED_FROM_INSTITUTION=""; NEEDS_REVIEW=""; VISIBILITY=""
  while [[ $# -gt 0 ]]; do
    case "$1" in
      --start) START="$2"; shift 2 ;;
      --end) END="$2"; shift 2 ;;
      --limit) LIMIT="$2"; shift 2 ;;
      --offset) OFFSET="$2"; shift 2 ;;
      --account-id) ACCOUNT_ID="$2"; shift 2 ;;
      --timeframe) TIMEFRAME="$2"; shift 2 ;;
      --account-type) ACCOUNT_TYPE="$2"; shift 2 ;;
      --order-by) ORDER_BY="$2"; shift 2 ;;
      --search) SEARCH="$2"; shift 2 ;;
      --account) ACCOUNT_IDS="${ACCOUNT_IDS:+$ACCOUNT_IDS }$2"; shift 2 ;;
      --category) CATEGORY_IDS="${CATEGORY_IDS:+$CATEGORY_IDS }$2"; shift 2 ;;
      --tag) TAG_IDS="${TAG_IDS:+$TAG_IDS }$2"; shift 2 ;;
      --has-attachments) HAS_ATTACHMENTS=$(_truthy "$2"); shift 2 ;;
      --has-notes) HAS_NOTES=$(_truthy "$2"); shift 2 ;;
      --hide-from-reports) HIDE_FROM_REPORTS=$(_truthy "$2"); shift 2 ;;
      --is-split) IS_SPLIT=$(_truthy "$2"); shift 2 ;;
      --is-recurring) IS_RECURRING=$(_truthy "$2"); shift 2 ;;
      --imported-from-mint) IMPORTED_FROM_MINT=$(_truthy "$2"); shift 2 ;;
      --synced-from-institution) SYNCED_FROM_INSTITUTION=$(_truthy "$2"); shift 2 ;;
      --needs-review) NEEDS_REVIEW=$(_truthy "$2"); shift 2 ;;
      --visibility) VISIBILITY=$(_visibility "$2"); shift 2 ;;
      *) echo "monarch: unknown flag: $1" >&2; exit 2 ;;
    esac
  done
}
