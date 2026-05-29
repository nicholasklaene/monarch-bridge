# CreateManualTaxLotsBulkRequest

Account id comes from the URL path. Each tax lot row carries its own `holdingId`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tax_lots** | [**List[BulkTaxLotInput]**](BulkTaxLotInput.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_manual_tax_lots_bulk_request import CreateManualTaxLotsBulkRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateManualTaxLotsBulkRequest from a JSON string
create_manual_tax_lots_bulk_request_instance = CreateManualTaxLotsBulkRequest.from_json(json)
# print the JSON string representation of the object
print(CreateManualTaxLotsBulkRequest.to_json())

# convert the object into a dict
create_manual_tax_lots_bulk_request_dict = create_manual_tax_lots_bulk_request_instance.to_dict()
# create an instance of CreateManualTaxLotsBulkRequest from a dict
create_manual_tax_lots_bulk_request_from_dict = CreateManualTaxLotsBulkRequest.from_dict(create_manual_tax_lots_bulk_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


