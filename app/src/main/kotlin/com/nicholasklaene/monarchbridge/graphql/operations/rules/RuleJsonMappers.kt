package com.nicholasklaene.monarchbridge.graphql.operations.rules

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.Ref
import com.nicholasklaene.monarchbridge.generated.model.Transaction
import com.nicholasklaene.monarchbridge.generated.model.TransactionRule
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleAmountCriterion
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleAmountRange
import com.nicholasklaene.monarchbridge.generated.model.TransactionRulePreviewMatch
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleSplitAction
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleSplitInfo
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleStringCriterion
import com.nicholasklaene.monarchbridge.graphql.JsonMappers
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull
import java.time.LocalDate

/**
 * Shared parsers for the transaction-rules surface — used by [GetTransactionRules] and
 * [PreviewTransactionRule]. Lives next to the operations rather than in the cross-resource
 * [JsonMappers] because the schema is rules-specific.
 *
 * Every field is forgiving — `pathOrNull` / `asTextOrNull` everywhere so partial Monarch
 * responses (which happen any time the user hasn't configured a criterion / action) parse
 * cleanly into nullable fields.
 */
internal object RuleJsonMappers {
    // Shared, thread-safe Jackson mapper reused across every parseFreeFormMap call instead of
    // allocating a fresh ObjectMapper per invocation. The TypeReference makes convertValue return
    // a properly typed Map<String, Any>, so no unchecked cast is needed.
    private val MAPPER = jacksonObjectMapper()
    private val FREE_FORM_MAP_TYPE = object : TypeReference<Map<String, Any>>() {}

    @Suppress("LongMethod")
    fun parseRule(node: JsonNode): TransactionRule =
        TransactionRule(
            id = node.path("id").asText(""),
            order = node.path("order").asIntOrNull(),
            merchantCriteriaUseOriginalStatement = node.path("merchantCriteriaUseOriginalStatement").asBooleanOrNull(),
            merchantCriteria = node.pathOrNull("merchantCriteria")?.map(::parseStringCriterion),
            originalStatementCriteria = node.pathOrNull("originalStatementCriteria")?.map(::parseStringCriterion),
            merchantNameCriteria = node.pathOrNull("merchantNameCriteria")?.map(::parseStringCriterion),
            amountCriteria = node.pathOrNull("amountCriteria")?.let(::parseAmountCriterion),
            categoryIds = node.pathOrNull("categoryIds")?.mapNotNull { it.asTextOrNull() },
            accountIds = node.pathOrNull("accountIds")?.mapNotNull { it.asTextOrNull() },
            criteriaOwnerIsJoint = node.path("criteriaOwnerIsJoint").asBooleanOrNull(),
            criteriaOwnerUserIds = node.pathOrNull("criteriaOwnerUserIds")?.mapNotNull { it.asTextOrNull() },
            criteriaBusinessEntityIds = node.pathOrNull("criteriaBusinessEntityIds")?.mapNotNull { it.asTextOrNull() },
            criteriaBusinessEntityIsUnassigned = node.path("criteriaBusinessEntityIsUnassigned").asBooleanOrNull(),
            setMerchantAction = node.pathOrNull("setMerchantAction")?.let(JsonMappers::parseRef),
            setCategoryAction = node.pathOrNull("setCategoryAction")?.let(JsonMappers::parseRef),
            addTagsAction = node.pathOrNull("addTagsAction")?.map(JsonMappers::parseRef),
            linkGoalAction = node.pathOrNull("linkGoalAction")?.let(JsonMappers::parseRef),
            linkSavingsGoalAction = node.pathOrNull("linkSavingsGoalAction")?.let(JsonMappers::parseRef),
            needsReviewByUserAction = node.pathOrNull("needsReviewByUserAction")?.let(::parseUserRef),
            unassignNeedsReviewByUserAction = node.path("unassignNeedsReviewByUserAction").asBooleanOrNull(),
            sendNotificationAction = node.path("sendNotificationAction").asBooleanOrNull(),
            setHideFromReportsAction = node.path("setHideFromReportsAction").asBooleanOrNull(),
            setLinkToPaydownBudgetAction = node.path("setLinkToPaydownBudgetAction").asBooleanOrNull(),
            reviewStatusAction = node.path("reviewStatusAction").asTextOrNull(),
            actionSetOwnerIsJoint = node.path("actionSetOwnerIsJoint").asBooleanOrNull(),
            actionSetOwner = node.pathOrNull("actionSetOwner")?.let(::parseUserRef),
            actionSetBusinessEntity = node.pathOrNull("actionSetBusinessEntity")?.let(JsonMappers::parseRef),
            actionSetBusinessEntityIsUnassigned = node.path("actionSetBusinessEntityIsUnassigned").asBooleanOrNull(),
            recentApplicationCount = node.path("recentApplicationCount").asIntOrNull(),
            lastAppliedAt = node.path("lastAppliedAt").asTextOrNull(),
            splitTransactionsAction = node.pathOrNull("splitTransactionsAction")?.let(::parseSplitAction),
        )

