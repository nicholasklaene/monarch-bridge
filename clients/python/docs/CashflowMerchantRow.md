# CashflowMerchantRow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**merchant** | [**CashflowMerchantRef**](CashflowMerchantRef.md) |  | 
**sum_income** | **float** |  | [optional] 
**sum_expense** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.cashflow_merchant_row import CashflowMerchantRow

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowMerchantRow from a JSON string
cashflow_merchant_row_instance = CashflowMerchantRow.from_json(json)
# print the JSON string representation of the object
print(CashflowMerchantRow.to_json())

# convert the object into a dict
cashflow_merchant_row_dict = cashflow_merchant_row_instance.to_dict()
# create an instance of CashflowMerchantRow from a dict
cashflow_merchant_row_from_dict = CashflowMerchantRow.from_dict(cashflow_merchant_row_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


