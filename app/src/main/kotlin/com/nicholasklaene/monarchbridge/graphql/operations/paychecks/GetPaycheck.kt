package com.nicholasklaene.monarchbridge.graphql.operations.paychecks

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Fetch a single paycheck by id. Returns the spec-generated `CreatePaycheckResponseData`
 * envelope because the generator dedupes responses with identical `{paycheck: Paycheck}`
 * shape under the first-seen name; `getPaycheck`, `createPaycheck`, and `updatePaycheck`
 * all share it.
 */
object GetPaycheck : MonarchOperation<GetPaycheck.Input, CreatePaycheckResponseData> {
    override val operationName: String = "Common_GetPaycheck"
    override val query: String by lazy {
        GraphQLLoader.load(
            operationName,
            fragments = listOf("PaycheckFields", "PaycheckDeductionFields", "PaycheckDepositFields"),
        )
    }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): CreatePaycheckResponseData =
        CreatePaycheckResponseData(
            paycheck = PaycheckJsonMappers.parsePaycheck(data.path("paycheck")),
        )
}
