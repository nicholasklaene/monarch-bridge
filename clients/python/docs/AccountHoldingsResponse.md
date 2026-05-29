# AccountHoldingsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetAccountHoldingsResponseData**](GetAccountHoldingsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.account_holdings_response import AccountHoldingsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of AccountHoldingsResponse from a JSON string
account_holdings_response_instance = AccountHoldingsResponse.from_json(json)
# print the JSON string representation of the object
print(AccountHoldingsResponse.to_json())

# convert the object into a dict
account_holdings_response_dict = account_holdings_response_instance.to_dict()
# create an instance of AccountHoldingsResponse from a dict
account_holdings_response_from_dict = AccountHoldingsResponse.from_dict(account_holdings_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


