# TransactionRule

Auto-categorization rule. Every criteria + action field is nullable; only the fields the user enabled in the rule builder come back populated. `categoryIds`, `accountIds`, `criteriaBusinessEntityIds`, `criteriaOwnerUserIds` are inclusion sets (match when the txn belongs to one of these); the action fields drive what happens to each matched txn. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**order** | **number** |  | [optional] [default to undefined]
**merchantCriteriaUseOriginalStatement** | **boolean** |  | [optional] [default to undefined]
**merchantCriteria** | [**Array&lt;TransactionRuleStringCriterion&gt;**](TransactionRuleStringCriterion.md) |  | [optional] [default to undefined]
**originalStatementCriteria** | [**Array&lt;TransactionRuleStringCriterion&gt;**](TransactionRuleStringCriterion.md) |  | [optional] [default to undefined]
**merchantNameCriteria** | [**Array&lt;TransactionRuleStringCriterion&gt;**](TransactionRuleStringCriterion.md) |  | [optional] [default to undefined]
**amountCriteria** | [**TransactionRuleAmountCriterion**](TransactionRuleAmountCriterion.md) |  | [optional] [default to undefined]
**categoryIds** | **Array&lt;string&gt;** |  | [optional] [default to undefined]
**accountIds** | **Array&lt;string&gt;** |  | [optional] [default to undefined]
**criteriaOwnerIsJoint** | **boolean** |  | [optional] [default to undefined]
**criteriaOwnerUserIds** | **Array&lt;string&gt;** |  | [optional] [default to undefined]
**criteriaBusinessEntityIds** | **Array&lt;string&gt;** |  | [optional] [default to undefined]
**criteriaBusinessEntityIsUnassigned** | **boolean** |  | [optional] [default to undefined]
**setMerchantAction** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**setCategoryAction** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**addTagsAction** | [**Array&lt;Ref&gt;**](Ref.md) |  | [optional] [default to undefined]
**linkGoalAction** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**linkSavingsGoalAction** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**needsReviewByUserAction** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**unassignNeedsReviewByUserAction** | **boolean** |  | [optional] [default to undefined]
**sendNotificationAction** | **boolean** |  | [optional] [default to undefined]
**setHideFromReportsAction** | **boolean** |  | [optional] [default to undefined]
**setLinkToPaydownBudgetAction** | **boolean** |  | [optional] [default to undefined]
**reviewStatusAction** | **string** |  | [optional] [default to undefined]
**actionSetOwnerIsJoint** | **boolean** |  | [optional] [default to undefined]
**actionSetOwner** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**actionSetBusinessEntity** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**actionSetBusinessEntityIsUnassigned** | **boolean** |  | [optional] [default to undefined]
**recentApplicationCount** | **number** |  | [optional] [default to undefined]
**lastAppliedAt** | **string** |  | [optional] [default to undefined]
**splitTransactionsAction** | [**TransactionRuleSplitAction**](TransactionRuleSplitAction.md) |  | [optional] [default to undefined]

## Example

```typescript
import { TransactionRule } from 'monarch-bridge-client';

const instance: TransactionRule = {
    id,
    order,
    merchantCriteriaUseOriginalStatement,
    merchantCriteria,
    originalStatementCriteria,
    merchantNameCriteria,
    amountCriteria,
    categoryIds,
    accountIds,
    criteriaOwnerIsJoint,
    criteriaOwnerUserIds,
    criteriaBusinessEntityIds,
    criteriaBusinessEntityIsUnassigned,
    setMerchantAction,
    setCategoryAction,
    addTagsAction,
    linkGoalAction,
    linkSavingsGoalAction,
    needsReviewByUserAction,
    unassignNeedsReviewByUserAction,
    sendNotificationAction,
    setHideFromReportsAction,
    setLinkToPaydownBudgetAction,
    reviewStatusAction,
    actionSetOwnerIsJoint,
    actionSetOwner,
    actionSetBusinessEntity,
    actionSetBusinessEntityIsUnassigned,
    recentApplicationCount,
    lastAppliedAt,
    splitTransactionsAction,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
