
# FinancialInsightDetail

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.String** |  |  |
| **merchantNameDisplay** | **kotlin.String** |  |  [optional] |
| **merchantLogoUrl** | **kotlin.String** |  |  [optional] |
| **productNameDisplay** | **kotlin.String** |  |  [optional] |
| **description** | **kotlin.String** |  |  [optional] |
| **reasoning** | **kotlin.String** |  |  [optional] |
| **effort** | **kotlin.String** |  |  [optional] |
| **status** | **kotlin.String** |  |  [optional] |
| **suggestedActionType** | **kotlin.String** |  |  [optional] |
| **executionMethod** | **kotlin.String** |  |  [optional] |
| **canUseBrowserAutomation** | **kotlin.Boolean** |  |  [optional] |
| **savingsEstimateLow** | **kotlin.Double** |  |  [optional] |
| **savingsEstimateHigh** | **kotlin.Double** |  |  [optional] |
| **capturedSavingsLow** | **kotlin.Double** |  |  [optional] |
| **currentAnnualCost** | **kotlin.Double** |  |  [optional] |
| **nextChargeDate** | [**java.time.LocalDate**](java.time.LocalDate.md) |  |  [optional] |
| **score** | **kotlin.Double** |  |  [optional] |
| **opportunityType** | **kotlin.String** |  |  [optional] |
| **paymentAccountLabel** | **kotlin.String** | From &#x60;paymentAccount.label&#x60; upstream. |  [optional] |
| **recurringStreamSnapshot** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Any&gt;**](kotlin.Any.md) | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  |  [optional] |
| **playbook** | [**FinancialInsightPlaybook**](FinancialInsightPlaybook.md) |  |  [optional] |
| **relatedMerchants** | [**kotlin.collections.List&lt;FinancialInsightRelatedMerchant&gt;**](FinancialInsightRelatedMerchant.md) |  |  [optional] |



