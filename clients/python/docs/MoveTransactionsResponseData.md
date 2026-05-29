# MoveTransactionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**num_transactions_moved** | **int** |  | 
**errors** | [**List[MoveTransactionsResponseDataErrorsInner]**](MoveTransactionsResponseDataErrorsInner.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.move_transactions_response_data import MoveTransactionsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of MoveTransactionsResponseData from a JSON string
move_transactions_response_data_instance = MoveTransactionsResponseData.from_json(json)
# print the JSON string representation of the object
print(MoveTransactionsResponseData.to_json())

# convert the object into a dict
move_transactions_response_data_dict = move_transactions_response_data_instance.to_dict()
# create an instance of MoveTransactionsResponseData from a dict
move_transactions_response_data_from_dict = MoveTransactionsResponseData.from_dict(move_transactions_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


