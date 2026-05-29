# InitiatePasswordChangeResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**InitiatePasswordChangeResponseData**](InitiatePasswordChangeResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.initiate_password_change_response import InitiatePasswordChangeResponse

# TODO update the JSON string below
json = "{}"
# create an instance of InitiatePasswordChangeResponse from a JSON string
initiate_password_change_response_instance = InitiatePasswordChangeResponse.from_json(json)
# print the JSON string representation of the object
print(InitiatePasswordChangeResponse.to_json())

# convert the object into a dict
initiate_password_change_response_dict = initiate_password_change_response_instance.to_dict()
# create an instance of InitiatePasswordChangeResponse from a dict
initiate_password_change_response_from_dict = InitiatePasswordChangeResponse.from_dict(initiate_password_change_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


