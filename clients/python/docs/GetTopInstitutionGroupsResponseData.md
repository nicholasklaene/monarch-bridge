# GetTopInstitutionGroupsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | [**List[TopInstitutionGroup]**](TopInstitutionGroup.md) |  | 
**equity_accounts_count** | **int** |  | [optional] 
**credentials_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_top_institution_groups_response_data import GetTopInstitutionGroupsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTopInstitutionGroupsResponseData from a JSON string
get_top_institution_groups_response_data_instance = GetTopInstitutionGroupsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTopInstitutionGroupsResponseData.to_json())

# convert the object into a dict
get_top_institution_groups_response_data_dict = get_top_institution_groups_response_data_instance.to_dict()
# create an instance of GetTopInstitutionGroupsResponseData from a dict
get_top_institution_groups_response_data_from_dict = GetTopInstitutionGroupsResponseData.from_dict(get_top_institution_groups_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


