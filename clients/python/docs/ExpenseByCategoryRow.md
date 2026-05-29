# ExpenseByCategoryRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_id** | **str** |  | 
**category_name** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**transaction_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.expense_by_category_row import ExpenseByCategoryRow

# TODO update the JSON string below
json = "{}"
# create an instance of ExpenseByCategoryRow from a JSON string
expense_by_category_row_instance = ExpenseByCategoryRow.from_json(json)
# print the JSON string representation of the object
print(ExpenseByCategoryRow.to_json())

# convert the object into a dict
expense_by_category_row_dict = expense_by_category_row_instance.to_dict()
# create an instance of ExpenseByCategoryRow from a dict
expense_by_category_row_from_dict = ExpenseByCategoryRow.from_dict(expense_by_category_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


