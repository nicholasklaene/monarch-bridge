# GetTaxScheduleCategoryMappingsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTaxScheduleCategoryMappingsResponseData**](GetTaxScheduleCategoryMappingsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tax_schedule_category_mappings_response import GetTaxScheduleCategoryMappingsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxScheduleCategoryMappingsResponse from a JSON string
get_tax_schedule_category_mappings_response_instance = GetTaxScheduleCategoryMappingsResponse.from_json(json)
# print the JSON string representation of the object
print(GetTaxScheduleCategoryMappingsResponse.to_json())

# convert the object into a dict
get_tax_schedule_category_mappings_response_dict = get_tax_schedule_category_mappings_response_instance.to_dict()
# create an instance of GetTaxScheduleCategoryMappingsResponse from a dict
get_tax_schedule_category_mappings_response_from_dict = GetTaxScheduleCategoryMappingsResponse.from_dict(get_tax_schedule_category_mappings_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


