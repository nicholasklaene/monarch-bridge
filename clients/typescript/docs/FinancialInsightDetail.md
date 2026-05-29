# FinancialInsightDetail

Single insight detail with playbook.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**merchantNameDisplay** | **string** |  | [optional] [default to undefined]
**merchantLogoUrl** | **string** |  | [optional] [default to undefined]
**productNameDisplay** | **string** |  | [optional] [default to undefined]
**description** | **string** |  | [optional] [default to undefined]
**reasoning** | **string** |  | [optional] [default to undefined]
**effort** | **string** |  | [optional] [default to undefined]
**status** | **string** |  | [optional] [default to undefined]
**suggestedActionType** | **string** |  | [optional] [default to undefined]
**executionMethod** | **string** |  | [optional] [default to undefined]
**canUseBrowserAutomation** | **boolean** |  | [optional] [default to undefined]
**savingsEstimateLow** | **number** |  | [optional] [default to undefined]
**savingsEstimateHigh** | **number** |  | [optional] [default to undefined]
**capturedSavingsLow** | **number** |  | [optional] [default to undefined]
**currentAnnualCost** | **number** |  | [optional] [default to undefined]
**nextChargeDate** | **string** |  | [optional] [default to undefined]
**score** | **number** |  | [optional] [default to undefined]
**opportunityType** | **string** |  | [optional] [default to undefined]
**paymentAccountLabel** | **string** | From &#x60;paymentAccount.label&#x60; upstream. | [optional] [default to undefined]
**recurringStreamSnapshot** | **{ [key: string]: any; }** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] [default to undefined]
**playbook** | [**FinancialInsightPlaybook**](FinancialInsightPlaybook.md) |  | [optional] [default to undefined]
**relatedMerchants** | [**Array&lt;FinancialInsightRelatedMerchant&gt;**](FinancialInsightRelatedMerchant.md) |  | [optional] [default to undefined]

## Example

```typescript
import { FinancialInsightDetail } from 'monarch-bridge-client';

const instance: FinancialInsightDetail = {
    id,
    merchantNameDisplay,
    merchantLogoUrl,
    productNameDisplay,
    description,
    reasoning,
    effort,
    status,
    suggestedActionType,
    executionMethod,
    canUseBrowserAutomation,
    savingsEstimateLow,
    savingsEstimateHigh,
    capturedSavingsLow,
    currentAnnualCost,
    nextChargeDate,
    score,
    opportunityType,
    paymentAccountLabel,
    recurringStreamSnapshot,
    playbook,
    relatedMerchants,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
