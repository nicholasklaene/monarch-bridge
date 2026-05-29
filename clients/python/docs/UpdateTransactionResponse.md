# UpdateTransactionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateTransactionResponseData**](UpdateTransactionResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_transaction_response import UpdateTransactionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateTransactionResponse from a JSON string
update_transaction_response_instance = UpdateTransactionResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateTransactionResponse.to_json())

# convert the object into a dict
update_transaction_response_dict = update_transaction_response_instance.to_dict()
# create an instance of UpdateTransactionResponse from a dict
update_transaction_response_from_dict = UpdateTransactionResponse.from_dict(update_transaction_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


