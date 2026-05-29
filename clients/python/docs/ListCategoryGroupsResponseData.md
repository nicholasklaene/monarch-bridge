# ListCategoryGroupsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_groups** | [**List[CategoryGroup]**](CategoryGroup.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_category_groups_response_data import ListCategoryGroupsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListCategoryGroupsResponseData from a JSON string
list_category_groups_response_data_instance = ListCategoryGroupsResponseData.from_json(json)
# print the JSON string representation of the object
print(ListCategoryGroupsResponseData.to_json())

# convert the object into a dict
list_category_groups_response_data_dict = list_category_groups_response_data_instance.to_dict()
# create an instance of ListCategoryGroupsResponseData from a dict
list_category_groups_response_data_from_dict = ListCategoryGroupsResponseData.from_dict(list_category_groups_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


