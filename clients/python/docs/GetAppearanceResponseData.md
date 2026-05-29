# GetAppearanceResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**appearance** | [**Appearance**](Appearance.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_appearance_response_data import GetAppearanceResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetAppearanceResponseData from a JSON string
get_appearance_response_data_instance = GetAppearanceResponseData.from_json(json)
# print the JSON string representation of the object
print(GetAppearanceResponseData.to_json())

# convert the object into a dict
get_appearance_response_data_dict = get_appearance_response_data_instance.to_dict()
# create an instance of GetAppearanceResponseData from a dict
get_appearance_response_data_from_dict = GetAppearanceResponseData.from_dict(get_appearance_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


