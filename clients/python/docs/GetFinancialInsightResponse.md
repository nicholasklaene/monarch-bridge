# GetFinancialInsightResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetFinancialInsightResponseData**](GetFinancialInsightResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_financial_insight_response import GetFinancialInsightResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetFinancialInsightResponse from a JSON string
get_financial_insight_response_instance = GetFinancialInsightResponse.from_json(json)
# print the JSON string representation of the object
print(GetFinancialInsightResponse.to_json())

# convert the object into a dict
get_financial_insight_response_dict = get_financial_insight_response_instance.to_dict()
# create an instance of GetFinancialInsightResponse from a dict
get_financial_insight_response_from_dict = GetFinancialInsightResponse.from_dict(get_financial_insight_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


