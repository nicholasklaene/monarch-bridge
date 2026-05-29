# BulkUpdateAccountsEntry

One entry in `BulkUpdateAccountsRequest.updates`. `id` is required; other fields are optional and only non-null fields are forwarded to Monarch. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**display_balance** | **float** |  | [optional] 
**type** | **str** |  | [optional] 
**subtype** | **str** |  | [optional] 
**include_in_net_worth** | **bool** |  | [optional] 
**hide_from_list** | **bool** |  | [optional] 
**hide_transactions_from_reports** | **bool** |  | [optional] 
**exclude_from_debt_paydown** | **bool** |  | [optional] 
**include_in_goal_balance** | **bool** |  | [optional] 
**invert_synced_balance** | **bool** |  | [optional] 
**current_balance** | **float** |  | [optional] 
**apr** | **float** |  | [optional] 
**interest_rate** | **float** |  | [optional] 
**limit** | **float** |  | [optional] 
**minimum_payment** | **float** |  | [optional] 
**planned_payment** | **float** |  | [optional] 
**use_available_balance** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_update_accounts_entry import BulkUpdateAccountsEntry

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateAccountsEntry from a JSON string
bulk_update_accounts_entry_instance = BulkUpdateAccountsEntry.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateAccountsEntry.to_json())

# convert the object into a dict
bulk_update_accounts_entry_dict = bulk_update_accounts_entry_instance.to_dict()
# create an instance of BulkUpdateAccountsEntry from a dict
bulk_update_accounts_entry_from_dict = BulkUpdateAccountsEntry.from_dict(bulk_update_accounts_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


