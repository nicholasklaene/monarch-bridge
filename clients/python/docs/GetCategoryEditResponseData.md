# GetCategoryEditResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category** | [**CategoryEditFields**](CategoryEditFields.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_category_edit_response_data import GetCategoryEditResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCategoryEditResponseData from a JSON string
get_category_edit_response_data_instance = GetCategoryEditResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCategoryEditResponseData.to_json())

# convert the object into a dict
get_category_edit_response_data_dict = get_category_edit_response_data_instance.to_dict()
# create an instance of GetCategoryEditResponseData from a dict
get_category_edit_response_data_from_dict = GetCategoryEditResponseData.from_dict(get_category_edit_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


