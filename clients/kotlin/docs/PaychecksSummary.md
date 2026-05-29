
# PaychecksSummary

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **count** | **kotlin.Int** | Number of paychecks in the window. |  |
| **totalGross** | **kotlin.Double** | Sum of &#x60;grossAmount&#x60; across all paychecks in window. |  |
| **totalDeductions** | **kotlin.Double** |  |  |
| **totalNet** | **kotlin.Double** | totalGross minus totalDeductions. |  |
| **deductionRate** | **kotlin.Double** | totalDeductions / totalGross, 0.0 to 1.0. |  [optional] |
| **deductionsByType** | [**kotlin.collections.List&lt;PaychecksSummaryDeduction&gt;**](PaychecksSummaryDeduction.md) |  |  [optional] |



