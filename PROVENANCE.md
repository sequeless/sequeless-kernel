# Provenance

- Created from: sequeless/sequeless-template. Commit 26fd82d has the same tree as template commit 7b294a2.
- Commit f036c1d also contains output of the template script `scripts/init-repo.sh`, with further edits. That script records the new repo's HEAD, not a template commit.
- Source repo: sequeless/sequeless-prototype
- Source SHA at the move: 3a070ad (main, after the javadoc prerequisite sequeless-prototype#75)
- Source paths, moved to `kernel-identity` (package `org.sequeless.kernel.identity`):
  - `sequeless-spi/src/main/java/org/sequeless/spi/{Scope,TenantId,Principal}.java`
  - tests `sequeless-spi/src/test/java/org/sequeless/spi/{PrincipalTest,ScopeTest,TenantIdTest}.java`
- Source paths, moved to `kernel-values` (package `org.sequeless.kernel.values`):
  - `sequeless-spi/src/main/java/org/sequeless/spi/object/{ObjectId,Value,TextValue,IntegerValue,DecimalValue,BoolValue,DateTimeValue,DateValue,ReferenceValue,ListValue,ObjectNotFoundException}.java`
  - tests `sequeless-spi/src/test/java/org/sequeless/spi/object/{ObjectIdTest,ValueTest,ObjectNotFoundExceptionTest}.java`
- The move: packages renamed in place (`org.sequeless.spi` to `org.sequeless.kernel.identity`, `org.sequeless.spi.object` to `org.sequeless.kernel.values`). Javadoc links to types that stay in the prototype were demoted to `{@code}` beforehand (sequeless-prototype#75). No behaviour change.
- Not moved: `StaleObjectException` stays on the Command side (sequeless-prototype#12, item 2). The prototype deletes the moved code in its cut-over (sequeless-prototype spec 7). The cut-over commit names this repo and the import commit SHA.
- Date: 2026-11-04
