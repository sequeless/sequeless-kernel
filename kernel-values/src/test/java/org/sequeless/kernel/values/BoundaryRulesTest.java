package org.sequeless.kernel.values;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

/**
 * Mechanically enforced boundaries for this module (spec 5, §5). It depends on the JDK and on its
 * own package only, and never on Spring. Dependencies on the other kernel module are not allowed.
 */
@AnalyzeClasses(
        packages = "org.sequeless.kernel.values",
        importOptions = {ImportOption.DoNotIncludeTests.class})
class BoundaryRulesTest {

    @ArchTest
    static final ArchRule module_is_free_of_spring = noClasses()
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("org.springframework..")
            .as("the kernel must stay transport-agnostic: no Spring dependency");

    @ArchTest
    static final ArchRule module_depends_only_on_java_and_itself = noClasses()
            .should()
            .dependOnClassesThat()
            .resideOutsideOfPackages("java..", "org.sequeless.kernel.values..")
            .as("this module depends on the JDK and itself only (#12: no dependency outside the JDK)");
}
