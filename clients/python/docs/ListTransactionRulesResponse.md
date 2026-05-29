# ListTransactionRulesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListTransactionRulesResponseData**](ListTransactionRulesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_transaction_rules_response import ListTransactionRulesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListTransactionRulesResponse from a JSON string
list_transaction_rules_response_instance = ListTransactionRulesResponse.from_json(json)
# print the JSON string representation of the object
print(ListTransactionRulesResponse.to_json())

# convert the object into a dict
list_transaction_rules_response_dict = list_transaction_rules_response_instance.to_dict()
# create an instance of ListTransactionRulesResponse from a dict
list_transaction_rules_response_from_dict = ListTransactionRulesResponse.from_dict(list_transaction_rules_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


