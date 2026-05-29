# UpdateGoalsPrioritiesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateGoalsPrioritiesResponseData**](UpdateGoalsPrioritiesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_goals_priorities_response import UpdateGoalsPrioritiesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateGoalsPrioritiesResponse from a JSON string
update_goals_priorities_response_instance = UpdateGoalsPrioritiesResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateGoalsPrioritiesResponse.to_json())

# convert the object into a dict
update_goals_priorities_response_dict = update_goals_priorities_response_instance.to_dict()
# create an instance of UpdateGoalsPrioritiesResponse from a dict
update_goals_priorities_response_from_dict = UpdateGoalsPrioritiesResponse.from_dict(update_goals_priorities_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


