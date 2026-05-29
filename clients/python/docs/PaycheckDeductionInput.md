# PaycheckDeductionInput

One deduction line-item to attach when creating or replacing a paycheck.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deduction_type** | **str** | Monarch&#39;s &#x60;PaycheckDeductionType&#x60; enum (e.g. &#x60;federal_income_tax&#x60;, &#x60;traditional_401k&#x60;, &#x60;medical_insurance&#x60;, &#x60;custom&#x60;). Use &#x60;custom&#x60; for free-form labels.  | 
**custom_deduction_name** | **str** | Required when &#x60;deductionType&#x3D;custom&#x60;; ignored otherwise. | [optional] 
**amount** | **float** | Dollar amount of the deduction (positive). | 

## Example

```python
from monarch_bridge_client.models.paycheck_deduction_input import PaycheckDeductionInput

# TODO update the JSON string below
json = "{}"
# create an instance of PaycheckDeductionInput from a JSON string
paycheck_deduction_input_instance = PaycheckDeductionInput.from_json(json)
# print the JSON string representation of the object
print(PaycheckDeductionInput.to_json())

# convert the object into a dict
paycheck_deduction_input_dict = paycheck_deduction_input_instance.to_dict()
# create an instance of PaycheckDeductionInput from a dict
paycheck_deduction_input_from_dict = PaycheckDeductionInput.from_dict(paycheck_deduction_input_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


