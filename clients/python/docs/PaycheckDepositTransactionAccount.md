# PaycheckDepositTransactionAccount


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.paycheck_deposit_transaction_account import PaycheckDepositTransactionAccount

# TODO update the JSON string below
json = "{}"
# create an instance of PaycheckDepositTransactionAccount from a JSON string
paycheck_deposit_transaction_account_instance = PaycheckDepositTransactionAccount.from_json(json)
# print the JSON string representation of the object
print(PaycheckDepositTransactionAccount.to_json())

# convert the object into a dict
paycheck_deposit_transaction_account_dict = paycheck_deposit_transaction_account_instance.to_dict()
# create an instance of PaycheckDepositTransactionAccount from a dict
paycheck_deposit_transaction_account_from_dict = PaycheckDepositTransactionAccount.from_dict(paycheck_deposit_transaction_account_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


