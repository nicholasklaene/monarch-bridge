# GetHouseholdMembersResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetHouseholdMembersResponseData**](GetHouseholdMembersResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_household_members_response import GetHouseholdMembersResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetHouseholdMembersResponse from a JSON string
get_household_members_response_instance = GetHouseholdMembersResponse.from_json(json)
# print the JSON string representation of the object
print(GetHouseholdMembersResponse.to_json())

# convert the object into a dict
get_household_members_response_dict = get_household_members_response_instance.to_dict()
# create an instance of GetHouseholdMembersResponse from a dict
get_household_members_response_from_dict = GetHouseholdMembersResponse.from_dict(get_household_members_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


