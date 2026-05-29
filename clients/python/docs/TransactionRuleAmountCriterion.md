# TransactionRuleAmountCriterion

Match transactions whose signed amount satisfies the operator/value pair.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**operator** | **str** | One of &#x60;equals&#x60;, &#x60;not_equals&#x60;, &#x60;greater_than&#x60;, &#x60;less_than&#x60;, &#x60;between&#x60;. Forwarded verbatim. | [optional] 
**is_expense** | **bool** | When true, scope the comparison to expenses (negative amounts) only. | [optional] 
**value** | **float** |  | [optional] 
**value_range** | [**TransactionRuleAmountRange**](TransactionRuleAmountRange.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_rule_amount_criterion import TransactionRuleAmountCriterion

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionRuleAmountCriterion from a JSON string
transaction_rule_amount_criterion_instance = TransactionRuleAmountCriterion.from_json(json)
# print the JSON string representation of the object
print(TransactionRuleAmountCriterion.to_json())

# convert the object into a dict
transaction_rule_amount_criterion_dict = transaction_rule_amount_criterion_instance.to_dict()
# create an instance of TransactionRuleAmountCriterion from a dict
transaction_rule_amount_criterion_from_dict = TransactionRuleAmountCriterion.from_dict(transaction_rule_amount_criterion_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


