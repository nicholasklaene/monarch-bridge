# SavingsRateReport


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**overall_savings_rate** | **float** |  | [optional] 
**monthly_rates** | [**List[SavingsRateMonth]**](SavingsRateMonth.md) |  | 

## Example

```python
from monarch_bridge_client.models.savings_rate_report import SavingsRateReport

# TODO update the JSON string below
json = "{}"
# create an instance of SavingsRateReport from a JSON string
savings_rate_report_instance = SavingsRateReport.from_json(json)
# print the JSON string representation of the object
print(SavingsRateReport.to_json())

# convert the object into a dict
savings_rate_report_dict = savings_rate_report_instance.to_dict()
# create an instance of SavingsRateReport from a dict
savings_rate_report_from_dict = SavingsRateReport.from_dict(savings_rate_report_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


