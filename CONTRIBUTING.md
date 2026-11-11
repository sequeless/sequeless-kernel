# Contributing to sequeless-kernel

## Setup

Requires JDK 25. The Maven wrapper (`./mvnw`) is committed, so no local Maven install is needed.
The devcontainer (`.devcontainer/`) provides a ready JDK 25 toolchain.

Library modules build with `--release 21` through the `sequeless-build` parent. The build JDK is
always 25 (sequeless-prototype#17 §1). Maven reads the `github` package registry, so a read token is needed:

```bash
export PACKAGES_READ_TOKEN=<PAT with read:packages>   # locally; CI reads the org secret
make verify    # confirm a green baseline
```

Your `~/.m2/settings.xml` needs a `github` server entry (`server-id: github`) with the same PAT.

There are no local git hooks. Conventional Commits are checked in CI, not on commit.

## Workflow

1. **Branch** off `main`.
2. **Make the change** with tests. The test is the specification. Format with `./mvnw -q -pl kernel-identity,kernel-values spotless:apply`.
3. **Verify** with `make verify`.
4. **Commit** using Conventional Commits.
5. **Open a PR** following the template. The `pr-title.yml` check lints the PR title with commitlint.
6. **Merge by squash.** The PR title becomes the commit on `main`. release-please reads it.

## Conventional Commits

`feat`, `fix`, `docs`, `style`, `refactor`, `perf`, `test`, `build`, `ci`, `chore`, `revert`.
Use `feat!:` or a `BREAKING CHANGE:` footer for majors. release-please derives versions and
changelogs from these titles. Never hand-edit a `CHANGELOG.md`.

## Recording a decision (ADR)

`make new-adr title="Short title"` scaffolds the next-numbered record under `docs/adr/`. Fill in
Context, Decision and Consequences. ADRs are immutable: supersede with a new one instead of editing.

## Quality gates

Spotless, Enforcer, dependency analysis, and ArchUnit run in `make verify`. Enforcer checks dependency hygiene, including the parent POM's Spring, Jena, and Lombok ban. CodeQL runs through `.github/workflows/codeql.yml`. SonarCloud analysis runs through the SonarCloud GitHub App. This repo has no Sonar workflow file.

## Coverage

`make verify` runs the JaCoCo agent during tests. `make verify` also writes JaCoCo reports to `kernel-identity/target/site/jacoco/` and `kernel-values/target/site/jacoco/`. This repo and its parent POM configure no JaCoCo coverage gate.
