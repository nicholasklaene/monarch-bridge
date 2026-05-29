package com.nicholasklaene.monarchbridge.graphql

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.Account
import com.nicholasklaene.monarchbridge.generated.model.Institution
import com.nicholasklaene.monarchbridge.generated.model.MerchantRef
import com.nicholasklaene.monarchbridge.generated.model.Ref
import com.nicholasklaene.monarchbridge.generated.model.TagRef
import com.nicholasklaene.monarchbridge.generated.model.Transaction
import com.nicholasklaene.monarchbridge.generated.model.TransactionAccountRef
import java.time.LocalDate

/**
 * Shared JSON → spec-generated-DTO mappers. Operations call into these helpers so the
 * field-by-field mapping for shared leaf types (Account, Transaction, ...) only lives
 * in one place. Each helper is intentionally tolerant of missing fields — Monarch's
 * GraphQL responses occasionally omit nullable subtrees.
 */
object JsonMappers {
    fun parseAccount(node: JsonNode): Account =
        Account(
            id = node.path("id").asText(""),
            displayName = node.path("displayName").asText(""),
            type = node.path("type").path("name").asTextOrNull(),
            subtype = node.path("subtype").path("name").asTextOrNull(),
            mask = node.path("mask").asTextOrNull(),
            currentBalance = node.path("currentBalance").asDoubleOrNull(),
            displayBalance = node.path("displayBalance").asDoubleOrNull(),
            isHidden = node.path("isHidden").asBoolean(false),
            hideFromList = node.path("hideFromList").asBoolean(false),
            includeInNetWorth = node.path("includeInNetWorth").asBoolean(false),
            isAsset = node.path("isAsset").asBoolean(false),
            isManual = node.path("isManual").asBoolean(false),
            institution = node.pathOrNull("institution")?.let(::parseInstitution),
        )

    fun parseInstitution(node: JsonNode): Institution =
        Institution(
            name = node.path("name").asText(""),
            id = node.path("id").asTextOrNull(),
            primaryColor = node.path("primaryColor").asTextOrNull(),
            url = node.path("url").asTextOrNull(),
            plaidInstitutionId = node.path("plaidInstitutionId").asTextOrNull(),
        )

    fun parseTransaction(node: JsonNode): Transaction =
        Transaction(
            id = node.path("id").asText(""),
            date = LocalDate.parse(node.path("date").asText("1970-01-01")),
            amount = node.path("amount").asDouble(0.0),
            pending = node.path("pending").asBoolean(false),
            plaidName = node.path("plaidName").asTextOrNull(),
            notes = node.path("notes").asTextOrNull(),
            hideFromReports = node.path("hideFromReports").asBoolean(false),
            needsReview = node.path("needsReview").asBoolean(false),
            isRecurring = node.path("isRecurring").asBoolean(false),
            isSplitTransaction = node.path("isSplitTransaction").asBoolean(false),
            createdAt = node.path("createdAt").asTextOrNull(),
            updatedAt = node.path("updatedAt").asTextOrNull(),
            account = node.pathOrNull("account")?.let(::parseTransactionAccountRef),
            merchant = node.pathOrNull("merchant")?.let(::parseMerchantRef),
            category = node.pathOrNull("category")?.let(::parseRef),
            tags = node.path("tags").takeIf { it.isArray }?.map(::parseTagRef) ?: emptyList(),
        )

    fun parseTransactionAccountRef(node: JsonNode): TransactionAccountRef =
        TransactionAccountRef(
            id = node.path("id").asText(""),
            displayName = node.path("displayName").asTextOrNull(),
        )

    fun parseMerchantRef(node: JsonNode): MerchantRef =
        MerchantRef(
            id = node.path("id").asText(""),
            name = node.path("name").asTextOrNull(),
            transactionsCount = node.path("transactionsCount").asInt(0),
        )

    fun parseRef(node: JsonNode): Ref =
        Ref(
            id = node.path("id").asText(""),
            name = node.path("name").asTextOrNull(),
        )

    fun parseTagRef(node: JsonNode): TagRef =
        TagRef(
            id = node.path("id").asText(""),
            name = node.path("name").asText(""),
            color = node.path("color").asTextOrNull(),
            order = node.path("order").takeIf { it.isInt }?.asInt(),
        )
}
