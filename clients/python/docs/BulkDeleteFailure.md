# BulkDeleteFailure


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** | Category id that failed to delete. | 
**reason** | **str** | Upstream exception message captured from the per-id delete. | 

## Example

```python
from monarch_bridge_client.models.bulk_delete_failure import BulkDeleteFailure

# TODO update the JSON string below
json = "{}"
# create an instance of BulkDeleteFailure from a JSON string
bulk_delete_failure_instance = BulkDeleteFailure.from_json(json)
# print the JSON string representation of the object
print(BulkDeleteFailure.to_json())

# convert the object into a dict
bulk_delete_failure_dict = bulk_delete_failure_instance.to_dict()
# create an instance of BulkDeleteFailure from a dict
bulk_delete_failure_from_dict = BulkDeleteFailure.from_dict(bulk_delete_failure_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


