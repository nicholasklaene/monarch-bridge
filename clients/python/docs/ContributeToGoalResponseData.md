# ContributeToGoalResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**user_notice** | **str** |  | [optional] 
**goal_event** | [**ContributeToGoalResponseDataGoalEvent**](ContributeToGoalResponseDataGoalEvent.md) |  | 

## Example

```python
from monarch_bridge_client.models.contribute_to_goal_response_data import ContributeToGoalResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ContributeToGoalResponseData from a JSON string
contribute_to_goal_response_data_instance = ContributeToGoalResponseData.from_json(json)
# print the JSON string representation of the object
print(ContributeToGoalResponseData.to_json())

# convert the object into a dict
contribute_to_goal_response_data_dict = contribute_to_goal_response_data_instance.to_dict()
# create an instance of ContributeToGoalResponseData from a dict
contribute_to_goal_response_data_from_dict = ContributeToGoalResponseData.from_dict(contribute_to_goal_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


