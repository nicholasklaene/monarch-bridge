# UpdateTransactionResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transaction** | [**Transaction**](Transaction.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_transaction_response_data import UpdateTransactionResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateTransactionResponseData from a JSON string
update_transaction_response_data_instance = UpdateTransactionResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateTransactionResponseData.to_json())

# convert the object into a dict
update_transaction_response_data_dict = update_transaction_response_data_instance.to_dict()
# create an instance of UpdateTransactionResponseData from a dict
update_transaction_response_data_from_dict = UpdateTransactionResponseData.from_dict(update_transaction_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


