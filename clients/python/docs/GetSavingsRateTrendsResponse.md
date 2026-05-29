# GetSavingsRateTrendsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetSavingsRateTrendsResponseData**](GetSavingsRateTrendsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_savings_rate_trends_response import GetSavingsRateTrendsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetSavingsRateTrendsResponse from a JSON string
get_savings_rate_trends_response_instance = GetSavingsRateTrendsResponse.from_json(json)
# print the JSON string representation of the object
print(GetSavingsRateTrendsResponse.to_json())

# convert the object into a dict
get_savings_rate_trends_response_dict = get_savings_rate_trends_response_instance.to_dict()
# create an instance of GetSavingsRateTrendsResponse from a dict
get_savings_rate_trends_response_from_dict = GetSavingsRateTrendsResponse.from_dict(get_savings_rate_trends_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


