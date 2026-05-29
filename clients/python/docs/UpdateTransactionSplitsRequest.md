# UpdateTransactionSplitsRequest

Replace the splits on a transaction. Sum of `amount` must equal parent transaction amount.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**split_data** | [**List[Split]**](Split.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_transaction_splits_request import UpdateTransactionSplitsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateTransactionSplitsRequest from a JSON string
update_transaction_splits_request_instance = UpdateTransactionSplitsRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateTransactionSplitsRequest.to_json())

# convert the object into a dict
update_transaction_splits_request_dict = update_transaction_splits_request_instance.to_dict()
# create an instance of UpdateTransactionSplitsRequest from a dict
update_transaction_splits_request_from_dict = UpdateTransactionSplitsRequest.from_dict(update_transaction_splits_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


