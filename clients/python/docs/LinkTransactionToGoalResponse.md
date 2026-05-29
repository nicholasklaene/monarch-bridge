# LinkTransactionToGoalResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**LinkTransactionToGoalResponseData**](LinkTransactionToGoalResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.link_transaction_to_goal_response import LinkTransactionToGoalResponse

# TODO update the JSON string below
json = "{}"
# create an instance of LinkTransactionToGoalResponse from a JSON string
link_transaction_to_goal_response_instance = LinkTransactionToGoalResponse.from_json(json)
# print the JSON string representation of the object
print(LinkTransactionToGoalResponse.to_json())

# convert the object into a dict
link_transaction_to_goal_response_dict = link_transaction_to_goal_response_instance.to_dict()
# create an instance of LinkTransactionToGoalResponse from a dict
link_transaction_to_goal_response_from_dict = LinkTransactionToGoalResponse.from_dict(link_transaction_to_goal_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


