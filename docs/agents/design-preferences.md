# Design Preferences

## Philosophy

Design decisions in this project should prioritise:

1. **Minimal and modular.** Implement only what's needed. Avoid over-engineering or speculative design.
2. **Maintainable.** Favour clarity, loose coupling and high cohesion.
3. **Open to evolve.** Design to support future alternatives without major rewrites. Avoid locking into a single implementation.

## Architectural pattern: hexagonal (ports and adapters)

The build enforces these rules:
- A module must not depend on Spring. The `BoundaryRulesTest` in each module checks this.
- A module must depend only on the JDK and its own package. The `BoundaryRulesTest` in each module checks this.
- The parent POM bans Spring, Jena, and Lombok. The module POMs opt in (kernel-*/pom.xml:20-21).
- The parent POM runs dependency analysis and fails on warnings.

The rules below come from sequeless/sequeless-template. The code in this repo does not enforce them. This repo does not have the packages or modules they describe:
- Each module must have `api`, `spi`, and `internal` packages.
- The `api` and `spi` packages must not depend on `internal`.
- Each port must have a default adapter.
- Contract tests must run in a testkit module.

## How agents should apply this

When grilling or recommending architecture:

1. **Ask about boundaries.** Does this logic belong in the core, or behind a new port in an adapter?
2. **Prefer ports to magic.** Propose a new port before baking a cross-cutting concern into core.
3. **Sketch adapters.** Suggest two or three plausible adapter implementations before settling a port.
4. **Avoid premature unification.** Don't merge similar concerns into one port until they share semantics.
5. **Configuration over code.** Recommend configurable adapter selection, not compile-time choices or constants.

## Reference

- **Decision records**: `docs/adr/`. Consult them before revisiting a design choice.
- **Glossary**: `GLOSSARY.md`, read before ADRs.
