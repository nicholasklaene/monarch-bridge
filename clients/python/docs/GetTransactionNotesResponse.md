# GetTransactionNotesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionNotesResponseData**](GetTransactionNotesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transaction_notes_response import GetTransactionNotesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionNotesResponse from a JSON string
get_transaction_notes_response_instance = GetTransactionNotesResponse.from_json(json)
# print the JSON string representation of the object
print(GetTransactionNotesResponse.to_json())

# convert the object into a dict
get_transaction_notes_response_dict = get_transaction_notes_response_instance.to_dict()
# create an instance of GetTransactionNotesResponse from a dict
get_transaction_notes_response_from_dict = GetTransactionNotesResponse.from_dict(get_transaction_notes_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


