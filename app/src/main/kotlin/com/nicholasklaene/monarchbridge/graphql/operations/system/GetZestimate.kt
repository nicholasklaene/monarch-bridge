package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetZestimateRequest
import com.nicholasklaene.monarchbridge.generated.model.GetZestimateResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetZestimateResponseDataZestimatesInner
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Zillow Zestimate lookup for a free-form address. Returns 0+ matches. */
object GetZestimate : MonarchOperation<GetZestimate.Input, GetZestimateResponseData> {
    override val operationName: String = "Web_GetZestimate"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val address: String,
    ) {
        companion object {
            fun from(req: GetZestimateRequest): Input = Input(address = req.address)
        }
    }

    override fun variables(input: Input): Map<String, Any?> = mapOf("address" to input.address)

    override fun parseOutput(data: JsonNode): GetZestimateResponseData =
        GetZestimateResponseData(
            zestimates =
                data.path("zestimates").map { z ->
                    GetZestimateResponseDataZestimatesInner(
                        zpid = z.path("zpid").asTextOrNull(),
                        addressStreet = z.path("addressStreet").asTextOrNull(),
                        addressCity = z.path("addressCity").asTextOrNull(),
                        addressStateAbbr = z.path("addressStateAbbr").asTextOrNull(),
                        addressPostalCode = z.path("addressPostalCode").asTextOrNull(),
                        zestimate = z.path("zestimate").asDoubleOrNull(),
                    )
                },
        )
}
