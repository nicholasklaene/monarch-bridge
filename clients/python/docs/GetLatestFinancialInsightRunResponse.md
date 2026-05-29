# GetLatestFinancialInsightRunResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetLatestInsightRunResponseData**](GetLatestInsightRunResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_latest_financial_insight_run_response import GetLatestFinancialInsightRunResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetLatestFinancialInsightRunResponse from a JSON string
get_latest_financial_insight_run_response_instance = GetLatestFinancialInsightRunResponse.from_json(json)
# print the JSON string representation of the object
print(GetLatestFinancialInsightRunResponse.to_json())

# convert the object into a dict
get_latest_financial_insight_run_response_dict = get_latest_financial_insight_run_response_instance.to_dict()
# create an instance of GetLatestFinancialInsightRunResponse from a dict
get_latest_financial_insight_run_response_from_dict = GetLatestFinancialInsightRunResponse.from_dict(get_latest_financial_insight_run_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


