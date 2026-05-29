# GetTaxScheduleCategoryMappingsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**mappings** | [**List[TaxScheduleCategoryMapping]**](TaxScheduleCategoryMapping.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tax_schedule_category_mappings_response_data import GetTaxScheduleCategoryMappingsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxScheduleCategoryMappingsResponseData from a JSON string
get_tax_schedule_category_mappings_response_data_instance = GetTaxScheduleCategoryMappingsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTaxScheduleCategoryMappingsResponseData.to_json())

# convert the object into a dict
get_tax_schedule_category_mappings_response_data_dict = get_tax_schedule_category_mappings_response_data_instance.to_dict()
# create an instance of GetTaxScheduleCategoryMappingsResponseData from a dict
get_tax_schedule_category_mappings_response_data_from_dict = GetTaxScheduleCategoryMappingsResponseData.from_dict(get_tax_schedule_category_mappings_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


