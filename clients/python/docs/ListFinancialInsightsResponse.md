# ListFinancialInsightsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListFinancialInsightsResponseData**](ListFinancialInsightsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_financial_insights_response import ListFinancialInsightsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListFinancialInsightsResponse from a JSON string
list_financial_insights_response_instance = ListFinancialInsightsResponse.from_json(json)
# print the JSON string representation of the object
print(ListFinancialInsightsResponse.to_json())

# convert the object into a dict
list_financial_insights_response_dict = list_financial_insights_response_instance.to_dict()
# create an instance of ListFinancialInsightsResponse from a dict
list_financial_insights_response_from_dict = ListFinancialInsightsResponse.from_dict(list_financial_insights_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


