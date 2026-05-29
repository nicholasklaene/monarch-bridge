# BulkDeleteCategoriesRequest

Body for `POST /v1/categories/bulk-delete`. Each id in `ids` is forwarded to the existing single-id delete operation. `moveToCategoryId`, if present, is applied to every per-id delete. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | **List[str]** | Category ids to delete. | 
**move_to_category_id** | **str** | Optional remap target applied to each per-id delete. | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_delete_categories_request import BulkDeleteCategoriesRequest

# TODO update the JSON string below
json = "{}"
# create an instance of BulkDeleteCategoriesRequest from a JSON string
bulk_delete_categories_request_instance = BulkDeleteCategoriesRequest.from_json(json)
# print the JSON string representation of the object
print(BulkDeleteCategoriesRequest.to_json())

# convert the object into a dict
bulk_delete_categories_request_dict = bulk_delete_categories_request_instance.to_dict()
# create an instance of BulkDeleteCategoriesRequest from a dict
bulk_delete_categories_request_from_dict = BulkDeleteCategoriesRequest.from_dict(bulk_delete_categories_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


