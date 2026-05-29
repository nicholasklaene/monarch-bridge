# ContributeToGoalResponseDataGoalEventAccount


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**available_balance_for_goals_unmemoized** | **float** |  | [optional] 
**include_in_goal_contributions** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.contribute_to_goal_response_data_goal_event_account import ContributeToGoalResponseDataGoalEventAccount

# TODO update the JSON string below
json = "{}"
# create an instance of ContributeToGoalResponseDataGoalEventAccount from a JSON string
contribute_to_goal_response_data_goal_event_account_instance = ContributeToGoalResponseDataGoalEventAccount.from_json(json)
# print the JSON string representation of the object
print(ContributeToGoalResponseDataGoalEventAccount.to_json())

# convert the object into a dict
contribute_to_goal_response_data_goal_event_account_dict = contribute_to_goal_response_data_goal_event_account_instance.to_dict()
# create an instance of ContributeToGoalResponseDataGoalEventAccount from a dict
contribute_to_goal_response_data_goal_event_account_from_dict = ContributeToGoalResponseDataGoalEventAccount.from_dict(contribute_to_goal_response_data_goal_event_account_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


