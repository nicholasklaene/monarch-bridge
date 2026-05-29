# WithdrawFromGoalResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**goal_event_id** | **str** |  | 
**goal_id** | **str** |  | [optional] 
**goal_current_balance** | **float** |  | [optional] 
**goal_progress** | **float** |  | [optional] 
**goal_status** | **str** |  | [optional] 
**account_id** | **str** |  | [optional] 
**account_available_balance_for_goals** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.withdraw_from_goal_response_data import WithdrawFromGoalResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of WithdrawFromGoalResponseData from a JSON string
withdraw_from_goal_response_data_instance = WithdrawFromGoalResponseData.from_json(json)
# print the JSON string representation of the object
print(WithdrawFromGoalResponseData.to_json())

# convert the object into a dict
withdraw_from_goal_response_data_dict = withdraw_from_goal_response_data_instance.to_dict()
# create an instance of WithdrawFromGoalResponseData from a dict
withdraw_from_goal_response_data_from_dict = WithdrawFromGoalResponseData.from_dict(withdraw_from_goal_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


