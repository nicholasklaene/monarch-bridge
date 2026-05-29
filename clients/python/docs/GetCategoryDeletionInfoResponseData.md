# GetCategoryDeletionInfoResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category** | [**CategoryDeletionInfo**](CategoryDeletionInfo.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_category_deletion_info_response_data import GetCategoryDeletionInfoResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCategoryDeletionInfoResponseData from a JSON string
get_category_deletion_info_response_data_instance = GetCategoryDeletionInfoResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCategoryDeletionInfoResponseData.to_json())

# convert the object into a dict
get_category_deletion_info_response_data_dict = get_category_deletion_info_response_data_instance.to_dict()
# create an instance of GetCategoryDeletionInfoResponseData from a dict
get_category_deletion_info_response_data_from_dict = GetCategoryDeletionInfoResponseData.from_dict(get_category_deletion_info_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


