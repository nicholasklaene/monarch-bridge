# BalanceHistoryStatusResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetBalanceHistoryStatusResponseData**](GetBalanceHistoryStatusResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.balance_history_status_response import BalanceHistoryStatusResponse

# TODO update the JSON string below
json = "{}"
# create an instance of BalanceHistoryStatusResponse from a JSON string
balance_history_status_response_instance = BalanceHistoryStatusResponse.from_json(json)
# print the JSON string representation of the object
print(BalanceHistoryStatusResponse.to_json())

# convert the object into a dict
balance_history_status_response_dict = balance_history_status_response_instance.to_dict()
# create an instance of BalanceHistoryStatusResponse from a dict
balance_history_status_response_from_dict = BalanceHistoryStatusResponse.from_dict(balance_history_status_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


