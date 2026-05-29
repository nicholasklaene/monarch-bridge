# GetGoalContributionHistoryResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**contributions** | [**List[GoalContribution]**](GoalContribution.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_goal_contribution_history_response_data import GetGoalContributionHistoryResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetGoalContributionHistoryResponseData from a JSON string
get_goal_contribution_history_response_data_instance = GetGoalContributionHistoryResponseData.from_json(json)
# print the JSON string representation of the object
print(GetGoalContributionHistoryResponseData.to_json())

# convert the object into a dict
get_goal_contribution_history_response_data_dict = get_goal_contribution_history_response_data_instance.to_dict()
# create an instance of GetGoalContributionHistoryResponseData from a dict
get_goal_contribution_history_response_data_from_dict = GetGoalContributionHistoryResponseData.from_dict(get_goal_contribution_history_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


