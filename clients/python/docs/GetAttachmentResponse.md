# GetAttachmentResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetAttachmentResponseData**](GetAttachmentResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_attachment_response import GetAttachmentResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetAttachmentResponse from a JSON string
get_attachment_response_instance = GetAttachmentResponse.from_json(json)
# print the JSON string representation of the object
print(GetAttachmentResponse.to_json())

# convert the object into a dict
get_attachment_response_dict = get_attachment_response_instance.to_dict()
# create an instance of GetAttachmentResponse from a dict
get_attachment_response_from_dict = GetAttachmentResponse.from_dict(get_attachment_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


