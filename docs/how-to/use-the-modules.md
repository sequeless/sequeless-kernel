# Use the modules

This guide shows how to add the kernel modules to a Maven project.

## Requirements

- Java 21 or later. The modules target Java release 21.
- Access to the Maven repository that hosts the modules.

## Declare the repository

Copy the `<repositories>` block from `kernel-identity/pom.xml` into your POM. The repository identifier is `github`.

Add a server with identifier `github` to your `settings.xml` file. Set the username to your GitHub user name. Set the password to a token that has the `read:packages` scope. See [CONTRIBUTING.md](../../CONTRIBUTING.md) for token setup.

## Add the dependencies

Add one dependency for each module:

```xml
<dependency>
  <groupId>org.sequeless</groupId>
  <artifactId>kernel-identity</artifactId>
  <version>0.1.0</version>
</dependency>
```

Use the same form for `kernel-values`. Replace 0.1.0 with the latest release version for each module. Release tags use the form `<module>-vX.Y.Z`. See the Release section of [README.md](../../README.md).

## Parent POM

The modules use the parent POM `sequeless-build-parent` version 0.1.3. Maven must resolve it from the same repository.

## Use a module

The code in this section uses both modules.

```java
import org.sequeless.kernel.identity.Principal;
import org.sequeless.kernel.identity.Scope;
import org.sequeless.kernel.identity.TenantId;
import org.sequeless.kernel.values.ObjectId;
import org.sequeless.kernel.values.Value;

public class Example {
    public static void main(String[] args) {
        Scope scope = new Scope(TenantId.DEFAULT, Principal.ANONYMOUS);
        ObjectId identifier = ObjectId.random();
        Value name = Value.text("Ada");
        System.out.println(scope + " " + identifier + " " + name);
    }
}
```
