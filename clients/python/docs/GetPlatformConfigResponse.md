# GetPlatformConfigResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetPlatformConfigResponseData**](GetPlatformConfigResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_platform_config_response import GetPlatformConfigResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetPlatformConfigResponse from a JSON string
get_platform_config_response_instance = GetPlatformConfigResponse.from_json(json)
# print the JSON string representation of the object
print(GetPlatformConfigResponse.to_json())

# convert the object into a dict
get_platform_config_response_dict = get_platform_config_response_instance.to_dict()
# create an instance of GetPlatformConfigResponse from a dict
get_platform_config_response_from_dict = GetPlatformConfigResponse.from_dict(get_platform_config_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


