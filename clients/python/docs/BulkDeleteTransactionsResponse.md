# BulkDeleteTransactionsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**BulkDeleteTransactionsResponseData**](BulkDeleteTransactionsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.bulk_delete_transactions_response import BulkDeleteTransactionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of BulkDeleteTransactionsResponse from a JSON string
bulk_delete_transactions_response_instance = BulkDeleteTransactionsResponse.from_json(json)
# print the JSON string representation of the object
print(BulkDeleteTransactionsResponse.to_json())

# convert the object into a dict
bulk_delete_transactions_response_dict = bulk_delete_transactions_response_instance.to_dict()
# create an instance of BulkDeleteTransactionsResponse from a dict
bulk_delete_transactions_response_from_dict = BulkDeleteTransactionsResponse.from_dict(bulk_delete_transactions_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


