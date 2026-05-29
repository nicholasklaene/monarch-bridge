# UpdatePaycheckRequest

Body for `PATCH /v1/paychecks/{id}`. All fields optional; only set fields are sent to Monarch. Lists (`deductions`, `deposits`) are wholesale-replace when present, matching Monarch's `UpdatePaycheckInput` semantics. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**employer_id** | **str** |  | [optional] 
**gross_amount** | **float** |  | [optional] 
**pay_date** | **str** |  | [optional] 
**pay_period_start** | **str** |  | [optional] 
**pay_period_end** | **str** |  | [optional] 
**payroll_provider** | **str** |  | [optional] 
**owner_id** | **str** |  | [optional] 
**deductions** | [**List[PaycheckDeductionInput]**](PaycheckDeductionInput.md) |  | [optional] 
**deposits** | [**List[PaycheckDepositInput]**](PaycheckDepositInput.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_paycheck_request import UpdatePaycheckRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdatePaycheckRequest from a JSON string
update_paycheck_request_instance = UpdatePaycheckRequest.from_json(json)
# print the JSON string representation of the object
print(UpdatePaycheckRequest.to_json())

# convert the object into a dict
update_paycheck_request_dict = update_paycheck_request_instance.to_dict()
# create an instance of UpdatePaycheckRequest from a dict
update_paycheck_request_from_dict = UpdatePaycheckRequest.from_dict(update_paycheck_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


