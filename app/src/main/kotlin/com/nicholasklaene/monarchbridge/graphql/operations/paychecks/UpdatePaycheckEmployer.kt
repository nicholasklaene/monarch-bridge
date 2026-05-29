package com.nicholasklaene.monarchbridge.graphql.operations.paychecks

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckEmployerResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdatePaycheckEmployerRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Rename an existing paycheck-employer entry. Wraps Monarch's
 * `updatePaycheckEmployer` mutation.
 *
 * Returns the spec-generated `CreatePaycheckEmployerResponseData` envelope -
 * the generator dedupes identical `{employer: PaycheckEmployer}` shapes under
 * the first-seen name.
 */
object UpdatePaycheckEmployer : MonarchOperation<UpdatePaycheckEmployer.Input, CreatePaycheckEmployerResponseData> {
    override val operationName: String = "Common_UpdatePaycheckEmployer"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
        val name: String,
    ) {
        companion object {
            fun from(
                id: String,
                req: UpdatePaycheckEmployerRequest,
            ): Input = Input(id = id, name = req.name)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "id" to input.id,
                    "name" to input.name,
                ),
        )

    override fun parseOutput(data: JsonNode): CreatePaycheckEmployerResponseData =
        CreatePaycheckEmployerResponseData(
            employer = PaycheckJsonMappers.parseEmployer(data.path("updatePaycheckEmployer").path("employer")),
        )
}
