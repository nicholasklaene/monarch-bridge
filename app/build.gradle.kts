// :app module — Spring Boot 3 + Kotlin 2 + minimal HTTP wrapper.
// No JPA, no Flyway, no Kafka. monarch-bridge is stateless: it loads a session token
// from disk and proxies GraphQL calls to api.monarch.com.

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dep.mgmt)
    alias(libs.plugins.detekt)
    alias(libs.plugins.spotless)
    alias(libs.plugins.kover)
    alias(libs.plugins.openapi.generator)
}

group = "com.nicholasklaene"
version = "1.0.0"

java {
    toolchain {
        languageVersion.set(
            JavaLanguageVersion.of(libs.versions.java.get().toInt()),
        )
    }
}

// --- Kotlin compiler args ---
// `-Xannotation-default-target=param-property` opts into Kotlin 2.x's future default for
// annotation use-site targets (param + property) NOW, which silences the ~2067 "this annotation
// is currently applied to the value parameter only, but in the future it will also be applied to
// field" warnings emitted across the openapi-generated DTOs (Jakarta validation annotations on
// constructor params). Validation annotations still apply to the generated DTOs (:app:test proves
// it); this only changes which use-site target the compiler picks, not whether the annotation is
// present.
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.add("-Xannotation-default-target=param-property")
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
    // Spring Boot starters — web only (no data-jpa, no kafka)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.validation)

    // Kotlin extras Spring needs
    implementation(libs.jackson.module.kotlin)
    implementation(libs.kotlin.reflect)

    // OpenAPI 3 spec + Swagger UI (auto-generates spec from Spring controllers)
    implementation(libs.springdoc.openapi.starter.webmvc.ui)

    // Structured JSON logs
    runtimeOnly(libs.logstash.logback.encoder)

    // Idiomatic Kotlin logging: `private val log = KotlinLogging.logger {}` on companions,
    // lazy message evaluation via `log.info { "expensive: ${...}" }`. Routes through SLF4J.
    implementation(libs.kotlin.logging.jvm)

    // Tests
    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.wiremock.standalone)
    testImplementation(libs.assertj.core)
    testImplementation(libs.archunit.junit5)

    // Note: detekt 2.0 dropped the bundled `detekt-formatting` plugin. Spotless's ktlint
    // integration covers the same ground; no replacement dependency needed.
}

// Explicitly set the Spring Boot application main class so bootJar doesn't
// get confused by MonarchBootstrapMain (the interactive CLI entry point).
springBoot {
    mainClass.set("com.nicholasklaene.monarchbridge.ApplicationKt")
}

// --- Bootstrap CLI task ---
// One-time auth setup. Prompts for email/password/MFA, writes session JSON to disk.
// NOT auto-run; the user invokes this when first setting up monarch-bridge.
tasks.register<JavaExec>("bootstrapMonarch") {
    group = "application"
    description =
        "One-time interactive Monarch Money authentication. Prompts for email/password/MFA and " +
        "writes a session JSON file the running service loads. Re-run if the session expires."
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("com.nicholasklaene.monarchbridge.auth.MonarchBootstrapMain")
    standardInput = System.`in`
}

// Copy the source-of-truth OpenAPI yaml into the runtime classpath so Swagger UI can
// fetch it from /openapi/monarch-bridge.yaml. Spring Boot serves anything under
// src/main/resources/static/ at the root URL — so we drop the spec at static/openapi/.
tasks.named<Copy>("processResources") {
    from("$rootDir/openapi/monarch-bridge.yaml") {
        into("static/openapi/")
    }
}

// --- OpenAPI codegen ---
// Spec-first: openapi/monarch-bridge.yaml is the source of truth. This task generates
// Kotlin request DTOs into build/generated/openapi, which gets compiled into the api jar.
// Run automatically before compileKotlin; refresh after editing the spec.
openApiGenerate {
    // kotlin-spring (NOT the plain `kotlin` client generator) — the spring flavor
    // emits Jakarta validation annotations (@NotBlank, @Pattern, @Size, etc.) read
    // straight from the spec's required/pattern/minLength constraints. The plain
    // kotlin generator silently ignores useBeanValidation.
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/openapi/monarch-bridge.yaml")
    outputDir.set("$buildDir/generated/openapi")
    apiPackage.set("com.nicholasklaene.monarchbridge.generated.api")
    modelPackage.set("com.nicholasklaene.monarchbridge.generated.model")
    invokerPackage.set("com.nicholasklaene.monarchbridge.generated")
    // Generate BOTH request/response models AND a Spring `*Api` interface per tag.
    // Controllers implement those interfaces — no hand-rolled @GetMapping / @PostMapping
    // strings, no hand-rolled response wrappers; the spec drives the web layer end-to-end.
    // We suppress docs/tests/supporting files (we keep our own test layer).
    globalProperties.set(
        mapOf(
            "models" to "",
            "apis" to "",
            "modelDocs" to "false",
            "apiTests" to "false",
            "modelTests" to "false",
            "apiDocs" to "false",
            "supportingFiles" to "false",
        ),
    )
    configOptions.set(
        mapOf(
            "useBeanValidation" to "true",
            "useSpringBoot3" to "true",
            // interfaceOnly: emit only the Spring `*Api` interface (with @RequestMapping +
            // @Operation already baked in from the spec); the proxy controllers implement
            // it. Without this the generator would also emit *Controller stubs we don't want.
            "interfaceOnly" to "true",
            // skipDefaultInterface: by default the generator gives each method a 501-throwing
            // default impl. Removing it forces concrete controllers to implement every method,
            // which is exactly the compile-time enforcement we want.
            "skipDefaultInterface" to "true",
            // useTags: one interface per OpenAPI tag (SystemApi, AccountsApi, …) instead of
            // one per path. Matches our one-controller-per-resource layout.
            "useTags" to "true",
            "serializationLibrary" to "jackson",
            "enumPropertyNaming" to "UPPERCASE",
            "dateLibrary" to "java8",
            "additionalModelTypeAnnotations" to "@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)",
        ),
    )
}

