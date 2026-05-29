package com.nicholasklaene.monarchbridge.graphql.operations.paychecks

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.Paycheck
import com.nicholasklaene.monarchbridge.generated.model.PaycheckCreatedBy
import com.nicholasklaene.monarchbridge.generated.model.PaycheckDeduction
import com.nicholasklaene.monarchbridge.generated.model.PaycheckDeposit
import com.nicholasklaene.monarchbridge.generated.model.PaycheckDepositTransaction
import com.nicholasklaene.monarchbridge.generated.model.PaycheckDepositTransactionAccount
import com.nicholasklaene.monarchbridge.generated.model.PaycheckDepositTransactionMerchant
import com.nicholasklaene.monarchbridge.generated.model.PaycheckEmployer
import com.nicholasklaene.monarchbridge.generated.model.PaycheckEmployerRef
import com.nicholasklaene.monarchbridge.generated.model.PaycheckOwner
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull

/**
 * Shared parsers for the Paycheck object graph. Used by every `*Operation.parseOutput`
 * in this package so the Paycheck shape is parsed identically everywhere.
 *
 * Field selection mirrors the `PaycheckFields` GraphQL fragment from Monarch's web
 * bundle. Optional nested objects (employer, owner, createdBy) are flagged via
 * `pathOrNull` so a missing-vs-null distinction is preserved.
 */
internal object PaycheckJsonMappers {
    fun parsePaycheck(node: JsonNode): Paycheck =
        Paycheck(
            id = node.path("id").asText(""),
            grossAmount = node.path("grossAmount").asDouble(0.0),
            payDate = node.path("payDate").asText(""),
            employer = node.pathOrNull("employer")?.let(::parseEmployerRef),
            employerName = node.path("employerName").asTextOrNull(),
            payrollProvider = node.path("payrollProvider").asTextOrNull(),
            payPeriodStart = node.path("payPeriodStart").asTextOrNull(),
            payPeriodEnd = node.path("payPeriodEnd").asTextOrNull(),
            createdAt = node.path("createdAt").asTextOrNull(),
            isMagicImported = node.path("isMagicImported").let { if (it.isBoolean) it.asBoolean() else null },
            owner = node.pathOrNull("owner")?.let(::parseOwner),
            createdBy = node.pathOrNull("createdBy")?.let(::parseCreatedBy),
            deductions = node.pathOrNull("deductions")?.takeIf { it.isArray }?.map(::parseDeduction) ?: emptyList(),
            deposits = node.pathOrNull("deposits")?.takeIf { it.isArray }?.map(::parseDeposit) ?: emptyList(),
        )

    fun parseEmployer(node: JsonNode): PaycheckEmployer =
        PaycheckEmployer(
            id = node.path("id").asText(""),
            name = node.path("name").asText(""),
            paycheckCount = node.path("paycheckCount").asIntOrNull(),
            createdAt = node.path("createdAt").asTextOrNull(),
        )

    private fun parseEmployerRef(node: JsonNode): PaycheckEmployerRef =
        PaycheckEmployerRef(
            id = node.path("id").asText(""),
            name = node.path("name").asTextOrNull(),
        )

    private fun parseOwner(node: JsonNode): PaycheckOwner =
        PaycheckOwner(
            id = node.path("id").asText(""),
            name = node.path("name").asTextOrNull(),
            profilePictureUrl = node.path("profilePictureUrl").asTextOrNull(),
        )

    private fun parseCreatedBy(node: JsonNode): PaycheckCreatedBy =
        PaycheckCreatedBy(
            id = node.path("id").asText(""),
            name = node.path("name").asTextOrNull(),
        )

    private fun parseDeduction(node: JsonNode): PaycheckDeduction =
        PaycheckDeduction(
            id = node.path("id").asText(""),
            deductionType = node.path("deductionType").asText(""),
            amount = node.path("amount").asDouble(0.0),
            customDeductionName = node.path("customDeductionName").asTextOrNull(),
            createdAt = node.path("createdAt").asTextOrNull(),
        )

    private fun parseDeposit(node: JsonNode): PaycheckDeposit =
        PaycheckDeposit(
            id = node.path("id").asText(""),
            transaction = node.pathOrNull("transaction")?.let(::parseDepositTransaction),
            createdAt = node.path("createdAt").asTextOrNull(),
        )

    private fun parseDepositTransaction(node: JsonNode): PaycheckDepositTransaction =
        PaycheckDepositTransaction(
            id = node.path("id").asText(""),
            amount = node.path("amount").asDoubleOrNull(),
            date = node.path("date").asTextOrNull(),
            merchant =
                node.pathOrNull("merchant")?.let { m ->
                    PaycheckDepositTransactionMerchant(
                        id = m.path("id").asTextOrNull(),
                        name = m.path("name").asTextOrNull(),
                    )
                },
            account =
                node.pathOrNull("account")?.let { a ->
                    PaycheckDepositTransactionAccount(
                        id = a.path("id").asTextOrNull(),
                        displayName = a.path("displayName").asTextOrNull(),
                    )
                },
        )
}
