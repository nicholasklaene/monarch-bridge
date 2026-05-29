# FinancialInsightSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total_captured_savings** | **float** |  | [optional] 
**completed_count** | **int** |  | [optional] 
**total_identified_savings_low** | **float** |  | [optional] 
**total_identified_savings_high** | **float** |  | [optional] 
**accepted_count** | **int** |  | [optional] 
**in_progress_count** | **int** |  | [optional] 
**new_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.financial_insight_summary import FinancialInsightSummary

# TODO update the JSON string below
json = "{}"
# create an instance of FinancialInsightSummary from a JSON string
financial_insight_summary_instance = FinancialInsightSummary.from_json(json)
# print the JSON string representation of the object
print(FinancialInsightSummary.to_json())

# convert the object into a dict
financial_insight_summary_dict = financial_insight_summary_instance.to_dict()
# create an instance of FinancialInsightSummary from a dict
financial_insight_summary_from_dict = FinancialInsightSummary.from_dict(financial_insight_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


