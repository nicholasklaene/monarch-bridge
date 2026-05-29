# GetSpendingTrendsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetSpendingTrendsResponseData**](GetSpendingTrendsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_spending_trends_response import GetSpendingTrendsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetSpendingTrendsResponse from a JSON string
get_spending_trends_response_instance = GetSpendingTrendsResponse.from_json(json)
# print the JSON string representation of the object
print(GetSpendingTrendsResponse.to_json())

# convert the object into a dict
get_spending_trends_response_dict = get_spending_trends_response_instance.to_dict()
# create an instance of GetSpendingTrendsResponse from a dict
get_spending_trends_response_from_dict = GetSpendingTrendsResponse.from_dict(get_spending_trends_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


