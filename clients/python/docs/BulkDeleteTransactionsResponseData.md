# BulkDeleteTransactionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**success** | **bool** | Monarch&#39;s mutation-level success flag. | 
**affected_count** | **int** | Number of rows Monarch actually deleted. | 
**errors** | [**List[BulkMutationError]**](BulkMutationError.md) | Per-row error messages (typically null on success). | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_delete_transactions_response_data import BulkDeleteTransactionsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of BulkDeleteTransactionsResponseData from a JSON string
bulk_delete_transactions_response_data_instance = BulkDeleteTransactionsResponseData.from_json(json)
# print the JSON string representation of the object
print(BulkDeleteTransactionsResponseData.to_json())

# convert the object into a dict
bulk_delete_transactions_response_data_dict = bulk_delete_transactions_response_data_instance.to_dict()
# create an instance of BulkDeleteTransactionsResponseData from a dict
bulk_delete_transactions_response_data_from_dict = BulkDeleteTransactionsResponseData.from_dict(bulk_delete_transactions_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


