# ExplainTransactionResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**explanation** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.explain_transaction_response_data import ExplainTransactionResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ExplainTransactionResponseData from a JSON string
explain_transaction_response_data_instance = ExplainTransactionResponseData.from_json(json)
# print the JSON string representation of the object
print(ExplainTransactionResponseData.to_json())

# convert the object into a dict
explain_transaction_response_data_dict = explain_transaction_response_data_instance.to_dict()
# create an instance of ExplainTransactionResponseData from a dict
explain_transaction_response_data_from_dict = ExplainTransactionResponseData.from_dict(explain_transaction_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


