# GetAccountHistoryResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account** | [**Account**](Account.md) |  | [optional] 
**recent_transactions** | [**List[Transaction]**](Transaction.md) |  | 
**snapshots** | [**List[AccountSnapshot]**](AccountSnapshot.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_account_history_response_data import GetAccountHistoryResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetAccountHistoryResponseData from a JSON string
get_account_history_response_data_instance = GetAccountHistoryResponseData.from_json(json)
# print the JSON string representation of the object
print(GetAccountHistoryResponseData.to_json())

# convert the object into a dict
get_account_history_response_data_dict = get_account_history_response_data_instance.to_dict()
# create an instance of GetAccountHistoryResponseData from a dict
get_account_history_response_data_from_dict = GetAccountHistoryResponseData.from_dict(get_account_history_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


