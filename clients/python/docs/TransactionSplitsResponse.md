# TransactionSplitsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionSplitsResponseData**](GetTransactionSplitsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.transaction_splits_response import TransactionSplitsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionSplitsResponse from a JSON string
transaction_splits_response_instance = TransactionSplitsResponse.from_json(json)
# print the JSON string representation of the object
print(TransactionSplitsResponse.to_json())

# convert the object into a dict
transaction_splits_response_dict = transaction_splits_response_instance.to_dict()
# create an instance of TransactionSplitsResponse from a dict
transaction_splits_response_from_dict = TransactionSplitsResponse.from_dict(transaction_splits_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


