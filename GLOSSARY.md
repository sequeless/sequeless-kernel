# Glossary

This file lists the terms that this repo uses. Each entry cites its source.

- **Scope**: The tenant and principal of a request. The type is `Scope`. (kernel-identity/src/main/java/org/sequeless/kernel/identity/Scope.java:11-12)
- **TenantId**: The identifier of a tenant. (kernel-identity/src/main/java/org/sequeless/kernel/identity/TenantId.java:9)
- **Default tenant**: The tenant named by `TenantId.DEFAULT`. (kernel-identity/src/main/java/org/sequeless/kernel/identity/TenantId.java:18)
- **Principal**: The caller that a request acts for. It can be anonymous. (kernel-identity/src/main/java/org/sequeless/kernel/identity/Scope.java:12, kernel-identity/src/main/java/org/sequeless/kernel/identity/Principal.java:23-26)
- **Role**: A string in the roles of a principal. (kernel-identity/src/main/java/org/sequeless/kernel/identity/Principal.java:23)
- **Anonymous principal**: The principal `Principal.ANONYMOUS`, with identifier `anonymous`. (kernel-identity/src/main/java/org/sequeless/kernel/identity/Principal.java:26)
- **Value**: A property value. `Value` is a sealed interface. (kernel-values/src/main/java/org/sequeless/kernel/values/Value.java:22-23, kernel-values/src/main/java/org/sequeless/kernel/values/BoolValue.java:4)
- **ObjectId**: The identifier of an object. It wraps a UUID. (kernel-values/src/main/java/org/sequeless/kernel/values/ObjectId.java:11, kernel-values/src/main/java/org/sequeless/kernel/values/ObjectId.java:13)
- **ObjectNotFoundException**: A runtime exception. It reports a missing or deleted object. (kernel-values/src/main/java/org/sequeless/kernel/values/ObjectNotFoundException.java:14, kernel-values/src/main/java/org/sequeless/kernel/values/ObjectNotFoundException.java:19)
