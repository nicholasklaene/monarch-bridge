# UpdateMeResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**email** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**timezone** | **str** |  | [optional] 
**birthday** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_me_response_data import UpdateMeResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateMeResponseData from a JSON string
update_me_response_data_instance = UpdateMeResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateMeResponseData.to_json())

# convert the object into a dict
update_me_response_data_dict = update_me_response_data_instance.to_dict()
# create an instance of UpdateMeResponseData from a dict
update_me_response_data_from_dict = UpdateMeResponseData.from_dict(update_me_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


