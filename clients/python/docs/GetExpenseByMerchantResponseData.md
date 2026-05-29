# GetExpenseByMerchantResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rows** | [**List[ExpenseByMerchantRow]**](ExpenseByMerchantRow.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_expense_by_merchant_response_data import GetExpenseByMerchantResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetExpenseByMerchantResponseData from a JSON string
get_expense_by_merchant_response_data_instance = GetExpenseByMerchantResponseData.from_json(json)
# print the JSON string representation of the object
print(GetExpenseByMerchantResponseData.to_json())

# convert the object into a dict
get_expense_by_merchant_response_data_dict = get_expense_by_merchant_response_data_instance.to_dict()
# create an instance of GetExpenseByMerchantResponseData from a dict
get_expense_by_merchant_response_data_from_dict = GetExpenseByMerchantResponseData.from_dict(get_expense_by_merchant_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


