// Root build script for monarch-bridge.
// Stateless pass-through wrapper over Monarch Money GraphQL: no DB, no Kafka.

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
version = "1.0.0"

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
        "Pre-flight checks for agent loops. Runs detekt + spotlessCheck + tests across all modules; the same gates CI runs."
    group = "verification"
    dependsOn(
        ":app:detekt", ":app:spotlessCheck", ":app:test",
        ":mcp:detekt", ":mcp:spotlessCheck", ":mcp:test",
    )
}
