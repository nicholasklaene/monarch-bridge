# TopInstitutionGroup


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **str** |  | 
**title** | **str** |  | [optional] 
**short_title** | **str** |  | [optional] 
**accounts_connected_count** | **int** |  | [optional] 
**institutions** | [**List[TopInstitution]**](TopInstitution.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.top_institution_group import TopInstitutionGroup

# TODO update the JSON string below
json = "{}"
# create an instance of TopInstitutionGroup from a JSON string
top_institution_group_instance = TopInstitutionGroup.from_json(json)
# print the JSON string representation of the object
print(TopInstitutionGroup.to_json())

# convert the object into a dict
top_institution_group_dict = top_institution_group_instance.to_dict()
# create an instance of TopInstitutionGroup from a dict
top_institution_group_from_dict = TopInstitutionGroup.from_dict(top_institution_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


