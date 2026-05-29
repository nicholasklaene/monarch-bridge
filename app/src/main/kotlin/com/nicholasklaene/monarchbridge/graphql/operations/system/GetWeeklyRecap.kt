package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.GetWeeklyRecapResponseData
import com.nicholasklaene.monarchbridge.generated.model.WeeklyRecap
import com.nicholasklaene.monarchbridge.generated.model.WeeklyRecapCard
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull
import java.time.LocalDate

/**
 * Auto-generated narrative recap for one week. Monarch backfills these on a schedule;
 * `recap` is null when the system has not yet produced one for the requested window.
 *
 * Both top-level `summary` and per-module `cards` are returned so callers can choose
 * between a one-liner and a structured breakdown. Per-card `metrics` and `richBlocks`
 * are pass-through free-form maps (the shape varies per `module`).
 */
object GetWeeklyRecap : MonarchOperation<GetWeeklyRecap.Input, GetWeeklyRecapResponseData> {
    override val operationName: String = "Common_GetWeeklyRecap"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: LocalDate,
        val endDate: LocalDate,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "startDate" to input.startDate.toString(),
            "endDate" to input.endDate.toString(),
        )

    override fun parseOutput(data: JsonNode): GetWeeklyRecapResponseData {
        val node = data.pathOrNull("recap") ?: return GetWeeklyRecapResponseData(recap = null)
        return GetWeeklyRecapResponseData(
            recap =
                WeeklyRecap(
                    id = node.path("id").asText(""),
                    dateRangeStart = LocalDate.parse(node.path("dateRangeStart").asText("1970-01-01")),
                    dateRangeEnd = LocalDate.parse(node.path("dateRangeEnd").asText("1970-01-01")),
                    summary = node.path("summary").asTextOrNull(),
                    sentiment = node.path("sentiment").asTextOrNull(),
                    createdAt = node.path("createdAt").asTextOrNull(),
                    updatedAt = node.path("updatedAt").asTextOrNull(),
                    cards =
                        node.path("cards").map { card ->
                            WeeklyRecapCard(
                                module = card.path("module").asText(""),
                                title = card.path("title").asTextOrNull(),
                                headline = card.path("headline").asTextOrNull(),
                                message = card.path("message").asTextOrNull(),
                                sentiment = card.path("sentiment").asTextOrNull(),
                                titleMarkdown = card.path("titleMarkdown").asTextOrNull(),
                                headlineMarkdown = card.path("headlineMarkdown").asTextOrNull(),
                                messageMarkdown = card.path("messageMarkdown").asTextOrNull(),
                                metrics = freeForm(card.pathOrNull("metrics")),
                                richBlocks = freeForm(card.pathOrNull("richBlocks")),
                            )
                        },
                ),
        )
    }

    private fun freeForm(node: JsonNode?): Map<String, Any>? = node?.takeIf { it.isObject }?.let { MAPPER.convertValue(it, MAP_TYPE) }

    private val MAPPER = jacksonObjectMapper()
    private val MAP_TYPE = object : TypeReference<Map<String, Any>>() {}
}
