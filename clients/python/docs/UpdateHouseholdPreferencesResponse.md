# UpdateHouseholdPreferencesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateHouseholdPreferencesResponseData**](UpdateHouseholdPreferencesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_household_preferences_response import UpdateHouseholdPreferencesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateHouseholdPreferencesResponse from a JSON string
update_household_preferences_response_instance = UpdateHouseholdPreferencesResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateHouseholdPreferencesResponse.to_json())

# convert the object into a dict
update_household_preferences_response_dict = update_household_preferences_response_instance.to_dict()
# create an instance of UpdateHouseholdPreferencesResponse from a dict
update_household_preferences_response_from_dict = UpdateHouseholdPreferencesResponse.from_dict(update_household_preferences_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


