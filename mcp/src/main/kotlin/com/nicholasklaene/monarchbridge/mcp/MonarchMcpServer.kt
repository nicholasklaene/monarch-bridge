@file:Suppress(
    // MCP stdio dispatcher has many short helpers; splitting them across files would
    // hurt readability more than it helps.
    "TooManyFunctions",
    "LongMethod",
    "CyclomaticComplexMethod",
    "TooGenericExceptionCaught",
)

package com.nicholasklaene.monarchbridge.mcp

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.modelcontextprotocol.kotlin.sdk.server.Server
import io.modelcontextprotocol.kotlin.sdk.server.ServerOptions
import io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport
import io.modelcontextprotocol.kotlin.sdk.types.CallToolResult
import io.modelcontextprotocol.kotlin.sdk.types.Implementation
import io.modelcontextprotocol.kotlin.sdk.types.ServerCapabilities
import io.modelcontextprotocol.kotlin.sdk.types.TextContent
import io.modelcontextprotocol.kotlin.sdk.types.ToolSchema
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.Operation
import io.swagger.v3.oas.models.PathItem
import io.swagger.v3.parser.OpenAPIV3Parser
import io.swagger.v3.parser.core.models.ParseOptions
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import kotlinx.io.asSink
import kotlinx.io.asSource
import kotlinx.io.buffered
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonObject
import java.net.URI
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.Duration

/**
 * MCP server that exposes monarch-bridge's REST surface as AI tools.
 *
 * Built on the official Anthropic Kotlin SDK (`io.modelcontextprotocol:kotlin-sdk`).
 *
 * On startup we dereference `openapi/monarch-bridge.yaml` (root + paths/ + components/),
 * walk every path × method, and register one MCP tool per operation: `operationId`
 * becomes the tool name; the spec's `summary` + `description` becomes the tool
 * description; tool input schemas are derived from the operation's path + query
 * parameters and its request body schema.
 *
 * On `tools/call` we substitute path placeholders, build the query string, forward the
 * body to `MONARCH_BRIDGE_BASE` (default `http://localhost:9084`), and return the raw
 * response body as text content. HTTP 4xx and 5xx surface as `isError = true` so the
 * calling assistant knows the call failed.
 *
 * Transport is stdio (the format Claude Desktop, Cursor, Continue, Cline, etc. use).
 * stdout carries the MCP JSON-RPC stream; logging goes to stderr via slf4j-simple.
 */

private val MAPPER: ObjectMapper = ObjectMapper().registerKotlinModule()

private const val CONNECT_TIMEOUT_SECONDS: Long = 5
private const val RESPONSE_TIMEOUT_SECONDS: Long = 60
private const val ERROR_STATUS_FLOOR = 400

private val HTTP: HttpClient =
    HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(CONNECT_TIMEOUT_SECONDS)).build()

private val HTTP_METHODS: Map<String, (PathItem) -> Operation?> =
    mapOf(
        "GET" to PathItem::getGet,
        "POST" to PathItem::getPost,
        "PUT" to PathItem::getPut,
        "PATCH" to PathItem::getPatch,
        "DELETE" to PathItem::getDelete,
    )

/** Per-tool dispatch info: where to fan the HTTP call and how to interpret each param. */
private data class RouteBinding(
    val httpPath: String,
    val httpMethod: String,
    /** Param name → "path" | "query" | "header". Drives URL substitution vs query-string append. */
    val paramLocations: Map<String, String>,
)

private data class ToolDescriptor(
    val name: String,
    val description: String,
    val schema: ToolSchema,
    val binding: RouteBinding,
)

