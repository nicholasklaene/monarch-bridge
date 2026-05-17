package com.nicholasklaene.monarchproxy.architecture

import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses

/**
 * Flat MVC architecture rules — enforces KRE conventions for `monarch-proxy`.
 *
 * This service is a stateless pass-through over Monarch Money's GraphQL API. There is
 * no `persistence/` or `kafka/` package, so the rule set is **6 top-level packages**
 * instead of the 8 used by PDS / ES / template-spring-next:
 *
 *   controllers, services, models, exceptions, config, utils
 *
 * If a future iteration adds a database or event mesh, add the relevant package to the
 * whitelist below + tighten the rules (see PDS's ArchitectureTest for the 8-package shape).
 */
@AnalyzeClasses(
    packages = ["com.nicholasklaene.monarchproxy"],
    importOptions = [ImportOption.DoNotIncludeTests::class],
)
class ArchitectureTest {
    @ArchTest
    val controllersHaveRestControllerAndCorrectName =
        classes()
            .that()
            .resideInAPackage("..controllers..")
            .and()
            .areTopLevelClasses()
            .should()
            .haveSimpleNameEndingWith("Controller")
            .andShould()
            .beAnnotatedWith(org.springframework.web.bind.annotation.RestController::class.java)
            .because(
                "classes in controllers/ are Spring REST controllers — name ends with Controller, annotated with @RestController",
            )

    // NOTE: monarch-proxy uses @Component for all services (MonarchClient, MonarchSessionService,
    // MonarchAuth) since none of them have an interface-pair pattern. PDS / ES use @Service for the
    // XService/XServiceImpl pair pattern; we don't have that here. The next rule covers placement.

    @ArchTest
    val springComponentsLiveUnderServicesOrConfig =
        classes()
            .that()
            .areAnnotatedWith(org.springframework.stereotype.Component::class.java)
            .and()
            .areTopLevelClasses()
            .should()
            .resideInAnyPackage("..services..", "..config..")
            .because(
                "@Component-annotated classes (MonarchClient, MonarchSessionService, MonarchAuth) live under services/; configuration components under config/",
            )

    @ArchTest
    val modelsAreFrameworkFree =
        noClasses()
            .that()
            .resideInAPackage("..models..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage(
                "org.springframework..",
                "jakarta.persistence..",
                "org.hibernate..",
            ).because("models/ holds plain data classes — no Spring/JPA imports")

    @ArchTest
    val exceptionsExtendRuntimeException =
        classes()
            .that()
            .resideInAPackage("..exceptions..")
            .and()
            .areTopLevelClasses()
            .should()
            .beAssignableTo(RuntimeException::class.java)
            .because(
                "exceptions/ classes are KRE-style runtime exceptions mapped to HTTP status by GlobalExceptionHandler",
            )

    @ArchTest
    val controllersDoNotImportServicesInternals =
        noClasses()
            .that()
            .resideInAPackage("..controllers..")
            .should()
            .dependOnClassesThat()
            .resideInAPackage("..services.internal..")
            .because(
                "controllers should depend on service interfaces / @Components, not internal-package classes (defensive — no internal/ subpackage exists today)",
            )

    /**
     * Flat layout enforcement — no sub-packages under any of the 6 top-level dirs.
     * Add a top-level package to the whitelist below when you introduce one.
     *
     * If `persistence/` or `kafka/` ever land (they shouldn't for V1's pass-through
     * design), add them here AND swap the package counts in the documentation above.
     */
    @ArchTest
    val noNestedSubpackages =
        classes()
            .that()
            .resideInAPackage("com.nicholasklaene.monarchproxy..")
            .and()
            .areTopLevelClasses()
            .should()
            .resideInAnyPackage(
                "com.nicholasklaene.monarchproxy",
                "com.nicholasklaene.monarchproxy.controllers",
                "com.nicholasklaene.monarchproxy.services",
                "com.nicholasklaene.monarchproxy.models",
                "com.nicholasklaene.monarchproxy.config",
                "com.nicholasklaene.monarchproxy.exceptions",
                "com.nicholasklaene.monarchproxy.utils",
            ).because(
                "flat layout — no sub-packages under controllers/, services/, models/, " +
                    "config/, exceptions/, utils/. monarch-proxy has 6 top-level packages " +
                    "(no persistence/, no kafka/) since this is a stateless pass-through.",
            )
}
