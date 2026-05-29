# AccountHistoryResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetAccountHistoryResponseData**](GetAccountHistoryResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.account_history_response import AccountHistoryResponse

# TODO update the JSON string below
json = "{}"
# create an instance of AccountHistoryResponse from a JSON string
account_history_response_instance = AccountHistoryResponse.from_json(json)
# print the JSON string representation of the object
print(AccountHistoryResponse.to_json())

# convert the object into a dict
account_history_response_dict = account_history_response_instance.to_dict()
# create an instance of AccountHistoryResponse from a dict
account_history_response_from_dict = AccountHistoryResponse.from_dict(account_history_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


