# UpdateMeResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateMeResponseData**](UpdateMeResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_me_response import UpdateMeResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateMeResponse from a JSON string
update_me_response_instance = UpdateMeResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateMeResponse.to_json())

# convert the object into a dict
update_me_response_dict = update_me_response_instance.to_dict()
# create an instance of UpdateMeResponse from a dict
update_me_response_from_dict = UpdateMeResponse.from_dict(update_me_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


