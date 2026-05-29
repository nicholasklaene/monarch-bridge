# BulkUpdateTransactionsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**BulkUpdateTransactionsResponseData**](BulkUpdateTransactionsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.bulk_update_transactions_response import BulkUpdateTransactionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateTransactionsResponse from a JSON string
bulk_update_transactions_response_instance = BulkUpdateTransactionsResponse.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateTransactionsResponse.to_json())

# convert the object into a dict
bulk_update_transactions_response_dict = bulk_update_transactions_response_instance.to_dict()
# create an instance of BulkUpdateTransactionsResponse from a dict
bulk_update_transactions_response_from_dict = BulkUpdateTransactionsResponse.from_dict(bulk_update_transactions_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


