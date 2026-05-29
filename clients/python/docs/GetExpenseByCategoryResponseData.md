# GetExpenseByCategoryResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rows** | [**List[ExpenseByCategoryRow]**](ExpenseByCategoryRow.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_expense_by_category_response_data import GetExpenseByCategoryResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetExpenseByCategoryResponseData from a JSON string
get_expense_by_category_response_data_instance = GetExpenseByCategoryResponseData.from_json(json)
# print the JSON string representation of the object
print(GetExpenseByCategoryResponseData.to_json())

# convert the object into a dict
get_expense_by_category_response_data_dict = get_expense_by_category_response_data_instance.to_dict()
# create an instance of GetExpenseByCategoryResponseData from a dict
get_expense_by_category_response_data_from_dict = GetExpenseByCategoryResponseData.from_dict(get_expense_by_category_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


