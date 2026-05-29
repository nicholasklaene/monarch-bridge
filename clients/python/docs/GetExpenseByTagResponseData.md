# GetExpenseByTagResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rows** | [**List[ExpenseByTagRow]**](ExpenseByTagRow.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_expense_by_tag_response_data import GetExpenseByTagResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetExpenseByTagResponseData from a JSON string
get_expense_by_tag_response_data_instance = GetExpenseByTagResponseData.from_json(json)
# print the JSON string representation of the object
print(GetExpenseByTagResponseData.to_json())

# convert the object into a dict
get_expense_by_tag_response_data_dict = get_expense_by_tag_response_data_instance.to_dict()
# create an instance of GetExpenseByTagResponseData from a dict
get_expense_by_tag_response_data_from_dict = GetExpenseByTagResponseData.from_dict(get_expense_by_tag_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


