# CreateTransactionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateTransactionResponseData**](CreateTransactionResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_transaction_response import CreateTransactionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreateTransactionResponse from a JSON string
create_transaction_response_instance = CreateTransactionResponse.from_json(json)
# print the JSON string representation of the object
print(CreateTransactionResponse.to_json())

# convert the object into a dict
create_transaction_response_dict = create_transaction_response_instance.to_dict()
# create an instance of CreateTransactionResponse from a dict
create_transaction_response_from_dict = CreateTransactionResponse.from_dict(create_transaction_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


