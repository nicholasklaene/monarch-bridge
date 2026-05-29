# CreateGoalResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateGoalResponseData**](CreateGoalResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_goal_response import CreateGoalResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreateGoalResponse from a JSON string
create_goal_response_instance = CreateGoalResponse.from_json(json)
# print the JSON string representation of the object
print(CreateGoalResponse.to_json())

# convert the object into a dict
create_goal_response_dict = create_goal_response_instance.to_dict()
# create an instance of CreateGoalResponse from a dict
create_goal_response_from_dict = CreateGoalResponse.from_dict(create_goal_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


