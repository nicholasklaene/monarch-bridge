# BulkUpdateTransactionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**success** | **bool** |  | 
**affected_count** | **int** | Number of rows Monarch actually updated. | 
**errors** | [**List[BulkMutationError]**](BulkMutationError.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_update_transactions_response_data import BulkUpdateTransactionsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateTransactionsResponseData from a JSON string
bulk_update_transactions_response_data_instance = BulkUpdateTransactionsResponseData.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateTransactionsResponseData.to_json())

# convert the object into a dict
bulk_update_transactions_response_data_dict = bulk_update_transactions_response_data_instance.to_dict()
# create an instance of BulkUpdateTransactionsResponseData from a dict
bulk_update_transactions_response_data_from_dict = BulkUpdateTransactionsResponseData.from_dict(bulk_update_transactions_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


