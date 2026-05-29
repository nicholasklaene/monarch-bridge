# DeleteTaxLotsBulkResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteTaxLotsBulkResponseData**](DeleteTaxLotsBulkResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.delete_tax_lots_bulk_response import DeleteTaxLotsBulkResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteTaxLotsBulkResponse from a JSON string
delete_tax_lots_bulk_response_instance = DeleteTaxLotsBulkResponse.from_json(json)
# print the JSON string representation of the object
print(DeleteTaxLotsBulkResponse.to_json())

# convert the object into a dict
delete_tax_lots_bulk_response_dict = delete_tax_lots_bulk_response_instance.to_dict()
# create an instance of DeleteTaxLotsBulkResponse from a dict
delete_tax_lots_bulk_response_from_dict = DeleteTaxLotsBulkResponse.from_dict(delete_tax_lots_bulk_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


