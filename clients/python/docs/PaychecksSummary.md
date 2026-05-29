# PaychecksSummary

Aggregate paycheck stats over a date window.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**count** | **int** | Number of paychecks in the window. | 
**total_gross** | **float** | Sum of &#x60;grossAmount&#x60; across all paychecks in window. | 
**total_deductions** | **float** |  | 
**total_net** | **float** | totalGross minus totalDeductions. | 
**deduction_rate** | **float** | totalDeductions / totalGross, 0.0 to 1.0. | [optional] 
**deductions_by_type** | [**List[PaychecksSummaryDeduction]**](PaychecksSummaryDeduction.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.paychecks_summary import PaychecksSummary

# TODO update the JSON string below
json = "{}"
# create an instance of PaychecksSummary from a JSON string
paychecks_summary_instance = PaychecksSummary.from_json(json)
# print the JSON string representation of the object
print(PaychecksSummary.to_json())

# convert the object into a dict
paychecks_summary_dict = paychecks_summary_instance.to_dict()
# create an instance of PaychecksSummary from a dict
paychecks_summary_from_dict = PaychecksSummary.from_dict(paychecks_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


