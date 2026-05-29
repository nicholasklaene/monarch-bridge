# SpendingReport


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total_spend** | **float** |  | [optional] 
**total_budget** | **float** |  | [optional] 
**percent_of_budget** | **float** |  | [optional] 
**top_categories** | [**List[SpendingReportCategory]**](SpendingReportCategory.md) |  | 

## Example

```python
from monarch_bridge_client.models.spending_report import SpendingReport

# TODO update the JSON string below
json = "{}"
# create an instance of SpendingReport from a JSON string
spending_report_instance = SpendingReport.from_json(json)
# print the JSON string representation of the object
print(SpendingReport.to_json())

# convert the object into a dict
spending_report_dict = spending_report_instance.to_dict()
# create an instance of SpendingReport from a dict
spending_report_from_dict = SpendingReport.from_dict(spending_report_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


