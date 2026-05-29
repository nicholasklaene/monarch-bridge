# TransactionAccountRef

Minimal account reference embedded in a transaction.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**display_name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_account_ref import TransactionAccountRef

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionAccountRef from a JSON string
transaction_account_ref_instance = TransactionAccountRef.from_json(json)
# print the JSON string representation of the object
print(TransactionAccountRef.to_json())

# convert the object into a dict
transaction_account_ref_dict = transaction_account_ref_instance.to_dict()
# create an instance of TransactionAccountRef from a dict
transaction_account_ref_from_dict = TransactionAccountRef.from_dict(transaction_account_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


