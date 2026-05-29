# UpdateTransactionSplitsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateTransactionSplitsResponseData**](UpdateTransactionSplitsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_transaction_splits_response import UpdateTransactionSplitsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateTransactionSplitsResponse from a JSON string
update_transaction_splits_response_instance = UpdateTransactionSplitsResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateTransactionSplitsResponse.to_json())

# convert the object into a dict
update_transaction_splits_response_dict = update_transaction_splits_response_instance.to_dict()
# create an instance of UpdateTransactionSplitsResponse from a dict
update_transaction_splits_response_from_dict = UpdateTransactionSplitsResponse.from_dict(update_transaction_splits_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


