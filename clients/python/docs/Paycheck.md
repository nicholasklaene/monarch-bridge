# Paycheck

One paycheck - gross amount plus its breakdown of deductions and bank deposits.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**employer** | [**PaycheckEmployerRef**](PaycheckEmployerRef.md) | Reference to the persisted employer; null for legacy paychecks before the registry shipped. | [optional] 
**employer_name** | **str** | Denormalized employer label. Always present even when &#x60;employer&#x60; is null (Monarch keeps it on the row for historical paychecks).  | [optional] 
**payroll_provider** | **str** | One of Monarch&#39;s &#x60;PayrollProvider&#x60; enum values (e.g. &#x60;adp&#x60;, &#x60;gusto&#x60;, &#x60;paychex&#x60;, &#x60;rippling&#x60;, &#x60;other&#x60;). Null for manually-entered paychecks.  | [optional] 
**pay_date** | **str** | Day the funds hit the bank, &#x60;YYYY-MM-DD&#x60;. | 
**pay_period_start** | **str** | First day of the period this paycheck covers, &#x60;YYYY-MM-DD&#x60;. | [optional] 
**pay_period_end** | **str** | Last day of the period this paycheck covers, &#x60;YYYY-MM-DD&#x60;. | [optional] 
**gross_amount** | **float** | Total gross pay before deductions, in dollars. | 
**created_at** | **str** |  | [optional] 
**is_magic_imported** | **bool** | True when the paycheck was auto-imported from Monarch&#39;s Magic Import. | [optional] 
**owner** | [**PaycheckOwner**](PaycheckOwner.md) |  | [optional] 
**created_by** | [**PaycheckCreatedBy**](PaycheckCreatedBy.md) |  | [optional] 
**deductions** | [**List[PaycheckDeduction]**](PaycheckDeduction.md) |  | [optional] 
**deposits** | [**List[PaycheckDeposit]**](PaycheckDeposit.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.paycheck import Paycheck

# TODO update the JSON string below
json = "{}"
# create an instance of Paycheck from a JSON string
paycheck_instance = Paycheck.from_json(json)
# print the JSON string representation of the object
print(Paycheck.to_json())

# convert the object into a dict
paycheck_dict = paycheck_instance.to_dict()
# create an instance of Paycheck from a dict
paycheck_from_dict = Paycheck.from_dict(paycheck_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


