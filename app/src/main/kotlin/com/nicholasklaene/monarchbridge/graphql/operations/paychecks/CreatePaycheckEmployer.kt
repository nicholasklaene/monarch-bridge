package com.nicholasklaene.monarchbridge.graphql.operations.paychecks

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckEmployerRequest
import com.nicholasklaene.monarchbridge.generated.model.CreatePaycheckEmployerResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Create a new paycheck-employer entry. Pure name registry; clients then reference
 * the returned id from `CreatePaycheckRequest.employerId`.
 */
object CreatePaycheckEmployer : MonarchOperation<CreatePaycheckEmployer.Input, CreatePaycheckEmployerResponseData> {
    override val operationName: String = "Common_CreatePaycheckEmployer"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val name: String,
    ) {
        companion object {
            fun from(req: CreatePaycheckEmployerRequest): Input = Input(name = req.name)
        }
    }

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("name" to input.name))

    override fun parseOutput(data: JsonNode): CreatePaycheckEmployerResponseData =
        CreatePaycheckEmployerResponseData(
            employer = PaycheckJsonMappers.parseEmployer(data.path("createPaycheckEmployer").path("employer")),
        )
}
