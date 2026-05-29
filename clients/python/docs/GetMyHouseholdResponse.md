# GetMyHouseholdResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetMyHouseholdResponseData**](GetMyHouseholdResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_my_household_response import GetMyHouseholdResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetMyHouseholdResponse from a JSON string
get_my_household_response_instance = GetMyHouseholdResponse.from_json(json)
# print the JSON string representation of the object
print(GetMyHouseholdResponse.to_json())

# convert the object into a dict
get_my_household_response_dict = get_my_household_response_instance.to_dict()
# create an instance of GetMyHouseholdResponse from a dict
get_my_household_response_from_dict = GetMyHouseholdResponse.from_dict(get_my_household_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


