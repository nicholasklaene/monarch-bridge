# BulkMutationError

One error entry from a Monarch bulk mutation.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**message** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_mutation_error import BulkMutationError

# TODO update the JSON string below
json = "{}"
# create an instance of BulkMutationError from a JSON string
bulk_mutation_error_instance = BulkMutationError.from_json(json)
# print the JSON string representation of the object
print(BulkMutationError.to_json())

# convert the object into a dict
bulk_mutation_error_dict = bulk_mutation_error_instance.to_dict()
# create an instance of BulkMutationError from a dict
bulk_mutation_error_from_dict = BulkMutationError.from_dict(bulk_mutation_error_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


