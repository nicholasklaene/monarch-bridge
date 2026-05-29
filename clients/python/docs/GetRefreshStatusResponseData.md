# GetRefreshStatusResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accounts** | [**List[AccountSyncStatus]**](AccountSyncStatus.md) |  | 
**all_complete** | **bool** |  | 

## Example

```python
from monarch_bridge_client.models.get_refresh_status_response_data import GetRefreshStatusResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetRefreshStatusResponseData from a JSON string
get_refresh_status_response_data_instance = GetRefreshStatusResponseData.from_json(json)
# print the JSON string representation of the object
print(GetRefreshStatusResponseData.to_json())

# convert the object into a dict
get_refresh_status_response_data_dict = get_refresh_status_response_data_instance.to_dict()
# create an instance of GetRefreshStatusResponseData from a dict
get_refresh_status_response_data_from_dict = GetRefreshStatusResponseData.from_dict(get_refresh_status_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


