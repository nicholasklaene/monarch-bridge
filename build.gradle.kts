// Root build script for monarch-proxy.
// Stateless pass-through wrapper over Monarch Money GraphQL — no DB, no Kafka.

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dep.mgmt) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.spotless)
    alias(libs.plugins.kover) apply false
}

group = "com.nicholasklaene"
version = "0.1.0-SNAPSHOT"

spotless {
    kotlinGradle {
        target("**/*.gradle.kts")
        ktlint(libs.versions.ktlint.get())
    }
    format("misc") {
        target("**/*.md", "**/.gitignore", "**/.editorconfig")
        trimTrailingWhitespace()
        endWithNewline()
    }
}

tasks.register("preflight") {
    description =
        "Pre-flight checks for agent loops. Runs detekt + spotlessCheck + tests — same gates CI runs."
    group = "verification"
    dependsOn(":api:detekt", ":api:spotlessCheck", ":api:test")
}
