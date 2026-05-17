// :api module — Spring Boot 3 + Kotlin 2 + minimal HTTP wrapper.
// No JPA, no Flyway, no Kafka. monarch-proxy is stateless: it loads a session token
// from disk and proxies GraphQL calls to api.monarch.com.

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dep.mgmt)
    alias(libs.plugins.detekt)
    alias(libs.plugins.spotless)
    alias(libs.plugins.kover)
}

group = "com.nicholasklaene"
version = "0.1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(
            JavaLanguageVersion.of(libs.versions.java.get().toInt()),
        )
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

    // Structured JSON logs
    runtimeOnly(libs.logstash.logback.encoder)

    // Tests
    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.wiremock.standalone)
    testImplementation(libs.assertj.core)
    testImplementation(libs.archunit.junit5)

    // Detekt formatting plugin (ktlint-style rules)
    detektPlugins(libs.detekt.formatting)
}

// Explicitly set the Spring Boot application main class so bootJar doesn't
// get confused by MonarchBootstrapMain (the interactive CLI entry point).
springBoot {
    mainClass.set("com.nicholasklaene.monarchproxy.ApplicationKt")
}

// --- Bootstrap CLI task ---
// One-time auth setup. Prompts for email/password/MFA, writes session JSON to disk.
// NOT auto-run; the user invokes this when first setting up monarch-proxy.
tasks.register<JavaExec>("bootstrapMonarch") {
    group = "application"
    description =
        "One-time interactive Monarch Money authentication. Prompts for email/password/MFA and " +
        "writes a session JSON file the running service loads. Re-run if the session expires."
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("com.nicholasklaene.monarchproxy.MonarchBootstrapMain")
    standardInput = System.`in`
}

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
                    "com.nicholasklaene.monarchproxy.Application*",
                    "com.nicholasklaene.monarchproxy.ApplicationKt",
                    // Interactive CLI — can't unit-test without stdin
                    "com.nicholasklaene.monarchproxy.MonarchBootstrapMain*",
                    // Live-network auth — covered by the future `monarch-auth-payload-verify`
                    // ticket once we have a real session to exercise it against. WireMock
                    // tests would test our own assumptions, not Monarch's actual contract.
                    "com.nicholasklaene.monarchproxy.services.MonarchAuth*",
                )
            }
        }
        verify {
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
