# GetMerchantTransactionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transactions** | [**List[MerchantTransactionRow]**](MerchantTransactionRow.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_merchant_transactions_response_data import GetMerchantTransactionsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetMerchantTransactionsResponseData from a JSON string
get_merchant_transactions_response_data_instance = GetMerchantTransactionsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetMerchantTransactionsResponseData.to_json())

# convert the object into a dict
get_merchant_transactions_response_data_dict = get_merchant_transactions_response_data_instance.to_dict()
# create an instance of GetMerchantTransactionsResponseData from a dict
get_merchant_transactions_response_data_from_dict = GetMerchantTransactionsResponseData.from_dict(get_merchant_transactions_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


