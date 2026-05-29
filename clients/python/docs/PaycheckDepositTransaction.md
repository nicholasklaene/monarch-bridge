# PaycheckDepositTransaction

The matched bank-side transaction that funded one paycheck deposit.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**amount** | **float** |  | [optional] 
**var_date** | **str** |  | [optional] 
**merchant** | [**PaycheckDepositTransactionMerchant**](PaycheckDepositTransactionMerchant.md) |  | [optional] 
**account** | [**PaycheckDepositTransactionAccount**](PaycheckDepositTransactionAccount.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.paycheck_deposit_transaction import PaycheckDepositTransaction

# TODO update the JSON string below
json = "{}"
# create an instance of PaycheckDepositTransaction from a JSON string
paycheck_deposit_transaction_instance = PaycheckDepositTransaction.from_json(json)
# print the JSON string representation of the object
print(PaycheckDepositTransaction.to_json())

# convert the object into a dict
paycheck_deposit_transaction_dict = paycheck_deposit_transaction_instance.to_dict()
# create an instance of PaycheckDepositTransaction from a dict
paycheck_deposit_transaction_from_dict = PaycheckDepositTransaction.from_dict(paycheck_deposit_transaction_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


