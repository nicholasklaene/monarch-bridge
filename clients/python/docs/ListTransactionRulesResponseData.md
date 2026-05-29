# ListTransactionRulesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rules** | [**List[TransactionRule]**](TransactionRule.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_transaction_rules_response_data import ListTransactionRulesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListTransactionRulesResponseData from a JSON string
list_transaction_rules_response_data_instance = ListTransactionRulesResponseData.from_json(json)
# print the JSON string representation of the object
print(ListTransactionRulesResponseData.to_json())

# convert the object into a dict
list_transaction_rules_response_data_dict = list_transaction_rules_response_data_instance.to_dict()
# create an instance of ListTransactionRulesResponseData from a dict
list_transaction_rules_response_data_from_dict = ListTransactionRulesResponseData.from_dict(list_transaction_rules_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


