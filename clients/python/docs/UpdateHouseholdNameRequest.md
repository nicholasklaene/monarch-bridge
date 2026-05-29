# UpdateHouseholdNameRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 

## Example

```python
from monarch_bridge_client.models.update_household_name_request import UpdateHouseholdNameRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateHouseholdNameRequest from a JSON string
update_household_name_request_instance = UpdateHouseholdNameRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateHouseholdNameRequest.to_json())

# convert the object into a dict
update_household_name_request_dict = update_household_name_request_instance.to_dict()
# create an instance of UpdateHouseholdNameRequest from a dict
update_household_name_request_from_dict = UpdateHouseholdNameRequest.from_dict(update_household_name_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


