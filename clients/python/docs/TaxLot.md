# TaxLot

One manual cost-basis tax lot under a holding. `acquisitionQuantity` / `costBasisPerUnit` express the per-share cost basis at acquisition. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**created_at** | **str** |  | [optional] 
**acquisition_date** | **date** |  | [optional] 
**acquisition_quantity** | **float** |  | [optional] 
**cost_basis_per_unit** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.tax_lot import TaxLot

# TODO update the JSON string below
json = "{}"
# create an instance of TaxLot from a JSON string
tax_lot_instance = TaxLot.from_json(json)
# print the JSON string representation of the object
print(TaxLot.to_json())

# convert the object into a dict
tax_lot_dict = tax_lot_instance.to_dict()
# create an instance of TaxLot from a dict
tax_lot_from_dict = TaxLot.from_dict(tax_lot_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


