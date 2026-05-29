
# CreateTransactionRuleRequest

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **merchantCriteriaUseOriginalStatement** | **kotlin.Boolean** |  |  [optional] |
| **merchantCriteria** | [**kotlin.collections.List&lt;TransactionRuleStringCriterion&gt;**](TransactionRuleStringCriterion.md) |  |  [optional] |
| **originalStatementCriteria** | [**kotlin.collections.List&lt;TransactionRuleStringCriterion&gt;**](TransactionRuleStringCriterion.md) |  |  [optional] |
| **merchantNameCriteria** | [**kotlin.collections.List&lt;TransactionRuleStringCriterion&gt;**](TransactionRuleStringCriterion.md) |  |  [optional] |
| **amountCriteria** | [**TransactionRuleAmountCriterion**](TransactionRuleAmountCriterion.md) |  |  [optional] |
| **categoryIds** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **accountIds** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **criteriaOwnerIsJoint** | **kotlin.Boolean** |  |  [optional] |
| **criteriaOwnerUserIds** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **criteriaBusinessEntityIds** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **criteriaBusinessEntityIsUnassigned** | **kotlin.Boolean** |  |  [optional] |
| **setMerchantAction** | **kotlin.String** | Merchant id to set on match. |  [optional] |
| **setCategoryAction** | **kotlin.String** | Category id to set on match. |  [optional] |
| **addTagsAction** | **kotlin.collections.List&lt;kotlin.String&gt;** | Tag ids to add on match (additive; does not replace existing tags). |  [optional] |
| **linkGoalAction** | **kotlin.String** |  |  [optional] |
| **linkSavingsGoalAction** | **kotlin.String** |  |  [optional] |
| **needsReviewByUserAction** | **kotlin.String** | User id to assign for review. |  [optional] |
| **unassignNeedsReviewByUserAction** | **kotlin.Boolean** |  |  [optional] |
| **sendNotificationAction** | **kotlin.Boolean** |  |  [optional] |
| **setHideFromReportsAction** | **kotlin.Boolean** |  |  [optional] |
| **setLinkToPaydownBudgetAction** | **kotlin.Boolean** |  |  [optional] |
| **reviewStatusAction** | **kotlin.String** |  |  [optional] |
| **actionSetOwnerIsJoint** | **kotlin.Boolean** |  |  [optional] |
| **actionSetOwner** | **kotlin.String** | User id to set as transaction owner on match. |  [optional] |
| **actionSetBusinessEntity** | **kotlin.String** | Business entity id to assign on match. |  [optional] |
| **actionSetBusinessEntityIsUnassigned** | **kotlin.Boolean** |  |  [optional] |
| **splitTransactionsAction** | [**TransactionRuleSplitAction**](TransactionRuleSplitAction.md) |  |  [optional] |



