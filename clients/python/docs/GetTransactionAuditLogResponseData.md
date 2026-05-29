# GetTransactionAuditLogResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**entries** | [**List[TransactionAuditEntry]**](TransactionAuditEntry.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transaction_audit_log_response_data import GetTransactionAuditLogResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionAuditLogResponseData from a JSON string
get_transaction_audit_log_response_data_instance = GetTransactionAuditLogResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTransactionAuditLogResponseData.to_json())

# convert the object into a dict
get_transaction_audit_log_response_data_dict = get_transaction_audit_log_response_data_instance.to_dict()
# create an instance of GetTransactionAuditLogResponseData from a dict
get_transaction_audit_log_response_data_from_dict = GetTransactionAuditLogResponseData.from_dict(get_transaction_audit_log_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


