# TransactionRuleRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**merchantCriteriaUseOriginalStatement** | **boolean** |  | [optional] [default to null]
**merchantCriteria** | [**array[TransactionRuleStringCriterion]**](TransactionRuleStringCriterion.md) |  | [optional] [default to null]
**originalStatementCriteria** | [**array[TransactionRuleStringCriterion]**](TransactionRuleStringCriterion.md) |  | [optional] [default to null]
**merchantNameCriteria** | [**array[TransactionRuleStringCriterion]**](TransactionRuleStringCriterion.md) |  | [optional] [default to null]
**amountCriteria** | [**TransactionRuleAmountCriterion**](TransactionRuleAmountCriterion.md) |  | [optional] [default to null]
**categoryIds** | **array[string]** |  | [optional] [default to null]
**accountIds** | **array[string]** |  | [optional] [default to null]
**criteriaOwnerIsJoint** | **boolean** |  | [optional] [default to null]
**criteriaOwnerUserIds** | **array[string]** |  | [optional] [default to null]
**criteriaBusinessEntityIds** | **array[string]** |  | [optional] [default to null]
**criteriaBusinessEntityIsUnassigned** | **boolean** |  | [optional] [default to null]
**setMerchantAction** | **string** |  | [optional] [default to null]
**setCategoryAction** | **string** |  | [optional] [default to null]
**addTagsAction** | **array[string]** |  | [optional] [default to null]
**linkGoalAction** | **string** |  | [optional] [default to null]
**linkSavingsGoalAction** | **string** |  | [optional] [default to null]
**needsReviewByUserAction** | **string** |  | [optional] [default to null]
**unassignNeedsReviewByUserAction** | **boolean** |  | [optional] [default to null]
**sendNotificationAction** | **boolean** |  | [optional] [default to null]
**setHideFromReportsAction** | **boolean** |  | [optional] [default to null]
**setLinkToPaydownBudgetAction** | **boolean** |  | [optional] [default to null]
**reviewStatusAction** | **string** |  | [optional] [default to null]
**actionSetOwnerIsJoint** | **boolean** |  | [optional] [default to null]
**actionSetOwner** | **string** |  | [optional] [default to null]
**actionSetBusinessEntity** | **string** |  | [optional] [default to null]
**actionSetBusinessEntityIsUnassigned** | **boolean** |  | [optional] [default to null]
**splitTransactionsAction** | [**TransactionRuleSplitAction**](TransactionRuleSplitAction.md) |  | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


