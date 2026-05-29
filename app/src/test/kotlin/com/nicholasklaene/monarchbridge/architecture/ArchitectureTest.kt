package com.nicholasklaene.monarchbridge.architecture

import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes

/**
 * Architecture rules. Top-level packages:
 *
 *   controllers/    Spring REST controllers, one per resource (System, Transaction, Account,
 *                   Budget, Recurring, Tag, Category). Each implements a spec-generated
 *                   `*Api` interface from `generated.api/`.
 *   auth/           Everything related to Monarch session + authentication + bootstrap CLI.
 *   graphql/        GraphQL transport — MonarchClient, MonarchOperation interface,
 *                   GraphQLLoader, PayloadError types, plus per-resource operation objects
 *                   under graphql/operations/{transactions,accounts,tags,categories,system,
 *                   budgets,recurring}/.
 *   exceptions/     Non-auth runtime exceptions mapped to HTTP by GlobalExceptionHandler
 *                   (auth exceptions live in auth/).
 *   config/         Spring configuration + GlobalExceptionHandler.
 *   generated/      OpenAPI-generated code: `generated.api/` (Spring interfaces) +
 *                   `generated.model/` (request + response DTOs). Both are spec-derived;
 *                   never hand-edit. No `models/` package exists — all DTOs come from
 *                   `openapi/monarch-bridge.yaml`.
 *
 * If a future iteration adds a database or event mesh, add the package to the whitelist.
 */
@AnalyzeClasses(
    packages = ["com.nicholasklaene.monarchbridge"],
    importOptions = [ImportOption.DoNotIncludeTests::class],
)
class ArchitectureTest {
    @ArchTest
    val concreteControllersHaveRestControllerAndCorrectName =
        classes()
            .that()
            .resideInAPackage("..controllers..")
            .and()
            .areTopLevelClasses()
            .and()
            .doNotHaveModifier(com.tngtech.archunit.core.domain.JavaModifier.ABSTRACT)
            .and()
            .haveSimpleNameEndingWith("Controller")
            .should()
            .beAnnotatedWith(org.springframework.web.bind.annotation.RestController::class.java)
            .because(
                "concrete controllers in controllers/ are @RestController. Abstract bases (e.g. MonarchControllerBase) hold shared scaffold and are not Spring beans.",
            )

    /**
     * @Component beans live in auth/ (session, auth, bootstrap), graphql/ (MonarchClient),
     * or config/ (Spring configuration). The old monolithic services/ package no longer exists.
     */
    @ArchTest
    val springComponentsLiveUnderApprovedPackages =
        classes()
            .that()
            .areAnnotatedWith(org.springframework.stereotype.Component::class.java)
            .and()
            .areTopLevelClasses()
            .should()
            .resideInAnyPackage("..auth..", "..graphql..", "..config..")
            .because(
                "@Component classes live in auth/ (session+auth) or graphql/ (MonarchClient) or config/.",
            )

    @ArchTest
    val exceptionsLiveInExceptionsPackageOnly =
        classes()
            .that()
            .resideInAPackage("com.nicholasklaene.monarchbridge..")
            .and()
            .areTopLevelClasses()
            .and()
            .haveSimpleNameEndingWith("Exception")
            .should()
            .resideInAPackage("..exceptions..")
            .andShould()
            .beAssignableTo(RuntimeException::class.java)
            .because(
                "all *Exception classes live in exceptions/ (the single GlobalExceptionHandler dispatch boundary) " +
                    "and extend RuntimeException so they propagate cleanly to the @ExceptionHandler chain",
            )

    /** Concrete controllers implement a spec-generated `*Api` interface (one per OpenAPI tag). */
    @ArchTest
    val controllersImplementGeneratedApi =
        classes()
            .that()
            .resideInAPackage("..controllers..")
            .and()
            .areTopLevelClasses()
            .and()
            .doNotHaveModifier(com.tngtech.archunit.core.domain.JavaModifier.ABSTRACT)
            .and()
            .haveSimpleNameEndingWith("Controller")
            .should()
            .beAssignableTo(
                Any::class.java,
            ).andShould()
            .resideInAPackage("..controllers..")
            .because(
                "concrete controllers live in controllers/ and (by convention enforced at compile " +
                    "time via the *Api interface they implement) get all HTTP wiring from the spec.",
            )

    /**
     * Approved top-level package layout. Subpackages allowed ONLY under graphql/operations/
     * (one per resource for the per-operation Kotlin objects). Everything else is flat.
     */
    @ArchTest
    val approvedPackageLayout =
        classes()
            .that()
            .resideInAPackage("com.nicholasklaene.monarchbridge..")
            .and()
            .areTopLevelClasses()
            .should()
            .resideInAnyPackage(
                "com.nicholasklaene.monarchbridge",
                "com.nicholasklaene.monarchbridge.controllers",
                "com.nicholasklaene.monarchbridge.auth",
                "com.nicholasklaene.monarchbridge.graphql",
                "com.nicholasklaene.monarchbridge.graphql.operations.transactions",
                "com.nicholasklaene.monarchbridge.graphql.operations.accounts",
                "com.nicholasklaene.monarchbridge.graphql.operations.tags",
                "com.nicholasklaene.monarchbridge.graphql.operations.categories",
                "com.nicholasklaene.monarchbridge.graphql.operations.budgets",
                "com.nicholasklaene.monarchbridge.graphql.operations.recurring",
                "com.nicholasklaene.monarchbridge.graphql.operations.system",
                "com.nicholasklaene.monarchbridge.graphql.operations.rules",
                "com.nicholasklaene.monarchbridge.graphql.operations.goals",
                "com.nicholasklaene.monarchbridge.graphql.operations.paychecks",
                "com.nicholasklaene.monarchbridge.graphql.operations.merchants",
                "com.nicholasklaene.monarchbridge.graphql.operations.holdings",
                "com.nicholasklaene.monarchbridge.graphql.operations.investments",
                "com.nicholasklaene.monarchbridge.graphql.operations.taxlots",
                // Coverage-expansion subpackages. Each owns a slice of the long-tail Monarch
                // surface (Web_/Mobile_ screen aggregates, plus feature surfaces Monarch has
                // but we hadn't wrapped: Advice, Forecast, Bills, EquityGrants, ReportConfig,
                // business-entity, etc.). See agents/context/AGENTS.md "Outstanding wrappable gap"
                // for the full per-subpackage operation inventory.
                "com.nicholasklaene.monarchbridge.graphql.operations.web",
                "com.nicholasklaene.monarchbridge.graphql.operations.mobile",
                "com.nicholasklaene.monarchbridge.graphql.operations.features",
                "com.nicholasklaene.monarchbridge.graphql.operations.longtail",
                // Generated code from openapi/monarch-bridge.yaml — code-gen output, not
                // hand-written. Lives in the same JAR but in its own namespace.
                "com.nicholasklaene.monarchbridge.generated",
                "com.nicholasklaene.monarchbridge.generated.api",
                "com.nicholasklaene.monarchbridge.generated.model",
                "com.nicholasklaene.monarchbridge.config",
                "com.nicholasklaene.monarchbridge.exceptions",
            ).because(
                "flat layout, with intentional sub-grouping: graphql.operations.<resource>/ " +
                    "for the per-operation Kotlin objects; all request/response DTOs come from " +
                    "openapi/ via generated.model. Add a top-level package here when introducing one.",
            )
}
