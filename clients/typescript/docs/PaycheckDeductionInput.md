# PaycheckDeductionInput

One deduction line-item to attach when creating or replacing a paycheck.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deductionType** | **string** | Monarch\&#39;s &#x60;PaycheckDeductionType&#x60; enum (e.g. &#x60;federal_income_tax&#x60;, &#x60;traditional_401k&#x60;, &#x60;medical_insurance&#x60;, &#x60;custom&#x60;). Use &#x60;custom&#x60; for free-form labels.  | [default to undefined]
**customDeductionName** | **string** | Required when &#x60;deductionType&#x3D;custom&#x60;; ignored otherwise. | [optional] [default to undefined]
**amount** | **number** | Dollar amount of the deduction (positive). | [default to undefined]

## Example

```typescript
import { PaycheckDeductionInput } from 'monarch-bridge-client';

const instance: PaycheckDeductionInput = {
    deductionType,
    customDeductionName,
    amount,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
