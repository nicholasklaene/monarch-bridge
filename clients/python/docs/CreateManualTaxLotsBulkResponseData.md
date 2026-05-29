# CreateManualTaxLotsBulkResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tax_lots** | [**List[TaxLot]**](TaxLot.md) |  | 
**errors** | [**List[BulkTaxLotRowError]**](BulkTaxLotRowError.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.create_manual_tax_lots_bulk_response_data import CreateManualTaxLotsBulkResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of CreateManualTaxLotsBulkResponseData from a JSON string
create_manual_tax_lots_bulk_response_data_instance = CreateManualTaxLotsBulkResponseData.from_json(json)
# print the JSON string representation of the object
print(CreateManualTaxLotsBulkResponseData.to_json())

# convert the object into a dict
create_manual_tax_lots_bulk_response_data_dict = create_manual_tax_lots_bulk_response_data_instance.to_dict()
# create an instance of CreateManualTaxLotsBulkResponseData from a dict
create_manual_tax_lots_bulk_response_data_from_dict = CreateManualTaxLotsBulkResponseData.from_dict(create_manual_tax_lots_bulk_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


