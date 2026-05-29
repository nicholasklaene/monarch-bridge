# GetHouseholdPreferencesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetHouseholdPreferencesResponseData**](GetHouseholdPreferencesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_household_preferences_response import GetHouseholdPreferencesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetHouseholdPreferencesResponse from a JSON string
get_household_preferences_response_instance = GetHouseholdPreferencesResponse.from_json(json)
# print the JSON string representation of the object
print(GetHouseholdPreferencesResponse.to_json())

# convert the object into a dict
get_household_preferences_response_dict = get_household_preferences_response_instance.to_dict()
# create an instance of GetHouseholdPreferencesResponse from a dict
get_household_preferences_response_from_dict = GetHouseholdPreferencesResponse.from_dict(get_household_preferences_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


