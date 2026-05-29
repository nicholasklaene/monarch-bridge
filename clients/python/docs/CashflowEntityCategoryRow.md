# CashflowEntityCategoryRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category** | [**CashflowCategoryRef**](CashflowCategoryRef.md) |  | 
**sum** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.cashflow_entity_category_row import CashflowEntityCategoryRow

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowEntityCategoryRow from a JSON string
cashflow_entity_category_row_instance = CashflowEntityCategoryRow.from_json(json)
# print the JSON string representation of the object
print(CashflowEntityCategoryRow.to_json())

# convert the object into a dict
cashflow_entity_category_row_dict = cashflow_entity_category_row_instance.to_dict()
# create an instance of CashflowEntityCategoryRow from a dict
cashflow_entity_category_row_from_dict = CashflowEntityCategoryRow.from_dict(cashflow_entity_category_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


