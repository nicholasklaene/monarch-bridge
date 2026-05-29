# BulkTransactionUpdates

Subset of Monarch's `TransactionUpdateParams` write-side input shape. Same field set as `PATCH /v1/transactions/{id}` plus the bulk-only `tags` overwrite list. All fields are optional. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_id** | **str** |  | [optional] 
**merchant_name** | **str** |  | [optional] 
**var_date** | **str** |  | [optional] 
**notes** | **str** |  | [optional] 
**hide** | **bool** |  | [optional] 
**is_recurring** | **bool** |  | [optional] 
**review_status** | **str** |  | [optional] 
**goal_id** | **str** |  | [optional] 
**needs_review_by_user_id** | **str** |  | [optional] 
**owner_user_id** | **str** |  | [optional] 
**business_entity_id** | **str** |  | [optional] 
**is_linked_to_paydown_budget** | **bool** |  | [optional] 
**tags** | **List[str]** | Tag id list (overwrite). Omit to leave existing tags untouched. | [optional] 

## Example

```python
from monarch_bridge_client.models.bulk_transaction_updates import BulkTransactionUpdates

# TODO update the JSON string below
json = "{}"
# create an instance of BulkTransactionUpdates from a JSON string
bulk_transaction_updates_instance = BulkTransactionUpdates.from_json(json)
# print the JSON string representation of the object
print(BulkTransactionUpdates.to_json())

# convert the object into a dict
bulk_transaction_updates_dict = bulk_transaction_updates_instance.to_dict()
# create an instance of BulkTransactionUpdates from a dict
bulk_transaction_updates_from_dict = BulkTransactionUpdates.from_dict(bulk_transaction_updates_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


