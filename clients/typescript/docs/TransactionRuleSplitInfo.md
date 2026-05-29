# TransactionRuleSplitInfo

One entry in `splitTransactionsAction.splitsInfo`. Defines a child split the rule will create on match.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**categoryId** | **string** |  | [optional] [default to undefined]
**merchantName** | **string** |  | [optional] [default to undefined]
**amount** | **number** | Required when amountType is ABSOLUTE; required as a percentage 0-100 when amountType is PERCENTAGE. | [optional] [default to undefined]
**goalId** | **string** |  | [optional] [default to undefined]
**savingsGoalId** | **string** |  | [optional] [default to undefined]
**tags** | **Array&lt;string&gt;** |  | [optional] [default to undefined]
**hideFromReports** | **boolean** |  | [optional] [default to undefined]
**reviewStatus** | **string** |  | [optional] [default to undefined]
**needsReviewByUserId** | **string** |  | [optional] [default to undefined]
**ownerUserId** | **string** |  | [optional] [default to undefined]
**ownerIsJoint** | **boolean** |  | [optional] [default to undefined]
**businessEntityId** | **string** |  | [optional] [default to undefined]
**businessEntityIsUnassigned** | **boolean** |  | [optional] [default to undefined]

## Example

```typescript
import { TransactionRuleSplitInfo } from 'monarch-bridge-client';

const instance: TransactionRuleSplitInfo = {
    categoryId,
    merchantName,
    amount,
    goalId,
    savingsGoalId,
    tags,
    hideFromReports,
    reviewStatus,
    needsReviewByUserId,
    ownerUserId,
    ownerIsJoint,
    businessEntityId,
    businessEntityIsUnassigned,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
