# SpendFromGoalResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**SpendFromGoalResponseData**](SpendFromGoalResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.spend_from_goal_response import SpendFromGoalResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SpendFromGoalResponse from a JSON string
spend_from_goal_response_instance = SpendFromGoalResponse.from_json(json)
# print the JSON string representation of the object
print(SpendFromGoalResponse.to_json())

# convert the object into a dict
spend_from_goal_response_dict = spend_from_goal_response_instance.to_dict()
# create an instance of SpendFromGoalResponse from a dict
spend_from_goal_response_from_dict = SpendFromGoalResponse.from_dict(spend_from_goal_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


