# Goal

A v2 savings goal.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**name** | **string** |  | [default to undefined]
**type** | **string** | One of &#x60;savings&#x60;, &#x60;debt&#x60;. | [optional] [default to undefined]
**status** | **string** | Lifecycle status (&#x60;active&#x60;, &#x60;complete&#x60;, &#x60;archived&#x60;, etc.). | [optional] [default to undefined]
**progress** | **number** | 0.0 → 1.0 fraction of &#x60;targetAmount&#x60; reached. | [optional] [default to undefined]
**currentBalance** | **number** |  | [optional] [default to undefined]
**targetAmount** | **number** |  | [optional] [default to undefined]
**targetDate** | **string** | ISO date the user is aiming for (&#x60;YYYY-MM-DD&#x60;); nullable for open-ended goals. | [optional] [default to undefined]
**archivedAt** | **string** | ISO timestamp the goal was archived; null for active goals. | [optional] [default to undefined]
**createdAt** | **string** |  | [optional] [default to undefined]
**priority** | **number** | User-set ordering (lower &#x3D; higher priority). | [optional] [default to undefined]
**isSinkingFund** | **boolean** |  | [optional] [default to undefined]
**plannedMonthlyContribution** | **number** |  | [optional] [default to undefined]
**estimatedMonthsUntilCompletion** | **number** |  | [optional] [default to undefined]
**forecastedCompletionDate** | **string** |  | [optional] [default to undefined]
**imageStorageProvider** | **string** |  | [optional] [default to undefined]
**imageStorageProviderId** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { Goal } from 'monarch-bridge-client';

const instance: Goal = {
    id,
    name,
    type,
    status,
    progress,
    currentBalance,
    targetAmount,
    targetDate,
    archivedAt,
    createdAt,
    priority,
    isSinkingFund,
    plannedMonthlyContribution,
    estimatedMonthsUntilCompletion,
    forecastedCompletionDate,
    imageStorageProvider,
    imageStorageProviderId,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
