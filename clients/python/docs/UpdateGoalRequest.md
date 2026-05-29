# UpdateGoalRequest

Partial update for `PATCH /v1/goals/{id}`. Send only the fields you want to change. Maps to a subset of Monarch's `UpdateSavingsGoalInput` (the practical edit surface; deeper account-link + budget-cascade fields have dedicated endpoints). 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**target_amount** | **float** |  | [optional] 
**target_date** | **str** | ISO date &#x60;YYYY-MM-DD&#x60;. | [optional] 
**priority** | **int** |  | [optional] 
**is_sinking_fund** | **bool** |  | [optional] 
**image_storage_provider** | **str** |  | [optional] 
**image_storage_provider_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_goal_request import UpdateGoalRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateGoalRequest from a JSON string
update_goal_request_instance = UpdateGoalRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateGoalRequest.to_json())

# convert the object into a dict
update_goal_request_dict = update_goal_request_instance.to_dict()
# create an instance of UpdateGoalRequest from a dict
update_goal_request_from_dict = UpdateGoalRequest.from_dict(update_goal_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


