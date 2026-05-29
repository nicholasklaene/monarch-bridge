# GetCategoryGroupDetailsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCategoryGroupDetailsResponseData**](GetCategoryGroupDetailsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_category_group_details_response import GetCategoryGroupDetailsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCategoryGroupDetailsResponse from a JSON string
get_category_group_details_response_instance = GetCategoryGroupDetailsResponse.from_json(json)
# print the JSON string representation of the object
print(GetCategoryGroupDetailsResponse.to_json())

# convert the object into a dict
get_category_group_details_response_dict = get_category_group_details_response_instance.to_dict()
# create an instance of GetCategoryGroupDetailsResponse from a dict
get_category_group_details_response_from_dict = GetCategoryGroupDetailsResponse.from_dict(get_category_group_details_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


