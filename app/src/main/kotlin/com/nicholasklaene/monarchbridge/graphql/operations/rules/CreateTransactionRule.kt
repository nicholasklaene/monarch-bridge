package com.nicholasklaene.monarchbridge.graphql.operations.rules

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRuleRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRuleResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Persist a new auto-categorization rule. Monarch's `createTransactionRuleV2` mutation does
 * not return the saved rule body — only errors. On success the proxy returns
 * `{created: true}`; callers can refetch the rules list to inspect the saved form.
 */
object CreateTransactionRule : MonarchOperation<CreateTransactionRule.Input, CreateTransactionRuleResponseData> {
    override val operationName: String = "Common_CreateTransactionRuleMutationV2"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val rule: CreateTransactionRuleRequest,
    ) {
        companion object {
            fun from(req: CreateTransactionRuleRequest): Input = Input(rule = req)
        }
    }

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to TransactionRuleInputMapper.toInputMap(input.rule))

    override fun parseOutput(data: JsonNode): CreateTransactionRuleResponseData =
        CreateTransactionRuleResponseData(
            // Mutation reaches here only if no PayloadError was thrown by MonarchClient; treat as success.
            created = true,
        )
}
