# GetAppVersionResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**current** | **str** |  | [optional] 
**minimum** | **str** |  | [optional] 
**recommended** | **str** |  | [optional] 
**build_sha** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_app_version_response_data import GetAppVersionResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetAppVersionResponseData from a JSON string
get_app_version_response_data_instance = GetAppVersionResponseData.from_json(json)
# print the JSON string representation of the object
print(GetAppVersionResponseData.to_json())

# convert the object into a dict
get_app_version_response_data_dict = get_app_version_response_data_instance.to_dict()
# create an instance of GetAppVersionResponseData from a dict
get_app_version_response_data_from_dict = GetAppVersionResponseData.from_dict(get_app_version_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


