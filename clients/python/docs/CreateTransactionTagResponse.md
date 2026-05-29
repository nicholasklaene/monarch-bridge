# CreateTransactionTagResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateTagResponseData**](CreateTagResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_transaction_tag_response import CreateTransactionTagResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreateTransactionTagResponse from a JSON string
create_transaction_tag_response_instance = CreateTransactionTagResponse.from_json(json)
# print the JSON string representation of the object
print(CreateTransactionTagResponse.to_json())

# convert the object into a dict
create_transaction_tag_response_dict = create_transaction_tag_response_instance.to_dict()
# create an instance of CreateTransactionTagResponse from a dict
create_transaction_tag_response_from_dict = CreateTransactionTagResponse.from_dict(create_transaction_tag_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


