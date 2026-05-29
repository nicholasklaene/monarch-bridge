# Appearance


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**theme** | **str** |  | [optional] 
**accent_color** | **str** |  | [optional] 
**compact_mode** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.appearance import Appearance

# TODO update the JSON string below
json = "{}"
# create an instance of Appearance from a JSON string
appearance_instance = Appearance.from_json(json)
# print the JSON string representation of the object
print(Appearance.to_json())

# convert the object into a dict
appearance_dict = appearance_instance.to_dict()
# create an instance of Appearance from a dict
appearance_from_dict = Appearance.from_dict(appearance_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


