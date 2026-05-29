package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.JsonMappers
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/**
 * Patch account fields. All Input fields except `id` are optional — only non-null fields
 * are included in the GraphQL `input` variable. Output is the spec-generated
 * [UpdateAccountResponseData].
 */
object UpdateAccount : MonarchOperation<UpdateAccount.Input, UpdateAccountResponseData> {
    override val operationName: String = "Common_UpdateAccount"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("AccountFields", "PayloadErrorFields"))
    }

    data class Input(
        val id: String,
        val name: String? = null,
        val displayBalance: Double? = null,
        val type: String? = null,
        val subtype: String? = null,
        val includeInNetWorth: Boolean? = null,
        val hideFromList: Boolean? = null,
        val hideTransactionsFromReports: Boolean? = null,
    ) {
        companion object {
            fun from(
                id: String,
                req: UpdateAccountRequest,
            ): Input =
                Input(
                    id = id,
                    name = req.name,
                    displayBalance = req.displayBalance,
                    type = req.type,
                    subtype = req.subtype,
                    includeInNetWorth = req.includeInNetWorth,
                    hideFromList = req.hideFromList,
                    hideTransactionsFromReports = req.hideTransactionsFromReports,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOfNotNull(
                    "id" to input.id,
                    "name" to input.name,
                    "displayBalance" to input.displayBalance,
                    "type" to input.type,
                    "subtype" to input.subtype,
                    "includeInNetWorth" to input.includeInNetWorth,
                    "hideFromList" to input.hideFromList,
                    "hideTransactionsFromReports" to input.hideTransactionsFromReports,
                ),
        )

    override fun parseOutput(data: JsonNode): UpdateAccountResponseData =
        UpdateAccountResponseData(
            account = JsonMappers.parseAccount(data.path("updateAccount").path("account")),
        )
}
