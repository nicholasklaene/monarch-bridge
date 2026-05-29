# GetMerchantTransactionsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetMerchantTransactionsResponseData**](GetMerchantTransactionsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_merchant_transactions_response import GetMerchantTransactionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetMerchantTransactionsResponse from a JSON string
get_merchant_transactions_response_instance = GetMerchantTransactionsResponse.from_json(json)
# print the JSON string representation of the object
print(GetMerchantTransactionsResponse.to_json())

# convert the object into a dict
get_merchant_transactions_response_dict = get_merchant_transactions_response_instance.to_dict()
# create an instance of GetMerchantTransactionsResponse from a dict
get_merchant_transactions_response_from_dict = GetMerchantTransactionsResponse.from_dict(get_merchant_transactions_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


