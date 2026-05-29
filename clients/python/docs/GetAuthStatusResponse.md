# GetAuthStatusResponse

Body of `GET /v1/auth/status` and `POST /v1/auth/refresh`. Not data-wrapped.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**authenticated** | **bool** |  | 
**email** | **str** |  | [optional] 
**last_verified_at** | **datetime** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_auth_status_response import GetAuthStatusResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetAuthStatusResponse from a JSON string
get_auth_status_response_instance = GetAuthStatusResponse.from_json(json)
# print the JSON string representation of the object
print(GetAuthStatusResponse.to_json())

# convert the object into a dict
get_auth_status_response_dict = get_auth_status_response_instance.to_dict()
# create an instance of GetAuthStatusResponse from a dict
get_auth_status_response_from_dict = GetAuthStatusResponse.from_dict(get_auth_status_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


