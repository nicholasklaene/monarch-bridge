# GetTaxCategoriesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**categories** | [**List[TaxCategoryWithSystem]**](TaxCategoryWithSystem.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tax_categories_response_data import GetTaxCategoriesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxCategoriesResponseData from a JSON string
get_tax_categories_response_data_instance = GetTaxCategoriesResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTaxCategoriesResponseData.to_json())

# convert the object into a dict
get_tax_categories_response_data_dict = get_tax_categories_response_data_instance.to_dict()
# create an instance of GetTaxCategoriesResponseData from a dict
get_tax_categories_response_data_from_dict = GetTaxCategoriesResponseData.from_dict(get_tax_categories_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


