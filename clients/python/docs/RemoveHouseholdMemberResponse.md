# RemoveHouseholdMemberResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**RemoveHouseholdMemberResponseData**](RemoveHouseholdMemberResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.remove_household_member_response import RemoveHouseholdMemberResponse

# TODO update the JSON string below
json = "{}"
# create an instance of RemoveHouseholdMemberResponse from a JSON string
remove_household_member_response_instance = RemoveHouseholdMemberResponse.from_json(json)
# print the JSON string representation of the object
print(RemoveHouseholdMemberResponse.to_json())

# convert the object into a dict
remove_household_member_response_dict = remove_household_member_response_instance.to_dict()
# create an instance of RemoveHouseholdMemberResponse from a dict
remove_household_member_response_from_dict = RemoveHouseholdMemberResponse.from_dict(remove_household_member_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


