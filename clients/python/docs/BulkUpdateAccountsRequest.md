# BulkUpdateAccountsRequest

Body for `PATCH /v1/accounts/bulk`. Each entry in `updates` is one `UpdateAccountsMutationInput`: `id` plus any subset of the patchable fields. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**updates** | [**List[BulkUpdateAccountsEntry]**](BulkUpdateAccountsEntry.md) |  | 

## Example

```python
from monarch_bridge_client.models.bulk_update_accounts_request import BulkUpdateAccountsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateAccountsRequest from a JSON string
bulk_update_accounts_request_instance = BulkUpdateAccountsRequest.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateAccountsRequest.to_json())

# convert the object into a dict
bulk_update_accounts_request_dict = bulk_update_accounts_request_instance.to_dict()
# create an instance of BulkUpdateAccountsRequest from a dict
bulk_update_accounts_request_from_dict = BulkUpdateAccountsRequest.from_dict(bulk_update_accounts_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


