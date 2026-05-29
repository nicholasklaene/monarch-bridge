# GoalEvent

One contribution / withdrawal / linked-transaction event against a savings goal.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**date** | **string** |  | [optional] [default to undefined]
**amount** | **number** |  | [optional] [default to undefined]
**type** | **string** | Event type (&#x60;contribution&#x60;, &#x60;withdrawal&#x60;, &#x60;transaction&#x60;, etc.). | [optional] [default to undefined]
**createdAt** | **string** |  | [optional] [default to undefined]
**canDelete** | **boolean** |  | [optional] [default to undefined]
**includeInBudget** | **boolean** |  | [optional] [default to undefined]
**notes** | **string** |  | [optional] [default to undefined]
**account** | [**GoalEventAccountRef**](GoalEventAccountRef.md) |  | [optional] [default to undefined]
**transaction** | [**GoalEventTransactionRef**](GoalEventTransactionRef.md) |  | [optional] [default to undefined]

## Example

```typescript
import { GoalEvent } from 'monarch-bridge-client';

const instance: GoalEvent = {
    id,
    date,
    amount,
    type,
    createdAt,
    canDelete,
    includeInBudget,
    notes,
    account,
    transaction,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
