# UpdateTransactionSplitsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transaction_id** | **str** |  | 
**has_split_transactions** | **bool** |  | 
**split_transactions** | [**List[TransactionSplit]**](TransactionSplit.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_transaction_splits_response_data import UpdateTransactionSplitsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateTransactionSplitsResponseData from a JSON string
update_transaction_splits_response_data_instance = UpdateTransactionSplitsResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateTransactionSplitsResponseData.to_json())

# convert the object into a dict
update_transaction_splits_response_data_dict = update_transaction_splits_response_data_instance.to_dict()
# create an instance of UpdateTransactionSplitsResponseData from a dict
update_transaction_splits_response_data_from_dict = UpdateTransactionSplitsResponseData.from_dict(update_transaction_splits_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


