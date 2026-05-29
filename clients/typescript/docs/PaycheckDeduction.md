# PaycheckDeduction

One line-item deduction from a paycheck (pre-tax, tax, post-tax).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**deductionType** | **string** | Monarch enum of payroll deduction categories (e.g. &#x60;federal_income_tax&#x60;, &#x60;traditional_401k&#x60;, &#x60;medical_insurance&#x60;, &#x60;custom&#x60;). When &#x60;custom&#x60;, see &#x60;customDeductionName&#x60;.  | [default to undefined]
**customDeductionName** | **string** | Free-text label when &#x60;deductionType&#x3D;custom&#x60;; null otherwise. | [optional] [default to undefined]
**amount** | **number** | Dollar amount of the deduction (always positive). | [default to undefined]
**createdAt** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { PaycheckDeduction } from 'monarch-bridge-client';

const instance: PaycheckDeduction = {
    id,
    deductionType,
    customDeductionName,
    amount,
    createdAt,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
