# UpdateTaxLotResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateManualTaxLotResponseData**](CreateManualTaxLotResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_tax_lot_response import UpdateTaxLotResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateTaxLotResponse from a JSON string
update_tax_lot_response_instance = UpdateTaxLotResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateTaxLotResponse.to_json())

# convert the object into a dict
update_tax_lot_response_dict = update_tax_lot_response_instance.to_dict()
# create an instance of UpdateTaxLotResponse from a dict
update_tax_lot_response_from_dict = UpdateTaxLotResponse.from_dict(update_tax_lot_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


