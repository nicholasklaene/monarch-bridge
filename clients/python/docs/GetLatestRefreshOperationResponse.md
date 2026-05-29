# GetLatestRefreshOperationResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetLatestRefreshOperationResponseData**](GetLatestRefreshOperationResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_latest_refresh_operation_response import GetLatestRefreshOperationResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetLatestRefreshOperationResponse from a JSON string
get_latest_refresh_operation_response_instance = GetLatestRefreshOperationResponse.from_json(json)
# print the JSON string representation of the object
print(GetLatestRefreshOperationResponse.to_json())

# convert the object into a dict
get_latest_refresh_operation_response_dict = get_latest_refresh_operation_response_instance.to_dict()
# create an instance of GetLatestRefreshOperationResponse from a dict
get_latest_refresh_operation_response_from_dict = GetLatestRefreshOperationResponse.from_dict(get_latest_refresh_operation_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


