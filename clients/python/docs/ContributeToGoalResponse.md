# ContributeToGoalResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ContributeToGoalResponseData**](ContributeToGoalResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.contribute_to_goal_response import ContributeToGoalResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ContributeToGoalResponse from a JSON string
contribute_to_goal_response_instance = ContributeToGoalResponse.from_json(json)
# print the JSON string representation of the object
print(ContributeToGoalResponse.to_json())

# convert the object into a dict
contribute_to_goal_response_dict = contribute_to_goal_response_instance.to_dict()
# create an instance of ContributeToGoalResponse from a dict
contribute_to_goal_response_from_dict = ContributeToGoalResponse.from_dict(contribute_to_goal_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


