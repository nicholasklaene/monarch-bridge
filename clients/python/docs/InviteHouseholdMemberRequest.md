# InviteHouseholdMemberRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**email** | **str** |  | 
**role** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.invite_household_member_request import InviteHouseholdMemberRequest

# TODO update the JSON string below
json = "{}"
# create an instance of InviteHouseholdMemberRequest from a JSON string
invite_household_member_request_instance = InviteHouseholdMemberRequest.from_json(json)
# print the JSON string representation of the object
print(InviteHouseholdMemberRequest.to_json())

# convert the object into a dict
invite_household_member_request_dict = invite_household_member_request_instance.to_dict()
# create an instance of InviteHouseholdMemberRequest from a dict
invite_household_member_request_from_dict = InviteHouseholdMemberRequest.from_dict(invite_household_member_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


