# UpdateHouseholdPreferencesRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**newTransactionsNeedReview** | **boolean** |  | [optional] [default to undefined]
**uncategorizedTransactionsNeedReview** | **boolean** |  | [optional] [default to undefined]
**pendingTransactionsCanBeEdited** | **boolean** |  | [optional] [default to undefined]
**aiAssistantEnabled** | **boolean** |  | [optional] [default to undefined]
**llmEnrichmentEnabled** | **boolean** |  | [optional] [default to undefined]
**investmentTransactionsEnabled** | **boolean** |  | [optional] [default to undefined]
**budgetApplyToFutureMonthsDefault** | **boolean** |  | [optional] [default to undefined]
**hiddenTransactionsBetaEnabled** | **boolean** |  | [optional] [default to undefined]
**collaborationToolsEnabled** | **boolean** |  | [optional] [default to undefined]
**aggDataSharingEnabled** | **boolean** |  | [optional] [default to undefined]
**aiModelTrainingOnUserDataEnabled** | **boolean** |  | [optional] [default to undefined]
**excludeBusinessFromBudget** | **boolean** |  | [optional] [default to undefined]
**continuousFinancialMonitoringEnabled** | **boolean** |  | [optional] [default to undefined]

## Example

```typescript
import { UpdateHouseholdPreferencesRequest } from 'monarch-bridge-client';

const instance: UpdateHouseholdPreferencesRequest = {
    newTransactionsNeedReview,
    uncategorizedTransactionsNeedReview,
    pendingTransactionsCanBeEdited,
    aiAssistantEnabled,
    llmEnrichmentEnabled,
    investmentTransactionsEnabled,
    budgetApplyToFutureMonthsDefault,
    hiddenTransactionsBetaEnabled,
    collaborationToolsEnabled,
    aggDataSharingEnabled,
    aiModelTrainingOnUserDataEnabled,
    excludeBusinessFromBudget,
    continuousFinancialMonitoringEnabled,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
