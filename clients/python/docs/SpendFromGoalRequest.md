# SpendFromGoalRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **float** | Dollar amount spent (positive). | 
**var_date** | **date** | Spend date. Defaults to today. | [optional] 
**notes** | **str** | Optional caller-supplied note for the event. | [optional] 

## Example

```python
from monarch_bridge_client.models.spend_from_goal_request import SpendFromGoalRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SpendFromGoalRequest from a JSON string
spend_from_goal_request_instance = SpendFromGoalRequest.from_json(json)
# print the JSON string representation of the object
print(SpendFromGoalRequest.to_json())

# convert the object into a dict
spend_from_goal_request_dict = spend_from_goal_request_instance.to_dict()
# create an instance of SpendFromGoalRequest from a dict
spend_from_goal_request_from_dict = SpendFromGoalRequest.from_dict(spend_from_goal_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


