# RefreshStatusResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetRefreshStatusResponseData**](GetRefreshStatusResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.refresh_status_response import RefreshStatusResponse

# TODO update the JSON string below
json = "{}"
# create an instance of RefreshStatusResponse from a JSON string
refresh_status_response_instance = RefreshStatusResponse.from_json(json)
# print the JSON string representation of the object
print(RefreshStatusResponse.to_json())

# convert the object into a dict
refresh_status_response_dict = refresh_status_response_instance.to_dict()
# create an instance of RefreshStatusResponse from a dict
refresh_status_response_from_dict = RefreshStatusResponse.from_dict(refresh_status_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


