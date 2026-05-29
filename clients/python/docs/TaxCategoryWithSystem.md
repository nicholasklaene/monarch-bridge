# TaxCategoryWithSystem


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**icon** | **str** |  | [optional] 
**system_category** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.tax_category_with_system import TaxCategoryWithSystem

# TODO update the JSON string below
json = "{}"
# create an instance of TaxCategoryWithSystem from a JSON string
tax_category_with_system_instance = TaxCategoryWithSystem.from_json(json)
# print the JSON string representation of the object
print(TaxCategoryWithSystem.to_json())

# convert the object into a dict
tax_category_with_system_dict = tax_category_with_system_instance.to_dict()
# create an instance of TaxCategoryWithSystem from a dict
tax_category_with_system_from_dict = TaxCategoryWithSystem.from_dict(tax_category_with_system_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


