# GetTransactionsDuplicatesResponse

Groups of likely-duplicate transactions in the requested window. Each group's `transactions` list always has length > 1; singletons are filtered out. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionsDuplicatesResponseData**](GetTransactionsDuplicatesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transactions_duplicates_response import GetTransactionsDuplicatesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionsDuplicatesResponse from a JSON string
get_transactions_duplicates_response_instance = GetTransactionsDuplicatesResponse.from_json(json)
# print the JSON string representation of the object
print(GetTransactionsDuplicatesResponse.to_json())

# convert the object into a dict
get_transactions_duplicates_response_dict = get_transactions_duplicates_response_instance.to_dict()
# create an instance of GetTransactionsDuplicatesResponse from a dict
get_transactions_duplicates_response_from_dict = GetTransactionsDuplicatesResponse.from_dict(get_transactions_duplicates_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


