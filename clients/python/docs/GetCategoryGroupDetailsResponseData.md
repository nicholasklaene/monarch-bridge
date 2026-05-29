# GetCategoryGroupDetailsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_group** | [**CategoryGroupDetails**](CategoryGroupDetails.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_category_group_details_response_data import GetCategoryGroupDetailsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCategoryGroupDetailsResponseData from a JSON string
get_category_group_details_response_data_instance = GetCategoryGroupDetailsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCategoryGroupDetailsResponseData.to_json())

# convert the object into a dict
get_category_group_details_response_data_dict = get_category_group_details_response_data_instance.to_dict()
# create an instance of GetCategoryGroupDetailsResponseData from a dict
get_category_group_details_response_data_from_dict = GetCategoryGroupDetailsResponseData.from_dict(get_category_group_details_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


