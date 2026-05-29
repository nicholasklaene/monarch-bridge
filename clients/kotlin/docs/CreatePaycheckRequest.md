
# CreatePaycheckRequest

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **employerId** | **kotlin.String** | Id from &#x60;GET /v1/paycheck-employers&#x60;. Create one first if you don&#39;t have it. |  |
| **grossAmount** | **kotlin.Double** | Total gross pay before deductions, in dollars. |  |
| **payDate** | **kotlin.String** | Day the funds hit the bank, &#x60;YYYY-MM-DD&#x60;. |  |
| **payPeriodStart** | **kotlin.String** |  |  [optional] |
| **payPeriodEnd** | **kotlin.String** |  |  [optional] |
| **payrollProvider** | **kotlin.String** | One of Monarch&#39;s &#x60;PayrollProvider&#x60; enum values. |  [optional] |
| **ownerId** | **kotlin.String** | Household member id; omit to default to the calling user. |  [optional] |
| **deductions** | [**kotlin.collections.List&lt;PaycheckDeductionInput&gt;**](PaycheckDeductionInput.md) |  |  [optional] |
| **deposits** | [**kotlin.collections.List&lt;PaycheckDepositInput&gt;**](PaycheckDepositInput.md) |  |  [optional] |