// Wire generated sources into the main sourceSet + make compileKotlin depend on codegen.
kotlin {
    sourceSets["main"].kotlin.srcDir("$buildDir/generated/openapi/src/main/kotlin")
}

// --- Strip `200` status-code from generated class names ---
// The kotlin-spring generator emits `Xxx200Response` / `Xxx200ResponseData` when a path's
// 200 response has an inline schema, sometimes alongside a same-named named-schema variant
// declared in `components/schemas`. The `200` is a generator quirk — the spec itself never
// uses it. This task cleans those names so callers see `XxxResponse` / `XxxResponseData`
// instead. Runs after openApiGenerate and before compileKotlin; idempotent (re-running on a
// clean tree is a no-op).
//
// Collision policy (only relevant inside the planned `<X>Response` vs `<X>200Response` pair):
//   * Same shape post-normalization → keep the clean-name file, delete the 200-version.
//     (Most common: spec defines both an inline path schema and a same-shape named schema.)
//   * Different shape post-normalization → the path-anchored 200-version wins (controllers +
//     the generated `*Api` interface reference it; the named-schema variant is dead code).
//     Delete the clean-name file and rename the 200-file to take its place.
//   * Any other collision outside this planned pair fails the build with a GradleException.
tasks.register("stripStatusCodesFromGeneratedModels") {
    description =
        "Rename generated *200Response[*] models to *Response[*] (and update self-references). " +
        "Resolves the planned name-pair by preferring the path-anchored *200* version when " +
        "the two genuinely differ; deletes the duplicate when they normalize identical."
    val modelDir = file("$buildDir/generated/openapi/src/main/kotlin/com/nicholasklaene/monarchbridge/generated/model")
    val genRoot = file("$buildDir/generated/openapi/src/main/kotlin")
    inputs.dir(genRoot)
    outputs.dir(genRoot)
    doLast {
        if (!modelDir.exists()) {
            logger.lifecycle("stripStatusCodesFromGeneratedModels: model dir missing, skipping")
            return@doLast
        }

        var renamed = 0
        var deletedDupes = 0
        var deletedConflictingClean = 0
        val collisions = mutableListOf<String>()

        // Returns the file content with every `200Response`-anchored identifier collapsed
        // to its `Response`-anchored form. Used to compare a pair for true equivalence.
        fun normalize(text: String): String =
            text
                .replace(Regex("([A-Za-z])200ResponseData"), "$1ResponseData")
                .replace(Regex("([A-Za-z])200Response"), "$1Response")

        // Sort by descending filename length so deeper/longer names ($Foo200ResponseDataInner)
        // are processed before their shorter parents ($Foo200Response). Otherwise an earlier
        // parent rename could change a `200Response` substring inside a still-pending filename.
        val candidates = modelDir.listFiles { f ->
            f.isFile && f.name.endsWith(".kt") && f.name.contains("200Response")
        }?.sortedByDescending { it.name.length } ?: emptyList()

        for (file in candidates) {
            val oldName = file.name
            val newName = oldName.replace("200Response", "Response")
            if (newName == oldName) continue
            val target = File(modelDir, newName)
            if (target.exists() && target.absolutePath != file.absolutePath) {
                val srcNorm = normalize(file.readText())
                val dstNorm = normalize(target.readText())
                if (srcNorm == dstNorm) {
                    // True duplicate — the named-schema and path-inline schema describe the
                    // same shape. Keep the clean-name file, drop the 200-version.
                    file.delete()
                    deletedDupes++
                } else {
                    // Genuine shape conflict. The path-inline schema (200-version) is what
                    // controllers + the generated `*Api` interface reference, so it wins.
                    // The named-schema variant is dead code — delete it and rename.
                    target.delete()
                    deletedConflictingClean++
                    val oldClass = oldName.removeSuffix(".kt")
                    val newClass = newName.removeSuffix(".kt")
                    file.writeText(file.readText().replace(oldClass, newClass))
                    if (!file.renameTo(target)) {
                        collisions += "could not rename $oldName -> $newName after deleting clean dupe"
                    } else {
                        renamed++
                    }
                }
            } else {
                // No collision — straight rename + self-reference rewrite.
                val oldClass = oldName.removeSuffix(".kt")
                val newClass = newName.removeSuffix(".kt")
                file.writeText(file.readText().replace(oldClass, newClass))
                if (!file.renameTo(target)) {
                    collisions += "could not rename $oldName -> $newName"
                    continue
                }
                renamed++
            }
        }

        // Second pass: bulk-replace any remaining `Xxx200ResponseData` and `Xxx200Response`
        // references (imports, property types, KDoc) in the entire generated tree. Do the
        // `200ResponseData` form FIRST so the broader `200Response` rule doesn't strip the
        // `200` half-way and leave `ResponseData` mis-formed.
        var touched = 0
        genRoot.walkTopDown().filter { it.isFile && it.name.endsWith(".kt") }.forEach { f ->
            val before = f.readText()
            val after = normalize(before)
            if (after != before) {
                f.writeText(after)
                touched++
            }
        }

        if (collisions.isNotEmpty()) {
            throw GradleException(
                "stripStatusCodesFromGeneratedModels collisions:\n  " + collisions.joinToString("\n  "),
            )
        }
        logger.lifecycle(
            "stripStatusCodesFromGeneratedModels: renamed=$renamed, " +
                "deleted-dupes=$deletedDupes, deleted-conflicting-clean=$deletedConflictingClean, " +
                "bulk-edited=$touched",
        )
    }
}

