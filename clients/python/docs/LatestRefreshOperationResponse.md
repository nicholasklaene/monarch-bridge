# LatestRefreshOperationResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetLatestRefreshOperationResponseData**](GetLatestRefreshOperationResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.latest_refresh_operation_response import LatestRefreshOperationResponse

# TODO update the JSON string below
json = "{}"
# create an instance of LatestRefreshOperationResponse from a JSON string
latest_refresh_operation_response_instance = LatestRefreshOperationResponse.from_json(json)
# print the JSON string representation of the object
print(LatestRefreshOperationResponse.to_json())

# convert the object into a dict
latest_refresh_operation_response_dict = latest_refresh_operation_response_instance.to_dict()
# create an instance of LatestRefreshOperationResponse from a dict
latest_refresh_operation_response_from_dict = LatestRefreshOperationResponse.from_dict(latest_refresh_operation_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


