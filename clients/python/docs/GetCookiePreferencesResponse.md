# GetCookiePreferencesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCookiePreferencesResponseData**](GetCookiePreferencesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_cookie_preferences_response import GetCookiePreferencesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCookiePreferencesResponse from a JSON string
get_cookie_preferences_response_instance = GetCookiePreferencesResponse.from_json(json)
# print the JSON string representation of the object
print(GetCookiePreferencesResponse.to_json())

# convert the object into a dict
get_cookie_preferences_response_dict = get_cookie_preferences_response_instance.to_dict()
# create an instance of GetCookiePreferencesResponse from a dict
get_cookie_preferences_response_from_dict = GetCookiePreferencesResponse.from_dict(get_cookie_preferences_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


