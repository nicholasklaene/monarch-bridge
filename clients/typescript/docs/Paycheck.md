# Paycheck

One paycheck - gross amount plus its breakdown of deductions and bank deposits.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**employer** | [**PaycheckEmployerRef**](PaycheckEmployerRef.md) | Reference to the persisted employer; null for legacy paychecks before the registry shipped. | [optional] [default to undefined]
**employerName** | **string** | Denormalized employer label. Always present even when &#x60;employer&#x60; is null (Monarch keeps it on the row for historical paychecks).  | [optional] [default to undefined]
**payrollProvider** | **string** | One of Monarch\&#39;s &#x60;PayrollProvider&#x60; enum values (e.g. &#x60;adp&#x60;, &#x60;gusto&#x60;, &#x60;paychex&#x60;, &#x60;rippling&#x60;, &#x60;other&#x60;). Null for manually-entered paychecks.  | [optional] [default to undefined]
**payDate** | **string** | Day the funds hit the bank, &#x60;YYYY-MM-DD&#x60;. | [default to undefined]
**payPeriodStart** | **string** | First day of the period this paycheck covers, &#x60;YYYY-MM-DD&#x60;. | [optional] [default to undefined]
**payPeriodEnd** | **string** | Last day of the period this paycheck covers, &#x60;YYYY-MM-DD&#x60;. | [optional] [default to undefined]
**grossAmount** | **number** | Total gross pay before deductions, in dollars. | [default to undefined]
**createdAt** | **string** |  | [optional] [default to undefined]
**isMagicImported** | **boolean** | True when the paycheck was auto-imported from Monarch\&#39;s Magic Import. | [optional] [default to undefined]
**owner** | [**PaycheckOwner**](PaycheckOwner.md) |  | [optional] [default to undefined]
**createdBy** | [**PaycheckCreatedBy**](PaycheckCreatedBy.md) |  | [optional] [default to undefined]
**deductions** | [**Array&lt;PaycheckDeduction&gt;**](PaycheckDeduction.md) |  | [optional] [default to undefined]
**deposits** | [**Array&lt;PaycheckDeposit&gt;**](PaycheckDeposit.md) |  | [optional] [default to undefined]

## Example

```typescript
import { Paycheck } from 'monarch-bridge-client';

const instance: Paycheck = {
    id,
    employer,
    employerName,
    payrollProvider,
    payDate,
    payPeriodStart,
    payPeriodEnd,
    grossAmount,
    createdAt,
    isMagicImported,
    owner,
    createdBy,
    deductions,
    deposits,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
