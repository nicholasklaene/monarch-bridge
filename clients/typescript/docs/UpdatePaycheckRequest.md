# UpdatePaycheckRequest

Body for `PATCH /v1/paychecks/{id}`. All fields optional; only set fields are sent to Monarch. Lists (`deductions`, `deposits`) are wholesale-replace when present, matching Monarch\'s `UpdatePaycheckInput` semantics. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**employerId** | **string** |  | [optional] [default to undefined]
**grossAmount** | **number** |  | [optional] [default to undefined]
**payDate** | **string** |  | [optional] [default to undefined]
**payPeriodStart** | **string** |  | [optional] [default to undefined]
**payPeriodEnd** | **string** |  | [optional] [default to undefined]
**payrollProvider** | **string** |  | [optional] [default to undefined]
**ownerId** | **string** |  | [optional] [default to undefined]
**deductions** | [**Array&lt;PaycheckDeductionInput&gt;**](PaycheckDeductionInput.md) |  | [optional] [default to undefined]
**deposits** | [**Array&lt;PaycheckDepositInput&gt;**](PaycheckDepositInput.md) |  | [optional] [default to undefined]

## Example

```typescript
import { UpdatePaycheckRequest } from 'monarch-bridge-client';

const instance: UpdatePaycheckRequest = {
    employerId,
    grossAmount,
    payDate,
    payPeriodStart,
    payPeriodEnd,
    payrollProvider,
    ownerId,
    deductions,
    deposits,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
