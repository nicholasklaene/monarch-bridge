# TaxScheduleCategoryMapping


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**line_item** | **str** |  | [optional] 
**schedule** | **str** |  | [optional] 
**tax_year** | **int** |  | [optional] 
**category** | [**TaxCategoryRef**](TaxCategoryRef.md) |  | [optional] 
**line_item_info** | [**TaxLineItemInfo**](TaxLineItemInfo.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.tax_schedule_category_mapping import TaxScheduleCategoryMapping

# TODO update the JSON string below
json = "{}"
# create an instance of TaxScheduleCategoryMapping from a JSON string
tax_schedule_category_mapping_instance = TaxScheduleCategoryMapping.from_json(json)
# print the JSON string representation of the object
print(TaxScheduleCategoryMapping.to_json())

# convert the object into a dict
tax_schedule_category_mapping_dict = tax_schedule_category_mapping_instance.to_dict()
# create an instance of TaxScheduleCategoryMapping from a dict
tax_schedule_category_mapping_from_dict = TaxScheduleCategoryMapping.from_dict(tax_schedule_category_mapping_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


