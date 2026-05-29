# GetAccountsForTransactionFilterResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accounts** | [**List[AccountForFilterRow]**](AccountForFilterRow.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_accounts_for_transaction_filter_response_data import GetAccountsForTransactionFilterResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetAccountsForTransactionFilterResponseData from a JSON string
get_accounts_for_transaction_filter_response_data_instance = GetAccountsForTransactionFilterResponseData.from_json(json)
# print the JSON string representation of the object
print(GetAccountsForTransactionFilterResponseData.to_json())

# convert the object into a dict
get_accounts_for_transaction_filter_response_data_dict = get_accounts_for_transaction_filter_response_data_instance.to_dict()
# create an instance of GetAccountsForTransactionFilterResponseData from a dict
get_accounts_for_transaction_filter_response_data_from_dict = GetAccountsForTransactionFilterResponseData.from_dict(get_accounts_for_transaction_filter_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


