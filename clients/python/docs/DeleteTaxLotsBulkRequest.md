# DeleteTaxLotsBulkRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | **List[str]** |  | 

## Example

```python
from monarch_bridge_client.models.delete_tax_lots_bulk_request import DeleteTaxLotsBulkRequest

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteTaxLotsBulkRequest from a JSON string
delete_tax_lots_bulk_request_instance = DeleteTaxLotsBulkRequest.from_json(json)
# print the JSON string representation of the object
print(DeleteTaxLotsBulkRequest.to_json())

# convert the object into a dict
delete_tax_lots_bulk_request_dict = delete_tax_lots_bulk_request_instance.to_dict()
# create an instance of DeleteTaxLotsBulkRequest from a dict
delete_tax_lots_bulk_request_from_dict = DeleteTaxLotsBulkRequest.from_dict(delete_tax_lots_bulk_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


