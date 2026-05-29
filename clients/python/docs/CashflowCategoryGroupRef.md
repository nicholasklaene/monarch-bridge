# CashflowCategoryGroupRef


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**type** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.cashflow_category_group_ref import CashflowCategoryGroupRef

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowCategoryGroupRef from a JSON string
cashflow_category_group_ref_instance = CashflowCategoryGroupRef.from_json(json)
# print the JSON string representation of the object
print(CashflowCategoryGroupRef.to_json())

# convert the object into a dict
cashflow_category_group_ref_dict = cashflow_category_group_ref_instance.to_dict()
# create an instance of CashflowCategoryGroupRef from a dict
cashflow_category_group_ref_from_dict = CashflowCategoryGroupRef.from_dict(cashflow_category_group_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


