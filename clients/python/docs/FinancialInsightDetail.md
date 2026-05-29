# FinancialInsightDetail

Single insight detail with playbook.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**merchant_name_display** | **str** |  | [optional] 
**merchant_logo_url** | **str** |  | [optional] 
**product_name_display** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**reasoning** | **str** |  | [optional] 
**effort** | **str** |  | [optional] 
**status** | **str** |  | [optional] 
**suggested_action_type** | **str** |  | [optional] 
**execution_method** | **str** |  | [optional] 
**can_use_browser_automation** | **bool** |  | [optional] 
**savings_estimate_low** | **float** |  | [optional] 
**savings_estimate_high** | **float** |  | [optional] 
**captured_savings_low** | **float** |  | [optional] 
**current_annual_cost** | **float** |  | [optional] 
**next_charge_date** | **date** |  | [optional] 
**score** | **float** |  | [optional] 
**opportunity_type** | **str** |  | [optional] 
**payment_account_label** | **str** | From &#x60;paymentAccount.label&#x60; upstream. | [optional] 
**recurring_stream_snapshot** | **Dict[str, object]** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] 
**playbook** | [**FinancialInsightPlaybook**](FinancialInsightPlaybook.md) |  | [optional] 
**related_merchants** | [**List[FinancialInsightRelatedMerchant]**](FinancialInsightRelatedMerchant.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.financial_insight_detail import FinancialInsightDetail

# TODO update the JSON string below
json = "{}"
# create an instance of FinancialInsightDetail from a JSON string
financial_insight_detail_instance = FinancialInsightDetail.from_json(json)
# print the JSON string representation of the object
print(FinancialInsightDetail.to_json())

# convert the object into a dict
financial_insight_detail_dict = financial_insight_detail_instance.to_dict()
# create an instance of FinancialInsightDetail from a dict
financial_insight_detail_from_dict = FinancialInsightDetail.from_dict(financial_insight_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