    fun parsePreviewMatch(node: JsonNode): TransactionRulePreviewMatch =
        TransactionRulePreviewMatch(
            transaction = node.pathOrNull("transaction")?.let(::parsePreviewTransaction),
            newName = node.path("newName").asTextOrNull(),
            newSplitTransactions = node.pathOrNull("newSplitTransactions")?.map(::parseFreeFormMap),
            newCategory = node.pathOrNull("newCategory")?.let(JsonMappers::parseRef),
            newOwnerIsJoint = node.path("newOwnerIsJoint").asBooleanOrNull(),
            newHideFromReports = node.path("newHideFromReports").asBooleanOrNull(),
            newTags = node.pathOrNull("newTags")?.map(JsonMappers::parseRef),
            newGoal = node.pathOrNull("newGoal")?.let(JsonMappers::parseRef),
            newBusinessEntity = node.pathOrNull("newBusinessEntity")?.let(JsonMappers::parseRef),
            newBusinessEntityIsUnassigned = node.path("newBusinessEntityIsUnassigned").asBooleanOrNull(),
        )

    /**
     * The preview's `transaction` shape is a slim subset of Transaction (missing fields like
     * pending / notes / etc.). Parse what's there and let the rest default to null/false.
     */
    private fun parsePreviewTransaction(node: JsonNode): Transaction =
        Transaction(
            id = node.path("id").asText(""),
            date = LocalDate.parse(node.path("date").asText("1970-01-01")),
            amount = node.path("amount").asDouble(0.0),
            account = null,
            merchant = node.pathOrNull("merchant")?.let(JsonMappers::parseMerchantRef),
            category = node.pathOrNull("category")?.let(JsonMappers::parseRef),
            tags = emptyList(),
        )

    private fun parseStringCriterion(node: JsonNode): TransactionRuleStringCriterion =
        TransactionRuleStringCriterion(
            `operator` = node.path("operator").asTextOrNull(),
            value = node.path("value").asTextOrNull(),
        )

    private fun parseAmountCriterion(node: JsonNode): TransactionRuleAmountCriterion =
        TransactionRuleAmountCriterion(
            `operator` = node.path("operator").asTextOrNull(),
            isExpense = node.path("isExpense").asBooleanOrNull(),
            value = node.path("value").asDoubleOrNull(),
            valueRange =
                node.pathOrNull("valueRange")?.let {
                    TransactionRuleAmountRange(lower = it.path("lower").asDoubleOrNull(), upper = it.path("upper").asDoubleOrNull())
                },
        )

    private fun parseSplitAction(node: JsonNode): TransactionRuleSplitAction =
        TransactionRuleSplitAction(
            amountType = node.path("amountType").asText(""),
            splitsInfo = node.path("splitsInfo").map(::parseSplitInfo),
        )

    private fun parseSplitInfo(node: JsonNode): TransactionRuleSplitInfo =
        TransactionRuleSplitInfo(
            categoryId = node.path("categoryId").asTextOrNull(),
            merchantName = node.path("merchantName").asTextOrNull(),
            amount = node.path("amount").asDoubleOrNull(),
            goalId = node.path("goalId").asTextOrNull(),
            savingsGoalId = node.path("savingsGoalId").asTextOrNull(),
            tags = node.pathOrNull("tags")?.mapNotNull { it.asTextOrNull() },
            hideFromReports = node.path("hideFromReports").asBooleanOrNull(),
            reviewStatus = node.path("reviewStatus").asTextOrNull(),
            needsReviewByUserId = node.path("needsReviewByUserId").asTextOrNull(),
            ownerUserId = node.path("ownerUserId").asTextOrNull(),
            ownerIsJoint = node.path("ownerIsJoint").asBooleanOrNull(),
            businessEntityId = node.path("businessEntityId").asTextOrNull(),
            businessEntityIsUnassigned = node.path("businessEntityIsUnassigned").asBooleanOrNull(),
        )

    /**
     * Adapt a Monarch User node (id + displayName) into the proxy's [Ref] shape. Monarch
     * uses `displayName` here, not `name`; the spec uses [Ref] (which has `name`) for these
     * fields since they're functionally equivalent.
     */
    private fun parseUserRef(node: JsonNode): Ref =
        Ref(
            id = node.path("id").asText(""),
            name = node.path("displayName").asTextOrNull(),
        )

    /** Convert a JsonNode to the generated `FreeForm` map. */
    private fun parseFreeFormMap(node: JsonNode): Map<String, Any> = MAPPER.convertValue(node, FREE_FORM_MAP_TYPE)
}
