# MoveTransactionsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**MoveTransactionsResponseData**](MoveTransactionsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.move_transactions_response import MoveTransactionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MoveTransactionsResponse from a JSON string
move_transactions_response_instance = MoveTransactionsResponse.from_json(json)
# print the JSON string representation of the object
print(MoveTransactionsResponse.to_json())

# convert the object into a dict
move_transactions_response_dict = move_transactions_response_instance.to_dict()
# create an instance of MoveTransactionsResponse from a dict
move_transactions_response_from_dict = MoveTransactionsResponse.from_dict(move_transactions_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


