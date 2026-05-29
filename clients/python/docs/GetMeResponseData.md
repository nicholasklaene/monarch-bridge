# GetMeResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**email** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**timezone** | **str** |  | [optional] 
**birthday** | **str** |  | [optional] 
**has_password** | **bool** |  | [optional] 
**has_mfa_on** | **bool** |  | [optional] 
**household_role** | **str** |  | [optional] 
**created_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_me_response_data import GetMeResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetMeResponseData from a JSON string
get_me_response_data_instance = GetMeResponseData.from_json(json)
# print the JSON string representation of the object
print(GetMeResponseData.to_json())

# convert the object into a dict
get_me_response_data_dict = get_me_response_data_instance.to_dict()
# create an instance of GetMeResponseData from a dict
get_me_response_data_from_dict = GetMeResponseData.from_dict(get_me_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


