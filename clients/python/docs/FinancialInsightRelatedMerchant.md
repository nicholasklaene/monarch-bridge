# FinancialInsightRelatedMerchant


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**logo_url** | **str** |  | [optional] 
**merchant_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.financial_insight_related_merchant import FinancialInsightRelatedMerchant

# TODO update the JSON string below
json = "{}"
# create an instance of FinancialInsightRelatedMerchant from a JSON string
financial_insight_related_merchant_instance = FinancialInsightRelatedMerchant.from_json(json)
# print the JSON string representation of the object
print(FinancialInsightRelatedMerchant.to_json())

# convert the object into a dict
financial_insight_related_merchant_dict = financial_insight_related_merchant_instance.to_dict()
# create an instance of FinancialInsightRelatedMerchant from a dict
financial_insight_related_merchant_from_dict = FinancialInsightRelatedMerchant.from_dict(financial_insight_related_merchant_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


