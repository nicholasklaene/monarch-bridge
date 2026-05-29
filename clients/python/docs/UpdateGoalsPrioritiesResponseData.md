# UpdateGoalsPrioritiesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**goals** | [**List[GoalPriority]**](GoalPriority.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_goals_priorities_response_data import UpdateGoalsPrioritiesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateGoalsPrioritiesResponseData from a JSON string
update_goals_priorities_response_data_instance = UpdateGoalsPrioritiesResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateGoalsPrioritiesResponseData.to_json())

# convert the object into a dict
update_goals_priorities_response_data_dict = update_goals_priorities_response_data_instance.to_dict()
# create an instance of UpdateGoalsPrioritiesResponseData from a dict
update_goals_priorities_response_data_from_dict = UpdateGoalsPrioritiesResponseData.from_dict(update_goals_priorities_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


