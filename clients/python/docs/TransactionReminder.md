# TransactionReminder


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**remind_at** | **str** |  | [optional] 
**note** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_reminder import TransactionReminder

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionReminder from a JSON string
transaction_reminder_instance = TransactionReminder.from_json(json)
# print the JSON string representation of the object
print(TransactionReminder.to_json())

# convert the object into a dict
transaction_reminder_dict = transaction_reminder_instance.to_dict()
# create an instance of TransactionReminder from a dict
transaction_reminder_from_dict = TransactionReminder.from_dict(transaction_reminder_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


