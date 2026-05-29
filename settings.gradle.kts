rootProject.name = "monarch-bridge"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

// Auto-provision JDK declared by the toolchain (java=21 in libs.versions.toml).
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
    }
}

include(":app")
include(":mcp")
