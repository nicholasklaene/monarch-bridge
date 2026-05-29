# CreateGoalRequest

Body for `POST /v1/goals`. Wraps Monarch's batch `createSavingsGoals` mutation as a single-goal convenience. `imageStorageProvider` + `imageStorageProviderId` are picked from Monarch's stock goal-image library; omit for the default fallback. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**type** | **str** | One of &#x60;savings&#x60;, &#x60;debt&#x60;. | [optional] [default to 'savings']
**target_amount** | **float** |  | [optional] 
**target_date** | **str** | ISO date &#x60;YYYY-MM-DD&#x60;. | [optional] 
**image_storage_provider** | **str** |  | [optional] 
**image_storage_provider_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.create_goal_request import CreateGoalRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateGoalRequest from a JSON string
create_goal_request_instance = CreateGoalRequest.from_json(json)
# print the JSON string representation of the object
print(CreateGoalRequest.to_json())

# convert the object into a dict
create_goal_request_dict = create_goal_request_instance.to_dict()
# create an instance of CreateGoalRequest from a dict
create_goal_request_from_dict = CreateGoalRequest.from_dict(create_goal_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


