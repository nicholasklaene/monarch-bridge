# TransactionRuleSplitAction

Auto-split action. Break the matched transaction into N children by amount or percentage.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount_type** | **str** | One of &#x60;ABSOLUTE&#x60;, &#x60;PERCENTAGE&#x60;. Drives interpretation of each &#x60;splitsInfo[].amount&#x60;. | [optional] 
**splits_info** | [**List[TransactionRuleSplitInfo]**](TransactionRuleSplitInfo.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_rule_split_action import TransactionRuleSplitAction

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionRuleSplitAction from a JSON string
transaction_rule_split_action_instance = TransactionRuleSplitAction.from_json(json)
# print the JSON string representation of the object
print(TransactionRuleSplitAction.to_json())

# convert the object into a dict
transaction_rule_split_action_dict = transaction_rule_split_action_instance.to_dict()
# create an instance of TransactionRuleSplitAction from a dict
transaction_rule_split_action_from_dict = TransactionRuleSplitAction.from_dict(transaction_rule_split_action_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


