# 0001. Package names follow the repo segment

- Status: proposed
- Date: 2026-11-04

## Context

Sequeless repos name their packages `org.sequeless.<repo>.<...>`. sequeless-filter uses
`org.sequeless.filter.api` and `org.sequeless.filter.sql.api`. The kernel's identity and value types
used to live in the prototype's `org.sequeless.spi` and `org.sequeless.spi.object`. Decision #23
commits to renaming packages in place when code moves, with no bridge package. The repo's
`docs/architecture/02-decision-records.md` records no package-naming rule, so the choice had to be
made here.

## Decision

We will name the packages `org.sequeless.kernel.identity` (for `kernel-identity`) and
`org.sequeless.kernel.values` (for `kernel-values`). Later repos will follow the same rule: the
segment after `org.sequeless` is the repo's short name.

## Consequences

- The prototype's cut-over (spec 7) updates up to 125 importing files from `org.sequeless.spi` to
  these packages in one commit.
- The package names match the repo name, so a consumer can find the module from the import.
- A future `sequeless-identity` repo would not collide with `kernel.identity`.
- Option B (`org.sequeless.identity` and `org.sequeless.values`) was rejected: it is a one-off exception
  to the convention. Option C (keeping `org.sequeless.spi`) was rejected: the package would no longer
  match its repo, and the rename is already committed by decision #23.
