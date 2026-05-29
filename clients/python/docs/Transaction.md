# Transaction

A Monarch transaction.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**var_date** | **date** |  | 
**amount** | **float** | Signed. Negative &#x3D; expense, positive &#x3D; income. | 
**pending** | **bool** |  | [optional] 
**plaid_name** | **str** |  | [optional] 
**notes** | **str** |  | [optional] 
**hide_from_reports** | **bool** |  | [optional] 
**needs_review** | **bool** |  | [optional] 
**is_recurring** | **bool** |  | [optional] 
**is_split_transaction** | **bool** |  | [optional] 
**created_at** | **str** |  | [optional] 
**updated_at** | **str** |  | [optional] 
**account** | [**TransactionAccountRef**](TransactionAccountRef.md) |  | [optional] 
**merchant** | [**MerchantRef**](MerchantRef.md) |  | [optional] 
**category** | [**Ref**](Ref.md) |  | [optional] 
**tags** | [**List[TagRef]**](TagRef.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction import Transaction

# TODO update the JSON string below
json = "{}"
# create an instance of Transaction from a JSON string
transaction_instance = Transaction.from_json(json)
# print the JSON string representation of the object
print(Transaction.to_json())

# convert the object into a dict
transaction_dict = transaction_instance.to_dict()
# create an instance of Transaction from a dict
transaction_from_dict = Transaction.from_dict(transaction_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


