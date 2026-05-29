# GetTransactionAuditLogResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionAuditLogResponseData**](GetTransactionAuditLogResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_transaction_audit_log_response import GetTransactionAuditLogResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTransactionAuditLogResponse from a JSON string
get_transaction_audit_log_response_instance = GetTransactionAuditLogResponse.from_json(json)
# print the JSON string representation of the object
print(GetTransactionAuditLogResponse.to_json())

# convert the object into a dict
get_transaction_audit_log_response_dict = get_transaction_audit_log_response_instance.to_dict()
# create an instance of GetTransactionAuditLogResponse from a dict
get_transaction_audit_log_response_from_dict = GetTransactionAuditLogResponse.from_dict(get_transaction_audit_log_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


