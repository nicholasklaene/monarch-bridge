# UploadTransactionAttachmentResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attachment** | [**TransactionAttachment**](TransactionAttachment.md) |  | 

## Example

```python
from monarch_bridge_client.models.upload_transaction_attachment_response_data import UploadTransactionAttachmentResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UploadTransactionAttachmentResponseData from a JSON string
upload_transaction_attachment_response_data_instance = UploadTransactionAttachmentResponseData.from_json(json)
# print the JSON string representation of the object
print(UploadTransactionAttachmentResponseData.to_json())

# convert the object into a dict
upload_transaction_attachment_response_data_dict = upload_transaction_attachment_response_data_instance.to_dict()
# create an instance of UploadTransactionAttachmentResponseData from a dict
upload_transaction_attachment_response_data_from_dict = UploadTransactionAttachmentResponseData.from_dict(upload_transaction_attachment_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


