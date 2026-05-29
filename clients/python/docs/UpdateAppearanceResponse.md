# UpdateAppearanceResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetAppearanceResponseData**](GetAppearanceResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_appearance_response import UpdateAppearanceResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateAppearanceResponse from a JSON string
update_appearance_response_instance = UpdateAppearanceResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateAppearanceResponse.to_json())

# convert the object into a dict
update_appearance_response_dict = update_appearance_response_instance.to_dict()
# create an instance of UpdateAppearanceResponse from a dict
update_appearance_response_from_dict = UpdateAppearanceResponse.from_dict(update_appearance_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


