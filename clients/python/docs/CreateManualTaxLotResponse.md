# CreateManualTaxLotResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateManualTaxLotResponseData**](CreateManualTaxLotResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_manual_tax_lot_response import CreateManualTaxLotResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreateManualTaxLotResponse from a JSON string
create_manual_tax_lot_response_instance = CreateManualTaxLotResponse.from_json(json)
# print the JSON string representation of the object
print(CreateManualTaxLotResponse.to_json())

# convert the object into a dict
create_manual_tax_lot_response_dict = create_manual_tax_lot_response_instance.to_dict()
# create an instance of CreateManualTaxLotResponse from a dict
create_manual_tax_lot_response_from_dict = CreateManualTaxLotResponse.from_dict(create_manual_tax_lot_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


