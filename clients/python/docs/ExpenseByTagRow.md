# ExpenseByTagRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tag_id** | **str** |  | 
**tag_name** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**transaction_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.expense_by_tag_row import ExpenseByTagRow

# TODO update the JSON string below
json = "{}"
# create an instance of ExpenseByTagRow from a JSON string
expense_by_tag_row_instance = ExpenseByTagRow.from_json(json)
# print the JSON string representation of the object
print(ExpenseByTagRow.to_json())

# convert the object into a dict
expense_by_tag_row_dict = expense_by_tag_row_instance.to_dict()
# create an instance of ExpenseByTagRow from a dict
expense_by_tag_row_from_dict = ExpenseByTagRow.from_dict(expense_by_tag_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


