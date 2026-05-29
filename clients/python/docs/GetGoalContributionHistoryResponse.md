# GetGoalContributionHistoryResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetGoalContributionHistoryResponseData**](GetGoalContributionHistoryResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_goal_contribution_history_response import GetGoalContributionHistoryResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetGoalContributionHistoryResponse from a JSON string
get_goal_contribution_history_response_instance = GetGoalContributionHistoryResponse.from_json(json)
# print the JSON string representation of the object
print(GetGoalContributionHistoryResponse.to_json())

# convert the object into a dict
get_goal_contribution_history_response_dict = get_goal_contribution_history_response_instance.to_dict()
# create an instance of GetGoalContributionHistoryResponse from a dict
get_goal_contribution_history_response_from_dict = GetGoalContributionHistoryResponse.from_dict(get_goal_contribution_history_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


