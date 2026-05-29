# BulkUpdateHoldingsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**BulkUpdateHoldingsResponseData**](BulkUpdateHoldingsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.bulk_update_holdings_response import BulkUpdateHoldingsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateHoldingsResponse from a JSON string
bulk_update_holdings_response_instance = BulkUpdateHoldingsResponse.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateHoldingsResponse.to_json())

# convert the object into a dict
bulk_update_holdings_response_dict = bulk_update_holdings_response_instance.to_dict()
# create an instance of BulkUpdateHoldingsResponse from a dict
bulk_update_holdings_response_from_dict = BulkUpdateHoldingsResponse.from_dict(bulk_update_holdings_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


