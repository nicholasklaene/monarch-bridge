# GetAppearanceResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetAppearanceResponseData**](GetAppearanceResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_appearance_response import GetAppearanceResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetAppearanceResponse from a JSON string
get_appearance_response_instance = GetAppearanceResponse.from_json(json)
# print the JSON string representation of the object
print(GetAppearanceResponse.to_json())

# convert the object into a dict
get_appearance_response_dict = get_appearance_response_instance.to_dict()
# create an instance of GetAppearanceResponse from a dict
get_appearance_response_from_dict = GetAppearanceResponse.from_dict(get_appearance_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


