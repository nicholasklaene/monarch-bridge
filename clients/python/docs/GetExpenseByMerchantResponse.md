# GetExpenseByMerchantResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetExpenseByMerchantResponseData**](GetExpenseByMerchantResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_expense_by_merchant_response import GetExpenseByMerchantResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetExpenseByMerchantResponse from a JSON string
get_expense_by_merchant_response_instance = GetExpenseByMerchantResponse.from_json(json)
# print the JSON string representation of the object
print(GetExpenseByMerchantResponse.to_json())

# convert the object into a dict
get_expense_by_merchant_response_dict = get_expense_by_merchant_response_instance.to_dict()
# create an instance of GetExpenseByMerchantResponse from a dict
get_expense_by_merchant_response_from_dict = GetExpenseByMerchantResponse.from_dict(get_expense_by_merchant_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


