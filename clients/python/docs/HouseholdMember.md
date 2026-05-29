# HouseholdMember


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**email** | **str** |  | [optional] 
**household_role** | **str** |  | [optional] 
**has_mfa_on** | **bool** |  | [optional] 
**profile_picture_url** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.household_member import HouseholdMember

# TODO update the JSON string below
json = "{}"
# create an instance of HouseholdMember from a JSON string
household_member_instance = HouseholdMember.from_json(json)
# print the JSON string representation of the object
print(HouseholdMember.to_json())

# convert the object into a dict
household_member_dict = household_member_instance.to_dict()
# create an instance of HouseholdMember from a dict
household_member_from_dict = HouseholdMember.from_dict(household_member_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


