# DeleteCategoryResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteAccountResponseData**](DeleteAccountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.delete_category_response import DeleteCategoryResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteCategoryResponse from a JSON string
delete_category_response_instance = DeleteCategoryResponse.from_json(json)
# print the JSON string representation of the object
print(DeleteCategoryResponse.to_json())

# convert the object into a dict
delete_category_response_dict = delete_category_response_instance.to_dict()
# create an instance of DeleteCategoryResponse from a dict
delete_category_response_from_dict = DeleteCategoryResponse.from_dict(delete_category_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


