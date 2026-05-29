# DeleteGoalResponse

Confirmation body for `DELETE /v1/goals/{id}/hard`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteAccountResponseData**](DeleteAccountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.delete_goal_response import DeleteGoalResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteGoalResponse from a JSON string
delete_goal_response_instance = DeleteGoalResponse.from_json(json)
# print the JSON string representation of the object
print(DeleteGoalResponse.to_json())

# convert the object into a dict
delete_goal_response_dict = delete_goal_response_instance.to_dict()
# create an instance of DeleteGoalResponse from a dict
delete_goal_response_from_dict = DeleteGoalResponse.from_dict(delete_goal_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


