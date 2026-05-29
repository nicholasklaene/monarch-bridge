# CreateGoalResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**goal** | [**Goal**](Goal.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_goal_response_data import CreateGoalResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of CreateGoalResponseData from a JSON string
create_goal_response_data_instance = CreateGoalResponseData.from_json(json)
# print the JSON string representation of the object
print(CreateGoalResponseData.to_json())

# convert the object into a dict
create_goal_response_data_dict = create_goal_response_data_instance.to_dict()
# create an instance of CreateGoalResponseData from a dict
create_goal_response_data_from_dict = CreateGoalResponseData.from_dict(create_goal_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


