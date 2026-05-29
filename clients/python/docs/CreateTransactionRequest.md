# CreateTransactionRequest

Body for `POST /v1/transactions`. `amount` is signed - negative for expenses, positive for income. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **str** |  | 
**account_id** | **str** |  | 
**amount** | **float** | Signed amount. | 
**merchant_name** | **str** |  | 
**category_id** | **str** |  | 
**notes** | **str** |  | [optional] [default to '']
**should_update_balance** | **bool** | If true, Monarch re-syncs the affected account&#39;s balance after creation. | [optional] [default to False]

## Example

```python
from monarch_bridge_client.models.create_transaction_request import CreateTransactionRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateTransactionRequest from a JSON string
create_transaction_request_instance = CreateTransactionRequest.from_json(json)
# print the JSON string representation of the object
print(CreateTransactionRequest.to_json())

# convert the object into a dict
create_transaction_request_dict = create_transaction_request_instance.to_dict()
# create an instance of CreateTransactionRequest from a dict
create_transaction_request_from_dict = CreateTransactionRequest.from_dict(create_transaction_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


