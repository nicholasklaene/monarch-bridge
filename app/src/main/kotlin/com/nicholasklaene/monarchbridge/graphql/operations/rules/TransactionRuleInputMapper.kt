package com.nicholasklaene.monarchbridge.graphql.operations.rules

import com.nicholasklaene.monarchbridge.generated.model.CreateTransactionRuleRequest
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleAmountCriterion
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleAmountRange
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleSplitAction
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleSplitInfo
import com.nicholasklaene.monarchbridge.generated.model.TransactionRuleStringCriterion
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/**
 * Shared mapper from the spec-generated [CreateTransactionRuleRequest] DTO into a GraphQL
 * `input` variable map for Monarch's `CreateTransactionRuleInput` /
 * `UpdateTransactionRuleInput` / `TransactionRulePreviewInput`. All three Monarch inputs
 * accept the same field surface, so one mapper covers create + update + preview; the only
 * delta is whether `id` is injected (update only).
 *
 * The generator emits two equivalent classes (`TransactionRuleRequest` and
 * `CreateTransactionRuleRequest`) from the same schema because the body param's name
 * collides with the schema name. The Rules API methods take the `CreateTransactionRuleRequest`
 * shape so that's what this mapper accepts.
 *
 * Each input field is forwarded verbatim if non-null and dropped otherwise. Monarch
 * distinguishes "field absent" (leave unchanged) from "field present and null" (clear it).
 */
internal object TransactionRuleInputMapper {
    /** Build the `input` variable for a Monarch rule mutation/query. */
    fun toInputMap(
        req: CreateTransactionRuleRequest,
        id: String? = null,
    ): Map<String, Any?> =
        mapOfNotNull(
            "id" to id,
            "merchantCriteriaUseOriginalStatement" to req.merchantCriteriaUseOriginalStatement,
            "merchantCriteria" to req.merchantCriteria?.map(::stringCriterionToMap),
            "originalStatementCriteria" to req.originalStatementCriteria?.map(::stringCriterionToMap),
            "merchantNameCriteria" to req.merchantNameCriteria?.map(::stringCriterionToMap),
            "amountCriteria" to req.amountCriteria?.let(::amountCriterionToMap),
            "categoryIds" to req.categoryIds,
            "accountIds" to req.accountIds,
            "criteriaOwnerIsJoint" to req.criteriaOwnerIsJoint,
            "criteriaOwnerUserIds" to req.criteriaOwnerUserIds,
            "criteriaBusinessEntityIds" to req.criteriaBusinessEntityIds,
            "criteriaBusinessEntityIsUnassigned" to req.criteriaBusinessEntityIsUnassigned,
            "setMerchantAction" to req.setMerchantAction,
            "setCategoryAction" to req.setCategoryAction,
            "addTagsAction" to req.addTagsAction,
            "linkGoalAction" to req.linkGoalAction,
            "linkSavingsGoalAction" to req.linkSavingsGoalAction,
            "needsReviewByUserAction" to req.needsReviewByUserAction,
            "unassignNeedsReviewByUserAction" to req.unassignNeedsReviewByUserAction,
            "sendNotificationAction" to req.sendNotificationAction,
            "setHideFromReportsAction" to req.setHideFromReportsAction,
            "setLinkToPaydownBudgetAction" to req.setLinkToPaydownBudgetAction,
            "reviewStatusAction" to req.reviewStatusAction,
            "actionSetOwnerIsJoint" to req.actionSetOwnerIsJoint,
            "actionSetOwner" to req.actionSetOwner,
            "actionSetBusinessEntity" to req.actionSetBusinessEntity,
            "actionSetBusinessEntityIsUnassigned" to req.actionSetBusinessEntityIsUnassigned,
            "splitTransactionsAction" to req.splitTransactionsAction?.let(::splitActionToMap),
        )

    private fun stringCriterionToMap(c: TransactionRuleStringCriterion): Map<String, Any?> =
        mapOfNotNull("operator" to c.`operator`, "value" to c.value)

    private fun amountCriterionToMap(c: TransactionRuleAmountCriterion): Map<String, Any?> =
        mapOfNotNull(
            "operator" to c.`operator`,
            "isExpense" to c.isExpense,
            "value" to c.value,
            "valueRange" to c.valueRange?.let(::amountRangeToMap),
        )

    private fun amountRangeToMap(r: TransactionRuleAmountRange): Map<String, Any?> = mapOfNotNull("lower" to r.lower, "upper" to r.upper)

    private fun splitActionToMap(a: TransactionRuleSplitAction): Map<String, Any?> =
        mapOf(
            "amountType" to a.amountType,
            "splitsInfo" to a.splitsInfo.orEmpty().map(::splitInfoToMap),
        )

    private fun splitInfoToMap(s: TransactionRuleSplitInfo): Map<String, Any?> =
        mapOfNotNull(
            "categoryId" to s.categoryId,
            "merchantName" to s.merchantName,
            "amount" to s.amount,
            "goalId" to s.goalId,
            "savingsGoalId" to s.savingsGoalId,
            "tags" to s.tags,
            "hideFromReports" to s.hideFromReports,
            "reviewStatus" to s.reviewStatus,
            "needsReviewByUserId" to s.needsReviewByUserId,
            "ownerUserId" to s.ownerUserId,
            "ownerIsJoint" to s.ownerIsJoint,
            "businessEntityId" to s.businessEntityId,
            "businessEntityIsUnassigned" to s.businessEntityIsUnassigned,
        )
}
