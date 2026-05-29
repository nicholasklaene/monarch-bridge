# CashflowCategoryGroupRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_group** | [**CashflowCategoryGroupRef**](CashflowCategoryGroupRef.md) |  | 
**sum** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.cashflow_category_group_row import CashflowCategoryGroupRow

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowCategoryGroupRow from a JSON string
cashflow_category_group_row_instance = CashflowCategoryGroupRow.from_json(json)
# print the JSON string representation of the object
print(CashflowCategoryGroupRow.to_json())

# convert the object into a dict
cashflow_category_group_row_dict = cashflow_category_group_row_instance.to_dict()
# create an instance of CashflowCategoryGroupRow from a dict
cashflow_category_group_row_from_dict = CashflowCategoryGroupRow.from_dict(cashflow_category_group_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


