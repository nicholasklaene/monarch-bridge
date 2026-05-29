# TaxCategoryAggregateRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category** | [**TaxCategoryWithSystem**](TaxCategoryWithSystem.md) |  | 
**sum** | **float** |  | [optional] 
**count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.tax_category_aggregate_row import TaxCategoryAggregateRow

# TODO update the JSON string below
json = "{}"
# create an instance of TaxCategoryAggregateRow from a JSON string
tax_category_aggregate_row_instance = TaxCategoryAggregateRow.from_json(json)
# print the JSON string representation of the object
print(TaxCategoryAggregateRow.to_json())

# convert the object into a dict
tax_category_aggregate_row_dict = tax_category_aggregate_row_instance.to_dict()
# create an instance of TaxCategoryAggregateRow from a dict
tax_category_aggregate_row_from_dict = TaxCategoryAggregateRow.from_dict(tax_category_aggregate_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


