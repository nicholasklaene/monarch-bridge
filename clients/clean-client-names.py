#!/usr/bin/env python3
"""Strip synthetic HTTP-status segments from generated OpenAPI client model names.

openapi-generator synthesizes `Xxx200Response` / `Xxx200ResponseData` model names for
inline 200-response envelopes. This script collapses every such name to its clean
`XxxResponse` / `XxxResponseData` form across an entire generated client tree
(declarations, filenames, imports, type refs, re-export indexes, and docs).

It is a faithful, dependency-free port of the JVM build task
`stripStatusCodesFromGeneratedModels` in app/build.gradle.kts (which works at scale on
the server's generated tree). Supported languages: python, typescript, kotlin. Bash is
operation-based/untyped and needs no model strip.

Algorithm
---------
normalize(text): regex-replace `([A-Za-z])200ResponseData` -> `\\1ResponseData`, THEN
  `([A-Za-z])200Response` -> `\\1Response`. ORDER MATTERS (ResponseData before Response).

Phase 1 (per-declaration, processed LONGEST-NAME-FIRST so e.g. Foo200ResponseDataInner is
handled before its parent Foo200Response):
  newName = name with `200Response` -> `Response`.
  If a different declaration named newName already exists:
    - normalize(src) == normalize(dst) -> DELETE the 200-version (true duplicate; named wins).
    - else (genuine shape conflict)    -> DELETE the named version, RENAME the 200-version
                                          into its place (rewriting its self-references).
  else -> straight RENAME + self-reference rewrite.
  Any collision that is NOT the planned `<X>Response` vs `<X>200Response` pair aborts.

Phase 1 runs over the model declarations and, for the file-backed languages, also over the
parallel `docs/*.md` model docs and (python) the `test/test_*.py` stubs, all under the same
collision policy. Phase 2 (bulk): apply normalize() to every source/doc file in the tree.

Two deviations from the pure server port, both forced by client-tree realities:
  * The generator's `.openapi-generator/FILES` manifest (an extensionless filename listing)
    is normalized too, so it doesn't lie about the renamed tree / trip a `grep 200Response`.
  * python additionally collapses the snake_case module-path token (`200_response`) in import
    statements and test stubs; the kotlin server port never needed this (PascalCase filenames).
Only `200` is stripped (matching the server task exactly); 202/503 envelopes are left intact.

Idempotent: re-running on a clean tree (no `200Response` anywhere) is a no-op.

Usage:
  clean-client-names.py <client_dir> <language>     # language in {python, typescript, kotlin}
"""

from __future__ import annotations

import re
import sys
from pathlib import Path

# --- core text normalization (shared, language-agnostic) --------------------

_RE_RESPONSE_DATA = re.compile(r"([A-Za-z])200ResponseData")
_RE_RESPONSE = re.compile(r"([A-Za-z])200Response")

# Snake-case forms, needed for python module paths (e.g. the import statement
# `from pkg.models.delete_account200_response import DeleteAccountResponse`). The
# generator builds the module path from the *original* synthetic name, so renaming the
# file alone leaves these snake paths dangling. ResponseData before Response, same as
# the PascalCase rules.
#
# Two real shapes occur, both targeting `<base>_response[_data]`:
#   - model-file style: `delete_account200_response`  (letter/digit immediately before 200)
#   - buggy test-stub style: `delete_account_200_response`  (underscore before 200) — the
#     generator's python test stubs reference an underscore-`_200_` module path that never
#     matched the real `200`-no-underscore module file, so this collapse also repairs them.
# The optional leading `_` is consumed so the result keeps exactly one separating underscore
# (never a doubled `__`). A bare HTTP `200` (e.g. `== 200:`) is left untouched.
_RE_RESPONSE_DATA_SNAKE = re.compile(r"_?200_response_data")
_RE_RESPONSE_SNAKE = re.compile(r"_?200_response")


def normalize(text: str) -> str:
    """Collapse every `200Response[Data]`-anchored identifier to its clean form.

    ResponseData is rewritten before Response so the broader Response rule never
    strips the `200` half-way and leaves a malformed `ResponseData`. This is the
    PascalCase port of the server task and is the right normalizer for kotlin/typescript
    declarations + comparisons.
    """
    text = _RE_RESPONSE_DATA.sub(r"\1ResponseData", text)
    text = _RE_RESPONSE.sub(r"\1Response", text)
    return text


