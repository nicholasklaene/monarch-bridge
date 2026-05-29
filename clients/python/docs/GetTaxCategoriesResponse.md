# GetTaxCategoriesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTaxCategoriesResponseData**](GetTaxCategoriesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tax_categories_response import GetTaxCategoriesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxCategoriesResponse from a JSON string
get_tax_categories_response_instance = GetTaxCategoriesResponse.from_json(json)
# print the JSON string representation of the object
print(GetTaxCategoriesResponse.to_json())

# convert the object into a dict
get_tax_categories_response_dict = get_tax_categories_response_instance.to_dict()
# create an instance of GetTaxCategoriesResponse from a dict
get_tax_categories_response_from_dict = GetTaxCategoriesResponse.from_dict(get_tax_categories_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


