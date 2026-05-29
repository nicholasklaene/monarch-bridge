# UpdateHouseholdNameResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_household_name_response_data import UpdateHouseholdNameResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateHouseholdNameResponseData from a JSON string
update_household_name_response_data_instance = UpdateHouseholdNameResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateHouseholdNameResponseData.to_json())

# convert the object into a dict
update_household_name_response_data_dict = update_household_name_response_data_instance.to_dict()
# create an instance of UpdateHouseholdNameResponseData from a dict
update_household_name_response_data_from_dict = UpdateHouseholdNameResponseData.from_dict(update_household_name_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


