# CreatePaycheckRequest

Body for `POST /v1/paychecks`. Maps to Monarch's `CreatePaycheckInput`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**employer_id** | **str** | Id from &#x60;GET /v1/paycheck-employers&#x60;. Create one first if you don&#39;t have it. | 
**gross_amount** | **float** | Total gross pay before deductions, in dollars. | 
**pay_date** | **str** | Day the funds hit the bank, &#x60;YYYY-MM-DD&#x60;. | 
**pay_period_start** | **str** |  | [optional] 
**pay_period_end** | **str** |  | [optional] 
**payroll_provider** | **str** | One of Monarch&#39;s &#x60;PayrollProvider&#x60; enum values. | [optional] 
**owner_id** | **str** | Household member id; omit to default to the calling user. | [optional] 
**deductions** | [**List[PaycheckDeductionInput]**](PaycheckDeductionInput.md) |  | [optional] 
**deposits** | [**List[PaycheckDepositInput]**](PaycheckDepositInput.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.create_paycheck_request import CreatePaycheckRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreatePaycheckRequest from a JSON string
create_paycheck_request_instance = CreatePaycheckRequest.from_json(json)
# print the JSON string representation of the object
print(CreatePaycheckRequest.to_json())

# convert the object into a dict
create_paycheck_request_dict = create_paycheck_request_instance.to_dict()
# create an instance of CreatePaycheckRequest from a dict
create_paycheck_request_from_dict = CreatePaycheckRequest.from_dict(create_paycheck_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


