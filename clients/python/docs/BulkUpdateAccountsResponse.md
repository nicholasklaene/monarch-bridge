# BulkUpdateAccountsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**BulkUpdateAccountsResponseData**](BulkUpdateAccountsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.bulk_update_accounts_response import BulkUpdateAccountsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateAccountsResponse from a JSON string
bulk_update_accounts_response_instance = BulkUpdateAccountsResponse.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateAccountsResponse.to_json())

# convert the object into a dict
bulk_update_accounts_response_dict = bulk_update_accounts_response_instance.to_dict()
# create an instance of BulkUpdateAccountsResponse from a dict
bulk_update_accounts_response_from_dict = BulkUpdateAccountsResponse.from_dict(bulk_update_accounts_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