tasks.named("stripStatusCodesFromGeneratedModels") { dependsOn("openApiGenerate") }
tasks.named("compileKotlin") { dependsOn("stripStatusCodesFromGeneratedModels") }
// Also auto-run after a bare `./gradlew :app:openApiGenerate` so the generated tree is never
// left in its `*200Response*` state — controllers + tests expect the cleaned names regardless
// of how codegen was invoked.
tasks.named("openApiGenerate") { finalizedBy("stripStatusCodesFromGeneratedModels") }
tasks.withType<dev.detekt.gradle.Detekt> {
    // Skip the generated source tree: it's been formatted by openapi-generator and
    // shouldn't be measured against our internal code style.
    exclude("**/generated/**")
}
// Spotless already targets src/**/*.kt only, so build/generated/** is naturally excluded.

// --- Detekt ---
detekt {
    config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
    autoCorrect = false
    parallel = true
}

// --- Spotless ---
spotless {
    kotlin {
        target("src/**/*.kt")
        ktlint(libs.versions.ktlint.get())
    }
}

// --- Kover (line-coverage gate) ---
kover {
    reports {
        filters {
            excludes {
                classes(
                    // Spring entry point — implicitly exercised by every @SpringBootTest
                    "com.nicholasklaene.monarchbridge.Application*",
                    "com.nicholasklaene.monarchbridge.ApplicationKt",
                    // Interactive CLI — can't unit-test without stdin
                    "com.nicholasklaene.monarchbridge.auth.MonarchBootstrapMain*",
                    // Live-network auth — WireMock tests cover the shape; the actual TCP/TLS
                    // path runs only at first interactive bootstrap.
                    "com.nicholasklaene.monarchbridge.auth.MonarchAuth*",
                    // Codegen output (openapi-generator). Hand-written tests would just
                    // re-test the generator. Spec changes get caught at compile time.
                    "com.nicholasklaene.monarchbridge.generated.*",
                    "com.nicholasklaene.monarchbridge.generated.**",
                    // Long-tail / screen-aggregate pass-through layer. These ~540 operations
                    // (web, mobile, longtail packages + their thin controllers) wrap Monarch's
                    // full bundle surface with identical Map-in / Map-out plumbing; each shares
                    // the same exec() path. Representative WebMvc tests cover the shared behavior
                    // per controller; testing all ~540 individually re-tests one code path 540x.
                    // The hand-written core (accounts, transactions, budgets, goals, etc.) stays
                    // under the 90% gate below. See agents/context/AGENTS.md coverage section.
                    "com.nicholasklaene.monarchbridge.graphql.operations.web.*",
                    "com.nicholasklaene.monarchbridge.graphql.operations.mobile.*",
                    "com.nicholasklaene.monarchbridge.graphql.operations.longtail.*",
                    "com.nicholasklaene.monarchbridge.controllers.WebScreensController",
                    "com.nicholasklaene.monarchbridge.controllers.MobileScreensController",
                    "com.nicholasklaene.monarchbridge.controllers.LongTailController",
                )
            }
        }
        verify {
            // Lines: 90% gate on the hand-written core (the screen-aggregate / long-tail
            // pass-through layer is excluded above - identical plumbing, representative-tested).
            // The core data-domain controllers + operations stay rigorously covered.
            rule {
                minBound(90)
            }
        }
    }
}

// JUnit Platform (JUnit 5) — Spring Boot test starter includes junit-jupiter but Gradle
// defaults to the legacy JUnit 4 runner unless explicitly told to use the platform.
tasks.withType<Test> {
    useJUnitPlatform()
}

// `check` already runs test + detekt + spotlessCheck via Spring Boot conventions.
// Add explicit kover gate.
tasks.named("check") {
    dependsOn("koverVerify")
}

