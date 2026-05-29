package com.nicholasklaene.monarchbridge.graphql.operations.rules

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRuleRequest
import com.nicholasklaene.monarchbridge.generated.model.PreviewTransactionRuleResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Dry-run a rule shape — get back the transactions that *would* match if the rule were
 * saved, along with the proposed new values (new category, tags, name, etc.). No
 * persistence; useful for interactive rule-building. Output is the spec-generated
 * [PreviewTransactionRuleResponseData].
 */
object PreviewTransactionRule : MonarchOperation<PreviewTransactionRule.Input, PreviewTransactionRuleResponseData> {
    override val operationName: String = "Common_PreviewTransactionRule"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val rule: CreateTransactionRuleRequest,
        val offset: Int? = null,
    ) {
        companion object {
            fun from(
                req: CreateTransactionRuleRequest,
                offset: Int?,
            ): Input = Input(rule = req, offset = offset)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        buildMap {
            put("rule", TransactionRuleInputMapper.toInputMap(input.rule))
            if (input.offset != null) put("offset", input.offset)
        }

    override fun parseOutput(data: JsonNode): PreviewTransactionRuleResponseData {
        val preview = data.path("transactionRulePreview")
        return PreviewTransactionRuleResponseData(
            totalCount = preview.path("totalCount").asInt(0),
            results = preview.path("results").map(RuleJsonMappers::parsePreviewMatch),
        )
    }
}
