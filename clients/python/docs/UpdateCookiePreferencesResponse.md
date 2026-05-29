# UpdateCookiePreferencesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCookiePreferencesResponseData**](GetCookiePreferencesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_cookie_preferences_response import UpdateCookiePreferencesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateCookiePreferencesResponse from a JSON string
update_cookie_preferences_response_instance = UpdateCookiePreferencesResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateCookiePreferencesResponse.to_json())

# convert the object into a dict
update_cookie_preferences_response_dict = update_cookie_preferences_response_instance.to_dict()
# create an instance of UpdateCookiePreferencesResponse from a dict
update_cookie_preferences_response_from_dict = UpdateCookiePreferencesResponse.from_dict(update_cookie_preferences_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


