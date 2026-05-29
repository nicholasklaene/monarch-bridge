# TransactionsDuplicatesResponse

Groups of likely-duplicate transactions in the requested window. Each group's `transactions` list always has length > 1; singletons are filtered out. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionsDuplicatesResponseData**](GetTransactionsDuplicatesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.transactions_duplicates_response import TransactionsDuplicatesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionsDuplicatesResponse from a JSON string
transactions_duplicates_response_instance = TransactionsDuplicatesResponse.from_json(json)
# print the JSON string representation of the object
print(TransactionsDuplicatesResponse.to_json())

# convert the object into a dict
transactions_duplicates_response_dict = transactions_duplicates_response_instance.to_dict()
# create an instance of TransactionsDuplicatesResponse from a dict
transactions_duplicates_response_from_dict = TransactionsDuplicatesResponse.from_dict(transactions_duplicates_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


