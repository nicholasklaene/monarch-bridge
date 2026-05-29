# ExpenseByMerchantRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**merchant_id** | **str** |  | 
**merchant_name** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**transaction_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.expense_by_merchant_row import ExpenseByMerchantRow

# TODO update the JSON string below
json = "{}"
# create an instance of ExpenseByMerchantRow from a JSON string
expense_by_merchant_row_instance = ExpenseByMerchantRow.from_json(json)
# print the JSON string representation of the object
print(ExpenseByMerchantRow.to_json())

# convert the object into a dict
expense_by_merchant_row_dict = expense_by_merchant_row_instance.to_dict()
# create an instance of ExpenseByMerchantRow from a dict
expense_by_merchant_row_from_dict = ExpenseByMerchantRow.from_dict(expense_by_merchant_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


