# FinancialInsight

One AI-generated savings opportunity.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**merchantNameDisplay** | **string** |  | [optional] [default to undefined]
**merchantLogoUrl** | **string** |  | [optional] [default to undefined]
**dashboardSubtitle** | **string** |  | [optional] [default to undefined]
**description** | **string** |  | [optional] [default to undefined]
**reasoning** | **string** |  | [optional] [default to undefined]
**effort** | **string** | Monarch\&#39;s effort tag (e.g. &#x60;LOW&#x60;, &#x60;MEDIUM&#x60;, &#x60;HIGH&#x60;). | [optional] [default to undefined]
**status** | **string** | &#x60;InsightStatusEnum&#x60; value (e.g. &#x60;NEW&#x60;, &#x60;ACCEPTED&#x60;, &#x60;COMPLETED&#x60;). | [optional] [default to undefined]
**savingsEstimateLow** | **number** |  | [optional] [default to undefined]
**savingsEstimateHigh** | **number** |  | [optional] [default to undefined]
**capturedSavingsLow** | **number** |  | [optional] [default to undefined]
**currentAnnualCost** | **number** |  | [optional] [default to undefined]
**nextChargeDate** | **string** |  | [optional] [default to undefined]
**score** | **number** |  | [optional] [default to undefined]
**opportunityType** | **string** |  | [optional] [default to undefined]
**suggestedActionType** | **string** |  | [optional] [default to undefined]
**recurringStreamSnapshot** | **{ [key: string]: any; }** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] [default to undefined]
**relatedMerchants** | [**Array&lt;FinancialInsightRelatedMerchant&gt;**](FinancialInsightRelatedMerchant.md) |  | [optional] [default to undefined]

## Example

```typescript
import { FinancialInsight } from 'monarch-bridge-client';

const instance: FinancialInsight = {
    id,
    merchantNameDisplay,
    merchantLogoUrl,
    dashboardSubtitle,
    description,
    reasoning,
    effort,
    status,
    savingsEstimateLow,
    savingsEstimateHigh,
    capturedSavingsLow,
    currentAnnualCost,
    nextChargeDate,
    score,
    opportunityType,
    suggestedActionType,
    recurringStreamSnapshot,
    relatedMerchants,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
