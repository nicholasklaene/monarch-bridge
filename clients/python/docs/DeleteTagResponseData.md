# DeleteTagResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deleted** | **bool** | True when Monarch removed the tag with no payload errors. | 

## Example

```python
from monarch_bridge_client.models.delete_tag_response_data import DeleteTagResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteTagResponseData from a JSON string
delete_tag_response_data_instance = DeleteTagResponseData.from_json(json)
# print the JSON string representation of the object
print(DeleteTagResponseData.to_json())

# convert the object into a dict
delete_tag_response_data_dict = delete_tag_response_data_instance.to_dict()
# create an instance of DeleteTagResponseData from a dict
delete_tag_response_data_from_dict = DeleteTagResponseData.from_dict(delete_tag_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


