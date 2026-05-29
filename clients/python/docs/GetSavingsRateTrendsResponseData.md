# GetSavingsRateTrendsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**points** | [**List[SavingsRateTrendPoint]**](SavingsRateTrendPoint.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_savings_rate_trends_response_data import GetSavingsRateTrendsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetSavingsRateTrendsResponseData from a JSON string
get_savings_rate_trends_response_data_instance = GetSavingsRateTrendsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetSavingsRateTrendsResponseData.to_json())

# convert the object into a dict
get_savings_rate_trends_response_data_dict = get_savings_rate_trends_response_data_instance.to_dict()
# create an instance of GetSavingsRateTrendsResponseData from a dict
get_savings_rate_trends_response_data_from_dict = GetSavingsRateTrendsResponseData.from_dict(get_savings_rate_trends_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


