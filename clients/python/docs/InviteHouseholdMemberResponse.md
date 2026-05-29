# InviteHouseholdMemberResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**InviteHouseholdMemberResponseData**](InviteHouseholdMemberResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.invite_household_member_response import InviteHouseholdMemberResponse

# TODO update the JSON string below
json = "{}"
# create an instance of InviteHouseholdMemberResponse from a JSON string
invite_household_member_response_instance = InviteHouseholdMemberResponse.from_json(json)
# print the JSON string representation of the object
print(InviteHouseholdMemberResponse.to_json())

# convert the object into a dict
invite_household_member_response_dict = invite_household_member_response_instance.to_dict()
# create an instance of InviteHouseholdMemberResponse from a dict
invite_household_member_response_from_dict = InviteHouseholdMemberResponse.from_dict(invite_household_member_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


