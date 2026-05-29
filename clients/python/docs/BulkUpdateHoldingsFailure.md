# BulkUpdateHoldingsFailure


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**holding_id** | **str** |  | 
**reason** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_update_holdings_failure import BulkUpdateHoldingsFailure

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateHoldingsFailure from a JSON string
bulk_update_holdings_failure_instance = BulkUpdateHoldingsFailure.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateHoldingsFailure.to_json())

# convert the object into a dict
bulk_update_holdings_failure_dict = bulk_update_holdings_failure_instance.to_dict()
# create an instance of BulkUpdateHoldingsFailure from a dict
bulk_update_holdings_failure_from_dict = BulkUpdateHoldingsFailure.from_dict(bulk_update_holdings_failure_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


