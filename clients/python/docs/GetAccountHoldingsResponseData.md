# GetAccountHoldingsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**holdings** | [**List[Holding]**](Holding.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_account_holdings_response_data import GetAccountHoldingsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetAccountHoldingsResponseData from a JSON string
get_account_holdings_response_data_instance = GetAccountHoldingsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetAccountHoldingsResponseData.to_json())

# convert the object into a dict
get_account_holdings_response_data_dict = get_account_holdings_response_data_instance.to_dict()
# create an instance of GetAccountHoldingsResponseData from a dict
get_account_holdings_response_data_from_dict = GetAccountHoldingsResponseData.from_dict(get_account_holdings_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


