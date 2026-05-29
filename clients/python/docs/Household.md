# Household


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
from monarch_bridge_client.models.household import Household

# TODO update the JSON string below
json = "{}"
# create an instance of Household from a JSON string
household_instance = Household.from_json(json)
# print the JSON string representation of the object
print(Household.to_json())

# convert the object into a dict
household_dict = household_instance.to_dict()
# create an instance of Household from a dict
household_from_dict = Household.from_dict(household_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


