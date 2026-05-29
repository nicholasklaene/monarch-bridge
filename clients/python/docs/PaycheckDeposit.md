# PaycheckDeposit

One credit-side transaction recorded against a paycheck (multi-deposit support).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**transaction** | [**PaycheckDepositTransaction**](PaycheckDepositTransaction.md) |  | [optional] 
**created_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.paycheck_deposit import PaycheckDeposit

# TODO update the JSON string below
json = "{}"
# create an instance of PaycheckDeposit from a JSON string
paycheck_deposit_instance = PaycheckDeposit.from_json(json)
# print the JSON string representation of the object
print(PaycheckDeposit.to_json())

# convert the object into a dict
paycheck_deposit_dict = paycheck_deposit_instance.to_dict()
# create an instance of PaycheckDeposit from a dict
paycheck_deposit_from_dict = PaycheckDeposit.from_dict(paycheck_deposit_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


