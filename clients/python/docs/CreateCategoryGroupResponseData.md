# CreateCategoryGroupResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_group** | [**CategoryGroup**](CategoryGroup.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_category_group_response_data import CreateCategoryGroupResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of CreateCategoryGroupResponseData from a JSON string
create_category_group_response_data_instance = CreateCategoryGroupResponseData.from_json(json)
# print the JSON string representation of the object
print(CreateCategoryGroupResponseData.to_json())

# convert the object into a dict
create_category_group_response_data_dict = create_category_group_response_data_instance.to_dict()
# create an instance of CreateCategoryGroupResponseData from a dict
create_category_group_response_data_from_dict = CreateCategoryGroupResponseData.from_dict(create_category_group_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


