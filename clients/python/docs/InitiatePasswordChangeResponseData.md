# InitiatePasswordChangeResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**request_id** | **str** |  | [optional] 
**email** | **str** |  | [optional] 
**expires_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.initiate_password_change_response_data import InitiatePasswordChangeResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of InitiatePasswordChangeResponseData from a JSON string
initiate_password_change_response_data_instance = InitiatePasswordChangeResponseData.from_json(json)
# print the JSON string representation of the object
print(InitiatePasswordChangeResponseData.to_json())

# convert the object into a dict
initiate_password_change_response_data_dict = initiate_password_change_response_data_instance.to_dict()
# create an instance of InitiatePasswordChangeResponseData from a dict
initiate_password_change_response_data_from_dict = InitiatePasswordChangeResponseData.from_dict(initiate_password_change_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


