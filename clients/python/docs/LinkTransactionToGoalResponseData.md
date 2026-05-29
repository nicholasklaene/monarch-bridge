# LinkTransactionToGoalResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**goal_event_id** | **str** |  | 
**transaction_id** | **str** |  | [optional] 
**goal_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.link_transaction_to_goal_response_data import LinkTransactionToGoalResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of LinkTransactionToGoalResponseData from a JSON string
link_transaction_to_goal_response_data_instance = LinkTransactionToGoalResponseData.from_json(json)
# print the JSON string representation of the object
print(LinkTransactionToGoalResponseData.to_json())

# convert the object into a dict
link_transaction_to_goal_response_data_dict = link_transaction_to_goal_response_data_instance.to_dict()
# create an instance of LinkTransactionToGoalResponseData from a dict
link_transaction_to_goal_response_data_from_dict = LinkTransactionToGoalResponseData.from_dict(link_transaction_to_goal_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


