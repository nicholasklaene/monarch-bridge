# GetAccountBalanceAtDateResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetAccountBalanceAtDateResponseData**](GetAccountBalanceAtDateResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_account_balance_at_date_response import GetAccountBalanceAtDateResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetAccountBalanceAtDateResponse from a JSON string
get_account_balance_at_date_response_instance = GetAccountBalanceAtDateResponse.from_json(json)
# print the JSON string representation of the object
print(GetAccountBalanceAtDateResponse.to_json())

# convert the object into a dict
get_account_balance_at_date_response_dict = get_account_balance_at_date_response_instance.to_dict()
# create an instance of GetAccountBalanceAtDateResponse from a dict
get_account_balance_at_date_response_from_dict = GetAccountBalanceAtDateResponse.from_dict(get_account_balance_at_date_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


