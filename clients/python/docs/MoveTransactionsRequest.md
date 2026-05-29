# MoveTransactionsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transaction_ids** | **List[str]** | Transaction ids to move. | 
**to_account_id** | **str** | Destination Monarch account id. | 

## Example

```python
from monarch_bridge_client.models.move_transactions_request import MoveTransactionsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of MoveTransactionsRequest from a JSON string
move_transactions_request_instance = MoveTransactionsRequest.from_json(json)
# print the JSON string representation of the object
print(MoveTransactionsRequest.to_json())

# convert the object into a dict
move_transactions_request_dict = move_transactions_request_instance.to_dict()
# create an instance of MoveTransactionsRequest from a dict
move_transactions_request_from_dict = MoveTransactionsRequest.from_dict(move_transactions_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


