# UpdateCookiePreferencesRequest

Patch any subset of cookie consents. Omit a field to leave it untouched.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**analytics** | **bool** |  | [optional] 
**marketing** | **bool** |  | [optional] 
**functional** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_cookie_preferences_request import UpdateCookiePreferencesRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateCookiePreferencesRequest from a JSON string
update_cookie_preferences_request_instance = UpdateCookiePreferencesRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateCookiePreferencesRequest.to_json())

# convert the object into a dict
update_cookie_preferences_request_dict = update_cookie_preferences_request_instance.to_dict()
# create an instance of UpdateCookiePreferencesRequest from a dict
update_cookie_preferences_request_from_dict = UpdateCookiePreferencesRequest.from_dict(update_cookie_preferences_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


