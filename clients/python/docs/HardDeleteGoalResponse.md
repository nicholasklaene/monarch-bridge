# HardDeleteGoalResponse

Confirmation body for `DELETE /v1/goals/{id}/hard`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteAccountResponseData**](DeleteAccountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.hard_delete_goal_response import HardDeleteGoalResponse

# TODO update the JSON string below
json = "{}"
# create an instance of HardDeleteGoalResponse from a JSON string
hard_delete_goal_response_instance = HardDeleteGoalResponse.from_json(json)
# print the JSON string representation of the object
print(HardDeleteGoalResponse.to_json())

# convert the object into a dict
hard_delete_goal_response_dict = hard_delete_goal_response_instance.to_dict()
# create an instance of HardDeleteGoalResponse from a dict
hard_delete_goal_response_from_dict = HardDeleteGoalResponse.from_dict(hard_delete_goal_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


