# AttachmentDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**original_asset_url** | **str** | Pre-signed download URL; GET it to fetch the binary asset. | [optional] 

## Example

```python
from monarch_bridge_client.models.attachment_detail import AttachmentDetail

# TODO update the JSON string below
json = "{}"
# create an instance of AttachmentDetail from a JSON string
attachment_detail_instance = AttachmentDetail.from_json(json)
# print the JSON string representation of the object
print(AttachmentDetail.to_json())

# convert the object into a dict
attachment_detail_dict = attachment_detail_instance.to_dict()
# create an instance of AttachmentDetail from a dict
attachment_detail_from_dict = AttachmentDetail.from_dict(attachment_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


