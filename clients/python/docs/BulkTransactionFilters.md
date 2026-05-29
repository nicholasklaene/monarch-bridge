# BulkTransactionFilters

Subset of Monarch's `TransactionFilterInput` accepted by the bulk-transaction mutations. Mirrors the read-side filter shape (search + id lists + nullable booleans) but is passed through verbatim to Monarch on writes. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**start_date** | **date** |  | [optional] 
**end_date** | **date** |  | [optional] 
**search** | **str** |  | [optional] 
**categories** | **List[str]** |  | [optional] 
**accounts** | **List[str]** |  | [optional] 
**tags** | **List[str]** |  | [optional] 
**has_attachments** | **bool** |  | [optional] 
**has_notes** | **bool** |  | [optional] 
**hide_from_reports** | **bool** |  | [optional] 
**is_split** | **bool** |  | [optional] 
**is_recurring** | **bool** |  | [optional] 
**imported_from_mint** | **bool** |  | [optional] 
**synced_from_institution** | **bool** |  | [optional] 
**needs_review** | **bool** |  | [optional] 
**transaction_visibility** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_transaction_filters import BulkTransactionFilters

# TODO update the JSON string below
json = "{}"
# create an instance of BulkTransactionFilters from a JSON string
bulk_transaction_filters_instance = BulkTransactionFilters.from_json(json)
# print the JSON string representation of the object
print(BulkTransactionFilters.to_json())

# convert the object into a dict
bulk_transaction_filters_dict = bulk_transaction_filters_instance.to_dict()
# create an instance of BulkTransactionFilters from a dict
bulk_transaction_filters_from_dict = BulkTransactionFilters.from_dict(bulk_transaction_filters_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


