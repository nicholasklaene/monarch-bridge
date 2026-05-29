# DeleteTransactionRuleResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteAccountResponseData**](DeleteAccountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.delete_transaction_rule_response import DeleteTransactionRuleResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteTransactionRuleResponse from a JSON string
delete_transaction_rule_response_instance = DeleteTransactionRuleResponse.from_json(json)
# print the JSON string representation of the object
print(DeleteTransactionRuleResponse.to_json())

# convert the object into a dict
delete_transaction_rule_response_dict = delete_transaction_rule_response_instance.to_dict()
# create an instance of DeleteTransactionRuleResponse from a dict
delete_transaction_rule_response_from_dict = DeleteTransactionRuleResponse.from_dict(delete_transaction_rule_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


