# TransactionNote


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**note** | **str** |  | [optional] 
**updated_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_note import TransactionNote

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionNote from a JSON string
transaction_note_instance = TransactionNote.from_json(json)
# print the JSON string representation of the object
print(TransactionNote.to_json())

# convert the object into a dict
transaction_note_dict = transaction_note_instance.to_dict()
# create an instance of TransactionNote from a dict
transaction_note_from_dict = TransactionNote.from_dict(transaction_note_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


