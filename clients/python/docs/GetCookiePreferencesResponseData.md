# GetCookiePreferencesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**preferences** | [**CookiePreferences**](CookiePreferences.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_cookie_preferences_response_data import GetCookiePreferencesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCookiePreferencesResponseData from a JSON string
get_cookie_preferences_response_data_instance = GetCookiePreferencesResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCookiePreferencesResponseData.to_json())

# convert the object into a dict
get_cookie_preferences_response_data_dict = get_cookie_preferences_response_data_instance.to_dict()
# create an instance of GetCookiePreferencesResponseData from a dict
get_cookie_preferences_response_data_from_dict = GetCookiePreferencesResponseData.from_dict(get_cookie_preferences_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


