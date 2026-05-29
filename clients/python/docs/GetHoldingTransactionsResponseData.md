# GetHoldingTransactionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transactions** | [**List[HoldingTransactionRow]**](HoldingTransactionRow.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_holding_transactions_response_data import GetHoldingTransactionsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetHoldingTransactionsResponseData from a JSON string
get_holding_transactions_response_data_instance = GetHoldingTransactionsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetHoldingTransactionsResponseData.to_json())

# convert the object into a dict
get_holding_transactions_response_data_dict = get_holding_transactions_response_data_instance.to_dict()
# create an instance of GetHoldingTransactionsResponseData from a dict
get_holding_transactions_response_data_from_dict = GetHoldingTransactionsResponseData.from_dict(get_holding_transactions_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


