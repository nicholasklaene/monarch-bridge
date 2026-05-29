# PaycheckDeduction

One line-item deduction from a paycheck (pre-tax, tax, post-tax).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**deduction_type** | **str** | Monarch enum of payroll deduction categories (e.g. &#x60;federal_income_tax&#x60;, &#x60;traditional_401k&#x60;, &#x60;medical_insurance&#x60;, &#x60;custom&#x60;). When &#x60;custom&#x60;, see &#x60;customDeductionName&#x60;.  | 
**custom_deduction_name** | **str** | Free-text label when &#x60;deductionType&#x3D;custom&#x60;; null otherwise. | [optional] 
**amount** | **float** | Dollar amount of the deduction (always positive). | 
**created_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.paycheck_deduction import PaycheckDeduction

# TODO update the JSON string below
json = "{}"
# create an instance of PaycheckDeduction from a JSON string
paycheck_deduction_instance = PaycheckDeduction.from_json(json)
# print the JSON string representation of the object
print(PaycheckDeduction.to_json())

# convert the object into a dict
paycheck_deduction_dict = paycheck_deduction_instance.to_dict()
# create an instance of PaycheckDeduction from a dict
paycheck_deduction_from_dict = PaycheckDeduction.from_dict(paycheck_deduction_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


