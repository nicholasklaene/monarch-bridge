# GetAccountsForTransactionsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetAccountsForTransactionFilterResponseData**](GetAccountsForTransactionFilterResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_accounts_for_transactions_response import GetAccountsForTransactionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetAccountsForTransactionsResponse from a JSON string
get_accounts_for_transactions_response_instance = GetAccountsForTransactionsResponse.from_json(json)
# print the JSON string representation of the object
print(GetAccountsForTransactionsResponse.to_json())

# convert the object into a dict
get_accounts_for_transactions_response_dict = get_accounts_for_transactions_response_instance.to_dict()
# create an instance of GetAccountsForTransactionsResponse from a dict
get_accounts_for_transactions_response_from_dict = GetAccountsForTransactionsResponse.from_dict(get_accounts_for_transactions_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


