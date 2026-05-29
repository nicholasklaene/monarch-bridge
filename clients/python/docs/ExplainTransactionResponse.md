# ExplainTransactionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ExplainTransactionResponseData**](ExplainTransactionResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.explain_transaction_response import ExplainTransactionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ExplainTransactionResponse from a JSON string
explain_transaction_response_instance = ExplainTransactionResponse.from_json(json)
# print the JSON string representation of the object
print(ExplainTransactionResponse.to_json())

# convert the object into a dict
explain_transaction_response_dict = explain_transaction_response_instance.to_dict()
# create an instance of ExplainTransactionResponse from a dict
explain_transaction_response_from_dict = ExplainTransactionResponse.from_dict(explain_transaction_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


