package com.nicholasklaene.monarchbridge.graphql.operations.paychecks

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ListPaychecksResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * List paychecks within an optional date window plus optional owner / employer filters.
 *
 * Mirrors Monarch's `paychecks(...)` root query. The full `PaycheckFields` fragment
 * (deductions + deposits + employer + owner) is requested every time - paychecks are
 * low-cardinality and the breakdown is the whole point of fetching one.
 */
object GetPaychecks : MonarchOperation<GetPaychecks.Input, ListPaychecksResponseData> {
    override val operationName: String = "Common_GetPaychecks"
    override val query: String by lazy {
        GraphQLLoader.load(
            operationName,
            fragments = listOf("PaycheckFields", "PaycheckDeductionFields", "PaycheckDepositFields"),
        )
    }

    data class Input(
        val startDate: String? = null,
        val endDate: String? = null,
        val ownerId: String? = null,
        val employerId: String? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "startDate" to input.startDate,
            "endDate" to input.endDate,
            "ownerId" to input.ownerId,
            "employerId" to input.employerId,
        )

    override fun parseOutput(data: JsonNode): ListPaychecksResponseData =
        ListPaychecksResponseData(
            paychecks = data.path("paychecks").map(PaycheckJsonMappers::parsePaycheck),
        )
}
