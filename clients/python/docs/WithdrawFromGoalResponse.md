# WithdrawFromGoalResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**WithdrawFromGoalResponseData**](WithdrawFromGoalResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.withdraw_from_goal_response import WithdrawFromGoalResponse

# TODO update the JSON string below
json = "{}"
# create an instance of WithdrawFromGoalResponse from a JSON string
withdraw_from_goal_response_instance = WithdrawFromGoalResponse.from_json(json)
# print the JSON string representation of the object
print(WithdrawFromGoalResponse.to_json())

# convert the object into a dict
withdraw_from_goal_response_dict = withdraw_from_goal_response_instance.to_dict()
# create an instance of WithdrawFromGoalResponse from a dict
withdraw_from_goal_response_from_dict = WithdrawFromGoalResponse.from_dict(withdraw_from_goal_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


