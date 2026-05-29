# GetAccountHoldingsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetAccountHoldingsResponseData**](GetAccountHoldingsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_account_holdings_response import GetAccountHoldingsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetAccountHoldingsResponse from a JSON string
get_account_holdings_response_instance = GetAccountHoldingsResponse.from_json(json)
# print the JSON string representation of the object
print(GetAccountHoldingsResponse.to_json())

# convert the object into a dict
get_account_holdings_response_dict = get_account_holdings_response_instance.to_dict()
# create an instance of GetAccountHoldingsResponse from a dict
get_account_holdings_response_from_dict = GetAccountHoldingsResponse.from_dict(get_account_holdings_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