fun main() {
    val specPath =
        System.getenv("MONARCH_BRIDGE_SPEC")?.let(Paths::get)
            ?: defaultSpecPath()
            ?: error("Set MONARCH_BRIDGE_SPEC to the absolute path of openapi/monarch-bridge.yaml")
    val proxyBase = System.getenv("MONARCH_BRIDGE_BASE") ?: "http://localhost:9084"

    val spec = loadSpec(specPath)
    val server = buildServer(spec, proxyBase)

    val transport =
        StdioServerTransport(
            inputStream = System.`in`.asSource().buffered(),
            outputStream = System.out.asSink().buffered(),
        )

    runBlocking {
        server.createSession(transport)
        System.err.println(
            "monarch-bridge-mcp ready: ${spec.paths.size} paths, proxy=$proxyBase",
        )
        // Keep the JVM alive until the MCP client closes the stdio pipes.
        val done = Job()
        server.onClose { done.complete() }
        done.join()
    }
}

/**
 * Resolve the spec path when `MONARCH_BRIDGE_SPEC` isn't set. Walks up from the jar/install
 * location looking for a sibling `openapi/monarch-bridge.yaml`, so `./gradlew :mcp:run` and
 * `./gradlew :mcp:installDist`-style launches both work out of the box.
 */
private fun defaultSpecPath(): Path? {
    val classLocation =
        runCatching {
            Path.of(
                Server::class.java.protectionDomain.codeSource.location
                    .toURI(),
            )
        }.getOrNull() ?: return null
    var dir: Path? = classLocation.parent
    while (dir != null) {
        val candidate = dir.resolve("openapi").resolve("monarch-bridge.yaml")
        if (Files.exists(candidate)) return candidate
        dir = dir.parent
    }
    return null
}

private fun loadSpec(specPath: Path): OpenAPI {
    val options =
        ParseOptions().apply {
            isResolve = true
            isResolveFully = true
        }
    val result = OpenAPIV3Parser().readLocation(specPath.toAbsolutePath().toString(), null, options)
    return result.openAPI
        ?: error("Failed to parse OpenAPI spec at $specPath: ${result.messages.joinToString()}")
}

private fun buildServer(
    spec: OpenAPI,
    proxyBase: String,
): Server {
    val server =
        Server(
            serverInfo = Implementation(name = "monarch-bridge", version = "1.0.0"),
            options =
                ServerOptions(
                    capabilities =
                        ServerCapabilities(
                            tools = ServerCapabilities.Tools(listChanged = false),
                        ),
                ),
        )

    for (tool in collectTools(spec)) {
        val binding = tool.binding
        server.addTool(
            name = tool.name,
            description = tool.description,
            inputSchema = tool.schema,
        ) { request ->
            try {
                val args = request.arguments ?: JsonObject(emptyMap())
                val (status, body) = forwardCall(binding, args, proxyBase)
                CallToolResult(
                    content = listOf(TextContent("HTTP $status\n\n$body")),
                    isError = status >= ERROR_STATUS_FLOOR,
                )
            } catch (e: Exception) {
                CallToolResult(
                    content =
                        listOf(
                            TextContent(
                                "Failed to reach monarch-bridge at $proxyBase: ${e.message}\n\n" +
                                    "Is the proxy running? Try `docker compose up -d` or " +
                                    "`./gradlew :app:bootRun`.",
                            ),
                        ),
                    isError = true,
                )
            }
        }
    }

    return server
}

// ──────────────────────── tool generation ────────────────────────

private fun collectTools(spec: OpenAPI): List<ToolDescriptor> {
    val out = mutableListOf<ToolDescriptor>()
    val paths = spec.paths ?: return out
    for ((path, item) in paths) {
        for ((methodName, extractor) in HTTP_METHODS) {
            val op = extractor(item) ?: continue
            out += buildToolFor(path, methodName, op)
        }
    }
    return out
}

