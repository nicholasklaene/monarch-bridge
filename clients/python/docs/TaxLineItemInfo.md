# TaxLineItemInfo


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**key** | **str** |  | 
**line_number** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**line_type** | **str** |  | [optional] 
**sort_order** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.tax_line_item_info import TaxLineItemInfo

# TODO update the JSON string below
json = "{}"
# create an instance of TaxLineItemInfo from a JSON string
tax_line_item_info_instance = TaxLineItemInfo.from_json(json)
# print the JSON string representation of the object
print(TaxLineItemInfo.to_json())

# convert the object into a dict
tax_line_item_info_dict = tax_line_item_info_instance.to_dict()
# create an instance of TaxLineItemInfo from a dict
tax_line_item_info_from_dict = TaxLineItemInfo.from_dict(tax_line_item_info_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


