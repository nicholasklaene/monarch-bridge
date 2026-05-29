
# TransactionRule

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.String** |  |  |
| **order** | **kotlin.Int** |  |  [optional] |
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
| **setMerchantAction** | [**Ref**](Ref.md) |  |  [optional] |
| **setCategoryAction** | [**Ref**](Ref.md) |  |  [optional] |
| **addTagsAction** | [**kotlin.collections.List&lt;Ref&gt;**](Ref.md) |  |  [optional] |
| **linkGoalAction** | [**Ref**](Ref.md) |  |  [optional] |
| **linkSavingsGoalAction** | [**Ref**](Ref.md) |  |  [optional] |
| **needsReviewByUserAction** | [**Ref**](Ref.md) |  |  [optional] |
| **unassignNeedsReviewByUserAction** | **kotlin.Boolean** |  |  [optional] |
| **sendNotificationAction** | **kotlin.Boolean** |  |  [optional] |
| **setHideFromReportsAction** | **kotlin.Boolean** |  |  [optional] |
| **setLinkToPaydownBudgetAction** | **kotlin.Boolean** |  |  [optional] |
| **reviewStatusAction** | **kotlin.String** |  |  [optional] |
| **actionSetOwnerIsJoint** | **kotlin.Boolean** |  |  [optional] |
| **actionSetOwner** | [**Ref**](Ref.md) |  |  [optional] |
| **actionSetBusinessEntity** | [**Ref**](Ref.md) |  |  [optional] |
| **actionSetBusinessEntityIsUnassigned** | **kotlin.Boolean** |  |  [optional] |
| **recentApplicationCount** | **kotlin.Int** |  |  [optional] |
| **lastAppliedAt** | **kotlin.String** |  |  [optional] |
| **splitTransactionsAction** | [**TransactionRuleSplitAction**](TransactionRuleSplitAction.md) |  |  [optional] |



