# PaychecksSummaryDeduction

Aggregated deduction total for one deduction type within the summary window.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deduction_type** | **str** |  | 
**total_amount** | **float** |  | 

## Example

```python
from monarch_bridge_client.models.paychecks_summary_deduction import PaychecksSummaryDeduction

# TODO update the JSON string below
json = "{}"
# create an instance of PaychecksSummaryDeduction from a JSON string
paychecks_summary_deduction_instance = PaychecksSummaryDeduction.from_json(json)
# print the JSON string representation of the object
print(PaychecksSummaryDeduction.to_json())

# convert the object into a dict
paychecks_summary_deduction_dict = paychecks_summary_deduction_instance.to_dict()
# create an instance of PaychecksSummaryDeduction from a dict
paychecks_summary_deduction_from_dict = PaychecksSummaryDeduction.from_dict(paychecks_summary_deduction_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


