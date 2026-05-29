# BulkUpdateTransactionsRequest

Body for `PATCH /v1/transactions/bulk`. Mirrors Monarch's `bulkUpdateTransactions` mutation variables; see `BulkDeleteTransactionsRequest` for the selection-mode semantics.  `updates` is Monarch's `TransactionUpdateParams` shape. Only non-null fields are forwarded; pass an empty object to no-op (Monarch will reject if zero fields). 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**selected_transaction_ids** | **List[str]** | Ids to patch (explicit mode). Ignored when &#x60;allSelected: true&#x60;. | [optional] 
**excluded_transaction_ids** | **List[str]** | Ids to skip (filter mode). Ignored when &#x60;allSelected: false&#x60;. | [optional] 
**all_selected** | **bool** | Switch between explicit (false) and filter (true) selection. | [optional] [default to False]
**expected_affected_transaction_count** | **int** | Safety check. Monarch refuses if actual affected count differs. | 
**updates** | [**BulkTransactionUpdates**](BulkTransactionUpdates.md) |  | 
**filters** | [**BulkTransactionFilters**](BulkTransactionFilters.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_update_transactions_request import BulkUpdateTransactionsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of BulkUpdateTransactionsRequest from a JSON string
bulk_update_transactions_request_instance = BulkUpdateTransactionsRequest.from_json(json)
# print the JSON string representation of the object
print(BulkUpdateTransactionsRequest.to_json())

# convert the object into a dict
bulk_update_transactions_request_dict = bulk_update_transactions_request_instance.to_dict()
# create an instance of BulkUpdateTransactionsRequest from a dict
bulk_update_transactions_request_from_dict = BulkUpdateTransactionsRequest.from_dict(bulk_update_transactions_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


