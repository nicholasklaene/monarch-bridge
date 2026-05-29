# SetTransactionTagsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**SetTransactionTagsResponseData**](SetTransactionTagsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.set_transaction_tags_response import SetTransactionTagsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SetTransactionTagsResponse from a JSON string
set_transaction_tags_response_instance = SetTransactionTagsResponse.from_json(json)
# print the JSON string representation of the object
print(SetTransactionTagsResponse.to_json())

# convert the object into a dict
set_transaction_tags_response_dict = set_transaction_tags_response_instance.to_dict()
# create an instance of SetTransactionTagsResponse from a dict
set_transaction_tags_response_from_dict = SetTransactionTagsResponse.from_dict(set_transaction_tags_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


