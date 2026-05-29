# FinancialInsight

One AI-generated savings opportunity.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**merchant_name_display** | **str** |  | [optional] 
**merchant_logo_url** | **str** |  | [optional] 
**dashboard_subtitle** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**reasoning** | **str** |  | [optional] 
**effort** | **str** | Monarch&#39;s effort tag (e.g. &#x60;LOW&#x60;, &#x60;MEDIUM&#x60;, &#x60;HIGH&#x60;). | [optional] 
**status** | **str** | &#x60;InsightStatusEnum&#x60; value (e.g. &#x60;NEW&#x60;, &#x60;ACCEPTED&#x60;, &#x60;COMPLETED&#x60;). | [optional] 
**savings_estimate_low** | **float** |  | [optional] 
**savings_estimate_high** | **float** |  | [optional] 
**captured_savings_low** | **float** |  | [optional] 
**current_annual_cost** | **float** |  | [optional] 
**next_charge_date** | **date** |  | [optional] 
**score** | **float** |  | [optional] 
**opportunity_type** | **str** |  | [optional] 
**suggested_action_type** | **str** |  | [optional] 
**recurring_stream_snapshot** | **Dict[str, object]** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] 
**related_merchants** | [**List[FinancialInsightRelatedMerchant]**](FinancialInsightRelatedMerchant.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.financial_insight import FinancialInsight

# TODO update the JSON string below
json = "{}"
# create an instance of FinancialInsight from a JSON string
financial_insight_instance = FinancialInsight.from_json(json)
# print the JSON string representation of the object
print(FinancialInsight.to_json())

# convert the object into a dict
financial_insight_dict = financial_insight_instance.to_dict()
# create an instance of FinancialInsight from a dict
financial_insight_from_dict = FinancialInsight.from_dict(financial_insight_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


