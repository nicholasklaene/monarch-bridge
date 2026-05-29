# TaxCategoryRef


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**icon** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.tax_category_ref import TaxCategoryRef

# TODO update the JSON string below
json = "{}"
# create an instance of TaxCategoryRef from a JSON string
tax_category_ref_instance = TaxCategoryRef.from_json(json)
# print the JSON string representation of the object
print(TaxCategoryRef.to_json())

# convert the object into a dict
tax_category_ref_dict = tax_category_ref_instance.to_dict()
# create an instance of TaxCategoryRef from a dict
tax_category_ref_from_dict = TaxCategoryRef.from_dict(tax_category_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


