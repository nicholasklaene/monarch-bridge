# TransactionRuleRequest

Body for creating / updating / previewing a rule. Every field is optional; only the fields you set drive the criteria and actions. Forwarded as-is to Monarch\'s `CreateTransactionRuleInput` / `UpdateTransactionRuleInput` / `TransactionRulePreviewInput`. The proxy injects path `{id}` into update calls; for create / preview the body alone is sufficient. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
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
**setMerchantAction** | **string** | Merchant id to set on match. | [optional] [default to undefined]
**setCategoryAction** | **string** | Category id to set on match. | [optional] [default to undefined]
**addTagsAction** | **Array&lt;string&gt;** | Tag ids to add on match (additive; does not replace existing tags). | [optional] [default to undefined]
**linkGoalAction** | **string** |  | [optional] [default to undefined]
**linkSavingsGoalAction** | **string** |  | [optional] [default to undefined]
**needsReviewByUserAction** | **string** | User id to assign for review. | [optional] [default to undefined]
**unassignNeedsReviewByUserAction** | **boolean** |  | [optional] [default to undefined]
**sendNotificationAction** | **boolean** |  | [optional] [default to undefined]
**setHideFromReportsAction** | **boolean** |  | [optional] [default to undefined]
**setLinkToPaydownBudgetAction** | **boolean** |  | [optional] [default to undefined]
**reviewStatusAction** | **string** |  | [optional] [default to undefined]
**actionSetOwnerIsJoint** | **boolean** |  | [optional] [default to undefined]
**actionSetOwner** | **string** | User id to set as transaction owner on match. | [optional] [default to undefined]
**actionSetBusinessEntity** | **string** | Business entity id to assign on match. | [optional] [default to undefined]
**actionSetBusinessEntityIsUnassigned** | **boolean** |  | [optional] [default to undefined]
**splitTransactionsAction** | [**TransactionRuleSplitAction**](TransactionRuleSplitAction.md) |  | [optional] [default to undefined]

## Example

```typescript
import { TransactionRuleRequest } from 'monarch-bridge-client';

const instance: TransactionRuleRequest = {
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
    splitTransactionsAction,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
