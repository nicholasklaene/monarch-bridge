# CreateManualTaxLotRequest

Holding id comes from the URL path. The account id is derived server-side from the holding. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account_id** | **str** | Optional override for the account id. If absent the bridge does not forward it (Monarch errors if missing, clients should normally pass it).  | [optional] 
**acquisition_date** | **date** |  | 
**acquisition_quantity** | **float** |  | 
**cost_basis_per_unit** | **float** |  | 

## Example

```python
from monarch_bridge_client.models.create_manual_tax_lot_request import CreateManualTaxLotRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateManualTaxLotRequest from a JSON string
create_manual_tax_lot_request_instance = CreateManualTaxLotRequest.from_json(json)
# print the JSON string representation of the object
print(CreateManualTaxLotRequest.to_json())

# convert the object into a dict
create_manual_tax_lot_request_dict = create_manual_tax_lot_request_instance.to_dict()
# create an instance of CreateManualTaxLotRequest from a dict
create_manual_tax_lot_request_from_dict = CreateManualTaxLotRequest.from_dict(create_manual_tax_lot_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


