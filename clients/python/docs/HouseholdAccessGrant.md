# HouseholdAccessGrant


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**to_email** | **str** |  | [optional] 
**to_name** | **str** |  | [optional] 
**created_at** | **str** |  | [optional] 
**expires_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.household_access_grant import HouseholdAccessGrant

# TODO update the JSON string below
json = "{}"
# create an instance of HouseholdAccessGrant from a JSON string
household_access_grant_instance = HouseholdAccessGrant.from_json(json)
# print the JSON string representation of the object
print(HouseholdAccessGrant.to_json())

# convert the object into a dict
household_access_grant_dict = household_access_grant_instance.to_dict()
# create an instance of HouseholdAccessGrant from a dict
household_access_grant_from_dict = HouseholdAccessGrant.from_dict(household_access_grant_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