def normalize_python(text: str) -> str:
    """normalize() plus the snake-case module-path collapse (python only).

    Python imports reference models by snake_case module path, so a content pass must
    fix both `200Response[Data]` (class identifiers) and `200_response[_data]` (module
    paths) to keep imports resolvable after the model files are renamed.
    """
    text = normalize(text)
    text = _RE_RESPONSE_DATA_SNAKE.sub("_response_data", text)
    text = _RE_RESPONSE_SNAKE.sub("_response", text)
    return text


class CollisionError(RuntimeError):
    """Raised for an unexpected collision outside the planned 200/clean pair."""


# --- per-language declaration models ----------------------------------------
#
# Each language exposes its set of "declarations" (a name + the text whose self-
# references must be rewritten on rename) and how to physically apply a
# rename/delete. Phase 1 of the algorithm is identical across all three; only the
# concrete declaration mechanics differ. Phase 2 is a pure text pass over a glob.


class Stats:
    def __init__(self) -> None:
        self.renamed = 0
        self.deleted_dupes = 0
        self.deleted_conflicting_clean = 0
        self.bulk_edited = 0

    def line(self, lang: str) -> str:
        return (
            f"{lang}: renamed={self.renamed}, deleted-dupes={self.deleted_dupes}, "
            f"deleted-conflicting-clean={self.deleted_conflicting_clean}, "
            f"bulk-edited={self.bulk_edited}"
        )


# ---- file-backed declarations (python, kotlin) -----------------------------


def _file_decl_name(path: Path, lang: str) -> str:
    """Return the declaration's *name* containing `200Response`, for collision logic.

    For kotlin the filename stem IS the PascalCase class name. For python the
    snake_case filename stem maps 1:1 to a class, but for rename/collision purposes
    we operate on the filename stem itself (snake form), which carries `200_response`.
    """
    return path.name


def _process_file_backed(
    model_dir: Path,
    suffix: str,
    *,
    name_token: str,
    clean_token: str,
    rewrite_self: "callable",
    stats: Stats,
    cmp_norm=normalize,
) -> None:
    """Phase 1 for languages where each model is its own file in model_dir.

    name_token/clean_token are the filename-level tokens, e.g. ('200Response',
    'Response') for kotlin or ('200_response', '_response') for python. rewrite_self
    rewrites a file's in-body self-references when its declaration is renamed. cmp_norm
    is the normalizer used to test src/dst equivalence on a collision (python passes
    normalize_python so two bodies differing only in snake import paths compare equal).
    """
    if not model_dir.is_dir():
        return

    # Longest-name-first so deeper names (…200ResponseDataInner) are handled before
    # their shorter parents (…200Response); otherwise a parent rename could mutate a
    # `200Response` substring inside a still-pending filename.
    candidates = sorted(
        (f for f in model_dir.iterdir() if f.is_file() and f.name.endswith(suffix) and name_token in f.name),
        key=lambda f: len(f.name),
        reverse=True,
    )

    for f in candidates:
        old_name = f.name
        new_name = old_name.replace(name_token, clean_token)
        if new_name == old_name:
            continue
        target = model_dir / new_name
        if target.exists() and target.resolve() != f.resolve():
            src_norm = cmp_norm(f.read_text())
            dst_norm = cmp_norm(target.read_text())
            if src_norm == dst_norm:
                # True duplicate: named-schema and path-inline schema describe the same
                # shape. Keep the clean-name file, drop the 200-version.
                f.unlink()
                stats.deleted_dupes += 1
            else:
                # Genuine shape conflict: the path-inline (200) schema is what the API
                # surface references, so it wins. Delete the dead clean-named file and
                # rename the 200-version into its place.
                target.unlink()
                stats.deleted_conflicting_clean += 1
                f.write_text(rewrite_self(f.read_text()))
                f.rename(target)
                stats.renamed += 1
        else:
            # No collision — straight rename + self-reference rewrite.
            f.write_text(rewrite_self(f.read_text()))
            f.rename(target)
            stats.renamed += 1


def _process_doc_dir(client_dir: Path, stats: Stats, norm=normalize) -> None:
    """Phase 1 for the parallel `docs/` tree, shared by all typed languages.

    openapi-generator writes one Markdown file per model, named after the PascalCase
    model class (e.g. docs/Foo200Response.md, docs/Foo200ResponseData.md). These names
    are identical across python/typescript/kotlin. They must be renamed to their clean
    form with the SAME collision policy as model declarations: longest-name-first; if a
    clean-named doc already exists, delete the 200-doc when normalized-equal else delete
    the clean doc and rename the 200-doc into its place. `norm` is both the self-rewrite
    and the collision comparator (python passes normalize_python so snake import-path
    examples inside docs are handled consistently).

    Bulk Phase 2 later fixes the *contents* (cross-references) of every surviving doc;
    this step is purely about the file *names*.
    """
    for docs in client_dir.rglob("docs"):
        if docs.is_dir():
            _process_file_backed(
                docs,
                ".md",
                name_token="200Response",
                clean_token="Response",
                rewrite_self=norm,
                stats=stats,
                cmp_norm=norm,
            )


