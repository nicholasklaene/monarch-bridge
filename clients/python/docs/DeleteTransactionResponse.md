# DeleteTransactionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteAccountResponseData**](DeleteAccountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.delete_transaction_response import DeleteTransactionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteTransactionResponse from a JSON string
delete_transaction_response_instance = DeleteTransactionResponse.from_json(json)
# print the JSON string representation of the object
print(DeleteTransactionResponse.to_json())

# convert the object into a dict
delete_transaction_response_dict = delete_transaction_response_instance.to_dict()
# create an instance of DeleteTransactionResponse from a dict
delete_transaction_response_from_dict = DeleteTransactionResponse.from_dict(delete_transaction_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


