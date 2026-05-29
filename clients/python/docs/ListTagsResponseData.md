# ListTagsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tags** | [**List[Tag]**](Tag.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_tags_response_data import ListTagsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListTagsResponseData from a JSON string
list_tags_response_data_instance = ListTagsResponseData.from_json(json)
# print the JSON string representation of the object
print(ListTagsResponseData.to_json())

# convert the object into a dict
list_tags_response_data_dict = list_tags_response_data_instance.to_dict()
# create an instance of ListTagsResponseData from a dict
list_tags_response_data_from_dict = ListTagsResponseData.from_dict(list_tags_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


