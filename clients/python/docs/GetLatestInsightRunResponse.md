# GetLatestInsightRunResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetLatestInsightRunResponseData**](GetLatestInsightRunResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_latest_insight_run_response import GetLatestInsightRunResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetLatestInsightRunResponse from a JSON string
get_latest_insight_run_response_instance = GetLatestInsightRunResponse.from_json(json)
# print the JSON string representation of the object
print(GetLatestInsightRunResponse.to_json())

# convert the object into a dict
get_latest_insight_run_response_dict = get_latest_insight_run_response_instance.to_dict()
# create an instance of GetLatestInsightRunResponse from a dict
get_latest_insight_run_response_from_dict = GetLatestInsightRunResponse.from_dict(get_latest_insight_run_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


