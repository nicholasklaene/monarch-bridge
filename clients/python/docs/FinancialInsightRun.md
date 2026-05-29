# FinancialInsightRun

Most-recent generation run metadata.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**status** | **str** |  | [optional] 
**created_at** | **str** |  | [optional] 
**insights_generated_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.financial_insight_run import FinancialInsightRun

# TODO update the JSON string below
json = "{}"
# create an instance of FinancialInsightRun from a JSON string
financial_insight_run_instance = FinancialInsightRun.from_json(json)
# print the JSON string representation of the object
print(FinancialInsightRun.to_json())

# convert the object into a dict
financial_insight_run_dict = financial_insight_run_instance.to_dict()
# create an instance of FinancialInsightRun from a dict
financial_insight_run_from_dict = FinancialInsightRun.from_dict(financial_insight_run_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


