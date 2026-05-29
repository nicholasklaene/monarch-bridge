# TransactionRule

Auto-categorization rule. Every criteria + action field is nullable; only the fields the user enabled in the rule builder come back populated. `categoryIds`, `accountIds`, `criteriaBusinessEntityIds`, `criteriaOwnerUserIds` are inclusion sets (match when the txn belongs to one of these); the action fields drive what happens to each matched txn. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**order** | **int** |  | [optional] 
**merchant_criteria_use_original_statement** | **bool** |  | [optional] 
**merchant_criteria** | [**List[TransactionRuleStringCriterion]**](TransactionRuleStringCriterion.md) |  | [optional] 
**original_statement_criteria** | [**List[TransactionRuleStringCriterion]**](TransactionRuleStringCriterion.md) |  | [optional] 
**merchant_name_criteria** | [**List[TransactionRuleStringCriterion]**](TransactionRuleStringCriterion.md) |  | [optional] 
**amount_criteria** | [**TransactionRuleAmountCriterion**](TransactionRuleAmountCriterion.md) |  | [optional] 
**category_ids** | **List[str]** |  | [optional] 
**account_ids** | **List[str]** |  | [optional] 
**criteria_owner_is_joint** | **bool** |  | [optional] 
**criteria_owner_user_ids** | **List[str]** |  | [optional] 
**criteria_business_entity_ids** | **List[str]** |  | [optional] 
**criteria_business_entity_is_unassigned** | **bool** |  | [optional] 
**set_merchant_action** | [**Ref**](Ref.md) |  | [optional] 
**set_category_action** | [**Ref**](Ref.md) |  | [optional] 
**add_tags_action** | [**List[Ref]**](Ref.md) |  | [optional] 
**link_goal_action** | [**Ref**](Ref.md) |  | [optional] 
**link_savings_goal_action** | [**Ref**](Ref.md) |  | [optional] 
**needs_review_by_user_action** | [**Ref**](Ref.md) |  | [optional] 
**unassign_needs_review_by_user_action** | **bool** |  | [optional] 
**send_notification_action** | **bool** |  | [optional] 
**set_hide_from_reports_action** | **bool** |  | [optional] 
**set_link_to_paydown_budget_action** | **bool** |  | [optional] 
**review_status_action** | **str** |  | [optional] 
**action_set_owner_is_joint** | **bool** |  | [optional] 
**action_set_owner** | [**Ref**](Ref.md) |  | [optional] 
**action_set_business_entity** | [**Ref**](Ref.md) |  | [optional] 
**action_set_business_entity_is_unassigned** | **bool** |  | [optional] 
**recent_application_count** | **int** |  | [optional] 
**last_applied_at** | **str** |  | [optional] 
**split_transactions_action** | [**TransactionRuleSplitAction**](TransactionRuleSplitAction.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_rule import TransactionRule

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionRule from a JSON string
transaction_rule_instance = TransactionRule.from_json(json)
# print the JSON string representation of the object
print(TransactionRule.to_json())

# convert the object into a dict
transaction_rule_dict = transaction_rule_instance.to_dict()
# create an instance of TransactionRule from a dict
transaction_rule_from_dict = TransactionRule.from_dict(transaction_rule_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


