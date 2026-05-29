# PreviewTransactionRuleResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**PreviewTransactionRuleResponseData**](PreviewTransactionRuleResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.preview_transaction_rule_response import PreviewTransactionRuleResponse

# TODO update the JSON string below
json = "{}"
# create an instance of PreviewTransactionRuleResponse from a JSON string
preview_transaction_rule_response_instance = PreviewTransactionRuleResponse.from_json(json)
# print the JSON string representation of the object
print(PreviewTransactionRuleResponse.to_json())

# convert the object into a dict
preview_transaction_rule_response_dict = preview_transaction_rule_response_instance.to_dict()
# create an instance of PreviewTransactionRuleResponse from a dict
preview_transaction_rule_response_from_dict = PreviewTransactionRuleResponse.from_dict(preview_transaction_rule_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


