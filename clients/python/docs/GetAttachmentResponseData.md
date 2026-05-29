# GetAttachmentResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attachment** | [**AttachmentDetail**](AttachmentDetail.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_attachment_response_data import GetAttachmentResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetAttachmentResponseData from a JSON string
get_attachment_response_data_instance = GetAttachmentResponseData.from_json(json)
# print the JSON string representation of the object
print(GetAttachmentResponseData.to_json())

# convert the object into a dict
get_attachment_response_data_dict = get_attachment_response_data_instance.to_dict()
# create an instance of GetAttachmentResponseData from a dict
get_attachment_response_data_from_dict = GetAttachmentResponseData.from_dict(get_attachment_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


