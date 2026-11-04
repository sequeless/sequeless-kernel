# sequeless-kernel

The identity and value types every Sequeless module shares. Two modules, each released on its own:

| Module | Package | Contents | Depends on |
|---|---|---|---|
| `kernel-identity` | `org.sequeless.kernel.identity` | `Scope`, `TenantId`, `Principal` | the JDK only |
| `kernel-values` | `org.sequeless.kernel.values` | `ObjectId`, the sealed `Value` hierarchy, `ObjectNotFoundException` | the JDK only |

The two modules are independent: neither depends on the other. They are split because `Value`
changes at a different rate from identity, and code that needs only identity should not be
released with every value change.

## Build

```bash
./mvnw -B verify       # JDK 25; libraries compile with --release 21
```

GitHub Packages needs a read token in the environment (`source ~/.bashrc.ext` on the owner's
machine). Never write a token into a file.

## Release

Modules are released by release-please in manifest mode with the `maven-workspace` plugin. Tags are
`<module>-vX.Y.Z`. Both modules start at `0.1.0`. Every version change is a patch bump until the
owner decides otherwise. A new permitted subtype of the sealed `Value` is a major bump, as is adding
a `Datatype`; a method with a default implementation is a minor bump.

## Provenance

The code came from `sequeless-prototype`, with a fresh history. See [PROVENANCE.md](PROVENANCE.md).

## Decisions

- [0001](docs/adr/0001-package-names-follow-the-repo-segment.md): package names follow the repo segment.
- Architecture decision records live in [docs/adr/](docs/adr/).
