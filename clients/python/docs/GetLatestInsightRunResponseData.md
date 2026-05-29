# GetLatestInsightRunResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**latest_run** | [**LatestFinancialInsightRun**](LatestFinancialInsightRun.md) |  | [optional] 
**insights_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_latest_insight_run_response_data import GetLatestInsightRunResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetLatestInsightRunResponseData from a JSON string
get_latest_insight_run_response_data_instance = GetLatestInsightRunResponseData.from_json(json)
# print the JSON string representation of the object
print(GetLatestInsightRunResponseData.to_json())

# convert the object into a dict
get_latest_insight_run_response_data_dict = get_latest_insight_run_response_data_instance.to_dict()
# create an instance of GetLatestInsightRunResponseData from a dict
get_latest_insight_run_response_data_from_dict = GetLatestInsightRunResponseData.from_dict(get_latest_insight_run_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


