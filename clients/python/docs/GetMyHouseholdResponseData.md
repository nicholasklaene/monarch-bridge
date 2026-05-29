# GetMyHouseholdResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**address** | **str** |  | [optional] 
**city** | **str** |  | [optional] 
**state** | **str** |  | [optional] 
**zip_code** | **str** |  | [optional] 
**country** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_my_household_response_data import GetMyHouseholdResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetMyHouseholdResponseData from a JSON string
get_my_household_response_data_instance = GetMyHouseholdResponseData.from_json(json)
# print the JSON string representation of the object
print(GetMyHouseholdResponseData.to_json())

# convert the object into a dict
get_my_household_response_data_dict = get_my_household_response_data_instance.to_dict()
# create an instance of GetMyHouseholdResponseData from a dict
get_my_household_response_data_from_dict = GetMyHouseholdResponseData.from_dict(get_my_household_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


