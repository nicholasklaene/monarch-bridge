# TransactionRuleStringCriterion

One operator-value pair for a text criterion (merchant / original-statement / merchant-name).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**operator** | **str** | Comparison operator (e.g. &#x60;equals&#x60;, &#x60;contains&#x60;, &#x60;starts_with&#x60;, &#x60;ends_with&#x60;). Forwarded verbatim. | [optional] 
**value** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_rule_string_criterion import TransactionRuleStringCriterion

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionRuleStringCriterion from a JSON string
transaction_rule_string_criterion_instance = TransactionRuleStringCriterion.from_json(json)
# print the JSON string representation of the object
print(TransactionRuleStringCriterion.to_json())

# convert the object into a dict
transaction_rule_string_criterion_dict = transaction_rule_string_criterion_instance.to_dict()
# create an instance of TransactionRuleStringCriterion from a dict
transaction_rule_string_criterion_from_dict = TransactionRuleStringCriterion.from_dict(transaction_rule_string_criterion_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


