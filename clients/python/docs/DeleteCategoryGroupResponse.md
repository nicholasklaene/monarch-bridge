# DeleteCategoryGroupResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteAccountResponseData**](DeleteAccountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.delete_category_group_response import DeleteCategoryGroupResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteCategoryGroupResponse from a JSON string
delete_category_group_response_instance = DeleteCategoryGroupResponse.from_json(json)
# print the JSON string representation of the object
print(DeleteCategoryGroupResponse.to_json())

# convert the object into a dict
delete_category_group_response_dict = delete_category_group_response_instance.to_dict()
# create an instance of DeleteCategoryGroupResponse from a dict
delete_category_group_response_from_dict = DeleteCategoryGroupResponse.from_dict(delete_category_group_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


