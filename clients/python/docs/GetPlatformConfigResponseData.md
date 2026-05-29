# GetPlatformConfigResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**platform** | **str** |  | [optional] 
**config_version** | **str** |  | [optional] 
**api_base_url** | **str** |  | [optional] 
**settings** | **List[Dict[str, object]]** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_platform_config_response_data import GetPlatformConfigResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetPlatformConfigResponseData from a JSON string
get_platform_config_response_data_instance = GetPlatformConfigResponseData.from_json(json)
# print the JSON string representation of the object
print(GetPlatformConfigResponseData.to_json())

# convert the object into a dict
get_platform_config_response_data_dict = get_platform_config_response_data_instance.to_dict()
# create an instance of GetPlatformConfigResponseData from a dict
get_platform_config_response_data_from_dict = GetPlatformConfigResponseData.from_dict(get_platform_config_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


