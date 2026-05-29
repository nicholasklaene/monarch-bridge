# BulkDeleteTransactionsRequest

Body for `POST /v1/transactions/bulk-delete`. Mirrors Monarch's `bulkDeleteTransactions` mutation variables. Two selection modes:  - **Explicit** (`allSelected: false`, default): `selectedTransactionIds`   lists exactly which rows to delete. - **Filter-based** (`allSelected: true`): every row matching `filters` is   deleted, minus the optional `excludedTransactionIds` set.  `expectedAffectedTransactionCount` is required as a safety guard. Pass the number of rows you believe will be affected. Monarch rejects the mutation if the actual count differs (race-prevention). 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**selected_transaction_ids** | **List[str]** | Ids to delete (explicit mode). Ignored when &#x60;allSelected: true&#x60;. | [optional] 
**excluded_transaction_ids** | **List[str]** | Ids to skip (filter mode). Ignored when &#x60;allSelected: false&#x60;. | [optional] 
**all_selected** | **bool** | Switch between explicit (false) and filter (true) selection. | [optional] [default to False]
**expected_affected_transaction_count** | **int** | Safety check. Monarch refuses if actual affected count differs. | 
**filters** | [**BulkTransactionFilters**](BulkTransactionFilters.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_delete_transactions_request import BulkDeleteTransactionsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of BulkDeleteTransactionsRequest from a JSON string
bulk_delete_transactions_request_instance = BulkDeleteTransactionsRequest.from_json(json)
# print the JSON string representation of the object
print(BulkDeleteTransactionsRequest.to_json())

# convert the object into a dict
bulk_delete_transactions_request_dict = bulk_delete_transactions_request_instance.to_dict()
# create an instance of BulkDeleteTransactionsRequest from a dict
bulk_delete_transactions_request_from_dict = BulkDeleteTransactionsRequest.from_dict(bulk_delete_transactions_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


