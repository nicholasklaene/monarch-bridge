# AccountSyncStatus

Per-account sync flag for `GET /v1/refresh/status`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**has_sync_in_progress** | **bool** |  | 

## Example

```python
from monarch_bridge_client.models.account_sync_status import AccountSyncStatus

# TODO update the JSON string below
json = "{}"
# create an instance of AccountSyncStatus from a JSON string
account_sync_status_instance = AccountSyncStatus.from_json(json)
# print the JSON string representation of the object
print(AccountSyncStatus.to_json())

# convert the object into a dict
account_sync_status_dict = account_sync_status_instance.to_dict()
# create an instance of AccountSyncStatus from a dict
account_sync_status_from_dict = AccountSyncStatus.from_dict(account_sync_status_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


