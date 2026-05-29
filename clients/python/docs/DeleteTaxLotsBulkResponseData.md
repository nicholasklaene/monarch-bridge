# DeleteTaxLotsBulkResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deleted_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.delete_tax_lots_bulk_response_data import DeleteTaxLotsBulkResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteTaxLotsBulkResponseData from a JSON string
delete_tax_lots_bulk_response_data_instance = DeleteTaxLotsBulkResponseData.from_json(json)
# print the JSON string representation of the object
print(DeleteTaxLotsBulkResponseData.to_json())

# convert the object into a dict
delete_tax_lots_bulk_response_data_dict = delete_tax_lots_bulk_response_data_instance.to_dict()
# create an instance of DeleteTaxLotsBulkResponseData from a dict
delete_tax_lots_bulk_response_data_from_dict = DeleteTaxLotsBulkResponseData.from_dict(delete_tax_lots_bulk_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


