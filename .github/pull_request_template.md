<!--
PR titles must be Conventional Commits. Use one of these types: feat, fix, docs, style, refactor, perf, test, build, ci, chore, revert.
The title drives versioning and the changelog on squash-merge.
-->

## What changed

<!-- A concise description of the change. -->

## Why

<!-- The motivation / problem being solved. Link the ADR number if this was a decision. -->

## How it was verified

<!-- Which gates/tests prove this works: `./mvnw verify`, new tests, manual steps. -->

- [ ] `./mvnw verify` is green (unit tests + quality gates)
- [ ] Public API changes carry Javadoc; decisions carry an ADR
- [ ] README/doc pointers updated if a command or convention changed
