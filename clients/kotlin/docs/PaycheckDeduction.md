
# PaycheckDeduction

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.String** |  |  |
| **deductionType** | **kotlin.String** | Monarch enum of payroll deduction categories (e.g. &#x60;federal_income_tax&#x60;, &#x60;traditional_401k&#x60;, &#x60;medical_insurance&#x60;, &#x60;custom&#x60;). When &#x60;custom&#x60;, see &#x60;customDeductionName&#x60;.  |  |
| **amount** | **kotlin.Double** | Dollar amount of the deduction (always positive). |  |
| **customDeductionName** | **kotlin.String** | Free-text label when &#x60;deductionType&#x3D;custom&#x60;; null otherwise. |  [optional] |
| **createdAt** | **kotlin.String** |  |  [optional] |



