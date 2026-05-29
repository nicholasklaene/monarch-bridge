# TransactionAttachment

Monarch's representation of a file attached to a transaction.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**public_id** | **str** | Cloudinary public id; durable handle for the binary. | [optional] 
**extension** | **str** |  | [optional] 
**size_bytes** | **int** |  | [optional] 
**filename** | **str** |  | [optional] 
**original_asset_url** | **str** | Signed URL clients can use to fetch the original binary. | [optional] 

## Example

```python
from monarch_bridge_client.models.transaction_attachment import TransactionAttachment

# TODO update the JSON string below
json = "{}"
# create an instance of TransactionAttachment from a JSON string
transaction_attachment_instance = TransactionAttachment.from_json(json)
# print the JSON string representation of the object
print(TransactionAttachment.to_json())

# convert the object into a dict
transaction_attachment_dict = transaction_attachment_instance.to_dict()
# create an instance of TransactionAttachment from a dict
transaction_attachment_from_dict = TransactionAttachment.from_dict(transaction_attachment_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


