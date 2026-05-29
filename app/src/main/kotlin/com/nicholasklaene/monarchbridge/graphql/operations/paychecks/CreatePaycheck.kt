package com.nicholasklaene.monarchbridge.graphql.operations.paychecks

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckRequest
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckResponseData
import com.nicholasklaene.monarchbridge.generated.model.PaycheckDeductionInput
import com.nicholasklaene.monarchbridge.generated.model.PaycheckDepositInput
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Create a paycheck. Wraps Monarch's `createPaycheck` mutation. `employerId` must
 * already exist (clients POST to `/v1/paycheck-employers` first).
 *
 * Both `deductions` and `deposits` lists are optional - send them at create time
 * or fill them in later via PATCH.
 */
object CreatePaycheck : MonarchOperation<CreatePaycheck.Input, CreatePaycheckResponseData> {
    override val operationName: String = "Common_CreatePaycheck"
    override val query: String by lazy {
        GraphQLLoader.load(
            operationName,
            fragments = listOf("PaycheckFields", "PaycheckDeductionFields", "PaycheckDepositFields"),
        )
    }

    data class Input(
        val employerId: String,
        val grossAmount: Double,
        val payDate: String,
        val payPeriodStart: String? = null,
        val payPeriodEnd: String? = null,
        val payrollProvider: String? = null,
        val ownerId: String? = null,
        val deductions: List<PaycheckDeductionInput>? = null,
        val deposits: List<PaycheckDepositInput>? = null,
    ) {
        companion object {
            fun from(req: CreatePaycheckRequest): Input =
                Input(
                    employerId = req.employerId,
                    grossAmount = req.grossAmount,
                    payDate = req.payDate,
                    payPeriodStart = req.payPeriodStart,
                    payPeriodEnd = req.payPeriodEnd,
                    payrollProvider = req.payrollProvider,
                    ownerId = req.ownerId,
                    deductions = req.deductions,
                    deposits = req.deposits,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val payload =
            buildMap<String, Any?> {
                put("employerId", input.employerId)
                put("grossAmount", input.grossAmount)
                put("payDate", input.payDate)
                input.payPeriodStart?.let { put("payPeriodStart", it) }
                input.payPeriodEnd?.let { put("payPeriodEnd", it) }
                input.payrollProvider?.let { put("payrollProvider", it) }
                input.ownerId?.let { put("ownerId", it) }
                input.deductions?.let { put("deductions", it.map(::deductionToMap)) }
                input.deposits?.let { put("deposits", it.map(::depositToMap)) }
            }
        return mapOf("input" to payload)
    }

    override fun parseOutput(data: JsonNode): CreatePaycheckResponseData =
        CreatePaycheckResponseData(
            paycheck = PaycheckJsonMappers.parsePaycheck(data.path("createPaycheck").path("paycheck")),
        )

    private fun deductionToMap(d: PaycheckDeductionInput): Map<String, Any?> =
        buildMap {
            put("deductionType", d.deductionType)
            put("amount", d.amount)
            d.customDeductionName?.let { put("customDeductionName", it) }
        }

    private fun depositToMap(d: PaycheckDepositInput): Map<String, Any?> = mapOf("transactionId" to d.transactionId)
}
