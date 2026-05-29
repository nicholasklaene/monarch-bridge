package com.nicholasklaene.monarchbridge.graphql.operations.rules

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRuleRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionRuleResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Replace the criteria + actions on an existing rule. Like create, Monarch's
 * `updateTransactionRuleV2` mutation only returns errors; success is signaled with
 * `{updated: true}`. Path `{id}` is injected into the GraphQL `input` variable by the proxy.
 */
object UpdateTransactionRule : MonarchOperation<UpdateTransactionRule.Input, UpdateTransactionRuleResponseData> {
    override val operationName: String = "Common_UpdateTransactionRuleMutationV2"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val id: String,
        val rule: CreateTransactionRuleRequest,
    ) {
        companion object {
            fun from(
                id: String,
                req: CreateTransactionRuleRequest,
            ): Input = Input(id = id, rule = req)
        }
    }

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to TransactionRuleInputMapper.toInputMap(input.rule, input.id))

    override fun parseOutput(data: JsonNode): UpdateTransactionRuleResponseData = UpdateTransactionRuleResponseData(updated = true)
}