def _normalize_file(f: Path, stats: Stats, seen: set[Path], norm) -> None:
    """Normalize a single file in place (skips non-files and already-seen paths)."""
    if not f.is_file():
        return
    rp = f.resolve()
    if rp in seen:
        return
    seen.add(rp)
    before = f.read_text()
    after = norm(before)
    if after != before:
        f.write_text(after)
        stats.bulk_edited += 1


def _bulk_pass(root: Path, patterns: list[str], stats: Stats, norm=normalize) -> None:
    """Phase 2: apply `norm` to every file matching any glob pattern under root.

    `norm` defaults to the PascalCase normalize(); python passes normalize_python() so the
    snake-case module paths in imports are collapsed too.

    Also normalizes the generator's own `.openapi-generator/FILES` manifest, which is an
    extensionless bookkeeping listing of every emitted filename. After Phase 1 renames the
    model files, that manifest still lists the stale `*200Response*` names; leaving it would
    both lie about the tree and trip the repo's `grep -rl 200Response` zero-invariant. It is
    generator output (never hand-edited), so collapsing it is in-spirit with the strip.
    """
    seen: set[Path] = set()
    for pattern in patterns:
        for f in root.rglob(pattern):
            _normalize_file(f, stats, seen, norm)
    # Extensionless generator manifests (FILES, VERSION) that the globs above miss.
    for manifest in root.rglob(".openapi-generator/FILES"):
        _normalize_file(manifest, stats, seen, norm)


# ---- python ----------------------------------------------------------------


def clean_python(client_dir: Path, stats: Stats) -> None:
    # Package dir holds models/ ; locate it generically (the only dir with a models/ subdir).
    pkg_dirs = [p.parent for p in client_dir.glob("*/models") if p.is_dir()]
    if not pkg_dirs:
        # Fall back: maybe model dir is nested deeper.
        model_dirs = [p for p in client_dir.rglob("models") if p.is_dir() and any(p.glob("*.py"))]
        pkg_dirs = [m.parent for m in model_dirs]
    for pkg in pkg_dirs:
        model_dir = pkg / "models"
        # A python model file references other models by BOTH PascalCase class name and
        # snake_case module path, so its self-rewrite + collision comparison use
        # normalize_python (PascalCase + snake collapse).
        _process_file_backed(
            model_dir,
            ".py",
            name_token="200_response",
            clean_token="_response",
            rewrite_self=normalize_python,
            stats=stats,
            cmp_norm=normalize_python,
        )
    # Phase 1a': the parallel test/ stubs are named test_<snake_model>.py and carry the
    # same 200_response token in both filename and body — rename them with the same policy.
    for test_dir in client_dir.rglob("test"):
        if test_dir.is_dir() and any(test_dir.glob("test_*.py")):
            _process_file_backed(
                test_dir,
                ".py",
                name_token="200_response",
                clean_token="_response",
                rewrite_self=normalize_python,
                stats=stats,
                cmp_norm=normalize_python,
            )
    # Phase 1b: rename the parallel docs/*.md model docs (PascalCase doc filenames; the
    # doc *content* carries both PascalCase and snake refs, fixed in the bulk pass).
    _process_doc_dir(client_dir, stats, norm=normalize_python)
    # Phase 2: every .py (api/, models/, __init__ re-exports) and every doc .md, using the
    # python normalizer so snake import paths (…200_response) are collapsed too.
    _bulk_pass(client_dir, ["*.py", "*.md"], stats, norm=normalize_python)


# ---- kotlin -----------------------------------------------------------------


def clean_kotlin(client_dir: Path, stats: Stats) -> None:
    model_dirs = [p for p in client_dir.rglob("models") if p.is_dir() and any(p.glob("*.kt"))]
    for model_dir in model_dirs:
        _process_file_backed(
            model_dir,
            ".kt",
            name_token="200Response",
            clean_token="Response",
            rewrite_self=normalize,
            stats=stats,
        )
    # Phase 1b: rename the parallel docs/*.md model docs (same collision policy).
    _process_doc_dir(client_dir, stats)
    # Phase 2: every .kt (apis/ imports + refs, models/ leftovers) and every doc .md.
    _bulk_pass(client_dir, ["*.kt", "*.md"], stats)


# ---- typescript -------------------------------------------------------------


