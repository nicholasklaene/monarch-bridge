# TransactionRuleRequest

Body for creating / updating / previewing a rule. Every field is optional; only the fields you set drive the criteria and actions. Forwarded as-is to Monarch's `CreateTransactionRuleInput` / `UpdateTransactionRuleInput` / `TransactionRulePreviewInput`. The proxy injects path `{id}` into update calls; for create / preview the body alone is sufficient. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
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
**set_merchant_action** | **str** | Merchant id to set on match. | [optional] 
**set_category_action** | **str** | Category id to set on match. | [optional] 
**add_tags_action** | **List[str]** | Tag ids to add on match (additive; does not replace existing tags). | [optional] 
**link_goal_action** | **str** |  | [optional] 
**link_savings_goal_action** | **str** |  | [optional] 
**needs_review_by_user_action** | **str** | User id to assign for review. | [optional] 
**unassign_needs_review_by_user_action** | **bool** |  | [optional] 
**send_notification_action** | **bool** |  | [optional] 
**set_hide_from_reports_action** | **bool** |  | [optional] 
**set_link_to_paydown_budget_action** | **bool** |  | [optional] 
**review_status_action** | **str** |  | [optional] 
**action_set_owner_is_joint** | **bool** |  | [optional] 
**action_set_owner** | **str** | User id to set as transaction owner on match. | [optional] 
**action_set_business_entity** | **str** | Business entity id to assign on match. | [optional] 
**action_set_business_entity_is_unassigned** | **bool** |  | [optional] 
**split_transactions_action** | [**TransactionRuleSplitAction**](TransactionRuleSplitAction.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_rule_request import TransactionRuleRequest

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionRuleRequest from a JSON string
transaction_rule_request_instance = TransactionRuleRequest.from_json(json)
# print the JSON string representation of the object
print(TransactionRuleRequest.to_json())

# convert the object into a dict
transaction_rule_request_dict = transaction_rule_request_instance.to_dict()
# create an instance of TransactionRuleRequest from a dict
transaction_rule_request_from_dict = TransactionRuleRequest.from_dict(transaction_rule_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


