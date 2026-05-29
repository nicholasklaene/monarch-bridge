# GetRefreshStatusResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetRefreshStatusResponseData**](GetRefreshStatusResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_refresh_status_response import GetRefreshStatusResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetRefreshStatusResponse from a JSON string
get_refresh_status_response_instance = GetRefreshStatusResponse.from_json(json)
# print the JSON string representation of the object
print(GetRefreshStatusResponse.to_json())

# convert the object into a dict
get_refresh_status_response_dict = get_refresh_status_response_instance.to_dict()
# create an instance of GetRefreshStatusResponse from a dict
get_refresh_status_response_from_dict = GetRefreshStatusResponse.from_dict(get_refresh_status_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


