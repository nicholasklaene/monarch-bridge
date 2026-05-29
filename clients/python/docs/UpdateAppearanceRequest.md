# UpdateAppearanceRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**theme** | **str** |  | [optional] 
**accent_color** | **str** |  | [optional] 
**compact_mode** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_appearance_request import UpdateAppearanceRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateAppearanceRequest from a JSON string
update_appearance_request_instance = UpdateAppearanceRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateAppearanceRequest.to_json())

# convert the object into a dict
update_appearance_request_dict = update_appearance_request_instance.to_dict()
# create an instance of UpdateAppearanceRequest from a dict
update_appearance_request_from_dict = UpdateAppearanceRequest.from_dict(update_appearance_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


