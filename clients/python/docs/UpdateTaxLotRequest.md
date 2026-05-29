# UpdateTaxLotRequest

Partial update. Only present fields are forwarded.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**acquisition_date** | **date** |  | [optional] 
**acquisition_quantity** | **float** |  | [optional] 
**cost_basis_per_unit** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_tax_lot_request import UpdateTaxLotRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateTaxLotRequest from a JSON string
update_tax_lot_request_instance = UpdateTaxLotRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateTaxLotRequest.to_json())

# convert the object into a dict
update_tax_lot_request_dict = update_tax_lot_request_instance.to_dict()
# create an instance of UpdateTaxLotRequest from a dict
update_tax_lot_request_from_dict = UpdateTaxLotRequest.from_dict(update_tax_lot_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


