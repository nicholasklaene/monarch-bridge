
# PaycheckDeductionInput

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **deductionType** | **kotlin.String** | Monarch&#39;s &#x60;PaycheckDeductionType&#x60; enum (e.g. &#x60;federal_income_tax&#x60;, &#x60;traditional_401k&#x60;, &#x60;medical_insurance&#x60;, &#x60;custom&#x60;). Use &#x60;custom&#x60; for free-form labels.  |  |
| **amount** | **kotlin.Double** | Dollar amount of the deduction (positive). |  |
| **customDeductionName** | **kotlin.String** | Required when &#x60;deductionType&#x3D;custom&#x60;; ignored otherwise. |  [optional] |



