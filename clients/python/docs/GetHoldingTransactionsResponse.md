# GetHoldingTransactionsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetHoldingTransactionsResponseData**](GetHoldingTransactionsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_holding_transactions_response import GetHoldingTransactionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetHoldingTransactionsResponse from a JSON string
get_holding_transactions_response_instance = GetHoldingTransactionsResponse.from_json(json)
# print the JSON string representation of the object
print(GetHoldingTransactionsResponse.to_json())

# convert the object into a dict
get_holding_transactions_response_dict = get_holding_transactions_response_instance.to_dict()
# create an instance of GetHoldingTransactionsResponse from a dict
get_holding_transactions_response_from_dict = GetHoldingTransactionsResponse.from_dict(get_holding_transactions_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


