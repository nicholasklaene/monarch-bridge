# UserProfileFlags


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**has_seen_categories_management_tour** | **bool** |  | [optional] 
**collaborates_on_finances_detailed** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.user_profile_flags import UserProfileFlags

# TODO update the JSON string below
json = "{}"
# create an instance of UserProfileFlags from a JSON string
user_profile_flags_instance = UserProfileFlags.from_json(json)
# print the JSON string representation of the object
print(UserProfileFlags.to_json())

# convert the object into a dict
user_profile_flags_dict = user_profile_flags_instance.to_dict()
# create an instance of UserProfileFlags from a dict
user_profile_flags_from_dict = UserProfileFlags.from_dict(user_profile_flags_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


