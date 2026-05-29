# UpdateCategoryGroupResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateCategoryGroupResponseData**](CreateCategoryGroupResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_category_group_response import UpdateCategoryGroupResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateCategoryGroupResponse from a JSON string
update_category_group_response_instance = UpdateCategoryGroupResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateCategoryGroupResponse.to_json())

# convert the object into a dict
update_category_group_response_dict = update_category_group_response_instance.to_dict()
# create an instance of UpdateCategoryGroupResponse from a dict
update_category_group_response_from_dict = UpdateCategoryGroupResponse.from_dict(update_category_group_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


