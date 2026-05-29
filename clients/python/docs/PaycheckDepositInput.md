# PaycheckDepositInput

One bank-side transaction id to record as a deposit for this paycheck.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transaction_id** | **str** |  | 

## Example

```python
from monarch_bridge_client.models.paycheck_deposit_input import PaycheckDepositInput

# TODO update the JSON string below
json = "{}"
# create an instance of PaycheckDepositInput from a JSON string
paycheck_deposit_input_instance = PaycheckDepositInput.from_json(json)
# print the JSON string representation of the object
print(PaycheckDepositInput.to_json())

# convert the object into a dict
paycheck_deposit_input_dict = paycheck_deposit_input_instance.to_dict()
# create an instance of PaycheckDepositInput from a dict
paycheck_deposit_input_from_dict = PaycheckDepositInput.from_dict(paycheck_deposit_input_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


