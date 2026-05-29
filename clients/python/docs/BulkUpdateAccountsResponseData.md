# BulkUpdateAccountsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accounts** | [**List[Account]**](Account.md) | Updated accounts, one per input entry. | 

## Example

```python
from monarch_bridge_client.models.bulk_update_accounts_response_data import BulkUpdateAccountsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateAccountsResponseData from a JSON string
bulk_update_accounts_response_data_instance = BulkUpdateAccountsResponseData.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateAccountsResponseData.to_json())

# convert the object into a dict
bulk_update_accounts_response_data_dict = bulk_update_accounts_response_data_instance.to_dict()
# create an instance of BulkUpdateAccountsResponseData from a dict
bulk_update_accounts_response_data_from_dict = BulkUpdateAccountsResponseData.from_dict(bulk_update_accounts_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


