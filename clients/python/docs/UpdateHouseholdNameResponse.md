# UpdateHouseholdNameResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateHouseholdNameResponseData**](UpdateHouseholdNameResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_household_name_response import UpdateHouseholdNameResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateHouseholdNameResponse from a JSON string
update_household_name_response_instance = UpdateHouseholdNameResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateHouseholdNameResponse.to_json())

# convert the object into a dict
update_household_name_response_dict = update_household_name_response_instance.to_dict()
# create an instance of UpdateHouseholdNameResponse from a dict
update_household_name_response_from_dict = UpdateHouseholdNameResponse.from_dict(update_household_name_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


