# ListCategoriesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**categories** | [**List[Category]**](Category.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_categories_response_data import ListCategoriesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListCategoriesResponseData from a JSON string
list_categories_response_data_instance = ListCategoriesResponseData.from_json(json)
# print the JSON string representation of the object
print(ListCategoriesResponseData.to_json())

# convert the object into a dict
list_categories_response_data_dict = list_categories_response_data_instance.to_dict()
# create an instance of ListCategoriesResponseData from a dict
list_categories_response_data_from_dict = ListCategoriesResponseData.from_dict(list_categories_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


