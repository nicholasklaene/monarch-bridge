# UpdateTransactionRuleResponse

Like create, the update mutation only returns errors. Success means `updated: true`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateTransactionRuleResponseData**](UpdateTransactionRuleResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_transaction_rule_response import UpdateTransactionRuleResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateTransactionRuleResponse from a JSON string
update_transaction_rule_response_instance = UpdateTransactionRuleResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateTransactionRuleResponse.to_json())

# convert the object into a dict
update_transaction_rule_response_dict = update_transaction_rule_response_instance.to_dict()
# create an instance of UpdateTransactionRuleResponse from a dict
update_transaction_rule_response_from_dict = UpdateTransactionRuleResponse.from_dict(update_transaction_rule_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


