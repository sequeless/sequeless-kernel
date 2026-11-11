# sequeless-kernel

This library defines the identity and value types that Sequeless modules share.
It contains two modules. Each module depends only on the Java platform.

Other Sequeless libraries use these types. For example, sequeless-expression returns its results as a `Value`.

## What the library does

- `kernel-identity` describes the caller of a request. A `Scope` holds a `TenantId` and a `Principal`.
- `Principal` identifies the caller and its roles. `Principal.ANONYMOUS` represents an unauthenticated caller.
- `TenantId.DEFAULT` names the default tenant.
- `kernel-values` defines property values. `Value` is a sealed interface with eight types: text, integer, decimal, boolean, date-time, date, reference, and list.
- `ObjectId` identifies an object. It wraps a UUID.
- `ObjectNotFoundException` reports a missing or deleted object.

## Design

- Both modules depend only on the JDK. A test checks that neither module depends on Spring.
- Only the eight types in `kernel-values` can implement `Value`.
- `Principal` and `ListValue` copy their collections when you construct them. Later changes to the original collection do not change the record.
- This repo does not define ports or adapters. Other libraries, for example sequeless-expression, define ports that use these types.

## Modules

| Module | Contents | Depends on |
|---|---|---|
| `kernel-identity` | `Scope`, `TenantId`, `Principal` | the JDK only |
| `kernel-values` | `Value` and its eight types, `ObjectId`, `ObjectNotFoundException` | the JDK only |

The modules are independent. Neither module depends on the other. The modules are split because `Value` changes at a different rate from identity.

Each module is released on its own. Release tags use the form `<module>-vX.Y.Z`. The root POM is an aggregator and is never released.

## Build

Maven reads the GitHub Packages repository. You need a token with `read:packages` and a `github` server entry in `~/.m2/settings.xml`:

```xml
<server>
  <id>github</id>
  <username>YOUR_GITHUB_USERNAME</username>
  <password>${env.PACKAGES_READ_TOKEN}</password>
</server>
```

Run the build:

```bash
export PACKAGES_READ_TOKEN=<PAT with read:packages>
make verify    # ./mvnw -B verify
```

The build needs JDK 25. The libraries compile for Java release 21. To format the code, run this command:

```bash
./mvnw -q -pl kernel-identity,kernel-values spotless:apply
```

See [CONTRIBUTING.md](CONTRIBUTING.md) for the contributor workflow.

## Quick start

Consumers need Java 21 or later at runtime. They also need the repository and the token described in Build.

1. Declare the repository in your POM. Use the same declaration as this repo:

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/sequeless/*</url>
  </repository>
</repositories>
```

2. Add a dependency for each module that you use. Set `<version>` to the latest release version. The tag `kernel-identity-v0.1.0` gives version 0.1.0.

```xml
<dependency>
  <groupId>org.sequeless</groupId>
  <artifactId>kernel-identity</artifactId>
  <version><!-- latest release --></version>
</dependency>
```

Use the same form for `kernel-values`.

3. Use the types in your code:

```java
import java.util.Set;
import org.sequeless.kernel.identity.Principal;
import org.sequeless.kernel.identity.Scope;
import org.sequeless.kernel.identity.TenantId;
import org.sequeless.kernel.values.ObjectId;
import org.sequeless.kernel.values.Value;

public class Example {
    public static void main(String[] args) {
        Principal caller = new Principal("user-42", Set.of("editor"));
        Scope scope = new Scope(TenantId.DEFAULT, caller);
        ObjectId identifier = ObjectId.random();
        Value name = Value.text("Ada");
        System.out.println(scope + " " + identifier + " " + name);
    }
}
```

For more detail, see [Use the modules](docs/how-to/use-the-modules.md).

## Documentation

- [Use the modules](docs/how-to/use-the-modules.md): add the modules to a Maven project.
- [CONTRIBUTING.md](CONTRIBUTING.md): set up the build and follow the contributor workflow.
- [PROVENANCE.md](PROVENANCE.md): where the code came from.
- Architecture decisions are in [docs/adr/](docs/adr/). Domain terms are in [GLOSSARY.md](GLOSSARY.md).

## License

Apache License 2.0. See [LICENSE](LICENSE).
