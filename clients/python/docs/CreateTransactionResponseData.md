# CreateTransactionResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transaction_id** | **str** |  | 

## Example

```python
from monarch_bridge_client.models.create_transaction_response_data import CreateTransactionResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of CreateTransactionResponseData from a JSON string
create_transaction_response_data_instance = CreateTransactionResponseData.from_json(json)
# print the JSON string representation of the object
print(CreateTransactionResponseData.to_json())

# convert the object into a dict
create_transaction_response_data_dict = create_transaction_response_data_instance.to_dict()
# create an instance of CreateTransactionResponseData from a dict
create_transaction_response_data_from_dict = CreateTransactionResponseData.from_dict(create_transaction_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


