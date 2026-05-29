# BulkUpdateHoldingsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**updates** | [**List[BulkUpdateHoldingsEntry]**](BulkUpdateHoldingsEntry.md) |  | 

## Example

```python
from monarch_bridge_client.models.bulk_update_holdings_request import BulkUpdateHoldingsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateHoldingsRequest from a JSON string
bulk_update_holdings_request_instance = BulkUpdateHoldingsRequest.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateHoldingsRequest.to_json())

# convert the object into a dict
bulk_update_holdings_request_dict = bulk_update_holdings_request_instance.to_dict()
# create an instance of BulkUpdateHoldingsRequest from a dict
bulk_update_holdings_request_from_dict = BulkUpdateHoldingsRequest.from_dict(bulk_update_holdings_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


