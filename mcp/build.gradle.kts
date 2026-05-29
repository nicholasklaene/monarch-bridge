// :mcp module: Kotlin MCP (Model Context Protocol) server.
//
// Reads `openapi/monarch-bridge.yaml` at startup, generates one MCP tool per operation,
// and forwards tool invocations to the running monarch-bridge HTTP service on :9084.
// Stdio transport, the format Claude Desktop / Cursor / Continue / Cline expect.
//
// Built on top of Anthropic's official Kotlin MCP SDK (io.modelcontextprotocol).

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.detekt)
    alias(libs.plugins.spotless)
    application
}

group = "com.nicholasklaene"
version = "1.0.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get().toInt()))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.mcp.kotlin.server)
    implementation(libs.swagger.parser)
    implementation(libs.kotlin.reflect)
    implementation(libs.jackson.module.kotlin)

    // stdout is the MCP JSON-RPC channel; slf4j-simple defaults to stderr so any
    // upstream logging (SDK, Swagger parser, etc.) doesn't corrupt the protocol stream.
    runtimeOnly(libs.slf4j.simple)

    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation(libs.assertj.core)

    // Note: detekt 2.0 dropped the bundled `detekt-formatting` plugin (Spotless's ktlint
    // integration covers the same ground). No replacement dependency needed.
}

application {
    mainClass.set("com.nicholasklaene.monarchbridge.mcp.MonarchMcpServerKt")
    applicationName = "monarch-bridge-mcp"
}

// Tell the generated launcher to keep stderr quiet by default — surfaces only WARN+.
// Users can override via `-Dorg.slf4j.simpleLogger.defaultLogLevel=info`.
tasks.named<CreateStartScripts>("startScripts") {
    defaultJvmOpts =
        listOf(
            "-Dorg.slf4j.simpleLogger.defaultLogLevel=warn",
            "-Dorg.slf4j.simpleLogger.logFile=System.err",
        )
}

tasks.withType<Test> {
    useJUnitPlatform()
}

detekt {
    config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
    autoCorrect = false
    parallel = true
}

spotless {
    kotlin {
        target("src/**/*.kt")
        ktlint(libs.versions.ktlint.get())
    }
}
