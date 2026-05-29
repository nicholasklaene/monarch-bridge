# TransactionAuditEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**timestamp** | **str** |  | [optional] 
**actor** | **str** |  | [optional] 
**action** | **str** |  | [optional] 
**var_field** | **str** |  | [optional] 
**old_value** | **str** |  | [optional] 
**new_value** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_audit_entry import TransactionAuditEntry

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionAuditEntry from a JSON string
transaction_audit_entry_instance = TransactionAuditEntry.from_json(json)
# print the JSON string representation of the object
print(TransactionAuditEntry.to_json())

# convert the object into a dict
transaction_audit_entry_dict = transaction_audit_entry_instance.to_dict()
# create an instance of TransactionAuditEntry from a dict
transaction_audit_entry_from_dict = TransactionAuditEntry.from_dict(transaction_audit_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


