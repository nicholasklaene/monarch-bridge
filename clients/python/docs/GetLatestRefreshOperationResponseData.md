# GetLatestRefreshOperationResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**operation** | [**LatestRefreshOperation**](LatestRefreshOperation.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_latest_refresh_operation_response_data import GetLatestRefreshOperationResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetLatestRefreshOperationResponseData from a JSON string
get_latest_refresh_operation_response_data_instance = GetLatestRefreshOperationResponseData.from_json(json)
# print the JSON string representation of the object
print(GetLatestRefreshOperationResponseData.to_json())

# convert the object into a dict
get_latest_refresh_operation_response_data_dict = get_latest_refresh_operation_response_data_instance.to_dict()
# create an instance of GetLatestRefreshOperationResponseData from a dict
get_latest_refresh_operation_response_data_from_dict = GetLatestRefreshOperationResponseData.from_dict(get_latest_refresh_operation_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


