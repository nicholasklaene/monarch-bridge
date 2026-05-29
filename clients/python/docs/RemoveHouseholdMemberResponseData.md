# RemoveHouseholdMemberResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**removed** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.remove_household_member_response_data import RemoveHouseholdMemberResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of RemoveHouseholdMemberResponseData from a JSON string
remove_household_member_response_data_instance = RemoveHouseholdMemberResponseData.from_json(json)
# print the JSON string representation of the object
print(RemoveHouseholdMemberResponseData.to_json())

# convert the object into a dict
remove_household_member_response_data_dict = remove_household_member_response_data_instance.to_dict()
# create an instance of RemoveHouseholdMemberResponseData from a dict
remove_household_member_response_data_from_dict = RemoveHouseholdMemberResponseData.from_dict(remove_household_member_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


