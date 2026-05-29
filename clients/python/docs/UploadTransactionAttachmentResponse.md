# UploadTransactionAttachmentResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UploadTransactionAttachmentResponseData**](UploadTransactionAttachmentResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.upload_transaction_attachment_response import UploadTransactionAttachmentResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UploadTransactionAttachmentResponse from a JSON string
upload_transaction_attachment_response_instance = UploadTransactionAttachmentResponse.from_json(json)
# print the JSON string representation of the object
print(UploadTransactionAttachmentResponse.to_json())

# convert the object into a dict
upload_transaction_attachment_response_dict = upload_transaction_attachment_response_instance.to_dict()
# create an instance of UploadTransactionAttachmentResponse from a dict
upload_transaction_attachment_response_from_dict = UploadTransactionAttachmentResponse.from_dict(upload_transaction_attachment_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


