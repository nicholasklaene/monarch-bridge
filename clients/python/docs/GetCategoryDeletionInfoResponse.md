# GetCategoryDeletionInfoResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCategoryDeletionInfoResponseData**](GetCategoryDeletionInfoResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_category_deletion_info_response import GetCategoryDeletionInfoResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCategoryDeletionInfoResponse from a JSON string
get_category_deletion_info_response_instance = GetCategoryDeletionInfoResponse.from_json(json)
# print the JSON string representation of the object
print(GetCategoryDeletionInfoResponse.to_json())

# convert the object into a dict
get_category_deletion_info_response_dict = get_category_deletion_info_response_instance.to_dict()
# create an instance of GetCategoryDeletionInfoResponse from a dict
get_category_deletion_info_response_from_dict = GetCategoryDeletionInfoResponse.from_dict(get_category_deletion_info_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


