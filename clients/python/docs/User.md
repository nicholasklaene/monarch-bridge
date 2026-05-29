# User


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**email** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**birthday** | **date** |  | [optional] 
**timezone** | **str** |  | [optional] 
**has_password** | **bool** |  | [optional] 
**has_mfa_on** | **bool** |  | [optional] 
**is_superuser** | **bool** |  | [optional] 
**household_role** | **str** |  | [optional] 
**external_auth_provider_names** | **List[str]** |  | [optional] 
**created_at** | **str** |  | [optional] 
**profile_picture_url** | **str** |  | [optional] 
**profile** | [**UserProfileFlags**](UserProfileFlags.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.user import User

# TODO update the JSON string below
json = "{}"
# create an instance of User from a JSON string
user_instance = User.from_json(json)
# print the JSON string representation of the object
print(User.to_json())

# convert the object into a dict
user_dict = user_instance.to_dict()
# create an instance of User from a dict
user_from_dict = User.from_dict(user_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


