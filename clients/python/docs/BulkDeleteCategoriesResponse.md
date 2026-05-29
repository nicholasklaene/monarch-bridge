# BulkDeleteCategoriesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**BulkDeleteCategoriesResponseData**](BulkDeleteCategoriesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.bulk_delete_categories_response import BulkDeleteCategoriesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of BulkDeleteCategoriesResponse from a JSON string
bulk_delete_categories_response_instance = BulkDeleteCategoriesResponse.from_json(json)
# print the JSON string representation of the object
print(BulkDeleteCategoriesResponse.to_json())

# convert the object into a dict
bulk_delete_categories_response_dict = bulk_delete_categories_response_instance.to_dict()
# create an instance of BulkDeleteCategoriesResponse from a dict
bulk_delete_categories_response_from_dict = BulkDeleteCategoriesResponse.from_dict(bulk_delete_categories_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


