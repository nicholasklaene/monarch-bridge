# CreateManualTaxLotsBulkResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateManualTaxLotsBulkResponseData**](CreateManualTaxLotsBulkResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_manual_tax_lots_bulk_response import CreateManualTaxLotsBulkResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreateManualTaxLotsBulkResponse from a JSON string
create_manual_tax_lots_bulk_response_instance = CreateManualTaxLotsBulkResponse.from_json(json)
# print the JSON string representation of the object
print(CreateManualTaxLotsBulkResponse.to_json())

# convert the object into a dict
create_manual_tax_lots_bulk_response_dict = create_manual_tax_lots_bulk_response_instance.to_dict()
# create an instance of CreateManualTaxLotsBulkResponse from a dict
create_manual_tax_lots_bulk_response_from_dict = CreateManualTaxLotsBulkResponse.from_dict(create_manual_tax_lots_bulk_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


