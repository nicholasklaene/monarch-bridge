# BulkTaxLotInput


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**holding_id** | **str** |  | 
**acquisition_date** | **date** |  | 
**acquisition_quantity** | **float** |  | 
**cost_basis_per_unit** | **float** |  | 

## Example

```python
from monarch_bridge_client.models.bulk_tax_lot_input import BulkTaxLotInput

# TODO update the JSON string below
json = "{}"
# create an instance of BulkTaxLotInput from a JSON string
bulk_tax_lot_input_instance = BulkTaxLotInput.from_json(json)
# print the JSON string representation of the object
print(BulkTaxLotInput.to_json())

# convert the object into a dict
bulk_tax_lot_input_dict = bulk_tax_lot_input_instance.to_dict()
# create an instance of BulkTaxLotInput from a dict
bulk_tax_lot_input_from_dict = BulkTaxLotInput.from_dict(bulk_tax_lot_input_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


