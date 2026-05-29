# InviteHouseholdMemberResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**invited** | **bool** |  | [optional] 
**email** | **str** |  | [optional] 
**role** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.invite_household_member_response_data import InviteHouseholdMemberResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of InviteHouseholdMemberResponseData from a JSON string
invite_household_member_response_data_instance = InviteHouseholdMemberResponseData.from_json(json)
# print the JSON string representation of the object
print(InviteHouseholdMemberResponseData.to_json())

# convert the object into a dict
invite_household_member_response_data_dict = invite_household_member_response_data_instance.to_dict()
# create an instance of InviteHouseholdMemberResponseData from a dict
invite_household_member_response_data_from_dict = InviteHouseholdMemberResponseData.from_dict(invite_household_member_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


