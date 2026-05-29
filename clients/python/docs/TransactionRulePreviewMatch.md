# TransactionRulePreviewMatch

One transaction that would be matched, plus the new values the rule would apply.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transaction** | [**Transaction**](Transaction.md) |  | [optional] 
**new_name** | **str** |  | [optional] 
**new_split_transactions** | **List[Dict[str, object]]** |  | [optional] 
**new_category** | [**Ref**](Ref.md) |  | [optional] 
**new_owner_is_joint** | **bool** |  | [optional] 
**new_hide_from_reports** | **bool** |  | [optional] 
**new_tags** | [**List[Ref]**](Ref.md) |  | [optional] 
**new_goal** | [**Ref**](Ref.md) |  | [optional] 
**new_business_entity** | [**Ref**](Ref.md) |  | [optional] 
**new_business_entity_is_unassigned** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_rule_preview_match import TransactionRulePreviewMatch

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionRulePreviewMatch from a JSON string
transaction_rule_preview_match_instance = TransactionRulePreviewMatch.from_json(json)
# print the JSON string representation of the object
print(TransactionRulePreviewMatch.to_json())

# convert the object into a dict
transaction_rule_preview_match_dict = transaction_rule_preview_match_instance.to_dict()
# create an instance of TransactionRulePreviewMatch from a dict
transaction_rule_preview_match_from_dict = TransactionRulePreviewMatch.from_dict(transaction_rule_preview_match_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


