# GetTopInstitutionGroupsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTopInstitutionGroupsResponseData**](GetTopInstitutionGroupsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_top_institution_groups_response import GetTopInstitutionGroupsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTopInstitutionGroupsResponse from a JSON string
get_top_institution_groups_response_instance = GetTopInstitutionGroupsResponse.from_json(json)
# print the JSON string representation of the object
print(GetTopInstitutionGroupsResponse.to_json())

# convert the object into a dict
get_top_institution_groups_response_dict = get_top_institution_groups_response_instance.to_dict()
# create an instance of GetTopInstitutionGroupsResponse from a dict
get_top_institution_groups_response_from_dict = GetTopInstitutionGroupsResponse.from_dict(get_top_institution_groups_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


