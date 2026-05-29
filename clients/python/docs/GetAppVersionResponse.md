# GetAppVersionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetAppVersionResponseData**](GetAppVersionResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_app_version_response import GetAppVersionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetAppVersionResponse from a JSON string
get_app_version_response_instance = GetAppVersionResponse.from_json(json)
# print the JSON string representation of the object
print(GetAppVersionResponse.to_json())

# convert the object into a dict
get_app_version_response_dict = get_app_version_response_instance.to_dict()
# create an instance of GetAppVersionResponse from a dict
get_app_version_response_from_dict = GetAppVersionResponse.from_dict(get_app_version_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


