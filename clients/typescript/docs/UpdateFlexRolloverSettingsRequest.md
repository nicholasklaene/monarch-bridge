# UpdateFlexRolloverSettingsRequest

Common use: point `rolloverStartMonth` to the current month with `rolloverStartingBalance: 0` to clear accumulated negative rollover. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rolloverStartMonth** | **string** |  | [default to undefined]
**rolloverStartingBalance** | **number** |  | [optional] [default to 0.0]
**rolloverEnabled** | **boolean** |  | [optional] [default to true]
**budgetSystem** | **string** |  | [optional] [default to 'fixed_and_flex']

## Example

```typescript
import { UpdateFlexRolloverSettingsRequest } from 'monarch-bridge-client';

const instance: UpdateFlexRolloverSettingsRequest = {
    rolloverStartMonth,
    rolloverStartingBalance,
    rolloverEnabled,
    budgetSystem,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
