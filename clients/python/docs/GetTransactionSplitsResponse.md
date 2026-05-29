# GetTransactionSplitsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionSplitsResponseData**](GetTransactionSplitsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transaction_splits_response import GetTransactionSplitsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionSplitsResponse from a JSON string
get_transaction_splits_response_instance = GetTransactionSplitsResponse.from_json(json)
# print the JSON string representation of the object
print(GetTransactionSplitsResponse.to_json())

# convert the object into a dict
get_transaction_splits_response_dict = get_transaction_splits_response_instance.to_dict()
# create an instance of GetTransactionSplitsResponse from a dict
get_transaction_splits_response_from_dict = GetTransactionSplitsResponse.from_dict(get_transaction_splits_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


