# BulkDeleteCategoriesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deleted** | **List[str]** | Ids that were deleted successfully. | 
**failed** | [**List[BulkDeleteFailure]**](BulkDeleteFailure.md) | Per-id failures (the bulk endpoint itself still returns 200). | 

## Example

```python
from monarch_bridge_client.models.bulk_delete_categories_response_data import BulkDeleteCategoriesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of BulkDeleteCategoriesResponseData from a JSON string
bulk_delete_categories_response_data_instance = BulkDeleteCategoriesResponseData.from_json(json)
# print the JSON string representation of the object
print(BulkDeleteCategoriesResponseData.to_json())

# convert the object into a dict
bulk_delete_categories_response_data_dict = bulk_delete_categories_response_data_instance.to_dict()
# create an instance of BulkDeleteCategoriesResponseData from a dict
bulk_delete_categories_response_data_from_dict = BulkDeleteCategoriesResponseData.from_dict(bulk_delete_categories_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


