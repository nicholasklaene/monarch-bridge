# CashflowCategoryRef


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**icon** | **str** |  | [optional] 
**group_id** | **str** |  | [optional] 
**group_type** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.cashflow_category_ref import CashflowCategoryRef

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowCategoryRef from a JSON string
cashflow_category_ref_instance = CashflowCategoryRef.from_json(json)
# print the JSON string representation of the object
print(CashflowCategoryRef.to_json())

# convert the object into a dict
cashflow_category_ref_dict = cashflow_category_ref_instance.to_dict()
# create an instance of CashflowCategoryRef from a dict
cashflow_category_ref_from_dict = CashflowCategoryRef.from_dict(cashflow_category_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


