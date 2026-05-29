# GetTaxCategoryAggregatesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rows** | [**List[TaxCategoryAggregateRow]**](TaxCategoryAggregateRow.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tax_category_aggregates_response_data import GetTaxCategoryAggregatesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTaxCategoryAggregatesResponseData from a JSON string
get_tax_category_aggregates_response_data_instance = GetTaxCategoryAggregatesResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTaxCategoryAggregatesResponseData.to_json())

# convert the object into a dict
get_tax_category_aggregates_response_data_dict = get_tax_category_aggregates_response_data_instance.to_dict()
# create an instance of GetTaxCategoryAggregatesResponseData from a dict
get_tax_category_aggregates_response_data_from_dict = GetTaxCategoryAggregatesResponseData.from_dict(get_tax_category_aggregates_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


