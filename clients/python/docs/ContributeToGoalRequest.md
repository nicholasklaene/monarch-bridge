# ContributeToGoalRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account_id** | **str** | Monarch account id the contribution is drawn from. | 
**amount** | **float** | Dollars (positive &#x3D; contribution, negative &#x3D; withdrawal). | 
**var_date** | **str** | ISO date &#x60;YYYY-MM-DD&#x60;; defaults to today. | [optional] 

## Example

```python
from monarch_bridge_client.models.contribute_to_goal_request import ContributeToGoalRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ContributeToGoalRequest from a JSON string
contribute_to_goal_request_instance = ContributeToGoalRequest.from_json(json)
# print the JSON string representation of the object
print(ContributeToGoalRequest.to_json())

# convert the object into a dict
contribute_to_goal_request_dict = contribute_to_goal_request_instance.to_dict()
# create an instance of ContributeToGoalRequest from a dict
contribute_to_goal_request_from_dict = ContributeToGoalRequest.from_dict(contribute_to_goal_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


