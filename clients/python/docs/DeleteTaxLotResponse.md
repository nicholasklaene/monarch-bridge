# DeleteTaxLotResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteTaxLotResponseData**](DeleteTaxLotResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.delete_tax_lot_response import DeleteTaxLotResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteTaxLotResponse from a JSON string
delete_tax_lot_response_instance = DeleteTaxLotResponse.from_json(json)
# print the JSON string representation of the object
print(DeleteTaxLotResponse.to_json())

# convert the object into a dict
delete_tax_lot_response_dict = delete_tax_lot_response_instance.to_dict()
# create an instance of DeleteTaxLotResponse from a dict
delete_tax_lot_response_from_dict = DeleteTaxLotResponse.from_dict(delete_tax_lot_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


