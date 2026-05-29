# GetHouseholdMembersResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**me_id** | **str** |  | 
**household_id** | **str** |  | 
**members** | [**List[GetHouseholdMembersResponseDataMembersInner]**](GetHouseholdMembersResponseDataMembersInner.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_household_members_response_data import GetHouseholdMembersResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetHouseholdMembersResponseData from a JSON string
get_household_members_response_data_instance = GetHouseholdMembersResponseData.from_json(json)
# print the JSON string representation of the object
print(GetHouseholdMembersResponseData.to_json())

# convert the object into a dict
get_household_members_response_data_dict = get_household_members_response_data_instance.to_dict()
# create an instance of GetHouseholdMembersResponseData from a dict
get_household_members_response_data_from_dict = GetHouseholdMembersResponseData.from_dict(get_household_members_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


