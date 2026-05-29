# HouseholdInvite


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**invited_email** | **str** |  | [optional] 
**created_at** | **str** |  | [optional] 
**is_revoked** | **bool** |  | [optional] 
**used_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.household_invite import HouseholdInvite

# TODO update the JSON string below
json = "{}"
# create an instance of HouseholdInvite from a JSON string
household_invite_instance = HouseholdInvite.from_json(json)
# print the JSON string representation of the object
print(HouseholdInvite.to_json())

# convert the object into a dict
household_invite_dict = household_invite_instance.to_dict()
# create an instance of HouseholdInvite from a dict
household_invite_from_dict = HouseholdInvite.from_dict(household_invite_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


