# BulkUpdateHoldingsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**updated_count** | **int** |  | 
**failed_count** | **int** |  | 
**failures** | [**List[BulkUpdateHoldingsFailure]**](BulkUpdateHoldingsFailure.md) |  | 

## Example

```python
from monarch_bridge_client.models.bulk_update_holdings_response_data import BulkUpdateHoldingsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateHoldingsResponseData from a JSON string
bulk_update_holdings_response_data_instance = BulkUpdateHoldingsResponseData.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateHoldingsResponseData.to_json())

# convert the object into a dict
bulk_update_holdings_response_data_dict = bulk_update_holdings_response_data_instance.to_dict()
# create an instance of BulkUpdateHoldingsResponseData from a dict
bulk_update_holdings_response_data_from_dict = BulkUpdateHoldingsResponseData.from_dict(bulk_update_holdings_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


