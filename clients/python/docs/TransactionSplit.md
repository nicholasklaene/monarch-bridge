# TransactionSplit

One split row inside a transaction's split set.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**amount** | **float** | Signed. | [optional] 
**notes** | **str** |  | [optional] 
**merchant_name** | **str** |  | [optional] 
**category_name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_split import TransactionSplit

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionSplit from a JSON string
transaction_split_instance = TransactionSplit.from_json(json)
# print the JSON string representation of the object
print(TransactionSplit.to_json())

# convert the object into a dict
transaction_split_dict = transaction_split_instance.to_dict()
# create an instance of TransactionSplit from a dict
transaction_split_from_dict = TransactionSplit.from_dict(transaction_split_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


