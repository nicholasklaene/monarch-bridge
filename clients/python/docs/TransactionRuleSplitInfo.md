# TransactionRuleSplitInfo

One entry in `splitTransactionsAction.splitsInfo`. Defines a child split the rule will create on match.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_id** | **str** |  | [optional] 
**merchant_name** | **str** |  | [optional] 
**amount** | **float** | Required when amountType is ABSOLUTE; required as a percentage 0-100 when amountType is PERCENTAGE. | [optional] 
**goal_id** | **str** |  | [optional] 
**savings_goal_id** | **str** |  | [optional] 
**tags** | **List[str]** |  | [optional] 
**hide_from_reports** | **bool** |  | [optional] 
**review_status** | **str** |  | [optional] 
**needs_review_by_user_id** | **str** |  | [optional] 
**owner_user_id** | **str** |  | [optional] 
**owner_is_joint** | **bool** |  | [optional] 
**business_entity_id** | **str** |  | [optional] 
**business_entity_is_unassigned** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_rule_split_info import TransactionRuleSplitInfo

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionRuleSplitInfo from a JSON string
transaction_rule_split_info_instance = TransactionRuleSplitInfo.from_json(json)
# print the JSON string representation of the object
print(TransactionRuleSplitInfo.to_json())

# convert the object into a dict
transaction_rule_split_info_dict = transaction_rule_split_info_instance.to_dict()
# create an instance of TransactionRuleSplitInfo from a dict
transaction_rule_split_info_from_dict = TransactionRuleSplitInfo.from_dict(transaction_rule_split_info_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


