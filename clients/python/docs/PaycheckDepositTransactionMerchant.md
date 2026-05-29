# PaycheckDepositTransactionMerchant


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.paycheck_deposit_transaction_merchant import PaycheckDepositTransactionMerchant

# TODO update the JSON string below
json = "{}"
# create an instance of PaycheckDepositTransactionMerchant from a JSON string
paycheck_deposit_transaction_merchant_instance = PaycheckDepositTransactionMerchant.from_json(json)
# print the JSON string representation of the object
print(PaycheckDepositTransactionMerchant.to_json())

# convert the object into a dict
paycheck_deposit_transaction_merchant_dict = paycheck_deposit_transaction_merchant_instance.to_dict()
# create an instance of PaycheckDepositTransactionMerchant from a dict
paycheck_deposit_transaction_merchant_from_dict = PaycheckDepositTransactionMerchant.from_dict(paycheck_deposit_transaction_merchant_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


