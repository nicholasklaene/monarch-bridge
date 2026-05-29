# GetNetworthRecentResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accounts** | [**List[RecentAccountBalances]**](RecentAccountBalances.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_networth_recent_response_data import GetNetworthRecentResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetNetworthRecentResponseData from a JSON string
get_networth_recent_response_data_instance = GetNetworthRecentResponseData.from_json(json)
# print the JSON string representation of the object
print(GetNetworthRecentResponseData.to_json())

# convert the object into a dict
get_networth_recent_response_data_dict = get_networth_recent_response_data_instance.to_dict()
# create an instance of GetNetworthRecentResponseData from a dict
get_networth_recent_response_data_from_dict = GetNetworthRecentResponseData.from_dict(get_networth_recent_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


