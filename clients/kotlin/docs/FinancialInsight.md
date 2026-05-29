
# FinancialInsight

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.String** |  |  |
| **merchantNameDisplay** | **kotlin.String** |  |  [optional] |
| **merchantLogoUrl** | **kotlin.String** |  |  [optional] |
| **dashboardSubtitle** | **kotlin.String** |  |  [optional] |
| **description** | **kotlin.String** |  |  [optional] |
| **reasoning** | **kotlin.String** |  |  [optional] |
| **effort** | **kotlin.String** | Monarch&#39;s effort tag (e.g. &#x60;LOW&#x60;, &#x60;MEDIUM&#x60;, &#x60;HIGH&#x60;). |  [optional] |
| **status** | **kotlin.String** | &#x60;InsightStatusEnum&#x60; value (e.g. &#x60;NEW&#x60;, &#x60;ACCEPTED&#x60;, &#x60;COMPLETED&#x60;). |  [optional] |
| **savingsEstimateLow** | **kotlin.Double** |  |  [optional] |
| **savingsEstimateHigh** | **kotlin.Double** |  |  [optional] |
| **capturedSavingsLow** | **kotlin.Double** |  |  [optional] |
| **currentAnnualCost** | **kotlin.Double** |  |  [optional] |
| **nextChargeDate** | [**java.time.LocalDate**](java.time.LocalDate.md) |  |  [optional] |
| **score** | **kotlin.Double** |  |  [optional] |
| **opportunityType** | **kotlin.String** |  |  [optional] |
| **suggestedActionType** | **kotlin.String** |  |  [optional] |
| **recurringStreamSnapshot** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Any&gt;**](kotlin.Any.md) | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  |  [optional] |
| **relatedMerchants** | [**kotlin.collections.List&lt;FinancialInsightRelatedMerchant&gt;**](FinancialInsightRelatedMerchant.md) |  |  [optional] |



