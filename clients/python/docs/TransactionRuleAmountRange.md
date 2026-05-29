# TransactionRuleAmountRange


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**lower** | **float** |  | [optional] 
**upper** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_rule_amount_range import TransactionRuleAmountRange

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionRuleAmountRange from a JSON string
transaction_rule_amount_range_instance = TransactionRuleAmountRange.from_json(json)
# print the JSON string representation of the object
print(TransactionRuleAmountRange.to_json())

# convert the object into a dict
transaction_rule_amount_range_dict = transaction_rule_amount_range_instance.to_dict()
# create an instance of TransactionRuleAmountRange from a dict
transaction_rule_amount_range_from_dict = TransactionRuleAmountRange.from_dict(transaction_rule_amount_range_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


