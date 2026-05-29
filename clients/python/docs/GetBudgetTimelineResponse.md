# GetBudgetTimelineResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetBudgetTimelineResponseData**](GetBudgetTimelineResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_budget_timeline_response import GetBudgetTimelineResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetBudgetTimelineResponse from a JSON string
get_budget_timeline_response_instance = GetBudgetTimelineResponse.from_json(json)
# print the JSON string representation of the object
print(GetBudgetTimelineResponse.to_json())

# convert the object into a dict
get_budget_timeline_response_dict = get_budget_timeline_response_instance.to_dict()
# create an instance of GetBudgetTimelineResponse from a dict
get_budget_timeline_response_from_dict = GetBudgetTimelineResponse.from_dict(get_budget_timeline_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


