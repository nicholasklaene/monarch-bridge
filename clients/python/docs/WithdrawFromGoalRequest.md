# WithdrawFromGoalRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **float** | Dollar amount to withdraw (positive). | 
**account_id** | **str** | Source account id (where the goal balance is parked). | 
**var_date** | **date** | Withdrawal date. Defaults to today. | [optional] 

## Example

```python
from monarch_bridge_client.models.withdraw_from_goal_request import WithdrawFromGoalRequest

# TODO update the JSON string below
json = "{}"
# create an instance of WithdrawFromGoalRequest from a JSON string
withdraw_from_goal_request_instance = WithdrawFromGoalRequest.from_json(json)
# print the JSON string representation of the object
print(WithdrawFromGoalRequest.to_json())

# convert the object into a dict
withdraw_from_goal_request_dict = withdraw_from_goal_request_instance.to_dict()
# create an instance of WithdrawFromGoalRequest from a dict
withdraw_from_goal_request_from_dict = WithdrawFromGoalRequest.from_dict(withdraw_from_goal_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


