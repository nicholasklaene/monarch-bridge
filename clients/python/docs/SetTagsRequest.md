# SetTagsRequest

Full overwrite. Empty list removes all tags.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tag_ids** | **List[str]** |  | 

## Example

```python
from monarch_bridge_client.models.set_tags_request import SetTagsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SetTagsRequest from a JSON string
set_tags_request_instance = SetTagsRequest.from_json(json)
# print the JSON string representation of the object
print(SetTagsRequest.to_json())

# convert the object into a dict
set_tags_request_dict = set_tags_request_instance.to_dict()
# create an instance of SetTagsRequest from a dict
set_tags_request_from_dict = SetTagsRequest.from_dict(set_tags_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


