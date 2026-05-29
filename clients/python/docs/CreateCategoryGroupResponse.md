# CreateCategoryGroupResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateCategoryGroupResponseData**](CreateCategoryGroupResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_category_group_response import CreateCategoryGroupResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreateCategoryGroupResponse from a JSON string
create_category_group_response_instance = CreateCategoryGroupResponse.from_json(json)
# print the JSON string representation of the object
print(CreateCategoryGroupResponse.to_json())

# convert the object into a dict
create_category_group_response_dict = create_category_group_response_instance.to_dict()
# create an instance of CreateCategoryGroupResponse from a dict
create_category_group_response_from_dict = CreateCategoryGroupResponse.from_dict(create_category_group_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