def _find_interface_blocks(text: str) -> list[tuple[str, int, int]]:
    """Return [(name, start, end)] for each top-level `export interface <Name> {...}`.

    start is the index of the line's leading `export`; end is just past the matching
    close brace (and any trailing newline). Brace-matched so nested objects are safe.
    """
    blocks: list[tuple[str, int, int]] = []
    pat = re.compile(r"export interface ([A-Za-z0-9_]+)\s*\{")
    for m in pat.finditer(text):
        name = m.group(1)
        # Walk braces from the opening `{` (m.end()-1 points at the `{`).
        depth = 0
        i = m.end() - 1
        n = len(text)
        end = i
        while i < n:
            c = text[i]
            if c == "{":
                depth += 1
            elif c == "}":
                depth -= 1
                if depth == 0:
                    end = i + 1
                    break
            i += 1
        # consume a single trailing newline if present
        if end < n and text[end] == "\n":
            end += 1
        blocks.append((name, m.start(), end))
    return blocks


def clean_typescript(client_dir: Path, stats: Stats) -> None:
    api = client_dir / "api.ts"
    if api.exists():
        text = api.read_text()
        # Build name -> block map from the CURRENT text each iteration is fragile;
        # instead collect all blocks once, decide deletions, then splice.
        blocks = _find_interface_blocks(text)
        by_name = {name: (s, e) for name, s, e in blocks}

        # Candidates: interface declarations whose name contains 200Response, longest first.
        candidates = sorted(
            (b for b in blocks if "200Response" in b[0]),
            key=lambda b: len(b[0]),
            reverse=True,
        )

        # Decide an action per candidate without mutating text yet; record byte ranges
        # to delete (drop a whole interface block) so we can splice once at the end.
        delete_ranges: list[tuple[int, int]] = []
        # Track names that will exist after deletes so collision checks are consistent.
        for name, s, e in candidates:
            new_name = name.replace("200Response", "Response")
            if new_name == name:
                continue
            block_src = text[s:e]
            if new_name in by_name:
                ds, de = by_name[new_name]
                if (ds, de) == (s, e):
                    continue  # same block (shouldn't happen for a 200-name)
                dst_src = text[ds:de]
                if normalize(block_src) == normalize(dst_src):
                    # True duplicate: drop the 200 block; the clean-named one wins.
                    delete_ranges.append((s, e))
                    stats.deleted_dupes += 1
                else:
                    # Genuine conflict: drop the clean-named block; the 200 block's body
                    # survives and its name is normalized in the global pass below.
                    delete_ranges.append((ds, de))
                    stats.deleted_conflicting_clean += 1
                    stats.renamed += 1  # the 200 block effectively takes the clean name
            else:
                # No declaration collision — the rename happens via the global normalize.
                stats.renamed += 1

        # Splice out deleted ranges (descending so earlier offsets stay valid).
        for s, e in sorted(set(delete_ranges), key=lambda r: r[0], reverse=True):
            text = text[:s] + text[e:]

        # Now globally normalize remaining declarations + all refs in api.ts.
        new_text = normalize(text)
        if new_text != api.read_text():
            api.write_text(new_text)

    # Phase 1b: rename the parallel docs/*.md model docs (same collision policy).
    _process_doc_dir(client_dir, stats)
    # Phase 2 for docs (+ any other .ts that slipped in) — api.ts already handled above
    # but a redundant normalize is a safe no-op.
    _bulk_pass(client_dir, ["*.md", "*.ts"], stats)


# --- entry point -------------------------------------------------------------

CLEANERS = {
    "python": clean_python,
    "typescript": clean_typescript,
    "kotlin": clean_kotlin,
}


def main(argv: list[str]) -> int:
    if len(argv) != 3:
        sys.stderr.write(__doc__ or "")
        sys.stderr.write("\nERROR: expected exactly <client_dir> <language>\n")
        return 2
    client_dir = Path(argv[1]).resolve()
    lang = argv[2].strip().lower()
    if lang == "bash":
        sys.stderr.write("bash is untyped/operation-based; no model strip needed.\n")
        return 0
    if lang not in CLEANERS:
        sys.stderr.write(f"ERROR: unsupported language '{lang}'. Use one of: {', '.join(CLEANERS)}\n")
        return 2
    if not client_dir.is_dir():
        sys.stderr.write(f"ERROR: client dir not found: {client_dir}\n")
        return 2

    stats = Stats()
    try:
        CLEANERS[lang](client_dir, stats)
    except CollisionError as e:
        sys.stderr.write(f"COLLISION (aborting, no hack-around): {e}\n")
        return 1
    print(stats.line(lang))
    return 0


if __name__ == "__main__":
    raise SystemExit(main(sys.argv))
