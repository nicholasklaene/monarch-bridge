# LinkTransactionToGoalRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**goal_id** | **str** | Target Monarch goal id. | 

## Example

```python
from monarch_bridge_client.models.link_transaction_to_goal_request import LinkTransactionToGoalRequest

# TODO update the JSON string below
json = "{}"
# create an instance of LinkTransactionToGoalRequest from a JSON string
link_transaction_to_goal_request_instance = LinkTransactionToGoalRequest.from_json(json)
# print the JSON string representation of the object
print(LinkTransactionToGoalRequest.to_json())

# convert the object into a dict
link_transaction_to_goal_request_dict = link_transaction_to_goal_request_instance.to_dict()
# create an instance of LinkTransactionToGoalRequest from a dict
link_transaction_to_goal_request_from_dict = LinkTransactionToGoalRequest.from_dict(link_transaction_to_goal_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


