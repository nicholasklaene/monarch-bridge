# BulkUpdateHoldingsEntry

One row in a bulk-update holdings payload.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**holding_id** | **str** |  | 
**quantity** | **float** |  | [optional] 
**cost_basis** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_update_holdings_entry import BulkUpdateHoldingsEntry

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateHoldingsEntry from a JSON string
bulk_update_holdings_entry_instance = BulkUpdateHoldingsEntry.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateHoldingsEntry.to_json())

# convert the object into a dict
bulk_update_holdings_entry_dict = bulk_update_holdings_entry_instance.to_dict()
# create an instance of BulkUpdateHoldingsEntry from a dict
bulk_update_holdings_entry_from_dict = BulkUpdateHoldingsEntry.from_dict(bulk_update_holdings_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


