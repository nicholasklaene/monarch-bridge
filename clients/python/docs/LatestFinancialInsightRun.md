# LatestFinancialInsightRun


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**status** | **str** |  | [optional] 
**error_message** | **str** |  | [optional] 
**insights_generated_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.latest_financial_insight_run import LatestFinancialInsightRun

# TODO update the JSON string below
json = "{}"
# create an instance of LatestFinancialInsightRun from a JSON string
latest_financial_insight_run_instance = LatestFinancialInsightRun.from_json(json)
# print the JSON string representation of the object
print(LatestFinancialInsightRun.to_json())

# convert the object into a dict
latest_financial_insight_run_dict = latest_financial_insight_run_instance.to_dict()
# create an instance of LatestFinancialInsightRun from a dict
latest_financial_insight_run_from_dict = LatestFinancialInsightRun.from_dict(latest_financial_insight_run_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


