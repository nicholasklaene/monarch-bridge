# GetCategoryEditResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCategoryEditResponseData**](GetCategoryEditResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_category_edit_response import GetCategoryEditResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCategoryEditResponse from a JSON string
get_category_edit_response_instance = GetCategoryEditResponse.from_json(json)
# print the JSON string representation of the object
print(GetCategoryEditResponse.to_json())

# convert the object into a dict
get_category_edit_response_dict = get_category_edit_response_instance.to_dict()
# create an instance of GetCategoryEditResponse from a dict
get_category_edit_response_from_dict = GetCategoryEditResponse.from_dict(get_category_edit_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


