# IncomeReportSource


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_id** | **str** |  | 
**name** | **str** |  | 
**amount** | **float** |  | [optional] 
**percent_of_total** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.income_report_source import IncomeReportSource

# TODO update the JSON string below
json = "{}"
# create an instance of IncomeReportSource from a JSON string
income_report_source_instance = IncomeReportSource.from_json(json)
# print the JSON string representation of the object
print(IncomeReportSource.to_json())

# convert the object into a dict
income_report_source_dict = income_report_source_instance.to_dict()
# create an instance of IncomeReportSource from a dict
income_report_source_from_dict = IncomeReportSource.from_dict(income_report_source_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


