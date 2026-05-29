# GetBalanceHistoryStatusResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetBalanceHistoryStatusResponseData**](GetBalanceHistoryStatusResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_balance_history_status_response import GetBalanceHistoryStatusResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetBalanceHistoryStatusResponse from a JSON string
get_balance_history_status_response_instance = GetBalanceHistoryStatusResponse.from_json(json)
# print the JSON string representation of the object
print(GetBalanceHistoryStatusResponse.to_json())

# convert the object into a dict
get_balance_history_status_response_dict = get_balance_history_status_response_instance.to_dict()
# create an instance of GetBalanceHistoryStatusResponse from a dict
get_balance_history_status_response_from_dict = GetBalanceHistoryStatusResponse.from_dict(get_balance_history_status_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


