# CreateTransactionRuleResponse

Monarch's create mutation only returns errors (no rule body). On success we surface a `created: true` flag. To inspect the persisted rule, refetch the list with `GET /v1/transaction-rules`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateTransactionRuleResponseData**](CreateTransactionRuleResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_transaction_rule_response import CreateTransactionRuleResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreateTransactionRuleResponse from a JSON string
create_transaction_rule_response_instance = CreateTransactionRuleResponse.from_json(json)
# print the JSON string representation of the object
print(CreateTransactionRuleResponse.to_json())

# convert the object into a dict
create_transaction_rule_response_dict = create_transaction_rule_response_instance.to_dict()
# create an instance of CreateTransactionRuleResponse from a dict
create_transaction_rule_response_from_dict = CreateTransactionRuleResponse.from_dict(create_transaction_rule_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


