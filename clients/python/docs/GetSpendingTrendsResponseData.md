# GetSpendingTrendsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**trends** | [**SpendingTrends**](SpendingTrends.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_spending_trends_response_data import GetSpendingTrendsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetSpendingTrendsResponseData from a JSON string
get_spending_trends_response_data_instance = GetSpendingTrendsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetSpendingTrendsResponseData.to_json())

# convert the object into a dict
get_spending_trends_response_data_dict = get_spending_trends_response_data_instance.to_dict()
# create an instance of GetSpendingTrendsResponseData from a dict
get_spending_trends_response_data_from_dict = GetSpendingTrendsResponseData.from_dict(get_spending_trends_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


