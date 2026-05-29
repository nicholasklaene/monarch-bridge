# GetHouseholdMembersResponseDataMembersInner


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**household_role** | **str** |  | [optional] 
**profile_picture_url** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_household_members_response_data_members_inner import GetHouseholdMembersResponseDataMembersInner

# TODO update the JSON string below
json = "{}"
# create an instance of GetHouseholdMembersResponseDataMembersInner from a JSON string
get_household_members_response_data_members_inner_instance = GetHouseholdMembersResponseDataMembersInner.from_json(json)
# print the JSON string representation of the object
print(GetHouseholdMembersResponseDataMembersInner.to_json())

# convert the object into a dict
get_household_members_response_data_members_inner_dict = get_household_members_response_data_members_inner_instance.to_dict()
# create an instance of GetHouseholdMembersResponseDataMembersInner from a dict
get_household_members_response_data_members_inner_from_dict = GetHouseholdMembersResponseDataMembersInner.from_dict(get_household_members_response_data_members_inner_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


