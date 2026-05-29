# ListCategoryGroupsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListCategoryGroupsResponseData**](ListCategoryGroupsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_category_groups_response import ListCategoryGroupsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListCategoryGroupsResponse from a JSON string
list_category_groups_response_instance = ListCategoryGroupsResponse.from_json(json)
# print the JSON string representation of the object
print(ListCategoryGroupsResponse.to_json())

# convert the object into a dict
list_category_groups_response_dict = list_category_groups_response_instance.to_dict()
# create an instance of ListCategoryGroupsResponse from a dict
list_category_groups_response_from_dict = ListCategoryGroupsResponse.from_dict(list_category_groups_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


