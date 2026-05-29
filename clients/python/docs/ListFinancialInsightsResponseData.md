# ListFinancialInsightsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**insights** | [**List[FinancialInsight]**](FinancialInsight.md) |  | 
**summary** | [**FinancialInsightSummary**](FinancialInsightSummary.md) |  | [optional] 
**latest_run** | [**FinancialInsightRun**](FinancialInsightRun.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.list_financial_insights_response_data import ListFinancialInsightsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListFinancialInsightsResponseData from a JSON string
list_financial_insights_response_data_instance = ListFinancialInsightsResponseData.from_json(json)
# print the JSON string representation of the object
print(ListFinancialInsightsResponseData.to_json())

# convert the object into a dict
list_financial_insights_response_data_dict = list_financial_insights_response_data_instance.to_dict()
# create an instance of ListFinancialInsightsResponseData from a dict
list_financial_insights_response_data_from_dict = ListFinancialInsightsResponseData.from_dict(list_financial_insights_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


