# CreatePaycheckRequest

Body for `POST /v1/paychecks`. Maps to Monarch\'s `CreatePaycheckInput`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**employerId** | **string** | Id from &#x60;GET /v1/paycheck-employers&#x60;. Create one first if you don\&#39;t have it. | [default to undefined]
**grossAmount** | **number** | Total gross pay before deductions, in dollars. | [default to undefined]
**payDate** | **string** | Day the funds hit the bank, &#x60;YYYY-MM-DD&#x60;. | [default to undefined]
**payPeriodStart** | **string** |  | [optional] [default to undefined]
**payPeriodEnd** | **string** |  | [optional] [default to undefined]
**payrollProvider** | **string** | One of Monarch\&#39;s &#x60;PayrollProvider&#x60; enum values. | [optional] [default to undefined]
**ownerId** | **string** | Household member id; omit to default to the calling user. | [optional] [default to undefined]
**deductions** | [**Array&lt;PaycheckDeductionInput&gt;**](PaycheckDeductionInput.md) |  | [optional] [default to undefined]
**deposits** | [**Array&lt;PaycheckDepositInput&gt;**](PaycheckDepositInput.md) |  | [optional] [default to undefined]

## Example

```typescript
import { CreatePaycheckRequest } from 'monarch-bridge-client';

const instance: CreatePaycheckRequest = {
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