private fun buildToolFor(
    path: String,
    method: String,
    op: Operation,
): ToolDescriptor {
    val properties = mutableMapOf<String, JsonObject>()
    val required = mutableListOf<String>()
    val paramLocations = mutableMapOf<String, String>()

    for (param in op.parameters.orEmpty()) {
        val schemaJson = schemaToJsonObject(param.schema)
        val annotated =
            if (!param.description.isNullOrBlank()) {
                buildJsonObject {
                    schemaJson.forEach { (k, v) -> put(k, v) }
                    put("description", JsonPrimitive(param.description))
                }
            } else {
                schemaJson
            }
        properties[param.name] = annotated
        paramLocations[param.name] = param.`in`
        if (param.required == true) required += param.name
    }

    val jsonBody =
        op.requestBody
            ?.content
            ?.get("application/json")
            ?.schema
    if (jsonBody != null) {
        val schemaJson = schemaToJsonObject(jsonBody)
        properties["body"] =
            buildJsonObject {
                schemaJson.forEach { (k, v) -> put(k, v) }
                put("description", JsonPrimitive("Request body (application/json)."))
            }
        if (op.requestBody.required != false) required += "body"
    }

    val description =
        listOfNotNull(op.summary, op.description)
            .joinToString("\n\n")
            .ifBlank { "$method $path" }

    val schema =
        ToolSchema(
            properties = JsonObject(properties),
            required = required.ifEmpty { null },
        )

    return ToolDescriptor(
        name = op.operationId ?: "${method.lowercase()}_${path.replace(Regex("[/{}]"), "_")}",
        description = description,
        schema = schema,
        binding = RouteBinding(httpPath = path, httpMethod = method, paramLocations = paramLocations),
    )
}

/**
 * Convert a Swagger `Schema` to a kotlinx.serialization JsonObject for an MCP tool's input
 * schema. Serialize via Jackson (the same machinery Swagger uses internally), then reparse
 * with kotlinx. Round-trip is cheap and avoids hand-coding the conversion for every JSON
 * Schema construct.
 */
private fun schemaToJsonObject(schema: io.swagger.v3.oas.models.media.Schema<*>?): JsonObject {
    if (schema == null) return JsonObject(emptyMap())
    val rawJson = MAPPER.writeValueAsString(schema)
    return Json.parseToJsonElement(rawJson).jsonObject
}

// ──────────────────────── HTTP forwarder ────────────────────────

private fun forwardCall(
    binding: RouteBinding,
    args: JsonObject,
    proxyBase: String,
): Pair<Int, String> {
    var url = binding.httpPath
    val query = StringBuilder()
    var body: String? = null

    for ((key, value) in args) {
        when {
            key == "body" -> {
                body = value.toString()
            }

            binding.paramLocations[key] == "path" -> {
                val raw = stringify(value)
                url = url.replace("{$key}", URLEncoder.encode(raw, StandardCharsets.UTF_8))
            }

            else -> {
                if (query.isNotEmpty()) query.append('&')
                query.append(URLEncoder.encode(key, StandardCharsets.UTF_8))
                query.append('=')
                query.append(URLEncoder.encode(stringify(value), StandardCharsets.UTF_8))
            }
        }
    }

    val full = "$proxyBase$url" + if (query.isNotEmpty()) "?$query" else ""
    val builder =
        HttpRequest
            .newBuilder(URI.create(full))
            .timeout(Duration.ofSeconds(RESPONSE_TIMEOUT_SECONDS))
    if (body != null) {
        builder.method(binding.httpMethod, HttpRequest.BodyPublishers.ofString(body))
        builder.header("Content-Type", "application/json")
    } else {
        builder.method(binding.httpMethod, HttpRequest.BodyPublishers.noBody())
    }

    val response = HTTP.send(builder.build(), HttpResponse.BodyHandlers.ofString())
    return response.statusCode() to response.body()
}

/** Strip the surrounding quotes JsonPrimitive.toString adds for string values. */
private fun stringify(value: kotlinx.serialization.json.JsonElement): String =
    when (value) {
        is JsonPrimitive -> {
            if (value.isString) value.content else value.toString()
        }

        else -> {
            value.toString()
        }
    }
