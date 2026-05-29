# BulkTaxLotRowError


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**index** | **int** |  | [optional] 
**error** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_tax_lot_row_error import BulkTaxLotRowError

# TODO update the JSON string below
json = "{}"
# create an instance of BulkTaxLotRowError from a JSON string
bulk_tax_lot_row_error_instance = BulkTaxLotRowError.from_json(json)
# print the JSON string representation of the object
print(BulkTaxLotRowError.to_json())

# convert the object into a dict
bulk_tax_lot_row_error_dict = bulk_tax_lot_row_error_instance.to_dict()
# create an instance of BulkTaxLotRowError from a dict
bulk_tax_lot_row_error_from_dict = BulkTaxLotRowError.from_dict(bulk_tax_lot_row_error_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


