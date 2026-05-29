package com.nicholasklaene.monarchbridge.graphql.operations.paychecks

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckResponseData
import com.nicholasklaene.monarchbridge.generated.model.PaycheckDeductionInput
import com.nicholasklaene.monarchbridge.generated.model.PaycheckDepositInput
import com.nicholasklaene.monarchbridge.generated.model.UpdatePaycheckRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Partial-update one paycheck. Only fields the caller sets are forwarded to Monarch
 * (matching `UpdatePaycheckInput` PATCH semantics). When `deductions` / `deposits`
 * are sent, they wholesale-replace the existing lists.
 *
 * Returns the spec-generated `CreatePaycheckResponseData` envelope; the generator
 * dedupes identical `{paycheck: Paycheck}` shapes under the first-seen name.
 */
object UpdatePaycheck : MonarchOperation<UpdatePaycheck.Input, CreatePaycheckResponseData> {
    override val operationName: String = "Common_UpdatePaycheck"
    override val query: String by lazy {
        GraphQLLoader.load(
            operationName,
            fragments = listOf("PaycheckFields", "PaycheckDeductionFields", "PaycheckDepositFields"),
        )
    }

    data class Input(
        val id: String,
        val req: UpdatePaycheckRequest,
    ) {
        companion object {
            fun from(
                id: String,
                req: UpdatePaycheckRequest,
            ): Input = Input(id = id, req = req)
        }
    }

    @Suppress("CyclomaticComplexMethod")
    override fun variables(input: Input): Map<String, Any?> {
        val payload =
            buildMap<String, Any?> {
                put("id", input.id)
                input.req.employerId?.let { put("employerId", it) }
                input.req.grossAmount?.let { put("grossAmount", it) }
                input.req.payDate?.let { put("payDate", it) }
                input.req.payPeriodStart?.let { put("payPeriodStart", it) }
                input.req.payPeriodEnd?.let { put("payPeriodEnd", it) }
                input.req.payrollProvider?.let { put("payrollProvider", it) }
                input.req.ownerId?.let { put("ownerId", it) }
                input.req.deductions?.let { put("deductions", it.map(::deductionToMap)) }
                input.req.deposits?.let { put("deposits", it.map(::depositToMap)) }
            }
        return mapOf("input" to payload)
    }

    override fun parseOutput(data: JsonNode): CreatePaycheckResponseData =
        CreatePaycheckResponseData(
            paycheck = PaycheckJsonMappers.parsePaycheck(data.path("updatePaycheck").path("paycheck")),
        )

    private fun deductionToMap(d: PaycheckDeductionInput): Map<String, Any?> =
        buildMap {
            put("deductionType", d.deductionType)
            put("amount", d.amount)
            d.customDeductionName?.let { put("customDeductionName", it) }
        }

    private fun depositToMap(d: PaycheckDepositInput): Map<String, Any?> = mapOf("transactionId" to d.transactionId)
}
