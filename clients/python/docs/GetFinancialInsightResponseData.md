# GetFinancialInsightResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**insight** | [**FinancialInsightDetail**](FinancialInsightDetail.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_financial_insight_response_data import GetFinancialInsightResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetFinancialInsightResponseData from a JSON string
get_financial_insight_response_data_instance = GetFinancialInsightResponseData.from_json(json)
# print the JSON string representation of the object
print(GetFinancialInsightResponseData.to_json())

# convert the object into a dict
get_financial_insight_response_data_dict = get_financial_insight_response_data_instance.to_dict()
# create an instance of GetFinancialInsightResponseData from a dict
get_financial_insight_response_data_from_dict = GetFinancialInsightResponseData.from_dict(get_financial_insight_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


