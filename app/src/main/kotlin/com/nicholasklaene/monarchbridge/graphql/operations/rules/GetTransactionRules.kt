package com.nicholasklaene.monarchbridge.graphql.operations.rules

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ListTransactionRulesResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * List all auto-categorization rules for the household, in display order. Each rule is
 * parsed via [RuleJsonMappers.parseRule]. Output is the spec-generated
 * [ListTransactionRulesResponseData].
 */
object GetTransactionRules : MonarchOperation<Unit, ListTransactionRulesResponseData> {
    override val operationName: String = "GetTransactionRules"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("TransactionRuleFields"))
    }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): ListTransactionRulesResponseData =
        ListTransactionRulesResponseData(
            rules = data.path("transactionRules").map(RuleJsonMappers::parseRule),
        )
}
