# DeleteTagResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteTagResponseData**](DeleteTagResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.delete_tag_response import DeleteTagResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteTagResponse from a JSON string
delete_tag_response_instance = DeleteTagResponse.from_json(json)
# print the JSON string representation of the object
print(DeleteTagResponse.to_json())

# convert the object into a dict
delete_tag_response_dict = delete_tag_response_instance.to_dict()
# create an instance of DeleteTagResponse from a dict
delete_tag_response_from_dict = DeleteTagResponse.from_dict(delete_tag_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


