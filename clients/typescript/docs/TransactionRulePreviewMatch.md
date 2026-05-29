# TransactionRulePreviewMatch

One transaction that would be matched, plus the new values the rule would apply.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transaction** | [**Transaction**](Transaction.md) |  | [optional] [default to undefined]
**newName** | **string** |  | [optional] [default to undefined]
**newSplitTransactions** | **Array&lt;{ [key: string]: any; }&gt;** |  | [optional] [default to undefined]
**newCategory** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**newOwnerIsJoint** | **boolean** |  | [optional] [default to undefined]
**newHideFromReports** | **boolean** |  | [optional] [default to undefined]
**newTags** | [**Array&lt;Ref&gt;**](Ref.md) |  | [optional] [default to undefined]
**newGoal** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**newBusinessEntity** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**newBusinessEntityIsUnassigned** | **boolean** |  | [optional] [default to undefined]

## Example

```typescript
import { TransactionRulePreviewMatch } from 'monarch-bridge-client';

const instance: TransactionRulePreviewMatch = {
    transaction,
    newName,
    newSplitTransactions,
    newCategory,
    newOwnerIsJoint,
    newHideFromReports,
    newTags,
    newGoal,
    newBusinessEntity,
    newBusinessEntityIsUnassigned,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
